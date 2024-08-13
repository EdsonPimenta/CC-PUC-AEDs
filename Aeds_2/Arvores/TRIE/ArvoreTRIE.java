package TRIE;
 public class ArvoreTRIE {
    NoTRIE raiz;
    public ArvoreTRIE(){
        raiz = new NoTRIE();
    }
    public void inserir(String s){
        inserir(s,raiz,0);
    }
    public void inserir(String s, NoTRIE no,int i){
        if(no.prox[s.charAt(i)] == null){
            no.prox[s.charAt(i)] = new NoTRIE(s.charAt(i));
            if(i == s.length()-1){
                System.out.println("folha");
                no.prox[s.charAt(i)].folha = true;
            }else{
                inserir(s, no.prox[s.charAt(i)], i+1);
            }
        }else if( i < s.length()-1){
           inserir(s, no.prox[s.charAt(i)], i+1);
        }else if( i == s.length() - 1){
            System.out.println("folha");
            no.prox[s.charAt(i)].folha = true;
        }
    }
    public boolean pesquisar(String s){
        return pesquisar(s,raiz,0);
    }
    private boolean pesquisar(String s,NoTRIE no,int i){
        boolean resp = true;
        if(no.prox[s.charAt(i)] == null){
            resp = false;
        }else if(i == s.length()-1){
            resp = (no.prox[s.charAt(i)].folha == true);
        }else if(i < s.length()-1){
            resp = pesquisar(s, no.prox[s.charAt(i)], i+1);
        }else{
            System.out.println("Erro ao pesquisar");
            System.exit(-1);
        }
        return resp;
    }
    public void mostrar(){
        mostrar("", raiz);
    }
     private void mostrar(String s, NoTRIE no){
        if(no.folha == true){
            System.out.println("Palavra: " + s + no.valor);
        }else{
            for(int i = 0; i < no.prox.length;i++){
                if(no.prox[i]!=null){
                    System.out.println("Estou em: " + no.valor + " E vou para: " + no.prox[i].valor);
                    mostrar(s + no.valor, no.prox[i]);
                }
            }
        }
    }
    public void contar(char c){
       System.out.println("Tem: "+ contar(c,raiz) + "caracteres: "+ c); 
    }
    private int contar(char c, NoTRIE no){
        int contar = 0;
        if(no.folha != true){
            for(int i = 0; i < no.prox.length;i++){
                if(no.prox[i] != null){
                    if(no.prox[i].valor == c){
                        contar++;
                    }
                    contar += contar(c,no.prox[i]);
                 }
            }
        }
        return contar;
    }

    
 }