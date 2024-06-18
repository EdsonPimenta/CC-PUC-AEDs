#include <stdio.h>


void preencheArr(int vet[],int n){
    int count = 1;
    for(int i = n-1;i>=0;i--){
        vet[i] = count++;
      
    }
    
}

int removeFim(int vet[],int* n){
    int elemento = vet[*(n)-1];
    (*n)--;
    return elemento;
}
void insereInicio(int vet[],int n){
    int elemento = vet[n-1];
    for(int i = n;i>0;i--){
        vet[i] = vet[i-1];
    }
    vet[0] = elemento;
}

int main(){
    int n;
    while(scanf("%d",&n)!=0){
        int vet[n];
        preencheArr(vet,n);
        printf("Discarded cards: ");
         for(int i = n - 1;i > 0 ;i--){
            printf("%d",removeFim(vet,&n));
                if(i>1){
                    printf(", ");
                }
            insereInicio(vet,n);
         }
         printf("\nRemaining cards: ");
         printf("%d",vet[n-1]);
        
    }

    return 0;
}