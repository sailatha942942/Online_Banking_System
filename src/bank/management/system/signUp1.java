package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class signUp1 extends JFrame implements ActionListener {
    //signup 1st page
    long random;
    JTextField nameField, fnameField, pinField, stateField, cityField, addressField, emailField;
    JLabel formno, personalDetails,name,fname,dob,gender,Email,marital,Address,city,state,pincode;
    JDateChooser dobField;
    JRadioButton male,female,trans,married, unmarried, other;
    ButtonGroup group,group2;
    JButton next;


    signUp1(){

        setLayout(null);

        Random ran = new Random(); // to generate the random application number
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        personalDetails = new JLabel("page 1: personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(280, 70, 250, 30);
        add(personalDetails);

        name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 20);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.BOLD, 15));
        nameField.setBounds(300, 140, 400, 30);
        add(nameField);

        fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 180, 150, 20);
        add(fname);

        fnameField = new JTextField();
        fnameField.setFont(new Font("Raleway", Font.BOLD, 15));
        fnameField.setBounds(300, 180, 400, 30);
        add(fnameField);

        dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 220, 140, 20);
        add(dob);
//calender jar file need to be connected through libraries
//(file-->project structure-->modules-->dependencies-->'+' button-->add jar file and apply it)
        dobField = new JDateChooser();
        dobField.setBounds(300, 220, 400, 30);
        add(dobField);

        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 260, 100, 20);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 15));
        male.setBounds(300, 260, 100, 20);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        female.setBounds(450, 260, 100, 20);
        female.setBackground(Color.WHITE);
        add(female);

        trans = new JRadioButton("Other");
        trans.setFont(new Font("Raleway", Font.BOLD, 15));
        trans.setBounds(600, 260, 100, 20);
        trans.setBackground(Color.WHITE);
        add(trans);

        group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(trans);

        Email = new JLabel("Email Address: ");
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100, 300, 170, 20);
        add(Email);

        emailField = new JTextField();
        emailField.setFont(new Font("Raleway", Font.BOLD, 15));
        emailField.setBounds(300, 300, 400, 25);
        add(emailField);

        marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 340, 170, 20);
        add(marital);

        married = new JRadioButton("Yes");
        married.setFont(new Font("Raleway", Font.BOLD, 15));
        married.setBounds(300, 340, 80, 20);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("No");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 15));
        unmarried.setBounds(450, 340, 80, 20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("other");
        other.setFont(new Font("Raleway", Font.BOLD, 15));
        other.setBounds(600, 340, 80, 20);
        other.setBackground(Color.WHITE);
        add(other);

        group2 = new ButtonGroup();
        group2.add(married);
        group2.add(unmarried);
        group2.add(other);

        Address = new JLabel("Address: ");
        Address.setFont(new Font("Raleway", Font.BOLD, 20));
        Address.setBounds(100, 380, 100, 20);
        add(Address);

        addressField = new JTextField();
        addressField.setFont(new Font("Raleway", Font.BOLD, 15));
        addressField.setBounds(300, 380, 400, 25);
        add(addressField);

        city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 420, 80, 26);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Raleway", Font.BOLD, 15));
        cityField.setBounds(300, 420, 400, 25);
        add(cityField);

        state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 460, 80, 20);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Raleway", Font.BOLD, 15));
        stateField.setBounds(300, 460, 400, 25);
        add(stateField);

        pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 500, 100, 20);
        add(pincode);

        pinField = new JTextField();
        pinField.setFont(new Font("Raleway", Font.BOLD, 15));
        pinField.setBounds(300, 500, 400, 25);
        add(pinField);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(600, 560, 80, 25);
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        setSize(850, 660);
        setLocation(300, 10);
        setVisible(true);


        getContentPane().setBackground(Color.WHITE);

    }
    public void actionPerformed(ActionEvent e) {
        String formno = "" + random; // by using "" we can convert long to string
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = ((JTextField) dobField.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        }

        String email = emailField.getText();

        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital = "Unmarried";
        } else if(other.isSelected()){
            marital = "Other";
        }

        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pin = pinField.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "name is mandatory");
            } else {
                conn c = new conn();
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signUp2(formno).setVisible(true);
            }
        } catch (Exception ex) {
            //throw new RuntimeException(ex);
            System.out.print(ex);
        }
    }
    public static void main(String[] args){
        new signUp1();
    }

}
