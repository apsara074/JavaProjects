package department;

import exception.CustomException;

public class Department {
    private String deptId;
    private String deptName;

    public Department(String deptId, String deptName) throws CustomException {
        setDeptId(deptId);
        setDeptName(deptName);
    }

    private void setDeptId(String id) throws CustomException {
        if (id.length() < 2)
            throw new CustomException("Department ID must have at least 2 characters.");
        this.deptId = id.toUpperCase();
    }

    private void setDeptName(String name) throws CustomException {
        if (name.length() < 3)
            throw new CustomException("Department name must have at least 3 characters.");
        this.deptName = name;
    }

    public String getDeptId() { return deptId; }
    public String getDeptName() { return deptName; }

    public void displayDepartment() {
        System.out.println("Department ID: " + deptId + ", Name: " + deptName);
    }
}
