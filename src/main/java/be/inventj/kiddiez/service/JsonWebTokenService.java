package be.inventj.kiddiez.service;


import be.inventj.kiddiez.model.User;
import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

@Service
public class JsonWebTokenService {

    private static final Logger logger = LoggerFactory.getLogger(JsonWebTokenService.class);

    private static final String SECRET = "azerty";

    public String getToken(User user){
        JWTSigner.Options options = new JWTSigner.Options();
        options.setAlgorithm(Algorithm.HS256);
        //options.setExpirySeconds();
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUserName());
        claims.put("aud", "kiddiezweb");
        return new JWTSigner(SECRET).sign(claims, options);
    }

    public void verifyToken(String token) throws Exception {

        try {
            Map<String,Object> decodedPayload =
                    new JWTVerifier(SECRET, "kiddiezweb").verify(token);

        } catch (Exception e) {
            throw new Exception("Failed to verify token");
        }

    }

    public void verifyToken(HttpServletRequest request) {
        logger.debug("verifyToken()");
        final String token = request.getHeader("Authorization");
        if (token != null) {
            // user is logged in with a token
            logger.debug("token " + token + " has been verified and is OK");
        } else {
            logger.error("no token found");
        }
        // no token !!! invalid request
    }
}
