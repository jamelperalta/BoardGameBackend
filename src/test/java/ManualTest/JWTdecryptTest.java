package ManualTest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JWTdecryptTest {
	
	public static void main(String[] args) {
		String secretKey = "secretkey";
		String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYW1lbHBlcmFsdGEiLCJpc3MiOiJhdXRoMCJ9.zi9aKBdfcYt0nyP_oI_NNv6H3yTC0jgtRRXpQ3xHWng";
		
		Algorithm algorithmHMAC = Algorithm.HMAC256(secretKey);
		JWTVerifier verifier = JWT.require(algorithmHMAC)
				.withIssuer("auth0")
				.build(); //Reusable verifier instance
		
		DecodedJWT jwt = verifier.verify(token);
		
		
	}
	
}
