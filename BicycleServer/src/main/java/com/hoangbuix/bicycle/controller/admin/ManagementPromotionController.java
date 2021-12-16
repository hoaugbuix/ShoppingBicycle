package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.PromotionEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreatePromotionReq;
import com.hoangbuix.bicycle.model.request.update.UpdatePromotionReq;
import com.hoangbuix.bicycle.service.PromotionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/promotion")
@CrossOrigin(origins = "*")
public class ManagementPromotionController {
    final Logger log = Logger.getLogger(ManagementPromotionController.class);

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        log.info("get All");
        List<PromotionEntity> promotion = promotionService.findAll();
        if (promotion.isEmpty()) {
            throw new NotFoundException("Không tồn tại nào");
        }
        return new ResponseEntity<>(promotion, HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    private ResponseEntity<?> findById(@PathVariable("id") int id) {
        log.info("find by id" + id);
        PromotionEntity promotion = promotionService.findById(id);
        if (promotion.getId() == 0) {
            throw new NotFoundException("không tồn tại!");
        }
        return new ResponseEntity<>(promotion, HttpStatus.OK);
    }

    @PostMapping("/create-promotion")
    private ResponseEntity<?> create(@Valid @RequestBody CreatePromotionReq req) {
        int id = promotionService.save(req);
        if (id == 0) {
            throw new BadRequestException("Tạo mới thất bại!");
        }
        return new ResponseEntity<>(promotionService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/update-promotion")
    private ResponseEntity<?> update(@Valid @RequestBody UpdatePromotionReq req) {
        try {
            promotionService.update(req);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return ResponseEntity.ok().body("update success!");
    }

    @PostMapping("/delete-promotion/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") int id) {
        log.info("delete " + id);
        try {
            promotionService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return ResponseEntity.ok().body("delete success");
    }
}
