package com.security.springsecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SampleApplication {
	
	public static void main(String [] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("Kiran");
		System.out.println(result);
	}

}
