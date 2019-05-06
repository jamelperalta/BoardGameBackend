package DomainLayer;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class Authentication {
	
	// Key for the JWT and for password encryption
	public static final String secretKey = "projectTesting_jameljorge";
	public static final String ISSUER = "jameljorge"; 
	
	// Getting the secret key spec for password encryption or decryption.
	public static SecretKeySpec getSecretKeySpec() {
		
		// The salt (probably) can be stored along with the encrypted data
        byte[] salt = new String("12345678").getBytes();

        // Decreasing this speeds down startup time and can be useful during testing,
        // but it also makes it easier for brute force attackers
        int iterationCount = 40000;
        
        // Other values give me java.security.InvalidKeyException:
        // Illegal key size or default parameters
        int keyLength = 128;
        
        SecretKeySpec key = null;
        try {
			key = createSecretKey(secretKey.toCharArray(), salt, iterationCount, keyLength);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		};
		
		return key;
        
	}
	
	// For creating the secret key, an algorithm from java
	private static SecretKeySpec createSecretKey(char[] password, byte[] salt,
			int iterationCount, int keyLength) 
					throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        SecretKey keyTmp = keyFactory.generateSecret(keySpec);
        return new SecretKeySpec(keyTmp.getEncoded(), "AES");
    }
	
}
