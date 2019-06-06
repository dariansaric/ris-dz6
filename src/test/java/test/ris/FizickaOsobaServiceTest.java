package test.ris;

import com.google.gson.Gson;
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

import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizickaOsobaServiceTest {
    //sve prolazi ako se zasebno pokrenu
    private static final Gson GSON = new Gson();

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
        //todo:drukčije testirati
        assertNull(service.saveNewFizickaOsoba(o));
        o.setOib("00002");
        assertEquals(o, service.saveNewFizickaOsoba(o));
    }

    @Test
    public void testFailedSaveExisting() {
        FizickaOsoba o = new FizickaOsoba("00001", "Luka", "Lukić", Date.valueOf("1900-1-1"));
        assertNull(service.saveNewFizickaOsoba(o));
        //todo:drukčije testirati
        o.setOib("00002");
        assertEquals(o, service.saveNewFizickaOsoba(o));
    }

    @Test
    public void testSuccessfulSave() {
        FizickaOsoba o = new FizickaOsoba("00002", "Luka", "Lukić", Date.valueOf("1900-1-1"));
        assertEquals(o, service.saveNewFizickaOsoba(o));
    }

    @Test
    public void testValidSaveAndRead() throws Exception {
        FizickaOsoba o = new FizickaOsoba("00002", "Luka", "Lukić", Date.valueOf("1900-1-1"));
//        FizickaOsoba o1 = service.saveNewFizickaOsoba(o);
        testSuccessfulSave();
        mvc.perform(get("/fosoba/00002"))
                .andExpect(status().isOk())
                .andExpect(content().json(GSON.toJson(o)));
    }
}
