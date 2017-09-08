
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel Alvarado
 */
public class lugar extends Thread{

    public String nombre;
    public String clima;
    public String extension;
    public int cantidad;
    public String tipo;
    public String año;
    public Tabla ventana = new Tabla(); 
    
    
    public static final long SerailVersionUID = 777L;

    public lugar(String nombre, String clima, String extension, int cantidad, String tipo, String año) {
        this.nombre = nombre;
        this.clima = clima;
        this.extension = extension;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public void run() {
        ventana.setVisible(true);
        ventana.table.setText(nombre);
        JTable m= new JTable();
        DefaultTableModel modelo = new DefaultTableModel();
        
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
    
}
