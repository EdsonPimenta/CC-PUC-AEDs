import java.util.Scanner;

class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;

    public Celula(){
        this(0);
    }

    public Celula(int elemento){
        this(elemento, null, null, null, null);
    }

    public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
        this.elemento = elemento;
        this.inf = inf;
        this.sup = sup;
        this.esq = esq;
        this.dir = dir;
    }
}

class Matriz {
    private Celula inicio;
    private int linha, coluna;

    public Matriz() {
        this(3, 3);
    }

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;

        // Alocar a matriz com this.linha linhas e this.coluna colunas
        inicio = new Celula();  // Inicializando a célula inicial

        Celula atual = inicio;
        Celula colunaAtual = inicio;

        // Criar a primeira linha
        for (int j = 1; j < coluna; j++) {
            atual.dir = new Celula();
            atual.dir.esq = atual;
            atual = atual.dir;
        }

        // Criar as outras linhas
        for (int i = 1; i < linha; i++) {
            colunaAtual.inf = new Celula();
            colunaAtual.inf.sup = colunaAtual;
            atual = colunaAtual.inf;

            for (int j = 1; j < coluna; j++) {
                atual.dir = new Celula();
                atual.dir.esq = atual;
                atual.dir.sup = atual.sup.dir;
                atual.sup.dir.inf = atual.dir;
                atual = atual.dir;
            }
            colunaAtual = colunaAtual.inf;
        }
    }

    public void setElemento(int i, int j, int elemento) {
        Celula atual = inicio;
        for (int x = 0; x < i; x++) {
            atual = atual.inf;
        }
        for (int y = 0; y < j; y++) {
            atual = atual.dir;
        }
        atual.elemento = elemento;
    }

    public int getElemento(int i, int j) {
        Celula atual = inicio;
        for (int x = 0; x < i; x++) {
            atual = atual.inf;
        }
        for (int y = 0; y < j; y++) {
            atual = atual.dir;
        }
        return atual.elemento;
    }

    public Matriz soma(Matriz m) {
        Matriz resp = null;

        if (this.linha == m.linha && this.coluna == m.coluna) {
            resp = new Matriz(this.linha, this.coluna);
            Celula c = resp.inicio;
            Celula a = this.inicio;
            Celula b = m.inicio;

            for (int i = 0; i < this.linha; i++) {
                Celula cTmp = c;
                Celula aTmp = a;
                Celula bTmp = b;
                for (int j = 0; j < this.coluna; j++) {
                    cTmp.elemento = aTmp.elemento + bTmp.elemento;
                    cTmp = cTmp.dir;
                    aTmp = aTmp.dir;
                    bTmp = bTmp.dir;
                }
                c = c.inf;
                a = a.inf;
                b = b.inf;
            }
        }
        return resp;
    }

    public Matriz multiplicacao(Matriz m) {
        Matriz resp = null;

        if (this.coluna == m.linha) {
            resp = new Matriz(this.linha, m.coluna);
            for (int i = 0; i < this.linha; i++) {
                for (int j = 0; j < m.coluna; j++) {
                    int soma = 0;
                    for (int k = 0; k < this.coluna; k++) {
                        soma += this.getElemento(i, k) * m.getElemento(k, j);
                    }
                    resp.setElemento(i, j, soma);
                }
            }
        }
        return resp;
    }

    public boolean isQuadrada() {
        return this.linha == this.coluna;
    }

    public void mostrarDiagonalPrincipal() {
        if (isQuadrada()) {
            Celula atual = inicio;
            for (int i = 0; i < linha; i++) {
                System.out.print(atual.elemento + " ");
                if (atual.dir != null && atual.inf != null) {
                    atual = atual.dir.inf;
                }
            }
            System.out.println();
        }
    }

    public void mostrarDiagonalSecundaria() {
        if (isQuadrada()) {
            Celula atual = inicio;
            for (int i = 0; i < linha - 1; i++) {
                atual = atual.dir;
            }
            for (int i = 0; i < linha; i++) {
                System.out.print(atual.elemento + " ");
                if (atual.esq != null && atual.inf != null) {
                    atual = atual.esq.inf;
                }
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCasos = scanner.nextInt();

        for (int caso = 0; caso < numCasos; caso++) {
            // Leitura da primeira matriz
            int linhas1 = scanner.nextInt();
            int colunas1 = scanner.nextInt();
            Matriz m1 = new Matriz(linhas1, colunas1);
            for (int i = 0; i < linhas1; i++) {
                for (int j = 0; j < colunas1; j++) {
                    m1.setElemento(i, j, scanner.nextInt());
                }
            }

            // Leitura da segunda matriz
            int linhas2 = scanner.nextInt();
            int colunas2 = scanner.nextInt();
            Matriz m2 = new Matriz(linhas2, colunas2);
            for (int i = 0; i < linhas2; i++) {
                for (int j = 0; j < colunas2; j++) {
                    m2.setElemento(i, j, scanner.nextInt());
                }
            }

            // Mostrar diagonais da primeira matriz
            m1.mostrarDiagonalPrincipal();
            m1.mostrarDiagonalSecundaria();

            // Soma das matrizes
            Matriz soma = m1.soma(m2);
            if (soma != null) {
                for (int i = 0; i < linhas1; i++) {
                    for (int j = 0; j < colunas1; j++) {
                        System.out.print(soma.getElemento(i, j) + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Nao foi possivel somar as matrizes");
            }

            // Multiplicação das matrizes
            Matriz multiplicacao = m1.multiplicacao(m2);
            if (multiplicacao != null) {
                for (int i = 0; i < linhas1; i++) {
                    for (int j = 0; j < colunas2; j++) {
                        System.out.print(multiplicacao.getElemento(i, j) + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Nao foi possivel multiplicar as matrizes");
            }
        }

        scanner.close();
    }
}
