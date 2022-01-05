
package com.example.Egg.libreria.Servicios;

import com.example.Egg.libreria.Entidades.Editorial;
import java.util.List;

/**
 *
 * @author Alfredo
 */
public interface EditorialServices {
      public List<Editorial> ListaEditorial();
    
    public void GuardarEditorial( Editorial editorial );
    
    public boolean EliminarEditorial( Editorial editorial );
   
    public Editorial BuscarEditorial( Editorial editorial );
 
    public Editorial BuscarIDEditorial(Long id );
    
    public List<Editorial> BuscarEditorialPorNombre(String szName ); 
    public void CambiarEstadoEditorial(Editorial ed);
    public void VerificarEditorialDuplicada(Editorial editorial);
    
}
