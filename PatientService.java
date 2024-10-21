package service;
import domain.Patient;
import repository.MemoryRepository;
import java.util.Collection;

public class PatientService {
    private MemoryRepository<Patient> repository;
    public PatientService(MemoryRepository<Patient> repository) {
        this.repository = repository;
    }

    public void addPatient(Patient patient) {
        repository.add(patient);
    }

    public Patient findPatient(Long id) {
        return repository.find(id);
    }

    public void updatePatient(Patient patient) {
        repository.update(patient);
    }

    public void deletePatient(Long id) {
        repository.delete(id);
    }

    public Collection<Patient> getAllPatients() {
        return repository.findAll().values();
    }
}
