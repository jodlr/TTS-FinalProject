package com.tts.usrreg;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DBPassGen {
 public static void main(String[] args ) {	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	String txtPassword = "password123";
    String GeneratedPwd =encoder.encode(txtPassword);
    
    System.out.println(GeneratedPwd);
 }  
}
