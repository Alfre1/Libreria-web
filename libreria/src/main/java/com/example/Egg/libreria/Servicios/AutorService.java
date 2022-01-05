
package com.example.Egg.libreria.Servicios;

import com.example.Egg.libreria.Dao.AutorDao;
import com.example.Egg.libreria.Dao.LibroDao;
import com.example.Egg.libreria.Entidades.Autor;
import com.example.Egg.libreria.Entidades.Libro;
import java.util.ArrayList;
import java.util.List;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Alfredo
 */
@Service
public class AutorService implements AutorServices{
 @Autowired
    private AutorDao autordao;

    @Autowired
    private LibroDao librodao;
    @Autowired
    private LibroService librosv;
    
    @Override
    @Transactional(readOnly = true)
    public List<Autor> ListarAutores() {
        return (List<Autor>) autordao.findAll();
    }

    @Override
    @Transactional
    public void GuardarAutor(Autor autor) {
        autordao.save(autor);
    }

    @Override
    @Transactional
    public boolean EliminarAutor(Autor autor) {
        
        var Libros = librosv.ListarLibros();
        
        boolean eliminar = true;
   
        for(Libro l : Libros){
            if(l.getAutor().getIdautor() == autor.getIdautor()){
                eliminar = false;
                break;
            }
        }
        
        if( eliminar )
            autordao.delete(autor);
        
        return eliminar;
    }

    @Override
    @Transactional(readOnly = true)
    public Autor BuscarAutor(Autor autor) {
        return (Autor) autordao.findById(autor.getIdautor()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Autor BuscarIDAutor(Long id) {
        Autor new_autor = (Autor) autordao.findById(id).orElse(null);
        return new_autor;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Autor> BuscarAutorPorNombre(String szName) {

        List<Autor> Autors = new ArrayList();
        Autors = ListarAutores();

        List<Autor> Search = new ArrayList();

        for (Autor search_autor : Search) {

            String szTemp = search_autor.getNombre_autor();

            if (szTemp.contains(szName)) {
                Search.add(search_autor);
            }
        }

        if (Search.size() > 0) {
            return Search;
        }

        return null;
    }

    @Override
    @Transactional
    public void CambiarEstadoAutor(Autor autor) {
        autor.setAlta_autor(!autor.getAlta_autor());
        autordao.save(autor);
    }

    @Override
    @Transactional(readOnly = true) 
    public void VerificarAutorDuplicado(Autor autor) {
        String szAutor = autor.getNombre_autor();
        var Autores = ListarAutores();

        for (Autor aux : Autores) {
            String temp = aux.getNombre_autor();

            if (szAutor.equalsIgnoreCase(temp)) {
                autor.setIdautor(aux.getIdautor());
                autor.setAlta_autor(aux.getAlta_autor());
                break;
            }
        }
    }

}