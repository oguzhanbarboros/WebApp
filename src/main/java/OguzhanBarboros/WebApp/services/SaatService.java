package OguzhanBarboros.WebApp.services;

import OguzhanBarboros.WebApp.model.Saat;
import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Tarih;
import OguzhanBarboros.WebApp.model.Yonetici;

import java.util.List;
import java.util.Set;

public interface SaatService {

    // List<Saat> findBySahas(Saha saha);

    List<Saat> findBySahalistAndTarihlist(Saha saha, Tarih tarih);


    Set<Saat> getList();

    List<Saat> getAll();

    void deleteByIdAndSahalistAndTarihlist(Long id,Saha saha,Tarih tarih);
}
