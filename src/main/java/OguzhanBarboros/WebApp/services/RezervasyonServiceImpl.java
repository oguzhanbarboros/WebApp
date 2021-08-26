package OguzhanBarboros.WebApp.services;

import OguzhanBarboros.WebApp.model.Rezervasyon;
import OguzhanBarboros.WebApp.model.Yonetici;
import OguzhanBarboros.WebApp.repostories.RezervasyonRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RezervasyonServiceImpl implements RezervasyonService {
    private RezervasyonRepositories rezervasyonRepositories;


    @Autowired
    public RezervasyonServiceImpl(RezervasyonRepositories rezervasyonRepositories) {
        this.rezervasyonRepositories = rezervasyonRepositories;
    }

    @Override
    public Rezervasyon save(Rezervasyon rezervasyon) {
        return this.rezervasyonRepositories.save(rezervasyon);


    }

    @Override
    public List<Rezervasyon> findByYoneticiId(long id) {
        List<Rezervasyon> rezervasyons = new ArrayList<>();
        rezervasyonRepositories.findByYoneticiId(id).iterator().forEachRemaining(rezervasyons::add);

        return rezervasyons;

    }
    @Override
    public void delete(Rezervasyon rezervasyon) { rezervasyonRepositories.delete(rezervasyon);
    }
    @Override
    public  List <Rezervasyon> getAll(){
        return this.rezervasyonRepositories.findAll();
    }

}
