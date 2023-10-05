package br.com.ifba.vaga.controller;

import br.com.ifba.vaga.model.Vaga;
import br.com.ifba.infrastructure.facade.IFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author santo
 */
@RestController
@RequestMapping("/vaga")
@CrossOrigin("*")
public class VagaController {
    
    @Autowired
    private IFacade ifacadedao;
       
    @GetMapping()
    public List <Vaga> vaga(){
    
        return (List<Vaga>) ifacadedao.findAllVaga();
    }
}
