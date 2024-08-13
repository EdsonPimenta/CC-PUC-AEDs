package Rubro_Negra;

public class ArvoreRB {     
    NoRB raiz;
    public ArvoreRB(){
        raiz = null;
    }
    //os tres primeiros sao inserido manualmente e sem cor
    public void mostrar(){
        caminharPreOrdem(raiz);
    }
    void caminharPreOrdem(NoRB i){
        if(i!=null){
            System.out.println("No: " + i.elemento);
            caminharPreOrdem(i.esq);
            caminharPreOrdem(i.dir);
        }
    }
    public void inserir(int elemento){
        if(raiz == null){
            raiz = new NoRB(elemento);
        }
        else if(raiz.dir == null || raiz.esq == null){
            if(elemento>raiz.elemento){
                if(raiz.dir == null){
                    raiz.dir = new NoRB(elemento);
                }
                else if(elemento>raiz.dir.elemento){
                    raiz.dir.dir = new NoRB(elemento);
                    raiz = rotacionarEsq(raiz);
                }
                else{
                    raiz.dir.esq = new NoRB(elemento);
                    raiz.dir = rotacionarDir(raiz.dir);
                    raiz = rotacionarEsq(raiz);
                }
                raiz.dir.cor = false;
           
            } else{
                if(raiz.esq == null){
                    raiz.esq = new NoRB(elemento);
                }
                else if(elemento < raiz.esq.elemento){
                    raiz.esq.esq = new NoRB(elemento);
                    raiz = rotacionarDir(raiz);
                }
                else{
                    raiz.esq.dir = new NoRB(elemento);
                    raiz.esq = rotacionarEsq(raiz.esq);
                   raiz =  rotacionarDir(raiz);
                }
                raiz.esq.cor =  false;
            }
        }
        else{
            System.out.println("Arvore com tres ou mais elementos");
            inserir(elemento,null,null,null,raiz);
        }
        raiz.cor = false;
    }
    void inserir(int elemento,NoRB bizavo,NoRB avo,NoRB pai,NoRB i){
        if(i == null){
            if(elemento < pai.elemento){
                i = pai.esq = new NoRB(elemento,true);
            }else{
                i = pai.dir = new NoRB(elemento,true);
            }
            if(pai.cor == true){
                balancear(bizavo,avo,pai,i);
            }
        }else{
            //achou um 4-no, deve-se fragmentar
            if(i.esq != null && i.dir !=null && i.esq.cor == true && i.dir.cor == true){
                i.cor = true;
                i.esq.cor = false;
                i.dir.cor = false;
                if(i == raiz){
                    i.cor = false;
                }else if(pai.cor == true){
                    balancear(bizavo,avo,pai,i);
                }
            }

            if(elemento < i.elemento){
                inserir(elemento,avo,pai,i,i.esq);
            }else if(elemento > i.elemento){
                inserir(elemento,avo,pai,i,i.dir);
            }else{
                System.out.println("Erro - Elemento repetido");
                return;
            }
        }
    }
    void balancear(NoRB bisavo,NoRB avo,NoRB pai,NoRB i){
        if(pai.cor == true){
            if(pai.elemento > avo.elemento){
                if(i.elemento > pai.elemento){
                    avo = rotacionarEsq(avo);
                }
                else{
                   avo.dir = rotacionarDir(pai);
                   avo = rotacionarEsq(avo);
                }
            }else{
                if(i.elemento < pai.elemento){
                    avo = rotacionarDir(avo);
                }
                else{
                   avo.esq = rotacionarEsq(pai);
                   avo = rotacionarDir(avo);
                }
            }
        }
        if(bisavo == null){
            raiz = avo;
        }else if(avo.elemento < bisavo.elemento){
            bisavo.esq = avo;
        }else{
            bisavo.dir = avo;
        }
        avo.cor = false;
        avo.esq.cor = avo.dir.cor = true;
    }
    NoRB rotacionarDir(NoRB i){
        System.out.println("Rotacionar Direita");
        NoRB esq = i.esq;
        NoRB esqDir = i.esq.dir;
       
        esq.dir = i;
        i.esq = esqDir;
       
        return esq;
    }

    NoRB rotacionarEsq(NoRB i){
        System.out.println("Rotacionar Esquerda");
        NoRB dir = i.dir;
        NoRB dirEsq = i.dir.esq;
       
        dir.esq = i;
        i.dir = dirEsq;

        return dir;
    }

    
}
