import java.util.*;
import java.io.*;

class Selection {
  public static void main(String[] args) throws IOException{
    Scanner scanner = new Scanner(System.in);

    System.out.println("Which day would you like to run? Enter only the number.");
    int input = scanner.nextInt();

    switch(input) {
      case 1:
        Process p = Runtime.getRuntime().exec("java src/Day1.java");

        InputStream is = p.getInputStream();
        int i = 0;
        StringBuffer sb = new StringBuffer();
        while ( (i = is.read()) != -1)
          sb.append((char)i);

        System.out.println(sb.toString());
      case 2:
        Process p1 = Runtime.getRuntime().exec("java src/Day2.java");

        InputStream is1 = p1.getInputStream();
        int i1 = 0;
        StringBuffer sb1 = new StringBuffer();
        while ( (i = is1.read()) != -1)
          sb1.append((char)i);

        System.out.println(sb1.toString());
      default:

    }
  }
}