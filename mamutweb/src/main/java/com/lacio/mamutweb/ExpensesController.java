package com.lacio.mamutweb;

import com.lacio.mamutweb.entities.SettlementRow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExpensesController {
    private final SettlementRowRepository repository;

    public ExpensesController(SettlementRowRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/expenses")
    public ExpensesOutput expensesOutput(){

        ArrayList<Expense> expenses = new ArrayList<>();
        List<SettlementRow> rows = repository.findAll();
        for (SettlementRow row:rows) {
            expenses.add(new Expense(row.getId(),row.getKategoria(),row.getKoszt(),Character.toString(row.getKto())));
        }

       return new ExpensesOutput(expenses);
    }
}
