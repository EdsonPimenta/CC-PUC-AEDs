package AVL;
import java.lang.Math;
public class ArvoreAVL {
    NoAVL raiz;
    public ArvoreAVL(){
       raiz = null;
    }
    public void inserir(int elemento){
        raiz = inserir(elemento,raiz);
    }
    NoAVL inserir(int elemento, NoAVL i){
        if(i == null){
            i = new NoAVL(elemento);
        }
        else if(elemento>i.elemento){
            i.dir = (inserir(elemento, i.dir));
        }
        else if(elemento< i.elemento){
                i.esq = (inserir(elemento, i.esq));
        }
        return balancear(i);
    }
    NoAVL balancear(NoAVL i){
        int fator = NoAVL.getNivel(i.dir) - NoAVL.getNivel(i.esq);
        if(Math.abs(fator) <= -1){
            i.setNivel();
        }
        else if(fator == 2){
            int fatorFilhoDir = NoAVL.getNivel(i.dir.dir) - NoAVL.getNivel(i.dir.esq);
                if(fatorFilhoDir == -1){
                    i.dir = rotacionarDir(i.dir);
                }
                i = rotacionarEsq(i);
        }
        else if( fator == -2){
            int fatorFilhoEsq = NoAVL.getNivel(i.esq.dir) - NoAVL.getNivel(i.esq.esq);
            if(fatorFilhoEsq == 1){
                i.esq = rotacionarEsq(i.esq);
            }
                i = rotacionarDir(i);
        }
        return i;
    }
    NoAVL rotacionarDir(NoAVL i){
        System.out.println("Rotacionar Direita");
        NoAVL esq = i.esq;
        NoAVL esqDir = i.esq.dir;
       
        esq.dir = i;
        i.esq = esqDir;
       
        return esq;
    }
    NoAVL rotacionarEsq(NoAVL i){
        System.out.println("Rotacionar Esquerda");
        NoAVL dir = i.dir;
        NoAVL dirEsq = i.dir.esq;
       
        dir.esq = i;
        i.dir = dirEsq;

        return dir;
    }
    public void caminharPos(){
        caminharPos(raiz);
    }
    void caminharPos(NoAVL i){
        if(i != null){
            caminharPos(i.dir);
            caminharPos(i.esq);
            System.out.println("No: " + i.elemento);
        }
    }
    void remover(int elemento){

    }
    NoAVL remover(int elemento, NoAVL i){
        if(elemento>i.elemento){
            i.dir = remover(elemento, i.dir);
        }
        else if(elemento < i.elemento){
            i.esq = remover(elemento, i.esq);
        }
        else if(i.dir == null){
            i = i.esq;
        }
        else if(i.esq == null){
            i = i.dir;
        }
        else{
            i.esq = getMaiorEsq(i,i.esq);
        }
        return i;
    }
    NoAVL getMaiorEsq(NoAVL i,NoAVL j){
        if(j.dir == null){
            i.elemento = j.elemento;
            j = j.esq;
        }
        else{
            j.dir = getMaiorEsq(i,j.dir);
        }
        return j;
    }
}
