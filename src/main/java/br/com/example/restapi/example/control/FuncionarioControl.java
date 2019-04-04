/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.example.restapi.example.control;

import br.com.example.restapi.example.dao.ConnectionFactory;
import br.com.example.restapi.example.dao.FuncionarioDao;
import br.com.example.restapi.example.model.Funcionario;

import javax.persistence.EntityManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estagiodev
 */
@RestController
@RequestMapping("/funcionario")
public class FuncionarioControl {

    private EntityManager em;

    @RequestMapping(value = "/push/{nome}")
    public String salvarFuncionario(@PathVariable String nome) {

        em = ConnectionFactory.openConnection();
        FuncionarioDao funcionarioDao = new FuncionarioDao(em);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);

        try {
            funcionarioDao.salvar(funcionario);
        } catch (Exception e) {
            return e.toString();
        }
        return "Success!";
    }

    @GetMapping(value = "/get/{id}")
    public Funcionario getFuncionario(@PathVariable Integer id) {

        em = ConnectionFactory.openConnection();
        FuncionarioDao funcionarioDao = new FuncionarioDao(em);

        Funcionario funcionario = null;
        try {
            funcionario = funcionarioDao.pesquisarPorId(id);
        } catch (Exception e) {
            return null;
        }

        return funcionario;
    }
    
    @DeleteMapping(value = "/pop/{codigo}")
    public String excluirFuncionario(@PathVariable int codigo) {
        
        em = ConnectionFactory.openConnection();
        FuncionarioDao funcionarioDao = new FuncionarioDao(em);
        Funcionario funcionario = funcionarioDao.pesquisarPorId(codigo);
        
        try{
            funcionarioDao.excluir(funcionario);
        } catch(Exception e){
            return e.toString();
        }
        
        return "Sucesso!";
    }

}
