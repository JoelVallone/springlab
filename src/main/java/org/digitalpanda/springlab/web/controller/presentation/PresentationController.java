package org.digitalpanda.springlab.web.controller.presentation;

import static org.springframework.web.bind.annotation.RequestMethod.*;


import org.digitalpanda.springlab.data.PresentationRepository;
import org.digitalpanda.springlab.spittr.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/presentation")
public class PresentationController {
    private PresentationRepository myRepo;
    
    public PresentationController(){}
    
    @Autowired
    public PresentationController(
            PresentationRepository myRepo) {
        this.myRepo = myRepo;
    }
   
    
    @RequestMapping(value="main", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        //return "presentation/main";
        return "presentation-main";
    }

}