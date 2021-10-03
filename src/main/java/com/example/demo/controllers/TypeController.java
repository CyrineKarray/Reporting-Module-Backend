package com.example.demo.controllers;

import com.example.demo.services.TypeService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Type;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/type")
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<Type> gettypes(){
        return typeService.getTypes();
    }

    @PostMapping
    public void registerNewType(@RequestBody Type type){
        typeService.addNewType(type);
    }

    public void deletetype(@PathVariable("typeId") Long typeId){
        typeService.deleteType(typeId);
    }

    public void updatetype(
            @PathVariable("typeId") Long typeId,
            @RequestBody Type typeUpdate
    ){
        typeService.updateType(typeId, typeUpdate);
    }
}
