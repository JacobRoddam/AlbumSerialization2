package album;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AlbumTest {
    @Test
    public void testCSVSerialization() throws IOException {
        Album album = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        Album.serializeToCSV(album, "CSVtestfile.csv");
        Album albumCopy = Album.deserializeFromCSV("CSVtestfile.csv");

        assertEquals(album, albumCopy);
    }

    @Test
    public void testBinSerialization() throws IOException, ClassNotFoundException {
        Album album = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        Album.serializeToBinary(album, "BinTestFile.ser");
        Album albumCopy = Album.deserializeFromBinary("BinTestFile.ser");

        assertEquals(album, albumCopy);
    }

    @Test
    public void testXMLSerialization() throws IOException {
        Album album = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        Album.serializeToXML(album, "xmlSerTestFile.xml");
        Album albumCopy = Album.deserializeFromXML("xmlSerTestFile.xml");

        assertEquals(album, albumCopy);
        

    }

}