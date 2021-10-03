/* package com.example.demo.controllers;


import com.example.demo.entities.ZoneIntervention;
import com.example.demo.services.ZoneInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/zoneintervention")
public class ZoneInterventionController {

    private final ZoneInterventionService zoneInterventionService;

    @Autowired
    public ZoneInterventionController(ZoneInterventionService zoneInterventionService) {
        this.zoneInterventionService = zoneInterventionService;
    }

    @GetMapping
    public List<ZoneIntervention> getZoneInterventions(){
        return zoneInterventionService.getZoneInterventions();
    }


    @PostMapping
    public ZoneIntervention registerNewZoneIntervention(@Valid @RequestBody ZoneIntervention zoneIntervention, BindingResult bindingResult){
        zoneInterventionService.addNewZoneIntervention(zoneIntervention,bindingResult);
        return zoneIntervention;
    }

    @DeleteMapping(path="{zoneInterventionId}")
    public void deletezoneIntervention(@PathVariable("zoneInterventionId") Long zoneInterventionId){
        zoneInterventionService.deleteZoneIntervention(zoneInterventionId);
    }

    @PutMapping(path="{zoneInterventionId}")
    public void updatezoneIntervention(
            @PathVariable("zoneInterventionId") Long zoneInterventionId,
            @RequestBody ZoneIntervention zoneInterventionUpdate
    ){
        zoneInterventionService.updateZoneIntervention(zoneInterventionId, zoneInterventionUpdate);
    }
}
*/