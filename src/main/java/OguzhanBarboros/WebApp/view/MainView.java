package OguzhanBarboros.WebApp.view;

import OguzhanBarboros.WebApp.model.Super;
import OguzhanBarboros.WebApp.services.SuperService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;


@Route
public class MainView extends VerticalLayout {
    private  final SuperService superService;
    public MainView(SuperService superService){
        this.superService = superService;
        getElement().setAttribute("theme","dark");


        HorizontalLayout horizontalLayout = new HorizontalLayout();
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        HorizontalLayout horizontalLayout3= new HorizontalLayout();
        VerticalLayout verticalLayout = new VerticalLayout();


        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout1.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout2.setJustifyContentMode(JustifyContentMode.CENTER);


        horizontalLayout2.setHeight("4500px");
        horizontalLayout2.setWidth("3000px");
        horizontalLayout.setSizeFull();
        horizontalLayout1.setSizeFull();
        horizontalLayout2.setSizeFull();
        horizontalLayout3.setSizeFull();
        horizontalLayout3.setHeight("500px");





        H1 text = new H1("HALI SAHA RANDEVU SİSTEMİNE \n HOŞGELDİNİZ");
        H1 text1= new H1("");

        Text text2 = new Text("                                                    ");
        Text text3 = new Text("                                                      ");
        Image image = new Image("https://shenleyleisure.org.uk/wp-content/uploads/2021/04/football-pitch-hire-in-milton-keynes_a.jpeg","resim1");
        H2 h1 = new H2();
        H2 h2 = new H2();
        H2 h3 = new H2();
        h2.setText("KULLANICI GİRİŞ");
        h1.setText("ADMİN GİRİŞ");
        h3.setText("Rezervasyon Yap");
        Button button= new Button(h2);
        Button button1= new Button(h1);
        Button button2 = new Button(h3);




        button.setHeight("250px");
        button.setWidth("250px");
        button1.setHeight("250px");
        button1.setWidth("250px");
        button2.setWidth("350px");
        button2.setHeight("350px");


        button.getStyle().set("border","5px solid White" ) ;
        button1.getStyle().set( "border","5px solid  White" ) ;
        button2.getStyle().set("border","5px solid white");

        horizontalLayout3.setJustifyContentMode(JustifyContentMode.CENTER);

        button1.addClickListener(buttonClickEvent ->
                UI.getCurrent().getPage().setLocation("super"));

        button.addClickListener(buttonClickEvent ->
                UI.getCurrent().getPage().setLocation("a"));
        button2.addClickListener(buttonClickEvent ->
                UI.getCurrent().getPage().setLocation("rezervasyon1"));






        horizontalLayout.add(text);

        horizontalLayout2.add(image);

        horizontalLayout3.add(text3,button,button2,button1);

        verticalLayout.add(horizontalLayout,horizontalLayout1,horizontalLayout2,horizontalLayout3);
        add(verticalLayout);



        getElement().setAttribute("theme","dark");








    }
}
