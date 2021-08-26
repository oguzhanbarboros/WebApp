package OguzhanBarboros.WebApp.repostories;

import OguzhanBarboros.WebApp.model.Rezervasyon;
import OguzhanBarboros.WebApp.model.Saha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RezervasyonRepositories extends CrudRepository<Rezervasyon,Long>,JpaRepository<Rezervasyon,Long> {

    List<Rezervasyon> findByYoneticiId(long id);
}
