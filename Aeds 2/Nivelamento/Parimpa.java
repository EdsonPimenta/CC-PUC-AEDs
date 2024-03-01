import java.util.Scanner;

class Parimpa{

    public static void main(String[] args){
         
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while(n!=0){
        if(n%2==0)
            System.out.println("P\n");
        else
            System.out.println("I\n");
        
        n = scanner.nextInt();
        }

scanner.close();
    }
}