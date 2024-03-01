#include <stdio.h>

void maiorMenor(int vet[],int tam)
{
    int maior = vet[0];
    int menor = vet[0];
    for(int i = 0;i<tam;i++)
    {
        for(int j = 0;j<tam;j++)
        {
            if(vet[j]>maior)
            maior = vet[j];
            
            else if(vet[j]<menor)
            menor = vet[j];
        }

    }
printf("Maior eh %d\nMenor eh %d\n",maior,menor);

}

int main()
{
  
int vet[] = {1,2,3,4,5};
maiorMenor(vet,5);

    return 0;
}