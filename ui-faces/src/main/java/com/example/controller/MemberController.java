package com.example.controller;

import com.example.model.Member;
import com.example.dao.MemberDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class MemberController implements Serializable {
    private Member member = new Member();
    private MemberDAO memberDAO = new MemberDAO();

    public void createMember() {
        memberDAO.addMember(member);
        member = new Member(); // Reset the member object after creation
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public MemberDAO getMemberDAO() {
        return memberDAO;
    }

    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void updateMember() {
        memberDAO.updateMember(member);
    }

    public void deleteMember() {
        memberDAO.deleteMember(member.getId());
        member = new Member(); // Reset the member object after deletion
    }

    // Add this method for JSF dataTable
    public List<Member> getMembers() {
        return memberDAO.getAllMembers();
    }
}