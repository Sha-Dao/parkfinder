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
import br.com.ifba.authentication.service.TokenService;
import java.util.List;
import br.com.ifba.vaga.model.Vaga;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    private Vaga vaga;
    
    @Autowired
    private IFacade ifacadedao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private RecuperacaoService rec; 
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private TokenService tokenService;
       
    
    @GetMapping("/perfil-cliente")
    public ResponseEntity<Cliente> sessaoCliente(HttpServletRequest request) {
       
        String token = extractTokenFromHeader(request);

        if (token != null && !token.isEmpty()) {
            String email = tokenService.getSubject(token);

            Cliente cliente = ifacadedao.findByUsernameCliente(email);

            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            }
        }

        return ResponseEntity.notFound().build();
    }


        private String extractTokenFromHeader(HttpServletRequest request) {
            String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                return authorizationHeader.substring(7); // Ignorar o prefixo "Bearer "
            }
            return null;
}

    
    @GetMapping("/cliente")
    public List <Cliente> cliente(){
        return (List<Cliente>) ifacadedao.findAllCliente();
    }
     

 @PostMapping("/salvar-cliente")
public ResponseEntity<String> salvar(@RequestBody Cliente cliente) {
    // Verifica se o email já existe no banco de dados
    Cliente clientes =  ifacadedao.findByUsernameCliente(cliente.getEmail());
    
    if (clientes!=null) {
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
    } else {
        String senhaCodificada = passwordEncoder.encode(cliente.getSenha());
        cliente.setSenha(senhaCodificada);
        ifacadedao.saveCliente(cliente);
        
    }
    return ResponseEntity.ok("ok");
}









    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Cliente cliente) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(cliente.getEmail(), cliente.getSenha());
      
       Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        
        if(authenticationManager!=null){
            Cliente clienteauth =  new Cliente();
            clienteauth = (Cliente) authenticate.getPrincipal();
            return ResponseEntity.ok(tokenService.generateToken(clienteauth));

        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
        }
    }
        
        /*
        Cliente clientenovo = ifacadedao.checkLoginCliente(cliente.getEmail(), cliente.getSenha());

        if (clientenovo != null) {

            return ResponseEntity.ok("Login bem-sucedido");
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
*/
    
    @PostMapping("/recovery")
    public ResponseEntity<String> enviarEmail(@RequestBody EmailModel emailModel) {
        
        try {
            Random random = new Random();
            int numeroAleatorio = random.nextInt(9000) + 1000;
            EmailModel email = new EmailModel(emailModel.getDestino(), "RECUPERAÇÃO DE SENHA",
            "<html>\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Recuperação de Senha</title>\n" +
"    <style>\n" +
"        .email-container {\n" +
"            max-width: 600px;\n" +
"            margin: 0 auto;\n" +
"            background-color: #f7f7f7;\n" +
"            padding: 20px;\n" +
"            border-radius: 10px;\n" +
"            box-shadow: 0 4px 8px rgba(0,0,0,0.1);\n" +
"        }\n" +
"        .code-box {\n" +
"            background-color: #f7f7f7;\n" +
"            border: 1px solid #c7c6c6;\n" +
"            padding: 10px;\n" +
"            border-radius: 6px;\n" +
"            margin: 0 auto;\n" +
"            max-width: 130px;\n" +
"            text-align: center;\n" +
"        }\n" +
"        h1 {\n" +
"            color: #333;\n" +
"        }\n" +
"        p {\n" +
"            color: #666;\n" +
"        }\n" +
"        strong {\n" +
"            color: #000;\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
"    <div class=\"email-container\">\n" +
"        <p>Olá,</p>\n" +
"        <p>O seu número de recuperação é:</p>\n" +
"        <div class=\"code-box\">\n" +
"            <strong>"+String.valueOf(numeroAleatorio)+"</strong>\n" +
"        </div>\n" +
"        <p>Por favor, não compartilhe com ninguém.</p>\n" +
"        <p>Se você não solicitou a recuperação de senha, por favor, ignore esta mensagem.</p>\n" +
"        <p>Atenciosamente,<br>Park Finder</p>\n" +
"    </div>\n" +
"</body>\n" +
"</html>\n" +
"\n" +
"");
            
     
            
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
        try {
            if (cliente != null) {
                Cliente checarEmail = ifacadedao.findByUsernameCliente(cliente.getEmail());
                if (checarEmail != null) {
                    String token = tokenService.generateToken(checarEmail);
                    return ResponseEntity.ok(token);
                } else {
                    return ResponseEntity.ok("naoexiste");
                }
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
}

      
        
        
   
    
}
