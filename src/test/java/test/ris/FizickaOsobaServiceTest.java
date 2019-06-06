package test.ris;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import test.ris.business.FizickaOsoba;
import test.ris.business.FizickaOsobaService;
import static org.junit.Assert.*;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizickaOsobaServiceTest {
    //sve prolazi ako se zasebno pokrenu

    @Autowired
    private MockMvc mvc;
    @Autowired
    private FizickaOsobaService service;

    @Before
    public void setUp() {
        //todo: napravi?
    }

    @Test
    public void testIfMatchingPruzateljExists() {
        FizickaOsoba o = new FizickaOsoba("00003", "Luka", "Lukić", Date.valueOf("1900-1-1"));
        assertNull(service.saveNewFizickaOsoba(o));
        o.setOib("00002");
        assertEquals(o, service.saveNewFizickaOsoba(o));
    }

    @Test
    public void testFailedSaveExisting() {
        FizickaOsoba o = new FizickaOsoba("00001", "Luka", "Lukić", Date.valueOf("1900-1-1"));
        assertNull(service.saveNewFizickaOsoba(o));
        o.setOib("00002");
        assertEquals(o, service.saveNewFizickaOsoba(o));
    }
}
