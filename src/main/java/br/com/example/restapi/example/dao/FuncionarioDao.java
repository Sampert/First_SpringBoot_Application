/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.example.restapi.example.dao;

import javax.persistence.EntityManager;

/**
 *
 * @author estagiodev
 */
public class FuncionarioDao  extends BaseDaoAbstract implements IFuncionarioDao {

    public FuncionarioDao(EntityManager em) {
        super(em);
    }
    
}
