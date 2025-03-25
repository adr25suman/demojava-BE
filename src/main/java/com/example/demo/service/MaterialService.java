package com.example.demo.service;


import com.example.demo.repository.MaterialRepository;
import com.example.demo.usermodel.Material;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<Material> getMaterials(){
        return materialRepository.findAll();

    }

    public Material getMaterial(Long id) { return materialRepository.findById(id).orElse( null); }

    public Material addMaterial(Material material) {
        return materialRepository.save(material);
    }


    public Material updateMaterial(Material material) {
        return materialRepository.save(material);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }

}
