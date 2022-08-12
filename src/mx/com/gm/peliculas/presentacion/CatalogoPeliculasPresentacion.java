package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;



public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        
        var opcion = -1;
        var scanner = new Scanner(System.in);
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        while (opcion != 0){
            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar catalogo de Peliculas\n"
                    + "2. Agregar pelicula\n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar pelicula\n"
                    + "0. salir");
            opcion =Integer.parseInt(scanner.nextLine()) ;
            
            switch (opcion) {
                case 1:
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula que desea agregar\n");
                    var NombrePelicula = scanner.nextLine();
                    catalogo.agrearPelicula(NombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la pelicula que desea buscar\n");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                    case 0:
                        System.out.println("Hasta pronto");
                        break;
                    default:
                       System.out.println("Opcion no definida");
                    break;
            }
        }
    }

  
}
