package com.freewiki.wikiapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class  WikiAppApplication {
	public static void main(String[] args) {
		/*String x = "[p] This is a [[link text|http://example.com]] to check. [{right|image|photo of object|https://images.pexels.com/photos/674010/pexels-photo-674010.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1}] [p]";
		String res = TextParser.getParsedText(x);
		System.out.println(res);*/
		SpringApplication.run(WikiAppApplication.class, args);
	}

}
