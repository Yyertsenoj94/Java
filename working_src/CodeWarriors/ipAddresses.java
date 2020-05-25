package CodeWarriors;

public class ipAddresses {

    public static void main(String[] args){

        long ip = 2154959208L;
        String stringIP = "";
        stringIP = longToIP(ip);
        System.out.println(stringIP);

    }

    public static String longToIP(long ip) {
        String ipv4 = "";
        if(ip == 0){
            return "0.0.0.0";
        }
        String[] ipArray = new String[4];
        int tempSum = 0;
        int count = 0;
        int arrayCount = 0;
        do {
            if(ip % 2 == 1){
                tempSum += Math.pow(2, count);
            }
            count++;
            if(count == 8){
                count = 0;
               ipArray[arrayCount] = Integer.toString(tempSum);
               tempSum = 0;
               arrayCount++;
            }
            ip /= 2;
        }while(ip / 2 != 0);
        tempSum += Math.pow(2, count);
        ipArray[arrayCount] = Integer.toString(tempSum);
        for(int i = ipArray.length-1; i >= 0; i--){
            ipv4 += ipArray[i];
            if(i != 0){
                ipv4+= ".";
            }
        }
        System.out.println(ipv4);


        return ipv4;

    }


}
