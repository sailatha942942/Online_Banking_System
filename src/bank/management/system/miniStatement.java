package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class miniStatement extends JFrame {

    miniStatement(String pin) {

        setTitle("Mini Statement");
        setLayout(null);

        JLabel l1 = new JLabel();
        l1.setBounds(20, 130, 400, 200);
        add(l1);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,30);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);


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
            ResultSet rs = c.s.executeQuery("select * From bank where pin = '"+pin+"'");
            StringBuilder resultText = new StringBuilder("<html>");
            StringBuilder updatedrs = resultText.append("<table border='1'><tr><th>Date</th><th>Type</th><th>Amount</th></tr>");


            while(rs.next()) {
                String date = rs.getString("date"); // Assuming the column name is "date"
                String type = rs.getString("type"); // Assuming the column name is "type"
                double amount = rs.getDouble("amount"); // Assuming the column name is "amount"

                updatedrs.append("<tr>")
                        .append("<td>").append(date).append("</td>")
                        .append("<td>").append(type).append("</td>")
                        .append("<td>").append(amount).append("</td>")
                        .append("</tr>");

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
