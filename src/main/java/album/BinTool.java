package album;

import java.io.*;


public class BinTool implements Serializable {

    public static void serializeToBinary(AlbumList albums, String fileName) throws IOException{
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream outS = new ObjectOutputStream(file);

        outS.writeObject(albums);

        outS.close();
        file.close();
    }

    public static AlbumList deserializeFromBinary(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream inS = new ObjectInputStream(file);

        AlbumList albums = (AlbumList)inS.readObject();

        inS.close();
        file.close();

        return albums;
    }





    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Album alb1 = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        Album alb2 = new Album("Shmilco", "Wilco", "Indie", 12);

        Album[] albumArray = {alb1, alb2};
        AlbumList albums = new AlbumList(albumArray);
        serializeToBinary(albums, "serial.ser");
        AlbumList albumsCopy = deserializeFromBinary("serial.ser");

        Album[] albList = albumsCopy.getAlbumList();

        Album alb1a = albList[0];
        Album alb2a = albList[1];

        System.out.println("alb1 = alb1a: " + alb1.equals(alb1a));
        System.out.println("alb2 = alb2a: " + alb2.equals(alb2a));
    }
}
