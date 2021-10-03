package com.example.demo.services;

import com.example.demo.entities.Type;
import com.example.demo.entities.Unite;
import com.example.demo.repositories.UniteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service(value = "uniteService")
public class UniteService {

    private final UniteRepository uniteRepository;

    public UniteService(UniteRepository uniteRepository) {
        this.uniteRepository = uniteRepository;
    }



    public List<Unite> getUnites() {
        return uniteRepository.findAll();
    }


    public void deleteUnite(Long uniteId) {
        uniteRepository.findById(uniteId);
        boolean exists= uniteRepository.existsById(uniteId);
        if(!exists){
            throw new IllegalStateException("unite indicateur avec unite " + uniteId + " n existe pas.");
        }
        uniteRepository.deleteById(uniteId);
    }

    @Transactional
    public void updateUnite(Long uniteId, Unite uniteUpdate) {
        Unite unite = uniteRepository.findById(uniteId).orElseThrow(()-> new IllegalStateException(
                "unite with id " + uniteId + " does not exist"));

        if (uniteUpdate.getDesignation()!=null &&
                uniteUpdate.getDesignation().toString().length() > 0 &&
                !Objects.equals(unite.getDesignation(), uniteUpdate.getDesignation())){
            unite.setDesignation(uniteUpdate.getDesignation());
        }
    }

}
