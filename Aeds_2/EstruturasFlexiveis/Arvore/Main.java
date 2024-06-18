import java.util.*;

class No{
    No dir, esq;
    int elemento;
    No(int elemento){
        this.dir = null;
        this.esq = null;
        this.elemento = elemento;
    }
}


class Arvore{
    No raiz;
    int tamEsq = 0;
    int tamDir = 0;
    int fator = 0;
    Arvore(){
        this.raiz = null;
    }
    void inserir(int elemento){
        raiz = inserir(elemento, raiz);
        fator = tamDir - tamEsq;
    }
    No inserir(int elemento,No i){
        if(i == null){
            i = new No(elemento);
        }
        else if(elemento > i.elemento){
            i.dir = inserir(elemento, i.dir);
            tamDir++;
        }
        else if(elemento<i.elemento){
            i.esq = inserir(elemento, i.esq);
            tamEsq--;
        }
        return i;

    }
    void  balancear(){
        if(raiz.dir!=null && raiz.esq!=null){
            System.out.println("Árvore balanceada");
        }else if(raiz.dir!=null){
            if(raiz.dir.dir != null){
                raiz = rotacionarEsq(raiz);
            }else{
                raiz = rotacionarDirEsq(raiz);
            }
        }else{
            if(raiz.esq.dir != null){
                raiz = rotacionarEsqDir(raiz);    
            
            }else{
                raiz = rotacionarDir(raiz);
            }
        }
    }
    void remover(int elemento) throws Exception{
        raiz =  remover(elemento,raiz);
    }
    No remover(int elemento,No i) throws Exception{
      if(i == null) {
        throw new Exception("Erro");
      }else if(elemento < i.elemento){
        i.esq = remover(elemento, i.esq);
      }else if(elemento > i.elemento){
        i.dir = remover(elemento, i.dir);
      }
      else if(i.dir == null){
        i = i.esq;
      }
      else if(i.esq == null){
        i = i.dir;
      }
      else{
        i.esq = getMaiorEsq(i, i.esq);
      }

      return i;
    }
    No rotacionarEsq(No i){
        No iDir = i.dir;
        No iDirEsq = i.dir.esq;
        iDir.esq = i;
        i.dir = iDirEsq;
        return iDir;
    }
    No rotacionarDir(No i){
        No iEsq = i.esq;
        No iEsqDir = iEsq.dir;
        iEsq.dir = i;
        i.esq = iEsqDir;
        return iEsq;
    }
    No rotacionarDirEsq(No i){
        i.dir = rotacionarDir(i.dir);
        return rotacionarEsq(i);
    }
    No rotacionarEsqDir(No i){
        i.esq = rotacionarEsq(i.esq);
        return rotacionarDir(i);
    }
    No getMaiorEsq(No i, No j){
        if(i.dir == null){
            i.elemento = j.elemento;
            j = j.esq;
        }
        else{
            j.dir = getMaiorEsq(i,j.dir); 
        }

        return j;
    }
    boolean isContido(int elemento){
        return isContido(raiz,elemento);
    }
    boolean isContido(No raiz,int elemento){
        No atual = raiz;
        boolean estaContido = false;
        while (atual!=null) {
            if(atual.elemento == elemento){
                estaContido = true;
                atual = null;
            }
            else if(elemento>atual.elemento){
                atual = atual.dir;
            }
            else if(elemento<atual.elemento){
                atual = atual.esq;
            }
        }
        return estaContido;
    }
    int getSoma(No i){
        int soma = 0;
        if(i!=null){
            soma+=i.elemento;
            soma+=getSoma(i.esq);
            soma+=getSoma(i.dir);
        }
        return soma;
    }



}

public class Main {
public static void main(String[] args) {
    System.out.println("ola\n");
}
}