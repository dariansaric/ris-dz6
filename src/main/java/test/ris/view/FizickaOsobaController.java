package test.ris.view;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.ris.business.FizickaOsoba;
import test.ris.business.FizickaOsobaService;

@RestController
@RequestMapping("/fosoba")
public class FizickaOsobaController {
    private static final Gson GSON = new Gson();

    @Autowired
    private FizickaOsobaService service;

    @GetMapping(value = "/{oib}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getOsoba(@PathVariable(name = "oib") final String oib) {
        FizickaOsoba o = service.getForOib(oib);
        return o == null ?
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(GSON.toJson(service.getForOib(oib)), HttpStatus.OK);
    }

    @PostMapping()
    public String postOsoba(@RequestBody FizickaOsoba osoba) {
        FizickaOsoba o = service.saveNewFizickaOsoba(osoba);

        if (osoba.equals(o)) {
            return GSON.toJson(o);
        } else {
            return "failed";
        }
    }
}
