package com.example.ClinicaaOdontologica.Hibernate.persistence.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class AddressDTO {
    private Long id;
    private String street;
    private Integer number;
    private String location;
    private String province;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String street, Integer number, String location, String province) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }
}
