import java.util.Map;

public class Animal {
    private String title;
    private boolean isAvailable;
    private boolean isSold;
    private Map<String, String> photosMap;


    @Override
    public String toString(){
        String output;
        output = "Animal{ " + "title: " + title + " isAvailable = " + isAvailable + " isSold = " + " photosMap = " + photosMap + " }";
        return output;
    }

}
