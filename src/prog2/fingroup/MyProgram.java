package prog2.fingroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import static java.lang.String.valueOf;

public class MyProgram extends javax.swing.JFrame {

    private JLabel label;
    private static JLabel communityPopulation;
    private static JLabel name;
    private static JLabel Age;
    private static JLabel residencyType;
    private static JLabel districtNum;
    private static JLabel gender;
    private static JTextField nameTextField;
    private JTable spreadSheet = null;
    private static JScrollPane scrollPane;
    private static JButton ascendingButton;
    private static JButton descendingButton;
    private final ArrayList<String[]> Rs = new ArrayList<String[]>();
    private final ArrayList<String> Rs2 = new ArrayList<String>();
    private String[] OneRow;
    private final MyProgramUtility myProgramUtility = new MyProgramUtility();
    private DefaultTableModel model;
    MyModel NewModel = new MyModel();
    TableModel myTableModel = (TableModel) spreadSheet;
    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myTableModel);
    private final String path = "src\\res\\data.csv";





    /**
     * Course of plan:
     * Read the file
     * Sort the file
     * Store the sorted file in a new file
     * Read the new file
     * Store the values of the new file in JTable
     * @param
     * @return
     */


    public MyProgram() throws IOException {
        JLabel sideLabel = new JLabel();
        JLabel label = new JLabel();
        JFrame frame = new JFrame();
        ImageIcon image = new ImageIcon();

        JPanel sidePane = new JPanel();
        sidePane.setBackground(Color.gray);
        sidePane.setBounds(0, 80, 360, 900);
        sidePane.setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setBackground(Color.darkGray);
        header.setBounds(0, 0, 1050, 80);
        header.setLayout(new BorderLayout());

        JPanel result = new JPanel();
        result.setBackground(Color.white);
        result.setBounds(370, 90, 660, 820);
        result.setLayout(new BorderLayout());


        communityPopulation = new JLabel();
        communityPopulation.setHorizontalAlignment(JLabel.CENTER);
        communityPopulation.setVerticalAlignment(JLabel.CENTER);
        communityPopulation.setText("Community Population");
        communityPopulation.setFont(new Font("Century Gothic", Font.BOLD, 20));
        communityPopulation.setForeground(Color.white);
        communityPopulation.setBounds(740, 10, 100, 30);
        header.add(communityPopulation);

        name = new JLabel();
        name.setText("Search");
        name.setFont(new Font("Century Gothic", Font.BOLD,
                18));
        name.setForeground(Color.black);
        sidePane.add(name);

        nameTextField = new JTextField(20);
        nameTextField.setBounds(60, 80, 260, 30);
        nameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File data = new File("src\\res\\data.csv");
                //ReadCSVfile(data);

            }
        });
        sidePane.add(nameTextField);

        ascendingButton = new JButton("Ascending");
        ascendingButton.setBounds(60, 120, 120, 30);
        sidePane.add(ascendingButton);
        ascendingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyProgramUtility hehe = new MyProgramUtility();
                String path = "src\\res\\data.csv";

//                try {
//                    ArrayList<Citizen> array = MyProgramUtility.printNameAscending(MyProgramUtility.readCSV(path), path);
//
//                    //ArrayList<String[]> strList = (ArrayList<String[]>)(ArrayList<?>) (array);
//
//                    //List<String> strings = list.stream()
//                    //   .map(object -> Objects.toString(object, null))
//                    //   .collect(Collectors.toList());
//
//                    ArrayList<String[]> strList = array.stream().map((object -> Objects.toString(object, null)).collect(Collectors.toList()));
//
//                    NewModel.AddCSVData(strList);
//                    System.out.println("Rows: " + NewModel.getRowCount());
//                    System.out.println("Cols: " + NewModel.getColumnCount());

//                } catch (FileNotFoundException fileNotFoundException) {
//                    fileNotFoundException.printStackTrace();
//                }


            }

        });
        descendingButton = new JButton("Descending");
        descendingButton.setBounds(200, 120, 120, 30);
        sidePane.add(descendingButton);
        descendingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // put the code implementation here
            }
        });

        Age = new JLabel();
        Age.setText("Age");
        Age.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Age.setForeground(Color.black);
        Age.setBounds(60, 180, 70, 25);
        sidePane.add(Age);

        String[] ageDrop = {" ", "1-10", "11-20", "21-30", "31-40", "41-50", "51-60", "61-70"};
        JComboBox<String> aD = new JComboBox<>(ageDrop);
        aD.setBounds(60, 220, 70, 30);
        Age.add(aD);
        Age.setLayout(null);
        sidePane.add(aD);
        Age.setVisible(true);

        residencyType = new JLabel();
        residencyType.setText("Residency Type");
        residencyType.setFont(new Font("Century Gothic", Font.BOLD, 18));
        residencyType.setForeground(Color.black);
        residencyType.setBounds(60, 260, 600, 30);
        sidePane.add(residencyType);

        String[] rtDrop = {" ", "Resident", "None Resident"};
        JComboBox<String> rtD = new JComboBox<>(rtDrop);
        rtD.setBounds(60, 300, 130, 30);
        residencyType.setLayout(null);
        rtD.addItemListener(e -> {
            // File data = new File("src\\res\\data.csv");
            //ArrayList<String[]> readData = myProgramUtility.
            //ArrayList<String[]> filteredNameList = new ArrayList<>(readData);
            //NewModel = new MyProgramUtility.MyModel();

//            if (e.getStateChange() == ItemEvent.SELECTED) {
//                if(rtD.getSelectedItem().toString().equals("Resident")) {
//
//                    ArrayList<String[]> resident = filter(readData, "Resident");
//                    NewModel.AddCSVData(resident);
//                    System.out.println("Rows: " + NewModel.getRowCount());
//                    System.out.println("Cols: " + NewModel.getColumnCount());
//
//                } else {
//
//                    ArrayList<String[]> nonResident = filter(readData, "Non-Resident");
//                    NewModel.AddCSVData(nonResident);
//                    System.out.println("Rows: " + NewModel.getRowCount());
//                    System.out.println("Cols: " + NewModel.getColumnCount());
//                }
//            }
        });
        sidePane.add(rtD);
        residencyType.setVisible(true);


        districtNum = new JLabel();
        districtNum.setText("District Number");
        districtNum.setFont(new Font("Century Gothic", Font.BOLD, 18));
        districtNum.setForeground(Color.black);
        districtNum.setBounds(60, 340, 600, 30);
        sidePane.add(districtNum);


        String[] distNum = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        JComboBox<String> distD = new JComboBox<>(distNum);
        distD.setBounds(60, 380, 50, 30);
        districtNum.add(distD);
        districtNum.setLayout(null);
        sidePane.add(distD);
        districtNum.setVisible(true);

        gender = new JLabel();
        gender.setText("Gender:");
        gender.setFont(new Font("Century Gothic", Font.BOLD, 18));
        gender.setForeground(Color.black);
        gender.setBounds(60, 420, 200, 30);
        gender.setVisible(true);
        sidePane.add(gender);

        String[] genDrop = {" ", "Female", "Male"};
        JComboBox<String> genD = new JComboBox<>(genDrop);
        genD.setBounds(60, 470, 120, 30);
        gender.setLayout(null);
        sidePane.add(genD);
        genD.setVisible(true);
        gender.setVisible(true);


        /**
         * Don't remove this or magugulo yung side pane
         */
        label = new JLabel();
        label.setText("");
        label.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setBounds(60, 590, 100, 30);
        sidePane.add(label);


        JLabel sortedResults = new JLabel();
        sortedResults.setText("Sorted Results");
        sortedResults.setHorizontalAlignment(JLabel.CENTER);
        sortedResults.setVerticalAlignment(JLabel.CENTER);
        sortedResults.setFont(new Font("Century Gothic", Font.BOLD, 20));
        sortedResults.setForeground(Color.white);
        sortedResults.setBounds(60, 590, 100, 30);
        result.add(sortedResults);

        spreadSheet = new JTable(new MyModel());
        System.out.println();
        spreadSheet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        spreadSheet.setPreferredScrollableViewportSize(new Dimension(800, 100));
        spreadSheet.setBounds(0, 0, 500, 700);
        spreadSheet.setGridColor(Color.PINK);
        spreadSheet.setFillsViewportHeight(true);
        spreadSheet.setVisible(true);



        spreadSheet.setModel(NewModel);
        File DataFile = new File("src\\res\\data.csv");
        ArrayList<String[]> Rs2 = ReadCSVfile(DataFile) ;
        NewModel.AddCSVData(Rs2);
        System.out.println("Rows: " + NewModel.getRowCount());
        System.out.println("Cols: " + NewModel.getColumnCount());


        //spreadSheet.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(spreadSheet);
        add(scrollPane);
        result.add(scrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Citizen");
        frame.setSize(1050, 1000);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setBackground(Color.black);
        frame.add(sidePane);
        frame.add(header);
        frame.add(result);

        image = new ImageIcon("src\\res\\app_logo.png");
        // frame.add(image);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);
    }

    public static void printNames (List<Citizen> citizens, String path) {
        ArrayList<Citizen> shitizen = new ArrayList<>(citizens);
        for (Citizen e : shitizen) {
            e.toString();
            shitizen.add(e);
        }

    }

    public ArrayList<String[]> ReadCSVfile(File file) {

        try {
            BufferedReader brd = new BufferedReader(new FileReader(file));
            while (brd.ready()) {
                String st = brd.readLine();
                OneRow = st.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
                Rs.add(OneRow);
                System.out.println(Arrays.toString(OneRow));
            } // end of while
        } // end of try
        catch (Exception e) {
            System.out.println("File not found:" + e.getMessage());
        } // end of Catch
        return Rs;
    }// end of ReadFile method





    public static void main(String[] args) throws IOException {
        // write your code here

        new MyProgram();

    }


    static class MyModel extends AbstractTableModel {
        private final String[] columnNames = {"Last Name", "First Name", "Email Address", "Address", "Age",
                "Residence Type", "District Number", "Gender"};
        private ArrayList<String[]> Data = new ArrayList<>();




        public void AddCSVData(ArrayList<String[]> DataIn) {

            ArrayList<String[]> stringList = (ArrayList<String[]>)(ArrayList<?>)(DataIn);
            this.Data = stringList;
            this.fireTableDataChanged();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;// length;
        }

        @Override
        public int getRowCount() {
            return Data.size();
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return Data.get(row)[col];
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            String[][] cells = null;
            cells[rowIndex][columnIndex] = (String) aValue;
            fireTableCellUpdated(rowIndex, columnIndex);
        }




    }
}





