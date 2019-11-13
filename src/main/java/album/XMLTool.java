package album;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class XMLTool {

    public static void serializeToXML(AlbumList albums, String fileName) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("album-list", AlbumList.class);
        xstream.addImplicitArray(AlbumList.class, "albumList");
        xstream.alias("album", Album.class);

        OutputStream outS = new FileOutputStream(fileName);

        xstream.toXML(albums, outS);
    }

    public static AlbumList deserializeFromXML(String fileName) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("album-list", AlbumList.class);
        xstream.addImplicitArray(AlbumList.class, "albumList");
        xstream.alias("album", Album.class);

        InputStream inS = new FileInputStream(fileName);

        AlbumList albums = (AlbumList) xstream.fromXML(inS);

        return albums;
    }
}
