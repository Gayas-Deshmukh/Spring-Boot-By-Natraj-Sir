package com.nt.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder 
{
	public static void main(String[] args)
	{
		BCryptPasswordEncoder encoder	=	new BCryptPasswordEncoder();
		
		System.out.println(encoder.encode("amol123"));
	}
}
