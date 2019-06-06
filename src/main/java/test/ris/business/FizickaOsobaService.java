package test.ris.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.ris.data.FizickaOsobaEntity;
import test.ris.data.FizickaOsobaRepository;
import test.ris.data.PruzateljUslugaRepository;

import java.sql.Date;


@Service
public class FizickaOsobaService {
    @Autowired
    private FizickaOsobaRepository fizickaOsobaRepository;
    @Autowired
    private PruzateljUslugaRepository pruzateljUslugaRepository;

    private static FizickaOsoba convertToObject(FizickaOsobaEntity e) {
        if (e == null) {
            return null;
        }

        return new FizickaOsoba(e.getOib(), e.getIme(), e.getPrezime(), e.getDatumRodjenja());
    }

    private static FizickaOsobaEntity convertToEntity(FizickaOsoba o) {
        if (o == null) {
            return null;
        }

        return new FizickaOsobaEntity(o.getOib(), o.getIme(), o.getPrezime(), o.getDatumRodjenja());
    }

    public FizickaOsoba saveNewFizickaOsoba(FizickaOsoba o) {
        if (fizickaOsobaRepository.existsById(o.getOib())
                || !pruzateljUslugaRepository.existsById(o.getOib())
                || !o.getDatumRodjenja().before(new Date(System.currentTimeMillis()))) {
            return null;
        }
        return convertToObject(fizickaOsobaRepository.save(convertToEntity(o)));
    }

    public FizickaOsoba updateFizickaOsoba(FizickaOsoba o) {
        if (fizickaOsobaRepository.existsById(o.getOib())
                && o.getDatumRodjenja().before(new Date(System.currentTimeMillis()))) {
            return convertToObject(fizickaOsobaRepository.save(convertToEntity(o)));
        }

        return null;
    }

    public FizickaOsoba getForOib(String oib) {
        return convertToObject(fizickaOsobaRepository.findById(oib).orElse(null));
    }
}
