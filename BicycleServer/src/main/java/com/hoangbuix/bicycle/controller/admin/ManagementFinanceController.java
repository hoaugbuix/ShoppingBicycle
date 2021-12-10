package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.FinanceEntity;
import com.hoangbuix.bicycle.entity.ProductSizeEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateFinanceReq;
import com.hoangbuix.bicycle.model.request.create.CreateProductSizeReq;
import com.hoangbuix.bicycle.model.request.update.UpdateFinanceReq;
import com.hoangbuix.bicycle.service.FinanceService;
import com.hoangbuix.bicycle.service.ProductSizeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/finance")
public class ManagementFinanceController {
    final Logger log = Logger.getLogger(ManagementFinanceController.class);
    @Autowired
    private FinanceService financeService;


    @PostMapping("/create-finance")
    private ResponseEntity<?> create(@Valid @RequestBody CreateFinanceReq req) {
        int id = 0;
        try {
            id = financeService.save(req);
            if (id <= 0) {
                throw new BadRequestException("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(financeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> getAll() {
        List<FinanceEntity> finances = financeService.findAll();
        if (finances.isEmpty()) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(finances, HttpStatus.OK);
    }

    @GetMapping("get-id/{id}")
    private ResponseEntity<?> getById(@PathVariable("id") int id) {
        FinanceEntity finance = financeService.findById(id);
        if (finance == null) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(finance, HttpStatus.OK);
    }

    @GetMapping("get-quantity/{amount}")
    private ResponseEntity<?> getByAmount(int amount) {
        FinanceEntity finance = financeService.findByAmount(amount);
        if (finance == null) {
            throw new NotFoundException("");
        }
        return new ResponseEntity<>(finance, HttpStatus.OK);
    }

}
