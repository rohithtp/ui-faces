package com.example.dao;

import com.example.model.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    
    // Method to add a new member
    public void addMember(Member member) {
        // Implementation for adding a member to the database
    }

    // Method to retrieve a member by ID
    public Member getMember(Long id) {
        // Implementation for retrieving a member from the database
        return null; // Placeholder return
    }

    // Method to update an existing member
    public void updateMember(Member member) {
        // Implementation for updating a member in the database
    }

    // Method to delete a member by ID
    public void deleteMember(Long id) {
        // Implementation for deleting a member from the database
    }

    // Method to get all members from the SQLite database
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        String url = "jdbc:sqlite:ui_faces_db.sqlite";
        String sql = "SELECT id, name, membershipDate FROM Member";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                member.setMembershipDate(rs.getString("membershipDate"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}