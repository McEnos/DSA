package com.company.codingproblems.thirteen;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception{
        /**
         * JDK 11 built in HttpClient
         * 1) Create HttpClient Object
         * 2) Build HttpRequest object
         * 3) Trigger request and wait for response
         */

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Whole response: " + response.uri());
            System.out.println("\n Body: " + response.body());
            HttpHeaders headers = response.headers();
            Map<String, List<String>> map = headers.map();
            map.forEach((value, key) -> System.out.println(value + ": " + key));
            List<String> cacheControl = headers.allValues("cache-control");
            System.out.println(cacheControl);
            // System.out.println(headers);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        HttpRequest getRequest = HttpRequest.newBuilder()
                .GET() //can be omitted, it's the default
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpRequest postRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\"name\": \"morpheus\",\"job\": \"leader\"}"
                ))
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpRequest putRequest = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(
                        "{\"name\": \"morpheus\",\"job\": \"zion resident\"}"
                ))
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpRequest deleteRequest = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpRequest patchRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .method("PATCH", HttpRequest.BodyPublishers.ofString(
                        "{\"name\": \"morpheus\",\"job\": \"zion resident\"}"
                ))
                .header("Content-Type", "application/json")
                .build();

        HttpRequest headRequest = HttpRequest.newBuilder()
                .method("HEAD", HttpRequest.BodyPublishers.noBody())
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpRequest requestBodyInputStream = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofInputStream(() -> inputStream("user.json")))
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        try {
            HttpRequest byteArrayRequestBody = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofByteArray(
                            Files.readAllBytes(Path.of("user.json"))
                    ))
                    .uri(URI.create("https://reqres.in/api/users/2"))
                    .build();
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            HttpRequest fileRequestBody = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofFile(Path.of("user.json")))
                    .uri(URI.create("https://reqres.in/api/users/2"))
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        HttpClient client1 = HttpClient.newBuilder()
                .proxy(ProxySelector.of(new InetSocketAddress("proxy.host", 80)))
                .proxy(ProxySelector.getDefault())
                .build();
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080"))
                .header("name", "Joshua")
                .setHeader("lastName", "Enos")
                .build();

        HttpClient client2 = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "username",
                                "password".toCharArray()
                        );
                    }
                })
                .build();

        Map<String,String> body = new HashMap<>();
        body.put("name","Joshua");
        body.put("lastName","Enos");
        body.put("emailAddress","joshuamcenos@gmail.com");
        body.put("phoneNumber","8689686968595");
      //  ObjectMapper

        HttpRequest request2 = HttpRequest.newBuilder()
                .header("Authorization", basicAuth("username", "password"))
                .timeout(Duration.of(5, ChronoUnit.MILLIS))
                .build();

        //Sending request synchronously
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        HttpClient httpClient1 = HttpClient.newHttpClient();

        HttpRequest httpRequest1 = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        CompletableFuture<String> response1 = httpClient1.sendAsync(httpRequest1, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(e -> "Exception: " + e);
        // .thenAccept(System.out::println)
                //.get(30, TimeUnit.SECONDS);

        while (!response1.isDone()){
            //Thread.sleep(50);
            System.out.println("Performing other tasks  while waiting for response....");
        }
       // String body = response1.get(30, TimeUnit.SECONDS);



    }

    private static String basicAuth(String username, String password) {
        return "Basic " + Base64.getEncoder().encodeToString(
                (username + ":" + password).getBytes()
        );
    }

    private static ByteArrayInputStream inputStream(String fileName) {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(
                Files.readAllBytes(Path.of(fileName))
        )) {
            return inputStream;
        } catch (IOException e) {
            throw new RuntimeException("File could not be found", e);
        }
    }
}
