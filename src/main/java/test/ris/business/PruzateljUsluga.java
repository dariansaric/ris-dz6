package test.ris.business;

import java.util.Objects;


public class PruzateljUsluga {
    private String oib;
    private String adresa;

    public PruzateljUsluga(String oib, String adresa) {
        this.oib = oib;
        this.adresa = adresa;
    }

    public PruzateljUsluga() {
    }


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
        PruzateljUsluga that = (PruzateljUsluga) o;
        return Objects.equals(oib, that.oib) &&
                Objects.equals(adresa, that.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, adresa);
    }
}
