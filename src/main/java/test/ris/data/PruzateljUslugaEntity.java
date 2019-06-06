package test.ris.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pruzateljusluga")
public class PruzateljUslugaEntity {
    private String oib;
    private String adresa;

    @OneToOne(mappedBy = "pruzateljUsluga", cascade = CascadeType.ALL)
    private FizickaOsobaEntity fizickaOsoba;
//    @OneToOne(mappedBy = "pruzateljUsluga", cascade = CascadeType.ALL)
//    private PravnaOsobaEntity pravnaOsobaEntity;


    public PruzateljUslugaEntity() {
    }

    public PruzateljUslugaEntity(String oib, String adresa) {
        this.oib = oib;
        this.adresa = adresa;
    }

    @Id
    @Column(name = "oib", nullable = false, length = 255)
    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PruzateljUslugaEntity that = (PruzateljUslugaEntity) o;
        return Objects.equals(oib, that.oib) &&
                Objects.equals(adresa, that.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, adresa);
    }
}
