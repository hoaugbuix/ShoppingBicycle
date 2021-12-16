package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.ProductSizeEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateProductSizeReq;
import com.hoangbuix.bicycle.service.ProductSizeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product-size")
@CrossOrigin(origins = "*")
public class ManagementProductSizeController {
    final Logger log = Logger.getLogger(ManagementProductSizeController.class);
    @Autowired
    private ProductSizeService productSizeService;


    @PostMapping("/create-product-size")
    private ResponseEntity<?> create(@Valid @RequestBody CreateProductSizeReq product) {
        int id = 0;
        try {
            id = productSizeService.save(product);
            if (id <= 0) {
                throw new BadRequestException("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(productSizeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> getAll() {
        List<ProductSizeEntity> products = productSizeService.findAll();
        if (products.isEmpty()) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("get-id/{id}")
    private ResponseEntity<?> getById(@PathVariable("id") int id) {
        ProductSizeEntity product = productSizeService.findById(id);
        if (product == null) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("get-quantity/{quantity}")
    private ResponseEntity<?> getByQuantity(int quantity) {
        ProductSizeEntity product = productSizeService.findByQuantity(quantity);
        if (product == null) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("get-quantity/{size}")
    private ResponseEntity<?> getBySize(int size) {
        ProductSizeEntity product = productSizeService.findBySize(size);
        if (product == null) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
