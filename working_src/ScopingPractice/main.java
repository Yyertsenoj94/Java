package ScopingPractice;

public class main {


    public static void main(String[] args) {
        ScopeCheck scopeInstance = new ScopeCheck();

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();

        innerClass.timeTwo();

    }




}
