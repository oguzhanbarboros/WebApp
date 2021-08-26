/*package OguzhanBarboros.WebApp.bootstrap;


import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Yonetici;

import OguzhanBarboros.WebApp.services.SahaService;
import OguzhanBarboros.WebApp.services.YoneticiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final SahaService sahaService;
    private final YoneticiService yoneticiService;


    public BootStrapData(SahaService sahaService, YoneticiService yoneticiService) {
        this.sahaService = sahaService;

        this.yoneticiService = yoneticiService;
    }



    @Override
    public void run(String... args) throws Exception {


        Yonetici yonetici = new Yonetici();
        yonetici.setEmail("oguzbar41@hotmail.com");
        yonetici.setPassword("12345");



        yoneticiService.save(yonetici);

        Yonetici yonetici1 = new Yonetici();
        yonetici1.setEmail("aa@hotmail.com");

        yonetici1.setPassword("123");
        yoneticiService.save(yonetici1);

        Saha saha = new Saha();
        saha.setAlan("15");
        saha.setFiyat("15");
        saha.setYonetici(yonetici);
        sahaService.kayit(saha);







    }
}
*/