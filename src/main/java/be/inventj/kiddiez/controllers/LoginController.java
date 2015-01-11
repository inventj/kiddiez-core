package be.inventj.kiddiez.controllers;

import be.inventj.kiddiez.model.User;
import be.inventj.kiddiez.service.JsonWebTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * This is to be refactored into an authentication service
 */
@RestController
public class LoginController {

    @Autowired
    private JsonWebTokenService tokenService;

    @RequestMapping(method= RequestMethod.POST, value="login")
    public User login(@RequestBody User user, HttpServletRequest request) {

        // 1. Retrieve a token
        String token = tokenService.getToken(user);

        user.setToken(token);

        // 2. Check database if username and password is correct
        if(user.getUserName().equals("villavrolijk")){
            return getVillaVrolijk(user);
        } else if (user.getUserName().equals("joeri")){
            return getJoeri(user);
        }

        return null;
    }


    private User getVillaVrolijk(User user){
        user.setEmail("villavrolijk@mail.be");
        user.setLastLogin(new Date());
        return user;
    }

    private User getJoeri(User user){
        user.setEmail("joeri@mail.be");
        user.setLastLogin(new Date());
        return user;
    }
}
