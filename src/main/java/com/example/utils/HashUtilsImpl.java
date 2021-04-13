package com.example.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HashUtilsImpl implements HashUtils {

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Autowired
	Pbkdf2PasswordEncoder pbkdf2PasswordEncoder;

	@Autowired
	SCryptPasswordEncoder scryptPasswordEncoder;

	@Override
	public String generateBcrypt(String rawPassword) {
		return bcryptPasswordEncoder.encode(rawPassword);
	}

	@Override
	public String generateScrypt(String rawPassword) {
		return scryptPasswordEncoder.encode(rawPassword);
	}

	@Override
	public String generatePbkdf2(String rawPassword) {
		return pbkdf2PasswordEncoder.encode(rawPassword);
	}

	@Override
	public String generateSHA256(String rawPassword) {
		try {
			return toHexString(getSHA(rawPassword, "SHA-256"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String generateSHA384(String rawPassword) {
		try {
			return toHexString(getSHA(rawPassword, "SHA-384"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String generateSHA512(String rawPassword) {
		try {
			return toHexString(getSHA(rawPassword, "SHA-512"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] getSHA(String input, String sha) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(sha);
		return md.digest(input.getBytes(StandardCharsets.UTF_8));
	}

	public static String toHexString(byte[] hash) {
		BigInteger number = new BigInteger(1, hash);

		StringBuilder hexString = new StringBuilder(number.toString(16));

		while (hexString.length() < 32) {
			hexString.insert(0, '0');
		}

		return hexString.toString();
	}

}
