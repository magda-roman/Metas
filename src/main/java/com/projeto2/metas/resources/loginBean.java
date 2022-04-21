package com.projeto2.metas.resources;

import utils.JsfUtil;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Eduardo
 */
@Named
@ViewScoped
public class loginBean implements Serializable {

    private String usuario;
    private String senha;

    @EJB
    private GerUsuarioService gus;

    public void valida() {
        GerUsuario usr = gus.buscaObjetoUsuario(usuario);
        if (usr != null && usr.getSenha().equals(senha)) {
            JsfUtil.exibeMensagem("Sucesso");
            JsfUtil.redirecionar("/cadastroUsuario.xhtml");
        }
        JsfUtil.exibeErro("Usuário inválido");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
