package com.ep.pojo;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {
    private int did;
    private String deptName;
    private List<Emp> emps;

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }

    public Dept(int did, String deptName, List<Emp> emps) {
        this.did = did;
        this.deptName = deptName;
        this.emps = emps;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Dept(int did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Dept() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
