import AVL.*;
import Rubro_Negra.*;
import TRIE.*;

public class Principal {
    public static void main(String[] args) throws Exception{
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        arvoreAVL.inserir(5);
        arvoreAVL.inserir(6);
        arvoreAVL.inserir(4);
        arvoreAVL.caminharPos();

        ArvoreRB arvoreRB = new ArvoreRB();
        arvoreRB.inserir(5);
        arvoreRB.inserir(9);
        arvoreRB.inserir(12);
        arvoreRB.inserir(8);
        arvoreRB.inserir(2);
        arvoreRB.inserir(20);
        arvoreRB.mostrar();

        ArvoreTRIE arvoreTRIE = new ArvoreTRIE();
        String array[] = new String[13];
        array[0] = "ACEROLA";
        array[1] = "ABACATE";
        array[2] = "ABACAXI";
        array[3] = "BALA";
        array[4] = "BOLO";
        array[5] = "ABACATE";
        array[6] = "galo";
        array[7] = "pata";
        array[8] = "pato";
        array[9] = "gato";
        array[10] = "ga";
        array[11] = "gataloei";
        array[12] = "AC";


  
        for(int i = 0; i < array.length;i++){
            arvoreTRIE.inserir(array[i]);
        }
        arvoreTRIE.mostrar();
        arvoreTRIE.contar('A');


    }

}

