package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.ImageEntity;
import com.hoangbuix.bicycle.entity.UserEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.InternalServerException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.security.CustomUserDetails;
import com.hoangbuix.bicycle.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/image")
public class ManagementImageController {

    @Autowired
    private ImageService imageService;

    private static String UPLOAD_DIR = System.getProperty("user.home") + "/media/upload";

    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        // Create folder to save file if not exist
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        ;
        if (originalFilename != null && originalFilename.length() > 0) {
            if (!extension.equals("png") && !extension.equals("jpg") && !extension.equals("gif") && !extension.equals("svg") && !extension.equals("jpeg")) {
                throw new BadRequestException("Không hỗ trợ định dạng file này");
            }
            try {
                ImageEntity img = new ImageEntity();
                img.setFileName(file.getName());
                img.setSize(file.getSize());
                img.setFileType(extension);
                img.setPostId(1);
                UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
                img.setUploadBy(user.getId());
                String link = "/media/upload/" + img.getFileName() + "." + extension;
                img.setLink(link);

                // Create file
                File serverFile = new File(UPLOAD_DIR + "/" + img.getFileName() + "." + extension);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(file.getBytes());
                stream.close();
                ImageEntity result = imageService.saveImage(img);
                return ResponseEntity.ok(link);
            } catch (Exception e) {
                throw new InternalServerException("Lỗi khi upload file");
            }
        }

        throw new BadRequestException("File không hợp lệ");
    }

    @GetMapping("/media/static/{filename:.+}")
    public ResponseEntity<?> download(@PathVariable String filename) {
        File file = new File(UPLOAD_DIR + "/" + filename);
        if (!file.exists()) {
            throw new NotFoundException("File không tồn tại");
        }

        UrlResource resource;
        try {
            resource = new UrlResource(file.toURI());
        } catch (MalformedURLException e) {
            throw new NotFoundException("File không tồn tại");
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }


    @GetMapping("/get-image/{filename:.+}")
    public ResponseEntity<ByteArrayResource> getImag(@PathVariable("filename") String filename) {
        if (!filename.equals("") || filename != null) {
            try {
                Path fileName = Paths.get(UPLOAD_DIR, filename);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/png")).body(byteArrayResource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/api/delete-image/{filename:.+}")
    public ResponseEntity<?> deleteFile(@PathVariable String filename) {
        imageService.deleteImage(UPLOAD_DIR, filename);
        return ResponseEntity.ok("Xóa thành công");
    }
}
