package Employees;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PWHash {
	
	public String encry(byte[] salt ,  String new_pw) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		KeySpec spec = new PBEKeySpec(new_pw.toCharArray(), salt, 65536, 128);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = factory.generateSecret(spec).getEncoded();
				
		return Arrays.toString(hash).replace(",","").replace("[","").replace("]","").replace(" ","");
	}

	public boolean check_pw(byte[] salt  , String input_pw, String stored_pw_hashed) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		KeySpec input1 = new PBEKeySpec(input_pw.toCharArray(), salt, 65536, 128);
		SecretKeyFactory factory2 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash2 = factory2.generateSecret(input1).getEncoded();
		String hash_str2 = Arrays.toString(hash2).replace(",","").replace("[","").replace("]","").replace(" ","");
		
		if (hash_str2.equals(stored_pw_hashed)) {
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
	
}


