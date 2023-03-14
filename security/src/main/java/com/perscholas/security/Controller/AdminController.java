package com.perscholas.security.Controller;

import com.perscholas.security.User;
import com.perscholas.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/home")
    public String adminHome(Model model, Principal principal){
        String email= principal.getName();
        User user= userRepository.getUserByUserName(email);
        model.addAttribute("user",user);

        return "/admin/admin_home";
    }



}