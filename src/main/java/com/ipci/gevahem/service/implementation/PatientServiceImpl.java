package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Ambulancier;
import com.ipci.gevahem.entity.Patient;
import com.ipci.gevahem.repository.AmbulancierRepository;
import com.ipci.gevahem.repository.PatientRepository;
import com.ipci.gevahem.service.AmbulancierService;
import com.ipci.gevahem.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public void savePatient(Patient ambulancier) {
        patientRepository.save(ambulancier);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient getPatientByContact(String contact) {
        return patientRepository.findByContact(contact);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

}
