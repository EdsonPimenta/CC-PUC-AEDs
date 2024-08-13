package AVL;
import java.lang.Math;

public class NoAVL {
    int elemento;
    NoAVL dir,esq;
    int nivel;
    public NoAVL(int elemento){
        this(elemento,null,null,1);
    }
    public NoAVL(int elemento,NoAVL esq, NoAVL dir, int nivel){
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }
    public void setNivel(){
        this.nivel = 1 + Math.max(getNivel(dir),getNivel(esq));
    }
   public static int getNivel(NoAVL i){
        if(i == null){
            return 0;
        }
        else{
            return i.nivel;
        }
    }
}

