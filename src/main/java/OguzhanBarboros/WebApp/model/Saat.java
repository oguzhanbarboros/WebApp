package OguzhanBarboros.WebApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Saat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String saat;
    private Boolean durum;


    @ManyToMany(mappedBy = "saats")
    private List<Saha> sahalist;


    @ManyToMany(mappedBy = "saats1")
    private List<Tarih> tarihlist;



}
