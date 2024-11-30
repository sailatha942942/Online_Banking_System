package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class transactions extends JFrame implements ActionListener {

        JLabel l1,l2;
        JButton b1,b2,b3,b4,b5,b6,b7;
        String pin;
    public transactions(String pin) {
            //setLayout(null);
            this.pin = pin;

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l1 = new JLabel(i3);
          // l1.setBounds(0, 0, 900, 900);
            add(l1);

            l2 = new JLabel("Please select your Transaction");
            l2.setFont(new Font("System", Font.BOLD, 12));
            l2.setForeground(Color.WHITE);
            l2.setBounds(150, 230,300,20);
            l1.add(l2);

            b1 = new JButton("Deposit");
            b1.setFont(new Font("Raleway", Font.BOLD, 12));
            b1.setForeground(Color.BLACK);
            b1.setBounds(120, 305,105,20);
            b1.addActionListener(this);
            l1.add(b1);

            b2 = new JButton("Cash Withdrawal");
            b2.setFont(new Font("Raleway", Font.BOLD, 12));
            b2.setForeground(Color.BLACK);
            b2.setBounds(250, 305,140,20);
            b2.addActionListener(this);
            l1.add(b2);

            b3 = new JButton("Fast Cash");
            b3.setFont(new Font("Raleway", Font.BOLD, 12));
            b3.setForeground(Color.BLACK);
            b3.setBounds(120, 333,105,20);
            b3.addActionListener(this);
            l1.add(b3);

            b4 = new JButton("Mini Statement");
            b4.setFont(new Font("Raleway", Font.BOLD, 12));
            b4.setForeground(Color.BLACK);
            b4.setBounds(250, 333,140,20);
            b4.addActionListener(this);
            l1.add(b4);

            b5 = new JButton("Pin Change");
            b5.setFont(new Font("Raleway", Font.BOLD, 12));
            b5.setForeground(Color.BLACK);
            b5.setBounds(120, 360,105,20);
            b5.addActionListener(this);
            l1.add(b5);

            b6 = new JButton("Balance Enquiry");
            b6.setFont(new Font("Raleway", Font.BOLD, 12));
            b6.setForeground(Color.BLACK);
            b6.setBounds(250, 360,140,20);
            b6.addActionListener(this);
            l1.add(b6);

            b7 = new JButton("Exit");
            b7.setFont(new Font("Raleway", Font.BOLD, 12));
            b7.setForeground(Color.BLACK);
            b7.setBounds(250, 385,140,20);
            b7.addActionListener(this);
            l1.add(b7);

            setSize(700, 700);
            setLocation(300, 0);
            setUndecorated(true);
            setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b7){
                    System.exit(0);
            } else if(e.getSource()==b1){
                    setVisible(false);
                    new Deposit(pin).setVisible(true);
            } else if(e.getSource()==b2){
                    setVisible(false);
                    new withdraw(pin).setVisible(true);
            } else if (e.getSource()==b3) {
                    setVisible(false);
                    new fastCash(pin).setVisible(true);
            } else if (e.getSource()==b5) {
                    setVisible(false);
                    new pinChange(pin).setVisible(true);
            } else if (e.getSource()==b6) {
                    setVisible(false);
                    new balanceEnquiry(pin).setVisible(true);
            } else if (e.getSource()==b4) {
                    setVisible(false);
                    new miniStatement(pin).setVisible(true);
            }
    }
    public static void main(String[] args) {
        new transactions("");
    }
}
