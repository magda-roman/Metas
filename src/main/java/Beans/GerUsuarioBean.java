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

    public void pesquisa() {
        if (StringUtil.nullOrEmpty(usuario.getNome())) {
            JsfUtil.exibeAviso("Digite o nome do usuário para pesquisar");
            return;
        }
        usuario = gus.buscaObjetoUsuario(usuario.getNome());
        if (usuario == null) {
            JsfUtil.exibeAviso("Nenhum usuário encontrado");
            limpar();
            return;
        }
    }

    public void limpar() {
        usuario = new GerUsuario();
    }

    public void excluir() {
        if (usuario.getCodigo() == null) {
            JsfUtil.exibeAviso("Pesquise um usuário para excluí-lo");
            return;
        }
        gus.excluir(usuario);
        JsfUtil.exibeMensagem("Usuário excluído com sucesso");
        limpar();
    }

    public GerUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(GerUsuario usuario) {
        this.usuario = usuario;
    }

}
