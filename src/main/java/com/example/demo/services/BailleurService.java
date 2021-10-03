package com.example.demo.services;


import com.example.demo.entities.Bailleur;
import com.example.demo.entities.Financement;
import com.example.demo.repositories.BailleurRepository;
import com.example.demo.repositories.FinancementRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.management.JMRuntimeException;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service(value = "bailleurService")
public class BailleurService {

    private final BailleurRepository bailleurRepository;
    private final FinancementRepository financementRepository;

    @Autowired
    public BailleurService(BailleurRepository bailleurRepository, FinancementRepository financementRepository) {
        this.bailleurRepository = bailleurRepository;
        this.financementRepository = financementRepository;
    }

    public List<Bailleur> getbailleurs() {
        return bailleurRepository.findAll();
    }


    public void addNewBailleur(Bailleur bailleur) {
        Optional<Bailleur> bailleurOptional = bailleurRepository.findBailleurByCode(bailleur.getCode());
        if (bailleurOptional.isPresent()){
            throw new IllegalStateException("Code already exists");
        }
        bailleurRepository.save(bailleur);
    }


    public void deleteBailleur(Long bailleurId) {
       bailleurRepository.findById(bailleurId);
        boolean exists= bailleurRepository.existsById(bailleurId);
        if(!exists){
            throw new IllegalStateException("Bailleur Profile with id " + bailleurId + " does not exists");
        }
        bailleurRepository.deleteById(bailleurId);
    }

    @Transactional
    public void updateBailleur(Long bailleurId, Bailleur bailleurUpdate) {
        Bailleur bailleur = bailleurRepository.findById(bailleurId).orElseThrow(()-> new IllegalStateException(
                "bailleur with id " + bailleurId + " does not exist"));

        if (bailleurUpdate.getCode()!=null &&
                !Objects.equals(bailleur.getCode(), bailleurUpdate.getCode())){
            bailleur.setCode(bailleurUpdate.getCode());
        }
        if (bailleurUpdate.getIntitule()!=null &&
                bailleurUpdate.getIntitule().toString().length() > 0 &&
                !Objects.equals(bailleur.getIntitule(), bailleurUpdate.getIntitule())){
            bailleur.setIntitule(bailleurUpdate.getIntitule());
        }
        if (bailleurUpdate.getAdresse()!=null &&
                bailleurUpdate.getAdresse().toString().length() > 0 &&
                !Objects.equals(bailleur.getAdresse(), bailleurUpdate.getAdresse())){
            bailleur.setAdresse(bailleurUpdate.getAdresse());
        }
        if (bailleurUpdate.getVille()!=null &&
                bailleurUpdate.getVille().toString().length() > 0 &&
                !Objects.equals(bailleur.getVille(), bailleurUpdate.getVille())){
            bailleur.setVille(bailleurUpdate.getVille());
        }
        if (bailleurUpdate.getTelephone()!=null &&
                bailleurUpdate.getTelephone().toString().length() > 0 &&
                !Objects.equals(bailleur.getTelephone(), bailleurUpdate.getTelephone())){
            bailleur.setTelephone(bailleurUpdate.getTelephone());
        }
        if (bailleurUpdate.getFax()!=null &&
                bailleurUpdate.getFax().toString().length() > 0 &&
                !Objects.equals(bailleur.getFax(), bailleurUpdate.getFax())){
            bailleur.setFax(bailleurUpdate.getFax());
        }
        if (bailleurUpdate.getEmail()!=null &&
                bailleurUpdate.getEmail().toString().length() > 0 &&
                !Objects.equals(bailleur.getEmail(), bailleurUpdate.getEmail())){
            bailleur.setEmail(bailleurUpdate.getEmail());
        }
        if (bailleurUpdate.getSomme_participation()!=null &&
                bailleurUpdate.getSomme_participation().toString().length() > 0 &&
                !Objects.equals(bailleur.getSomme_participation(), bailleurUpdate.getSomme_participation())){
            bailleur.setSomme_participation(bailleurUpdate.getSomme_participation());
        }
    }

    public void linkNewFinancementToBailleur(Long financementId, Long bailleurId) {
        Financement financement = financementRepository.findById(financementId).orElseThrow(()-> new IllegalStateException(
                "financement with id " + financementId + " does not exist"));
        Bailleur bailleur = bailleurRepository.findById(bailleurId).orElseThrow(()-> new IllegalStateException(
                "bailleur with id " + bailleurId + " does not exist"));
        financement.setBailleur(bailleur);
        financementRepository.save(financement);

        Set<Financement> financements = bailleur.getFinancements();
        financements.add(financement);
        bailleur.setFinancements(financements);
        bailleurRepository.save(bailleur);
    }



    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        String path ="D:\\projects";
        List<Bailleur> bailleurs= bailleurRepository.findAll();

        File file = ResourceUtils.getFile("classpath:bailleur.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bailleurs);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("Liste des","bailleurs de fond");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("html")){
                JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\bailleur.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")){
                JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\bailleur.pdf");
        }
        return "report successfully generated in path :"+path;
    }

    public Bailleur getBailleur(Long id) {
        Bailleur bailleur = getbailleurs().stream().filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return bailleur;
    }
}

