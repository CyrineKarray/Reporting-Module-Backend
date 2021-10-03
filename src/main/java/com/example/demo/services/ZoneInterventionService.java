/*  package com.example.demo.services;

import com.example.demo.entities.ZoneIntervention;
import com.example.demo.repositories.ZoneInterventionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service(value = "zoneInterventionService")
public class ZoneInterventionService {
    private final ZoneInterventionRepository zoneInterventionRepository;

    public ZoneInterventionService(ZoneInterventionRepository zoneInterventionRepository) {
        this.zoneInterventionRepository = zoneInterventionRepository;
    }

    public List<ZoneIntervention> getZoneInterventions() {
        return zoneInterventionRepository.findAll();
    }


    public void deleteZoneIntervention(Long id) {
        Optional<ZoneIntervention> zoneInterventionId = zoneInterventionRepository.findById(id);
        if(!zoneInterventionId.isPresent()){
            throw new IllegalStateException("zoneIntervention does not exist");
        }
       // zoneInterventionId.get().setOrganisme(null);
        zoneInterventionRepository.deleteById(id);
    }


    public void addNewZoneIntervention(ZoneIntervention zoneIntervention, BindingResult bindingResult) {
        Optional<ZoneIntervention> zoneInterventionOptional = zoneInterventionRepository.findZoneInterventionByCode(zoneIntervention.getCode());
        if (zoneInterventionOptional.isPresent()){
            throw new IllegalStateException("code est déjà pris");
        }
        if(bindingResult.hasErrors()){
            throw new IllegalStateException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        zoneInterventionRepository.save(zoneIntervention);
    }

    public ZoneIntervention getZoneIntervention(Long id) {
        ZoneIntervention zoneIntervention = getZoneInterventions().stream().filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return zoneIntervention;
    }

    public void updateZoneIntervention(Long zoneInterventionId, ZoneIntervention zoneInterventionUpdate) {
        ZoneIntervention zoneIntervention = zoneInterventionRepository.findById(zoneInterventionId).orElseThrow(()-> new IllegalStateException(
                "zoneIntervention with id " + zoneInterventionId + " does not exist"));

        if (zoneInterventionUpdate.getCode()!=null &&
                !Objects.equals(zoneIntervention.getCode(), zoneInterventionUpdate.getCode())){
            zoneIntervention.setCode(zoneInterventionUpdate.getCode());
        }
        if (zoneInterventionUpdate.getDescription()!=null &&
                zoneIntervention.getDescription().length() > 0 &&
                !Objects.equals(zoneIntervention.getDescription(), zoneInterventionUpdate.getDescription())){
            zoneIntervention.setDescription(zoneInterventionUpdate.getDescription());
        }

        if (zoneInterventionUpdate.getSurface()!=null &&
                !Objects.equals(zoneIntervention.getSurface(), zoneInterventionUpdate.getSurface())){
            zoneIntervention.setSurface(zoneInterventionUpdate.getSurface());
        }

        zoneInterventionRepository.save(zoneIntervention);

    }


}
*/