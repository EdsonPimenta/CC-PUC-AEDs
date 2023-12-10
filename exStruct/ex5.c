    #include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct produtos{
char nome[30];
int preco;

}produtos;

typedef struct lista{
int id;
produtos vet[30];
int size;
}lista;

void preencheLista(lista* Lista)
{
    int i  = Lista->id;
    printf("Digite o nome do produto: ");
    scanf(" %[^\n]",Lista->vet[i].nome);
    printf("Digite o preco do produto: ");
    scanf("%d",&Lista->vet[i].preco);
    Lista->id++;
    Lista->size++;


}
void printaLista(lista Lista)
{
    for(int i = 1;i<=Lista.size;i++){
    printf("Nome: %s",Lista.vet[i].nome);
    printf("\nPreco: %d\n",Lista.vet[i].preco);
    }

}
void printaListaArquivo(FILE*arq,lista Lista)
{
    arq = fopen("listaProdutos.txt","w");
    for(int i = 1;i<=Lista.size;i++)
    {
        fprintf(arq, "%s;%d;",Lista.vet[i].nome,Lista.vet[i].preco);
    }
    fclose(arq);
}
void lerDoArquiv(FILE*arq,lista* Lista)
{
int qtd = Lista->size ;
arq = fopen("listaProdutos.txt","r");
for(int i = 1;i<=qtd;i++){ 
    fscanf(arq,"%[^;]",Lista->vet[Lista->id].nome);           
    fscanf(arq,"%d;",&Lista->vet[Lista->id].preco);
    Lista->size++;
    Lista->id++;
}
fclose(arq);


}


int main(){
lista myList;
myList.id = 1;
myList.size = 0;
FILE* arq;
preencheLista(&myList);
printaListaArquivo(arq,myList);
printaLista(myList);
lerDoArquiv(arq,&myList);


    return 0;
}