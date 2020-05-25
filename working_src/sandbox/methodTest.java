package sandbox;

public class methodTest {
    public static void main(String[] args) {
        String text = "I want some water. I had some water earlier, but now he has some water.";
        System.out.println(findText(text, "some water"));
    }

    public static int findText(String text, String searchText){
        int place = 0;
        int searchCount = 0;
        int searchPlace = 0;
        String tempString = "";
        while(place < text.length()){

            if(searchPlace != searchText.length() && text.charAt(place) == searchText.charAt(searchPlace)){
                tempString += text.charAt(place);
                searchPlace ++;

            }else{
                if(tempString.equals(searchText)){
                    searchPlace = 0;
                    searchCount++;
                    tempString = "";
                }
            }

            place++;
        }

        return searchCount;
    }
}
