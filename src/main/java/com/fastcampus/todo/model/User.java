package com.fastcampus.todo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

/**
 * @author Martin
 * @since 2020/12/22
 */
@Entity     // hibernate -> (EntityManager)
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Where(clause = "deleted = false")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto increment
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "email")
    private String email;
//    private String address;
    private String password;
    private String bloodType;

    @Embedded
    private Address address;

    @ColumnDefault("false")
    private boolean deleted;    // primitive, 기본값 : false

//    @OneToOne
//    @OneToMany
//    @ManyToOne
//    @ManyToMany

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)   // 컬럼명: todo_id
    @ToString.Exclude
//    @JsonIgnore
    private Todo todo;      // inner join User x Todo

    // lazyinit -> 필요한시점에 init
    // Todo.class -> HibernateProxy<Todo> : Optional<Todo>

    // json -> object : json deserialize
    // object -> json : json serialize

    public static User emptyObject() {
        return new User();
    }
}
