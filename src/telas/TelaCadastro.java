package telas;

import classe.FicheiroUsuario;
import classe.usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

class TelaCadastro extends JFrame implements ActionListener {

    JLabel nome = new JLabel("Nome ");
    JLabel usuario = new JLabel();
    JTextField txtNome = new JTextField(12);  //Botoes de escopo Globa
    JLabel senh = new JLabel("Confirmar Senha");
    JPasswordField txtSenha = new JPasswordField(12);
    JLabel senha1 = new JLabel("Senha");
    JPasswordField txtSenha2 = new JPasswordField(12);
    JButton btnGuardar = new JButton("Guardar");
    JButton btnVoltar = new JButton();
    JButton btnGuardar2 = new JButton("Cancelar");
    FicheiroUsuario fh = new FicheiroUsuario();
    JPanel p = new JPanel();
    int se1, se2;
    String name;
    ArrayList<usuario> lista = new ArrayList<usuario>();

    public TelaCadastro() {

        super("Cadastro");

        setLayout(null);
        Border br = BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Cadastrar");
        p.setBorder(br);
//        p.setBackground(new Color(0,10,30));
        p.setLayout(null);

        p.add(usuario);
        p.add(nome);
        p.add(txtNome);
        p.add(senh);
        p.add(txtSenha);
        p.add(senha1);
        p.add(txtSenha2);
        p.add(btnGuardar);
        p.add(btnVoltar);
        p.add(btnGuardar2);
        add(p);

        btnGuardar.setIcon(new ImageIcon("src\\img\\salvar-silhueta-de-icone.png"));
        usuario.setIcon(new ImageIcon("src\\img\\avatar-de-perfil (1).png"));
        btnVoltar.setIcon(new ImageIcon("src\\img\\botao-voltar.png"));

        usuario.setBounds(210, 40, 150, 80);
        btnVoltar.setBounds(10, 40, 50, 25);
        nome.setBounds(100, 130, 150, 20);
        txtNome.setBounds(180, 130, 150, 20);
        senh.setBounds(60, 280, 150, 20);
        txtSenha.setBounds(180, 190, 150, 20);
        senha1.setBounds(100, 200, 150, 20);
        txtSenha2.setBounds(180, 200, 150, 20);
        txtSenha.setBounds(180, 280, 150, 20);
        btnGuardar.setBounds(180, 360, 150, 20);
        p.setBounds(0, 0, 483, 460);

        btnGuardar.addActionListener(this);
        btnVoltar.addActionListener(this);
        btnGuardar2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            MyFrame f = new MyFrame();
            f.setSize(600, 400);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocation(350, 180);
            f.setResizable(false);
            dispose();

        }
        if (e.getSource() == btnGuardar) {

            try {
                name = txtNome.getText();
                se1 = Integer.parseInt(txtSenha.getText());
                se2 = Integer.parseInt(txtSenha2.getText());
                if ("".equals(txtNome.getText()) || "".equals(txtSenha.getText()) || "".equals(txtSenha2.getText())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

                } else if (se1==se2) {
                    fh.create(new usuario(name, se1));
                    JOptionPane.showMessageDialog(null, "salvo com sucesso...");
                } else if (se1==se2) {
                    JOptionPane.showMessageDialog(null, "Volte a confirmar a senha!");
                }
            } catch (Exception ev) {

            }

        }

    }

}

class Principal {

    public static void main(String[] args) {

        TelaCadastro cadastro = new TelaCadastro();
        cadastro.setSize(500, 500);
        cadastro.setVisible(true);
        cadastro.setResizable(false);
        cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadastro.setLocation(330, 180);
    }

}
