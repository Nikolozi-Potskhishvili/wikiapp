package com.freewiki.wikiapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import wikimark.TextParser;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class WikiAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikiAppApplication.class, args);
	}

}
