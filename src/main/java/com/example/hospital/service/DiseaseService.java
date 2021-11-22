package com.example.hospital.service;

import com.example.hospital.dto.DiseaseDTO;
import com.example.hospital.entity.Disease;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DiseaseService {

    DiseaseDTO addDisease(DiseaseDTO disease);

    Page<Disease> listAllDetails(int pageNo , int pageSize, String sortBy);

    Disease getDiseaseDetailsByID(Long id);

    List<Disease> saveAllDetails(List<Disease> diseases);

    String deleteDetailsById(Long id);

    Disease updateDetailsById(DiseaseDTO disease);

}
