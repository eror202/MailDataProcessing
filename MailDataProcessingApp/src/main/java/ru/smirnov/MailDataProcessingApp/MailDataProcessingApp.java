package ru.smirnov.MailDataProcessingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class MailDataProcessingApp {

	public static void main(String[] args) {
		SpringApplication.run(MailDataProcessingApp.class, args);
	}

}
