package test.ris.data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
//@Table(name = "pravnaosoba")
public class PravnaOsobaEntity {
    private String oib;
    private String naziv;
    private Date datumOsnivanja;
    private double pocetniKapital;

    @Id
    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Basic
    public Date getDatumOsnivanja() {
        return datumOsnivanja;
    }

    public void setDatumOsnivanja(Date datumOsnivanja) {
        this.datumOsnivanja = datumOsnivanja;
    }

    @Basic
    public double getPocetniKapital() {
        return pocetniKapital;
    }

    public void setPocetniKapital(double pocetniKapital) {
        this.pocetniKapital = pocetniKapital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PravnaOsobaEntity that = (PravnaOsobaEntity) o;
        return Double.compare(that.pocetniKapital, pocetniKapital) == 0 &&
                Objects.equals(oib, that.oib) &&
                Objects.equals(naziv, that.naziv) &&
                Objects.equals(datumOsnivanja, that.datumOsnivanja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, naziv, datumOsnivanja, pocetniKapital);
    }
}
