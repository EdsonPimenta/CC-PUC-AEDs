import java.util.*;

class Jaspion{
    public static Scanner scanner = new Scanner(System.in);
    public static void pares() {
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0;i < T;i++){
            int m,n;
          
            m = scanner.nextInt();
            scanner.nextLine();
            n = scanner.nextInt();
            scanner.nextLine();
            String[]mPares = new String[m*2];
            String letraMusica;
            String []letraMusicaSplit;
            for(int j = 0;j < m * 2;j++ ){
                mPares[j] = scanner.nextLine();
            }
            for(int k = 0; k < n;k++){
                letraMusica = scanner.nextLine();
                letraMusicaSplit = letraMusica.split(" ");

                for(String palavra: letraMusicaSplit){
                    for(int b = 0;b < m * 2 - 1 ;b++){
                        if(palavra.equals(mPares[b])){
                            System.out.println("o " + mPares[b+1]);
                            break;
                        }
                    }

                }
            }
        }
        scanner.close();
    }
}




 public class Main {
    public static void main(String[] args) throws Exception{
        Jaspion.pares();
    }    
}
