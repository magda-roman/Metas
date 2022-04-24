package Beans;

import Classes.GerUsuario;
import Services.GerUsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import utils.JsfUtil;
import utils.SecUtil;
import utils.StringUtil;

/**
 *
 * @author Eduardo Mokfa
 */
@Named
@ViewScoped
public class GerUsuarioBean implements Serializable {

    @EJB
    GerUsuarioService gus;

    private GerUsuario usuario = new GerUsuario();

    public void salva() {
        try {
            if (!StringUtil.ValidaCNPJCPF(usuario.getCpf())) {
                JsfUtil.exibeErro("CPF inválido");
                return;
            }
            usuario.setSenha(SecUtil.Encript(usuario.getSenha()));
            gus.salvar(usuario);
            JsfUtil.exibeMensagem("Sucesso");
            usuario = new GerUsuario();
        } catch (Exception e) {
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
