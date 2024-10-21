package ui;

import domain.Patient;
import repository.MemoryRepository;
import service.PatientService;

import java.util.Scanner;

public class PatientUI {
    private PatientService patientService;
    private Scanner scanner = new Scanner(System.in);

    public PatientUI(PatientService patientService) {
        this.patientService = patientService;
    }

    public static final int ADD_PATIENT = 1;
    public static final int VIEW_PATIENT = 2;
    public static final int UPDATE_PATIENT = 3;
    public static final int DELETE_PATIENT = 4;
    public static final int LIST_PATIENT = 5;
    public static final int EXIT = 6;
    public void showMenu() {
        while (true) {
            System.out.println("\nDentist Appointment System");
            System.out.println(ADD_PATIENT + ".Add Patient");
            System.out.println(VIEW_PATIENT+".View Patient");
            System.out.println(UPDATE_PATIENT+".Update Patient");
            System.out.println(DELETE_PATIENT+".Delete Patient");
            System.out.println(LIST_PATIENT +".List All Patients");
            System.out.println(EXIT +".Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case ADD_PATIENT:
                    addPatient();
                    break;
                case VIEW_PATIENT:
                    viewPatient();
                    break;
                case UPDATE_PATIENT:
                    updatePatient();
                    break;
                case DELETE_PATIENT:
                    deletePatient();
                    break;
                case LIST_PATIENT:
                    listAllPatients();
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }

    private void addPatient() {
        System.out.println("Enter Patient ID:");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Patient Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        Patient patient = new Patient(id, name, phoneNumber, email);
        patientService.addPatient(patient);
        System.out.println("Patient added successfully.");
    }

    private void viewPatient() {
        System.out.println("Enter Patient ID:");
        Long id = scanner.nextLong();
        Patient patient = patientService.findPatient(id);
        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("Patient not found.");
        }
    }

    private void updatePatient() {
        System.out.println("Enter Patient ID to update:");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new Patient Name:");
        String name = scanner.nextLine();

        System.out.println("Enter new Phone Number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter new Email:");
        String email = scanner.nextLine();

        Patient patient = new Patient(id, name, phoneNumber, email);
        patientService.updatePatient(patient);
        System.out.println("Patient updated successfully.");
    }

    private void deletePatient() {
        System.out.println("Enter Patient ID to delete:");
        Long id = scanner.nextLong();
        patientService.deletePatient(id);
        System.out.println("Patient deleted successfully.");
    }

    private void listAllPatients() {
        for (Patient patient : patientService.getAllPatients()) {
            System.out.println(patient);
        }
    }
}
