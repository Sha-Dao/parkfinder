package br.com.ifba.vaga.controller;

import br.com.ifba.vaga.model.Vaga;
import br.com.ifba.infrastructure.facade.IFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin("*")
public class VagaController {
    
    @Autowired
    private IFacade ifacadedao;
       
    @GetMapping("/vaga")
    public List <Vaga> vaga(){
    /*
        Vaga vaga1 = new Vaga(-11.327674, -41.864284, false, "normal", 2);
        ifacadedao.saveVaga(vaga1);
        Vaga vaga2 = new Vaga(-11.327460, -41.864837, false, "normal", 2);
        ifacadedao.saveVaga(vaga2);
        Vaga vaga3 = new Vaga(-11.327820, -41.863928, false, "pcd", 2);
        ifacadedao.saveVaga(vaga3);
        Vaga vaga4 = new Vaga(-11.303308, -41.853942, false, "normal", 3);
        ifacadedao.saveVaga(vaga4);
        Vaga vaga5 = new Vaga(-11.303302, -41.854147, false, "paga", 3);
        ifacadedao.saveVaga(vaga5);
        Vaga vaga6 = new Vaga(-11.303414, -41.854597, false, "normal", 3);
        ifacadedao.saveVaga(vaga6);
*/
        System.out.println("Cadastrou -------------------------------------------------------------------------------------------------");
        return (List<Vaga>) ifacadedao.findAllVaga();
    }
    
@PostMapping("/salvar-estado-vaga")
public ResponseEntity<String> salvarEstadoVaga(@RequestBody List<Vaga> vagas) {
    try {
        for (int i = 0; i < vagas.size(); i++) {
            System.out.println(vagas.size());
            System.out.println(vagas.get(i).getId());
            ifacadedao.updateVaga(vagas.get(i).getId(), vagas.get(i).getOcupado());
        }
        return ResponseEntity.ok("Dados das vagas recebidos!");
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar os dados das vagas");
    }
}

}
