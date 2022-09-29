package telas;

import classe.Divida;
import classe.FicheiroDivida;
import classe.FicheiroUsuario;
import classe.usuario;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

class TelaPrincipal extends JFrame implements ActionListener {

    TextArea txt8 = new TextArea(10, 30);
    JLabel btnNome = new JLabel("Nome: ");
    JTextField txtNome = new JTextField(12);  //Botoes de escopo Global
    JLabel btnApelido = new JLabel("Apelido ");
    JTextField txtApelido = new JTextField(12);
    JLabel btnValor_divida = new JLabel("Valor Da Divida");
    JTextField txtValor_divida = new JTextField(12);
    JLabel btnValor_apagar = new JLabel("Valor Apagar");
    JTextField txtValor_apagar = new JTextField(12);
    JLabel btnEstado_divida = new JLabel("Valor Apagar");
    JTextField txtEstado_divida = new JTextField(12);
    JLabel btnIDD = new JLabel("Id");
    JTextField txtIDD = new JTextField(12);
    JLabel data = new JLabel("Data");
    JTextField txt6 = new JTextField(12);
    FicheiroDivida fh = new FicheiroDivida();
    JButton btnGuardar = new JButton("Guardar");
    JButton btnNovo = new JButton("Novo");
    JButton btnCancelar = new JButton("Cancelar");
    JTextField txt11 = new JTextField(12);
    JMenu Relatorio = new JMenu("Relatorio");
    JButton btnPesquisar = new JButton("Pesquisar");
    JTextField txt7 = new JTextField(12);

    JTextField txt9 = new JTextField(12);
    JButton nD1 = new JButton("Eliminar");
    JButton btnIVisualizar = new JButton("visualizar");
    JTextField txt10 = new JTextField(12);
    JButton btnVoltar = new JButton("Voltar");
    JPanel p = new JPanel();
    JPanel p1 = new JPanel();
    JTable table;
    double ale = Math.random();
    int aleatoria = (int) (200 + ale * (1000 - 200)), c;
    double divida, valor_apagar;
    String nome, apelido, estado, dat;
    LocalDate Data;

    char sxo;
    int btnVoltarxde;
    Date date;
    ArrayList<Divida> lista;
    String mat[][];
    Divida aux;
    DefaultTableModel modelo;

    public TelaPrincipal() {

        super("Exame");

        table = new JTable();

        setLayout(null);
        Border br = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "DivbtnVoltara");
        p.setBorder(br);
        p.setBackground(Color.gray);
        p.setLayout(null);

        Border br1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Lista de DivbtnVoltara");
        p1.setBorder(br1);
        p1.setBackground(new Color(62, 154, 148));
        p1.setLayout(null);

        JScrollPane barraRolagem = new JScrollPane(table);
        p1.add(barraRolagem);
        p.add(btnNome);
        p.add(txtNome);
        p.add(btnApelido);
        p.add(txtApelido);
        p.add(btnValor_divida);
        p.add(txtValor_divida);
        p.add(btnValor_apagar);
        p.add(txtValor_apagar);
        p.add(btnEstado_divida);
        p.add(txtEstado_divida);
        p.add(btnIDD);
        p.add(txtIDD);
        p.add(data);
        p.add(txt6);
        p.add(data);
        p.add(txt6);
        p.add(btnGuardar);
        p.add(btnNovo);
        p.add(btnCancelar);

        add(p);
        add(Relatorio);
        p1.add(txt7);
        add(txt8);
        p.add(txt9);
        p1.add(nD1);
        add(txt10);
        add(txt11);
        p1.add(btnPesquisar);
        p1.add(btnVoltar);
        p1.add(btnIVisualizar);
        add(p1);

        barraRolagem.setBounds(30, 220, 850, 260);
        btnNome.setBounds(30, 80, 150, 20);
        txtNome.setBounds(130, 80, 150, 20);
        btnApelido.setBounds(30, 150, 150, 20);
        txtApelido.setBounds(130, 150, 150, 20);
        btnValor_divida.setBounds(30, 220, 150, 20);
        txtValor_divida.setBounds(130, 220, 150, 20);
        btnIDD.setBounds(30, 290, 150, 20);
        txtIDD.setBounds(130, 290, 150, 20);
        data.setBounds(30, 360, 200, 20);
        txt6.setBounds(130, 360, 150, 20);
        btnGuardar.setBounds(30, 460, 100, 20);
        btnNovo.setBounds(140, 460, 100, 20);
        btnCancelar.setBounds(250, 460, 110, 20);
        btnPesquisar.setBounds(200, 60, 130, 20);
        txt7.setBounds(40, 60, 150, 20);
        nD1.setBounds(750, 60, 130, 20);
        btnVoltar.setBounds(750, 100, 130, 20);
        btnIVisualizar.setBounds(740, 150, 160, 20);
        p.setBounds(10, 80, 400, 500);
        p1.setBounds(430, 80, 910, 500);

        btnGuardar.addActionListener(this);
        btnNovo.addActionListener(this);
        btnCancelar.addActionListener(this);
        nD1.addActionListener(this);
        btnPesquisar.addActionListener(this);
        btnVoltar.addActionListener(this);
        btnIVisualizar.addActionListener(this);

        btnGuardar.setIcon(new ImageIcon("src\\img\\salvar-silhueta-de-icone.png"));
        btnPesquisar.setIcon(new ImageIcon("src\\img\\documento.png"));
        nD1.setIcon(new ImageIcon("src\\img\\do-utilizador.png"));
        btnNovo.setIcon(new ImageIcon("src\\img\\add-group.png"));
        btnCancelar.setIcon(new ImageIcon("src\\img\\cancelar (2) icon.png"));

        modelo = (DefaultTableModel) table.getModel();
        modelo.setDataVector(new Object[][]{}, new String[]{
            " Id ", " Nome ", " Apelido ", " Valor da Divida ", "Valor Apagar", "Estado da Divida ", "  Data "
        });
        atualizar();

    }

    void atualizar() {
        lista = (ArrayList<Divida>) fh.lista().clone();
        for (Divida func : lista) {
            modelo.addRow(new Object[]{
                func.getId(), func.getNomeDevedor(), func.getApelidoDevedor(), func.getValorDivida(), func.getValorAPagar(),
                func.getEstadoDivida(), func.getData()
            });
        }
    }

//Metodo para limpar os campos da tela 
    public void limpar() {
        txtNome.setText("");
        txt6.setText("");
        txtIDD.setText("");
        txtApelido.setText("");
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnGuardar) {
            try {
                if (txtEstado_divida.getText().isEmpty() || txtNome.getText().isEmpty() || txtApelido.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha os campos!");
                } else {
                    nome = txtNome.getText();
                    apelido = txtApelido.getText();
                    divida = Double.parseDouble(txtValor_apagar.getText());
                    if (divida <= 100) {
                        valor_apagar = divida + 0.4;
                    } else if (divida <= 500) {
                        valor_apagar = divida + 0.3;
                    } else if (divida <= 1000) {
                        valor_apagar = divida + 0.2;
                    } else if (divida > 1000) {
                        valor_apagar = divida + 0.15;
                    }
                    if (divida == 0) {
                        estado = "Pago";
                    } else {
                        estado = "Nao Pago";
                    }
                    lista.add(new Divida(aleatoria, nome, apelido, Data, divida, valor_apagar, estado));
                    limpar();
                    mat = new String[lista.size()][7];
                    for (int i = 0; i < lista.size(); i++) {
                        aux = lista.get(i);
                        mat[i][0] = Integer.toString(aux.getId());
                        mat[i][1] = aux.getNomeDevedor();
                        mat[i][2] = aux.getApelidoDevedor();
                        mat[i][3] = String.valueOf(aux.getData());
                        mat[i][4] = Double.toString(aux.getValorDivida());
                        mat[i][5] = Double.toString(aux.getValorAPagar());
                        mat[i][6] = aux.getEstadoDivida();
                    }
                    aux.setId(aleatoria);
                    aux.setNomeDevedor(nome);
                    aux.setApelidoDevedor(apelido);
                    aux.setValorDivida(valor_apagar);
                    aux.setValorAPagar(divida);
                    aux.setEstadoDivida(estado);
                    aux.setData(Data);

                    Divida med = new Divida();
                    med.setId(aleatoria);
                    med.setNomeDevedor(nome);
                    med.setApelidoDevedor(apelido);
                    med.setValorDivida(valor_apagar);
                    med.setValorAPagar(divida);
                    med.setEstadoDivida(estado);
                    med.setData(Data);

                    fh.create(med);

                    modelo.addRow(new Object[]{
                        med.getId(),
                        med.getNomeDevedor(),
                        med.getApelidoDevedor(),
                        med.getValorDivida(),
                        med.getValorAPagar(),
                        med.getEstadoDivida(),
                        med.getData()
                    });
                    limpar();
                }
            } catch (Exception ev) {

            }
        }
        if (e.getSource() == btnNovo) {
            Data = LocalDate.now();
            txt6.setText(Data.toString());
            txtIDD.setText(Integer.toString(aleatoria));
        }

        if (e.getSource() == nD1) {
            try {
                modelo.removeRow(c = table.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Eliminado  Com sucesso");

            } catch (IndexOutOfBoundsException q) {
                JOptionPane.showMessageDialog(null, "Por favor selecione um paciente!");
            }
        }

        if (e.getSource() == btnCancelar) {
            limpar();
        }

        if (e.getSource()
                == btnPesquisar) {
            Divida med = fh.procura(txt7.getText());
            if (med != null) {
                txtNome.setText(med.getNomeDevedor());
                txtApelido.setText(med.getApelidoDevedor());
                txtValor_divida.setText(Double.toString(med.getValorDivida()));
//                txtValor_apagar.setText(Double.toString(med.getValorAPagar()));
//                txtEstado_divida.setText(med.getEstadoDivida());

            } else {
                JOptionPane.showMessageDialog(null, "Nao existe");
            }
        }

        if (e.getSource() == btnVoltar) {
            MyFrame f = new MyFrame();
            f.setSize(600, 400);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocation(350, 180);
            f.setResizable(false);
            dispose();
        }

        if (e.getSource() == btnIVisualizar) {

        }

    }

}

public class Tela_Principal {

    public static void main(String[] args) {

        TelaPrincipal c = new TelaPrincipal();
        c.setSize(1380, 700);
        c.setVisible(true);
        c.setResizable(false);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
