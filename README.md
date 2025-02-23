# GitHub Activity CLI 🚀

GitHub Activity CLI es una aplicación de línea de comandos (CLI) que permite consultar y mostrar la actividad reciente de un usuario de GitHub. Esto incluye eventos como commits, apertura de issues, estrellas en repositorios, forks y pull requests. La información se obtiene utilizando la [GitHub API](https://docs.github.com/en/rest).

---

## 🚀 Funcionalidades

- Consultar la actividad reciente de cualquier usuario de GitHub.
- Mostrar diferentes tipos de eventos, incluyendo:
    - 🚀 Commits (`PushEvent`)
    - 🐞 Issues (`IssuesEvent`)
    - ⭐ Estrellas (`WatchEvent`)
    - 🍴 Forks (`ForkEvent`)
    - 🔄 Pull Requests (`PullRequestEvent`)
- Manejo de errores para:
    - Usuarios inexistentes.
    - Errores de conexión.
    - Usuarios sin actividad reciente.

---

## 📋 Requisitos previos

- Java Development Kit (JDK) 11 o superior.
- IntelliJ IDEA (recomendado) u otro IDE de tu preferencia.
- Conexión a internet para obtener la actividad de GitHub.

---

## ⚙️ Instalación

1. Clona este repositorio:
    ```bash
    git clone https://github.com/tu-usuario/github-activity-cli.git
    cd github-activity-cli
    ```

2. Importa el proyecto en **IntelliJ IDEA** o en tu IDE favorito.

3. Asegúrate de tener las dependencias necesarias para trabajar con JSON.  
   Si estás usando **Maven**, asegúrate de tener la siguiente dependencia en tu `pom.xml`:
    ```xml
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20230227</version>
    </dependency>
    ```

---

## ▶️ Ejecución

### **Desde IntelliJ IDEA:**
- Ejecuta la clase `Main` directamente desde el IDE.
- Se te pedirá ingresar el nombre de usuario de GitHub en la consola.

### **Desde la terminal:**
1. Compila el proyecto:
    ```bash
    javac -d out/ src/main/java/com/github/activitycli/*.java
    ```
2. Navega a la carpeta de salida:
    ```bash
    cd out
    ```
3. Ejecuta la aplicación proporcionando el nombre de usuario de GitHub:
    ```bash
    java com.github.activitycli.Main
    ```

---



