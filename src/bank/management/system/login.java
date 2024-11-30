package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JButton signIn, signUp, clear;
    JTextField cardno1;
    JPasswordField pin1;
    String cardnumber, PIN;

    login(){
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Osward", Font.BOLD, 20));
        cardno.setBounds(120, 150, 250, 40);
        add(cardno);

        cardno1 = new JTextField();
        cardno1.setFont(new Font("Arial", Font.BOLD, 14));
        cardno1.setBounds(250, 157, 250, 30);
        add(cardno1);


        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Arial", Font.BOLD, 14));
        pin.setBounds(120, 220, 250, 40);
        add(pin);

        pin1 = new JPasswordField();
        pin1.setFont(new Font("Osward", Font.BOLD, 15));
        pin1.setBounds(250, 227, 250, 30);
        add(pin1);

        signIn = new JButton("SIGN IN");
        signIn.setFont(new Font("Osward", Font.BOLD, 10));
        signIn.setBounds(250, 300, 100, 30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);

        signUp = new JButton("SIGN UP");
        signUp.setFont(new Font("Osward", Font.BOLD, 10));
        signUp.setBounds(250, 350, 220, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        clear = new JButton("CLEAR");
        clear.setFont(new Font("Osward", Font.BOLD, 10));
        clear.setBounds(370, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,450);
        setVisible(true);
        setLocation(350,150);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == clear){
            cardno1.setText("");
            pin1.setText("");
        }else if(e.getSource() == signIn){
            String cardno = cardno1.getText();
            String pin = pin1.getText();
            conn c = new conn();
            String query = "select * From login where \"cardnumber\" = '"+cardno+"' and \"PIN\" = '"+pin+"'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or pin number");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }else if(e.getSource() == signUp){
            setVisible(false);
            new signUp1().setVisible(true);

        }
    }
    public static void main(String[] args) {
            new login();
    }
}
