package com.example.demo.services;


import com.example.demo.entities.Parametre;
import com.example.demo.repositories.ParametreRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service(value = "parametreService")
public class ParametreService {
    private final ParametreRepository parametreRepository;

    public ParametreService(ParametreRepository parametreRepository) {
        this.parametreRepository = parametreRepository;
    }

    public List<Parametre> getParametres() {
        return parametreRepository.findAll();
    }


    public Parametre getParametre(Long id) {
        Parametre parametre = getParametres().stream().filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return parametre;
    }

    public void DeleteParametre(Long id) {
        Optional<Parametre> parametreId = parametreRepository.findById(id);
        if(!parametreId.isPresent()){
            throw new IllegalStateException("parametre does not exist");
        }
       // parametreId.get().setDomain(null);
        parametreRepository.deleteById(id);
    }

    public void addNewParametre(Parametre parametre, BindingResult bindingResult) {
        parametreRepository.save(parametre);
    }


    public void updateParametre(Long parametreId, Parametre parametreUpdate) {
        Parametre parametre = parametreRepository.findById(parametreId).orElseThrow(()-> new IllegalStateException(
                "parametre with id " + parametreId + " does not exist"));

        if (parametreUpdate.getValeur()!=0 &&
                !Objects.equals(parametre.getValeur(), parametreUpdate.getValeur())){
            parametre.setValeur(parametreUpdate.getValeur());
        }
        parametreRepository.save(parametre);
    }

}
