    
package classe;

import java.io.Serializable;
import java.time.LocalDate;


public class Divida implements Serializable{
   private int id; 
   private String nomeDevedor;
   private String apelidoDevedor;
   private LocalDate data;
   private double valorDivida; 
   private double valorAPagar;
   private String estadoDivida;

    public Divida(int id ,String nomeDevedor, String apelidoDevedor, LocalDate data, double valorDívida,double valorAPagar, String estadoDivida) {
        this.id = id;
        this.nomeDevedor = nomeDevedor;
        this.apelidoDevedor = apelidoDevedor;
        this.data = data;
        this.valorDivida = valorDívida;
        this.valorAPagar = valorAPagar;
        this.estadoDivida = estadoDivida;
    }

    public Divida() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Divida{" + "id=" + id + ", nomeDevedor=" + nomeDevedor + ", apelidoDevedor=" + apelidoDevedor + ", data=" + data + ", valorD\u00edvida=" + valorDivida + ", valorAPagar=" + valorAPagar + ", estadoDivida=" + estadoDivida + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDevedor() {
        return nomeDevedor;
    }

    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    public String getApelidoDevedor() {
        return apelidoDevedor;
    }

    public void setApelidoDevedor(String apelidoDevedor) {
        this.apelidoDevedor = apelidoDevedor;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public String getEstadoDivida() {
        return estadoDivida;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setEstadoDivida(String estadoDivida) {
        this.estadoDivida = estadoDivida;
    }


    
}
