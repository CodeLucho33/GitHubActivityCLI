package com.github.activitycli.service;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubActivityFetcher {

    public void fetchAndDisplayActivity(String username) {
        // Construir la URL de la API de GitHub
        String apiUrl = "https://api.github.com/users/" + username + "/events";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/vnd.github.v3+json");

            int statusCode = connection.getResponseCode();
            if (statusCode == 200) {
                // Leer la respuesta
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parsear el JSON y mostrar la actividad
                JSONArray events = new JSONArray(response.toString());
                System.out.println("\nActividad reciente de GitHub para el usuario: " + username);
                for (int i = 0; i < events.length(); i++) {
                    JSONObject event = events.getJSONObject(i);
                    String eventType = event.getString("type");
                    String repoName = event.getJSONObject("repo").getString("name");

                    switch (eventType) {
                        case "PushEvent":
                            int commitCount = event.getJSONObject("payload").getJSONArray("commits").length();
                            System.out.println("- Pushed " + commitCount + " commits to " + repoName);
                            break;
                        case "IssuesEvent":
                            String action = event.getJSONObject("payload").getString("action");
                            System.out.println("- " + capitalize(action) + " an issue in " + repoName);
                            break;
                        case "WatchEvent":
                            System.out.println("- Starred " + repoName);
                            break;
                        default:
                            // Ignorar otros tipos de eventos por ahora
                            break;
                    }
                }
            } else {
                System.out.println("Error: No se pudo obtener la actividad. Código de estado HTTP: " + statusCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Error: No se pudo conectar con la API de GitHub.");
            e.printStackTrace();
        }
    }

    // Método para capitalizar la primera letra de una palabra
    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
