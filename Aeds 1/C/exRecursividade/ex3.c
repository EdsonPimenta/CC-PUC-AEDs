#include <stdio.h>

int potenciacaoRecursivo(int base,int expoente)
{
    if(expoente == 0)
        return base;
    else{

        return base* potenciacaoRecursivo(base,expoente-1);
    }



}



int main()
{

    int base,expoente;

    base = 2;
    expoente = 3;
    printf("A potencia eh: %d\n",potenciacaoRecursivo(base,expoente));


    return 0;
}