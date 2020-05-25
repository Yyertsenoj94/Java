package Compare;
public class Compare{

    public static void main(String[] args) {

        String name1 = "H!";

        String name2 = "Hello2";

        Cat cat = new Cat("Garfield");

        System.out.println(comparison(name1, name2));

        System.out.println(cat.getClass().getDeclaredFields());
    }

    public static int comparison(String one, String two){
        int length;
        if(one.length() > two.length()){
            length = two.length();
        }else{
            length = one.length();
        }

        for(int i = 0; i < length; i++){

            if(one.charAt(i) == two.charAt(i)){
                continue;
            }else if(one.charAt(i) < two.charAt(i)){
                return 1;
            }
            else{
                return 2;
            }

        }
        if(one.length() < two.length()){
            return 1;
        }else{
            return 0;
        }
    }

}


class Cat{
    String name;

    public Cat(String name){
        this.name = name;
    }

}