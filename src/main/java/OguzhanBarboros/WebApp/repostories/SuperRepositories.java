package OguzhanBarboros.WebApp.repostories;

import OguzhanBarboros.WebApp.model.Super;
import OguzhanBarboros.WebApp.model.Yonetici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SuperRepositories extends CrudRepository<Super,Long>,JpaRepository<Super,Long> {
    List <Super> findByEmailAndPassword(String email, String password);



}
