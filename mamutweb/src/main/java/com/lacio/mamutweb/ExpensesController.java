package com.lacio.mamutweb;

import com.lacio.mamutweb.entities.SettlementRow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ExpensesOutput> expensesOutput(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String excludedCategory
    ) {
        if (category != null && excludedCategory != null) {
            return ResponseEntity.badRequest().build();
        }
        ArrayList<Expense> expenses = new ArrayList<>();
        List<SettlementRow> rows = repository.findAll();
        if (category == null && excludedCategory == null) {
            for (SettlementRow row : rows) {
                expenses.add(new Expense(row.getId(), row.getKategoria(), row.getKoszt(), Character.toString(row.getKto())));
            }
        } else {
            for (SettlementRow row : rows) {
                if (category != null && category.equals(row.getKategoria())) {
                    expenses.add(new Expense(row.getId(), row.getKategoria(), row.getKoszt(), Character.toString(row.getKto())));
                }
                if (excludedCategory != null && !excludedCategory.equals(row.getKategoria())) {
                    expenses.add(new Expense(row.getId(), row.getKategoria(), row.getKoszt(), Character.toString(row.getKto())));
                }

            }
        }
        return ResponseEntity.ok().body(new ExpensesOutput(expenses));
    }

}
