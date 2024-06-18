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
   public Celula primeiro,ultimo;
   private int tamanho = 0;
   public Lista(){
       primeiro = ultimo = new Celula();
   }
    // ----- inserção -----
    public void inserirFim(int elemento){
       ultimo.prox = new Celula(elemento);
       ultimo = ultimo.prox;
       tamanho++;
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
  
    
    // ---- mostrar ------
    public void mostrar(){
       Celula i = primeiro.prox;
       while (i != null) {
           System.out.println(i.getElemento());
           i = i.prox;
       }
    
    }
    // retorna o maior elemento
    public int maiorElement0(){
        int maior = primeiro.prox.getElemento();
        for(Celula i = primeiro;i != null;i = i.prox){
            if(i.getElemento()>maior){
                maior = i.getElemento();
            }
        }

        return maior;
    }

    // retorna o terceiro elemento
    public int terceiroElemento(){
        Celula j = primeiro;
        for(int i = 0; i < 3; i ++){
            j = j.prox;
        }
        int resp = j.getElemento();
        return resp;

    }
    // soma dos elementos
    public int somaElementos(){
        int soma = 0;
        for(Celula i = primeiro.prox; i != null;i = i.prox){
            soma += i.getElemento();
        }
        return soma;
    }


    //  inverte a ordem dos elementos da fila
    public void inverteOrdemElementos(){
        
        while(conditioBoolean(primeiro, ultimo)){
            Celula aux = primeiro;
            primeiro = ultimo;
            ultimo = aux;
            ultimo = getUltimo(ultimo,primeiro);
        }
        
    }
    public Boolean conditioBoolean(Celula primeiro,Celula ultimo){
        if(primeiro == ultimo || ultimo.prox == primeiro){
            return false;
        }
        else
            return true;
    }
    public Celula getUltimo(Celula ultimo,Celula primeiro){
        Celula i = primeiro;
        while (i.prox != ultimo) {
            i = i . prox;
        }
        return i;
    }
    public Celula getPrimeiro(){
        return primeiro;
    }
}
public class Fila {
   public static void main(String[] args){
   Lista lista = new Lista();
   lista.inserirFim(5);
   lista.inserirFim(6);
//    lista.inserirFim(7);
//    lista.inserirFim(8);
//    lista.inserirFim(17);
   lista.inserirFim(1);
   lista.mostrar();
   System.out.println();
//    System.out.println(lista.maiorElement0());
//    System.out.println(lista.terceiroElemento());
//    System.out.println(lista.somaElementos());

   lista.inverteOrdemElementos();
   System.out.println();

   lista.mostrar();
   }


}

