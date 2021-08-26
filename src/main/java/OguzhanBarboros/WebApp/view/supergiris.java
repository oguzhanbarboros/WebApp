package OguzhanBarboros.WebApp.view;

import OguzhanBarboros.WebApp.model.Super;
import OguzhanBarboros.WebApp.services.SuperService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("/super")
public class supergiris extends VerticalLayout {
    private SuperService superService;
    public  supergiris(SuperService supersevice){
        this.superService= supersevice;

        getElement().setAttribute("theme","dark");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidth("100%");
        horizontalLayout.getStyle().set("border","0px solid #9E9E9E");
        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);


        LoginForm loginForm = new LoginForm();

        loginForm.addLoginListener(loginEvent -> {


            Super result = this.superService.login(loginEvent.getUsername(),loginEvent.getPassword());

            if (result.getId()!=null)
            {
                VaadinSession.getCurrent().getSession().setAttribute("LoggedInSystemUserId",result.getId());
                UI.getCurrent().getPage().setLocation("yoneticiekle");
            }else
            {
                loginForm.setError(true);

            }

        });
        H1 h1 = new H1();
        h1.setText("ADMİN GİRİŞ EKRANI");


        HorizontalLayout horizontalLayout1= new HorizontalLayout();
        horizontalLayout1.add(h1);
        horizontalLayout.setHeight("1500px");
        horizontalLayout.add(loginForm);
        setJustifyContentMode(JustifyContentMode.CENTER);


        horizontalLayout1.setWidth("100%");
        horizontalLayout1.getStyle().set("border","0px solid #9E9E9E");
        horizontalLayout1.setJustifyContentMode(JustifyContentMode.CENTER);

        add(horizontalLayout1,horizontalLayout);
    }



}
