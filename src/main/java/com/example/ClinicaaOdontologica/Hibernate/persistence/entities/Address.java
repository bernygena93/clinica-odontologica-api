package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Addresses")
@Getter
@Setter
public class Address{
    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    @Column
    private Long id;
    @Column
    private String street;
    @Column
    private Integer number;
    @Column
    private String location;
    @Column
    private String province;

    public Address() {
    }

    public Address(Long id, String street, Integer number, String location, String province) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }

    public Address(String street, Integer number, String location, String province) {
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }
}
