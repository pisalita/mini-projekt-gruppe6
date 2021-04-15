package kea.gruppe6.miniprojekt.controllers;

import kea.gruppe6.miniprojekt.data.UserImpl;
import kea.gruppe6.miniprojekt.data.WishMapper;
import kea.gruppe6.miniprojekt.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;


@Controller
public class FrontController {
    LoginControl loginControl = new LoginControl(new UserImpl());
    WishMapper wishMapper = new WishMapper();

    WishList wishList = new WishList();
    User user;
    Wish wish;

    @GetMapping(value = "/")
    public String index(){
        return "index.html";
    }

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

        return "redirect:/welcome";
    }

    @GetMapping(value ="/create-user")
    public String createUser(){
        return "create-user.html";
    }

    @PostMapping(value = "/create-user-validation")
    public String createUserValidation(WebRequest request) throws LoginWishLinkException{
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        String pwd2 = request.getParameter("password2");

        if(pwd.equals(pwd2)){
            user = loginControl.createUser(email,username,pwd);
            return "redirect:/";
        }else{
            throw new LoginWishLinkException("Password dont match");
        }
    }

    @GetMapping(value ="/welcome")
    public String welcome(WebRequest request){

        request.getAttribute("username", WebRequest.SCOPE_SESSION);
        return "welcome.html";
    }

    @GetMapping(value ="/createWishList")
    public String createWishList(WebRequest request){


        request.getAttribute("wishlist", WebRequest.SCOPE_SESSION);
        request.getAttribute("username", WebRequest.SCOPE_SESSION);
        return "wishlist.html";
    }

    @PostMapping(value = "/wishlist-validation")
    public String wishlistValidation(WebRequest request){
        String title = request.getParameter("title");
        String cmnt = request.getParameter("cmnt");
        String link = request.getParameter("link");
        String email = user.getEmail();

        System.out.println(email);
        if(email == null){
            email = "";
        }

        wish = new Wish(title,link,cmnt,false,email);

        wishList.addWish(wish);

        request.setAttribute("wishlist", wishList.getList(), WebRequest.SCOPE_SESSION);
        wishMapper.createWish(wish);
        return "redirect:/createWishList";
    }

    @GetMapping("/view-wishlist")
    public String viewWishlist(@RequestParam("email") String email, WebRequest request){

        WishList readList = wishMapper.readWish(email);
        request.setAttribute("wishlist", readList.getList(), WebRequest.SCOPE_SESSION);

        boolean reserved = request.getParameter("reserved");

        return "view-wishlist.html";
    }

}
