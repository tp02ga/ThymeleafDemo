package com.coderscampus.thymeleafdemo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController
{
  @RequestMapping("/")
  public String welcome (ModelMap model)
  {
    model.put("message", "This message comes to you from our Welcome Controller");
    
    List<String> cars = new ArrayList<>();
    
    cars.add("Toyota");
    cars.add("Honda");
    cars.add("Tesla");
    cars.add("Ford");
    cars.add("GM");
    
    model.put("cars", cars);
    
    return "welcome";
  }
}
