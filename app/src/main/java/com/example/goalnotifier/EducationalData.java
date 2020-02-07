package com.example.goalnotifier;

public class EducationalData {

    private String schoolName;
    private String classCourse;
    private int startYear;
    private int endYear;
    private String favouriteSubject;

    public EducationalData() {

    }

    public EducationalData(String schoolName, String classCourse, int startYear, int endYear, String favouriteSubject) {
        this.schoolName = schoolName;
        this.classCourse = classCourse;
        this.startYear = startYear;
        this.endYear = endYear;
        this.favouriteSubject = favouriteSubject;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getClassCourse() {
        return classCourse;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public String getFavouriteSubject() {
        return favouriteSubject;
    }
}
