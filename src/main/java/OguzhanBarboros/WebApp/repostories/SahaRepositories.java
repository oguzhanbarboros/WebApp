

package OguzhanBarboros.WebApp.repostories;

import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Yonetici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SahaRepositories extends CrudRepository<Saha,Long>,JpaRepository <Saha,Long>  {

    List<Saha> findByYoneticiId(Long systemUserId);


    List<Saha> findByYonetici(Yonetici yonetici);

    @Query(value = "select t.sahaadi,t.fiyat,t.alan from Saha t")
    List<String> sahabilgileri();



    //List<Saha> getBysahaadiandfiyatandalan();
}
