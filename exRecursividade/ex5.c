#include <stdio.h>
int vezesNumeroNoVetor(int vet[],int tam,int x,int contador)
{

    if(tam==0)
        return contador;
    else{
    if(vet[tam-1] == x){
        return (vezesNumeroNoVetor(vet,tam-1,x,contador+1));
    }
    else 
        return(vezesNumeroNoVetor(vet,tam-1,x,contador));

    }


}



int main()
{
    int n,x;
    scanf("%d",&n);
    scanf("%d",&x);
    int contador = 0;
    int vet[n];
    for(int i =0;i<n;i++)
    {
        scanf("%d",&vet[i]);
    }
    int resultado = vezesNumeroNoVetor(vet,n,x,contador);
    printf("\nO resultado eh: %d\n",resultado);

    

    return 0;
}