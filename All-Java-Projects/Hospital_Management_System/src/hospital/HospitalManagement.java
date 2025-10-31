package hospital;

import java.util.*;
import java.util.stream.Collectors;

import appointment.Appointment;
import doctor.Doctor;
import exception.CustomException;
import patient.Patient;

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // 🔹 Input Doctors
            List<Doctor> doctors = new ArrayList<>();
            System.out.print("Enter number of doctors: ");
            int docCount = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 0; i < docCount; i++) {
                System.out.println("Enter details for Doctor " + (i + 1));
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Specialization: ");
                String specialization = sc.nextLine();
                System.out.print("Experience (years): ");
                int exp = sc.nextInt();
                sc.nextLine();
                doctors.add(new Doctor(name, specialization, exp));
            }

            // 🔹 Input Patients
            List<Patient> patients = new ArrayList<>();
            System.out.print("\nEnter number of patients: ");
            int patCount = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < patCount; i++) {
                System.out.println("Enter details for Patient " + (i + 1));
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Phone: ");
                String phone = sc.nextLine();
                patients.add(new Patient(name, age, phone));
            }

            // 🔹 Schedule Appointments
            List<Appointment> appointments = new ArrayList<>();
            System.out.print("\nEnter number of appointments: ");
            int appCount = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < appCount; i++) {
                System.out.println("Enter details for Appointment " + (i + 1));

                // Select patient
                System.out.println("Select patient by number:");
                for (int j = 0; j < patients.size(); j++) {
                    System.out.println((j + 1) + ". " + patients.get(j).getName());
                }
                int patIndex = sc.nextInt() - 1;
                sc.nextLine();

                // Select doctor
                System.out.println("Select doctor by number:");
                for (int j = 0; j < doctors.size(); j++) {
                    System.out.println((j + 1) + ". " + doctors.get(j).getName() + " (" + doctors.get(j).getSpecialization() + ")");
                }
                int docIndex = sc.nextInt() - 1;
                sc.nextLine();

                // Enter date and fee
                System.out.print("Appointment Date (dd-mm-yyyy): ");
                String date = sc.nextLine();
                System.out.print("Consultation Fee: ");
                double fee = sc.nextDouble();
                sc.nextLine();

                appointments.add(new Appointment(patients.get(patIndex), doctors.get(docIndex), date, fee));
            }

            // 🔹 Stream API Examples
            System.out.println("\n--- Costliest Appointment ---");
            appointments.stream()
                    .max(Comparator.comparing(Appointment::getFee))
                    .ifPresent(Appointment::displayAppointment);

            System.out.println("\n--- Appointments by Cardiologist ---");
            appointments.stream()
                    .filter(a -> a.getDoctor().getSpecialization().equalsIgnoreCase("Cardiologist"))
                    .forEach(Appointment::displayAppointment);

            System.out.println("\n--- Appointments Grouped by Doctor ---");
            Map<String, List<Appointment>> grouped = appointments.stream()
                    .collect(Collectors.groupingBy(a -> a.getDoctor().getName()));
            grouped.forEach((doctor, appList) -> {
                System.out.println("\nDoctor: " + doctor);
                appList.forEach(Appointment::displayAppointment);
            });

        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
/*Enter number of doctors: 2
Enter details for Doctor 1
Name: Dr. Smith
Specialization: Cardiologist
Experience (years): 15
Enter details for Doctor 2
Name: Dr. John
Specialization: Dermatologist
Experience (years): 10

Enter number of patients: 3
Enter details for Patient 1
Name: Alice
Age: 25
Phone: 9876543210
Enter details for Patient 2
Name: Bob
Age: 40
Phone: 9123456789
Enter details for Patient 3
Name: Charlie
Age: 60
Phone: 9988776655

Enter number of appointments: 3
Enter details for Appointment 1
Select patient by number:
1. Alice
2. Bob
3. Charlie
1
Select doctor by number:
1. Dr. Smith (Cardiologist)
2. Dr. John (Dermatologist)
1
Appointment Date (dd-mm-yyyy): 15-09-2025
Consultation Fee: 500

Enter details for Appointment 2
Select patient by number:
1. Alice
2. Bob
3. Charlie
2
Select doctor by number:
1. Dr. Smith (Cardiologist)
2. Dr. John (Dermatologist)
2
Appointment Date (dd-mm-yyyy): 16-09-2025
Consultation Fee: 300

Enter details for Appointment 3
Select patient by number:
1. Alice
2. Bob
3. Charlie
3
Select doctor by number:
1. Dr. Smith (Cardiologist)
2. Dr. John (Dermatologist)
1
Appointment Date (dd-mm-yyyy): 17-09-2025
Consultation Fee: 700

--- Costliest Appointment ---
AppointmentID: APT1234, Date: 17-09-2025, Fee: 700.0
Patient: Charlie, Age: 60, Phone: 9988776655
Doctor: Dr. Smith, Specialization: Cardiologist, Experience: 15 years

--- Appointments by Cardiologist ---
AppointmentID: APT5678, Date: 15-09-2025, Fee: 500.0
Patient: Alice, Age: 25, Phone: 9876543210
Doctor: Dr. Smith, Specialization: Cardiologist, Experience: 15 years

AppointmentID: APT1234, Date: 17-09-2025, Fee: 700.0
Patient: Charlie, Age: 60, Phone: 9988776655
Doctor: Dr. Smith, Specialization: Cardiologist, Experience: 15 years

--- Appointments Grouped by Doctor ---

Doctor: Dr. Smith
AppointmentID: APT1234, Date: 15-09-2025, Fee: 500.0
Patient: Alice, Age: 25, Phone: 9876543210
Doctor: Dr. Smith, Specialization: Cardiologist, Experience: 15 years

AppointmentID: APT1234, Date: 17-09-2025, Fee: 700.0
Patient: Charlie, Age: 60, Phone: 9988776655
Doctor: Dr. Smith, Specialization: Cardiologist, Experience: 15 years

Doctor: Dr. John
AppointmentID: APT2345, Date: 16-09-2025, Fee: 300.0
Patient: Bob, Age: 40, Phone: 9123456789
Doctor: Dr. John, Specialization: Dermatologist, Experience: 10 years
 */