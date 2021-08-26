package OguzhanBarboros.WebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Rezervasyon {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String rezervasyonsahaadi;
    private String rezervasyonsaat;
    private String rezervasyontarih;
    private Long  sahaid;


    @ManyToOne
    private Yonetici yonetici;


}
