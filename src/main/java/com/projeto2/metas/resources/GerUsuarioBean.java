package com.projeto2.metas.resources;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import utils.JsfUtil;

/**
 *
 * @author Eduardo Mokfa
 */
@Named
@ViewScoped
public class GerUsuarioBean implements Serializable{
    
    @EJB
    GerUsuarioService gus;
    
    private GerUsuario usuario = new GerUsuario();
    
    public void salva(){
        try{
        gus.salvar(usuario); 
        JsfUtil.exibeMensagem("Sucesso");
        usuario = new GerUsuario();
        }catch(Exception e){
            e.printStackTrace();
            JsfUtil.fatal("Falha na inclusão");
        }
    }

    public GerUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(GerUsuario usuario) {
        this.usuario = usuario;
    }
    
    
}
