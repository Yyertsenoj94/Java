package Subnetting;

public class Main {
    public static void main(String[] args) {
        Network ip = new Network("192.168.0.0", "255.255.255.0");
        ip.printIP();
        ip.printMask();
        ip.divideBySubnet(16, 10);
        for(Subnet s: ip.subnets){
            s.printSubnet();
        }
    }
}
