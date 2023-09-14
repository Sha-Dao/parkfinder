package br.com.ifba.cliente.recovery;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class RecuperacaoService {
    @Autowired
    private JavaMailSender mail;

   
    public void enviar(EmailModel emailModel) throws MailException, MessagingException {
        try {
            MimeMessage message = mail.createMimeMessage();
            MimeMessageHelper conteudo = new MimeMessageHelper(message, true, "UTF-8");
            
            conteudo.setFrom("ecotechparkfinder@gmail.com");
            conteudo.setTo(emailModel.getDestino());
            conteudo.setSubject(emailModel.getAssunto());
            conteudo.setText(emailModel.getConteudo(), true);
            mail.send(message);
            System.out.println("E-mail com HTML enviado com sucesso!");
            
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
