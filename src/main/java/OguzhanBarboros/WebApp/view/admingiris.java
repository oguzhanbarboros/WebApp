package OguzhanBarboros.WebApp.view;

import OguzhanBarboros.WebApp.model.Yonetici;
import OguzhanBarboros.WebApp.services.YoneticiService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("/a")
public class admingiris extends VerticalLayout {



    private final YoneticiService yoneticiService;



    public admingiris(YoneticiService yoneticiService){
        this.yoneticiService = yoneticiService;

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        getElement().setAttribute("theme","dark");

        H1 h1 = new H1();
        h1.setText("KULLANICI GİRİŞ EKRANI");

        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        horizontalLayout1.add(h1);
        horizontalLayout1.setWidth("100%");

        horizontalLayout1.setJustifyContentMode(JustifyContentMode.CENTER);

        horizontalLayout.setWidth("100%");
        horizontalLayout.setHeight("1500px");
        horizontalLayout.getStyle().set("border","0px solid #9E9E9E");
        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);



        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(loginEvent -> {


            Yonetici result = this.yoneticiService.login(loginEvent.getUsername(),loginEvent.getPassword());

            if (result.getId()!=null)
            {
                VaadinSession.getCurrent().getSession().setAttribute("LoggedInSystemUserId",result.getId());
                UI.getCurrent().getPage().setLocation("/aa");
            }else
            {
                loginForm.setError(true);
            }
        });



        horizontalLayout.add(loginForm);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(horizontalLayout1,horizontalLayout);
    }
}