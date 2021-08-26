package OguzhanBarboros.WebApp.services;
import OguzhanBarboros.WebApp.model.Yonetici;
import OguzhanBarboros.WebApp.repostories.YoneticiRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class YoneticiServiceImpl implements YoneticiService {

    private  final YoneticiRepositories yoneticiRepositories;
    @Autowired
    public YoneticiServiceImpl(YoneticiRepositories yoneticiRepositories) {
        super();
        this.yoneticiRepositories = yoneticiRepositories;
    }

    @Override
    public Yonetici kayitt(Yonetici yonetici) {
        return this.yoneticiRepositories.save(yonetici);
    }

    @Override
    public Set<Yonetici> getList() {
        Set<Yonetici> personSet =new HashSet<>();
        yoneticiRepositories.findAll().iterator().forEachRemaining(personSet::add);
        return personSet;
    }

    @Override
    public  List <Yonetici> getAll(){
        return this.yoneticiRepositories.findAll();
    }


    @Override
    public Yonetici login(String email,String password) {
        List<Yonetici> result= yoneticiRepositories.findByEmailAndPassword(email,password);
        if (result.size()==0){

            return new Yonetici();
        }
        return result.get(0);

    }
    @Override
    public void delete(Yonetici yonetici) { yoneticiRepositories.delete(yonetici);
    }




}




