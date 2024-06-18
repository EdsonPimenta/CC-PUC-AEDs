#include <stdio.h>

void binarioconverte(int x)
{
    if(x>0){
    binarioconverte(x/2);
    printf("%d",(x%2));
   }


}





int main()
{
    int x;

    printf("Digite um numero: ");
    scanf("%d",&x);
    binarioconverte(x);





    return 0;
}