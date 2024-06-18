#include <stdio.h>
#include <stdlib.h>
/* ---- Entrada -----------------
A entrada consiste em vários casos de teste, onde cada caso de teste é composto por 3 linhas.
A primeira das 3 linhas contém um número inteiro N que representa o número total de vagões.
A segunda linha contém a sequência dos vagões que vêm do lado A e a 
Terceira linha contém a sequência que o chefe de organização deseja como saída para o lado B.
A última linha de entrada contém apenas 0, indicando o fim da entrada.
*/

/* ------- Saída -----------
O arquivo de saída contém a quantidade de linhas correspondente ao número de casos de teste de entrada.
 Cada linha de saída contém uma sequência de I e R conforme o exemplo.
  Se não for possível mostrar a saída, as operações devem ser interrompidas e a mensagem "Impossible" deve ser impressa, com um espaço após a sequência
*/

/* ----- Exemplo -------
 A entrada e,t,d,a
para uma saída desejada d,a,t,e,
 I,I,I,R,I,R,R,R
*/

char* entradasDesejada(int n){
    char* arrEntrada = (char*) malloc(26 * sizeof(char));
    for(int i = 0; i < n; i++){
        scanf("%c",arrEntrada + i);
    }
    return arrEntrada;
}
char* saidaDesejada(int n){
    char* arrSaida = (char*) malloc(26 * sizeof(char));
    for(int i = 0; i < n; i++){
        scanf("%c",arrSaida + i);
    }
    return arrSaida;
}
void entradaSaida(char* entrada,char* saida,int n,int count){
    /* ----- Exemplo -------
    A entrada e,t,d,a
    para uma saída desejada d,a,t,e,
    I,I,I,R,I,R,R,R
    */ 
    // for(int i = 0; i < n;i++) {
    //    if() 
    // }
    entradaSaida(entrada,saida,n,count);
    
}

int main(){
    int n;
    scanf("%d",&n);
    entradaSaida( entradasDesejada(n),saidaDesejada(n),n,0);


    return 0;
}