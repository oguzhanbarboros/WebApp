package OguzhanBarboros.WebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarih {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;


    @ManyToMany()
    @JoinTable(name="tarih_saat",
            joinColumns=@JoinColumn(name = "tarihid"),
            inverseJoinColumns = @JoinColumn(name = "saatid"))
    private List<Saat> saats1;


    @ManyToMany()
    @JoinTable(name="tarih_saha",
            joinColumns=@JoinColumn(name = "tarihid"),
            inverseJoinColumns = @JoinColumn(name = "sahaid"))
    private List<Saha> sahas1;




}
