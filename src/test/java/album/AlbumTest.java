package album;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    @Test
    void testCSVSerialization() throws IOException {
        Album album = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        Album.serializeToCSV(album, "CSVtestfile.csv");
        Album albumCopy = Album.deserializeFromCSV("CSVtestfile.csv");

        assertEquals(album, albumCopy);
    }
}