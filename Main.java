package main;

import domain.Patient;
import repository.MemoryRepository;
import service.PatientService;
import ui.PatientUI;

public class Main {
    public static void main(String[] args) {
        MemoryRepository<Patient> patientRepository = new MemoryRepository<>();
        PatientService patientService = new PatientService(patientRepository);
        PatientUI patientUI = new PatientUI(patientService);

        // Seed data
        patientService.addPatient(new Patient(1L, "John Doe", "555-1234", "john@example.com"));
        patientService.addPatient(new Patient(2L, "Jane Smith", "555-5678", "jane@example.com"));
        patientService.addPatient(new Patient(3L, "Jim Brown", "555-9876", "jim@example.com"));
        patientService.addPatient(new Patient(4L, "Lisa White", "555-5432", "lisa@example.com"));
        patientService.addPatient(new Patient(5L, "Michael Green", "555-8765", "michael@example.com"));

        // Start UI
        patientUI.showMenu();
    }
}
