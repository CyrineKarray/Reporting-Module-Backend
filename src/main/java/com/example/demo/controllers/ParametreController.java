package com.example.demo.controllers;


import com.example.demo.entities.Parametre;
import com.example.demo.services.ParametreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/parametre")
public class ParametreController {

    private final ParametreService parametreService;

    @Autowired
    public ParametreController(ParametreService parametreService){
        this.parametreService=parametreService;
    }

    @GetMapping
    public List<Parametre> getParametres(){
        return parametreService.getParametres();
    }


    @GetMapping(path = "{parametreId}")
    Parametre getParametre(@PathVariable Long parametreId) {
        return parametreService.getParametre(parametreId);
    }

    @PostMapping
    public Parametre registerNewParametre(@Valid @RequestBody Parametre parametre, BindingResult bindingResult){
        parametreService.addNewParametre(parametre,bindingResult);
        return parametre;
    }

    @DeleteMapping("{id}")
    public void DeleteParametreById(@PathVariable Long id) {
        parametreService.DeleteParametre(id);
    }

    @PutMapping(path="{parametreId}")
    public void updateparametre(
            @PathVariable("parametreId") Long parametreId,
            @RequestBody Parametre parametreUpdate
    ){
        parametreService.updateParametre(parametreId, parametreUpdate);
    }
}
