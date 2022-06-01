package Beans;

import Classes.GerUsuario;
import Services.GerUsuarioService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
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

    @Inject
    private AcessoBean acesso;

    private GerUsuario usuario = new GerUsuario();
    private List<GerUsuario> usuariosList = new ArrayList<>();

    @PostConstruct
    private void init() {
        if (acesso.getUl() == null || !acesso.getUl().isAdmin()) {
            JsfUtil.redirecionar("/publico/index.xhtml");
        }
    }

    public void salva() {
        try {
            usuario.setCpf(StringUtil.onlyNumbers(usuario.getCpf()));
            if (!StringUtil.isCPF(usuario.getCpf())) {
                JsfUtil.exibeErro("CPF inválido");
                return;
            }
            if (gus.isCpfCadastrado(usuario)) {
                JsfUtil.exibeAviso("Já existe um usuário com este CPF cadastrado");
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
        usuariosList = gus.buscaLista();
        JsfUtil.showDlg("dlgBscUsuarios");
    }

    public void selecionaUsuario(GerUsuario usu) {
        usuario = usu;
        JsfUtil.exibeMensagem("Usuário selecionado com sucesso");
        JsfUtil.hideDlg("dlgBscUsuarios");
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

    public List<GerUsuario> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<GerUsuario> usuariosList) {
        this.usuariosList = usuariosList;
    }
}
