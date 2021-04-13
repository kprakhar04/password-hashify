package com.example.beans;

public class Password {
	private String plainText;
	private String hashedPassword;

	public Password() {
		super();
	}

	public Password(String plainText, String hashedPassword) {
		super();
		this.plainText = plainText;
		this.hashedPassword = hashedPassword;
	}

	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	@Override
	public String toString() {
		return "Password [plainText=" + plainText + ", hashedPassword=" + hashedPassword + "]";
	}

}
