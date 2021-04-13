package kea.gruppe6.miniprojekt.controllers;

import kea.gruppe6.miniprojekt.data.DBManager;
import kea.gruppe6.miniprojekt.data.UserImpl;
import kea.gruppe6.miniprojekt.domain.LoginControl;
import kea.gruppe6.miniprojekt.domain.LoginWishLinkException;
import kea.gruppe6.miniprojekt.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class FrontController {
    LoginControl loginControl = new LoginControl(new UserImpl());

    @GetMapping(value ="/login")
    public String login(){
        return "login.html";
    }

    @PostMapping(value ="/login-validation")
    public String loginUser(WebRequest request) throws LoginWishLinkException{
        String email = request.getParameter("email");
        String pwd =  request.getParameter("pwd");

        User user =  loginControl.login(email,pwd);

        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        request.setAttribute("username", user.getUsername(), WebRequest.SCOPE_SESSION);

        System.out.println(user);

        return "redirect:/welcome";
    }

    @GetMapping(value ="/welcome")
    @ResponseBody
    public String welcome(){
        return "Welcome!";
    }

}
