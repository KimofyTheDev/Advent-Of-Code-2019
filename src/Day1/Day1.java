import java.util.*;
import java.io.*;

class Day1 {
  public static void main(String[] args) throws IOException{
    Scanner scanner = new Scanner(new File("input/day1.txt"));
    
    int [] data = new int [100];
    int[] result = new int [100];
    int i = 0;

    while(scanner.hasNextInt()){
      data[i++] = scanner.nextInt();
    }
    int sum=0;
    for (int j=0;j<100;j++){
      result[j] = (data[j]/3)-2;
      sum +=result[j];
    }
    System.out.println("Part 1: " + sum);
  }
}