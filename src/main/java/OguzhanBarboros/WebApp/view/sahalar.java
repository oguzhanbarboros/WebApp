package OguzhanBarboros.WebApp.view;
import OguzhanBarboros.WebApp.model.Admin;
import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Yonetici;
import OguzhanBarboros.WebApp.services.SahaService;
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
import com.vaadin.flow.server.VaadinSession;

import java.util.ArrayList;
import java.util.List;



@Route("/abcd")
public class sahalar extends VerticalLayout {


    private SahaService sahaService;

    Grid<Saha> grid = new Grid<>(Saha.class);
    TextField txtFilter = new TextField();
    Dialog dialog = new Dialog();
    Binder<Saha> binder = new Binder<>();
    Long itemIdForEdition = 0L;
    Long loggedInSystemUserId;


    public sahalar(SahaService sahaService) {


        this.sahaService = sahaService;

        if(
                VaadinSession.getCurrent().getSession().getAttribute("LoggedInSystemUserId")==null){
            UI.getCurrent().getPage().setLocation("/a");

        }
        else{

            loggedInSystemUserId = Long.valueOf(VaadinSession.getCurrent().getSession().getAttribute("LoggedInSystemUserId").toString());
        }

        getElement().setAttribute("theme","dark");


        HorizontalLayout horizontalLayout5 = new HorizontalLayout();
        horizontalLayout5.setHeight("1500px");

        Binder<Saha> sahaBinder = new Binder<>();

        Button btn = new Button("Ekle", VaadinIcon.INSERT.create());
        Button btn1 = new Button("Geri", VaadinIcon.BACKWARDS.create());
        btn.getStyle().set("border","3px solid white");
        btn1.getStyle().set("border","3px solid white");



        dialog.setModal(true);

        TextField txtSahaadi = new TextField("saha adi girin", "saha adi giriniz");
        TextField txtFiyat = new TextField("fiyat gir", "fiyat giriniz");
        TextField txtAlan = new TextField("alan gir", "alan giriniz");

        sahaBinder.bind(txtSahaadi, Saha::getSahaadi, Saha::setSahaadi);
        sahaBinder.bind(txtFiyat, Saha::getFiyat, Saha::setFiyat);
        sahaBinder.bind(txtAlan, Saha::getAlan, Saha::setAlan);



        FormLayout formLayout = new FormLayout();
        formLayout.add(txtSahaadi, txtFiyat, txtAlan);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setHeight("1500px");
        horizontalLayout.setSpacing(true);
        Button kayit = new Button("Kaydet");
        Button iptal = new Button("Iptal Et");

        btn1.addClickListener(buttonClickEvent ->
                UI.getCurrent().getPage().setLocation("aa"));

        iptal.addClickListener(buttonClickEvent -> {
            dialog.close();
        });



        kayit.addClickListener(buttonClickEvent -> {
            Saha saha = new Saha();
            try {
                sahaBinder.writeBean(saha);

            } catch (ValidationException e) {
                e.printStackTrace();
            }

            saha.setId(itemIdForEdition);
            Yonetici yonetici= new Yonetici();
            yonetici.setId(loggedInSystemUserId);
            List<Saha> sahalar = new ArrayList<>();
            saha.setYonetici(yonetici);
            sahalar.addAll(sahaService.findByYonetici(yonetici));

            sahaService.kayit(saha);




            grid.setItems(sahalar);
            refreshData(loggedInSystemUserId);
            dialog.close();

        });
        horizontalLayout.add(kayit, iptal);
        dialog.add(new H1("Yeni Kayıt"), formLayout, horizontalLayout);
        btn.addClickListener(buttonClickEvent -> {
            itemIdForEdition = 0L;
            sahaBinder.readBean(new Saha());
            dialog.open();
        });
        refreshData(loggedInSystemUserId);
        grid.removeColumnByKey("id");

        grid.setColumns("sahaadi", "fiyat", "alan");
        grid.addComponentColumn(item->createRemoveButton(grid,item)).setHeader("İşlem");
        add(new H1("Yeni Kayit"), btn, btn1, grid,horizontalLayout5);



    }

    private void refreshData(Long loggedInSystemUserId) {
        List<Saha> personList = new ArrayList<>();
        personList.addAll(sahaService.getList(loggedInSystemUserId));


        grid.setItems(personList);
    }

    private void onDelete(ConfirmDialog.ConfirmEvent confirmEvent) {

    }


    private HorizontalLayout createRemoveButton(Grid<Saha> grid, Saha item) {
        @SuppressWarnings("unchecked")
        Button btnDelete = new Button("Sil");
        btnDelete.addClickListener(buttonClickEvent -> {
            //Notification.show("Delete item clicked on :" + item.getName());

            ConfirmDialog dialog = new ConfirmDialog("Silmeyi onayla",
                    "Kaydı Silmek istediğinizden emin misiniz ?", "Sil", confirmEvent -> {
                sahaService.delete(item);
                refreshData(loggedInSystemUserId);
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
 /*
        Button btnRez = new Button("Rezervasyon");
        btnRez.addClickListener(buttonClickEvent -> {
            UI.getCurrent().getPage().setLocation("rezervasyon");



        });

*/

    HorizontalLayout horizontalLayout2 = new HorizontalLayout();
    horizontalLayout2.add(btnDelete,btnUpdate);

    return horizontalLayout2;



    }


    private void refreshData() {
        List<Saha> saha = new ArrayList<>();
        Yonetici yonetici;
        saha.addAll(sahaService.getAll());

        grid.setItems(saha);
    }
}
