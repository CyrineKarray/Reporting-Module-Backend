package com.example.demo.controllers;


import com.example.demo.entities.Bailleur;
import com.example.demo.services.BailleurService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bailleur")
public class BailleurController {
    private final BailleurService bailleurService;

    @Autowired
    public BailleurController(BailleurService bailleurService) {
        this.bailleurService = bailleurService;
    }

    @GetMapping
    public List<Bailleur> getBailleurs(){
        return bailleurService.getbailleurs();
    }

    @GetMapping(path = "{bailleurId}")
    Bailleur getBailleur(@PathVariable Long bailleurId) {
        return bailleurService.getBailleur(bailleurId);
    }


    @PostMapping
    public void registerNewBailleur(@RequestBody Bailleur bailleur){
        bailleurService.addNewBailleur(bailleur);
    }


    @DeleteMapping("{id}")
    public void DeleteBailleurById(@PathVariable Long id) {
        bailleurService.deleteBailleur(id);
    }


    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return bailleurService.exportReport(format);
    }

    @GetMapping(path="/link/{financementId}/{bailleurId}")
    public void linkNewFinancementToBailleur(@PathVariable("financementId") Long financementId, @PathVariable("bailleurId") Long bailleurId){
        bailleurService.linkNewFinancementToBailleur(financementId, bailleurId);
    }




    @PutMapping(path="{id}")
    public void updateBailleur(
            @PathVariable("id") Long id,
            @RequestBody Bailleur bailleurUpdate
    ){
        bailleurService.updateBailleur(id,bailleurUpdate);
    }
}
