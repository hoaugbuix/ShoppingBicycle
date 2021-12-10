package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.DuplicateRecordException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateBrandReq;
import com.hoangbuix.bicycle.model.request.update.UpdateBrandReq;
import com.hoangbuix.bicycle.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class ManagementBrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("create-brand")
    private ResponseEntity<?> create(@Valid @RequestBody CreateBrandReq brand) {
        int id = 0;
        BrandEntity brnd = null;
        try {
            BrandEntity brn = brandService.findByBrandName(brand.getBrandName());
            if (brn != null) {
                throw new DuplicateRecordException("Đã tồn tại");
            } else {
                id = brandService.save(brand);
                brnd = brandService.findById(id);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            throw new BadRequestException("lỗi crete");
        }
        return new ResponseEntity<>(brnd, HttpStatus.OK);
    }

    @PostMapping("update-brand/{id}")
    private ResponseEntity<?> update(@Valid @RequestBody UpdateBrandReq brand, @PathVariable("id") int id) {
        BrandEntity brn = brandService.findById(id);
        if (brn.getBrandName().equals(brand.getBrandName())) {
            throw new DuplicateRecordException("Dup rồi");
        } else {
            brandService.update(brand, brn.getId());
        }
        return new ResponseEntity<>("Update Success!", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> getAll() {
        List<BrandEntity> brands = brandService.findAll();
        if (brands.isEmpty()) {
            throw new NotFoundException("kkkk");
        }
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @GetMapping("get-id/{id}")
    private ResponseEntity<?> getId(int id) {
        BrandEntity brand = brandService.findById(id);
        if (brand.getId() == null) {
            throw new NotFoundException("0");
        }
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }
}
