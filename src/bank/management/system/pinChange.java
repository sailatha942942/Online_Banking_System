package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {

    String pin;
    JLabel text,PIN,REPIN;
    JTextField t1,t2;
    JButton b1,b2;

    public pinChange(String pin) {
        this.pin = pin;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,700,700);
        add(l1);

        text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 12));
        text.setBounds(200,225,300,20);
        text.setForeground(Color.WHITE);
        l1.add(text);

        PIN = new JLabel("New PIN: ");
        PIN.setFont(new Font("System", Font.BOLD, 12));
        PIN.setBounds(130,255,200,20);
        PIN.setForeground(Color.WHITE);
        l1.add(PIN);

        t1 = new JTextField();
        t1.setFont(new Font("System", Font.BOLD, 12));
        t1.setBounds(250,255,150,20);
        t1.setForeground(Color.BLACK);
        l1.add(t1);

        REPIN = new JLabel("Re-Enter New PIN: ");
        REPIN.setFont(new Font("System", Font.BOLD, 12));
        REPIN.setBounds(130,285,200,20);
        REPIN.setForeground(Color.WHITE);
        l1.add(REPIN);

        t2 = new JTextField();
        t2.setFont(new Font("System", Font.BOLD, 12));
        t2.setBounds(250,285,150,20);
        t2.setForeground(Color.BLACK);
        l1.add(t2);

        b1 = new JButton("CHANGE");
        b1.setFont(new Font("System", Font.BOLD, 15));
        b1.setBounds(285,380,105,20);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 15));
        b2.setBounds(285,405,105,20);
        b2.addActionListener(this);
        l1.add(b2);

        setSize(700,700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String pin1 = t1.getText();
        String pin2 = t2.getText();

        if(e.getSource()==b1){
            try {
                if(!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null,"PIN does not match");
                    return;
                } else if(pin1.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new pin");
                    return;
                } else if(pin2.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new pin");
                    return;
                } else {
                    conn c = new conn();
                    String query1 = "update bank set pin='"+pin1+"' where pin='"+pin+"'";
                    String query2 = "update login set \"PIN\"='"+pin1+"' where \"PIN\"='"+pin+"'";
                    String query3 = "update signup3 set \"PIN\"='"+pin1+"' where \"PIN\"='"+pin+"'";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null,"PIN updated successfully");
                    setVisible(false);
                    new transactions(pin1).setVisible(true);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            setVisible(false);
            new transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new pinChange("");
    }
}
