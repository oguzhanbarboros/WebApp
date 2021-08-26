package OguzhanBarboros.WebApp.repostories;

import OguzhanBarboros.WebApp.model.Saat;
import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Tarih;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaatRepositories extends CrudRepository<Saat,Long>, JpaRepository<Saat,Long> {

  // List<Saat> findByTarihlistAndAndSahalist(Tarih tarih,Saha saha);
   //List<Saat> findBySahaandTarih(Saha saha,Tarih tarih);
    List<Saat> findBySahalistAndTarihlist(Saha saha,Tarih tarih);

    void deleteByIdAndSahalistAndTarihlist(Long id,Saha saha,Tarih tarih);

}
