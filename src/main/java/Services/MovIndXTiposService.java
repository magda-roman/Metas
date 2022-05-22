/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Classes.MovIndXTipos;
import com.projeto2.metas.resources.Crud.GenericDAO;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import utils.DateUtil;

/**
 *
 * @author edumokfa
 */
@Stateless
@LocalBean
public class MovIndXTiposService extends GenericDAO<MovIndXTipos> {

    @Override
    public void salvar(MovIndXTipos object) {
        super.salvar(object);
    }

    public MovIndXTipos busca(Integer id) {
        return super.busca(MovIndXTipos.class, id);
    }
}
