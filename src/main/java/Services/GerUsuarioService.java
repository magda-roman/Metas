/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Classes.GerUsuario;
import com.projeto2.metas.resources.Crud.GenericDAO;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author edumokfa
 */
@Stateless
@LocalBean
public class GerUsuarioService extends GenericDAO<GerUsuario> {

    @Override
    public void salvar(GerUsuario object) {
        super.salvar(object);
    }

    public GerUsuario busca(Integer id) {
        return super.busca(GerUsuario.class, id);
    }

    public boolean isCpfCadastrado(GerUsuario usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM GER_USUARIO GU ").append("WHERE GU.USR_CPF = '").append(usuario.getCpf()).append("' ");
        if (usuario.getCodigo() != null) {
            sb.append("AND GU.USR_ID <> ").append(usuario.getCodigo());
        }
        List<GerUsuario> usuarioList = super.executeNativeQuery(sb.toString(), GerUsuario.class);
        return usuarioList != null && !usuarioList.isEmpty();
    }
}
