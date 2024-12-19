# To-Do-Manager

Dies ist ein erstes Übungsprojekt zur Entwicklung einer Full-Stack-Anwendung mit Spring Boot im Backend sowie HTML, CSS und JavaScript im Frontend. Das Ziel dieses Projekts war es, grundlegende Fähigkeiten im Umgang mit modernen Webtechnologien und Java zu erlernen und anzuwenden.

## Technologie-Stack
- **Backend**: Java 21 mit Spring Boot
- **Frontend**: HTML, CSS, JavaScript
- **Build-Tool**: Maven

## Projektübersicht
Der To-Do-Manager ermöglicht es, Aufgaben hinzuzufügen, anzuzeigen, zu bearbeiten und zu löschen. 
Das Backend wurde mit Spring Boot realisiert, während das Frontend eine einfache Benutzeroberfläche bietet, um mit dem Backend zu interagieren.

## Voraussetzungen
Bevor du das Projekt startest, stelle sicher, dass folgende Software auf deinem Computer installiert ist:

- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) oder höher
- [Maven](https://maven.apache.org/install.html)

Optional:
- Eine IDE wie IntelliJ IDEA oder Eclipse

## Installation und Ausführung
### 1. Repository klonen
Lade das Projekt auf deinen Computer herunter, indem du das Repository klonst:
```bash
git clone https://github.com/Simon-Wittker/To-Do-Manager.git
cd To-Do-Manager
```

### 2. Abhängigkeiten installieren
Verwende Maven, um alle notwendigen Abhängigkeiten herunterzuladen:
```bash
mvn clean install
```

### 3. Anwendung starten
Die Anwendung kann mit folgendem Befehl gestartet werden:
```bash
mvn spring-boot:run
```
Alternativ kannst du eine ausführbare JAR-Datei erstellen und diese starten:
```bash
mvn package
java -jar target/to-do-manager-0.0.1-SNAPSHOT.jar
```

### 4. Anwendung im Browser öffnen

Falls du Konfigurationsänderungen vornehmen möchtest (z. B. Portänderungen oder Datenbankeinstellungen), findest du die Datei `application.properties` unter `src/main/resources`. Bearbeite diese Datei entsprechend deiner Umgebung.
Sobald die Anwendung läuft, kannst du sie über deinen Webbrowser aufrufen:
```
http://localhost:8080
```

## Weiterentwicklung
Dieses Projekt dient als Grundlage für zukünftige Erweiterungen und Verbesserungen. Ideen zur Weiterentwicklung könnten sein:
- Implementierung einer Benutzeranmeldung
- Erweiterung um zusätzliche Features wie Fälligkeitsdaten oder Kategorien
- Deployment in eine Cloud-Umgebung

## Feedback
Feedback und Vorschläge sind herzlich willkommen! Dieses Projekt ist ein erster Schritt in die Welt der Full-Stack-Entwicklung und wird kontinuierlich weiterentwickelt.

---
Vielen Dank fürs Anschauen und viel Spass beim Ausprobieren! 🚀


