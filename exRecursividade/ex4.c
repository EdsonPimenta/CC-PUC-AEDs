#include <stdio.h>


int somaVetor(int vet[],int tam)
{
    int soma;
    if(tam==0)
        return 0;

    
    return vet[tam-1]+ somaVetor(vet,tam-1);
}


int main()
{


int vet[] = {1,2,3,4,5};
int tam = 5;
int resultado = somaVetor(vet,tam);

printf("A soma dos numeros do arranjo eh: %d",resultado);



    return 0;
}