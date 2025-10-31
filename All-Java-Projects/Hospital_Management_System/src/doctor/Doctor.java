package doctor;

import exception.CustomException;

public class Doctor {
    private String name;
    private String specialization;
    private int experience; // in years

    public Doctor(String name, String specialization, int experience) throws CustomException {
        setName(name);
        setSpecialization(specialization);
        setExperience(experience);
    }

    private void setName(String name) throws CustomException {
        if (name.length() < 3) throw new CustomException("Doctor name must have at least 3 characters.");
        this.name = name;
    }

    private void setSpecialization(String specialization) throws CustomException {
        if (specialization.length() < 3) throw new CustomException("Specialization must have at least 3 characters.");
        this.specialization = specialization;
    }

    private void setExperience(int experience) throws CustomException {
        if (experience < 0) throw new CustomException("Experience cannot be negative.");
        this.experience = experience;
    }

    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public int getExperience() { return experience; }

    public void displayDoctor() {
        System.out.println("Doctor: " + name + ", Specialization: " + specialization + ", Experience: " + experience + " years");
    }
}
