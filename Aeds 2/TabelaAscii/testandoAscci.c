#include <stdio.h>
#include <string.h>
int main()
{

    char caractere[200];
    scanf("%[^\n]",caractere);
    int tam =  strlen(caractere);
    for(int i = 0;i < tam;i++)
    {

        printf("Caractere - %c, Codigo Ascii - %d\n",caractere[i],caractere[i]);

    }    
    return 0;
}
/*


////////// 


*/