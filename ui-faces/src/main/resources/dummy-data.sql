-- Create tables (if not already created by JPA/Hibernate)
CREATE TABLE IF NOT EXISTS Book (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT,
    author TEXT,
    isbn TEXT
);

CREATE TABLE IF NOT EXISTS Member (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    email TEXT,
    membershipDate TEXT
);

CREATE TABLE IF NOT EXISTS Loan (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    book_id INTEGER,
    member_id INTEGER,
    loan_date TEXT,
    return_date TEXT,
    FOREIGN KEY(book_id) REFERENCES Book(id),
    FOREIGN KEY(member_id) REFERENCES Member(id)
);

-- Insert dummy books
INSERT INTO Book (title, author, isbn) VALUES
('Effective Java', 'Joshua Bloch', '9780134685991'),
('Clean Code', 'Robert C. Martin', '9780132350884'),
('Design Patterns', 'Erich Gamma', '9780201633610');

-- Insert dummy members
INSERT INTO Member (name, email, membershipDate) VALUES
('Alice Smith', 'alice@example.com', '2025-01-01'),
('Bob Johnson', 'bob@example.com', '2025-02-15');

-- Insert dummy loans
INSERT INTO Loan (book_id, member_id, loan_date, return_date) VALUES
(1, 1, '2025-06-01', '2025-06-15'),
(2, 2, '2025-06-10', NULL);
