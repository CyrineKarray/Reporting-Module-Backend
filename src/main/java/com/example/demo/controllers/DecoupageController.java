package com.example.demo.controllers;

import com.example.demo.entities.Decoupage;
import com.example.demo.services.DecoupageService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/decoupage")
public class DecoupageController {


    private final DecoupageService decoupageService;

    @Autowired
    public DecoupageController(DecoupageService decoupageService){
        this.decoupageService=decoupageService;
    }

    @GetMapping
    public List<Decoupage> getdecoupages(){
        return decoupageService.getDecoupages();
    }

    @GetMapping(path = "{decoupageId}")
    Decoupage getdecoupage(@PathVariable Long decoupageId) {
        return decoupageService.getDecoupage(decoupageId);
    }


    @PostMapping
    public Decoupage registerNewdecoupage(@Valid @RequestBody Decoupage decoupage, BindingResult bindingResult){
        decoupageService.addNewDecoupage(decoupage,bindingResult);
        return decoupage;
    }

    @DeleteMapping("{id}")
    public void DeletedecoupageById(@PathVariable Long id) {
        decoupageService.DeleteDecoupage(id);
    }

    @PutMapping(path="{decoupageId}")
    public void updatedecoupage(
            @PathVariable("decoupageId") Long decoupageId,
            @RequestBody Decoupage decoupageUpdate
    ){
        decoupageService.updateDecoupage(decoupageId, decoupageUpdate);
    }


    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return decoupageService.exportReport(format);
    }
}
