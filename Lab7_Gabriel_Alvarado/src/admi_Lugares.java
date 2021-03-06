
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
public class admi_Lugares {
    private ArrayList<Lugares> ListLugares = new ArrayList();
    private File archivo;

    public admi_Lugares(String Path) {
        archivo=new File(Path);
    }

    public ArrayList<Lugares> getListLugares() {
        return ListLugares;
    }

    public void setListLugares(ArrayList<Lugares> ListLugares) {
        this.ListLugares = ListLugares;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
     public void cargarArchivo() {
        try {
            ListLugares = new ArrayList();
            Lugares temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Lugares) objeto.readObject()) != null) {
                        ListLugares.add(temp);
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
            for (Lugares t : ListLugares) {
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
