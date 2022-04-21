/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto2.metas.resources;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author edumokfa
 */
@Stateless
@LocalBean
public class GerUsuarioService extends GenericDAO<GerUsuario>{

    @Override
    public void salvar(GerUsuario object) {
        super.salvar(object);
    }
    
    public GerUsuario busca(Integer id) {
        return super.busca(GerUsuario.class, id);
    }

}
