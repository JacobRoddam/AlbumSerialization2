package album;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CSVTool {

    public static void serializeToCSV(Album[] albums, String CSVFileName) throws IOException{

        OutputStream outS = new FileOutputStream(CSVFileName);
        OutputStreamWriter wr = new OutputStreamWriter(outS, StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(wr);

        for (int i = 0; i < albums.length; i++){
            String csv = albums[i].getCSVString();

            writer.write(csv);
            writer.newLine();
        }
        writer.close();

    }

    public static ArrayList<Album> deserializeFromCSV(String CSVFileName) throws IOException{
        ArrayList<Album> albums = new ArrayList<>();

        InputStream in = new FileInputStream(CSVFileName);
        InputStreamReader inR = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(inR);

        String line = br.readLine();
        Album alb;
        while (line != null){
            String[] memberArray = line.split(",");
            for (int j = 0; j < memberArray.length; j++){
                memberArray[j] = memberArray[j].trim();
            }
            int numOfSongs = Integer.parseInt(memberArray[memberArray.length - 1]);
            alb = new Album(memberArray[0], memberArray[1], memberArray[2], numOfSongs);
            albums.add(alb);
            line = br.readLine();
        }

        br.close();

        return albums;
    }





}
