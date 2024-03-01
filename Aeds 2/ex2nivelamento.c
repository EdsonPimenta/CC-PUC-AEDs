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

for(int i = tam/2;i<tam;i+=0)
{

if(vet[i]==x)
estaContido = true;

else if(vet[i]>x)
i--;
else if(vet[i<x])
i++; 


}

return estaContido;
}



int main()
{

int vet[]={1,2,3,4,5};
ordenaVetor(vet,5);
bool verifica = verificaArray(vet,5,9);
if(verifica == true)
printf("Esta contido\n");
else
printf("Nao esta contido");



    return 0;
}