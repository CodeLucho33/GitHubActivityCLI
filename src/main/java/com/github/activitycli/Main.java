package com.github.activitycli;

public class Main {
    public static void main(String[] args) {
        // Verificar que se haya pasado un argumento
        if (args.length == 0) {
            System.out.println("Uso: java -jar GitHubActivityCLI.jar <nombre-de-usuario>");
            System.out.println("Ejemplo: java -jar GitHubActivityCLI.jar octocat");
            return;
        }

        // Obtener el nombre de usuario del primer argumento
        String username = args[0].trim();

        // Validar que el nombre de usuario no esté vacío
        if (username.isEmpty()) {
            System.out.println("Error: El nombre de usuario no puede estar vacío.");
            return;
        }

        // Mostrar el nombre de usuario ingresado (temporalmente, para pruebas)
        System.out.println("Obteniendo actividad de GitHub para el usuario: " + username);
    }
}