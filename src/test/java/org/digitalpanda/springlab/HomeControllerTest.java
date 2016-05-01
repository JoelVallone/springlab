package org.digitalpanda.springlab;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.digitalpanda.springlab.data.ISpittleRepository;
import org.digitalpanda.springlab.data.SpitterRepository;
import org.digitalpanda.springlab.data.SpittleRepository;
import org.digitalpanda.springlab.spittr.Spitter;
import org.digitalpanda.springlab.spittr.Spittle;
import org.digitalpanda.springlab.web.controller.HomeController;
import org.digitalpanda.springlab.web.controller.lab.spitter.SpitterController;
import org.digitalpanda.springlab.web.controller.lab.spitter.SpittleController;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import static org.hamcrest.Matchers.*;

@WebAppConfiguration
public class HomeControllerTest {
    
    //@Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }
    
    //@Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        
        ISpittleRepository mockRepository =
                Mockito.mock(ISpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
            .thenReturn(expectedSpittles);
        
        
        SpittleController controller =
                new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        
        mockMvc.perform(get("/spittles"))
            .andExpect(view().name("spittles"))
            .andExpect(model().attributeExists("spittleList"))
            .andExpect(model().attribute("spittleList",
                    hasItems(expectedSpittles.toArray())));
    }
    
    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
    
    
    //@Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(238900, 50))
        .thenReturn(expectedSpittles);
        
        SpittleController controller =
                new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        
        mockMvc.perform(get("/spittles?max=238900&count=50"))
        .andExpect(view().name("spittles"))
        .andExpect(model().attributeExists("spittleList"))
        .andExpect(model().attribute("spittleList",
                hasItems(expectedSpittles.toArray())));
    }
    
    //@Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        
        Mockito.when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(get("/spittles/12345"))
            .andExpect(view().name("spittle"))
            .andExpect(model().attributeExists("spittle"))
            .andExpect(model().attribute("spittle", expectedSpittle));
    }
    
    //@Test
    public void shouldShowRegistration() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        mockMvc.perform(get("/spitter/register"))
        .andExpect(view().name("registerForm"));
    }
    
    
    //@Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository =
                Mockito.mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved =
                new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        Mockito.when(mockRepository.save(unsaved)).thenReturn(1L);
        SpitterController controller =
                new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours"))
        .andExpect(redirectedUrl("/spitter/jbauer"));
        Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);
    }
}