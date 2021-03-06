
package com.example.Egg.libreria.Entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Alfredo
 */
@Data
@Entity
@Table(name = "autor")
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idautor;
    
    @NotEmpty
    private String nombre_autor;
    
    private Boolean alta_autor;
}
