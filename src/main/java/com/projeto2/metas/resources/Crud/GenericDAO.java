/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto2.metas.resources.Crud;

import Classes.GerUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author edumokfa
 * @param <T>
 */
public abstract class GenericDAO<T> {
    
    @PersistenceContext(name = "sysdb")
    private EntityManager em;
    
    private Class<T> classe;

    public void salvar(T object) {
            em.merge(object);
            em.flush();
    }

    public void excluir(T object) {
            em.remove(object);
            em.flush();
    }

    public T busca(Class cl, Integer id) {
        return em.find((Class<T>) cl, id);
    }

    public List<T> buscaLista() {
        return em.createQuery("from " + classe.getSimpleName() + " e").getResultList();
    }
    
    public GerUsuario buscaObjetoUsuario(String nome){
        List<T> aux = em.createQuery("SELECT e FROM GerUsuario e WHERE e.nome = :nomeUsuario").setParameter("nomeUsuario", nome).setMaxResults(1).getResultList();
        GerUsuario retorno = null;
        if(aux != null && !aux.isEmpty()){
            retorno = (GerUsuario)aux.get(0);
        }
        return retorno;
    }
}
