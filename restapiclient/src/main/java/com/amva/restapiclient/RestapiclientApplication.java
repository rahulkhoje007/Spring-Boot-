package com.amva.restapiclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiclientApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

		var url = "http://localhost:8081/salary/USER_1";

		var req = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

		var client = HttpClient.newBuilder().build();

		var response = client.send(req, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());
		System.out.println(response.statusCode());

	}

}
