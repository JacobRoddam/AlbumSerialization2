package AlbumClasses;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class Album implements Serializable{

    protected String name;
    protected String artist;
    protected String genre;
    protected int numSongs;

    public Album(String name, String artist, String genre, int numSongs) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.numSongs = numSongs;
    }

    // get methods
    public String getName(){
        return name;
    }

    public String getArtist(){
        return artist;
    }

    public String getGenre(){
        return genre;
    }

    public int getNumSongs(){
        return numSongs;
    }

    // set methods
    public void setName(String newName){
        name = newName;
    }

    public void setArtist(String newArtist){
        artist = newArtist;
    }

    public void setGenre(String newGenre){
        genre = newGenre;
    }

    public void setNumSongs(int newNumSongs){
        numSongs = newNumSongs;
    }

    //Override equals(), compareTo(), and hashCode() methods

    /*
     * Overrides equals() method
     * Returns true if obj is an instance of Album and all attributes are equal
     */
    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if ((obj instanceof Album)){
            Album alb = (Album) obj;
            isEqual = name.equals(alb.name) && artist.equals(alb.artist) && genre.equals(alb.genre) && numSongs == alb.numSongs;
        }

        return isEqual;
    }

    //Compares two Albums based on number of songs.
    public int compareTo(Album alb){

        return Integer.compare(numSongs, alb.numSongs);
    }

    /*
     * Overrides hashCode() method
     * Should return the same hashCode for two equal Albums
     * Uses algorithm from URL https://www.mkyong.com/java/java-how-to-overrides-equals-and-hashcode/
     */
    @Override
    public int hashCode() {
        int code = 17;
        code = code * 31 + name.hashCode();
        code = code * 31 + artist.hashCode();
        code = code * 31 + genre.hashCode();
        code = code * 31 + numSongs;

        return code;
    }

    // Serialization

    //Returns a comma separated string with the values of all the attributes of the album
    public String getCSVString(){
        StringBuilder csvString = new StringBuilder();
        char spl = ',';

        csvString.append(getName());
        csvString.append(spl);
        csvString.append(getArtist());
        csvString.append(spl);
        csvString.append(getGenre());
        csvString.append(spl);
        csvString.append(getNumSongs());




        return csvString.toString();
    }

    //Writes a comma separated string with the values of all the attributes of the Album to a file.
    public static void serializeToCSV(Album a, String CSVFileName) throws IOException{
        String csv = a.getCSVString();

        OutputStream outS = new FileOutputStream(CSVFileName);
        OutputStreamWriter wr = new OutputStreamWriter(outS, StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(wr);


        //BufferedWriter writer = new BufferedWriter(new FileWriter(CSVFileName));
        writer.write(csv);

        writer.close();

        //System.out.println("Writing to CSV file: " + CSVFileName + " for album: " + a.getName() + " successful");

    }


    /*
     * Takes a file containing the csv string for an Album instance
     * and returns an Album instance with the same attributes of the serialized instance.
     */
    public static Album deserializeToCSV(String CSVFileName) throws IOException{
        Album album = null;
        String line;
        BufferedReader br = null;
        InputStream in = new FileInputStream(CSVFileName);
        InputStreamReader inR = new InputStreamReader(in, StandardCharsets.UTF_8);


            //System.out.println("Try entered");
        br = new BufferedReader(inR);
        line = br.readLine();
            //System.out.println(line);
        if (line != null){
                //System.out.println("If entered");
            String[] memberArray = line.trim().split(",");
            int numOfSongs = Integer.parseInt(memberArray[memberArray.length - 1]);
            album = new AlbumClasses.Album(memberArray[0], memberArray[1], memberArray[2], numOfSongs);

        }


        br.close();


        return album;

    }

    // Binary Serialization and Deserialization

    public static void serializeToBinary(Album a, String fileName) throws IOException{
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream outS = new ObjectOutputStream(file);

        outS.writeObject(a);

        outS.close();
        file.close();


    }

    public static Album deserializeFromBinary(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream inS = new ObjectInputStream(file);

        Album a = (Album)inS.readObject();

        inS.close();
        file.close();

        return a;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        String fileName = "serialize.ser";

        Album a = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        serializeToBinary(a, fileName);
        Album aDes = deserializeFromBinary(fileName);

        System.out.println("a = aDes: " + a.equals(aDes));
    }


}
