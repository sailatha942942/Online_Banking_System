package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;


public class fastCash extends JFrame implements ActionListener {

    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    public fastCash(String pin) {
        //setLayout(null);
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        // l1.setBounds(0, 0, 900, 900);
        add(l1);

        l2 = new JLabel("Select withdrawl amount");
        l2.setFont(new Font("System", Font.BOLD, 12));
        l2.setForeground(Color.WHITE);
        l2.setBounds(180, 270,300,20);
        l1.add(l2);

        b1 = new JButton("Rs 100");
        b1.setFont(new Font("Raleway", Font.BOLD, 12));
        b1.setForeground(Color.BLACK);
        b1.setBounds(120, 325,105,20);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("Rs 500");
        b2.setFont(new Font("Raleway", Font.BOLD, 12));
        b2.setForeground(Color.BLACK);
        b2.setBounds(250, 325,140,20);
        b2.addActionListener(this);
        l1.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setFont(new Font("Raleway", Font.BOLD, 12));
        b3.setForeground(Color.BLACK);
        b3.setBounds(120, 353,105,20);
        b3.addActionListener(this);
        l1.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setFont(new Font("Raleway", Font.BOLD, 12));
        b4.setForeground(Color.BLACK);
        b4.setBounds(250, 353,140,20);
        b4.addActionListener(this);
        l1.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setFont(new Font("Raleway", Font.BOLD, 12));
        b5.setForeground(Color.BLACK);
        b5.setBounds(120, 380,105,20);
        b5.addActionListener(this);
        l1.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setFont(new Font("Raleway", Font.BOLD, 12));
        b6.setForeground(Color.BLACK);
        b6.setBounds(250, 380,140,20);
        b6.addActionListener(this);
        l1.add(b6);

        b7 = new JButton("Back");
        b7.setFont(new Font("Raleway", Font.BOLD, 12));
        b7.setForeground(Color.BLACK);
        b7.setBounds(250, 405,140,20);
        b7.addActionListener(this);
        l1.add(b7);

        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b7){

            setVisible(false);
            new transactions(pin).setVisible(true);

        } else {
            String amount = ((JButton)e.getSource()).getText().substring(3); //Rs 500
            int balance = 0;
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * From bank where pin = '"+pin+"'");

                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){

                        balance += Integer.parseInt(rs.getString("amount"));

                    }
                    else if(rs.getString("type").equals("Withdraw") ) {

                        balance -= Integer.parseInt(rs.getString("amount"));

                    }
                }

                if(e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"You have not enough money to deposit");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs '"+amount+"' debited successfully");

                setVisible(false);
                new transactions(pin).setVisible(true);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        new fastCash("");
    }
}
