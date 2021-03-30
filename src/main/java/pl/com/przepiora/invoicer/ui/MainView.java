package pl.com.przepiora.invoicer.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import pl.com.przepiora.invoicer.service.Message;
import pl.com.przepiora.invoicer.service.PersonService;

import java.util.Locale;

@Route
public class MainView extends HorizontalLayout {

    public MainView(Message message, PersonService personService) {
        Button button = new Button("xxx");
        Button button2 = new Button("PL");
        Button button3 = new Button("EN");
        Button button4 = new Button("refresh");

        button.addClickListener(event -> new DialogAddPerson(message, personService).open());
        button2.addClickListener(event -> message.changeLocale(Locale.forLanguageTag("PL")));
        button3.addClickListener(event -> message.changeLocale(Locale.US));
        button4.addClickListener(event -> UI.getCurrent().getPage().reload());

        add(button,button2,button3, button4);
    }
}
