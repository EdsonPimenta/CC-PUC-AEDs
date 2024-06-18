
class Celula{
    int elemento;
    Celula dir,esq,sup,inf;
    Celula(){
        this(0,null,null,null,null);
    }
    Celula(int elemento,Celula dir, Celula esq, Celula sup,Celula inf){
        this.elemento = elemento;
        this.dir = dir;
        this.esq = esq;
        this.sup = sup;
        this.inf = inf;
    }
}
class Matriz{
    Celula inicio;
    int lin,col;
    Celula atual;
    Matriz(){
        this(3,3);
    }
    Matriz(int lin, int col){
        inicio = new Celula();
        this.lin = lin;
        this.col = col;
    }
    public void preencherMatriz(){

        int count =  0;
        Celula atual = inicio;  
        for(int i = 0; i < lin; i++){
            for(int j = 0; j <col;j++){
                Celula tmp = atual;
                tmp.esq = atual.esq;
                atual = atual.dir;
                 
                atual.elemento = count;
            }
        }
    }
    
    public void inserir(int elemento,int posL,int posCol){
        int countL = 0;
        for(Celula i = inicio; i != null; i = i.inf){
            int countC = 0;
            countL++;
            for(Celula j = i; j != null;j = j.dir){
                countC++;
                if(countL == posL && countC == posCol){
                    j.elemento = elemento;
                }
            }
        }
    }
    public void printaMatriz(){
        Celula atual = inicio;
        for(int i = 0; i < lin; i++){
            for(int j = 0; j <col;j++){
                System.out.println(atual.elemento);
                atual = atual.dir;
            }
        }
    }
}




public class Main{
    public static void main(String[]args){
        Matriz matriz = new Matriz();
        matriz.preencherMatriz();
        matriz.printaMatriz();

    }
}