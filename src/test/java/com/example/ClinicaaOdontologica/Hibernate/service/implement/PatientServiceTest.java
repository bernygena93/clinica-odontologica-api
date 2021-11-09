package com.example.ClinicaaOdontologica.Hibernate.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Address;
import com.example.ClinicaaOdontologica.Hibernate.persistence.entities.Patient;

import java.util.Collection;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    PatientService patientService;

    public void cargarDataSet() {
        Address address = new Address("Av Santa fe", 444, "CABA", "Buenos Aires");
        Patient patient = new Patient("Santiago", "Paz", "88888888", address);
        patientService.save(patient);

    }

    @Test
    public void getAll() {
        Collection<Patient> patientCollection = patientService.getAll();
        Assert.assertFalse(patientCollection.isEmpty());
    }
}