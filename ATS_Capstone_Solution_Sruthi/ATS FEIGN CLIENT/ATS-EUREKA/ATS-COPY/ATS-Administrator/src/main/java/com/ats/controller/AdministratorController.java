package com.ats.controller;


import com.ats.exception.UserNotFoundException;
import com.ats.model.AdministratorModel;
import com.ats.repository.AdministratorRepository;
import com.ats.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AdministratorController {
    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorRepository administratorRepository, AdministratorService administratorService){
        this.administratorService = administratorService;
    }
    @PostMapping("/newUser")
    public String newAdministrator(@RequestBody AdministratorModel administratorRequest) {
        return administratorService.newAdministrator(administratorRequest);
    }
    @GetMapping("/allUsers")
    public List<AdministratorModel> getAllAdministrators(){
        return administratorService.getAllAdministrator();
    }

    @GetMapping("/users/{id}")
    public AdministratorModel getAdministratorById(@PathVariable Long id){
        try{
            return administratorService.getAdministratorById(id);
        }catch (UserNotFoundException userNotFoundException){
            return null;
        }
    }
}


