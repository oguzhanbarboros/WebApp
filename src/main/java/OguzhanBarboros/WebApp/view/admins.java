
package OguzhanBarboros.WebApp.view;

import OguzhanBarboros.WebApp.model.Admin;
import OguzhanBarboros.WebApp.services.AdminService;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;


import com.vaadin.flow.component.icon.VaadinIcon;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import java.util.ArrayList;
import java.util.List;

@Route("/abc")
public class admins extends VerticalLayout {

    Long id ;


    private AdminService adminService;
    Grid<Admin>grid = new Grid<>(Admin.class);

    public admins(AdminService adminService){

        this.adminService = adminService;

        if (VaadinSession.getCurrent().getSession().getAttribute("LoggedInSystemUserId")==null){

            UI.getCurrent().getPage().setLocation("aa");
        }else {

            id=Long.valueOf(VaadinSession.getCurrent().getSession().getAttribute("LoggedInSystemUserId").toString());
        }

        Binder<Admin> adminBinder = new Binder<>();
        Button btn = new Button("Ekle",VaadinIcon.INSERT.create());
        Button geri = new Button("Geri",VaadinIcon.BACKWARDS.create());

        geri.addClickListener(buttonClickEvent ->
                UI.getCurrent().getPage().setLocation("/aa"));

        if(VaadinSession.getCurrent().getSession().getAttribute("LoggedInSystemUserId")==null){
            UI.getCurrent().getPage().setLocation("aa");
        }





        Dialog dialog = new Dialog();
        dialog.setModal(true);

        TextField txtHaliSahaAdi = new TextField("Hali Saha Adi","Hali Saha Adi Gir");
        TextField txtEmail = new TextField("Email gir","Emailinizi Giriniz");
        TextField txtSifre = new TextField("Sifre","Sifrenizi Giriniz");

        adminBinder.bind(txtHaliSahaAdi,Admin::getHalisahaadi,Admin::setHalisahaadi);
        adminBinder.bind(txtEmail,Admin::getEposta,Admin::setEposta);
        adminBinder.bind(txtSifre,Admin::getSifre,Admin::setSifre);



        FormLayout formLayout = new FormLayout();
        formLayout.add(txtHaliSahaAdi,txtEmail,txtSifre);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        Button kaydet = new Button("Kaydet");
        Button iptalEt = new Button("Iptal Et");

        iptalEt.addClickListener(buttonClickEvent -> {
            dialog.close();
        });




        kaydet.addClickListener(buttonClickEvent -> {
            Admin admin = new Admin();
            try {
                adminBinder.writeBean(admin);

            } catch (ValidationException e) {
                e.printStackTrace();
            }
            adminService.kayit(admin);

            refreshData();
            dialog.close();

        });
        horizontalLayout.add(kaydet,iptalEt);
        dialog.add(new H1("Yeni Kayit"),formLayout,horizontalLayout);
        btn.addClickListener(buttonClickEvent -> {
            adminBinder.readBean(new Admin());
            dialog.open();
        });
        refreshData();
        grid.removeColumnByKey("id");
        grid.setColumns("halisahaadi","eposta","sifre");
        add(new H2("Yeni Kayit"),btn,geri,grid);



    }
    private void refreshData(){
        List<Admin> admin= new ArrayList<>();
        admin.addAll(adminService.getAll());
        grid.setItems(admin);
    }

}
