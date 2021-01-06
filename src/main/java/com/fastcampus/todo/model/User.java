package com.fastcampus.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;
    private String address;
    private String password;
    private String bloodType;

//    @OneToOne
//    @OneToMany
//    @ManyToOne
//    @ManyToMany

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)   // 컬럼명: todo_id
    @ToString.Exclude
    @JsonIgnore
    private Todo todo;      // inner join User x Todo

    public static User emptyObject() {
        return new User();
    }
}
