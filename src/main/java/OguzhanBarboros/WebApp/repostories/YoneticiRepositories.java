package OguzhanBarboros.WebApp.repostories;

import OguzhanBarboros.WebApp.model.Yonetici;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface YoneticiRepositories extends CrudRepository<Yonetici,Long> , JpaRepository<Yonetici,Long> {
    List <Yonetici> findByEmailAndPassword(String email,String password);

}
