
package mx.com.gm.peliculas.datos.AccesoDatos;
import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula.Pelicula;
import mx.com.gm.peliculas.excepciones.*;


public interface AccesoDatos {

    
    public boolean existe(String nombreArchivo) throws AccesoDatosEx;   
    
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx;
    
    public void escribir(Pelicula pelicula,String nombreArchivo,boolean  anexar)throws EstructuraDatosEx;
    
    public String buscar(String nombreArchivo,String buscar)throws LecturaDatosEx;

    public void crear (String nombreArchivo)throws AccesoDatosEx;
    
    public void borrar (String nombreArchivo)throws AccesoDatosEx;
}
