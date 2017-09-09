
import java.util.ArrayList;
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
public class lugar extends Thread {

    public String nombre;
    public String clima;
    public String extension;
    public String cantidad;
    public String tipo;
    public String año;
    public ArrayList<Persona> ListPersonas = new ArrayList();
    public Tabla ventana = new Tabla();

    public static final long SerailVersionUID = 777L;

    public lugar() {
    }

    public lugar(String nombre, String clima, String extension, String cantidad, String tipo, String año, ArrayList e) {
        this.nombre = nombre;
        this.clima = clima;
        this.extension = extension;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.año = año;
        this.ListPersonas = e;
    }

    public Tabla getVentana() {
        return ventana;
    }

    public void setVentana(Tabla ventana) {
        this.ventana = ventana;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
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
        JTable m = new JTable();
        Tabla y = new Tabla();
        DefaultTableModel model = (DefaultTableModel) ventana.Table_personas.getModel();
        while (true) {
            while (ventana.Table_personas.getRowCount() > 0) {
                model.removeRow(0);
            }
            ventana.Table_personas.setModel(model);
            for (Persona t : ListPersonas) {
                System.out.println(t.getNombre());
                if (t.getLugar().equals(nombre)) {
                    Object Fila[] = {t.getNombre(), t.getId(), t.getLugar(), t.getEstatura(), t.getProfesion()};
                    model.addRow(Fila);
                }
            }
            ventana.Table_personas.setModel(model);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
