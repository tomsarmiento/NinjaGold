package com.tomassarmiento.ninjagold;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {
	static int totalGold = 0;
	int m,n;
	String msg;
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
	static ArrayList<String> mensajes = new ArrayList<String>();
	
	@RequestMapping("/")
	public String game() {
		if(totalGold<-5) {
			return "prison.jsp";
		}
		return "home.jsp";
	}
	
	@RequestMapping("/farm")
	public String farm(HttpSession session) {
		m = 10;
		n = 20;
		int gold = (int) Math.floor(Math.random()*(n-m+1)+m);
		totalGold += gold;
		LocalDateTime localtime = LocalDateTime.now();
		msg = "You entered a farm and earned "+gold+" gold. ("+localtime.format(myFormatObj)+")";
		mensajes.add(msg);
		session.setAttribute("mensajes", mensajes);
		session.setAttribute("totalGold", totalGold);
		return "redirect:/";
	}
	
	@RequestMapping("/cave")
	public String cave(HttpSession session) {
		m = 5;
		n = 10;
		int gold = (int) Math.floor(Math.random()*(n-m+1)+m);
		totalGold += gold;
		LocalDateTime localtime = LocalDateTime.now();
		msg = "You entered a cave and earned "+gold+" gold. ("+localtime.format(myFormatObj)+")";
		mensajes.add(msg);
		session.setAttribute("mensajes", mensajes);
		session.setAttribute("totalGold", totalGold);
		return "redirect:/";
	}
	
	@RequestMapping("/house")
	public String house(HttpSession session) {
		m = 2;
		n = 5;
		int gold = (int) Math.floor(Math.random()*(n-m+1)+m);
		totalGold += gold;
		LocalDateTime localtime = LocalDateTime.now();
		msg = "You entered a house and earned "+gold+" gold. ("+localtime.format(myFormatObj)+")";
		mensajes.add(msg);
		session.setAttribute("mensajes", mensajes);
		session.setAttribute("totalGold", totalGold);
		return "redirect:/";
	}
		
	@RequestMapping("/casino")
	public String casino(HttpSession session) {
		m = 0;
		n = 50;
		Random rd = new Random();
		int gold = (int) Math.floor(Math.random()*(n-m+1)+m);
		LocalDateTime localtime = LocalDateTime.now();
		if(rd.nextBoolean()) {
			msg = "You entered a casino and lost "+(gold)+" gold. ("+localtime.format(myFormatObj)+")";
			gold *= -1;
			mensajes.add(msg);
			session.setAttribute("mensajes", mensajes);
		}
		else {
			msg = "You entered a casino and earned "+(gold)+" gold. ("+localtime.format(myFormatObj)+")";
			mensajes.add(msg);
			session.setAttribute("mensajes", mensajes);
		}
		totalGold += gold;
		session.setAttribute("totalGold", totalGold);
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		totalGold = 0;
		mensajes.clear();
		session.setAttribute("mensajes", mensajes);
		session.setAttribute("totalGold", totalGold);
		return "redirect:/";
	}
}
