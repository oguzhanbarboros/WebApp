package OguzhanBarboros.WebApp.view;

import OguzhanBarboros.WebApp.model.Rezervasyon;

import OguzhanBarboros.WebApp.services.RezervasyonService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import java.util.ArrayList;
import java.util.List;
@Route("/randevurapor")
public class randevuRapor extends VerticalLayout {
    private RezervasyonService rezervasyonService;
    Rezervasyon rezervasyon;


    Long girisid;


    Grid<Rezervasyon> rezervasyonGrid = new Grid<>();


    public randevuRapor(RezervasyonService rezervasyonService) {
        this.rezervasyonService = rezervasyonService;


        if (
                VaadinSession.getCurrent().getSession().getAttribute("LoggedInSystemUserId") == null) {
            UI.getCurrent().getPage().setLocation("/");


        } else {

            girisid = Long.valueOf(VaadinSession.getCurrent().getSession().getAttribute("LoggedInSystemUserId").toString());


        }
        rezervasyonGrid.addComponentColumn(item -> createRemoveButton(rezervasyonGrid, item)).setHeader("Actions");


        List<Rezervasyon> rezervasyons = getItems();


        rezervasyonGrid.setItems(rezervasyons);
        rezervasyonGrid.addColumn(Rezervasyon::getEmail).setHeader("email");
        rezervasyonGrid.addColumn(Rezervasyon::getRezervasyonsaat).setHeader("saat");
        rezervasyonGrid.addColumn(Rezervasyon::getRezervasyonsahaadi).setHeader("sahaadi");
        rezervasyonGrid.addColumn(Rezervasyon::getRezervasyontarih).setHeader("tarih");
       /*
        rezervasyonGrid.removeColumnByKey("Sahaid");
        rezervasyonGrid.removeColumnByKey("Yonetici");
        rezervasyonGrid.removeColumnByKey("email");
        rezervasyonGrid.removeColumnByKey("saat");
        rezervasyonGrid.removeColumnByKey("sahaadi");
        rezervasyonGrid.removeColumnByKey("tarih");
*/
        add(rezervasyonGrid);
    }


    private List<Rezervasyon> getItems() {

        return this.rezervasyonService.findByYoneticiId(girisid);
    }


    private HorizontalLayout createRemoveButton(Grid<Rezervasyon> rezervasyonGrid, Rezervasyon item) {
        @SuppressWarnings("unchecked")
        Button btnDelete = new Button("Sil");
        btnDelete.addClickListener(buttonClickEvent -> {
            //Notification.show("Delete item clicked on :" + item.getName());

            ConfirmDialog dialog = new ConfirmDialog("Silmeyi onayla",
                    "Kaydı Silmek istediğinizden emin misiniz ?", "Sil", confirmEvent -> {
                rezervasyonService.delete(item);
                refreshData();
            },
                    "İptal", cancelEvent -> {

            });
            dialog.setConfirmButtonTheme("error primary");

            dialog.open();
        });

        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        horizontalLayout2.add(btnDelete);
        add(horizontalLayout2);
        return horizontalLayout2;

    }


    private void refreshData () {
        List<Rezervasyon> rezervasyon = new ArrayList<>();
        rezervasyon.addAll(rezervasyonService.findByYoneticiId(girisid));
        rezervasyonGrid.setItems(rezervasyon);
    }
}


