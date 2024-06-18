class CelulaDupla{
    public int elemento;
    public CelulaDupla prox, ant;
    CelulaDupla(){
       this(0);
    }
    CelulaDupla(int elemento){
        this.elemento = elemento;
        this.prox = null;
        this.ant = null;
    }
    // --- setters ----
    public void setElemento(int elemento){
        this.elemento = elemento;
    }
    //  ---- getter ----
    public int getElemento(){
        return elemento;
    }

}

class Lista{
    private CelulaDupla primeiro,ultimo;
    private int tamanho = 0;
    public Lista(){
        primeiro = ultimo = new CelulaDupla();
    }
     // ----- inserção -----
     public void inserirInicio(int elemento){
        CelulaDupla tmp = new CelulaDupla(elemento);
        tmp.prox = primeiro.prox;
        tmp.ant = primeiro;
        primeiro.prox = tmp;
        if(primeiro == ultimo){
            ultimo = tmp;
        }else{
            tmp.prox.ant = tmp;
    }
        tmp = null;
        tamanho++;
    }
     public void inserirFim(int elemento){
        ultimo.prox = new CelulaDupla(elemento);
        ultimo.prox.ant = ultimo;
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
            CelulaDupla tmp = new CelulaDupla(elemento);
            CelulaDupla j = primeiro;
            for(int i = 0;i<pos;i++,j = j.prox);
            tmp.prox = j.prox;
            tmp.ant = j;
            tmp.prox.ant = tmp.ant.prox = tmp;
            tmp = j = null;
            tamanho++;
        }
     
     }
     //------ remoção -------
     public int removerInicio(){
        if(primeiro == ultimo){
            System.exit(0);
        }
        CelulaDupla tmp = primeiro.prox;
        int resp = tmp.getElemento();
        primeiro.prox = primeiro.prox.prox;
        tmp.prox.ant = primeiro;
        // remove fisicamente a celula
        tmp.prox = null;
        tmp.ant = null;
        tmp = null;
        tamanho--;

         return resp;
     } 
     public int removerFim (){
        if(primeiro == ultimo){
            System.exit(0);      
        }
        int resp = ultimo.getElemento();
         ultimo = ultimo.ant;
         ultimo.prox.ant = null;
         ultimo.prox = null;
        
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
        CelulaDupla j = primeiro;
        for(int i = 0; i < pos;i++,j = j.prox);
        resp = j.prox.getElemento();
        CelulaDupla tmp = j.prox;
        j.prox = tmp.prox;
        j.prox.ant = j;
        tmp.prox = null;
        tmp.ant = null;
        tmp = j = null;
       
         tamanho--;
        }
         return resp;
     }
     // ---- mostrar ------
     public void mostrar(){
        CelulaDupla i = primeiro.prox;
        while (i != null) {
            System.out.println(i.getElemento());
            i = i.prox;
        }
     
     } 
}

public class Main {
    
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.inserirInicio(5);
        lista.inserirFim(6);
        lista.inserirFim(7);
        lista.mostrar();
        // lista.removerInicio();
        // lista.removerFim();
        // lista.remover(0);
        lista.inserir(8, 0);
        System.out.println();
        lista.mostrar();
    }
}
