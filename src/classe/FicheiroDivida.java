/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KPROGRAMMER
 */
public class FicheiroDivida {

    static File directorio = new File("");
    File bancoDados = new File("src\\banco\\bd.dat");

    //
    public void CaminhoPrincipal() {

        if (directorio.exists()) {
            System.out.print("Direcorio OK!");
        } else {
            directorio.mkdir();
        }

        if (bancoDados.exists()) {
            System.out.print("Banco de dados OK!");

        } else {
            try {
                bancoDados.createNewFile();

                ArrayList<Divida> lista = new ArrayList();
                //File bancoDados=new File("banco\\bd.dat");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(bancoDados));

                objectOutputStream.writeObject(lista);

                objectOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void create(Divida p) {
        ArrayList<Divida> lista = new ArrayList();

        lista = (ArrayList<Divida>) lista().clone();
        lista.add(p);

        try {
            File bancoDados = new File("src\\banco\\bd.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(bancoDados));

            objectOutputStream.writeObject(lista);

            objectOutputStream.close();

            System.out.println("Salvo com sucesso");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        ArrayList<Divida> lista = new ArrayList();

        lista = (ArrayList<Divida>) lista().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId()== id) {
                lista.remove(i);
            }
        }

        try {
            File bancoDados = new File("src\\banco\\bd.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(bancoDados));

            objectOutputStream.writeObject(lista);

            objectOutputStream.close();

            System.out.println("Salvo com sucesso");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//     public void delete(int id) {
//        ArrayList<Divida> lista = new ArrayList();
//
//        lista = (ArrayList<Divida>) lista().clone();
//
//        for (int i = 0; i < lista.size(); i++) {
//
//            if (lista.get(i).getId()== id) {
//                lista.remove(i);
//            }
//        }
//
//        try {
//            File bancoDados = new File("src\\banco\\bd.dat");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(bancoDados));
//
//            objectOutputStream.writeObject(lista);
//
//            objectOutputStream.close();
//
//            System.out.println("Salvo com sucesso");
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public Divida procura(String nome) {
        try {

            FileInputStream readData = new FileInputStream("src\\banco\\bd.dat");
            ObjectInputStream os = new ObjectInputStream(readData);

            ArrayList<Divida> lista = (ArrayList<Divida>) os.readObject();
            for (Divida pessoa : lista) {
                if (pessoa.getNomeDevedor().equals(nome)) {
                    return pessoa;
                }
            }
            os.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "verifique seus dados");
        } catch (IOException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "verifique seus dados");

        }
        return  null;
    }

    
      public boolean login(String nome, int senha) {
        try {

            FileInputStream readData = new FileInputStream("src\\banco\\bd.dat");
            ObjectInputStream os = new ObjectInputStream(readData);

            ArrayList<Divida> lista = (ArrayList<Divida>) os.readObject();
            for (Divida pessoa : lista) {
//                if (pessoa.getNomeDevedor().equals(nome) && pessoa.getSenha().equals(senha)) {
//                    return true;
//                }
            }
            os.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "verifique seus dados");
        } catch (IOException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "verifique seus dados");

        }
        return  false;
    }

    public void edit(int id, Divida p) {
        ArrayList<Divida> lista = new ArrayList();

        lista = (ArrayList<Divida>) lista().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId()== id) {
                lista.remove(i);
                lista.add(p);
            }
        }

        try {
            File bancoDados = new File("src\\banco\\bd.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(bancoDados));

            objectOutputStream.writeObject(lista);

            objectOutputStream.close();

            System.out.println("Salvo com sucesso");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Divida> search(String pessoa) {
        ArrayList<Divida> lista = new ArrayList();

        lista = (ArrayList<Divida>) lista().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (!lista.get(i).getNomeDevedor().contentEquals(pessoa)) {

                lista.remove(i);
            }
        }
        return lista;
    }

    public ArrayList<Divida> lista() {
        ArrayList<Divida> lista = new ArrayList();

        try {

            FileInputStream readData = new FileInputStream("src\\banco\\bd.dat");
            ObjectInputStream os = new ObjectInputStream(readData);

            lista = (ArrayList<Divida>) os.readObject();

            os.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public void listas() {

        try {

            FileInputStream readData = new FileInputStream("src\\banco\\bd.dat");
            ObjectInputStream os = new ObjectInputStream(readData);

            ArrayList<Divida> lista = (ArrayList<Divida>) os.readObject();
            for (Divida pessoa : lista) {
                System.out.println("Nome:" + pessoa.getNomeDevedor());
                System.out.println("Senha:" + pessoa.getEstadoDivida());
            }
            os.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

 public void edit( Divida p) {
        ArrayList<Divida> lista = new ArrayList();

        lista = (ArrayList<Divida>) lista().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNomeDevedor().equals(p.getNomeDevedor())) {
                lista.remove(i);
                lista.add(p);
            }
        }

        try {
            File bancoDados = new File("src\\banco\\bd.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(bancoDados));

            objectOutputStream.writeObject(lista);

            objectOutputStream.close();

            System.out.println("Salvo com sucesso");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheiroDivida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
