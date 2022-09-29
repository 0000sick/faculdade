package telas;

import classe.FicheiroUsuario;
import classe.usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

class MyFrame extends JFrame implements ActionListener {

    JLabel nome, lblUsuario;
    JTextField txtNome;
    JLabel senha;
    JPasswordField txtSenha;
    JButton ok, btEncerrar, cadast;
    JPanel p;
    FicheiroUsuario fh = new FicheiroUsuario();
    String name;
    int senh;

    MyFrame() {

        super("Login");

        nome = new JLabel("Nome");
        txtNome = new JTextField(15);
        senha = new JLabel("Senha");
        txtSenha = new JPasswordField();
        ImageIcon iconConfirmar = new ImageIcon("src\\img\\ok.png");
        ok = new JButton(iconConfirmar);
        ImageIcon iconDeslig = new ImageIcon("src\\img\\ligado-desligado.png");
        btEncerrar = new JButton(iconDeslig);
        ImageIcon iconUsuario = new ImageIcon("src\\img\\avatar-de-perfil (1).png");
        cadast = new JButton("cadastrar");
        lblUsuario = new JLabel(iconUsuario);
        p = new JPanel();

        setLayout(null);
        Border br = BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Login");
        p.setBorder(br);
//       p.setBackground(new Color(10, 40, 30));
        p.setLayout(null);

        p.add(lblUsuario);
        p.add(nome);
        p.add(txtNome);
        p.add(senha);
        p.add(txtSenha);
        p.add(btEncerrar);
        p.add(cadast);
        p.add(ok);
        add(p);

        ok.addActionListener(this);
        cadast.addActionListener(this);
        btEncerrar.addActionListener(this);

        lblUsuario.setBounds(300, 50, 50, 50);
        nome.setBounds(160, 130, 150, 20);
        txtNome.setBounds(240, 130, 200, 20);
        senha.setBounds(160, 180, 180, 20);
        txtSenha.setBounds(240, 180, 200, 20);
        cadast.setBounds(345, 230, 90, 20);
        btEncerrar.setBounds(10, 330, 50, 20);
        ok.setBounds(240, 230, 90, 20);
        p.setBounds(0, 0, 585, 360);

    }

    public void limpar() {
        txtNome.setText("");
        txtSenha.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btEncerrar) {
            System.exit(0);
        }
        if (e.getSource() == cadast) {
            TelaCadastro cadastro = new TelaCadastro();
            cadastro.setSize(500, 500);
            cadastro.setVisible(true);
            cadastro.setResizable(false);
            cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cadastro.setLocation(330, 180);
            dispose();
        }
    if (e.getSource() == ok) {
         name = txtNome.getText();
         senh = Integer.parseInt(txtSenha.getText());

        FicheiroUsuario f = new FicheiroUsuario();

        usuario fuc = f.procura(txtNome.getText());
        
        if (txtNome.getText().equals("") || txtSenha.getText().equals("")) {
          JOptionPane.showMessageDialog(null, "Verifique seus dados");
        } else if (fuc.getPassword() == senh && name.equals(fuc.getUsername())) {
            TelaPrincipal c = new TelaPrincipal();
            c.setSize(1380, 700);
            c.setVisible(true);
            c.setResizable(false);
            c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
    }

    }

    }

}

public class login {

    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(600, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(350, 180);
        f.setResizable(false);
    }

}
