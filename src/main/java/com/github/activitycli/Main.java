package com.github.activitycli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Pedir al usuario que ingrese el nombre de usuario de GitHub
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de usuario de GitHub: ");
        String username = scanner.nextLine().trim();

        // Validar que el nombre de usuario no esté vacío
        if (username.isEmpty()) {
            System.out.println("Error: El nombre de usuario no puede estar vacío.");
            return;
        }

        // Conectar con la GitHub API y obtener la actividad del usuario
        String apiUrl = "https://api.github.com/users/" + username + "/events";
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/vnd.github.v3+json");

            // Verificar el código de estado HTTP
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

                // Mostrar la respuesta en la terminal (solo para pruebas)
                System.out.println("Respuesta de la API:");
                System.out.println(response.toString());
            } else {
                System.out.println("Error: No se pudo obtener la actividad. Código de estado HTTP: " + statusCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Error: No se pudo conectar con la API de GitHub.");
            e.printStackTrace();
        }
    }
}
