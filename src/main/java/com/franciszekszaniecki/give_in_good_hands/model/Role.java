package com.franciszekszaniecki.give_in_good_hands.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

}
