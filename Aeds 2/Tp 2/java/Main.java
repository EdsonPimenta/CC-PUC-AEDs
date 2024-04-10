// import java.io.IOException;
// import java.io.RandomAccessFile;
// import java.text.ParseException;
// import java.util.ArrayList;
// import java.util.*;
// public class Main {
//         public static Scanner scanner = new Scanner(System.in);

//         public static ArrayList<Personagem> lerArquivo() throws ParseException{
//             ArrayList<Personagem> array = new ArrayList<Personagem>();
//             //tratamento de excessao
//             try{ 
//                 RandomAccessFile arq = new RandomAccessFile("caracteres.csv", "r");
//                 arq.seek(0);
//                 arq.readLine(); 
//                 for(long i = 0; i < arq.length(); i = arq.getFilePointer()){
//                     String WordPersonagem = "";
//                     String aux2 = "";
//                     String aux[];
//                     WordPersonagem += arq.readLine(); 
//                     for(int j = 0; j < WordPersonagem.length();j++){
//                         if(WordPersonagem.charAt(j)!='[' && WordPersonagem.charAt(j)!= ']'){
//                             aux2 += WordPersonagem.charAt(j);    
//                         }
//                     }
//                     aux = aux2.split(";", 18);//split
//                     Personagem personagem = new Personagem(aux);
//                     array.add(personagem);
                    
//                 }
//                 arq.close();//fechando arquivo
                
//             }catch(IOException e){
//                 e.printStackTrace();
//             }
//             return array;
//         }
//         /*
//          * for(Personagem p : personagem  ){
//          *      if(p.id.equals(myId)){
//          *          p .printPersonagem
//          *          break;
//          *      }
//          *}
//          *  for(int i = 0; i < personagem.size(); i++){
//          *      if(personagem.get(i).getId().equals(myId)){
//          *              personagem.get(i).printPersonagem();
//          *              
//          */
        
        
//         public static void printaArray(ArrayList<Personagem> personagem){

//             for(int i = 0;i < personagem.size();i++){
                
//                 personagem.get(i).printPersonagem();
                
//             }

//         }
//         public static void buscaPorId(String myId,ArrayList<Personagem> personagem){
//             for(Personagem p : personagem  ){
//                 if(p.getId().equals(myId)){
//                     p .printPersonagem();
//                     break;
//                 }
//             }
//         }
        
        
//         public static void main(String[] args) throws ParseException {

//             ArrayList<Personagem> personagem = new ArrayList<Personagem>();
//             personagem = lerArquivo();
//             // printaArray(personagem);
//             String myId;
//             while(!(myId = scanner.nextLine()).equals("FIM")){
//                 buscaPorId(myId, personagem);
//             }



//          }
// }
