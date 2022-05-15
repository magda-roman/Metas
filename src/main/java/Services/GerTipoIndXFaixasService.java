/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Classes.GerTipoIndXFaixas;
import com.projeto2.metas.resources.Crud.GenericDAO;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author edumokfa
 */
@Stateless
@LocalBean
public class GerTipoIndXFaixasService extends GenericDAO<GerTipoIndXFaixas> {

    @Override
    public void salvar(GerTipoIndXFaixas object) {
        super.salvar(object);
    }

    public GerTipoIndXFaixas busca(Integer id) {
        return super.busca(GerTipoIndXFaixas.class, id);
    }
}
