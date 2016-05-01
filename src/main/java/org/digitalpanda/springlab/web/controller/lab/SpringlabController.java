package org.digitalpanda.springlab.web.controller.lab;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.digitalpanda.springlab.spittr.Spitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springlab")
public class SpringlabController {
    
    public SpringlabController(){}
    
    @RequestMapping(value="main", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "springlab-main";
    }

}