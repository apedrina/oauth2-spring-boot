package com.alissonpedrina.config;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class GenerateBCrypt {

	public static void main(String[] args) {

		System.out.println(BCrypt.hashpw("111", BCrypt.gensalt()));
	}

}
