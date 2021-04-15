package kea.gruppe6.miniprojekt.controllers;

import kea.gruppe6.miniprojekt.data.UserImpl;
import kea.gruppe6.miniprojekt.data.WishMapper;
import kea.gruppe6.miniprojekt.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class FrontController {
    LoginControl loginControl = new LoginControl(new UserImpl());
    WishMapper wishMapper = new WishMapper();

    WishList wishList = new WishList();
    WishList readList;
    User user;
    Wish wish;


    @GetMapping(value = "/")
    public String index(Model model){
        passLoginStatusToModel(model, user);
        return "index.html";
    }

    @GetMapping(value ="/login")
    public String login(Model model){
        passLoginStatusToModel(model, user);
        return "login.html";
    }

    @PostMapping(value ="/login-validation")
    public String loginUser(WebRequest request) throws LoginWishLinkException{
        String email = request.getParameter("email");
        String pwd =  request.getParameter("pwd");

        user =  loginControl.login(email,pwd);
        user.setLoggedIn(true);

        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        request.setAttribute("username", user.getUsername(), WebRequest.SCOPE_SESSION);

        return "redirect:/welcome";
    }

    @GetMapping(value ="/create-user")
    public String createUser(Model model){
        passLoginStatusToModel(model, user);
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
            user.setLoggedIn(true);
            return "redirect:/";
        }else{
            throw new LoginWishLinkException("Password dont match");
        }
    }

    @GetMapping(value ="/welcome")
    public String welcome(WebRequest request, Model model){
        passLoginStatusToModel(model, user);
        request.getAttribute("username", WebRequest.SCOPE_SESSION);
        return "welcome.html";
    }

    @GetMapping(value ="/createWishList")
    public String createWishList(WebRequest request, Model model){
        passLoginStatusToModel(model, user);

        model.addAttribute("shared", wishList.isShared());
        model.addAttribute("email", user.getEmail());

        wishList = wishMapper.readWish(user.getEmail());

        model.addAttribute("wishlist",wishList.getList());
        model.addAttribute("username",user.getUsername());

        return "wishlist.html";
    }

    @GetMapping(value = "/shared-validation")
    public String sharedValidation(){
        wishList.setShared(true);
        return "redirect:/createWishList";
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
    public String viewWishlist(@RequestParam("email") String email, Model model){
        passLoginStatusToModel(model, user);
        readList = wishMapper.readWish(email);

        model.addAttribute("wishlist",readList.getList());
        model.addAttribute("email", readList.getList().get(0).getEmail());

        return "view-wishlist.html";
    }

    @PostMapping(value ="/reserve-wish-validation")
    public String reserveWishValidation(@RequestParam("id") int id){
        System.out.println(id);
        System.out.println(readList.getList().get(0).getEmail());

        wishMapper.reserveWish(id);

        return "redirect:/view-wishlist?email=" + readList.getList().get(0).getEmail();
    }

    @GetMapping(value = "/logout-validation")
    public String logoutValidation(){
        if(user.isLoggedIn() == true){
            user.setLoggedIn(false);
            user = null;
        }
        return "redirect:/";
    }


    public void passLoginStatusToModel(Model model, User user){
        model.addAttribute("isLoggedIn", false);
        if(user != null){
            model.addAttribute("isLoggedIn", user.isLoggedIn());
        }
    }
}
