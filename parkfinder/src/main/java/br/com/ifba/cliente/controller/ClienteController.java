/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.cliente.controller;


import br.com.ifba.cliente.dao.IClienteDAO;
import br.com.ifba.cliente.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author j_ped
 */
@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private IClienteDAO iclientedao;
       
    @GetMapping()
    public List <Cliente> cliente(){
        return (List<Cliente>) iclientedao.findAll();
    }
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente){
        Cliente clientenovo = iclientedao.save(cliente);
        return clientenovo;

    }
}
