package com.hoangbuix.bicycle.controller.anonymus;

import com.hoangbuix.bicycle.entity.ProductEntity;
import com.hoangbuix.bicycle.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-view")
@CrossOrigin(origins = "*")
public class ProductController {
    final Logger log = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProduct")
    private ResponseEntity<?> getAllProduct() {
        List<ProductEntity> lstProduct = productService.findAll();
        return new ResponseEntity<>(lstProduct, HttpStatus.OK);
    }


    @GetMapping("/getProductById")
    private ResponseEntity<?> getProductByID(@PathVariable("id") int id) {
        ProductEntity product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


}
