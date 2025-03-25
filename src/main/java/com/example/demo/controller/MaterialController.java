package com.example.demo.controller;


import com.example.demo.service.MaterialService;
import com.example.demo.usermodel.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin // Enables CORS for all endpoints in this controller
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/material")
    public List<Material> getMaterials() {
        return materialService.getMaterials();
    }

    @GetMapping("/material/{id}")
    public Material getMaterial(@PathVariable("id") Long id) {
        return materialService.getMaterial(id); // Fixed incorrect reference
    }

    @PutMapping("/material/{id}")
    public Material updateMaterial(@RequestBody Material material, @PathVariable("id") Long id) {
        return materialService.updateMaterial(material); // Fixed incorrect instance name
    }

    @PostMapping("/material") // Changed from "/materials" for consistency
    public ResponseEntity<Material> addNew(@RequestBody Material material) {
        System.out.println("Title: " + material.getTitle());
        System.out.println("Summary: " + material.getSummary());
        System.out.println("CreatedAt: " + material.getCreatedAt());
        System.out.println("UpdatedAt: " + material.getUpdatedAt());
        System.out.println("Name: " + material.getName());
        Material newMaterial = materialService.addMaterial(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMaterial);
    }

    @DeleteMapping("/material/{id}")
    public void deleteMaterial(@PathVariable("id") Long id) {
        materialService.deleteMaterial(id);
    }
}


///*@RestController
//@RequestMapping("/api")
//@CrossOrigin
//
//public class MaterialController {
//
//    private  MaterialService materialServiceService;
//
//    @Autowired
//    public MaterialController(MaterialService materialService){
//        this.materialServiceService = MaterialService;
//    }
//
//    @GetMapping("/material")
//    @CrossOrigin
//    public List<Material> getMaterials(){
//        return materialService.getMaterials();
//    }
//
//    @GetMapping("/material/{id}")
//    public Material getmaterial(@PathVariable("id") Long id){
//        return MaterialService.getmaterial(id);
//    }
//
//    @PutMapping("/material/{id}")
//    @CrossOrigin
//    public Material updateMaterial(@RequestBody() Material material, @PathVariable("id") Long id){
//        return materialService.updateMaterial(material);
//
//    }
//
//    @PostMapping("/materials")
//    @CrossOrigin
//    public ResponseEntity<Material> addNew(@RequestBody() Material material){
//        Material newmaterial = materialService.addmaterial(material);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newmaterial);
//    }
//
//    @DeleteMapping("/material/{id}")
//    @CrossOrigin
//    public void deletematerial(@PathVariable("id") Long id){
//        materialService.deleteMaterial(id);
//    }

