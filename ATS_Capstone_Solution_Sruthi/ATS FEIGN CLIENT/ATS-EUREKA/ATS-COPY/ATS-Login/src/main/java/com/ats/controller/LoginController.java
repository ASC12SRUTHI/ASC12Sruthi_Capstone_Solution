package com.ats.controller;
import com.ats.exception.UserNotFoundException;
import com.ats.model.BookingModel;
import com.ats.model.LoginModel;
import com.ats.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public List<LoginModel> getAllLoginDetails(){
        return loginService.getAllLogin();
    }

    @GetMapping("/login/{id}")
    public LoginModel getLogin(@PathVariable Long id) {
        try {
            return loginService.getLoginById(id);
        } catch (UserNotFoundException userNotFoundException) {
            return null;
        }
    }
    @PostMapping("/login")
    public List<BookingModel> login(@RequestBody LoginModel loginRequest) {
        return loginService.login(loginRequest);
    }
}


