package com.example.hospital.controller;

import com.example.hospital.dto.DiseaseDTO;
import com.example.hospital.entity.Disease;
import com.example.hospital.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    //Post Method
    @PostMapping("/post")
    public DiseaseDTO addDisease(@RequestBody DiseaseDTO disease){
        return diseaseService.addDisease(disease);
    }
    @PostMapping("/createList")
    public List<Disease> saveDisease(@RequestBody List<Disease> Disease){
        return diseaseService.saveAllDetails(Disease);
    }

    //read method
    @GetMapping("/get")
    public Page<Disease> listAllDetails(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                            @RequestParam(value = "sortBy",defaultValue = "id") String sortBy){
        return diseaseService.listAllDetails(pageNo,pageSize,sortBy);
    }
    //read method by ID
    @GetMapping("/getById/{id}")
    public Disease getDiseaseDetailsByID(@PathVariable long id){
        return diseaseService.getDiseaseDetailsByID(id);
    }


    @PutMapping("/update")
    public Disease updateDiseaseDetails(@RequestBody DiseaseDTO disease) {
        return diseaseService.updateDetailsById(disease);
    }



    @DeleteMapping("/delete/{id}")
    public String deleteDisease(@PathVariable long id){
        return diseaseService.deleteDetailsById(id);
    }

}


