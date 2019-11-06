package album;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class Album implements Serializable, Comparable<Album>{

    private String name;
    private String artist;
    private String genre;
    private int numSongs;

    public Album(){
        this("", "", "", 0);
    }

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
        boolean isEqual = true;
        if ((obj instanceof Album)){
            Album alb = (Album) obj;
            isEqual = isEqual && (name.compareTo(alb.getName()) == 0);
            isEqual = isEqual && (artist.compareTo(alb.getArtist()) == 0);
            isEqual = isEqual && (genre.compareTo(alb.getGenre()) == 0);
            isEqual = isEqual && (numSongs == alb.numSongs);
        }
        else { isEqual = false; }


        return isEqual;
    }

    //Compares two Albums based on number of songs.
    @Override
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
    String getCSVString(){
        StringBuilder csvString = new StringBuilder();
        char spl = ',';

        csvString.append(this.name);
        csvString.append(spl);
        csvString.append(this.artist);
        csvString.append(spl);
        csvString.append(this.genre);
        csvString.append(spl);
        csvString.append(this.numSongs);




        return csvString.toString();
    }

    //Writes a comma separated string with the values of all the attributes of the Album to a file.
    public static void serializeToCSV(Album album, String CSVFileName) throws IOException{
        String csv = album.getCSVString();

        OutputStream outS = new FileOutputStream(CSVFileName);
        OutputStreamWriter outSWRiter = new OutputStreamWriter(outS, StandardCharsets.UTF_8);
        BufferedWriter bWriter = new BufferedWriter(outSWRiter);


        bWriter.write(csv);

        bWriter.close();
    }


    /*
     * Takes a file containing the csv string for an Album instance
     * and returns an Album instance with the same attributes of the serialized instance.
     */
    public static Album deserializeFromCSV(String CSVFileName) throws IOException{
        Album album = null;
        String line;
        BufferedReader bReader = null;
        InputStream inStream = new FileInputStream(CSVFileName);
        InputStreamReader inReader = new InputStreamReader(inStream, StandardCharsets.UTF_8);



        bReader = new BufferedReader(inReader);
        line = bReader.readLine();
        if (line != null){
            String[] memberArray = line.trim().split(",");
            int numOfSongs = Integer.parseInt(memberArray[memberArray.length - 1]);
            album = new album.Album(memberArray[0], memberArray[1], memberArray[2], numOfSongs);

        }


        bReader.close();


        return album;

    }

    // Binary Serialization and Deserialization

    public static void serializeToBinary(Album album, String fileName) throws IOException{
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream outS = new ObjectOutputStream(file);

        outS.writeObject(album);

        outS.close();
        file.close();


    }

    public static Album deserializeFromBinary(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream inS = new ObjectInputStream(file);

        Album album = (Album)inS.readObject();

        inS.close();
        file.close();

        return album;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        String fileName = "serialize.ser";

        Album a = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        serializeToBinary(a, fileName);
        Album aDes = deserializeFromBinary(fileName);

        System.out.println("a = aDes: " + a.equals(aDes));
    }


}
