package ar.com.lautaro.test;

import ar.com.lautaro.clases.Chofer;
import ar.com.lautaro.clases.Transportes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class testTransportes {

    public static void main(String[] args) {

        /* Consigna: 
        Una empresa de encomienda desea tener una aplicación que cargue tanto un lista 
        de los trasportes que llegan en un registro permanente así como cada día también
        Se carga una lista con los datos de los transportistas que transitaron solo para esa fecha.
        Transporte: contenido, proveedor, idChofer.
        Chofer: id (alfanumérico), nombre, numeroCamion.
         */
        test();

    }

    public static void crearDirectorio(String ruta) {
        File ejemploDir = new File(ruta);
        if (ejemploDir.exists()) {
            if (ejemploDir.isDirectory()) {
                JOptionPane.showInternalMessageDialog(null, "El directorio ya existe!!");
            }

        } else {
            // Si no existe el directorio lo creamos!! 
            ejemploDir.mkdir();
            JOptionPane.showInternalMessageDialog(null, "Se creo el directorio!!");

        }

    }

    public static void cargarDirectorio(File ruta) {
        // Crear archivos dentro del directorio.
        // función a modo de ejemplo, sin utilidad dentro del ejercicio!!
        if (ruta.exists()) {
            JOptionPane.showInternalMessageDialog(null, "Los archivos ya existen!!");
        } else {
            try {
                ruta.createNewFile();
                JOptionPane.showInternalMessageDialog(null, "Se crearon los archivos!!");
            } catch (IOException ex) {
                System.out.println("Error!! ");
                ex.printStackTrace(System.out);
            }
        }

    }

    public static void escrituraTransporte(File ruta, List<Transportes> lista) {

        try {
            FileOutputStream fo = new FileOutputStream(ruta, true);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            // writeObject()-> Solo en escritura de objetos 
            oo.writeObject(lista);

            fo.close();
            oo.close();
            JOptionPane.showMessageDialog(null, "Se escribió el archivo con los Transportes!!");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de escritura Transporte.");
            ex.printStackTrace(System.out);
        }
    }

    public static void escrituraChofer(File ruta, List<Chofer> lista) {
        try {
            // no le ponemos el 'true' porque queremos pisar los datos.
            FileOutputStream fo = new FileOutputStream(ruta);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            // writeObject()-> Solo en escritura de objetos 
            oo.writeObject(lista);

            fo.close();
            oo.close();
            JOptionPane.showMessageDialog(null, "Se escribió el archivo con los Choferes!!");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de escritura Choferes.");
            ex.printStackTrace(System.out);
        }
    }

    public static void escritura(List<Transportes> lista, String direc, Date fecha) {
        List<String> usar = lista.stream().map(x -> x + "\n").collect(Collectors.toList());
        String fechaEscrita = fecha.toString();
        try {
            // Poner el true para no perder la información!!
            BufferedWriter bw = new BufferedWriter(new FileWriter(direc, true));
            bw.write(fechaEscrita + "\n");
            for (String e : usar) {
                bw.write(e);
            }
            bw.write("-----------------------------------------------------------------------" + "\n");
            JOptionPane.showMessageDialog(null, "Se escribió el archivo de los transportes!!");
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error!!");
            ex.printStackTrace(System.out);
        }

    }

    public static void leer(String direccion) {
        try {
            FileReader fr = new FileReader(direccion);
            BufferedReader bf = new BufferedReader(fr);

            String linea = bf.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = bf.readLine();

            }

            bf.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println("Error!!");
            ex.printStackTrace(System.out);
        }

    }

    public static void escrituraObject(String direc, List<Chofer> lista, Date fecha) {
        try {
            // no le ponemos el 'true' porque queremos pisar los datos.
            FileOutputStream fo = new FileOutputStream(direc);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
//            oo.writeBytes(fechaEscrita);
            // writeObject()-> Solo en escritura de objetos 
            oo.writeObject(lista);

            fo.close();
            oo.close();
            JOptionPane.showMessageDialog(null, "Se escribió el archivo de los transportistas!!");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de escritura.");
            ex.printStackTrace(System.out);
        }
    }

    public static void lecturaObject(String direc) {

        try {
            FileInputStream fi = new FileInputStream(direc);
            ObjectInputStream oi = new ObjectInputStream(fi);
            List<Chofer> lista = (List<Chofer>) oi.readObject();
            lista.forEach(System.out::println);
            fi.close();
            oi.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de lectura. ");
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo de clase. ");
            ex.printStackTrace(System.out);
        }

    }

    public static void test() {
        List<Transportes> transporte = new ArrayList<>();
        List<Chofer> chofer = new ArrayList<>();
        transporte.add(new Transportes("Gaseosa", "CocaCola", "RT859P"));
        transporte.add(new Transportes("Golosinas", "Arcor", "NP452M"));
        transporte.add(new Transportes("Ropa", "Nike", "NI77KE"));
        transporte.add(new Transportes("Celulares", "Apple", "AP21LE"));
        chofer.add(new Chofer("CH01", "Lucio", 045));
        chofer.add(new Chofer("CH04", "Mariano", 777));
        chofer.add(new Chofer("CH9", "Marcelo", 014));
        chofer.add(new Chofer("CH11", "Brian", 839));
        chofer.add(new Chofer("CH7", "Nahuel", 053));
        String rutaDir = "directorio_transporte";
        String rutaT = rutaDir + File.separator + "ListaTransportes.txt";
        String rutaC = rutaDir + File.separator + "ListaTransportistas.dat";
        // año: 1900 + 122 = 2022
        // año/mes-1/dia
        Date fecha = new Date(122, 9, 30);
        // Llamada a las funciones.
        crearDirectorio(rutaDir);
        escritura(transporte, rutaT, fecha);
        escrituraObject(rutaC, chofer, fecha);
        leer(rutaT);
        lecturaObject(rutaC);

    }

}
