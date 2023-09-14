/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.cliente.controller;



import br.com.ifba.cliente.model.Cliente;
import br.com.ifba.infrastructure.facade.IFacade;
import br.com.ifba.cliente.recovery.EmailModel;
import br.com.ifba.cliente.recovery.RecuperacaoService;
import br.com.ifba.infrastructure.util.Session;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @Autowired
    private RecuperacaoService rec; 
       
    @GetMapping("/cliente")
    public List <Cliente> cliente(){
        return (List<Cliente>) ifacadedao.findAllCliente();
    }

    @PostMapping("/salvar-cliente")
    public ResponseEntity<String> salvar(@RequestBody Cliente cliente){
         
        List<Cliente> clientes = (List<Cliente>) ifacadedao.findByUsernameCliente(cliente.getEmail());
         
        
        if (clientes != null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        }else{
            ifacadedao.saveCliente(cliente);
        }
        return ResponseEntity.ok("ok");

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
    @PostMapping("/recovery")
    public ResponseEntity<String> enviarEmail(@RequestBody EmailModel emailModel) {
        
        try {
            Random random = new Random();
            int numeroAleatorio = random.nextInt(9000) + 1000;
            EmailModel email = new EmailModel(emailModel.getDestino(), "RECUPERAÇÃO DE SENHA",
            "<html><body>O SEU NÚMERO DE RECUPERAÇÃO É <strong> "+ String.valueOf(numeroAleatorio)
                    +"</strong> . NÃO COMPARTILHE COM NINGUÉM. <p> SE NÃO FOR O DESTINATÁRIO, IGNORE ESTA MENSAGEM.</p>"
                    + "</body></html>");
            
     
            
            rec.enviar(email);
            Session.setRecoveryCode(numeroAleatorio);
            return ResponseEntity.ok("enviado");
        
        }catch(Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/retrieve")
    public String codigo(){
        return String.valueOf(Session.getRecoveryCode());
    }
    
    @PostMapping("/update-password")
    public ResponseEntity<String> updateSenha(@RequestBody Cliente cliente){
        try{
            if(cliente!=null){
                ifacadedao.updatePassword(cliente.getId(), cliente.getSenha());
                
                return ResponseEntity.ok("atualizada");
            }
         }catch(Exception e){
            e.printStackTrace();
            
         }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
        }
    
    @PostMapping("/check-email")
    public ResponseEntity<String> checkEmail(@RequestBody Cliente cliente){
        try{
            if(cliente!=null){
                Cliente checarEmail = ifacadedao.findByUsernameCliente(cliente.getEmail());
                if (checarEmail!=null){
                     return ResponseEntity.ok(String.valueOf(checarEmail.getId()));
                }
                else{
                     return ResponseEntity.ok("naoexiste"); 
                }
            }else{
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
            }
                
                     
         }  catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
            
            
         }
        
        }
      
        
        
   
    
}
