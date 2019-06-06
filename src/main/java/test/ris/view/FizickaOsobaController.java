package test.ris.view;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.ris.business.FizickaOsoba;
import test.ris.business.FizickaOsobaService;

@RestController
@RequestMapping("/fosoba")
public class FizickaOsobaController {
    private static final Gson GSON = new Gson();

    @Autowired
    private FizickaOsobaService service;

    @GetMapping("/{oib}")
    public String getOsoba(@PathVariable(name = "oib") final String oib) {
        return GSON.toJson(service.getForOib(oib));
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
