package com.lacio.mamutweb;

import java.util.List;

public class ExpensesOutput {
    private List<Expense> expenses;

    public ExpensesOutput(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
