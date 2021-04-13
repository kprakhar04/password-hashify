package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.beans.Password;
import com.example.utils.HashUtils;

@Controller
@RequestMapping("/hash")
public class HashController {

	@Autowired
	HashUtils hashUtils;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/bcrypt")
	public String getBcrypt(Model model) {
		model.addAttribute("password", new Password());
		return "bcrypt";
	}

	@PostMapping("/bcrypt")
	public String postBcrypt(@ModelAttribute("password") Password password, Model model) {
		String encodedPassword = hashUtils.generateBcrypt(password.getPlainText());
		password.setHashedPassword(encodedPassword);
		model.addAttribute("password", password);
		return "bcrypt";
	}

	@GetMapping("/scrypt")
	public String getScrypt(Model model) {
		model.addAttribute("password", new Password());
		return "scrypt";
	}

	@PostMapping("/scrypt")
	public String postScrypt(@ModelAttribute("password") Password password, Model model) {
		String encodedPassword = hashUtils.generateScrypt(password.getPlainText());
		password.setHashedPassword(encodedPassword);
		model.addAttribute("password", password);
		return "scrypt";
	}

	@GetMapping("/pbkdf2")
	public String getPbkdf2(Model model) {
		model.addAttribute("password", new Password());
		return "pbkdf2";
	}

	@PostMapping("/pbkdf2")
	public String postPbkdf2(@ModelAttribute("password") Password password, Model model) {
		String encodedPassword = hashUtils.generatePbkdf2(password.getPlainText());
		password.setHashedPassword(encodedPassword);
		model.addAttribute("password", password);
		return "pbkdf2";
	}

	@GetMapping("/sha-256")
	public String getSha256(Model model) {
		model.addAttribute("password", new Password());
		return "sha-256";
	}

	@PostMapping("/sha-256")
	public String postSha384(@ModelAttribute("password") Password password, Model model) {
		String encodedPassword = hashUtils.generateSHA256(password.getPlainText());
		password.setHashedPassword(encodedPassword);
		model.addAttribute("password", password);
		return "sha-256";
	}

	@GetMapping("/sha-384")
	public String getSha384(Model model) {
		model.addAttribute("password", new Password());
		return "sha-384";
	}

	@PostMapping("/sha-384")
	public String postSha256(@ModelAttribute("password") Password password, Model model) {
		String encodedPassword = hashUtils.generateSHA384(password.getPlainText());
		password.setHashedPassword(encodedPassword);
		model.addAttribute("password", password);
		return "sha-384";
	}

	@GetMapping("/sha-512")
	public String getSha512(Model model) {
		model.addAttribute("password", new Password());
		return "sha-512";
	}

	@PostMapping("/sha-512")
	public String postSha512(@ModelAttribute("password") Password password, Model model) {
		String encodedPassword = hashUtils.generateSHA512(password.getPlainText());
		password.setHashedPassword(encodedPassword);
		model.addAttribute("password", password);
		return "sha-512";
	}

}
