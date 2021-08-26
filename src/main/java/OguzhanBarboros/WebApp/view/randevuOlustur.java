package OguzhanBarboros.WebApp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("/randevu")
public class randevuOlustur extends VerticalLayout {
    public randevuOlustur(){

        Button kayit = new Button("Kayit Oluştur");

        add(kayit);

    }
}
