package AlbumClasses;

import java.io.*;
import java.util.ArrayList;


public class BinTool implements Serializable {

    public static void serializeToBinary(Album[] Albums, String fileName) throws IOException {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream outS = new ObjectOutputStream(file);

        for (int i = 0; i < Albums.length; i++){         // new line?
            outS.writeObject(Albums[i]);


        }
        outS.close();
        file.close();
    }

    public static ArrayList<Album> deserializeFromBinary(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream inS = new ObjectInputStream(file);
        ArrayList<Album> albums = new ArrayList<>();
        Album a;

        a = (Album)inS.readObject();
        while (a != null){                   // new line?
            albums.add(a);
            a = (Album)inS.readObject();
        }

        inS.close();
        file.close();

        return albums;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Album alb1 = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        Album alb2 = new Album("Shmilco", "Wilco", "Indie", 12);

        Album[] albums = {alb1, alb2};
        serializeToBinary(albums, "serial.ser");
        ArrayList<Album> albList = deserializeFromBinary("serial.ser");

        Album alb1a = albList.get(0);
        Album alb2a = albList.get(1);

        System.out.println("alb1 = alb1a: " + alb1.equals(alb1a));
        System.out.println("alb2 = alb2a: " + alb2.equals(alb2a));
    }
}
