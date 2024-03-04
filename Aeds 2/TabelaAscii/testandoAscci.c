#include <stdio.h>
#include <stdint.h>

int main() {
    // String UTF-8 com caracteres variados
    char utf8_string[50];
    scanf(" %s",utf8_string);
    // Iterar pelos bytes da string
    for (int i = 0; utf8_string[i] != '\0'; ++i) {
        // Interpretar o byte como um número inteiro assinado
        int utf8_decimal = (int)((int8_t)utf8_string[i]);

        // Imprimir o caractere e seu valor decimal assinado
        printf("Caractere - %c, Valor UTF-8: %d\n", utf8_string[i], utf8_decimal);
    }

    return 0;
}
