package com.fastcampus.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Martin
 * @since 2020/12/22
 */
@Entity     // hibernate -> (EntityManager)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto increment
    private Long id;

    @Column(name = "name")
    private String name;
    private String email;
    private String address;
    private String password;
    private String bloodType;
    // json / http : blood_type,
    // java, json, url : bloodType, blood-type


    public static User emptyObject() {
        return new User();
    }
}
