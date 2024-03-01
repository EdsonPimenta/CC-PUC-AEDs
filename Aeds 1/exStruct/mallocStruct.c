#include <stdio.h>
#include <stdlib.h>

typedef struct estrutura{

int *myMalloc;

}estrutura;



int main(){

estrutura object;
object.myMalloc = (int*)malloc(5*sizeof(int));

for(int i = 0;i<5;i++)
{
    scanf("%d",object.myMalloc+i);
    
}
for(int i = 0;i<5;i++)
{
    printf("%d ",object.myMalloc[i]);

}




    return 0;
}