package Subnetting;
import java.util.ArrayList;

public class Subnet {
    int subnetNumber;
    ArrayList<int[]> ipRanges = new ArrayList<>();
    int[] networkIP;
    int[] broadcast;
    int[] network;
    int length;
    int hostDigits;
    int hostNumber;

    public Subnet(int[] array, int length, int number, int hosts){
        networkIP = new int[array.length];
        for(int i = 0; i < array.length-1; i++){
            networkIP[i] = array[i];
        }
        this.length = length;
        this.hostDigits = networkIP.length - length;
        this.hostNumber = hosts;
        this.subnetNumber = number;
        populateIP();
    }

    private void populateIP(){
        int counter = 0;
        int[] ip = new int[32];
        //create and populate the IP range with all values that are part of the network portion (subnet + network)
        for(int i = 0; i <= networkIP.length-1; i++){
            ip[i] = networkIP[i];
        }
        network = createCopy(ip);

        do {
            int current = networkIP.length - 1;
            if(ip[current] + 1 != 1){
                while(ip[current] + 1 == 2){
                    ip[current] = 0;
                    if(current == length){
                        break;
                    }
                    current--;
                }
            }
            ip[current] = 1;


            if(counter + 1 == hostNumber+2){
                broadcast = createCopy(ip); //add for broadcast address;
            }else{
                ipRanges.add(createCopy(ip));
            }
            counter ++;
        }while(counter < hostNumber+2);
    }

    private int[] createCopy(int[] array){
        int[] newArray = new int[array.length];
        int count = 0;
        for(int s: array){
            newArray[count] = array[count];
            count++;
        }
        return newArray;
    }


    public void printSubnet(){
            if(hostNumber > 256){
                System.out.println("Subnet Number: " + subnetNumber);
                System.out.println("Network Address: --> " + convertAddress(networkIP));
            }else{
                System.out.println("Subnet Number: " + subnetNumber);
                System.out.println("Network Address: --> " + convertAddress(networkIP));
                int count = 0;
                for(int[] s: ipRanges){
                    if(count == ipRanges.size()-1){
                        System.out.println("Broadcast Address: --> " + convertAddress(s));
                    }else{
                        System.out.println("LocalHost: " + (count+1) + " --> " + convertAddress(s));
                    }
                    count++;
                }
            }

        System.out.println("===================================");
    }

    private StringBuilder convertAddress(int [] ipArray){
        StringBuilder ip = new StringBuilder();

        for(int i = 0; i < ipArray.length; i += 8){
            int tempCounter = 0;
            int[] tempArray = new int[8];
            for(int j = i; j < i + 8; j++){
                tempArray[tempCounter] = ipArray[j];
                tempCounter++;
            }
            int sum = Library.functions.binaryToDecimal(tempArray);
            ip.append(sum);
            if(i+8 != 32){
                ip.append('.');
            }
        }
        return ip;
    }
}
