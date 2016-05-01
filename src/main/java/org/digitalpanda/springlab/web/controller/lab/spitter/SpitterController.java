package org.digitalpanda.springlab.web.controller.lab.spitter;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;
import javax.validation.Valid;

import org.digitalpanda.springlab.data.SpitterRepository;
import org.digitalpanda.springlab.spittr.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/springlab/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;
    
    public SpitterController(){}
    
    @Autowired
    public SpitterController(
            SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }
   
    
    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        //return "springlab/registerForm";
        return "registerForm";
    }

    @RequestMapping(value="/register", method=POST)
    public String processRegistration(
            @RequestPart("profilePicture") MultipartFile profilePicture,
            @Valid Spitter spitter,
            RedirectAttributes model,
            Errors errors) {        
        if (errors.hasErrors()) {
            //return "springlab/registerForm";
            return "registerForm";
        }
        spitterRepository.save(spitter);
        try {
            profilePicture.transferTo(
                    new File("/tmp/spittr/uploads/" 
                            + profilePicture.getOriginalFilename()));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //pass parameters into the url or as url parameter
        model.addAttribute("username",spitter.getUsername());
        model.addAttribute("spitterId", spitter.getId());
        //Store the spitter object into the session for the next request to gather it.
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/springlab/spitter/{username}";
        //return "redirect:/springlab/spitter/" + spitter.getUsername();
    }
    
    @RequestMapping(value="/{username}", method=GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        //the model may already contain the spitter if it was stored into 
        // the session as a flash attribute. Otherwise, fetch it from the "DB"
        if (!model.containsAttribute("spitter")) {
            Spitter spitter = spitterRepository.findByUsername(username);
            model.addAttribute(spitter);
            //return "springlab/profile";                
        }
        return "profile";
    }
}