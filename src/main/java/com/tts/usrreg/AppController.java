package com.tts.usrreg;

import java.util.List;

//import org.hibernate.mapping.List;
//import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import antlr.collections.List;
import org.springframework.stereotype.Controller;

//import antlr.collections.List;


@Controller
public class AppController {
	//@Autowired
	//private UserRepository repo;
	
	@Autowired
    private UserRepository userRepo;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "signup_form";
    }
    
    @PostMapping("/process_register")
    public String processRegistration(User user, CrudRepository<User, Long> userRepo) {
        
        //repo.save(user);
    	 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	    String encodedPassword = passwordEncoder.encode(user.getPassword());
    	    user.setPassword(encodedPassword);
    	     
    	    userRepo.save(user);
         
        return "register_success";
    }
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
         
        return "users";
    }
        
}
