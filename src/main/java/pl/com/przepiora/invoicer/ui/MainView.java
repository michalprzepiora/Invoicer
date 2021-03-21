package pl.com.przepiora.invoicer.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends HorizontalLayout {
    public MainView() {
        Button button = new Button("xxx");
        button.addClickListener(event -> Notification.show("Works!!!!!!!!!!!!!!!!!!!!!!!" + event));

        add(button);
    }
}
