package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.CategoryEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class ManagementCategoryController {
    final Logger log = Logger.getLogger(ManagementCategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        log.info("get All");
        List<CategoryEntity> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            throw new NotFoundException("Không tồn tại thể loại sản phẩm nào");
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    private ResponseEntity<?> findById(@PathVariable("id") int id) {
        log.info("find by id" + id);
        CategoryEntity cate = categoryService.findById(id);
        if (cate.getId() == 0) {
            throw new NotFoundException("Category không tồn tại!");
        }
        return new ResponseEntity<>(cate, HttpStatus.OK);
    }

    @PostMapping("/create-category")
    private ResponseEntity<?> createCategory(@Valid @RequestBody CategoryEntity cate) {
        int id = categoryService.save(cate);
        if (id == 0) {
            throw new BadRequestException("Tạo mới category thất bại!");
        }
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/category-update")
    private ResponseEntity<?> update(@Valid @RequestBody CategoryEntity cate) {
        try {
            categoryService.update(cate);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return ResponseEntity.ok().body("update success!");
    }

    @PostMapping("delete-category/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") int id) {
        log.info("delete " + id);
        try {
            categoryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return ResponseEntity.ok().body("delete success");
    }
}
