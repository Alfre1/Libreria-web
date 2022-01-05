
package com.example.Egg.libreria.Servicios;

import com.example.Egg.libreria.Entidades.Autor;
import java.util.List;

/**
 *
 * @author Alfredo
 */
public interface AutorServices {
    
    public List<Autor> ListarAutores();
    
    public void GuardarAutor( Autor autor );
    
    public boolean EliminarAutor( Autor autor );
    
    public Autor BuscarAutor( Autor autor );
 
    public Autor BuscarIDAutor(Long id );
    
    public List<Autor> BuscarAutorPorNombre(String id ); 
    
    public void CambiarEstadoAutor( Autor autor );
    public void VerificarAutorDuplicado(Autor autor);
}
