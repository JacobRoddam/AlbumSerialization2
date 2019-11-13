package album;

import java.io.Serializable;

public class AlbumList implements Serializable {
    private Album[] albumList;
    private int length;

    public AlbumList(){
        length = 0;
        albumList = new Album[length];
    }

    public AlbumList(Album[] albArray){
        length = albArray.length;
        albumList = new Album[length];
        for (int i = 0; i < length; i++){
            albumList[i] = albArray[i];
        }
    }

    public Album[] getAlbumList(){
        return albumList;
    }

    public Album getAlbum(int i) {return getAlbumList()[i];}


}
