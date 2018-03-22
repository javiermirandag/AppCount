package es.ulpgc.da.appcount.test;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import es.ulpgc.da.appcount.data.ModelDbItem;
import es.ulpgc.da.appcount.data.DatabaseFacade;

import static org.junit.Assert.*;

public class databaseFacadeTest {
    private DatabaseFacade db;

    @Before
    public void setUp() throws Exception {
        db = new DatabaseFacade();

        for (int j=1; j <= 10; j++) {
            String contents = "test contents " + j;
            String details = "test details " + j;

            ModelDbItem item = new ModelDbItem(contents, details);
            db.insertDatabaseItem(item);
        }
    }

    @Test
    public void deleteAllDatabaseItems() throws Exception {
        db.deleteAllDatabaseItems();
        int db_length = db.getAllItemsFromDatabase().size();

        assertEquals (db_length, 0);
    }

    @Test
    public void deleteDatabaseItem() throws Exception {
        db.deleteDatabaseItem(1);
        assertEquals(null, db.getItem(1));
    }

    @Test
    public void getItem() throws Exception {
        db = new DatabaseFacade();

        String contents = "test contents";
        String details = "test details";

        ModelDbItem item = new ModelDbItem(contents, details);
        db.insertDatabaseItem(item);

        assertEquals(item, db.getItem(0));
    }

    @Test
    public void getAllItemsFromDatabase() throws Exception {
        ModelDbItem[] items = new ModelDbItem[5];

        db = new DatabaseFacade();

        //  Create the elements and store them in the database (and also
        //  in the local array).
        for (int j=0; j<5; j++) {
            ModelDbItem newItem = new ModelDbItem();
            items[j] = newItem;
            db.insertDatabaseItem(newItem);
        }

        List<ModelDbItem> dblist = db.getAllItemsFromDatabase();

        //  Check that all the elements are in the returned list
        for (int j=0; j<5; j++) {
            ModelDbItem item = items[j];
            assertTrue(dblist.contains(item));
        }
    }

    @Test
    public void getAllItemsArrayFromDatabase() throws Exception {
        ModelDbItem[] items = new ModelDbItem[5];

        db = new DatabaseFacade();

        //  Create the elements and store them in the database (and also
        //  in the local array).
        for (int j=0; j<5; j++) {
            ModelDbItem newItem = new ModelDbItem();
            items[j] = newItem;
            db.insertDatabaseItem(newItem);
        }

        ModelDbItem[] dblist = db.getAllItemsArrayFromDatabase();

        //  Check that all the elements are in the returned array
        for (int j=0; j<5; j++) {
            assertEquals(items[j], dblist[j]);
        }

    }

}