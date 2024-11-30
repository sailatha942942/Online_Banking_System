package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener {
    JLabel l1,type,card,detail,pin,password,service,number,pinValue;
    JRadioButton type1,type2,type3,type4;
    ButtonGroup group;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno,facility;

    signup3(String formno){
        this.formno = formno;

        setLayout(null);

        l1 = new JLabel("page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(250, 20, 280, 32);
        add(l1);

        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        type.setBounds(60, 80, 150, 25);
        add(type);

        type1 = new JRadioButton("Savings Account");
        type1.setFont(new Font("Raleway", Font.BOLD, 12));
        type1.setBounds(60, 110, 190, 22);
        type1.setBackground(Color.WHITE);
        add(type1);

        type2 = new JRadioButton("Fixed Deposit Account");
        type2.setFont(new Font("Raleway", Font.BOLD, 12));
        type2.setBounds(280, 110, 450, 22);
        type2.setBackground(Color.WHITE);
        add(type2);

        type3 = new JRadioButton("Current Account");
        type3.setFont(new Font("Raleway", Font.BOLD, 12));
        type3.setBounds(60, 140, 190, 22);
        type3.setBackground(Color.WHITE);
        add(type3);

        type4 = new JRadioButton("Roaming Deposit Account");
        type4.setFont(new Font("Raleway", Font.BOLD, 12));
        type4.setBounds(280, 140, 450, 22);
        type4.setBackground(Color.WHITE);
        add(type4);

        group = new ButtonGroup();
        group.add(type1);
        group.add(type2);
        group.add(type3);
        group.add(type4);

        card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(60, 180, 150, 25);
        add(card);

        number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 18));
        number.setBounds(260, 180, 450, 22);
        add(number);

        detail = new JLabel("Your 16 Digit Card Number");
        detail.setFont(new Font("Raleway", Font.BOLD, 10));
        detail.setBounds(60, 205, 150, 15);
        add(detail);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(60, 245, 150, 15);
        add(pin);

        pinValue = new JLabel("XXXX");
        pinValue.setFont(new Font("Raleway", Font.BOLD, 18));
        pinValue.setBounds(260, 245, 450, 15);
        add(pinValue);

        password = new JLabel("Your 4 Digit Password");
        password.setFont(new Font("Raleway", Font.BOLD, 10));
        password.setBounds(60, 265, 150, 15);
        add(password);

        service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 18));
        service.setBounds(60, 300, 200, 18);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 12));
        c1.setBounds(60, 340, 150, 25);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 12));
        c2.setBounds(280, 340, 150, 25);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 12));
        c3.setBounds(60, 380, 150, 25);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 12));
        c4.setBounds(280, 380, 150, 25);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 12));
        c5.setBounds(60, 420, 150, 25);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 12));
        c6.setBounds(280, 420, 150, 25);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declares the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway", Font.BOLD, 10));
        c7.setBounds(60, 480, 550, 25);
        c7.setBackground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 15));
        submit.setBounds(180, 510, 100, 32);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 15));
        cancel.setBounds(350, 510, 100, 32);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(750, 630);
        setLocation(300, 30);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == cancel){

                setVisible(false);
                new login().setVisible(true);

            } else if (e.getSource() == submit) {

                String accountType = "";
                if(type1.isSelected()){
                    accountType = "Savings Account";
                } else if(type2.isSelected()){
                    accountType = "Fixed Deposit Account";
                } else if(type3.isSelected()){
                    accountType = "Current Account";
                } else if(type4.isSelected()){
                    accountType = "Roaming Deposit Account";
                } else {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                }

                Random ran = new Random();
                String cardnumber = "" + (Math.abs(ran.nextLong() % 90000000L) + 50409036000000000L);

                String pinnumber = "" + (Math.abs(ran.nextLong() % 9000L) + 1000L);

                 facility = "";
                if(c1.isSelected()){
                    facility = facility + "ATM CARD";
                }
                if(c2.isSelected()){
                    facility = facility + " Internet Banking";
                }
                if(c3.isSelected()){
                    facility = facility + " Mobile Banking";
                }
                if(c4.isSelected()){
                    facility = facility + " EMAIL & SMS Alerts";
                }
                if (c5.isSelected()) {
                    facility = facility + " Cheque Book";
                }
                if (c6.isSelected()) {
                    facility = facility + " E-Statement";
                }
                System.out.println(facility);

                try {
                    if(!c7.isSelected()){
                        JOptionPane.showMessageDialog(null, "You must agree the condition");
                    } else {
                        conn c = new conn();
                        String query = "insert into signup3 values ('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                        c.s.executeUpdate(query);

                        JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+ "\n PIN Number: "+pinnumber);

                       String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                        c.s.executeUpdate(query2);

                        setVisible(false);
                        new Deposit(pinnumber).setVisible(true);


                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
    }

    public static void main(String[] args) {
        new signup3("");
    }
}
