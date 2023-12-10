#include <stdio.h>

int fibonacci(int n)
{
    if(n==0||n==1)
        return 1;
    else{

        return fibonacci(n-1)+fibonacci(n-2);

    }



}






int main()
{
    
    
    int n;
    printf("Digite o ultimo termo da sequcencia de fibonacci: ");
    scanf("%d",&n);
    int enesimoTermo = fibonacci(n);
    printf("\n%d\n",enesimoTermo);
    
    
    return 0;

}