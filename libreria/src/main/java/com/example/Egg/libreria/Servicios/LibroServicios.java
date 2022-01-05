
package com.example.Egg.libreria.Servicios;

import com.example.Egg.libreria.Entidades.Libro;
import java.util.List;

/**
 *
 * @author Alfredo
 */
public interface LibroServicios {
    
    public List<Libro> ListarLibros();
    
    public void GuardarLibro( Libro libro );
    
    public boolean EliminarLibro( Libro libro );
    
    public Libro BuscarLibro( Libro libro );
 
    public List<Libro> BuscarID(Long id );
    
    public List<Libro> BuscarPorNombre(String id );  

    public List<Libro> BuscarPorAutor(String szname);
    
    public void CambiarEstadoLibro( Libro libro );

}

