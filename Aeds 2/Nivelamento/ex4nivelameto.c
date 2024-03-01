#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


void verificaMaiorMenor(int vet[],int tam)
{
    int maior = vet[0];
    int menor = vet[0];


        for(int i = 1;i<tam;i++)
        {
             if(vet[i]>maior)
                maior = vet[i];

             else if(vet[i]<menor)
                menor = vet[i];   
        }
    
    printf("O maior eh %d\n O menor eh %d",maior,menor);
    //nao tem como fazer menos que n comparações, a não ser que seja ordenado


}



int main()
{
    int array[] = {1,2,3,4,5};
    verificaMaiorMenor(array,5);


 
    return 0;
}