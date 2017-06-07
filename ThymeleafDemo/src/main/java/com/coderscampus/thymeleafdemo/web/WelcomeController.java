package com.coderscampus.thymeleafdemo.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderscampus.thymeleafdemo.domain.Car;
import com.coderscampus.thymeleafdemo.domain.Model;

@Controller
public class WelcomeController
{
  List<String> carBrands = new ArrayList<>();
  List<Car> cars = new ArrayList<>();
  
  public WelcomeController () {
    carBrands.add("Toyota");
    carBrands.add("Honda");
    carBrands.add("Tesla");
    carBrands.add("Ford");
    carBrands.add("GM");
  }
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String welcome (ModelMap model, @RequestParam(required=false) String carBrand)
  {
    Optional<Car> carOpt = cars.stream().filter(car -> car.getBrand().equals(carBrand)).findFirst();
    if (carOpt.isPresent())
    {
      Car car = carOpt.get();
      populateModel(model, car);
    }
    else
    {
      populateModel(model, null);
    }
    
    return "welcome";
  }

  private void populateModel(ModelMap model, Car car)
  {
    model.put("message", "This message comes to you from our Welcome Controller");
    model.put("carBrands", carBrands);
    model.put("today", new Date());
    model.put("money", 1654522.53);
    
    if (car == null)
      car = new Car();

    if (car.getModels().isEmpty())
    {
      Model carModel = new Model();
      List<Model> carModels = new ArrayList<>();
      carModels.add(carModel);
      car.setModels(carModels);
    }
    
    model.put("car", car);
    model.put("cars", cars);
  }
  
  @RequestMapping(value="/", method=RequestMethod.POST)
  public String welcomePost (@ModelAttribute Car car, ModelMap model)
  {
    if (cars.contains(car))
    {
      cars.get(cars.indexOf(car)).getModels().add(car.getModels().get(0));
    }
    else
    {
      cars.add(car);
    }
    populateModel(model, null);
    return "welcome";
  }
  
  @RequestMapping(value="/del/{carBrand}", method=RequestMethod.GET)
  public String deleteCarBrand (@PathVariable String carBrand, ModelMap model)
  {
    List<Car> carBrands = cars.stream().filter(car -> car.getBrand().equals(carBrand)).collect(Collectors.toList());
    cars.removeAll(carBrands);
    return "redirect:/";
  }
}
