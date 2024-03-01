#include <stdio.h>
#include <string.h>

void alteraString(char criptografia[])
{
int tam = strlen(criptografia);
for(int i = 0;i<tam;i++)
{
criptografia[i] = criptografia[i]+3;
}



}

int main()
{   
    char palavra[30];
    scanf(" %s",palavra);

    alteraString(palavra);
    int tam =  strlen(palavra);
    printf("%s\n",palavra);


    return 0;
}