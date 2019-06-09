package test.ris.data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class FizickaOsobaEntity {
    private String oib;
    private String ime;
    private String prezime;
    private Date datumRodjenja;

    public FizickaOsobaEntity() {
    }

    public FizickaOsobaEntity(String oib, String ime, String prezime, Date datumRodjenja) {
        this.oib = oib;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
    }

    @Id
    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    @Basic
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FizickaOsobaEntity that = (FizickaOsobaEntity) o;
        return Objects.equals(oib, that.oib) &&
                Objects.equals(ime, that.ime) &&
                Objects.equals(prezime, that.prezime) &&
                Objects.equals(datumRodjenja, that.datumRodjenja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, ime, prezime, datumRodjenja);
    }
}
