package CodeWarriors;


public class facebookLikes {
    public static void main(String[] args) {
        System.out.println(whoLikesIt());

    }
    public static String whoLikesIt(String... names) {

        String[] userNames = names;
        int size = userNames.length;

        if (size == 0) {
            return "no one likes this";
        }else if(size == 1){
            return userNames[0] + " likes this";
        }else if(size == 2){
            return userNames[0] + " and " + userNames[2] + " like this";
        }else if(size == 3){
            int nameCount = 0;
            String returnString = "";
            for(String str: userNames){
                returnString += str;
                if(nameCount == 0){
                    returnString += ", ";
                }else if(nameCount == 1){
                    returnString += " and ";
                }
                nameCount++;
            }
            returnString += " like this";
            return returnString;

        } else{
            int nameCount = 0;
            String returnString = "";
            int remainder = userNames.length - 2;
            for(String str: userNames){
                if(nameCount == 0){
                    returnString += str;
                    returnString += ", ";
                }else if(nameCount == 1){
                    returnString += str;
                    returnString += " and ";
                }else if(nameCount == 3){
                    returnString += remainder + " others like this";
                }
                nameCount++;
            }
            return returnString;
        }

    }
}
