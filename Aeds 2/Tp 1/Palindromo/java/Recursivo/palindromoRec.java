import java.util.*;

 class palindromoRec {
    public static Scanner scanner = new Scanner(System.in);
    
    public static Boolean isPalindromo(String word,int tam,int i){
        Boolean ehpalindromo = true;

        if(i>tam){
            return ehpalindromo;
        }
       else if(word.charAt(i) != word.charAt(tam)){
            return ehpalindromo = false;
        }
        else
            return isPalindromo(word, tam-1, i+1);
        
            

    }

    public static void main(String[] args){
        String word = scanner.nextLine();
        int tam = word.length();
        int i = 0;
        while(!word.equals("FIM")){
            if(isPalindromo(word,tam-1,i)==true){
                System.out.println("SIM");
            }
            else
            System.out.println("NAO");
           
            word =  scanner.nextLine();
            tam = word.length();
            i = 0;

        }
    }
}
