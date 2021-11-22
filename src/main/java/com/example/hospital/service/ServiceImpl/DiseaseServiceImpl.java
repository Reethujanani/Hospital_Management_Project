package com.example.hospital.service.ServiceImpl;

import com.example.hospital.dto.DiseaseDTO;
import com.example.hospital.entity.Disease;
import com.example.hospital.repository.DiseaseRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.DiseaseService;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DiseaseServiceImpl implements DiseaseService {

    private static final Logger LOGGER = null;
    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public DiseaseDTO addDisease(DiseaseDTO diseaseDTO) {

        Disease disease = new Disease();

        try {
            disease.setDiseaseName(disease.getDiseaseName());
            disease.setIsActive(disease.getIsActive());
            disease.setIsDeleted(disease.getIsDeleted());
            disease.setCreatedAt(disease.getCreatedAt());
            disease.setModifiedAt(disease.getModifiedAt());
            diseaseRepository.save(disease);
        }catch (Exception e){
            e.getMessage();
        }
        return diseaseDTO;
    }



    @Override
    public Page<Disease> listAllDetails(int pageNo , int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<Disease> Disease = diseaseRepository.findAll(pageable);
        LOGGER.info("disease saved successfully");
        return Disease;
    }



    @Override
    public Disease getDiseaseDetailsByID(Long id) {
        Optional<Disease> disease = diseaseRepository.findById(id);
        return disease.get();
    }

    @Override
    public List<Disease> saveAllDetails(List<Disease> diseases) {
        return null;
    }


    @Override
    public String deleteDetailsById(Long id) {
        diseaseRepository.deleteById(id);
        return "Successfully deleted";
    }

    @Override
    public Disease updateDetailsById(DiseaseDTO diseaseDTO) {
        Disease disease = new Disease();

        try {
            disease.setDiseaseName(disease.getDiseaseName());
            disease.setIsActive(diseaseDTO.getIsActive());
            disease.setIsDeleted(diseaseDTO.getIsDeleted());
            disease.setCreatedAt(diseaseDTO.getCreatedAt());
            disease.setModifiedAt(diseaseDTO.getModifiedAt());
            diseaseRepository.save(disease);
        }catch (Exception e){
            e.getMessage();
        }
        return disease;
    }


}



