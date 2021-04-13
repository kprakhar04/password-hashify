package com.example.utils;

public interface HashUtils {

	public String generateBcrypt(String rawPassword);

	public String generateScrypt(String rawPassword);

	public String generatePbkdf2(String rawPassword);

	public String generateSHA256(String rawPassword);

	public String generateSHA384(String rawPassword);

	public String generateSHA512(String rawPassword);
}
