package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.OrderEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.DuplicateRecordException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateOrderReq;
import com.hoangbuix.bicycle.model.request.update.UpdateOrderReq;
import com.hoangbuix.bicycle.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class ManagementOrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("create-order")
    private ResponseEntity<?> create(@Valid @RequestBody CreateOrderReq req) {
        int id = 0;
        OrderEntity order = null;
        try {
//            OrderEntity brn = orderService.findByBrandName(brand.getBrandName());
            if (order != null) {
                throw new DuplicateRecordException("Đã tồn tại");
            } else {
                id = orderService.save(req);
                order = orderService.findById(id);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            throw new BadRequestException("lỗi crete");
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("update-order/{id}")
    private ResponseEntity<?> update(@Valid @RequestBody UpdateOrderReq req, @PathVariable("id") int id) {
        OrderEntity order = orderService.findById(id);
//        if (order.getBrandName().equals(req.getBrandName())) {
//            throw new DuplicateRecordException("Dup rồi");
//        } else {
        orderService.update(req);
//        }
        return new ResponseEntity<>("Update Success!", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> getAll() {
        List<OrderEntity> order = orderService.findAll();
        if (order.isEmpty()) {
            throw new NotFoundException("kkkk");
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("get-id/{id}")
    private ResponseEntity<?> getId(int id) {
        OrderEntity order = orderService.findById(id);
        if (order.getId() == null) {
            throw new NotFoundException("0");
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
