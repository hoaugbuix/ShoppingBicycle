package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.CategoryEntity;
import com.hoangbuix.bicycle.entity.ProductEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.service.CategoryService;
import com.hoangbuix.bicycle.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ManagementProductController {
    final Logger log = Logger.getLogger(ManagementCategoryController.class);
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @PostMapping()
    private ResponseEntity<?> create(@Valid @RequestBody ProductEntity product) {
        int id = 0;
        try {
            CategoryEntity cate = categoryService.findById(product.getCategoryId());
            id = productService.save(product);
            if (id <= 0) {
                throw new BadRequestException("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> getAll() {
        List<ProductEntity> products = productService.findAll();
        if (products.isEmpty()) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("get-id/{id}")
    private ResponseEntity<?> getById(@PathVariable("id") int id) {
        ProductEntity product = productService.findById(id);
        if (product == null) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("getProductName/{productName}")
    private ResponseEntity<?> getByProductName(String productName) {
        ProductEntity product = productService.findByProductName(productName);
        if (product == null) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
