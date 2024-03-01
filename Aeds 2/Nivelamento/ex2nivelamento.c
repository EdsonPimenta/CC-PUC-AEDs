#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void ordenaVetor(int vet[],int tam)
{
int aux;
for(int j = 0;j<tam-1;j++){
    for(int i = 0;i<tam-1;i++)
    {
        if(vet[i]>vet[i+1]){
            aux = vet[i];
            vet[i] = vet[i+1];
            vet[i+1] = aux;
        } 
    }

}
}

bool verificaArray(int vet[],int tam,int x)
{
    bool estaContido = false;
    int left = 0;//esquerda
    int right = tam - 1;//direita
    int m = (left+right)/2;//meio
    while(left<=right)
    {
        
        if(vet[m]==x){
            estaContido = true;
            break;
        }
        else if(vet[m]<x){
            left = m + 1;
        }
        else if(vet[m]>x){
            right = m - 1;
        }

        m = (right + left)/2;
    }

    return estaContido;
}



int main() {
    printf("ola mundo!");
    int vet[]={1,2,3,4,5};
    // ordenaVetor(vet,5);
    bool verifica = verificaArray(vet,5,9);
    // if(verifica == true)
    //     printf("Esta contido\n");
    // else
    //     printf("Nao esta contido");
    printf("ola mundo!");
    return 0;
}