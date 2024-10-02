package com.mycompany.staffphonebook;

public class PhoneNumber {
    private String name;
    private String phoneNo;

    public PhoneNumber(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public String toString() {
        return name + "  " + phoneNo;
    }
}
