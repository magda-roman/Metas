/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import Classes.GerUsuario;
import Services.GerUsuarioService;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import utils.JsfUtil;
import utils.ListUtil;
import utils.SecUtil;

/**
 *
 * @author Eduardo
 */
@Named
@ViewScoped
public class AcessoBean implements Serializable {

    private String usuario;
    private String senha;

    @EJB
    private GerUsuarioService gus;

    public void valida() {
        Map<String, Object> filtros = new HashMap<>();
        filtros.put("nome", usuario);
        filtros.put("senha", SecUtil.Encript(senha));
        List<GerUsuario> usuarios = gus.filtrar(filtros);
        if (ListUtil.isNotEmpty(usuarios)) {
            JsfUtil.redirecionar("/");
        } else {
            JsfUtil.exibeErro("Usuário inválido");
        }
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
