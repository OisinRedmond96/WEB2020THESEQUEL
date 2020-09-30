package com.localfoodnetwork.localfoodnetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService service;
    private PasswordEncrypter encrypter;

    @RequestMapping("/signup")
    public String showSignupPage(Model model){
        System.out.println("Sign in page entered"); // Debug
        User user = new User();
        user.setRole("ROLE_USER");
        user.setEnabled(1);
        model.addAttribute("user", user);
        System.out.println("New user:" + user.getUsername()); // Debug
        return "signup";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")User user) {
        user.setPassword(encrypter.encode(user.getPassword()));
        System.out.println("New user:" + user.getUsername()); // Debug
        System.out.println("New user password: " + user.getPassword()); // Debug
        service.save(user);
        return "redirect:/";
    }



    
}
