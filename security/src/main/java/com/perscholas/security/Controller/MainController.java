package com.perscholas.security.Controller;

import com.perscholas.security.Role;
import com.perscholas.security.User;
import com.perscholas.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }
    @GetMapping("/admin/login")
    public String adminLogin(){
        return "/admin/admin_login";
    }
    @GetMapping("/user/login")
    public String userLogin(){
        return "/user/user_login";
    }



    @GetMapping("/user/home")
    public String userHome(Model model, Principal principal){
       String email= principal.getName();
      User user= userRepository.getUserByUserName(email);
        model.addAttribute("user",user);
        return "/user/user_home";
    }
    @RequestMapping("/signup")
    public String signUp(Model model)
    {
        model.addAttribute("title","Signup ");
        model.addAttribute("user",new User());

        return "signup";
    }






}
