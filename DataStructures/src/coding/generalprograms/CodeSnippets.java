package coding.generalprograms;

public class CodeSnippets {

    //1 Errors handling in java
    public static void main(String[] args) {
        try { test(); }
        catch (Exception ex) { System.out.print("exception "); }
        System.out.print("end ");
    }

    static void test() throws Error {
        if (true) throw new AssertionError();
        System.out.print("test ");
    }

    static int test1() {
      try {
          return 1;
      } catch (Exception e) {
         // return 2;
      }
      return 3;
    }

}
