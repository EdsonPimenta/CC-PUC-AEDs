#include <stdio.h>

int fatorial(int n)
{
    if(n == 1)
        return n;
    else{

    return n* fatorial(n-1);

    }


}

int main()
{


    int n;
    printf("Digite um numero: ");
    scanf("%d",&n);
    printf("\nO fatorial eh: %d\n",fatorial(n));


    return 0;
}