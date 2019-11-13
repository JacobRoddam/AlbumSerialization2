package album;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


public class CSVToolTest {

    @Test
    public void testCSVSerialization() throws IOException {
        Album album1 = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        Album album2 = new Album("Shmilco", "Wilco", "Indie", 12);

        Album[] albums = {album1, album2};
        CSVTool.serializeToCSV(albums, "MultCSVtestFile.csv");
        ArrayList<Album> albumsCopy = CSVTool.deserializeFromCSV("MultCSVtestFile.csv");
        Album album1Copy = albumsCopy.get(0);
        Album album2Copy = albumsCopy.get(1);

        assertEquals(album1, album1Copy);
        assertEquals(album2, album2Copy);


    }


}