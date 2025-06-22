# ui-faces Project

## Overview
The `ui-faces` project is a Java-based web application that manages a library system. It allows users to manage books, members, and loans through a web interface.

## Project Structure
The project follows a standard Maven directory structure:

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
│   │   │   └── META-INF/
│   │   │       └── persistence.xml
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       └── pages/
│   │           ├── books.xhtml
│   │           ├── members.xhtml
│   │           └── loans.xhtml
└── pom.xml
```

## Setup Instructions
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd ui-faces
   ```

2. **Build the Project**
   Ensure you have Maven installed, then run:
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   You can run the application using a servlet container like Apache Tomcat. Deploy the `ui-faces.war` file located in the `target` directory.

## Usage Guidelines
- Access the application through your web browser at `http://localhost:8080/ui-faces`.
- Use the navigation links to manage books, members, and loans.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.