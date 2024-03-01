import java.util.Scanner;

class Opalindromo{

    public static void main(String[] ags){
        boolean ehPalindromo = true;
        int tamanho;
        int j;
        String str;
        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();
        
        while(!str.equals("FIM")){
            ehPalindromo = true;
            tamanho = str.length();
            j = tamanho-1;
        
            for(int i = 0;i<tamanho/2;i++,j--)
            {
                if(str.charAt(i)!=str.charAt(j))
                    ehPalindromo = false;
            }

            if(ehPalindromo == true)
            System.out.println("SIM");

            else
            System.out.println("NAO");

            str = sc.nextLine();
            
        }     
        sc.close();
    }
}
