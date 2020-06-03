package com.example.internshipmyemmo;

import java.util.ArrayList;

public class Data {
    String status;

    ArrayList<Employee> array;

    public Data(String status, ArrayList<Employee> array) {
        this.status = status;
       this.array = array;
    }

    public ArrayList<Employee> getArray() {
        return array;
    }

    public void setArray(ArrayList<Employee> array) {
        this.array = array;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}

