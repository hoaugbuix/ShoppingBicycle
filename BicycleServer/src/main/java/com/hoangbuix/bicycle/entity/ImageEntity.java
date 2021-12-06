package com.hoangbuix.bicycle.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "image")
@Table(name = "image")
public class ImageEntity extends BaseEntity {

    @Column(name = "link", unique = true)
    private String link;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "size")
    private long size;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "post_id")
    private long postId;

    @Column(name = "upload_by")
    private long uploadBy;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "post_id")
//    private PostEntity post;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "upload_by")
//    private int uploadBy;
}
