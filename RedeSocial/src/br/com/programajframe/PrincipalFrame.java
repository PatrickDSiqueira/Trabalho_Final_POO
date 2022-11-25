package br.com.programajframe;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class PrincipalFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JPanel mainPanel = new JPanel();

    public PrincipalFrame() {
        reiniciarMainPainel();

        setTitle("Rede Social");
        setSize(500, 600);
        setMinimumSize(new Dimension());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void reiniciarMainPainel() {

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.mainPanel = mainPanel;
        add(this.mainPanel);
    }

    /**
     * 
     */
    public void initialize() {

        // JTextField tfFirstName, tfLastname;
        // JLabel lbWelcome;
        // // Form Panel//

        // JLabel lbFirtname = new JLabel("First Name ");
        // lbFirtname.setFont(mainFont);

        // tfFirstName = new JTextField();
        // tfFirstName.setFont(mainFont);

        // JLabel lbLastname = new JLabel("First Name ");
        // lbLastname.setFont(mainFont);

        // tfLastname = new JTextField();
        // tfLastname.setFont(mainFont);
        // JPanel formJPanel = new JPanel();
        // formJPanel.setLayout(new GridLayout(4, 1, 5, 5));
        // formJPanel.setOpaque(false);
        // formJPanel.add(lbFirtname);
        // formJPanel.add(tfFirstName);
        // formJPanel.add(lbLastname);
        // formJPanel.add(tfLastname);

        // /// Welcome label
        // lbWelcome = new JLabel();
        // lbWelcome.setFont(mainFont);
        // // < - - Welcome label

        // // Button Panel
        // JButton btnOk = new JButton("ok");
        // btnOk.setFont(mainFont);
        // btnOk.addActionListener(new ActionListener() {

        // @Override
        // public void actionPerformed(ActionEvent e) {
        // // TODO Auto-generated method stub
        // String firstName = tfFirstName.getText();
        // String lastName = tfLastname.getText();
        // lbWelcome.setText("Hello " + firstName + " " + lastName);
        // }

        // });

        // JButton btnClear = new JButton("clear");
        // btnClear.setFont(mainFont);
        // btnClear.addActionListener(new ActionListener() {

        // @Override
        // public void actionPerformed(ActionEvent e) {
        // // TODO Auto-generated method stub
        // tfFirstName.setText("");
        // tfLastname.setText("");
        // lbWelcome.setText("");
        // }

        // });
        // JPanel buttonsPanel = new JPanel();
        // buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        // buttonsPanel.setOpaque(false);
        // buttonsPanel.add(btnOk);
        // buttonsPanel.add(btnClear);

        // menu inicial Panel
        JButton btnCadastrar = new JButton("Criar Cadastro");
        btnCadastrar.setFont(mainFont);

        JButton bntLogar = new JButton("Logar");
        bntLogar.setFont(mainFont);
       
        JButton bntFecharPrograma = new JButton("Encerrar Programa");
        bntFecharPrograma.setFont(mainFont);

        JLabel lbInicio = new JLabel("Olá");
        lbInicio.setFont(mainFont);

        JPanel jpMenuInicial = new JPanel();
        jpMenuInicial.add(lbInicio);
        jpMenuInicial.add(btnCadastrar);
        jpMenuInicial.add(bntLogar);
        jpMenuInicial.add(bntFecharPrograma);
        jpMenuInicial.setLayout(new GridLayout(4, 1, 2, 2));
        jpMenuInicial.setOpaque(false);
        
        this.mainPanel.add(jpMenuInicial, BorderLayout.CENTER);
        add(this.mainPanel);

        // menu inicial Panel


        // mainPanel.add(formJPanel, BorderLayout.NORTH);
        // mainPanel.add(lbWelcome, BorderLayout.CENTER);
        // mainPanel.add(buttonsPanel, BorderLayout.SOUTH);


    }

    public void login() {
        JPanel login = new JPanel();
        reiniciarMainPainel();
        JLabel lbEmail = new JLabel("Email");
        JLabel lbSenha = new JLabel("Senha");
        lbEmail.setFont(mainFont);
        lbSenha.setFont(mainFont);
        login.add(lbEmail);

        login.add(lbSenha);
        login.setLayout(new GridLayout(4, 1, 10, 10));



        this.mainPanel.add(login, BorderLayout.CENTER);
        add(this.mainPanel);
    }

    public static void main(String[] args) {

        PrincipalFrame principalFrame = new PrincipalFrame();

        principalFrame.login();

    }
}
