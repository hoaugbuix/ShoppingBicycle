package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.PostEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.DuplicateRecordException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreatePostReq;
import com.hoangbuix.bicycle.model.request.update.UpdatePostReq;
import com.hoangbuix.bicycle.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*")
public class ManagementPostController {
    @Autowired
    private PostService postService;

    @PostMapping("create-post")
    private ResponseEntity<?> create(@Valid @RequestBody CreatePostReq req) {
        int id = 0;
        PostEntity result = null;
        try {
            PostEntity post = postService.findByTitle(req.getTitle());
            if (post != null) {
                throw new DuplicateRecordException("Đã tồn tại");
            } else {
                id = postService.save(req);
                result = postService.findById(id);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            throw new BadRequestException("lỗi crete");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("update-post/{id}")
    private ResponseEntity<?> update(@Valid @RequestBody UpdatePostReq req, @PathVariable("id") int id) {
        PostEntity post = postService.findById(id);
        if (post.getTitle().equals(req.getTitle())) {
            throw new DuplicateRecordException("Dup rồi");
        } else {
            postService.update(req, post.getId());
        }
        return new ResponseEntity<>("Update Success!", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> getAll() {
        List<PostEntity> posts = postService.findAll();
        if (posts.isEmpty()) {
            throw new NotFoundException("kkkk");
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("get-id/{id}")
    private ResponseEntity<?> getId(int id) {
        PostEntity post = postService.findById(id);
        if (post.getId() == null) {
            throw new NotFoundException("0");
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
