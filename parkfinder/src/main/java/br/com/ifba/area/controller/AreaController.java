package br.com.ifba.area.controller;

import br.com.ifba.area.model.Area;
import br.com.ifba.infrastructure.facade.IFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/area")
@CrossOrigin("*")
public class AreaController {
    
       @Autowired
    private IFacade ifacadedao;
       
    @GetMapping()
    public List <Area> area(){
    
        return (List<Area>) ifacadedao.findAllArea();
    }
}

