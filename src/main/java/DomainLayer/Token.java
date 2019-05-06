package DomainLayer;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

/**
 * Token Class:
 * A class for storing an authentication token.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class Token {

	// Instance Variables
	private String token;
	
	// Constructor
	public Token(String token) {
		this.setToken(token);
	}

	// Get and Set
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	// Static Methods
	
	/**
	 * For creating a user token.
	 * @return
	 */
	public static Token createToken(String username) {
		
		Algorithm algorithmHMAC = Algorithm.HMAC256(Authentication.secretKey);
		String token = JWT.create()
				.withIssuer(Authentication.ISSUER)
				.withSubject(username)
				.sign(algorithmHMAC);
		
		return new Token(token);
	}
	
	/**
	 * For verifying if a token is correct or not.
	 * @param token
	 * @return
	 */
	public static boolean verifyToken(String token) {
		try {

			Algorithm algorithmHMAC = Algorithm.HMAC256(Authentication.secretKey);
			JWTVerifier verifier = JWT.require(algorithmHMAC)
					.withIssuer(Authentication.ISSUER)
					.build(); //Reusable verifier instance
			DecodedJWT jwt = verifier.verify(token);
			
			return true;

		} catch (JWTVerificationException exception){
			//Invalid
			return false;
		}
	}

	@Override
	public String toString() {
		return "Token [token=" + token + "]";
	}
	
	
	

}
