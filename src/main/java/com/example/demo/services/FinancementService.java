package com.example.demo.services;


import com.example.demo.entities.Financement;

import com.example.demo.entities.Financement;
import com.example.demo.repositories.FinancementRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service(value = "financementService")

public class FinancementService {

    private final FinancementRepository financementRepository;

    @Autowired
    public FinancementService(FinancementRepository financementRepository) {
        this.financementRepository = financementRepository;
    }

    public List<Financement> getfinancements() {
        return financementRepository.findAll();
    }

    public Financement getFinancement(Long id) {
        Financement financement = getfinancements().stream().filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return financement;
    }


    public void addNewFinancement(Financement financement) {
        Optional<Financement> financementOptional = financementRepository.findFinancementByCode(financement.getCode());
        if (financementOptional.isPresent()){
            throw new IllegalStateException("Code already exists");
        }
        financementRepository.save(financement);
    }

    public void DeleteFinancement(Long id) {
        Optional<Financement> financementId = financementRepository.findById(id);
        if(!financementId.isPresent()){
            throw new IllegalStateException("financement does not exist");
        }
        financementId.get().setBailleur(null);
        financementRepository.deleteById(id);
    }



    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        String path ="D:\\projects";
        List<Financement> financements= financementRepository.findAll();

        File file = ResourceUtils.getFile("classpath:financement.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(financements);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("Liste des","financements");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\financement.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\financement.pdf");
        }
        return "report successfully generated in path :"+path;
    }

    @Transactional
    public long getCountOfEntities() {
        long count = financementRepository.countFinancement();
        return count;
    }
}

