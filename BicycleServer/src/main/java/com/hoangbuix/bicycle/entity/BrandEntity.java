package com.hoangbuix.bicycle.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "brand")
@Table(name = "brand")
public class BrandEntity extends BaseEntity {
    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "thumbnail")
    private String thumbnail;
}
