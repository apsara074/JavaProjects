package patient;

import exception.CustomException;

public class Patient {
    private String name;
    private int age;
    private String phone;

    public Patient(String name, int age, String phone) throws CustomException {
        setName(name);
        setAge(age);
        setPhone(phone);
    }

    private void setName(String name) throws CustomException {
        if (name.length() < 3) throw new CustomException("Patient name must have at least 3 characters.");
        this.name = name;
    }

    private void setAge(int age) throws CustomException {
        if (age <= 0) throw new CustomException("Age must be positive.");
        this.age = age;
    }

    private void setPhone(String phone) throws CustomException {
        if (!phone.matches("[6-9][0-9]{9}")) throw new CustomException("Invalid phone number.");
        this.phone = phone;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }

    public void displayPatient() {
        System.out.println("Patient: " + name + ", Age: " + age + ", Phone: " + phone);
    }
}
