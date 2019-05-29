package com.gokhaneskin.petclinic.web;

import com.gokhaneskin.petclinic.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetClinicController {

    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping(value = {"/","/index.html"})
    public  ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/owners")
    public ModelAndView getOwners(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("owners",petClinicService.findOwners());
        modelAndView.setViewName("owners");
        return modelAndView;
    }

    @RequestMapping("/pcs")
    @ResponseBody
    public String welcome(){
        return "Welcome to PetClinic World!";
    }

    @RequestMapping("/login.html")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
