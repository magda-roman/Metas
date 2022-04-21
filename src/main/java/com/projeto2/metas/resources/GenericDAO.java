/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto2.metas.resources;

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
}
