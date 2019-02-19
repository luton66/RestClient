package com.feckleface.massive.RestClient;

import com.feckleface.massive.RestClient.client.DailyMailTechClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Work on this project was based on
 *
 * https://www.youtube.com/watch?v=DyNXkznUYaU
 *
 */
@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {

	@Autowired
	DailyMailTechClient client;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		ResponseEntity result = client.getFromDailyMail();

		LinkedHashMap<String, ArrayList<LinkedHashMap>> newResult = (LinkedHashMap) result.getBody();
		ArrayList<LinkedHashMap> newnewResult = newResult.get("sciencetech");

		List<String> finalResult = newnewResult.stream().map(element -> (String) element.get("headline")).collect(Collectors.toList());

		String x = "x";

	}
}
