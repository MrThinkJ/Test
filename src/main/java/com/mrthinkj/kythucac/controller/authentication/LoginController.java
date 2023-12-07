package com.mrthinkj.kythucac.controller.authentication;

import com.mrthinkj.kythucac.model.user.Account;
import com.mrthinkj.kythucac.modelDTO.user.LoginForm;
import com.mrthinkj.kythucac.service.user.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String login() {
        return "page/login";
    }

    @PostMapping("/login")
    public String authLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login/{status}")
    public @ResponseBody String failedLogin(@PathVariable String status){
        if (status.equals("failed"))
            return "failed";
        return "success";
    }

    @GetMapping("/not-active")
    public @ResponseBody String notActiveLogin(){
        return "not-active";
    }
}
