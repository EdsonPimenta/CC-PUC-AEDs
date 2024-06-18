class Celula {
    public int elemento;
    public Celula prox;
    public Celula() {
        this(0);
    }
    public Celula(int x) {
        this.elemento = x;
        this.prox = null;
    }
}

class Pilha {
    private Celula topo;
    public Pilha() {
        topo = null;
    }
    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }
    public int remover() throws Exception {
        if(topo == null) {
            throw new Exception("Erro");
        }
        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }
    public void mostrar() {
        System.out.print("Pilha: [ ");
        for(Celula i = topo; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }

    public int getMaior() {
        return getMaior(topo);
    }
    private int getMaior(Celula i) {
        int resp = i.elemento;
        if(i.prox != null) {
            int maior = getMaior(i.prox);
            if(maior > resp) {
                resp = maior;
            }
        }
        return resp;
    }
}

class Test {
    public static void main(String args[]) {
        Pilha pilha = new Pilha();
        int maior = 0;
        // pilha.inserir(4);
        // pilha.inserir(9);
        pilha.inserir(5);
        pilha.inserir(2);
        pilha.inserir(3);
        maior = pilha.getMaior();
        pilha.mostrar();
        System.out.println("Maior: " + maior);
    }
}