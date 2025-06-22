package com.example.dao;

import com.example.model.Loan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {
    public void addLoan(Loan loan) {}
    public Loan getLoan(int id) { return null; }
    public void updateLoan(Loan loan) {}
    public void deleteLoan(int id) {}

    public List<Loan> getAllLoans() {
        List<Loan> loans = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:ui_faces_db.sqlite");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Loan")) {
            while (rs.next()) {
                Loan loan = new Loan();
                loan.setId(rs.getInt("id"));
                loan.setBookId(rs.getInt("book_id"));
                loan.setMemberId(rs.getInt("member_id"));
                loan.setLoanDate(rs.getString("loan_date"));
                loan.setReturnDate(rs.getString("return_date"));
                loans.add(loan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loans;
    }
}