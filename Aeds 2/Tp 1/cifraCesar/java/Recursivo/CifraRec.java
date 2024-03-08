import java.util.*;


class CifraRec{
   
   public static String alteraString(int count,int tam,String Cifra,String aux){
      
         if(count>tam){
            return aux;
         }    
         if (Cifra.charAt(count) != 65533) {
            aux  +=  (char)(Cifra.charAt(count)  + 3);   
         } else  {
            aux += Cifra.charAt(count);
         }
      
         return alteraString(count+1,tam,Cifra,aux);
   }
   
   
   public static Scanner scanner = new Scanner(System.in);
   
   public static void main(String[] args) {
   
      String Cifra = scanner.nextLine();
      String aux = "";

   while(!Cifra.equals("FIM")){

      int tam = Cifra.length();
      System.out.println(alteraString(0,tam - 1,Cifra,aux));
      Cifra = scanner.nextLine();
      
   }

   }

} 