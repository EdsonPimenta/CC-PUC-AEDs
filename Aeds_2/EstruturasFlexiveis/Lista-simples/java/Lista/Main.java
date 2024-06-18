 import java.util.*;
 
 class Celula {
    // a lista contem dois atributos,primeiro e ultimo
    public int elemento;
    public Celula prox;
    Celula(){
        this.elemento = 0;
        this.prox = null;
    }
    Celula(int elemento){
        this.elemento = elemento;
        this.prox = null;
    }
    //---- setters -------
    public void setElemento(int elemento){
        this.elemento = elemento;
        this.prox = null;
    }
    public void setProx(Celula prox){
        this.prox = null;
    }
    //------ getters ------
    public int getElemento(){
        return elemento;
    }
    public Celula prox(){
        return prox;
    }
    
    
}
class Lista{
    private Celula primeiro,ultimo;
    private int tamanho = 0;
    public Lista(){
        primeiro = ultimo = new Celula();
    }
     // ----- inserção -----
     public void inserirInicio(int elemento){
        Celula tmp = new Celula(elemento);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if(primeiro == ultimo){
            ultimo = tmp;
        }
        tmp = null; // organização
        tamanho++;
     }
     public void inserirFim(int elemento){
        ultimo.prox = new Celula(elemento);
        ultimo = ultimo.prox;
        tamanho++;
     
     }
     public void inserir(int elemento,int pos){
        if(pos < 0 || pos > tamanho){
            System.exit(0);
        }else if(pos == 0){
            inserirInicio(elemento);
        }else if(pos == tamanho){
            inserirFim(elemento);
        }else{
            Celula tmp = new Celula(elemento);
            Celula j = primeiro;
            for(int i = 0;i<pos;i++,j = j.prox);
            tmp.prox = j.prox;
            j.prox = tmp;
            tmp = j = null;
            tamanho++;
        }
     
     }
     //------ remoção -------
     public int removerInicio(){
        if(primeiro == ultimo){
            System.exit(0);
        }
        Celula tmp = primeiro.prox;
        int resp = tmp.getElemento();
        primeiro.prox = primeiro.prox.prox;
        // remove fisicamente a celula
        tmp.prox = null;
        tmp = null;
        tamanho--;

         return resp;
     } 
     public int removerFim (){
        if(primeiro == ultimo){
            System.exit(0);      
        }
         Celula i;
         for(i = primeiro;i.prox!=ultimo;i = i.prox);
         int resp = ultimo.getElemento();
         ultimo = i;
         i = ultimo.prox = null;
         tamanho--;
         return resp;
     }
     public int remover(int pos){
        int resp = 0;
        if(primeiro == ultimo || pos < 0 || pos >= tamanho){
            System.exit(0);
        }
        else if(pos == 0){
            removerInicio();
        }
        else if(pos == tamanho - 1){
            removerFim();
        }
        else{
        Celula j = primeiro;
        for(int i = 0; i < pos;i++,j = j.prox);
        resp = j.prox.getElemento();
        Celula tmp = j.prox;
        j.prox = tmp.prox;
        tmp.prox = null;
        tmp = j = null;
       
         tamanho--;
        }
         return resp;
     }
     // ---- mostrar ------
     public void mostrar(){
        Celula i = primeiro.prox;
        while (i != null) {
            System.out.println(i.getElemento());
            i = i.prox;
        }
     
     } 

 }
 public class Main {
    public static void main(String[] args){
    Lista lista = new Lista();
    lista.inserirFim(5);
    lista.inserirFim(7);
    lista.inserirInicio(10);
    lista.removerInicio();
    // lista.removerFim();
    // System.out.println(lista.removerFim());
    lista.mostrar();

    }
    
}

