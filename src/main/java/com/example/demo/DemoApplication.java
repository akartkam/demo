package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibm.icu.text.MessageFormat;

import org.springframework.boot.Banner;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		String msg = ResourceBundle.getBundle("messages").getString("message");
		msg = new String(msg.getBytes(ISO_8859_1), UTF_8);
		Map<String, Object> arg = new HashMap<>(1);
		arg.put("arg1", new Boolean(true));
		arg.put("arg2", new Integer(78691));
		arg.put("arg3", new Integer(2300));
		msg = MessageFormat.format(msg, arg);
		System.out.println(msg);
		
		System.exit(0);
	}

}
