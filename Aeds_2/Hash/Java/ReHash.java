public class ReHash {
    int tam = 7;
    int numRes;
    Integer []vet;

    public ReHash(){
        this.numRes = 0;
        vet = new int[tam];
        for(int i = 0;i< vet.length;i++){
            vet[i] = null;
        }
    }
    public ReHash(int tam){
        this.tam = tam;
        vet = new int[tam];
        for(int i = 0;i< vet.length;i++){
            vet[i] = null;
        }

    }
    public void inserir(Integer x){
        int i = hash(x);
        if(vet[i] == x){
            vet[i] = x;
        }else{
            i = ReHash(x);
            if(vet[i] == x){
                vet[i] = x;
            }
        }
    }
    public int pesquisar(Integer x){
        int posRes = 0;
        int resp = null;
        int i = hash(x);
        if(vet[i] == x){
            resp = i;
        }else if(vet[i]!=null){
            i = ReHash(x);
            if(vet[i] == x){
                resp = i;
            }
        }
        return resp;
    }
    public int remover(int x){
        int resp = 0;
        int i = hash(x);
        if(vet[i] == x){
            vet[i] = null;
        }else if(vet[i]!=null){
            for(int temp = 0; temp < tamReserva;temp++){
                if(vet[temp + tam] == x){
                    resp = vet[temp + tam];
                    vet[temp + tam] = null;
                }
            }
        }
        return resp;
    }

    int hash(Integer x){
        return x % tam;
    }

    int ReHash(Integer x){
        return ++x % tam;
    }
}

