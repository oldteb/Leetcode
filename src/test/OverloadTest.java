package test;

import java.util.List;

/* What is the output of the following program? */

public class OverloadTest {


  public boolean equals( OverloadTest other ) {
    System.out.println( "Inside of Test.equals" );
    return false;
  }

  public static void main( String [] args ) {
    Object t1 = new OverloadTest();
    Object t2 = new OverloadTest();
    OverloadTest t3 = new OverloadTest();
    Object o1 = new Object();
    List<Integer> list;

    int count = 0;
    System.out.println( count++ );// prints 0
    t1.equals( t2 ) ;
    System.out.println( count++ );// prints 1
    t1.equals( t3 );
    System.out.println( count++ );// prints 2
    t3.equals( o1 );
    System.out.println( count++ );// prints 3
    t3.equals(t3);
    System.out.println( count++ );// prints 4
    t3.equals(t2);
  }
}
