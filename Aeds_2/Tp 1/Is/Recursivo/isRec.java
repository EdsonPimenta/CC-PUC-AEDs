package Recursivo;

import java.util.*;

public class isRec {
    public static Scanner scanner = new Scanner(System.in);
    
    public static Boolean isVogal(String string,int tam,int i){
        Boolean ehVogal = true;
            if(i>tam)
                return ehVogal;
            else if(string.charAt(i)!='a'&&string.charAt(i)!='e' && string.charAt(i)!='i' && string.charAt(i)!='o' && string.charAt(i)!='u' && string.charAt(i)!='A' && string.charAt(i)!='E' && string.charAt(i)!='I' && string.charAt(i)!='O' && string.charAt(i)!='U'){
                return false;
            }
        
        return isVogal(string, tam, i+1);
    }
    public static Boolean isConsoante(String string,int tam,int i){
        Boolean ehConsoante = true;
            if(i>tam){
                return ehConsoante;
            }
            else if( string.charAt(i)=='A' || string.charAt(i)=='E' || string.charAt(i)=='I' || string.charAt(i)=='O' || string.charAt(i)=='U' || string.charAt(i)=='a' || string.charAt(i)=='e' || string.charAt(i)=='i' || string.charAt(i)=='o' || string.charAt(i)=='u'||(string.charAt(i)>='0' && string.charAt(i)<='9')){
                return false;
            }
        
        return isConsoante(string, tam, i+1);
    }
    public static Boolean isInteiro(String string,int tam,int i){
        boolean ehInteiro = true;
        if(i>tam){
            return ehInteiro;
        }
            else if((string.charAt(i)== '.' || string.charAt(i)==',')  || (string.charAt(i)<'0' || string.charAt(i)>'9')){
                return false;
            }
        
        return isInteiro(string, tam, i+1);
    }
    public static Boolean isReal(String string,int tam,int i){
        boolean ehReal = true;
            if(i>tam){
                return ehReal;
            }
        
            else if(string.charAt(i)!='.' && string.charAt(i)!=',' && (string.charAt(i)<'0' || string.charAt(i)>'9') ){
                return false;
            }
            return isReal(string, tam, i+1);
    }
    
    public static void main(String[] args){
        String isTrue = scanner.nextLine();
        String x1,x2,x3,x4;
        while(!isTrue.equals("FIM")){ 
            int tam = isTrue.length();
            if(isVogal(isTrue,tam-1,0)){
                x1 = "SIM";
            }
            else
                x1 = "NAO";
            if(isConsoante(isTrue, tam-1,0)){
                x2 = "SIM";
            }
            else
                x2 = "NAO";
            if(isInteiro(isTrue, tam-1,0)){
                x3 = "SIM";
            }
            else
                x3 = "NAO";
            if(isReal(isTrue, tam-1,0)){
                x4 = "SIM";
            }
            else
                x4 = "NAO";
            System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);
            isTrue = scanner.nextLine();
        }


    }
    
}

