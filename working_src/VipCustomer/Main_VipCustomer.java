package VipCustomer;
public class Main_VipCustomer {


    public static void main(String[] args){

        System.out.println("Hello There");

        VipCustomer CustomerDefault = new VipCustomer();


        //this is the customer for which only two values should be passed.
        VipCustomer CustomerTwoValues = new VipCustomer("Joe", "String");


        VipCustomer CustomerCustom = new VipCustomer("Trey", "harvjones1994@gmail.com", 100000);


        System.out.println(CustomerDefault.getCreditLimit());
        System.out.println(CustomerDefault.getEmail());
        System.out.println(CustomerDefault.getName());


        System.out.println(CustomerCustom.getCreditLimit());
        System.out.println(CustomerCustom.getEmail());
        System.out.println(CustomerCustom.getName());

        System.out.println(CustomerTwoValues.getCreditLimit());
        System.out.println(CustomerTwoValues.getEmail());
        System.out.println(CustomerTwoValues.getName());

    }

}
