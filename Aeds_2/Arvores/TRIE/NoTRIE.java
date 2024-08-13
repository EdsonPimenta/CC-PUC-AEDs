package TRIE;

public class NoTRIE {
    char valor;
    NoTRIE []prox;
    int tam = 255;
    boolean folha;
    NoTRIE(){
        this(' ');
    }
    NoTRIE(char valor){
        this.valor = valor;
        prox = new NoTRIE[tam];
        for(int i = 0; i < tam;i++){
            prox[i] = null;
        }
        folha = false;
    }
    public static int hash(char c){
        return (int)c;
    }
}
