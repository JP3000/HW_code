import java.util.Scanner;
public class JavaA1{
    public static void main(String[] args){
        int x, y;
        System.out.println("input x and y: ");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();

        x = x ^ y; 
        y = x ^ y;  
        x = x ^ y;

        System.out.println("After exchange x = " + x + " y =" + y);
    }
}