import java.util.*;


public class alteracaoAl {
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static String alteraString(String frase,char primeiraLetra,char segundaLetra){
        
        String fraseTemp = "";
        int tam = frase.length();
        
        for(int i = 0;i<tam;i++){
            if(frase.charAt(i) == primeiraLetra)
                fraseTemp += segundaLetra;
            else
                fraseTemp += frase.charAt(i);
        }


        return fraseTemp;
    }

    public static void main(String[] args){
        char primeiraLetra = 'a';
        char segundaLetra = 'b';
        String frase;
        
        Random gerador = new Random();
        gerador.setSeed(4);
        
        primeiraLetra = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        segundaLetra = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
        frase = scanner.nextLine();

        while(!frase.equals("FIM")){

            System.out.println(alteraString(frase, primeiraLetra, segundaLetra));

            primeiraLetra = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            segundaLetra = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            frase = scanner.nextLine();
        }
         
    }
    
}
