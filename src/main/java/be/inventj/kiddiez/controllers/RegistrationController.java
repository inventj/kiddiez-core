package be.inventj.kiddiez.controllers;

import be.inventj.kiddiez.model.Kid;
import be.inventj.kiddiez.model.Registration;
import be.inventj.kiddiez.model.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @RequestMapping(method= RequestMethod.GET, value="overview")
    public List<Registration> overview(HttpServletRequest request) {

        logger.debug("overview()");
        List<Registration> res = new ArrayList<>();
        res.add(sam());
        res.add(ries());

        return res;
    }

    private Registration sam(){

        Registration r = new Registration();
        r.setIn(new Date());
        Kid kid = null;

            kid = new Kid("Sam", "Peeters",
                    new Date());

        r.setKid(kid);

        return r;
    }

    private Registration ries(){

        Registration r = new Registration();
        r.setIn(new Date());
        Kid kid = null;

        kid = new Kid("Ries", "Peeters", null);


        r.setKid(kid);

        return r;
    }
}
