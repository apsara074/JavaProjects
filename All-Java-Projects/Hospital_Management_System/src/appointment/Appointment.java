package appointment;

import java.util.Random;
import exception.CustomException;
import patient.Patient;
import doctor.Doctor;

public class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date; // simple format (dd-mm-yyyy)
    private double fee;

    public Appointment(Patient patient, Doctor doctor, String date, double fee) throws CustomException {
        this.patient = patient;
        this.doctor = doctor;
        setDate(date);
        setFee(fee);
        generateAppointmentId();
    }

    private void setDate(String date) throws CustomException {
        if (!date.matches("\\d{2}-\\d{2}-\\d{4}")) 
            throw new CustomException("Date must be in format dd-mm-yyyy.");
        this.date = date;
    }

    private void setFee(double fee) throws CustomException {
        if (fee < 100) throw new CustomException("Consultation fee must be at least 100.");
        this.fee = fee;
    }

    private void generateAppointmentId() {
        Random rand = new Random();
        this.appointmentId = "APT" + (rand.nextInt(9000) + 1000);
    }

    public String getAppointmentId() { return appointmentId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getDate() { return date; }
    public double getFee() { return fee; }

    public void displayAppointment() {
        System.out.println("AppointmentID: " + appointmentId + ", Date: " + date + ", Fee: " + fee);
        patient.displayPatient();
        doctor.displayDoctor();
    }
}
