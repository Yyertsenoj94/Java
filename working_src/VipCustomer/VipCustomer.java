package VipCustomer;
public class VipCustomer {

    private int creditLimit = 0;

    private String name = "";

    private String email = "";



    public VipCustomer(String name, String email, int creditLimit){

        this.creditLimit = creditLimit;
        this.email = email;
        this.name = name;


    }

    public VipCustomer(){

        this("John", "john123@yahoo.com", 10000);


    }

    //need work on this portion of the project.
    public VipCustomer(String name, String email){

        this(name, email, 0);

    }


    public int getCreditLimit() {
        return creditLimit;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


}
