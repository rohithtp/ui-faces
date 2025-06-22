# Library Management System Architecture

## Overview

This document outlines the architecture for a Library Management System that utilizes SQLite as the database backend and PrimeFaces for the front end.

### Architecture Components

1. **Client-Side (Front End)**
   - **PrimeFaces**: A UI component library for JavaServer Faces (JSF) that provides rich user interfaces.
   - **JSF (JavaServer Faces)**: A Java specification for building component-based user interfaces for web applications.

2. **Server-Side (Back End)**
   - **Java EE / Jakarta EE**: The application server that hosts the JSF application.
   - **SQLite**: A lightweight, file-based database for storing application data.

3. **Data Access Layer**
   - **JDBC (Java Database Connectivity)**: To connect and interact with the SQLite database.

## Suggested Data Model

The following entities are included in the data model for the Library Management System:

### 1. Book
- `id` (INTEGER, Primary Key)
- `title` (TEXT, Not Null)
- `author` (TEXT, Not Null)
- `published_year` (INTEGER)
- `isbn` (TEXT, Unique)

### 2. Member
- `id` (INTEGER, Primary Key)
- `name` (TEXT, Not Null)
- `email` (TEXT, Unique)
- `membership_date` (DATE)

### 3. Loan
- `id` (INTEGER, Primary Key)
- `book_id` (INTEGER, Foreign Key referencing Book)
- `member_id` (INTEGER, Foreign Key referencing Member)
- `loan_date` (DATE)
- `return_date` (DATE)

## Database Structure

The SQLite database can be structured using the following SQL commands:

```sql
CREATE TABLE Book (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    author TEXT NOT NULL,
    published_year INTEGER,
    isbn TEXT UNIQUE
);

CREATE TABLE Member (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT UNIQUE,
    membership_date DATE
);

CREATE TABLE Loan (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_id INTEGER,
    member_id INTEGER,
    loan_date DATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES Book(id),
    FOREIGN KEY (member_id) REFERENCES Member(id)
);
