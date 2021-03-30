package pl.com.przepiora.invoicer.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Message {
    Locale locale = Locale.forLanguageTag("PL");
    MessageSource messageSource;

    public Message(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String get(String message){
        return messageSource.getMessage(message, null, locale);
    }

    public void changeLocale(Locale locale){
        this.locale = locale;
    }
}
