package ScopingPractice;

public class ScopeCheck {

    private int varOne = 1;



    public int getVarOne(){
        return varOne;
    }


    public class InnerClass{
        private int varTwo = 2;


        public void timeTwo(){

            while(this.varTwo < 10){
                System.out.println(varOne * varTwo);
                varTwo += 1;
                varOne +=1;
            }



            System.out.println(ScopeCheck.this.getVarOne());
        }





    }


}
