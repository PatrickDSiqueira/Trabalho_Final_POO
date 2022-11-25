package br.com.programajframe;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFirstName, tfLastname;
    JLabel lbWelcome;

    /**
     * 
     */
    public void initialize() {
        // Form Panel//

        JLabel lbFirtname = new JLabel("First Name ");
        lbFirtname.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastname = new JLabel("First Name ");
        lbLastname.setFont(mainFont);

        tfLastname = new JTextField();
        tfLastname.setFont(mainFont);
        JPanel formJPanel = new JPanel();
        formJPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formJPanel.setOpaque(false);
        formJPanel.add(lbFirtname);
        formJPanel.add(tfFirstName);
        formJPanel.add(lbLastname);
        formJPanel.add(tfLastname);

        /// Welcome label
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        // Button Panel
        JButton btnOk = new JButton("ok");
        btnOk.setFont(mainFont);
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String firstName = tfFirstName.getText();
                String lastName = tfLastname.getText();
                lbWelcome.setText("Hello " + firstName + " " + lastName);
            }

        });

        JButton btnClear = new JButton("clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tfFirstName.setText("");
                tfLastname.setText("");
                lbWelcome.setText("");
            }

        });
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOk);
        buttonsPanel.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(formJPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Rede Social");
        setSize(500, 600);
        setMinimumSize(new Dimension());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
