# JKS-SmartNotes
A simple note-taking app build with Java and XAMPP.

## About the Projekt
**JKS-SmartNotes** is a Java-based note-taking app with a graphical user interface (GUI) and a MySQL database connection (XAMPP). Our users can create, save, and categorize personal notes with tags.
Category via tags, as well as the ability to filter notes by title or tag, ensures that even with numerous entries, a clear overview is maintained. Secure user management with password hashing ensures that each user can only access their own notes.

## Motivation and Problem Statement
In an increasingly digital world, the need for simple yet effective tools for personal information management is growing. Many existing note-taking apps are either too complex, require an internet connection, or store user data insecurely. Furthermore, they often lack customizability or well-designed search functions, especially in the area of tag management.
Our motivation was therefore to develop a simple, local note-taking application that is easy to use but still offers essential features such as user management, password security, tag search, and structured data storage.

## Main Project Goals
Development of a GUI-based note-taking application in Java with a MySQL database connection
* User management with a secure login system and encrypted password storage (jBCrypt)
* Creation of notes including titles and descriptions
* Tag and category functionality for targeted content organization and filtering
* Search function for notes based on tags
* User-friendly and clean design using the FlatLaf library

## Problems and Special Features During the Project
During the development of JKS-SmartNotes, various technical and organizational challenges arose. Some of these led to certain features not being fully implemented due to time constraints:
Problems:
**I.** GUI Design with NetBeans
The user interface was created with NetBeans. While this facilitated visual design, problems with automatically generated code, which had to be manually adjusted, occurred regularly. Layout control required a lot of fine-tuning, especially when combining text fields, buttons, and selection fields. Despite the challenges, the FlatLaf library enabled a modern design.

**II.** Password Hashing with jBCrypt
Secure user login was a key feature of the project. Integrating the jBCrypt library presented a challenge, as the correct use of `hashpw()` and `checkpw()` during registration and login required careful implementation. After several testing phases, a functioning system was achieved that securely stores encrypted passwords and meets security standards.

**III.** Complexity of the Database Structure
Setting up a relational database with a many-to-many relationship between notes and tags was conceptually complex. The SQL commands and the Java integration, in particular, had to be carefully coordinated for storing and mapping tags to notes. The database structure was revised several times until it was error-free and logically sound.

**IV.** Unimplemented Features
Some originally planned features could not be completed due to time constraints:
* Sharing notes with other users:
* Deleting and editing notes:
* User roles (e.g., Admin, Guest, Premium User…)

These points have been documented and can be added in a future version.

Special Features:
* Use of password hashing with jBCrypt – secure and privacy-friendly.
* Database with many-to-many relationships for flexible tag assignment.
* Clearly structured GUI despite manual corrections using the NetBeans editor.
* Search function with tag filtering.
* Potential for future extensions due to its modular design.

## Project Structure
```text
JKS-SmartNotes/
│
├── Bibliotheken/
│
├── GUI-Bilder/
│
├── JKS-SmartNotes_FINAL_FERTIG/
│   ├── build/
│   │   └── classes/
│   ├── nbproject/
│   │   ├── private/
│   │   ├── build-impl.xml
│   │   ├── build-jar.properties 
│   │   ├── genfiles.properties
│   │   ├── project.properties
│   │   └── project.xml
│   ├── src/
│   ├── build.xml
│   └── manifest.mf
│
├── Ausarbeitung_JKS-SmartNotes-inklusiveProblembeschreibung.pdf
├── Bedienungsanleitung_JKS-SmartNotes.pdf
├── ER-Diagramm-JKS-SmartNotes.png
├── ER-Modell_JKS-SmartNotes.pdf
├── JKS-SmartNotes.pdf
├── JKS-Smartnotes (Code erklärung).pdf
├── Klassendiagramm-JKS-SmartNotes.pdf
└── jks_notiz_db.sql
```


## Technical Implementation
The application was developed using Java in the NetBeans development environment. The FlatLaf library was used for the UI design to ensure a modern appearance.
The database used was MySQL, operated via XAMPP/phpMyAdmin, connected using the MySQL Connector.
For secure password management, jBCrypt was integrated to hash all login credentials and store them securely in the database.

Libraries:
* Mysql-connector-j-8.4.0
* jBCrypt-0.4 (password hashing)
* FlatLaf-3.4.1 (modern GUI design)

## GUI Design and User Guidance
* Login/Registration: User enters login credentials or registers.
* Add: Enter a new note with a title, category, tags, and text.
* View: Display and filter notes by tags and titles.


## Conclusion and Outlook
We have developed a functioning system with user login, note creation, tags, and filtering.

We were able to improve important programming and project work skills:
* Java GUI
* Database modeling
* Password security
* Team coordination with Kanban
Future potential:
* Sharing function
* Mobile version
* Markdown support
* User roles

## Author
Created by Siavash Mehdipouraraei
