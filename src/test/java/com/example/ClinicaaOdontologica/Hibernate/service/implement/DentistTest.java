package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Dentist;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DentistTest {

    @Test
    public void save() {
        Dentist dentist1 = new Dentist("sad","dss",555);
        Assert.assertNotNull(dentist1);
    }

}