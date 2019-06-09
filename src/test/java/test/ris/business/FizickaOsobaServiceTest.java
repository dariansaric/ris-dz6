package test.ris.business;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizickaOsobaServiceTest {
    private static final Gson GSON = new Gson();

    @Autowired
    private MockMvc mvc;
    @Autowired
    private FizickaOsobaService service;
//    @Autowired
//    private FizickaOsobaServiceInvalid service;


    @Test
    public void testIfMatchingPruzateljExists() {
        FizickaOsoba o = new FizickaOsoba("00003", "Luka", "Lukić", Date.valueOf("1900-1-1"));
        assertNull(service.saveNewFizickaOsoba(o));
    }

    @Test
    public void testFailedSaveInvalidDate() {
        FizickaOsoba o = new FizickaOsoba("00002", "Luka", "Lukić", Date.valueOf("2020-1-1"));
        assertNull(service.saveNewFizickaOsoba(o));
    }

    @Test
    public void testFailedSaveExisting() {
        FizickaOsoba o = new FizickaOsoba("00001", "Luka", "Lukić", Date.valueOf("1900-1-1"));
        assertNull(service.saveNewFizickaOsoba(o));
    }

    @Test
    public void testSuccessfulSave() {
        FizickaOsoba o = new FizickaOsoba("00004", "Luka", "Lukić", Date.valueOf("1900-1-1"));
        Assert.assertEquals(o, service.saveNewFizickaOsoba(o));
    }

    @Test
    public void testValidSaveAndRead() throws Exception {
        FizickaOsoba o = new FizickaOsoba("00002", "Luka", "Lukić", Date.valueOf("1900-1-1"));
        service.saveNewFizickaOsoba(o);
        mvc.perform(get("/fosoba/00002").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(GSON.toJson(o)));
    }

    @Test
    public void testNotSavedAndRead() throws Exception {
        mvc.perform(get("/fosoba/00003").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
