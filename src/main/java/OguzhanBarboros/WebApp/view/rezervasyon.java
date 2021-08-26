/*package OguzhanBarboros.WebApp.view;

import OguzhanBarboros.WebApp.model.Admin;
import OguzhanBarboros.WebApp.model.Rezervasyon;
import OguzhanBarboros.WebApp.services.RezervasyonService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.LocalDateTime;
*/
/*
@Route("/rezervasyon")
public class rezervasyon extends VerticalLayout {
    private RezervasyonService rezervasyonService;

    Rezervasyon rezervasyon = new Rezervasyon();


    Button button = new Button("08:00-09:00");

    HorizontalLayout horizontalLayout = new HorizontalLayout();
    HorizontalLayout dateLayout = new HorizontalLayout();
    HorizontalLayout horizontalLayout2 = new HorizontalLayout();
    HorizontalLayout horizontalLayout3 = new HorizontalLayout();
    HorizontalLayout horizontalLayout4 = new HorizontalLayout();
    Button kaydet = new Button("Kaydet");

    public rezervasyon(RezervasyonService rezervasyonService){
        this.rezervasyonService = rezervasyonService;

        getElement().setAttribute("theme","dark");



        Dialog dialog = new Dialog();
        dialog.setModal(true);
        Binder<Rezervasyon> rezervasyonBinder = new Binder<>();


        TextField textField = new TextField("Email", "Emaili Giriniz");

        rezervasyonBinder.bind(textField, Rezervasyon::getEmail, Rezervasyon::setEmail);


        FormLayout formLayout = new FormLayout();
        formLayout.add(textField);

        button.setWidth("300px");
        button.setHeight("150px");
        {

            button.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button.setEnabled(false);

            });


        }


        kaydet.addClickListener(buttonClickEvent -> {

            try {

                rezervasyonBinder.writeBean(rezervasyon);
            } catch (ValidationException e) {
                e.printStackTrace();
            }




            rezervasyonService.save(rezervasyon);


            dialog.close();

        });
        dialog.add(formLayout, kaydet);

        DatePicker datePicker = new DatePicker();
        dateLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        dateLayout.setWidth("100%");

        horizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout.setWidth("100%");

        horizontalLayout2.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout2.setWidth("100%");

        horizontalLayout3.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout3.setWidth("100%");

        horizontalLayout4.setJustifyContentMode(JustifyContentMode.CENTER);
        horizontalLayout4.setWidth("100%");




        Button button1 = new Button("09:00-10:00");
        button1.setWidth("300px");
        button1.setHeight("150px");
        {

            button1.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button1.setEnabled(false);

            });

        }
        Button button2 = new Button("10:00-11:00");
        button2.setWidth("300px");
        button2.setHeight("150px");
        {

            button2.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button2.setEnabled(false);
            });


        }


        Button button3 = new Button("11:00-12:00");

        button3.setWidth("300px");
        button3.setHeight("150px");
        {

            button3.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button3.setEnabled(false);

            });

        }
        Button button4 = new Button("12:00-13:00");
        button4.setWidth("300px");
        button4.setHeight("150px");
        {

            button4.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button4.setEnabled(false);

            });
        }

        Button button5 = new Button("13:00-14:00");
        button5.setWidth("300px");
        button5.setHeight("150px");
        {

            button5.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button5.setEnabled(false);
            });
        }

        Button button6 = new Button("14:00-15:00");
        button6.setWidth("300px");
        button6.setHeight("150px");
        {

            button6.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button6.setEnabled(false);
            });

        }
        Button button7 = new Button("15:00-16:00");
        button7.setWidth("300px");
        button7.setHeight("150px");
        {

            button7.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button7.setEnabled(false);

            });
        }
        Button button8 = new Button("16:00-17:00");
        button8.setWidth("300px");
        button8.setHeight("150px");
        {

            button8.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button8.setEnabled(false);

            });

        }
        Button button9 = new Button("17:00-18:00");
        button9.setWidth("300px");
        button9.setHeight("150px");
        {

            button9.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button9.setEnabled(false);

            });
        }
        Button button10 = new Button("18:00-19:00");
        button10.setWidth("300px");
        button10.setHeight("150px");
        {

            button10.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button10.setEnabled(false);

            });
        }
        Button button11 = new Button("19:00-20:00");
        button11.setWidth("300px");
        button11.setHeight("150px");
        {

            button11.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button11.setEnabled(false);

            });
        }
        Button button12 = new Button("20:00-21:00");
        button12.setWidth("300px");
        button12.setHeight("150px");
        {

            button12.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button12.setEnabled(false);

            });
        }
        Button button13 = new Button("22:00-23:00");
        button13.setWidth("300px");
        button13.setHeight("150px");
        {

            button13.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button13.setEnabled(false);
            });
        }

        Button button14 = new Button("23:00-24:00");
        button14.setWidth("300px");
        button14.setHeight("150px");
        {

            button14.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button14.setEnabled(false);

            });
        }
        Button button15 = new Button("00:00-01:00");
        button15.setWidth("300px");
        button15.setHeight("150px");
        {

            button15.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button15.setEnabled(false);

            });

        }
        Button button16 = new Button("01:00-02:00");
        button16.setWidth("300px");
        button16.setHeight("150px");
        {

            button16.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button6.setEnabled(false);

            });

        }
        Button button17 = new Button("02:00-03:00");
        button17.setWidth("300px");
        button17.setHeight("150px");
        {

            button17.addClickListener(buttonClickEvent -> {
                rezervasyonBinder.readBean(new Rezervasyon());
                dialog.open();
                button17.setEnabled(false);

            });

        }


        Button geriGit = new Button("Geri", VaadinIcon.BACKWARDS.create());
        geriGit.addClickListener(buttonClickEvent -> {
            UI.getCurrent().getPage().setLocation("abcd");
        });

        geriGit.setWidth("100px");
        geriGit.setHeight("50px");
        geriGit.getStyle().set("border","3px solid white");
        datePicker.setWidth("600px");
        datePicker.setHeight("200px");
        datePicker.setValue(LocalDate.from(LocalDateTime.now()));
        dateLayout.add(datePicker);
        horizontalLayout.add(button15, button16,button17);
        horizontalLayout2.add(button,button1, button2, button3,button4, button5, button6, button7);
        horizontalLayout3.add(button8, button9, button10, button11);
        horizontalLayout4.add(button12, button13, button14);

        horizontalLayout4.setHeight("800px");

        button.getStyle().set("border","5px solid white");
        button1.getStyle().set("border","5px solid white");
        button2.getStyle().set("border","5px solid white");
        button3.getStyle().set("border","5px solid white");
        button4.getStyle().set("border","5px solid white");
        button5.getStyle().set("border","5px solid white");
        button6.getStyle().set("border","5px solid white");
        button7.getStyle().set("border","5px solid white");
        button8.getStyle().set("border","5px solid white");
        button9.getStyle().set("border","5px solid white");
        button10.getStyle().set("border","5px solid white");
        button11.getStyle().set("border","5px solid white");
        button12.getStyle().set("border","5px solid white");
        button13.getStyle().set("border","5px solid white");
        button14.getStyle().set("border","5px solid white");
        button15.getStyle().set("border","5px solid white");
        button16.getStyle().set("border","5px solid white");
        button17.getStyle().set("border","5px solid white");

        add(geriGit);
        add(dateLayout, horizontalLayout, horizontalLayout2, horizontalLayout3, horizontalLayout4);
    }
}
*/




