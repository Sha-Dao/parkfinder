package br.com.ifba;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Este método é chamado quando uma nova conexão WebSocket é estabelecida.
        // Você pode realizar ações iniciais aqui.
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Este método é chamado quando uma mensagem é recebida do cliente.
        String payload = message.getPayload();
        // Processar a mensagem e enviar atualizações para os clientes conectados, se necessário.
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Este método é chamado quando uma conexão WebSocket é fechada.
        // Faça a limpeza necessária aqui.
    }
}

