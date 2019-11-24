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
    @Override
    public String getBotToken() {
        return "846819627:AAGZKDB_Qn5KwKJNHqNssrjHaqHAGhEajnY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Esta función se invocará cuando nuestro bot reciba un mensaje
        // Se obtiene el mensaje escrito por el usuario        
        final String messageTextReceived = update.getMessage().getText();
        if(messageTextReceived.equals("start"))
        {
            running = true;
          //  EnviaMsgTimerTask tsk = new EnviaMsgTimerTask();
           // Timer timer = new Timer();
           // timer.schedule(tsk, 0,5000);
        }
        if(messageTextReceived.equals("stop") )
        {
            running = false;
        }
        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();
        //System.out.println("id: " + user.toString());
        
        // Se crea un objeto mensaje
        SendMessage message = new SendMessage().setChatId(chatId).setText(messageTextReceived);
        try {
            // Se envía el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
    

    @Override
    public String getBotUsername() {
        return "EchoBot";
    }
    
    public void sendMsg(long chat_id, String msg_toSend)
    {
        SendMessage message = new SendMessage().setChatId(chat_id).setText(msg_toSend);
        try {
            execute(message);
        } catch (TelegramApiException ex) {
            Logger.getLogger(TelegramNotifier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
