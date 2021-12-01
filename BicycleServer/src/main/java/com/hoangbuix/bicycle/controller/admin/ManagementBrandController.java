package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class ManagementBrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/get-all")
    private ResponseEntity<?> getAll(){
        List<BrandEntity> brands = brandService.findAll();
        if (brands.isEmpty()){
            throw new NotFoundException("kkkk");
        }
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }
}
