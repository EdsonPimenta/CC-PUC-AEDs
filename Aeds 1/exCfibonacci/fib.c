#include <stdio.h>


int main()
{
    int termo;
    int anterior;
    int prox;
     anterior = 0;
     termo = 1;



    for(int i = 0;i<10;i++)
    {
        prox = anterior + termo;
        anterior = termo;
        termo = prox;
        printf("%d",prox);

    }

    return 0;
}

