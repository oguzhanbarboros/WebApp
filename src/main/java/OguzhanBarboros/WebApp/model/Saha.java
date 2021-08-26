package OguzhanBarboros.WebApp.model;



import com.vaadin.flow.component.HasValue;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Saha  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sahaadi;
    private String fiyat;
    private String alan;
    @ManyToOne
    private Yonetici yonetici;


    @ManyToMany()
    @JoinTable(name="saha_saat",
            joinColumns=@JoinColumn(name = "sahaid"),
            inverseJoinColumns = @JoinColumn(name = "saatid"))
    private List<Saat> saats;


    @ManyToMany(mappedBy = "sahas1")
    private List<Tarih> tarihlist;







}

