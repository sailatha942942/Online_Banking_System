package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {

    String pin;
    JButton b1;
    ResultSet rs;
    JLabel text,l1,l2;

    public balanceEnquiry(String pin) {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        l1.setBounds(0, 0, 700, 700);
        add(l1);

        b1 = new JButton("Back");
        b1.setFont(new Font("Raleway", Font.BOLD, 12));
        b1.setBounds(250, 405, 140, 20);
        b1.addActionListener(this);
        add(b1);

        conn c = new conn();
        int balance = 0;
        try {

             rs = c.s.executeQuery("select * from bank where pin='"+pin+"'");

            while (rs.next()) {
                if(rs.getString("type").equals("Deposit") ) {

                    balance += Integer.parseInt(rs.getString("amount"));

                }
                else if(rs.getString("type").equals("Withdraw") ) {

                    balance -= Integer.parseInt(rs.getString("amount"));

                }
            }

            text = new JLabel("Your current account balance is: ");
            text.setForeground(Color.WHITE);
            text.setFont(new Font("Raleway", Font.BOLD, 15));
            text.setBounds(130, 250, 400, 30);
            l1.add(text);

            l2 = new JLabel(""+balance);
            l2.setFont(new Font("Raleway", Font.BOLD, 15));
            l2.setForeground(Color.WHITE);
            l2.setBounds(200, 280, 400, 30);
            l1.add(l2);


        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(700, 700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1) {
            setVisible(false);
            new transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
