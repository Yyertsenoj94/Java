package sandbox;
import java.util.*;
public class Sandbox2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input range of numers");
        int num = scanner.nextInt();
        System.out.println("Please input next integer");
        int temp = scanner.nextInt();
        int next;
        boolean asc = false;
        boolean desc = false;

        for(int i = 1; i < num; i++){
            System.out.println("Please input next integer");
            next = scanner.nextInt();
            if(next < temp){
                desc = true;
            }else if(next > temp){
                asc = true;
            }
        }
        if(asc && desc){
            System.out.println("Not Sorted");
        }
        if(asc && (!desc)){
            System.out.println("Sorted in ascending order");
        }
        if(desc && (!asc)){
            System.out.println("Sorted in descending order");
        }

    }
}
