package OguzhanBarboros.WebApp.repostories;

import OguzhanBarboros.WebApp.model.Saat;
import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Tarih;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TarihRepositories extends CrudRepository<Tarih,Long>, JpaRepository<Tarih,Long> {


   // List<Saat> findByDateAndSaatAndSaha(Date date, Saat saat, Saha saha);



    //void deleteBySaats1(Long id,Long id2);



    //@Query(value = "delete from Tarih b where b.id = b.saats1 ");


}
