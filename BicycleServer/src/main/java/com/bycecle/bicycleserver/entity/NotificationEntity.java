package com.bycecle.bicycleserver.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "notification")
@Table(name = "notification")
public class NotificationEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;
}
