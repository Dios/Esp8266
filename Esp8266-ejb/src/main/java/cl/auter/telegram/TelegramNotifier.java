/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.auter.telegram;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author drobles
 */
public class TelegramNotifier extends TelegramLongPollingBot {
    boolean running = false;
    long chat_id = 763510598;
    String botToken = "846819627:AAGZKDB_Qn5KwKJNHqNssrjHaqHAGhEajnY";
    
    public TelegramNotifier(long chat_id, String botToken)
    {
        this.chat_id = chat_id;
        this.botToken = botToken;
    }
    
    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Esta función se invocará cuando nuestro bot reciba un mensaje
        // Se obtiene el mensaje escrito por el usuario        
        final String messageTextReceived = update.getMessage().getText();
        if(messageTextReceived.equals("start"))
        {
            running = true;
        }
        else if(messageTextReceived.equals("stop") )
        {
            running = false;
        }
        else{
            messageTextReceived = "Comando no valido";
        }
        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();
        
        // Se crea un objeto mensaje
        SendMessage message = new SendMessage().setChatId(chatId).setText(messageTextReceived);
        try {
            // Se envía el mensaje
            execute(message);
        } catch (TelegramApiException ex) {
            Logger.getLogger(TelegramNotifier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public String getBotUsername() {
        return "EchoBot";
    }
    
    public void sendMsg(String msg_toSend)
    {
        SendMessage message = new SendMessage().setChatId(chat_id).setText(msg_toSend);
        try {
            execute(message);
        } catch (TelegramApiException ex) {
            Logger.getLogger(TelegramNotifier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
