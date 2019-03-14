package com.lxj.model;

import java.util.Date;

/**
 * Student
 */
public class Student {

    private int stuId;
    private String stuNo;
    private String stuName;
    private String sex;
    private Date birthday;
    private int gradeId = -1;
    private String email;
    private String stuDesc;

    private String gradeName;

    public Student() {
        
    }

    public Student(String stuNo, String stuName, String sex, Date birthday, int gradeId, String email, String stuDesc) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.sex = sex;
        this.birthday = birthday;
        this.gradeId = gradeId;
        this.email = email;
        this.stuDesc = stuDesc;
        this.gradeName = gradeName;
    }


    /**
     * @return the stuId
     */
    public int getStuId() {
        return stuId;
    }

    /**
     * @param stuId the stuId to set
     */
    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    /**
     * @return the stuNo
     */
    public String getStuNo() {
        return stuNo;
    }

    /**
     * @param stuNo the stuNo to set
     */
    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    /**
     * @return the stuName
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * @param stuName the stuName to set
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the gradeId
     */
    public int getGradeId() {
        return gradeId;
    }

    /**
     * @param gradeId the gradeId to set
     */
    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the stuDesc
     */
    public String getStuDesc() {
        return stuDesc;
    }

    /**
     * @param stuDesc the stuDesc to set
     */
    public void setStuDesc(String stuDesc) {
        this.stuDesc = stuDesc;
    }

    /**
     * @return the gradeName
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * @param gradeName the gradeName to set
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}