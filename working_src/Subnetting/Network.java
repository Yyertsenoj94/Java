package Subnetting;
import Library.*;

import java.util.ArrayList;

public class Network {
    int[] binaryIP;
    int[] binaryMask;
    ArrayList<Subnet> subnets = new ArrayList<>();

    public Network(String number, String subnet){
       this.binaryIP = setArrayBinary(number);//stores the IP address in binary form
       this.binaryMask = setArrayBinary(subnet);//stores the Subnet mask in binary form
        checkValidity();
        //fix the binary ip to be the first subnet ip.
        for(int i = networkLength(); i < binaryIP.length; i++){
            binaryIP[i] = 0;
        }
    }

    private int[] setArrayBinary(String ipAddress){//sets binary ip array from the given string array.
        int octetCount = 0; //used for looping through each octet's number
        int[] tempIP; //stores the digits of each octet in the ip address
        int[] binaryIP = new int[32]; //new binary IP that will be created and returned.
        String tempString = ""; //stores each octet as a string
        for(int i = 0; i < ipAddress.length(); i++){

            if(ipAddress.charAt(i) != '.'){//stores the character in the tempString if not a period (delimiter in IP)
                tempString += ipAddress.charAt(i);
            }else if(ipAddress.charAt(i) == '.'){ //if reached a delimiter for the octet (.), then add the temp String to the binary array.
                int tempInt = Integer.parseInt(tempString); //convert string to integer
                tempIP = functions.decimalToBinary(tempInt); //convert integer into binary using function decimaltoBinary
                tempString = ""; //reset the tempString
                int tempCounter = 0;//reset the tempCounter to loop through the tempIp
                for(int j = octetCount; j < octetCount + 8; j++){//for each index in the octet, store the tempIP index into the binaryIP.
                    binaryIP[j] = tempIP[tempCounter];
                    tempCounter++;
                }
                octetCount += 8; //increase the octet for the next starting point to add to binaryIP.
            }

            if((i + 1) == ipAddress.length()){ //if reached the end of the string IP, then convert again to binary, and add last digits to binaryIP
                int tempInt = Integer.parseInt(tempString);
                tempIP = functions.decimalToBinary(tempInt);
                int tempCounter = 0;
                for(int j = octetCount; j < octetCount + 8; j++){
                    binaryIP[j] = tempIP[tempCounter];
                    tempCounter++;
                }
            }
        }
        return binaryIP; //returns final array of binary digits.
    }

    public void divideByHosts(int number) {
        if(getMaxHosts() < number){
            System.out.println("Host number exceeds limit that network can sustain. Max is " + getMaxHosts());
        }
        int subnetNumber = 1;
        while(subnetNumber * 254 < number){
            subnetNumber++;
        }
        if(subnetNumber == 1){
            subnetNumber = 0;
        }
        divideBySubnet(subnetNumber, number);
    }

    public void divideBySubnet(int subnetNumber, int hostNumber){
        if(hostNumber == 0){
            hostNumber = 254;
        }
        int subnetBits = getSubnetBits(subnetNumber);
        int subnetsNeeded = (int) Math.pow(2, subnetBits);
        if(getMaxSubnets() < subnetsNeeded){
            System.out.println("Subnet number exceeds limit that network can accommodate. Max is: " + getMaxHosts());
        }else{

            int i = 0;
            subnets.add(new Subnet(binaryIP, networkLength() + subnetBits,1, hostNumber)); //add this subnet to the subnet array.
            while(i < subnetNumber - 1){
                int current = (networkLength() + subnetBits)-1; // start where the network ends, plus however many subnet digits are needed.
                if (binaryIP[current] + 1 != 1) {
                    while (binaryIP[current] + 1 == 2) { // addition of binary 1 from range of subnet digit needed to subnet digits beginning.
                        binaryIP[current] = 0; //set to zero, carry the one.
                        if(current == networkLength()){
                            break;
                        }
                        current--; //move current back.
                    }
                }
                binaryIP[current] = 1; // doesn't carry anymore, add the one to this place.
                subnets.add(new Subnet(binaryIP, networkLength() + subnetBits, (i+2/* for ID ONLY*/), (hostNumber))); //add this subnet to the subnet array.
                i++;
            }
        }
    }

    public int getSubnetBits(int number){
        int power = 0;
        while((Math.pow(2, power)) < number){
            power++;
        }
        return power;
    }

    private int getMaxSubnets(){
        return (int) Math.pow(2, binaryIP.length-networkLength());
    }

    private int getMaxHosts(){
        if(networkLength() >= 24){
            return (int) (Math.pow(2, binaryIP.length-networkLength()) - 2); // if mask goes into 4th octet, just return formula
        }else{ //if not, count subnet bits, and subnets that could be created, and multiply that by 254.
            int subnetBits = binaryIP.length - networkLength()-8;
            int subnets = (int) Math.pow(2, subnetBits);
            return subnets * 254;
        }
    }

    //returns the length of the network portion(CIDR notation)
    private int networkLength(){
        int count = 0;
        while(binaryMask[count] != 0){
            count++;
        }
        return count;
    }

    public void printIP(){
        printBinaryToString(this.binaryIP);
    }
    public void printMask(){
        printBinaryToString(this.binaryMask);
    }

    private void printBinaryToString(int[] binary){
        int number = 1;
        for(int s: binary){
            System.out.print(s);
            if(number % 8 == 0 && number != binary.length){
                System.out.print(".");
            }
            number++;
        }
        System.out.println();
    }

    private void checkValidity(){
        //compares the non-255 subnet mask digits against the ip provided
        // if they don't match the IP, the program will error out.
        int count = networkLength();
        StringBuilder tempSub = new StringBuilder();
        StringBuilder tempIP = new StringBuilder();
        while(count % 8 != 0){
            tempIP.append(this.binaryIP[count-1]);
            tempSub.append(this.binaryMask[count-1]);
            count--;
        }
        if(!(tempIP.toString().equals(tempSub.toString()))){
                throw new java.lang.RuntimeException("ERROR: Inconsistent Subnet mask and IP address provided");
        }
    }
}
