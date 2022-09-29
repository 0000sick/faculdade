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
public class FicheiroUsuario {

    public ArrayList<usuario> lista() {
        ArrayList<usuario> lista = new ArrayList();

        try {

            FileInputStream readData = new FileInputStream("src\\banco\\usuario.dat");
            ObjectInputStream os = new ObjectInputStream(readData);

            lista = (ArrayList<usuario>) os.readObject();

            os.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheiroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheiroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    } 
   public void create(usuario p) {
        ArrayList<usuario> lista = new ArrayList();

        lista = (ArrayList<usuario>) lista().clone();
        lista.add(p);

        try {
            File bancoDados = new File("src\\banco\\usuario.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(bancoDados));

            objectOutputStream.writeObject(lista);

            objectOutputStream.close();

            System.out.println("Salvo com sucesso");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public usuario procura(String nome) {
        try {

            FileInputStream readData = new FileInputStream("src\\banco\\usuario.dat");
            ObjectInputStream os = new ObjectInputStream(readData);

            ArrayList<usuario> lista = (ArrayList<usuario>) os.readObject();
            for (usuario pessoa : lista) {
                if (pessoa.getUsername().equals(nome)) {
                    return pessoa ;
                }
            }
            os.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheiroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "verifique seus dados");
        } catch (IOException ex) {
            Logger.getLogger(FicheiroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheiroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "verifique seus dados");

        }
        return  null;
    } 


}
