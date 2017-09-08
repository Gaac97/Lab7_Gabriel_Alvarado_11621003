
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel Alvarado
 */
public class admiPersonas {
    private ArrayList<Personas> ListPersonas = new ArrayList();
    private File archivo;

    public admiPersonas(String path) {
        archivo=new File(path);
    }

    public ArrayList<Personas> getListPersonas() {
        return ListPersonas;
    }

    public void setListPersonas(ArrayList<Personas> ListPersonas) {
        this.ListPersonas = ListPersonas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
     public void cargarArchivo() {
        try {
            ListPersonas = new ArrayList();
            Personas temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Personas) objeto.readObject()) != null) {
                        ListPersonas.add(temp);
                    }
                } catch (EOFException e) {
                    //Encotro el final del archivo
                }
                objeto.close();
                entrada.close();
            }//fin if
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Personas t : ListPersonas) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception e) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        }
    }
    
}
