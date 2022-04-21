package com.projeto2.metas.resources;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Eduardo Mokfa
 */
@Named
@ViewScoped
public class GerUsuarioBean implements Serializable{
    
    @EJB
    GerUsuarioService gus;
    
    private GerUsuario usuario;
    
    public void salva(){
        
    }

    public GerUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(GerUsuario usuario) {
        this.usuario = usuario;
    }
    
    
}
