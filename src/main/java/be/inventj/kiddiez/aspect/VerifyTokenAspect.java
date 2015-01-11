package be.inventj.kiddiez.aspect;

import be.inventj.kiddiez.model.User;
import be.inventj.kiddiez.service.JsonWebTokenService;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class VerifyTokenAspect {

    private static final Logger logger = LoggerFactory.getLogger(VerifyTokenAspect.class);

    @Autowired
    private JsonWebTokenService tokenService;

    @Before("execution(* be.inventj.kiddiez.controllers.RegistrationController.*(..)) && args(request)")
    public void verifyToken(JoinPoint joinPoint, HttpServletRequest request) {
        logger.debug("Verify token");
        tokenService.verifyToken(request);

    }

    @Before("execution(* be.inventj.kiddiez.controllers.LoginController.*(..))")
    public void doLogin(JoinPoint joinPoint) {
        logger.debug("doLogin()");


    }
}
