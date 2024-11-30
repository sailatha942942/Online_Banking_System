package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {

    String pin;
    JTextField tf;
    JButton b1,b2;
    JLabel text,l1;

    public  withdraw(String pin){
        this.pin = pin;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        l1.setBounds(0,0,700,700);
        add(l1);

        text = new JLabel("Enter amount to withdraw");
        text.setFont(new Font("System", Font.BOLD, 12));
        text.setBounds(150,250,300,20);
        text.setForeground(Color.WHITE);
        l1.add(text);

        tf = new JTextField();
        tf.setFont(new Font("System", Font.BOLD, 15));
        tf.setBounds(140,280,240,25);
        tf.setForeground(Color.BLACK);
        l1.add(tf);

        b1 = new JButton("Withdraw");
        b1.setFont(new Font("System", Font.BOLD, 15));
        b1.setBounds(285,380,105,20);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("System", Font.BOLD, 15));
        b2.setBounds(285,405,105,20);
        b2.addActionListener(this);
        l1.add(b2);


        setSize(700,700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        if(e.getActionCommand().equals("Withdraw")){
            if(tf.getText().equals("")){

                JOptionPane.showMessageDialog(null,"Enter amount to withdraw");

            } else {
                try {
                    conn c = new conn();
                    String withdrawl = tf.getText();
                    Date date = new Date();
                    String query = "insert into bank values ('" + pin + "','" + date + "','Withdraw','" + withdrawl + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Rs '"+withdrawl+"' debited successfully");

                    setVisible(false);
                    new transactions(pin).setVisible(true);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        } else if(e.getActionCommand().equals("Back")){
            setVisible(false);
            new transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new withdraw("");
    }
}
