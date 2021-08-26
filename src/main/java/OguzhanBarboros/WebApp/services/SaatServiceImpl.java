package OguzhanBarboros.WebApp.services;

import OguzhanBarboros.WebApp.model.Saat;
import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Tarih;
import OguzhanBarboros.WebApp.repostories.SaatRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Set;

@Service
@Transactional
public class SaatServiceImpl implements SaatService{
    private final SaatRepositories saatRepositories;



    @Autowired
    public SaatServiceImpl(SaatRepositories saatRepositories) {
        this.saatRepositories = saatRepositories;
    }

    /*@Override
    public List<Saat> findBySahas(Saha saha) {
        return this.saatRepositories.findBySahas(saha);


    }

     */

    @Override
    public List<Saat> findBySahalistAndTarihlist(Saha saha, Tarih tarih) {
        return this.saatRepositories.findBySahalistAndTarihlist(saha,tarih);
    }

    @Override
    public Set<Saat> getList() {
        return null;
    }

    @Override
    public List<Saat> getAll() {
        return null;
    }

    @Override
    public void deleteByIdAndSahalistAndTarihlist(Long id, Saha saha, Tarih tarih) {

        this.saatRepositories.deleteByIdAndSahalistAndTarihlist(id,saha,tarih);
    }


}
