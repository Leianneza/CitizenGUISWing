package prog2.fingroup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyProgram implements ActionListener {

        private static JLabel communityPopulation;
        private static JLabel name;
        private static JLabel Age;
        private static JLabel residencyType;
        private static JLabel districtNum;
        private static JLabel Gender;
        private static JTextField nameTextField;
        private static JTable spreadSheet;
        private static JScrollPane scrollPane;
        private static JButton button;

    public static void main(String[] args) {

        JLabel label = new JLabel();
        JFrame frame = new JFrame();

        frame.setTitle("MyProgram");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1500  , 800);
        frame.setVisible(true);
        frame.add(label);
        ImageIcon image = new ImageIcon("asia-developer-academy.png");
        frame.setIconImage(image.getImage());

        communityPopulation = new JLabel();
        label.setText("Community Population");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(Color.black);
        label.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label.setBackground(Color.gray);
        label.setOpaque(true);

        label.setLayout(null);

        name = new JLabel();
        name.setText("Search");
        name.setFont(new Font("Century Gothic", Font.BOLD, 18));
        name.setForeground(Color.black);
        name.setBounds(60,40,150,25);
        label.add(name);

        nameTextField = new JTextField(20);
        nameTextField.setBounds(60,80,260,30);
        label.add(nameTextField);

        button = new JButton("Ascending");
        button.setBounds(60,120,120,30);
        button.addActionListener(new MyProgram());
        label.add(button);

        button = new JButton("Descending");
        button.setBounds(200,120,120,30);
        button.addActionListener(new MyProgram());
        label.add(button);


        Age = new JLabel();
        Age.setText("Age");
        Age.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Age.setForeground(Color.black);
        Age.setBounds(60,180,70,25);
        label.add(Age);

        String ageDrop[] = {" ","1-10","11-20","21-30","31-40","41-50","51-60","61-70"};
        JComboBox aD = new JComboBox(ageDrop);
        aD.setBounds(60, 220, 70, 30);
        Age.add(aD);
        Age.setLayout(null);
        Age.setVisible(true);
        label.add(aD);

        residencyType = new JLabel();
        residencyType.setText("Residency Type");
        residencyType.setFont(new Font("Century Gothic", Font.BOLD, 18));
        residencyType.setForeground(Color.black);
        residencyType.setBounds(60,260,600,30);
        label.add(residencyType);

        String rtDrop[] = {" ","Resident","None Resident"};
        JComboBox rtD = new JComboBox(rtDrop);
        rtD.setBounds(60, 300, 130, 30);
        residencyType.setLayout(null);
        residencyType.setVisible(true);
        label.add(rtD);

        districtNum = new JLabel();
        districtNum.setText("District Number");
        districtNum.setFont(new Font("Century Gothic", Font.BOLD, 18));
        districtNum.setForeground(Color.black);
        districtNum.setBounds(60,340,600,30);
        label.add(districtNum);

        String distNum[] = {" ","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        JComboBox distD = new JComboBox(distNum);
        distD.setBounds(60, 380, 50, 30);
        districtNum.add(distD);
        districtNum.setLayout(null);
        districtNum.setVisible(true);
        label.add(distD);

        Gender = new JLabel();
        Gender.setText("Gender:");
        Gender.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Gender.setForeground(Color.black);
        Gender.setBounds(60,420,200,30);
        label.add(Gender);

        String genDrop[] = {" ","Male","Female"};
        JComboBox genD = new JComboBox(genDrop);
        genD.setBounds(60, 460, 80, 30);
        Gender.add(genD);
        Gender.setLayout(null);
        Gender.setVisible(true);
        label.add(genD);

        String[] columnNames = {"Name","Eye Color","Gender"};
        Object [][] data = {};
        spreadSheet = new JTable(data,columnNames);
        spreadSheet.setPreferredScrollableViewportSize(new Dimension(900,550));
        spreadSheet.setBounds(80,120,900,550);
        spreadSheet.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(spreadSheet);
        spreadSheet.add(scrollPane);
        label.add(spreadSheet);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}