package com.coviam.internalapp.hrms.employee.dto;

/**
 * Created by Hardik on 31/01/17.
 */
public class EmployeeUpdateImageDto {
    private String imagePath;

    public EmployeeUpdateImageDto() {
    }

    public EmployeeUpdateImageDto(String image) {
        this.imagePath = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String image) {
        this.imagePath = image;
    }
}
