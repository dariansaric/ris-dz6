package test.ris.business;

import java.sql.Date;
import java.util.Objects;


public class PravnaOsoba {
    private String oib;
    private String naziv;
    private Date datumOsnivanja;
    private double pocetniKapital;

    public PravnaOsoba(String oib, String naziv, Date datumOsnivanja, double pocetniKapital) {
        this.oib = oib;
        this.naziv = naziv;
        this.datumOsnivanja = datumOsnivanja;
        this.pocetniKapital = pocetniKapital;
    }

    public PravnaOsoba() {
    }

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

    public Date getDatumOsnivanja() {
        return datumOsnivanja;
    }

    public void setDatumOsnivanja(Date datumOsnivanja) {
        this.datumOsnivanja = datumOsnivanja;
    }

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
        PravnaOsoba that = (PravnaOsoba) o;
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
