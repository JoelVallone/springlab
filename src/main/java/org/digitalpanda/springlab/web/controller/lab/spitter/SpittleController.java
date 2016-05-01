package org.digitalpanda.springlab.web.controller.lab.spitter;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.digitalpanda.springlab.data.ISpittleRepository;
import org.digitalpanda.springlab.spittr.DuplicateSpittleException;
import org.digitalpanda.springlab.spittr.Spitter;
import org.digitalpanda.springlab.spittr.Spittle;
import org.digitalpanda.springlab.spittr.SpittleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/springlab/spittles")
public class SpittleController {
    private ISpittleRepository spittleRepository;   
    /*private static final String MAX_LONG_AS_STRING =
            Long.toString(Long.MAX_VALUE);*/
    
    @Autowired
    public SpittleController (ISpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }
    
    /*
    @RequestMapping(method=RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(
                spittleRepository.findSpittles(
                        Long.MAX_VALUE, 5));
        return "spittles";
    }*/
    
    @RequestMapping(method=RequestMethod.GET)
    public String spittles(Model model,
            @RequestParam(value="max", defaultValue="999999999" ) long max,
            @RequestParam(value="count", defaultValue="20") int count) {

        model.addAttribute( spittleRepository.findSpittles(max, count));
        //return "springlab/spittles";
        return "spittles";
    }
    
    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) 
                    throws SpittleNotFoundException {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException(
                    "Spittle " + spittleId + "not found in registry");
        }
        model.addAttribute(spittle);
        //return "springlab/spittle";
        return "spittle";        
    }
    
    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spittle());
        //return "springlab/registerForm";
        return "spittleForm";
    }

    @RequestMapping(value="/register", method=POST)
    public String saveSpittle(@Valid Spittle newSpittle,
            Errors errors) {;
        if (errors.hasErrors()) {
            //return "springlab/registerForm";
            return "spittleForm";
        }

        Long spittleId = spittleRepository.save(newSpittle);
        return "redirect:/springlab/spittles/" + spittleId;
    }
}
