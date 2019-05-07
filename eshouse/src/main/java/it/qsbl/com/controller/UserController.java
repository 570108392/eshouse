package it.qsbl.com.controller;

import it.qsbl.com.domain.User;
import it.qsbl.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Secured({"ROLE_ADMIN"})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("findUserByUserID")
    public User findUserByUserID(){
        return userService.findUseByUserID(1);
    }

}
