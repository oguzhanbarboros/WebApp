package OguzhanBarboros.WebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Super {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    private Long id;

    private  String email;

    private  String password;




}
