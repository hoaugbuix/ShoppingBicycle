package com.bycecle.bicycleserver.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "image")
@Table(name = "image")
public class ImageEntity extends BaseEntity {

    @Column(name = "link")
    private String link;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "size")
    private String size;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upload_by")
    private int uploadBy;
}
