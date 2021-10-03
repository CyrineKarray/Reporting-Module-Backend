package com.example.demo.services;

import com.example.demo.entities.Indicateur;
import com.example.demo.repositories.IndicateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service(value = "indicateurService")
public class IndicateurService {

    private final IndicateurRepository indicateurRepository;

    public IndicateurService(IndicateurRepository indicateurRepository) {
        this.indicateurRepository = indicateurRepository;
    }

    public List<Indicateur> getIndicateurs() {
        return indicateurRepository.findAll();
    }

    public Indicateur getIndicateur(Long id) {
        Indicateur indicateur = getIndicateurs().stream().filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return indicateur;
    }

    public void DeleteIndicateur(Long id) {
        Optional<Indicateur> indicateurId = indicateurRepository.findById(id);
        if(!indicateurId.isPresent()){
            throw new IllegalStateException("indicateur does not exist");
        }
    //    indicateurId.get().setOrganisme(null);
        indicateurRepository.deleteById(id);
    }

    public void addNewIndicateur(Indicateur indicateur, BindingResult bindingResult) {
        Optional<Indicateur>indicateurOptional = indicateurRepository.findIndicateurByCode(indicateur.getCode());
        if (indicateurOptional.isPresent()){
            throw new IllegalStateException("title is taken");
        }
        if(bindingResult.hasErrors()){
            throw new IllegalStateException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        indicateurRepository.save(indicateur);
    }

    public void updateIndicateur(Long indicateurId, Indicateur indicateurUpdate) {
        Indicateur indicateur = indicateurRepository.findById(indicateurId).orElseThrow(()-> new IllegalStateException(
                "indicateur with id " + indicateurId + " does not exist"));

        if (indicateurUpdate.getCode()!=null &&
                !Objects.equals(indicateur.getCode(), indicateurUpdate.getCode())){
            indicateur.setCode(indicateurUpdate.getCode());
        }
        if (indicateurUpdate.getDesignation()!=null &&
                indicateur.getDesignation().toString().length() > 0 &&
                !Objects.equals(indicateur.getDesignation(), indicateurUpdate.getDesignation())){
            indicateur.setDesignation(indicateurUpdate.getDesignation());
        }

        if (indicateurUpdate.getFrequence()!=null &&
                !Objects.equals(indicateur.getFrequence(), indicateurUpdate.getFrequence())){
            indicateur.setFrequence(indicateurUpdate.getFrequence());
        }

        if (indicateurUpdate.getMethodologie()!=null &&
                !Objects.equals(indicateur.getMethodologie(), indicateurUpdate.getMethodologie())){
            indicateur.setMethodologie(indicateurUpdate.getMethodologie());
        }

        if (indicateurUpdate.getHypothese()!=null &&
                !Objects.equals(indicateur.getHypothese(), indicateurUpdate.getHypothese())){
            indicateur.setHypothese(indicateurUpdate.getHypothese());
        }


        if (indicateurUpdate.getFormule()!=null &&
                indicateurUpdate.getFormule().toString().length() > 0 &&
                !Objects.equals(indicateurUpdate.getFormule(), indicateurUpdate.getFormule())){
            indicateur.setFormule(indicateurUpdate.getFormule());
        }

        if (indicateurUpdate.getResp_collecte()!=null &&
                indicateurUpdate.getResp_collecte().toString().length() > 0 &&
                !Objects.equals(indicateur.getResp_collecte(), indicateurUpdate.getResp_collecte())){
            indicateur.setResp_collecte(indicateurUpdate.getResp_collecte());
        }

        if (indicateurUpdate.getResp_synthese()!=null &&
                !Objects.equals(indicateur.getResp_synthese(), indicateurUpdate.getResp_synthese())){
            indicateur.setResp_synthese(indicateurUpdate.getResp_synthese());
        }

        if (indicateurUpdate.getSource_donnees()!=null &&
                !Objects.equals(indicateur.getSource_donnees(), indicateurUpdate.getSource_donnees())){
            indicateur.setSource_donnees(indicateurUpdate.getSource_donnees());
        }


        if (indicateurUpdate.getNature()!=null &&
                indicateurUpdate.getNature().toString().length() > 0 &&
                !Objects.equals(indicateurUpdate.getNature(), indicateurUpdate.getNature())){
            indicateur.setNature(indicateurUpdate.getNature());
        }

        if (indicateurUpdate.getDefinition()!=null &&
                indicateurUpdate.getDefinition().toString().length() > 0 &&
                !Objects.equals(indicateur.getDefinition(), indicateurUpdate.getDefinition())){
            indicateur.setDefinition(indicateurUpdate.getDefinition());
        }

        if (indicateurUpdate.getOrigine()!=null &&
                !Objects.equals(indicateur.getOrigine(), indicateurUpdate.getOrigine())){
            indicateur.setOrigine(indicateurUpdate.getOrigine());
        }

        if (indicateurUpdate.getRisque()!=null &&
                !Objects.equals(indicateur.getRisque(), indicateurUpdate.getRisque())){
            indicateur.setRisque(indicateurUpdate.getRisque());
        }

        indicateurRepository.save(indicateur);
    }
}
