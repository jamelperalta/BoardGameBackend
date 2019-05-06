package ManualTest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTencryptTest {
	
	public static void main(String[] args) {
		
		String secretKey = "secretkey";
		
		Algorithm algorithmHMAC = Algorithm.HMAC256(secretKey);
		String token = JWT.create()
				.withIssuer("auth0")
				.withSubject("jamelperalta")
				.sign(algorithmHMAC);
		
		System.out.println(token);
		
	}
}
