/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.example.restapi.example.dao;

import br.com.example.restapi.example.model.Funcionario;
import javax.persistence.EntityManager;

/**
 *
 * @author estagiodev
 */
public abstract class BaseDaoAbstract implements IBaseDao{
    
    protected EntityManager em;

    public BaseDaoAbstract(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public void salvar(Object object) {

        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void alterar(Object object) {

        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Object object) {

        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    @Override
    public Funcionario pesquisarPorId(Integer id) {

        em.getTransaction().begin();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.getTransaction().commit();

        return funcionario;
    }
}
