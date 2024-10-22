package com.example.demo;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("generate")
public class OpenAIEndpoints {
        @GetMapping("/reason") //
        public ResponseEntity provideReason() {
            try {
                String content = new String(Files.readAllBytes(Paths.get("/Users/jakubwiszowaty/personal-projects/IdeaProjects/Java-Masterclass-Udemy/src/main/resources/cv.json")));
                JSONObject jsonObject = new JSONObject(content);
                URL url = new URL("https://api.openai.com/v1/chat/completions");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Authorization", "Bearer " + System.getenv("VITE_OPENAI_API_KEY"));
                connection.setDoOutput(true);
                String jsonInputString = "{\"model\":\"gpt-4o\",\"messages\":[{\"role\":\"system\",\"content\":\"You are a analysing Jakub's cv.\"},{\"role\":\"user\",\"content\":\"" +
                        "Give one reason for why my experience and skills make me an exceptional Software Developer based on my cv: " +
                         "\"}]}";
                StringBuilder response = new StringBuilder();
                try (OutputStream outputStream = connection.getOutputStream()) {
                    byte[] input =jsonInputString.getBytes("utf-8");
                    outputStream.write(input, 0, input.length);
                }

                try (BufferedReader bufferedReader2 = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(),"utf-8")
                )) {
                    String responseLine;
                    while ((responseLine = bufferedReader2.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
                int responseCode = connection.getResponseCode();
                String responseMessage = connection.getResponseMessage();
                System.out.println(responseCode + " " + responseMessage);
                System.out.println(response);
                JSONObject responseJSON = new JSONObject(response.toString());
                return ResponseEntity
                        .status(200)
                        .body(responseJSON.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content"));
            } catch (Exception e) {
                return ResponseEntity
                        .status(400)
                        .body(e.getMessage());
            }
        }
    @GetMapping("/image/{prompt}") //
    public ResponseEntity provideImage(@PathVariable String prompt) {
        try {
            URL url = new URL("https://api.openai.com/v1/images/generations");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + System.getenv("VITE_OPENAI_API_KEY"));
            connection.setDoOutput(true);
            String jsonInputString = "{\"prompt\":\""+ prompt +" \",\"n\":2,\"size\":\"1024x1024\"}";
            StringBuilder response = new StringBuilder();
            try (OutputStream outputStream = connection.getOutputStream()) {
                byte[] input =jsonInputString.getBytes("utf-8");
                outputStream.write(input, 0, input.length);
            }

            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(),"utf-8")
            )) {
                String responseLine;
                while ((responseLine = bufferedReader.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            System.out.println(responseCode + " " + responseMessage);
            System.out.println(response);
            JSONObject responseJSON = new JSONObject(response.toString());
            return ResponseEntity
                    .status(200)
                    .body(responseJSON.getJSONArray("data"));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
}
