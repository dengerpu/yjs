package com.ep.pojo;

public class Emp {
    private int eid;
    private String empName;
    private String age;
    private String email;
    private String sex;
    private Dept dept;

    public Emp(int eid, String empName, String age, String email, String sex, Dept dept) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.email = email;
        this.sex = sex;
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp() {
    }



    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", dept=" + dept +
                '}';
    }
}
