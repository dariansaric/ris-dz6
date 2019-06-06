package test.ris.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.ris.data.PruzateljUslugaEntity;
import test.ris.data.PruzateljUslugaRepository;


@Service
public class PruzateljUslugaService {
    @Autowired
    private PruzateljUslugaRepository repository;

    public PruzateljUsluga getForOIB(String oib) {
        return convertToObject(repository.findById(oib).orElse(null));
    }

    private PruzateljUsluga convertToObject(PruzateljUslugaEntity e) {
        if (e == null) {
            return null;
        }
        return new PruzateljUsluga(e.getOib(), e.getAdresa());
    }
}
