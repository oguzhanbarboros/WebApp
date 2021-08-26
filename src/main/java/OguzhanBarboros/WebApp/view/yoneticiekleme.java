
package OguzhanBarboros.WebApp.view;
import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Yonetici;
/*
import OguzhanBarboros.WebApp.model.Saha;

import OguzhanBarboros.WebApp.services.SahaService;


 */
import OguzhanBarboros.WebApp.services.YoneticiService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
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


import java.util.ArrayList;
import java.util.List;

@Route("/yoneticiekle")
public class yoneticiekleme extends VerticalLayout {

    public YoneticiService yoneticiService;

    Grid<Yonetici> grid = new Grid<>(Yonetici.class);
    TextField txtFilter = new TextField();
    Dialog dialog = new Dialog();
    Binder<Yonetici> binder = new Binder<>();
    Long itemIdForEdition = 0L;


    public  yoneticiekleme(YoneticiService yoneticiService) {

        this.yoneticiService = yoneticiService;

        getElement().setAttribute("theme","dark");


        Binder<Yonetici> yoneticiBinder = new Binder<>();

        Button btn = new Button("Ekle", VaadinIcon.INSERT.create());
        Button btn1 = new Button("Çıkış", VaadinIcon.BACKWARDS.create());

        btn.getStyle().set("border","3px solid white");
        btn1.getStyle().set("border","3px solid white");


        dialog.setModal(true);


        TextField txtSahaadi = new TextField("Email Giriniz", "Email Giriniz");
        TextField txtFiyat = new TextField("Şifre Giriniz", "Şifre Giriniz");


        yoneticiBinder.bind(txtSahaadi, Yonetici::getEmail, Yonetici::setEmail);
        yoneticiBinder.bind(txtFiyat, Yonetici::getPassword, Yonetici::setPassword);


        FormLayout formLayout = new FormLayout();
        formLayout.add(txtSahaadi, txtFiyat);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        HorizontalLayout horizontalLayout5 = new HorizontalLayout();

        horizontalLayout.setSpacing(true);
        Button button1 = new Button("Kaydet");
        Button iptal = new Button("Iptal Et");

        btn1.addClickListener(buttonClickEvent ->
                UI.getCurrent().getPage().setLocation("/"));

        iptal.addClickListener(buttonClickEvent -> {
            dialog.close();
        });


        button1.addClickListener(buttonClickEvent -> {
            Yonetici yonetici = new Yonetici();
            try {
                yoneticiBinder.writeBean(yonetici);

            } catch (ValidationException e) {
                e.printStackTrace();
            }
            yonetici.setId(itemIdForEdition);
            yoneticiService.kayitt(yonetici);

            refreshData();
            dialog.close();

        });
        horizontalLayout.add(button1, iptal);
        dialog.add(new H1("-------Yönetici Ekle-------"), formLayout, horizontalLayout);
        btn.addClickListener(buttonClickEvent -> {
            itemIdForEdition = 0L;
            yoneticiBinder.readBean(new Yonetici());
            dialog.open();

        });
        refreshData();
        grid.removeColumnByKey("id");
        grid.setColumns("email", "password");
        grid.addComponentColumn(item -> createRemoveButton(grid, item)).setHeader("Actions");
        horizontalLayout5.setHeight("1500px");

        add(new H1("Yeni Kayıt"), btn, btn1, grid,horizontalLayout5);


    }
    private void refreshData(String filter) {
        List<Yonetici> personList = new ArrayList<>();
        grid.setItems(personList);
    }

    private void onDelete(ConfirmDialog.ConfirmEvent confirmEvent) {

    }
    private HorizontalLayout createRemoveButton(Grid<Yonetici> grid, Yonetici item) {
        @SuppressWarnings("unchecked")
        Button btnDelete = new Button("Sil");
        btnDelete.addClickListener(buttonClickEvent -> {
            //Notification.show("Delete item clicked on :" + item.getName());

            ConfirmDialog dialog = new ConfirmDialog("Silmeyi onayla",
                    "Kaydı Silmek istediğinizden emin misiniz ?", "Sil", confirmEvent -> {
                yoneticiService.delete(item);
                refreshData();
            },
                    "İptal", cancelEvent -> {

            });
            dialog.setConfirmButtonTheme("error primary");

            dialog.open();
        });
        Button btnUpdate = new Button("Güncelle");
        btnUpdate.addClickListener(buttonClickEvent -> {
            itemIdForEdition = item.getId();
            binder.readBean(item);
            dialog.open();

        });

        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        horizontalLayout2.add(btnDelete,btnUpdate);
        add(horizontalLayout2);
        return horizontalLayout2;
    }

    private void refreshData() {
        List<Yonetici> yonetici = new ArrayList<>();
        yonetici.addAll(yoneticiService.getAll());
        grid.setItems(yonetici);
    }
    }


