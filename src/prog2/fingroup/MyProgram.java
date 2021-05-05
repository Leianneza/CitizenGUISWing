package prog2.fingroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class MyProgram extends javax.swing.JFrame implements ActionListener {

    private JLabel label;
    private static JLabel communityPopulation;
    private static JLabel name;
    private static JLabel Age;
    private static JLabel residencyType;
    private static JLabel districtNum;
    private static JLabel gender;
    private static JTextField nameTextField;
    private static JTable spreadSheet;
    private static JScrollPane scrollPane;
    private static JButton button;

    public MyProgram()  {
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
        header.setBounds(0, 0, 1000, 80);
        header.setLayout(new BorderLayout());

        JPanel result = new JPanel();
        result.setBackground(Color.white);
        result.setBounds(370, 90, 620, 820);
        result.setLayout(new BorderLayout());


        communityPopulation = new JLabel();
        communityPopulation.setHorizontalAlignment(JLabel.CENTER);
        communityPopulation.setVerticalAlignment(JLabel.CENTER);
        communityPopulation.setText("Community Population");
        communityPopulation.setFont(new Font("Century Gothic", Font.BOLD, 20));
        communityPopulation.setForeground(Color.white);
        communityPopulation.setBounds(740,10,100,30);
        header.add(communityPopulation);

        name = new JLabel();
        name.setText("Search");
        name.setFont(new Font("Century Gothic", Font.BOLD,
                18));
        name.setForeground(Color.black);
        sidePane.add(name);

        nameTextField = new JTextField(20);
        nameTextField.setBounds(60,80,260,30);
        sidePane.add(nameTextField);

        button = new JButton("Ascending");
        button.setBounds(60,120,120,30);
        //button.addActionListener(new MyProgram());
        sidePane.add(button);

        button = new JButton("Descending");
        button.setBounds(200,120,120,30);
        //button.addActionListener(new MyProgram());
        sidePane.add(button);


        Age = new JLabel();
        Age.setText("Age");
        Age.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Age.setForeground(Color.black);
        Age.setBounds(60,180,70,25);
        sidePane.add(Age);

        String ageDrop[] = {" ","1-10","11-20","21-30","31-40","41-50","51-60","61-70"};
        JComboBox aD = new JComboBox(ageDrop);
        aD.setBounds(60, 220, 70, 30);
        Age.add(aD);
        Age.setLayout(null);
        sidePane.add(aD);
        Age.setVisible(true);

        residencyType = new JLabel();
        residencyType.setText("Residency Type");
        residencyType.setFont(new Font("Century Gothic", Font.BOLD, 18));
        residencyType.setForeground(Color.black);
        residencyType.setBounds(60,260,600,30);
        sidePane.add(residencyType);

        String rtDrop[] = {" ","Resident","None Resident"};
        JComboBox rtD = new JComboBox(rtDrop);
        rtD.setBounds(60, 300, 130, 30);
        residencyType.setLayout(null);
        sidePane.add(rtD);
        residencyType.setVisible(true);

        districtNum = new JLabel();
        districtNum.setText("District Number");
        districtNum.setFont(new Font("Century Gothic", Font.BOLD, 18));
        districtNum.setForeground(Color.black);
        districtNum.setBounds(60,340,600,30);
        sidePane.add(districtNum);

        String distNum[] = {" ","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        JComboBox distD = new JComboBox(distNum);
        distD.setBounds(60, 380, 50, 30);
        districtNum.add(distD);
        districtNum.setLayout(null);
        sidePane.add(distD);
        districtNum.setVisible(true);

        gender = new JLabel();
        gender.setText("Gender:");
        gender.setFont(new Font("Century Gothic", Font.BOLD, 18));
        gender.setForeground(Color.black);
        gender.setBounds(60,420,200,30);
        sidePane.add(gender);

        String genDrop[] = {" ","Female","Male"};
        JComboBox genD = new JComboBox(genDrop);
        genD.setBounds(60, 470, 120, 30);
        gender.setLayout(null);
        sidePane.add(genD);
        gender.setVisible(true);


        /**
         * Don't remove this or magugulo yung side pane
         */
        label = new JLabel();
        label.setText("");
        label.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setBounds(60,590,100,30);
        sidePane.add(label);





        String[] columnNames = {"Name","Eye Color","Gender"};
        Object [][] data = {};
        spreadSheet = new JTable(data,columnNames);
        spreadSheet.setPreferredScrollableViewportSize(new Dimension(900,550));
        spreadSheet.setBounds(80,120,900,550);
        spreadSheet.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(spreadSheet);
//        spreadSheet.add(scrollPane);
//        label.add(spreadSheet);




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Citizen");
        frame.setSize(1000, 900);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setBackground(Color.black);
        frame.add(sidePane);
        frame.add(header);
        frame.add(result);

        image = new ImageIcon("src\\res\\app_logo.png");
        frame.getContentPane().setBackground(Color.black);

//        ImageIcon background=new ImageIcon("src\\res\\background.jpg");
//        Image img=background.getImage();
//        Image temp=img.getScaledInstance(1000,900,Image.SCALE_SMOOTH);
//        background=new ImageIcon(temp);
//        JLabel back=new JLabel(background);
//        back.setLayout(null);
//        frame.add(back);



        frame.setVisible(true);



    }

    public static void main(String[] args) {
        // write your code here

        new MyProgram();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
