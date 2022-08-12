package mx.com.gm.peliculas.datos.AccesoDatos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo)  {
        File archivo = new File(nombreArchivo);
        return archivo.exists();

    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        var archivo = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();
        try {

            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar pelicular" + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar pelicular" + ex.getMessage());
        }

        return peliculas;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EstructuraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo " + pelicula);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new EstructuraDatosEx("Error al escribir el archivo" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EstructuraDatosEx("Error al escribir el archivo" + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado ="el resultado es "+ null;

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while (linea!= null){
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "pelicula "+linea+ "encontrada en el indice "+ indice;
                    break;
                }
               linea= entrada.readLine();
               indice++;
               
            }
               entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("error al buscar el archivo"+ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("error al buscar el archivo"+ex.getMessage());
        }
           
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter (new FileWriter(nombreArchivo));
            salida.close();
            System.out.println("Se a creado un archivo y/o restaurado");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("no se a podido crear el archivo" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("no se a podido crear el archivo" + ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
       
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("se a eliminado el archivo");
        }
    }

}
