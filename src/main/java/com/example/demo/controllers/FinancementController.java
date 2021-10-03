package com.example.demo.controllers;

import com.example.demo.entities.Financement;
import com.example.demo.services.FinancementService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/financement")
public class FinancementController {
    private final FinancementService financementService;

    @Autowired
    public FinancementController(FinancementService financementService) {
        this.financementService = financementService;
    }

    @GetMapping
    public List<Financement> getFinancements(){
        return financementService.getfinancements();
    }

    @GetMapping(path = "{financementId}")
    Financement getfinancement(@PathVariable Long financementId) {
        return financementService.getFinancement(financementId);
    }

    @PostMapping
    public void registerNewFinancement(@RequestBody Financement financement){
        financementService.addNewFinancement(financement);
    }

    @DeleteMapping("{id}")
    public void DeleteFinancementById(@PathVariable Long id) {
        financementService.DeleteFinancement(id);
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return financementService.exportReport(format);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public long countEntities() {
        long count = financementService.getCountOfEntities();
        return count;
    }
}
