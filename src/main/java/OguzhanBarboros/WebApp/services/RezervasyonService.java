package OguzhanBarboros.WebApp.services;

import OguzhanBarboros.WebApp.model.Rezervasyon;
import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Yonetici;

import java.util.List;
import java.util.Set;

public interface RezervasyonService {

    Rezervasyon save(Rezervasyon rezervasyon);

    List<Rezervasyon> findByYoneticiId(long id);

    void delete(Rezervasyon rezervasyon);
    List <Rezervasyon> getAll();


}
