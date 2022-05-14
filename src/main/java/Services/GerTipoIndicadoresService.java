/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Classes.GerTipoIndicadores;
import com.projeto2.metas.resources.Crud.GenericDAO;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author edumokfa
 */
@Stateless
@LocalBean
public class GerTipoIndicadoresService extends GenericDAO<GerTipoIndicadores> {

    @Override
    public void salvar(GerTipoIndicadores object) {
        super.salvar(object);
    }

    public GerTipoIndicadores busca(Integer id) {
        return super.busca(GerTipoIndicadores.class, id);
    }
}
