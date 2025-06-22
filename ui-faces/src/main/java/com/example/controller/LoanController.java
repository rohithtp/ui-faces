package com.example.controller;

import com.example.model.Loan;
import com.example.dao.LoanDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class LoanController {
    private Loan loan = new Loan();
    private LoanDAO loanDAO = new LoanDAO();

    public void createLoan() {
        loanDAO.addLoan(loan);
        loan = new Loan(); // Reset loan after creation
    }

    public Loan getLoan() {
        return loanDAO.getLoan(loan.getId());
    }

    public void updateLoan() {
        loanDAO.updateLoan(loan);
    }

    public void deleteLoan() {
        loanDAO.deleteLoan(loan.getId());
        loan = new Loan(); // Reset loan after deletion
    }

    public Loan getLoanDetails() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public List<Loan> getLoans() {
        return loanDAO.getAllLoans();
    }
}