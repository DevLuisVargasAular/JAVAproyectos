
package mx.com.gm.peliculas.negocio;


import mx.com.gm.peliculas.datos.AccesoDatos.*;
import mx.com.gm.peliculas.domain.Pelicula.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;


public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agrearPelicula(String NombrePelicula) {
    Pelicula pelicula=new Pelicula(NombrePelicula);
    boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Excepcion al acceso de datos");
            ex.printStackTrace(System.out);
            
       
            
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var pelicula = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula1 : pelicula) {
                System.out.println(pelicula1);
                
            }
        } catch (LecturaDatosEx ex) {
           System.out.println("Excepcion al acceso de datos");
            ex.printStackTrace(System.out);
        }
        

    }

    @Override
    public void buscarPelicula(String buscar) {
    String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Excepcion de lectura de datos");
            ex.printStackTrace(System.out);
        }
        System.out.println(resultado);
    }

    @Override
    public void iniciarArchivo() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
                
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("error de inicio de catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
   
    }

  
}
