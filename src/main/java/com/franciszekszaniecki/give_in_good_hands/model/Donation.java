package com.franciszekszaniecki.give_in_good_hands.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "donation_category")
    private List<Category> categories;
    @ManyToOne
    private Institution institution;
    @NotBlank
    private String street;
    private String city;
    private String zipCode;
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    private Boolean received;
    @ManyToOne
    private User user;


}
