package com.doubleBulkUp.user.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name="Person")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements Serializable {
    @Id
    @Column(name = "personId")
    private String id;

    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userBirth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate userBirth;
    @Column(name = "userSignUpTime")
    private LocalDateTime userSignUpTime;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "userPhone")
    private String userPhone;
    @Column(name = "userPicture")
    private String userPicture;


    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(name="userType")
    private UserType userType;


    @OneToOne(mappedBy = "person"
            , cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
    )
    private User user;

    @OneToOne(mappedBy = "person"
            , cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
    )
    private Trainer trainer;

    @OneToOne(mappedBy = "person"
            , cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
    )
    private Ceo ceo;


    @PrePersist
    public void setUserPicture() {
        this.userPicture = "Logo.png";
    }
}
