package Rubro_Negra;
public class NoRB {
    NoRB dir,esq;
    Boolean cor;
    int elemento;
    NoRB(int elemento){
        this(elemento,null,null,false);
    }
    NoRB(int elemento,boolean cor){
        this(elemento,null,null,cor);
    }

    NoRB(int elemento,NoRB esq, NoRB dir, boolean cor){
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.cor = cor;
    }

}
