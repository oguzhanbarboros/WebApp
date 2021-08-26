package OguzhanBarboros.WebApp.services;


import OguzhanBarboros.WebApp.model.Super;



import java.util.List;

public interface SuperService {
    List<Super> getAll();
    Super login(String email, String password);
    Super kayit(Super super1);
}
