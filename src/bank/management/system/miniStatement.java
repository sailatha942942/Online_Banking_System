package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class miniStatement extends JFrame {

    miniStatement(String pin) {

        setTitle("Mini Statement");
        setLayout(null);

        JLabel l1 = new JLabel();
        l1.setBounds(20, 130, 400, 400);
        add(l1);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,30);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,110,300,20);
        add(balance);

        JLabel stmt = new JLabel("The statement is shown below");
        stmt.setBounds(20,130,500,30);
        add(stmt);


        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * From login where \"PIN\" = '"+pin+"'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(13));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            conn c = new conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * From bank where pin = '"+pin+"'");
            StringBuilder resultText = new StringBuilder("<html>");
            StringBuilder updatedrs = resultText.append("<table border='1'><tr><th>Date</th><th>Type</th><th>Amount</th></tr>");


            while(rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                double amount = rs.getDouble("amount");

                updatedrs.append("<tr>")
                        .append("<td>").append(date).append("</td>")
                        .append("<td>").append(type).append("</td>")
                        .append("<td>").append(amount).append("</td>")
                        .append("</tr>");
                    if(rs.getString("type").equals("Deposit")){

                        bal += Integer.parseInt(rs.getString("amount"));

                    }
                    else if(rs.getString("type").equals("Withdraw") ) {

                        bal -= Integer.parseInt(rs.getString("amount"));

                    }
                balance.setText("Your current account balance is " + bal);

            }
            resultText.append("</html>"); // Close the HTML tag
            l1.setText(resultText.toString());


        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new miniStatement("");
    }
}
