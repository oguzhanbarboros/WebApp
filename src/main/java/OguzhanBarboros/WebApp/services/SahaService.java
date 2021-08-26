
package OguzhanBarboros.WebApp.services;


import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Yonetici;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface SahaService {

    Set<Saha> getList();

    Set<Saha> getList(Long systemUserId);


    List<Saha> getAll();
    Saha kayit(Saha saha);
    void delete(Saha saha);
    List<Saha> findByYonetici(Yonetici yonetici);

    List<String> sahabilgileri();
//    List<Saha> getBysahaadiandfiyatandalan(String sahaadi,String fiyat, String alan);


}
