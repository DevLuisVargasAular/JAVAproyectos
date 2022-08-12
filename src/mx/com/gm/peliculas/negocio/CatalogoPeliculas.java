package mx.com.gm.peliculas.negocio;

public interface CatalogoPeliculas {
    String NOMBRE_RECURSO = "peliculas.txt";

    public void agrearPelicula(String NombrePelicula);

    public void listarPeliculas();
    
    public void buscarPelicula(String buscar);
    
    public void iniciarArchivo();
}
