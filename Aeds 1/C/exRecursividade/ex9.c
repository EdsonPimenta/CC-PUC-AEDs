#include <stdio.h>



void inverte(int vet[],int tam)
{
    if(tam > 0){


        printf("%d",vet[tam-1]);
        return inverte(vet,tam-1);
    }
    

}

int main(){

    int vet[3] = {0,1,2};
    inverte(vet,3);




    return 0;
}


