package org.digitalpanda.springlab.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {
	
	private static final Logger LOGGER = 
	        LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
	    System.out.println("Welcome home!");
		//name of the View to use
		return "multiplexer";
	}
	
	@RequestMapping(value="/presentation", method = RequestMethod.GET )
	public String presentation() {
	    return "redirect:main";
	}
	
   @RequestMapping(value="/springlab", method = RequestMethod.GET )
    public String springlab() {
        return "redirect:main";
    }
   
   @RequestMapping(value="/login", method = RequestMethod.GET )
   public String login() {
       return "login";
   }

	
}
