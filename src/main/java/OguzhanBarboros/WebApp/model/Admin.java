package OguzhanBarboros.WebApp.model;

import javax.persistence.*;

@Entity
@Table(name = "Admins")

public class Admin {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "halisahaadi")
    private String halisahaadi;
    @Column(name = "eposta")
    private String eposta;
    @Column(name = "sifre")
    private String sifre;

    public Admin() {
    }

    public Admin(int id, String halisahaadi, String eposta, String sifre) {
        this.id = id;
        this.halisahaadi = halisahaadi;
        this.eposta = eposta;
        this.sifre = sifre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHalisahaadi() {
        return halisahaadi;
    }

    public void setHalisahaadi(String halisahaadi) {
        this.halisahaadi = halisahaadi;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}


