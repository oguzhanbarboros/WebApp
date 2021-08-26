
package OguzhanBarboros.WebApp.services;

import OguzhanBarboros.WebApp.model.Saha;
import OguzhanBarboros.WebApp.model.Yonetici;
import OguzhanBarboros.WebApp.repostories.SahaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SahaServiceImpl implements SahaService {

    private final SahaRepositories sahaRepositories;
    @Autowired
    public SahaServiceImpl(SahaRepositories sahaRepositories) {
        super();
        this.sahaRepositories = sahaRepositories;
    }
    @Override
   public Saha kayit(Saha saha){ return this.sahaRepositories.save(saha);
   }
    @Override
    public Set<Saha> getList() {
        Set<Saha> personSet =new HashSet<>();
        sahaRepositories.findAll().iterator().forEachRemaining(personSet::add);
        return personSet;
    }

    @Override
    public Set<Saha> getList(Long systemUserId) {
        Set<Saha> personSet =new HashSet<>();
        sahaRepositories.findByYoneticiId(systemUserId).iterator().forEachRemaining(personSet::add);
        return personSet;
    }

    /*
    @Override
    public Set<Saha> getList(String filter, Long systemUserId) {
        Set<Saha> personSet =new HashSet<>();
        sahaRepositories.findByNameContainingAndSystemUserId(filter,systemUserId).iterator().forEachRemaining(personSet::add);
        return personSet;
    }

     */

    @Override
    public List<Saha> getAll() { return this.sahaRepositories.findAll();
    }
    @Override
    public void delete(Saha saha) { sahaRepositories.delete(saha);
    }

    @Override
    public List<Saha> findByYonetici(Yonetici yonetici) {
        return this.sahaRepositories.findByYonetici(yonetici);
    }

    @Override
    public List<String> sahabilgileri() {
        return this.sahaRepositories.sahabilgileri();
    }


    /*@Override
    public List<Saha> getBysahaadiandfiyatandalan() {
        return  this.sahaRepositories.getBysahaadiandfiyatandalan();
    }

*/
}
