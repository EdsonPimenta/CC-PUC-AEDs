public class Overflow {
    int tam = 7;
    int tamReserva = 3;
    int numRes;
    Integer []vet;

    public Overflow(){
        this.numRes = 0;
        vet = new int[tam+tamReserva];
        for(int i = 0;i< vet.length;i++){
            vet[i] = null;
        }
    }
    public Overflow(int tam, int tamReserva){
        this.tam = tam;
        this.tamReserva = tamReserva;
        this.numRes = 0;
        vet = new int[tam+tamReserva];
        for(int i = 0;i< vet.length;i++){
            vet[i] = null;
        }

    }
    public void inserir(Integer x){
        int i = hash(x);
        if(vet[i] == null){
            vet[i] = x;
        }else{
            if(numRes<tamReserva){
                vet[tam+numRes] = x;
                numRes++;
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
            for(int temp = 0; temp < tamReserva;i++){
                if(vet[tam+temp] == x){
                    resp = tam + temp;
                }  
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
}

