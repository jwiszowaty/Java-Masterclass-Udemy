package com.example.demo;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                String myCvCharsEscaped = "{\'name\':\'Jakub Wiszowaty\',\'desiredCareer\':\'Junior Software Engineer\',\'about\':\'I'm a curious and fast-learning junior software developer with a strong background in chemistry. I am eager to join a team with a supportive environment to develop my skills further and use my excellent problem-solving skills to contribute to real-world projects. I have experience with working in teams and independently. In the past four months, I have explored PL/SQL, Java and testing. I'm currently undertaking the Java 17 Masterclass course on Udemy.\',\'technical_skills\':{\'languages\':[\'JavaScript\',\'Java\'],\'methodologies\':[\'Agile\',\'SCRUM\'],\'hosting\':[\'ElephantSQL\',\'Render\',\'Netlify\',\'Docker\'],\'front_end\':[\'HTML\',\'CSS\',\'React\',\'React Native\',\'Tableau\'],\'testing\':[\'TDD\',\'Jest\',\'Supertest\',\'JUnit\',\'Selenium\'],\'back_end\':[\'PostgreSQL\',\'Express.js\',\'seeding\',\'PL/SQL\']},\'experience\':[{\'date_range\':\'May 2024 - Present\',\'projects\':[{\'name\':\'Rock Paper Scissors (Scanner)\',\'link\':\'GitHub\'},{\'name\':\'Spring Boot REST API\',\'link\':\'GitHub\'}],\'responsibilities\':[\'Completed two specialized trainings in Data Science and Software Development.\'],\'company\':\'Ten10\',\'title\':\'Trainee Software Engineer\'},{\'date_range\':\'Aug 2023 - Nov 2023\',\'projects\':[{\'website\':\'website\',\'name\':\'PSQL & React\',\'backend_repo\':\'back end repo\'},{\'name\':\'PSQL & React Native\',\'frontend_repo\':\'front end repo\',\'backend_repo\':\'back end repo\',\'app_presentation\':\'app presentation\'}],\'responsibilities\':[\'The boot camp involved high-intensity learning where I learned about the industry's best practices.\',\'Practiced collaboration in paired programming throughout the boot camp and significantly improved interpersonal skills.\'],\'company\':\'Northcoders\',\'title\':\'Trainee Software Engineer\'},{\'date_range\':\'Oct 2019 - Present\',\'responsibilities\':[\'Prepared over 600 hours of online lessons for Polish high school students.\',\'Improved my students' pronunciation.\',\'Helped them overcome a fear of speaking in a foreign language.\'],\'company\':\'Online\',\'title\':\'English Tutor\'},{\'date_range\':\'Jun 2022 - Jun 2023\',\'responsibilities\':[\'Organic synthesis of substituted amphetamines and analogues of cannabidiols.\',\'Reversed and normal phase purification of organic compounds using Biotage.\',\'Analytical methods used: NMR, LC-MS, HPLC.\'],\'company\':\'NewChem Technologies\',\'title\':\'Research Assistant\'},{\'date_range\':\'Aug - Sept 2021\',\'responsibilities\':[\'Organic synthesis of analogues of barbituric acid.\',\'Purification using manual column chromatography and recrystallisation.\',\'Analytical methods used: LC-MS, HPLC, NMR (1H, 13C, 19F).\'],\'company\':\'BiBerChem Research\',\'title\':\'Research Project\',\'supervisor\':\'Prof. Bernard T Golding\'},{\'date_range\':\'Aug - Sept 2020\',\'responsibilities\':[\'Organic synthesis of analogues of cannabidiols.\'],\'company\':\'NewChem Technologies\',\'title\':\'Summer Intern\'},{\'date_range\':\'Jul 2017 - Aug 2021\',\'responsibilities\':[\'Worked efficiently with a team of 13 staff members in a busy restaurant environment.\',\'Maintained clean working space and shared responsibilities of a waiter, kitchen porter, cashier.\'],\'company\':\'Creams Café Newcastle\',\'title\':\'Team Member\'}],\'education\':[{\'date_range\':\'Oct 2018 - June 2022\',\'institution\':\'Newcastle University\',\'degree\':\'Master of Chemistry (2:1)\'}],\'volunteer_work\':[{\'date_range\':\'Oct - Dec 2021\',\'responsibilities\':[\'4-hour shift on Sundays for three months.\',\'Welcomed and directed patients in the centre to the check-in desks and kept them company in the queue, distracting them from their fear of vaccination.\',\'Organized a line for patients under 18 to maintain a good flow of patients and their parents, ensuring a comforting visit.\'],\'organization\':\'RVI Newcastle Hospitals NHS Foundation Trust\',\'location\':\'Centre For Life in Newcastle\',\'title\':\'Vaccination Centre Volunteer\'},{\'date_range\':\'Feb 2022\',\'responsibilities\':[\'4-hour shift on Sundays for three weeks.\',\'Contacted COVID-19 patients with underlying conditions to confirm their details and dispatched their medication to their homes.\'],\'organization\':\'RVI Newcastle Hospitals NHS Foundation Trust\',\'title\':\'Pharmacy Department Volunteer\'},{\'date_range\':\'Oct - Dec 2022\',\'responsibilities\':[\'4-hour night shift on Saturdays.\',\'Conversed with patients and comforted them with available food and beverages.\',\'Helped communicate between the nurses/doctors and patients, notifying personnel about anything that needed attention.\'],\'organization\':\'RVI Newcastle Hospitals NHS Foundation Trust\',\'title\':\'Emergency Department Volunteer\'}]}";
                URL url = new URL("https://api.openai.com/v1/chat/completions");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Authorization", "Bearer " + System.getenv("VITE_OPENAI_API_KEY"));
                connection.setDoOutput(true);
                String jsonInputString = "{\"model\":\"gpt-4o\",\"messages\":[{\"role\":\"system\",\"content\":\"You are analysing Jakub's cv and providing a convicing statements about it to potential employers. Maximum 22 words.\"},{\"role\":\"user\",\"content\":\"" +
                        "Provide one sentence statement for why my experience and skills make me an exceptional Software Developer based on my cv and remove period from your last sentence:" +
                        myCvCharsEscaped +
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
                        .body(e.getMessage() + "hi");
            }
        }
    @PostMapping(path = "/feedback/grammar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )    //
    public ResponseEntity provideFeedbackGrammar(
            @RequestBody JSONObject request
    ) {
        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + System.getenv("VITE_OPENAI_API_KEY"));
            connection.setDoOutput(true);
            String jsonInputString = "{\"model\":\"gpt-4o\",\"messages\":[{\"role\":\"system\",\"content\":\"You are analysing essays and other written work from students learning English. " +
                    "Mark sentences with grammatical mistakes by placing them inside <span class=\'grammar\'></span>." +
                    "At the end of each incorrect sentence add superscript integer." +
                    "inside <div class=\'grammar-feedback\'></div> place explanations in Polish, each in <p class=\'explanation\'></p> about each mistakes starting explanation with corresponding superscript integer." +
                    "return it in this form: <div class=\'writing\'>{place the text and it's formated sentences here}</div><div class=\'grammar-feedback\'></div></div>." +
                    "Put the integers that need to be supersciprted in <sup></sup>" +
                    "\"},{\"role\":\"user\",\"content\":\"" +
                    request.getString("text") +
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
    @GetMapping("/feedback/{text}/vocab") //
    public ResponseEntity provideFeedbackVocab(
            @PathVariable String text
    ) {
        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + System.getenv("VITE_OPENAI_API_KEY"));
            connection.setDoOutput(true);
            String jsonInputString = "{\"model\":\"gpt-4o\",\"messages\":[{\"role\":\"system\",\"content\":\"You are analysing essays and other written work from students learning English. " +
                    " Mark words which could be replaced with more interesting synonyms with <span class=\'vocab\'</span>." +
                    "At the end of each of those words add superscript integer." +
                    "inside <div class=\'vocab-feedback\'></div> place explanations in Polish, each in <p class=\'explanation\'></p> about each word starting explanation with corresponding superscript integer." +
                    "return it in this form: <div class=\'writing\'>{place the text and it's formated words here}</div><div class=\'vocab-feedback\'></div></div>." +
                    "Put the integers that need to be superscripted in <sup></sup>" +
                    "\"},{\"role\":\"user\",\"content\":\"" +
                    text +
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
