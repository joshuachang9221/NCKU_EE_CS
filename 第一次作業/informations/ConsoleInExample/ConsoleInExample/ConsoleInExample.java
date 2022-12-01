public class ConsoleInExample{

    public static void main(String args[]){

        System.out.print("Please input integer x: ");
        int x = ConsoleIn.readLineInt();
        System.out.print("Please input integer y: ");
        int y = ConsoleIn.readLineInt();

        System.out.println(" x = " + x + ", y = " + y);   
        System.out.println(" x + y  * 2 = " + (x+y*2) );
        System.out.println("(x + y) * 2 = " + ((x+y)*2) );
     
        double a = x, b = y;
        System.out.println("x / y = " + (x / y)); //int
        System.out.println("a / b = " + (a / b)); //double
        System.out.println("x / y = " + ((double) x / y) ); //double
    }
}
