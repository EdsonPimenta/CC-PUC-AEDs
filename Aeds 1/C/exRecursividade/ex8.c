#include <stdio.h>
int inverteTermos(int vet[],int tam)
{
    if(tam > 0)
    {
        printf("%d",vet[tam-1]);
         inverteTermos(vet,tam-1);

    }




}

int main()
{
    int n;
    printf("Digite o numero de termos do arranjo: ");
    scanf("%d",&n);
    int vet[n];

    for(int i = 0;i<n;i++)
    {
        printf("Digite o termo %d: ",i+1);
        scanf("%d",&vet[i]);

    }
    inverteTermos(vet,n);



    return 0;
}