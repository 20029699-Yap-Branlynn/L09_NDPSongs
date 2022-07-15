package sg.edu.rp.c346.id20029699.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private 	int id;
    private 	String title;
    private 	String singer;
    private 	int year;
    private 	int stars;

    public Song(int id, String title, String singer, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {  return id;  }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        String showStar = "";
        if (stars == 1){
            showStar += "*";
        } else if (stars == 2){
            showStar += "**";
        } else if (stars == 3){
            showStar += "***";
        }else if (stars == 4){
            showStar += "****";
        }else if (stars == 5){
            showStar += "*****";
        }
        String result = String.format("%s \n%s - %d \n%s", title, singer,year,showStar);
        return  result;
    }
}
