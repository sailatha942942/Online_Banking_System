package bank.management.system;

import javax.swing.*;
import java.awt.*;
//import java.util.*;
import java.awt.event.*;

public class signUp2 extends JFrame implements ActionListener {
    JLabel additionalDetails,religion,category,income,educational,quaification,occupation,pan,adhar,citizen,existing_account;
    JTextField panField,adharField;
    JButton next;
    JComboBox religionValue,categoryValue,incomeValue,education,occupationValue;
    JRadioButton skey,nokey,skey1,nokey1;
    ButtonGroup group;
    String formno;

    signUp2(String formno){
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);

        additionalDetails = new JLabel("page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(250, 20, 280, 32);
        add(additionalDetails);

        religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(60, 80, 150, 25);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionValue = new JComboBox(valReligion);
        religionValue.setBounds(250, 80, 400, 30);
        religionValue.setBackground(Color.WHITE);
        add(religionValue);

        category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(60, 120, 150, 25);
        add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryValue = new JComboBox(valCategory);
        categoryValue.setBounds(250, 120, 400, 30);
        categoryValue.setBackground(Color.WHITE);
        add(categoryValue);

        income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(60, 160, 150, 25);
        add(income);

        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomeValue = new JComboBox(valIncome);
        incomeValue.setBounds(250, 160, 400, 30);
        incomeValue.setBackground(Color.WHITE);
        add(incomeValue);

        educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 18));
        educational.setBounds(60, 200, 150, 25);
        add(educational);

        quaification = new JLabel("Quaification: ");
        quaification.setFont(new Font("Raleway", Font.BOLD, 18));
        quaification.setBounds(60, 220, 150, 25);
        add(quaification);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        education = new JComboBox(educationValues);
        education.setBounds(250, 220, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(60, 260, 150, 25);
        add(occupation);

        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupationValue = new JComboBox(valOccupation);
        occupationValue.setBounds(250, 260, 400, 30);
        occupationValue.setBackground(Color.WHITE);
        add(occupationValue);

        pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 18));
        pan.setBounds(60, 300, 150, 25);
        add(pan);

        panField = new JTextField();
        panField.setFont(new Font("Raleway", Font.BOLD, 15));
        panField.setBounds(250, 300, 400, 30);
        add(panField);

        adhar = new JLabel("Adhar Number: ");
        adhar.setFont(new Font("Raleway", Font.BOLD, 18));
        adhar.setBounds(60, 340, 150, 25);
        add(adhar);

        adharField = new JTextField();
        adharField.setFont(new Font("Raleway", Font.BOLD, 15));
        adharField.setBounds(250, 340, 400, 30);
        add(adharField);

        citizen = new JLabel("Senior Citizen: ");
        citizen.setFont(new Font("Raleway", Font.BOLD, 18));
        citizen.setBounds(60, 380, 150, 25);
        add(citizen);

        skey = new JRadioButton("Yes");
        skey.setFont(new Font("Raleway", Font.BOLD, 15));
        skey.setBounds(300, 380, 100, 20);
        skey.setBackground(Color.WHITE);
        add(skey);

        nokey = new JRadioButton("No");
        nokey.setFont(new Font("Raleway", Font.BOLD, 15));
        nokey.setBounds(450, 380, 100, 20);
        nokey.setBackground(Color.WHITE);
        add(nokey);

        group = new ButtonGroup();
        group.add(skey);
        group.add(nokey);

        existing_account = new JLabel("Existing Account: ");
        existing_account.setFont(new Font("Raleway", Font.BOLD, 18));
        existing_account.setBounds(60, 420, 180, 25);
        add(existing_account);

        skey1 = new JRadioButton("Yes");
        skey1.setFont(new Font("Raleway", Font.BOLD, 15));
        skey1.setBounds(300, 420, 100, 20);
        skey1.setBackground(Color.WHITE);
        add(skey1);

        nokey1 = new JRadioButton("No");
        nokey1.setFont(new Font("Raleway", Font.BOLD, 15));
        nokey1.setBounds(450, 420, 100, 20);
        nokey1.setBackground(Color.WHITE);
        add(nokey1);

        group = new ButtonGroup();
        group.add(skey1);
        group.add(nokey1);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(600, 480, 80, 25);
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        setSize(750, 600);
        setLocation(300, 10);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent e) {
        String sreligion = religionValue.getSelectedItem().toString();
        String scategory = categoryValue.getSelectedItem().toString();
        String income = incomeValue.getSelectedItem().toString();
        String seducation = education.getSelectedItem().toString();
        String occupation = occupationValue.getSelectedItem().toString();
        String pan_No = panField.getText();
        String adhar_No = adharField.getText();

        String seniorCitizen = null;
        if(skey.isSelected()){
            seniorCitizen = "Yes";
        } else if(nokey.isSelected()){
            seniorCitizen = "No";
        }

        String eAccount = null;
        if(skey1.isSelected()){
            eAccount = "Yes";
        } else if(nokey1.isSelected()){
            eAccount = "No";
        }

        try {
            conn c = new conn();
            String query = "insert into signup2 values ('"+formno+"','"+sreligion+"','"+scategory+"','"+income+"','"+seducation+"','"+occupation+"','"+pan_No+"','"+adhar_No+"','"+seniorCitizen+"','"+eAccount+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signup3(formno).setVisible(true);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args){
        new signUp2("");
    }
}

