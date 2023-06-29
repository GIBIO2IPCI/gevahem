package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatient();

    void savePatient(Patient patient);

    Patient getPatientById(Long id);

    Patient getPatientByContact(String contact);

    void deletePatientById(Long id);
}

