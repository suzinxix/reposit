package com.ja.jademo.controller;

import com.ja.jademo.model.Vehicle;
import com.ja.jademo.repository.VehicleRepository;
import com.ja.jademo.validator.VehicleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleValidator vehicleValidator;

    @GetMapping("/vehicle_list")
    public String list(Model model) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        model.addAttribute("vehicles", vehicles);
        return "vehicle/vehicle_list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("vehicle", new Vehicle());
        }else{
            Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
            model.addAttribute("vehicle", vehicle);
        }
        return "vehicle/form";
    }
    @PostMapping("/form")
    public String greetingSubmit(@ModelAttribute Vehicle vehicle, BindingResult bindingResult) {
        vehicleValidator.validate(vehicle,bindingResult);
        if(bindingResult.hasErrors()){
            return "vehicle/form";
        }
        vehicleRepository.save(vehicle);
        return "redirect:/vehicle/vehicle_list";
    }
}
