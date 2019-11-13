package album;


import java.io.IOException;
import java.util.ArrayList;

public class TestDriver {




    public static void main(String[] args) throws IOException{
        System.out.println("Test 1: Creates, serializes, and deserializes two Album instances one at a time.");
        System.out.println();

        Album alb1 = new Album("Good Kid Maad City", "Kendrick Lamar", "Rap", 13);
        Album alb2 = new Album("Shmilco", "Wilco", "Indie", 12);

        String file1 = "alb1.csv";
        String file2 = "alb2.csv";

        System.out.println("Serialize alb1 to file alb1.csv");
        Album.serializeToCSV(alb1, file1);

        System.out.println("Deserialize alb1 from file into Album alb1a");
        Album alb1a = Album.deserializeFromCSV(file1);

        if (alb1.equals(alb1a)){ System.out.println("alb1 equals alb1a, deserialization successful");}
        else {System.out.println("alb1 does not equal alb1a, deserialization unsuccessful");}

        if (alb1.hashCode() == alb1a.hashCode()){
            System.out.println("alb1 hashcode equals alb1a hashcode, hashCode() successful");}
        else {System.out.println("alb1 hashcode does not equal alb1a, hashCode() unsuccessful");}

        if (alb1.compareTo(alb1a) == 0){System.out.println("compareTo() = 0, successful");}
        else {System.out.println("compareTo() != 0, unsuccessful");}
        System.out.println();

        System.out.println("Serialize alb2 to file alb2.csv and deserialize from file into Album alb2a");
        Album.serializeToCSV(alb2, file2);
        Album alb2a = Album.deserializeFromCSV(file2);

        if (alb2.equals(alb2a)){ System.out.println("alb2 equals alb2a, deserialization successful");}
        else {System.out.println("alb2 does not equal alb2a, deserialization unsuccessful");}

        if (alb2.hashCode() == alb2a.hashCode()){
            System.out.println("alb2 hashcode equals alb2a hashcode, hashCode() successful");}
        else {System.out.println("alb2 hashcode does not equal alb2a, hashCode() unsuccessful");}

        if (alb2.compareTo(alb2a) == 0){System.out.println("compareTo() = 0, successful");}
        else {System.out.println("compareTo() != 0, unsuccessful");}
        System.out.println();

        System.out.println("Compare the two deserialized albums");
        if (alb1a.equals(alb2a)){ System.out.println("alb1a equals alb2a, unsuccessful");}
        else {System.out.println("alb1a does not equal alb2a, successful");}

        if (alb1a.hashCode() == alb2a.hashCode()){
            System.out.println("alb1a hashcode equals alb2a hashcode, must refer to equals()");}
        else {System.out.println("alb1a hashcode does not equal alb2a, hashCode() successful");}

        if (alb1a.compareTo(alb2a) > 0){System.out.println("alb1a.compareTo(alb2a) > 0, successful");}
        else {System.out.println("alb1a.compareTo(alb2a) <= 0, unsuccessful");}
        System.out.println();

        System.out.println("Test2: Serialize and deserialize Albums to same csv file, at same time, to file albums.csv");
        System.out.println();
        System.out.println("Create Album[] albums and store albums here");
        Album[] albums = {alb1, alb2};
        System.out.println("Serialize, then deserialize into ArrayList w/ alb1 going into alb1b and alb2 going into alb2b");
        CSVTool.serializeToCSV(albums, "albums.csv");
        ArrayList<Album> desAlbs = CSVTool.deserializeFromCSV("albums.csv");
        Album alb1b = desAlbs.get(0);
        Album alb2b = desAlbs.get(1);

        if (alb1.equals(alb1b)){ System.out.println("alb1 equals alb1b, deserialization successful");}
        else {System.out.println("alb1 does not equal alb1b, deserialization unsuccessful");}

        if (alb1.hashCode() == alb1b.hashCode()){
            System.out.println("alb1 hashcode equals alb1b hashcode, hashCode() successful");}
        else {System.out.println("alb1 hashcode does not equal alb1b, hashCode() unsuccessful");}

        if (alb1.compareTo(alb1b) == 0){System.out.println("compareTo() = 0, successful");}
        else {System.out.println("compareTo() != 0, unsuccessful");}
        System.out.println();

        if (alb2.equals(alb2b)){ System.out.println("alb2 equals alb2b, deserialization successful");}
        else {System.out.println("alb2 does not equal alb2b, deserialization unsuccessful");}

        if (alb2.hashCode() == alb2b.hashCode()){
            System.out.println("alb2 hashcode equals alb2b hashcode, hashCode() successful");}
        else {System.out.println("alb2 hashcode does not equal alb2b, hashCode() unsuccessful");}

        if (alb2.compareTo(alb2b) == 0){System.out.println("compareTo() = 0, successful");}
        else {System.out.println("compareTo() != 0, unsuccessful");}
        System.out.println();

        System.out.println("Compare the two deserialized albums");
        if (alb1b.equals(alb2b)){ System.out.println("alb1b equals alb2b, unsuccessful");}
        else {System.out.println("alb1b does not equal alb2b, successful");}

        if (alb1b.hashCode() == alb2b.hashCode()){
            System.out.println("alb1b hashcode equals alb2b hashcode, must refer to equals()");}
        else {System.out.println("alb1b hashcode does not equal alb2b, hashCode() successful");}

        if (alb1b.compareTo(alb2b) > 0){System.out.println("alb1b.compareTo(alb2b) > 0, successful");}
        else {System.out.println("alb1b.compareTo(alb2b) <= 0, unsuccessful");}
        System.out.println();





    }
}
