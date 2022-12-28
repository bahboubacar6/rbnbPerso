package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class AppUserRestController {

    private GestationService gestationService;

    @GetMapping("/all")
    public List<AppUser> users(){
        return gestationService.listUsers();
    }
}
