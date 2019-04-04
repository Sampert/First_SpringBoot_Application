/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.example.restapi.example.dao;

/**
 *
 * @author estagiodev
 */
public interface IBaseDao {
        
     void salvar(Object object);

    void alterar(Object object);

    void excluir(Object object);

    Object pesquisarPorId(Integer id);
}
