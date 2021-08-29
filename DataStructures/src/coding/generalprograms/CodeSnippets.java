package coding.generalprograms;

import coding.generalprograms.pojo.People;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class CodeSnippets {

    //1 Errors handling in java
    public static void main(String[] args) {

        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();

//        try { test(); }
//        catch (Exception ex) { System.out.print("exception "); }
//        System.out.print("end ");

       Map<People, Boolean> peopleBooleanMap = new HashMap<>();
       People people1 = new People(10,"AAA");
       People people2 = new People(10,"AAA");
       peopleBooleanMap.put(people1, true);
       peopleBooleanMap.put(people2, true);
        //System.out.println(peopleBooleanMap.size());

         //addMethod(10,10);
         //addMethod(10,10);
        System.out.println(String.class.getClassLoader());
        // prints null as string is in bootstrap class path and bootstrap is not written in java,
        // hence its object cannot be retrived
        System.out.println(CodeSnippets.class.getClassLoader()); // present in application class loader.
    }
    static void addMethod(float f, int i) {
        System.out.println(f + " " + i);
    }

    static void addMethod(int f, float i) {
        System.out.println(f + " " + i);
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

    class A {
        public void display() throws IOException{
            System.out.println();
        }
    }
    class B extends A {
        public void display() { //throws Exception {
            System.out.println();
        }
    }

