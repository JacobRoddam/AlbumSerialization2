package album;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BinToolTest {

    @Test
    public void testBinarySerialization() throws IOException, ClassNotFoundException {
        Album album1 = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        Album album2 = new Album("Shmilco", "Wilco", "Indie", 12);

        Album[] albums = {album1, album2};
        AlbumList albumList = new AlbumList(albums);

        BinTool.serializeToBinary(albumList, "BinToolTestFile.ser");
        AlbumList albumListCopy = BinTool.deserializeFromBinary("BinToolTestFile.ser");
        Album album1Copy = albumListCopy.getAlbum(0);
        Album album2Copy = albumListCopy.getAlbum(1);

        assertEquals(album1, album1Copy);
        assertEquals(album2, album2Copy);
        assertArrayEquals(albumList.getAlbumList(), albumListCopy.getAlbumList());
    }
}