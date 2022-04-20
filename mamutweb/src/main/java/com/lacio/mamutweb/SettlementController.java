package com.lacio.mamutweb;

import com.lacio.mamutweb.entities.SettlementRow;
import com.lacio.mamutweb.jsondata.MamutOutput;
import com.lacio.mamutweb.jsondata.SettlementOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettlementController {
    private final SettlementRowRepository repository;


    public SettlementController(SettlementRowRepository repository) {
        this.repository = repository;

    }

    @GetMapping("/settlement")
    public MamutOutput output() {

        try (MamutCalculations calculations = new MamutCalculations()) {
            List<SettlementRow> rows = repository.findAll();

            for (SettlementRow row : rows) {
                calculations.addCashToInvestor(row);
            }

            SettlementOutput settlementOutput = new SettlementOutput(
                    calculations.settle().getWho(),
                    calculations.settle().getWhom(),
                    calculations.settle().getHowMuch()
            );

            MamutOutput output = new MamutOutput(
                    calculations.getTotal(),
                    calculations.getCashForInvestor("P"),
                    calculations.getCashForInvestor("B"),
                    settlementOutput
            );
            return output;
        }
    }
}
