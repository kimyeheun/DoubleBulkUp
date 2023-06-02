package com.doubleBulkUp.user.entity;

import com.doubleBulkUp.gym.entity.Gym;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class UserMappingGym {
    @Id @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gymName")
    private Gym gym;
}
