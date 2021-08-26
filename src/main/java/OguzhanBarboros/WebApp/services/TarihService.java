package OguzhanBarboros.WebApp.services;

import OguzhanBarboros.WebApp.model.Saat;
import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Tarih;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface TarihService {
    //List<Saat> findByDateAndSaatAndSaha(Date date, Saat saat, Saha saha);

    List<Tarih> getList();

    //void deleteBySaats1(Long id,Long id2);

}
