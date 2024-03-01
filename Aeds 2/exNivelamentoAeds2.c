#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool verificaArray(int vet[],int tam,int x)
{
    bool estaContido = false;
    for(int i = 0;i<tam;i++)
    {
        if(vet[i]==x)
            estaContido = true;
    }



    return estaContido;
}
void printaTela(bool verifica)
{   
    
    if(verifica == true)
    printf("Esta contido\n");
    else
    printf("Nao esta contido\n");
}



int main()
{
bool verifica;
int vetInteiros[]={1,2,3,4,5};
int tam = 5;
int x = 4;

verifica = verificaArray(vetInteiros,tam,x);
printaTela(verifica);

    return 0;
}