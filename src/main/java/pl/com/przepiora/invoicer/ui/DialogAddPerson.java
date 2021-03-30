package pl.com.przepiora.invoicer.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import pl.com.przepiora.invoicer.model.Person;
import pl.com.przepiora.invoicer.service.Message;
import pl.com.przepiora.invoicer.service.PersonService;

public class DialogAddPerson extends Dialog {
    private static final String EMPTY = "";
    H2 title;
    TextField name;
    TextField surname;
    TextField phone;
    EmailField email;
    Button saveButton;
    Button cancelButton;
    transient PersonService personService;

    public DialogAddPerson(Message message, PersonService personService) {
        this.personService = personService;
        title = new H2(message.get("addContactTitle"));
        name = new TextField(message.get("name"));
        name.setRequired(true);
        name.setErrorMessage(message.get("required"));
        name.setValue("");
        surname = new TextField(message.get("surname"));
        surname.setRequired(true);
        surname.setErrorMessage(message.get("required"));
        phone = new TextField(message.get("phone"));
        phone.setRequired(true);
        phone.setErrorMessage(message.get("required"));
        email = new EmailField(message.get("email"));
        email.setRequiredIndicatorVisible(true);
        email.setErrorMessage(message.get("email.address.not.valid"));
        saveButton = new Button(message.get("save"));
        cancelButton = new Button(message.get("cancel"));

        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.addClickListener(event -> save());
        cancelButton.addClickListener(event -> this.close());

        HorizontalLayout level1 = new HorizontalLayout(title);
        HorizontalLayout level2 = new HorizontalLayout(name, surname);
        HorizontalLayout level3 = new HorizontalLayout(phone, email);
        HorizontalLayout level4 = new HorizontalLayout(saveButton, cancelButton);

        VerticalLayout main = new VerticalLayout(level1, level2, level3, level4);
        main.setAlignItems(FlexComponent.Alignment.CENTER);

        add(main);
    }

    public void save() {
        if (verifyFields()) {
            return;
        }
        Person person = new Person();
        person.setName(name.getValue());
        person.setSurname(surname.getValue());
        person.setPhone(phone.getValue());
        person.setEmail(email.getValue());
        personService.save(person);
        this.close();
    }

        private boolean verifyFields(){
            boolean result = false;
            TextField[] textFields = new TextField[]{name,surname,phone};
            for (TextField field : textFields) {
                if (EMPTY.equals(field.getValue())) {
                    field.setInvalid(true);
                    result = true;
                }
            }
            if (EMPTY.equals(email.getValue()) || email.getValue() == null){
                email.setInvalid(true);
                result = true;
            }
            return result;
        }

}
