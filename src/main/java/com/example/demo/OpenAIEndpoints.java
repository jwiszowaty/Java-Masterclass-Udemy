package com.example.demo;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
                URL url = new URL("https://api.openai.com/v1/chat/completions");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Authorization", "Bearer " + System.getenv("VITE_OPENAI_API_KEY"));
                connection.setDoOutput(true);
                String content = new String(Files.readAllBytes(Paths.get("CV Jakub Wiszowaty October 2024.txt")));

                String jsonInputString = "{\"model\":\"gpt-4o-mini\",\"messages\":[{\"role\":\"system\",\"content\":\"You are a helpful assistant.\"},{\"role\":\"user\",\"content\":\" Why Jakub is an exceptional junior software developer based on the cv:" +
                        content +
                        "\"}]}";
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
                        .body(responseJSON.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content"));
            } catch (Exception e) {
                return ResponseEntity
                        .status(400)
                        .body(e.getMessage());
            }
        }
}
