import java.util.*;


class Cifra{
   
   public static String alteraString(String Cifra){
      
      String cifra = "";
      int tam = Cifra.length();
      
      
      for(int i = 0;i<tam;i++){
         
         // if(Cifra.charAt(i)!= 189 && Cifra.charAt(i)!= 191 && Cifra.charAt(i)!= 239)
         // else
         if (Cifra.charAt(i) != 65533) {
            cifra  +=  (char)(Cifra.charAt(i)  + 3);   
         } else  {
            cifra += Cifra.charAt(i);
         }
         
      }
      return cifra;
   }
   
   
   
   public static void main(String[] args) {
   
      MyIO.setCharset("UTF-8");
      String Cifra = MyIO.readLine();

   while(!Cifra.equals("FIM")){

      
      System.out.println(alteraString(Cifra));
      Cifra = MyIO.readLine();
      
      
   }

   }

} 