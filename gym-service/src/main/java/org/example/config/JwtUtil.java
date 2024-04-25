package org.example.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private static String SECRET_KEY = "g7m-4ppl1c4t10n";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    // Crear un jwt para un usuario
    public String create(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis()+ TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORITHM);
    }
}
