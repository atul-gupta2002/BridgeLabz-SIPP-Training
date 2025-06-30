package SelfProblems;

import java.util.*;

// Patient class
class Patient {
    private String name;
    private List<Doctor> consultedDoctors;

    public Patient(String name) {
        this.name = name;
        this.consultedDoctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }

    public void showConsultedDoctors() {
        System.out.println("Patient: " + name + " has consulted:");
        for (Doctor doc : consultedDoctors) {
            System.out.println("• Dr. " + doc.getName());
        }
        System.out.println();
    }
}

// Doctor class
class Doctor {
    public String name;
    public String specialization;
    public List<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        patient.addDoctor(this);  // maintain bidirectional relationship
        System.out.println("Dr. " + name + " is consulting patient " + patient.getName());
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " (" + specialization + ") has consulted:");
        for (Patient p : patients) {
            System.out.println("• " + p.getName());
        }
        System.out.println();
    }
}

// Hospital class
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalInfo() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doc : doctors) {
            System.out.println("• Dr. " + doc.getName() + " - " + doc.specialization);
        }
        System.out.println("Patients:");
        for (Patient pat : patients) {
            System.out.println("• " + pat.getName());
        }
        System.out.println();
    }
}

// Main class
public class Main5 {
    public static void main(String[] args) {
        // Create hospital
        Hospital hospital = new Hospital("City Health Hospital");

        // Create doctors
        Doctor d1 = new Doctor("Alice", "Cardiologist");
        Doctor d2 = new Doctor("Bob", "Dermatologist");

        // Create patients
        Patient p1 = new Patient("Ravi");
        Patient p2 = new Patient("Sita");

        // Add doctors and patients to hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Consultations (many-to-many associations)
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        // Display all information
        hospital.showHospitalInfo();

        d1.showPatients();
        d2.showPatients();

        p1.showConsultedDoctors();
        p2.showConsultedDoctors();
    }
}

