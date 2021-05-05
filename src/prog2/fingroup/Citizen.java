package prog2.fingroup;

import java.util.Objects;

public class Citizen {
    private String lastName;
    private String firstNAme;
    private String email;
    private String address;
    private int age;
    private boolean residencyType;
    private int districtNumber;
    private boolean gender;


    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getDistrictNumber() {
        return districtNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistrictNumber(int districtNumber) {
        this.districtNumber = districtNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setResidencyType(boolean residencyType) {
        this.residencyType = residencyType;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "lastName='" + lastName + '\'' +
                ", firstNAme='" + firstNAme + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", residencyType=" + residencyType +
                ", districtNumber=" + districtNumber +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return age == citizen.age && residencyType == citizen.residencyType && districtNumber == citizen.districtNumber && gender == citizen.gender && Objects.equals(lastName, citizen.lastName) && Objects.equals(firstNAme, citizen.firstNAme) && Objects.equals(email, citizen.email) && Objects.equals(address, citizen.address);
    }

}
