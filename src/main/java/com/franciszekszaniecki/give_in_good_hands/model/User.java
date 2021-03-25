package com.franciszekszaniecki.give_in_good_hands.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\-\\=])(?=.*[A-Z])(?!.*\\s).{8,}$")
    private String password;
    @Email
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private boolean enabled = false;
    @ManyToMany(fetch = FetchType.EAGER )
    private Set<Role> roles;

}
