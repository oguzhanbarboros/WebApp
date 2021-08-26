package OguzhanBarboros.WebApp.view;


import OguzhanBarboros.WebApp.model.*;
import OguzhanBarboros.WebApp.services.RezervasyonService;
import OguzhanBarboros.WebApp.services.SaatService;
import OguzhanBarboros.WebApp.services.SahaService;
import OguzhanBarboros.WebApp.services.TarihService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;



import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Route("/rezervasyon1")
public class rezervasyon1 extends VerticalLayout {
    private RezervasyonService rezervasyonService;
    private SahaService sahaService;
    private SaatService saatService;
    private TarihService tarihService;
    private Saha saha1;
    private Tarih tarih1;
    Dialog dialog = new Dialog();
    Long id;
    Rezervasyon rezervasyon= new Rezervasyon();
    Binder<Rezervasyon> rezervasyonBinder2 = new Binder<>();
    Binder<Saha> binder1 = new Binder<>();
    List<Saat> sahaadi= new ArrayList<>();
    private String saha11;
    private String saha12;
    private String saha13;
    TextField textField22 = new TextField();
    TextField textField23 = new TextField();
    TextField textField24 = new TextField();
    TextField textField30 = new TextField();
    TextField textField31 = new TextField();
    private  String gelenn;
    private Yonetici yonetici;
    Binder<Rezervasyon> rezervasyonBinder = new Binder<>();
    private String gelenSaha;
    private String sahafiyat;
    private String sahaalan;

    HorizontalLayout horizontalLayout10 = new HorizontalLayout();
    public rezervasyon1(RezervasyonService rezervasyonService,SahaService sahaService,SaatService saatService,TarihService tarihService) {
        this.rezervasyonService = rezervasyonService;
        this.sahaService = sahaService;
        this.saatService = saatService;
        this.tarihService = tarihService;
        Binder<Rezervasyon> binder = new Binder<>();
        getElement().setAttribute("theme","dark");


        Grid<Saat> saatGrid = new Grid<>(Saat.class);


        dialog.setModal(true);


        TextField txtEmail = new TextField("email giriniz", "email giriniz");
        TextField txtSaat = new TextField("Saat seçiniz", "Saat seçiniz");
        TextField txtTarih = new TextField("Tarih seçiniz", "Tarih seçiniz");












        FormLayout formLayout = new FormLayout();
        formLayout.add(txtEmail);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);

        com.vaadin.flow.component.button.Button kayit = new com.vaadin.flow.component.button.Button("Kaydet");
        com.vaadin.flow.component.button.Button iptal = new Button("Iptal Et");

        kayit.addClickListener(buttonClickEvent -> {


            try {
                rezervasyonBinder.writeBean(rezervasyon);

            } catch (ValidationException e) {
                e.printStackTrace();



            }

            yonetici= saha1.getYonetici();
            rezervasyon.setYonetici(yonetici);
            rezervasyonService.save(rezervasyon);
            saatService.deleteByIdAndSahalistAndTarihlist(id,saha1,tarih1);
           // tarihService.deleteBySaats1(tarih1.getId(),id);
            List<Saat> saat1 = new ArrayList<>();
            saat1.addAll(saatService.findBySahalistAndTarihlist(saha1,tarih1));
            saatGrid.setItems(saat1);


            dialog.close();
            UI.getCurrent().getPage().setLocation("/rezervasyon1");
        });
        dialog.add(formLayout,kayit);

        FormLayout layoutWithFormItems = new FormLayout();



        DatePicker tarih = new DatePicker();
        //tarih.setMin(LocalDate.parse("2021-07-08"));
        tarih.setMin(LocalDate.now());



        layoutWithFormItems.addFormItem(tarih, "Tarih seçiniz");




        layoutWithFormItems.setVisible(false);

        horizontalLayout10.add(layoutWithFormItems);

        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        HorizontalLayout horizontalLayout3 = new HorizontalLayout();
        HorizontalLayout horizontalLayout4 = new HorizontalLayout();


        horizontalLayout4.add(layoutWithFormItems);

        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout.setWidth("100%");
        horizontalLayout.getStyle().set("border","0px solid #9E9E9E");

        horizontalLayout2.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout2.setWidth("100%");
        horizontalLayout2.getStyle().set("border","0px solid #9E9E9E");

        horizontalLayout3.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout3.setWidth("100%");
        horizontalLayout3.setHeight("150px");
        horizontalLayout3.getStyle().set("border","0px solid #9E9E9E");


        horizontalLayout4.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout4.setWidth("100%");
        horizontalLayout4.getStyle().set("border","0px solid #9E9E9E");


        dialog.add(new H1("Yeni Kayıt"), formLayout, horizontalLayout);

        add(dialog);


        ComboBox<String> comboBox = new ComboBox<>("Saha");

        Button geri = new Button("Geri", VaadinIcon.BACKWARDS.create());

        geri.addClickListener(buttonClickEvent ->
                UI.getCurrent().getPage().setLocation("/"));

        geri.getStyle().set("border","3px solid white");
HorizontalLayout horizontalLayout40 = new HorizontalLayout();

        horizontalLayout40.add(geri);
        add(horizontalLayout40);
        H1 h1 = new H1("RANDEVU SİSTEMİ");
        horizontalLayout3.add(h1);
        add(horizontalLayout3);
        List<String> list2=new ArrayList<>();
        ComboBox comboBox5 = new ComboBox();




        java.util.List<Saha> saha = (java.util.List<Saha>) getList();


        List<String> list=new ArrayList<>();

        list.addAll(sahaService.sahabilgileri());

        comboBox.setLabel("Saha İsmi , Saatlik Ücret , Saha Alan ");



        //comboBox.setItemLabelGenerator(Saha::getSahaadi);

        comboBox.setWidth("300px");
        comboBox.setHeight("150px");


        comboBox.setItems(list);

        gelenSaha = comboBox.getValue();

        // list.addAll(tarihService.findByDateAndSaatAndSaha());


        ComboBox<Saha> comboBox1 = new ComboBox<>("Saat");


        ComboBox<Saha> comboBox2 = new ComboBox<>("Saha");

        List<Saha> sahas = getList();

        comboBox2.setItemLabelGenerator(Saha::getSahaadi);
        comboBox2.setItems(sahas);



        ComboBox<Tarih> comboBox3 = new ComboBox<>("Tarih");

        List<Tarih> tarihs = getTarih();

        comboBox3.setItemLabelGenerator(Tarih::getDate);
        comboBox3.setItems(tarihs);


        textField30.setLabel("Fiyat");
        textField31.setLabel("Alan(m2)");
        textField30.setReadOnly(true);
        textField31.setReadOnly(true);



        HorizontalLayout horizontalLayout1 = new HorizontalLayout();


        Button yenile = new Button("Listele");

        yenile.setWidth("250px");
        yenile.setHeight("100px");


        add(comboBox2,comboBox3);
        yenile.addClickListener(buttonClickEvent -> {



            saha1 = comboBox2.getValue();
            tarih1 = comboBox3.getValue();
            List<Saat> saat1 = new ArrayList<>();
            saat1.addAll(saatService.findBySahalistAndTarihlist(saha1,tarih1));
            saatGrid.setItems(saat1);
            saha11= saha1.getSahaadi();
            saha12 = tarih1.getDate();
            sahafiyat = saha1.getFiyat();
            sahaalan= saha1.getAlan();






            textField23.setValue(saha12);
            // textField.setValue(String.valueOf(saha1));
            textField22.setValue(saha11);
            // gelenn = textField.getValue();

            textField30.setValue(sahafiyat);

            textField31.setValue(sahaalan);

        });

        textField22.setVisible(false);
        textField23.setVisible(false);
        textField24.setVisible(false);


        HorizontalLayout horizontalLayout30 = new HorizontalLayout();
        horizontalLayout30.setHeight("800px");


        saatGrid.removeColumnByKey("id");
        saatGrid.setColumns("saat");
        saatGrid.addComponentColumn(item->rezervasyonYap(saatGrid,item));

        horizontalLayout.add(yenile);
        add( horizontalLayout10,textField30,textField31,horizontalLayout2,horizontalLayout,horizontalLayout1,horizontalLayout4,saatGrid,textField22,textField23,textField24,horizontalLayout30);

        rezervasyonBinder.bind(txtEmail, Rezervasyon::getEmail, Rezervasyon::setEmail);
        rezervasyonBinder.bind(textField22,Rezervasyon::getRezervasyonsahaadi,Rezervasyon::setRezervasyonsahaadi);
        rezervasyonBinder.bind(textField23,Rezervasyon::getRezervasyontarih,Rezervasyon::setRezervasyontarih);
        rezervasyonBinder.bind(textField24,Rezervasyon::getRezervasyonsaat,Rezervasyon::setRezervasyonsaat);

        try {
            rezervasyonBinder.writeBean(rezervasyon);

        } catch (ValidationException e) {
            e.printStackTrace();



        }
    }

    private HorizontalLayout rezervasyonYap(Grid<Saat>grid,Saat item){
        Button randevu = new Button("Rezerve Et");
        randevu.addClickListener(buttonClickEvent -> {
            dialog.open();

            saha13= item.getSaat();
            textField24.setValue(saha13);

           // Binder<String> rezervasyonBinder3 = new Binder<>();


            try {
                rezervasyonBinder.writeBean(rezervasyon);
            } catch (ValidationException e) {
                e.printStackTrace();
            }
            rezervasyonService.save(rezervasyon);

            id = item.getId();









        });
        HorizontalLayout horizontalLayout11 = new HorizontalLayout();
        horizontalLayout11.add(randevu);
        return horizontalLayout11;
    }






    public List<Tarih> getTarih(){
        return this.tarihService.getList();
    }



    public List<Saha> getList() {

        return this.sahaService.getAll();

    }
}
