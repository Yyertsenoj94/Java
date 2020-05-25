package CodeWarriors;

import java.util.*;

public class compareArrays {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 5, 7, 9, 9};
        int[] arr2 = {4, 4, 9, 25, 49, 81};
        System.out.println(compare(arr, arr2));
    }

    public static boolean compare(int[] a, int[] b){
        List<Integer> a1 = new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            a1.add(a[i]);
        }
        for(int i = 0; i < b.length; i++){
            b1.add(b[i]);
        }
        ListIterator<Integer> iterA = a1.listIterator();

        while(iterA.hasNext()){
            int tempA = iterA.next();
            ListIterator<Integer> iterB = b1.listIterator();
            while(iterB.hasNext()){
                int tempB = iterB.next();
                if(tempA*tempA == tempB){
                    iterA.remove();
                    iterB.remove();
                    break;
                }
            }
        }
        if(a1.size() == 0 && b1.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}
