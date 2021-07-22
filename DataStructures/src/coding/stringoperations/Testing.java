package coding.stringoperations;

import java.util.Scanner;


public class Testing {


    public static void main(String[] args)  {
        
    }




    private static void logicCheck() {
        for (int i =0; i <3 ; i++)
            for (int j = 1; j < 4; j++)
                for (int k = 2; k < 5; k++)
                    if(i==j&& j==k)
                        System.out.println(i);
    }


    private static void scannerTestPgm() {
        String in ="10 a 100 . 1000 10000";
        Scanner scanner = new Scanner(in);
        int accum = 0;
        for (int i = 0; i < 5; i++) {
            accum += scanner.nextInt();
        }
        System.out.println(accum);
    }
}

class Base{

    public String getX() {
        return "2";
    }

    public void method(int i) {
        System.out.println("Value is : " + i);
    }
}

abstract class MyBase {
    abstract void amethod();
    static  int i;
}

class Bean {
    interface inter {
        void beanInterFace();
    }

    class Beanl implements inter {
        public void beanInterFace() {

        }
    }
}
