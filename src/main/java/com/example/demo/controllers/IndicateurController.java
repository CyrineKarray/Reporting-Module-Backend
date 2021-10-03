package com.example.demo.controllers;

import com.example.demo.entities.Indicateur;
import com.example.demo.services.IndicateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/indicateur")
public class IndicateurController {

    private final IndicateurService indicateurService;

    @Autowired
    public IndicateurController(IndicateurService indicateurService) {
        this.indicateurService = indicateurService;
    }

    @GetMapping
    public List<Indicateur> getindicateurs() {
        return indicateurService.getIndicateurs();
    }


    @GetMapping(path = "{indicateurId}")
    Indicateur getindicateur(@PathVariable Long indicateurId) {
        return indicateurService.getIndicateur(indicateurId);
    }

    @PostMapping
    public Indicateur registerNewIndicateur(@Valid @RequestBody Indicateur indicateur, BindingResult bindingResult) {
        indicateurService.addNewIndicateur(indicateur, bindingResult);
        return indicateur;
    }

    @DeleteMapping("{id}")
    public void DeleteIndicateurById(@PathVariable Long id) {
        indicateurService.DeleteIndicateur(id);
    }


    @PutMapping(path = "{indicateurId}")
    public void updateIndicateur(
            @PathVariable("indicateurId") Long indicateurId,
            @RequestBody Indicateur indicateurUpdate
    ) {
        indicateurService.updateIndicateur(indicateurId, indicateurUpdate);
    }
}
