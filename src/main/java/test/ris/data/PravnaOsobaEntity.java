package test.ris.data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

//@Entity
//@Table(name = "pravnaosoba")
public class PravnaOsobaEntity {
    private String oib;
    private String naziv;
    private Date datumOsnivanja;
    private double pocetniKapital;

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
    @Column(name = "datumOsnivanja", nullable = false)
    public Date getDatumOsnivanja() {
        return datumOsnivanja;
    }

    public void setDatumOsnivanja(Date datumOsnivanja) {
        this.datumOsnivanja = datumOsnivanja;
    }

    @Basic
    @Column(name = "pocetniKapital", nullable = false, precision = 0)
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
