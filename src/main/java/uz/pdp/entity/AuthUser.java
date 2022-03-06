package uz.pdp.entity;


import lombok.Getter;
import lombok.Setter;
import uz.pdp.enums.Role;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;


}
