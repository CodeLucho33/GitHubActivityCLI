package com.github.activitycli;

import com.github.activitycli.service.GitHubActivityFetcher;


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

        // Crear una instancia de GitHubActivityFetcher y obtener la actividad
        GitHubActivityFetcher fetcher = new GitHubActivityFetcher();
        fetcher.fetchAndDisplayActivity(username);
    }
}