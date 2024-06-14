No problem, here's an updated README file considering your use of Java Spring, Javascript, CSS, and HTML:

## FreeWikiApp

**Welcome to FreeWikiApp!** 

This project aims to create a collaborative information-sharing platform without moderation. It allows users to freely contribute and edit content, fostering a space for open knowledge exchange.

**Tech Stack:**

* Backend: Java Spring
* Frontend: Javascript, CSS, HTML

**Getting Started**

**Prerequisites:**

* Java Development Kit (JDK) ([https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/))
* Maven ([https://maven.apache.org/](https://maven.apache.org/))
* Your preferred IDE (e.g., IntelliJ IDEA)

**Steps:**

1. **Clone the repository:**

```bash
git clone https://github.com/Nikolozi-Potskhishvili/wikiapp.git
```

2. **Navigate to the project directory:**

```bash
cd wikiapp
```

3. **Install dependencies:**

   This project uses Maven for dependency management. Run the following command to download all required libraries:

   ```bash
   mvn clean install
   ```

4. **Run the application:**

   The application startup script depends on your specific configuration. Look for instructions within the project's `src/main/java` directory (e.g., a main class with a `main` method). Typically, you can run the application using your IDE's "Run" functionality or from the command line with:

   ```bash
   mvn spring-boot:run
   ```

   This will start the application on a local server, typically accessible at http://localhost:8080 (the exact port might vary).

**Features**

* Users can create and edit articles.
* Articles support a simple markup language for:
    * Hyperlinks to other wiki pages using `[[link text|URL]]`.
    * Image placement with `[image left]|{{image path}}|[image right]`.

**Contributing**

We welcome contributions to FreeWikiApp! Please feel free to create pull requests with your improvements or bug fixes.

**Disclaimer**

Please note that due to the lack of moderation, content on FreeWikiApp may not always be accurate or reliable. Use your judgment when evaluating information found here.

**Stay Tuned!**

This is an ongoing project, and we're actively working on improvements. Feel free to reach out with suggestions or feedback!

**I hope this helps!**

Remember to replace `"https://github.com/your-username/FreeWikiApp.git"` with the actual URL of your GitHub repository.  Also, update the instructions for running the application based on your specific project setup.
