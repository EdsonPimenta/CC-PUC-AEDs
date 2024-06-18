#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int produtoReicursivo(int x,int y)
{
    
    if(y==0)
    return 0;
    else{

        return x+produtoReicursivo(x,y-1);
    }

}


int main()
{
int x,y;
x = 5;
y = 6;

printf("%d",produtoReicursivo(x,y));







    
    return 0;
}