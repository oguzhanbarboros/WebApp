package OguzhanBarboros.WebApp.services;



import OguzhanBarboros.WebApp.model.Super;
import OguzhanBarboros.WebApp.repostories.SuperRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SuperServiceImpl implements SuperService{
    private final SuperRepositories superRepositories;

    public SuperServiceImpl(SuperRepositories superRepositories) {
        this.superRepositories = superRepositories;
    }


    @Override
    public List<Super> getAll() {
        return null;
    }

    @Override
    public Super login(String email, String password) {
        List<Super> result= superRepositories.findByEmailAndPassword(email,password);
        if (result.size()==0){

            return new Super();
        }
        return result.get(0);
    }

    @Override
    public Super kayit(Super super1) {

        return superRepositories.save(super1);

    }


}

