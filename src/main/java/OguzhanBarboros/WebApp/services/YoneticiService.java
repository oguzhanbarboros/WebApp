package OguzhanBarboros.WebApp.services;


import OguzhanBarboros.WebApp.model.Yonetici;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface YoneticiService {
    Set<Yonetici> getList();
    List <Yonetici> getAll();
    Yonetici login(String email,String password);
    Yonetici kayitt(Yonetici yonetici);
    void delete(Yonetici yonetici);





}
