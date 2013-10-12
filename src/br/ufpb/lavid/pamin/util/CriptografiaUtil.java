
package br.ufpb.lavid.pamin.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;


public class CriptografiaUtil implements java.io.Serializable{

	public String criptografarSenha(String senha){
		
		String senhaCriptografada = null;
		  
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            BASE64Encoder encoder = new BASE64Encoder ();
            
            senhaCriptografada =  encoder.encode(digest.digest());   //aqui ? onde retorna a String    
            
        }catch(Exception e){
            e.printStackTrace();
        }//catch
        
		return senhaCriptografada;
	}

		
		
}
