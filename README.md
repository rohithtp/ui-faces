# ui-faces

A Java web application for library management using PrimeFaces, JSF, and SQLite.

## Features
- Manage books, members, and loans
- Modern JSF/PrimeFaces UI
- SQLite database backend (see `src/main/resources/dummy-data.sql` for schema and sample data)

## Architecture Overview
- **Front End:** PrimeFaces (JSF)
- **Back End:** Java EE/Jakarta EE
- **Database:** SQLite (accessed via JDBC)

## Data Model
- **Book:** id, title, author, isbn
- **Member:** id, name, email, membershipDate
- **Loan:** id, bookId, memberId, loanDate, returnDate

## Project Structure
```
ui-faces/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── model/
│   │   │           │   ├── Book.java
│   │   │           │   ├── Member.java
│   │   │           │   └── Loan.java
│   │   │           ├── dao/
│   │   │           │   ├── BookDAO.java
│   │   │           │   ├── MemberDAO.java
│   │   │           │   └── LoanDAO.java
│   │   │           └── controller/
│   │   │               ├── BookController.java
│   │   │               ├── MemberController.java
│   │   │               └── LoanController.java
│   │   ├── resources/
│   │   │   ├── dummy-data.sql
│   │   │   └── META-INF/
│   │   │       └── persistence.xml
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       └── pages/
│   │           ├── books.xhtml
│   │           ├── members.xhtml
│   │           └── loans.xhtml
├── pom.xml
```

## Setup
1. **Build the project with Maven:**
   ```bash
   mvn clean package
   ```
2. **Populate the SQLite database with dummy data:**
   ```bash
   sqlite3 ui_faces_db.sqlite < src/main/resources/dummy-data.sql
   ```
3. **Run the project in Jetty:**
   - Add the Jetty Maven plugin to your `pom.xml` (see below).
   - Start Jetty with:
     ```bash
     mvn jetty:run
     ```
   - The application will be available at [http://localhost:8080/ui-faces](http://localhost:8080/ui-faces)

### Jetty Plugin Configuration
Add the following to your `pom.xml` inside the `<plugins>` section:
```xml
<plugin>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-maven-plugin</artifactId>
    <version>9.4.53.v20231009</version>
    <configuration>
        <webApp>
            <contextPath>/ui-faces</contextPath>
        </webApp>
    </configuration>
</plugin>
```

## Requirements
- Java 8+
- Maven
- SQLite
- Java EE server (for JSF/PrimeFaces) or Jetty

## License
MIT License. See LICENSE file for details.
