package prog2.fingroup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Citizen implements Comparable<Citizen>{

    private String firstName;
    private String email;
    private String address;
    private int age;
    private String residencyType;
    private int districtNumber;
    private String gender;
    private String lastName;
    private String fullName;


    public Citizen() {

    }


    public Citizen(String lastName, String firstName, String email, String address, int age,
                   String residencyType, int districtNo, String gender ) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.districtNumber = districtNo;
        this.residencyType = residencyType;
        this.gender = gender;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
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

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getResidenceType() {
        return residencyType;
    }



    public void setAllValues(String fullName, String email, String address, int age,
                             String residencyType, int districtNo, String gender ) {

        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.districtNumber = districtNo;
        this.residencyType = residencyType;
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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


    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setResidencyType(String residencyType) {
        this.residencyType = residencyType;
    }

    @Override
    public String toString() {
        String fullName = firstName + " " + lastName;
        return fullName +  "," + email + "," + address + "," + age + "," + residencyType +
                "," + districtNumber + "," + gender;
    }

    public int compareTo(Citizen another) {

        int compareThis = lastName.compareTo(another.getLastName());
        if ( compareThis < 0)
            return -1;
        else if (compareThis > 0)
            return 1;
        else
            return 0;
    } // end of compareTo

    Comparator<String> comparator = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Citizen another = null;
            int compareThis = ((String) o1).compareTo((String) o2);
            if ( compareThis < 0)
                return -1;
            else if (compareThis > 0)
                return 1;
            else
                return 0;
        }
    };
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return age == citizen.age && residencyType == citizen.residencyType && districtNumber == citizen.districtNumber && gender == citizen.gender
                && Objects.equals(firstName, citizen.firstName) && Objects.equals(email, citizen.email) && Objects.equals(address, citizen.address);
    }

}
