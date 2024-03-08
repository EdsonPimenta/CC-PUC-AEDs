package Iterativo;
import java.util.*;

public class is {
    public static Scanner scanner = new Scanner(System.in);
    
    public static Boolean isVogal(String string,int tam){
        Boolean ehVogal = true;
        for(int i = 0; i < tam; i++){
            if(string.charAt(i)!='a'&&string.charAt(i)!='e' && string.charAt(i)!='i' && string.charAt(i)!='o' && string.charAt(i)!='u' && string.charAt(i)!='A' && string.charAt(i)!='E' && string.charAt(i)!='I' && string.charAt(i)!='O' && string.charAt(i)!='U'){
                ehVogal = false;
                i = tam;    
            }
        }
        return ehVogal;
    }
    public static Boolean isConsoante(String string,int tam){
        Boolean ehConsoante = true;
        for(int i = 0; i < tam; i++){
            if( string.charAt(i)=='A' || string.charAt(i)=='E' || string.charAt(i)=='I' || string.charAt(i)=='O' || string.charAt(i)=='U' || string.charAt(i)=='a' || string.charAt(i)=='e' || string.charAt(i)=='i' || string.charAt(i)=='o' || string.charAt(i)=='u'||(string.charAt(i)>='0' && string.charAt(i)<='9')){
                ehConsoante = false;
                i = tam;    
            }
        }
        return ehConsoante;
    }
    public static Boolean isInteiro(String string,int tam){
        boolean ehInteiro = true;
        for(int i = 0; i < tam; i++){
            if((string.charAt(i)== '.' || string.charAt(i)==',')  || (string.charAt(i)<'0' || string.charAt(i)>'9')){
                ehInteiro = false;
            }
        }
        return ehInteiro;
    }
    public static Boolean isReal(String string,int tam){
        boolean ehInteiro = true;
        for(int i = 0; i < tam; i++){
            if(string.charAt(i)!='.' && string.charAt(i)!=',' && (string.charAt(i)<'0' || string.charAt(i)>'9') ){
                ehInteiro = false;
            }
        }
        return ehInteiro;
    }
    
    public static void main(String[] args){
        String isTrue = scanner.nextLine();
        String x1,x2,x3,x4;
        while(!isTrue.equals("FIM")){ 
            int tam = isTrue.length();
            if(isVogal(isTrue,tam)){
                x1 = "SIM";
            }
            else
                x1 = "NAO";
            if(isConsoante(isTrue, tam)){
                x2 = "SIM";
            }
            else
                x2 = "NAO";
            if(isInteiro(isTrue, tam)){
                x3 = "SIM";
            }
            else
                x3 = "NAO";
            if(isReal(isTrue, tam)){
                x4 = "SIM";
            }
            else
                x4 = "NAO";
            System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);
            isTrue = scanner.nextLine();
        }


    }
    
}
