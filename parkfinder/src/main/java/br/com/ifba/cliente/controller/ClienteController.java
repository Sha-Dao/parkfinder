/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.cliente.controller;


import br.com.ifba.cliente.dao.IClienteDAO;
import br.com.ifba.cliente.model.Cliente;
import br.com.ifba.infrastructure.facade.IFacade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private IFacade ifacadedao;
       
    @GetMapping("/cliente")
    public List <Cliente> cliente(){
        return (List<Cliente>) ifacadedao.findAllCliente();
    }

    @PostMapping("/cliente")
    public Cliente salvar(@RequestBody Cliente cliente){
        Cliente clientenovo = ifacadedao.saveCliente(cliente);
        return clientenovo;

    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Cliente cliente) {
        Cliente clientenovo = ifacadedao.checkLoginCliente(cliente.getEmail(), cliente.getSenha());

        if (clientenovo != null) {

            return ResponseEntity.ok("Login bem-sucedido");
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    
}
