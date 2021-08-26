package OguzhanBarboros.WebApp.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;


import java.awt.*;

@Route("/aa")
public class sayfaiki extends VerticalLayout {


    public sayfaiki() {



        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        HorizontalLayout horizontalLayout2 = new HorizontalLayout();

        getElement().setAttribute("theme","dark");
        H1 h1 = new H1("HALI SAHA REZARVASYON SİSTEMİNE HOŞGELDİNİZ");

        Image image = new Image("https://www.integralspor.com.tr/wp-content/uploads/2018/09/hal%C4%B1-saha-yapimi-asamalari.jpg","resim");



       // Button kayit = new Button("Kayit Ekle");
        Button sahaozellik = new Button("Saha Özellikleri");
        Button randevuOlustur = new Button("Randevuları Görüntüle");


       // kayit.setWidth("300px");
       // kayit.setHeight("150px");
        sahaozellik.setWidth("300px");
        sahaozellik.setHeight("150px");
        sahaozellik.getStyle().set("border","5px solid white");
        randevuOlustur.setWidth("300px");
        randevuOlustur.setHeight("150px");
        randevuOlustur.getStyle().set("border","5px solid white");


        if(VaadinSession.getCurrent().getSession().getAttribute("LoggedInSystemUserId")==null){
            UI.getCurrent().getPage().setLocation("a");
        }


        Button geri = new Button("Çıkış",VaadinIcon.BACKWARDS.create());

        geri.addClickListener(buttonClickEvent ->
                UI.getCurrent().getPage().setLocation("/"));

        geri.getStyle().set("border","3px solid white");
        HorizontalLayout horizontalLayout3 = new HorizontalLayout();
        horizontalLayout3.add(geri);

        horizontalLayout.add(h1);

        horizontalLayout1.add(image);
        horizontalLayout2.add(sahaozellik,randevuOlustur);

        verticalLayout.add(horizontalLayout3,horizontalLayout,horizontalLayout1,horizontalLayout2);

        verticalLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout1.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout2.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout.setSizeFull();
        horizontalLayout1.setSizeFull();
        horizontalLayout2.setSizeFull();

        sahaozellik.addClickListener(buttonClickEvent ->
                UI.getCurrent().navigate("abcd"));

        //kayit.addClickListener(buttonClickEvent ->
          //      UI.getCurrent().navigate("abc"));

        randevuOlustur.addClickListener(buttonClickEvent ->
                UI.getCurrent().navigate("randevurapor"));


        add(verticalLayout);














    }

}
