package AlbumClasses;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CSVTool {

    public static void serializeToCSV(Album[] albums, String CSVFileName) throws IOException{
        //BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileName));
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

    public static ArrayList<Album> deserializeToCSV(String CSVFileName) throws IOException{
        BufferedReader br = null;
        String line;
        ArrayList<Album> albums = new ArrayList<>();
        InputStream in = new FileInputStream(CSVFileName);
        InputStreamReader inR = new InputStreamReader(in, StandardCharsets.UTF_8);


        //System.out.println("Try entered");
        br = new BufferedReader(inR);
        line = br.readLine();
            //System.out.println(line);
        int i = 0;
        Album alb;
        while (line != null){
                //System.out.println("If entered");
            String[] memberArray = line.trim().split(",");
            int numOfSongs = Integer.parseInt(memberArray[memberArray.length - 1]);
            alb = new Album(memberArray[0], memberArray[1], memberArray[2], numOfSongs);
            albums.add(alb);
            line = br.readLine();
        }



        br.close();


        return albums;

    }





}
