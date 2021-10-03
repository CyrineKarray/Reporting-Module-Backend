package com.example.demo.services;

import com.example.demo.entities.Decoupage;
import com.example.demo.entities.Financement;
import com.example.demo.repositories.DecoupageRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


@Service(value = "decoupageService")
public class DecoupageService {

        private final DecoupageRepository decoupageRepository;

    public DecoupageService(DecoupageRepository decoupageRepository) {
        this.decoupageRepository = decoupageRepository;
    }


    public List<Decoupage> getDecoupages() {
            return decoupageRepository.findAll();
        }

        public void DeleteDecoupage(Long id) {
            Optional<Decoupage> decoupageId = decoupageRepository.findById(id);
            if(!decoupageId.isPresent()){
                throw new IllegalStateException("decoupage does not exist");
            }
           // decoupageId.get().getObservation()(null);
            decoupageRepository.deleteById(id);
        }

        public void addNewDecoupage(Decoupage decoupage, BindingResult bindingResult) {
            Optional<Decoupage> decoupageOptional = decoupageRepository.findDecoupageByCode(decoupage.getCode());
            if (decoupageOptional.isPresent()){
                throw new IllegalStateException("code is taken");
            }
            if(bindingResult.hasErrors()){
                throw new IllegalStateException(bindingResult.getAllErrors().get(0).getDefaultMessage());
            }
            decoupageRepository.save(decoupage);
        }

        public Decoupage getDecoupage(Long id) {
            Decoupage decoupage = getDecoupages().stream().filter(t -> id.equals(t.getId()))
                    .findFirst()
                    .orElse(null);
            return decoupage;
        }

        public void updateDecoupage(Long decoupageId, Decoupage decoupageUpdate) {
            Decoupage decoupage = decoupageRepository.findById(decoupageId).orElseThrow(()-> new IllegalStateException(
                    "decoupage with id " + decoupageId + " does not exist"));

            if (decoupageUpdate.getDesignation()!=null &&
                    decoupage.getDesignation().length() > 0 &&
                    !Objects.equals(decoupage.getDesignation(), decoupageUpdate.getDesignation())){
                decoupage.setDesignation(decoupageUpdate.getDesignation());
            }
            if (decoupageUpdate.getNiveau()!=null &&
                    !Objects.equals(decoupage.getNiveau(), decoupageUpdate.getNiveau())){
                decoupage.setNiveau(decoupageUpdate.getNiveau());
            }

            if (decoupageUpdate.getdate_deb()!=null &&
                    !Objects.equals(decoupage.getdate_deb(), decoupageUpdate.getdate_deb())){
                decoupage.setdate_deb(decoupageUpdate.getdate_deb());
            }

            if (decoupageUpdate.getdate_fin()!=null &&
                    !Objects.equals(decoupage.getdate_fin(), decoupageUpdate.getdate_fin())){
                decoupage.setdate_fin(decoupageUpdate.getdate_fin());
            }

            if (decoupageUpdate.getBudget()!=null &&
                    decoupageUpdate.getBudget().toString().length() > 0 &&
                    !Objects.equals(decoupage.getBudget(), decoupageUpdate.getBudget())){
                decoupage.setBudget(decoupageUpdate.getBudget());
            }

            if (decoupageUpdate.getObservation()!=null &&
                    decoupageUpdate.getObservation().toString().length() > 0 &&
                    !Objects.equals(decoupageUpdate.getObservation(), decoupageUpdate.getObservation())){
                decoupage.setObservation(decoupageUpdate.getObservation());
            }

            if (decoupageUpdate.getLocalisation()!=null &&
                    decoupage.getLocalisation().length() > 0 &&
                    !Objects.equals(decoupage.getLocalisation(), decoupageUpdate.getLocalisation())){
                decoupage.setLocalisation(decoupageUpdate.getLocalisation());
            }
            if (decoupageUpdate.getCoordinateur()!=null &&
                    decoupage.getCoordinateur().length() > 0 &&
                    !Objects.equals(decoupage.getCoordinateur(), decoupageUpdate.getCoordinateur())){
                decoupage.setCoordinateur(decoupageUpdate.getCoordinateur());
            }

            if (decoupageUpdate.getFacilitation()!=null &&
                    decoupage.getFacilitation().length() > 0 &&
                    !Objects.equals(decoupage.getFacilitation(), decoupageUpdate.getFacilitation())){
                decoupage.setFacilitation(decoupageUpdate.getFacilitation());
            }

            if (decoupageUpdate.getResultat_attendu()!=null &&
                    decoupageUpdate.getResultat_attendu().length() > 0 &&
                    !Objects.equals(decoupage.getResultat_attendu(), decoupageUpdate.getResultat_attendu())){
                decoupage.setResultat_attendu(decoupageUpdate.getResultat_attendu());
            }

            if (decoupageUpdate.getObjectif_global_dev()!=null &&
                    decoupageUpdate.getObjectif_global_dev().toString().length() > 0 &&
                    !Objects.equals(decoupage.getObjectif_global_dev(), decoupageUpdate.getObjectif_global_dev())){
                decoupage.setObjectif_global_dev(decoupageUpdate.getObjectif_global_dev());
            }

            if (decoupageUpdate.getObjectif_global_durable()!=null &&
                    decoupageUpdate.getObjectif_global_durable().toString().length() > 0 &&
                    !Objects.equals(decoupageUpdate.getObjectif_global_durable(), decoupageUpdate.getObjectif_global_durable())){
                decoupage.setObjectif_global_durable(decoupageUpdate.getObjectif_global_durable());
            }
            if (decoupageUpdate.getContexte()!=null &&
                    decoupageUpdate.getContexte().toString().length() > 0 &&
                    !Objects.equals(decoupageUpdate.getContexte(), decoupageUpdate.getContexte())){
                decoupage.setContexte(decoupageUpdate.getContexte());
            }
            decoupageRepository.save(decoupage);
    }


    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        String path ="D:\\projects";
        List<Decoupage> decoupages= decoupageRepository.findAll();

        File file = ResourceUtils.getFile("classpath:decoupage.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(decoupages);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("Liste des","decoupages");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\decoupages.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\decoupages.pdf");
        }
        return "report successfully generated in path :"+path;
    }

}
