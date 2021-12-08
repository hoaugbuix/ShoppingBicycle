package com.hoangbuix.bicycle.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "email")
@Table(name = "email")
public class EmailEntity extends BaseEntity {
    @Column(name = "content_email")
    private String contentEmail;

    @Column(name = "seen")
    private long seen;
}
