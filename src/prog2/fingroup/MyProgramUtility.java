package prog2.fingroup;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MyProgramUtility {
    private String[] OneRow;
    private String searchText;
    private static Citizen citizen;
    private static int ctr = 0;


    public static void main(String[] args) throws IOException {
        String path = "src\\res\\data.csv";

        System.out.println("Original List");
        printList(readCSV(path), path); // reads the files and prints it
        System.out.println("\n Ascending List");
        printNameAscending(readCSV(path), path); // prints the sorted data in ascending order
        System.out.println("\n Descending List");
        printNameDescending(readCSV(path), path); // prints the sorted data in descending order
        System.out.println("\n Searched Name (Terrell Dominic)");
        printSearchedName(readCSV(path), path); // prints the searched full name passed onto the method
        System.out.println("\n Searched Resident (Non-Resident)");
        printSearchedResidenceType(readCSV(path), path); // printsi the searched resident type passed onto method
        System.out.println("\n Searched Gender (female)");
        printSearchedGender(readCSV(path), path); // prints the searched gender passed onto method
        System.out.println("\n Searched District Number (10)");
        printSearchedDistrict(readCSV(path), path); // prints the searched district number passed onto method



    }


    public static ArrayList<Citizen> readCSV(String datafile) throws FileNotFoundException {
        ArrayList<Citizen> citizenList = new ArrayList<>();
        String contents;
        BufferedReader brd = new BufferedReader(new FileReader(datafile));
        try {
            while ((contents = brd.readLine()) != null) {
                String[] st = contents.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
                String firstName = st[1];
                String lastName = st[0];
                String email = st[2];
                String address = st[3];
                int age = Integer.parseInt(st[4]);
                String resident = st[5];
                int district = Integer.parseInt(st[6]);
                String gender = st[7];
                if (st[7].compareToIgnoreCase("Female") == 0) {
                    gender = "female";
                } else if (st[7].compareToIgnoreCase("Male") == 0) {
                    gender = "male";
                }

                citizenList.add(new Citizen(lastName, firstName, email, address, age, resident, district, gender));
            } // end of while loop


        } // end of try
        catch (Exception e) {
            System.out.println("File not found:" + e.getMessage());
        } // end of Catch

        return citizenList;
    }// end of ReadFile method


    public static void printList(List<Citizen> citizens, String path) throws FileNotFoundException {
        ArrayList<Citizen> shitizen = new ArrayList<>(readCSV(path));
        for (Citizen e : shitizen) {
            System.out.println(e);
        }
    }


    public static List<Citizen> SortNameAscending(List<Citizen> citizens, String path) throws FileNotFoundException {
        ArrayList<Citizen> list = readCSV(path);
        Citizen foundCitizen = new Citizen();

        list = (ArrayList<Citizen>) list.stream().sorted(Comparator.comparing(Citizen::getLastName)).collect(Collectors.toList());
        return list;

    }

    public static List<Citizen> SortNameDescending(List<Citizen> citizens, String path) throws FileNotFoundException {
        ArrayList<Citizen> list = readCSV(path);


        list = (ArrayList<Citizen>) list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return list;

    }

    public static void printNameDescending(List<Citizen> citizens, String path) throws FileNotFoundException {
        ArrayList<Citizen> shitizen = new ArrayList<>(SortNameDescending(readCSV(path), path));
        for (Citizen e : shitizen) {
            System.out.println(e);
        }
    }


    public static ArrayList<Citizen> printNameAscending(List<Citizen> citizens, String path) throws FileNotFoundException {
        ArrayList<Citizen> shitizen = new ArrayList<>(SortNameAscending(readCSV(path), path));
        for (Citizen e : shitizen) {
            System.out.println(e);
        }

        return shitizen;
    }

    public static ArrayList<Citizen> findName(String fullName, String path) throws FileNotFoundException {
        ArrayList<Citizen> list = readCSV(path);

        list = (ArrayList<Citizen>) list.stream().filter(x -> x.getFullName().equalsIgnoreCase(fullName)).collect(Collectors.toList());

        return list;
    }


    public static ArrayList<Citizen> findResident(String resident, String path) throws FileNotFoundException {
        ArrayList<Citizen> list = readCSV(path);

        list = (ArrayList<Citizen>) list.stream().filter(x -> x.getResidenceType().equalsIgnoreCase(resident)).collect(Collectors.toList());

        return list;
    }


    public static ArrayList<Citizen> findGender(String gender, String path) throws FileNotFoundException {
        ArrayList<Citizen> list = readCSV(path);

        list = (ArrayList<Citizen>) list.stream().filter(x -> x.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());

        return list;
    }


    public static ArrayList<Citizen> findDistrict(int district, String path) throws FileNotFoundException {
        ArrayList<Citizen> list = readCSV(path);

        list = (ArrayList<Citizen>) list.stream().filter(x -> x.getDistrictNumber() == (district)).collect(Collectors.toList());

        return list;
    }

    public static void printSearchedDistrict(List<Citizen> citizens, String path) throws FileNotFoundException {
        ArrayList<Citizen> mehe = new ArrayList<>(findDistrict(10, path));
        ctr = 0;
        for (Citizen e : mehe) {
            System.out.println(e);
            ctr++;
        }
        System.out.println("count: " + ctr);
    }

    public static void printSearchedGender(List<Citizen> citizens, String path) throws FileNotFoundException {
        ArrayList<Citizen> mehe = new ArrayList<>(findGender("female", path));
        ctr = 0;
        for (Citizen e : mehe) {
            System.out.println(e);
            ctr++;
        }
        System.out.println("count: " + ctr);
    }


    public static void printSearchedResidenceType (List < Citizen > citizens, String path) throws FileNotFoundException {
        ArrayList<Citizen> searchedResidenceType = new ArrayList<>(findResident("non-resident", path));
        ctr = 0;
        for (Citizen e : searchedResidenceType) {
            System.out.println(e);
            ctr++;
        }

        System.out.println("count: " + ctr);
    }


    public static void printSearchedName (List < Citizen > citizens, String path) throws FileNotFoundException {
        ArrayList<Citizen> searchedName = new ArrayList<>(findName("Terrell Dominic", path));
        ctr = 0;
        for (Citizen e : searchedName) {
            System.out.println(e);
            ctr++;
        }

        System.out.println("count: " + ctr);

    }

}










