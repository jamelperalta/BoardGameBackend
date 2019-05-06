package InfrastructureLayer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import DomainLayer.Authentication;

/**
 * Password Class:
 * is for encrypting and decreypting passwords
 * using AES.
 * @author jamelperaltacoss, jorgecruz
 *
 */
public class Password {
	
	/**
	 * This methods return true if the password is correct
	 * return false if the password is incorrect.
	 * @param correctPassword
	 * @param attemptPassword
	 * @return
	 */
	public static boolean checkPassword(String correctPassword, String attemptPassword) {

		try {
			String cpass = Password.decrypt(correctPassword, Authentication.getSecretKeySpec());
			
			if (attemptPassword.equals(cpass))
				return true;

		} catch (GeneralSecurityException | IOException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	/**
	 * For encryption
	 * @param property
	 * @param key
	 * @return
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public static String encrypt(String password, SecretKeySpec key) throws GeneralSecurityException, UnsupportedEncodingException {
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key);
        AlgorithmParameters parameters = pbeCipher.getParameters();
        IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
        byte[] cryptoText = pbeCipher.doFinal(password.getBytes("UTF-8"));
        byte[] iv = ivParameterSpec.getIV();
        return base64Encode(iv) + ":" + base64Encode(cryptoText);
    }

    public static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * For decryption
     * @param string
     * @param key
     * @return
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public static String decrypt(String password, SecretKeySpec key) throws GeneralSecurityException, IOException {
        String iv = password.split(":")[0];
        String property = password.split(":")[1];
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(base64Decode(iv)));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }

    public static byte[] base64Decode(String property) throws IOException {
        return Base64.getDecoder().decode(property);
    }
    
}
