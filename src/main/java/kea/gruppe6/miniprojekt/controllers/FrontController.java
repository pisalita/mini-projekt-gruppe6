package kea.gruppe6.miniprojekt.controllers;

import kea.gruppe6.miniprojekt.data.UserImpl;
import kea.gruppe6.miniprojekt.domain.LoginControl;
import kea.gruppe6.miniprojekt.domain.LoginWishLinkException;
import kea.gruppe6.miniprojekt.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.context.request.WebRequest;


@Controller
public class FrontController {
    LoginControl loginControl = new LoginControl(new UserImpl());
    User user;

    @GetMapping(value ="/login")
    public String login(){
        return "login.html";
    }

    @PostMapping(value ="/login-validation")
    public String loginUser(WebRequest request) throws LoginWishLinkException{
        String email = request.getParameter("email");
        String pwd =  request.getParameter("pwd");

        user =  loginControl.login(email,pwd);

        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        request.setAttribute("username", user.getUsername(), WebRequest.SCOPE_SESSION);

        System.out.println(user.getUsername() + user.getEmail() + user.getPwd());

        return "redirect:/welcome";
    }

    @GetMapping(value ="/welcome")
    public String welcome(WebRequest request){

        request.getAttribute("username", WebRequest.SCOPE_SESSION);
        return "welcome.html";
    }

    @GetMapping(value ="/createWishList")
    public String createWishList(WebRequest request){

        request.getAttribute("username", WebRequest.SCOPE_SESSION);
        return "wishlist.html";
    }
}
