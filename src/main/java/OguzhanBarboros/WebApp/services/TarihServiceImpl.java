package OguzhanBarboros.WebApp.services;

import OguzhanBarboros.WebApp.model.Saat;
import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Tarih;
import OguzhanBarboros.WebApp.repostories.TarihRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class TarihServiceImpl implements TarihService{
    private TarihRepositories tarihRepositories;
    @Autowired
    public TarihServiceImpl(TarihRepositories tarihRepositories) {
        super();
        this.tarihRepositories = tarihRepositories;
    }

    /*
    @Override
    public List<Saat> findByDateAndSaatAndSaha(Date date, Saat saat, Saha saha) {
        return tarihRepositories.findByDateAndSaatAndSaha(date,saat,saha);
    }

     */

    @Override
    public List<Tarih> getList() {

      List<Tarih> tarihs =new ArrayList<>();
      tarihRepositories.findAll().iterator().forEachRemaining(tarihs::add);
      return tarihs;
    }

    /*@Override
    public void deleteBySaats1(Long id, Long id2) {
        this.tarihRepositories.deleteBySaats1(id,id2);
    }
*/

}
