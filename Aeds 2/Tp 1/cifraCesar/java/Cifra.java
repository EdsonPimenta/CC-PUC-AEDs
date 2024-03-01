import java.util.*;


class Cifra{
   
   public static String alteraString(String Cifra){
      
      String cifra = "";
      int tam = Cifra.length();
      
      for(int i = 0;i<tam;i++){
         cifra  +=  (char)(Cifra.charAt(i)  + 3);   
      }
      return cifra;
   }
   
   
   
   public static void main(String[] args) {
   Scanner read =  new Scanner (System.in);
   String Cifra = read.nextLine();
   System.out.println(" " + alteraString(Cifra));
   read.close();
   }

} 