#ifndef FUNCOES_H_INCLUDED
#define FUNCOES_H_INCLUDED
#include "struct.h"
#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

long int sizeOf_File(FILE * arq){
  arq = fopen("characters.csv","r");
  if (arq == NULL){
    printf("Arquivo nao encontrado");
    return -1;
  }
  // move o cursor para ultima posicao do arquivo
  fseek(arq, 0,SEEK_END);
  long int sizeFile = ftell(arq);
  fclose(arq);

  return sizeFile;
}



char *tratandoAlternateNames(char string[]) {
    int count = 0;
    char* newChar = (char*) malloc((strlen(string) + 1) * sizeof(char));

    for(int i = 0; string[i] != '\0'; i++) {
        if(string[i] == '\'' || string[i] == '[' || string[i] == ']') continue;
        newChar[count++] = string[i];
    }

    newChar[count] = '\0';
    
    return newChar;
}

// funcao que l� string
void readString(char string[]) {
      int tam;
      scanf(" %[^\n]", string);
      getchar();
     
}



// void listaPassagens(array lista) {
//     printf("\n");
//     printf("\t(Lista de passagens)\n\n");
//   for (int i = 1; i <= lista.size; i++) {
//     printf(" %d %s %s %s %s %02d/%02d/%d %d:%d %d:%d R$%d;\n", i,
//            lista.vet[i].codigoAeroportoOrigem,
//            lista.vet[i].codigoAeroportoDestino, lista.vet[i].cdOrigem,
//            lista.vet[i].cdDestino, lista.vet[i].data.dia, lista.vet[i].data.mes,
//            lista.vet[i].data.ano, lista.vet[i].data.horaSD,
//            lista.vet[i].data.minutoSD, lista.vet[i].data.horaCH,
//            lista.vet[i].data.minutoCH, lista.vet[i].preco);
//   }
// }


void pesquisaPassagem(array Lista) {

  bool ehIgual;
  bool ehTrue;
  char id[100];
  int tamString;

        ehTrue = false;

        // lê id do teclado
         
        scanf("%[^\n]",id);
        tamString = strlen(id);
        printf("Entrou na pesquisa passsagem\n");
        for (int j = 0; j < Lista.size; j++) {
          printf("Primeiro for\n");
            ehIgual = true;
            for (int i = 0; i < tamString; i++) {
              printf("Segundo for\n");
                if (id[i] != Lista.vet[j].id[i]) {
                    ehIgual = false;
                }
                }
            if (ehIgual == true) {
                printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %02d/%02d/%d ## %d ## %s ## %s ## %s ## %s]\n",
                  Lista.vet[j].id,
                  Lista.vet[j].name,
                  tratandoAlternateNames(Lista.vet[j].alternate_names),
                  Lista.vet[j].house,
                  Lista.vet[j].ancestry,
                  Lista.vet[j].species,
                  Lista.vet[j].patronus,
                  Lista.vet[j].hogwartsStaff,
                  Lista.vet[j].hogwartsStudent,
                  Lista.vet[j].actorName,
                  Lista.vet[j].alive,
                  Lista.vet[j].data.dia,
                  Lista.vet[j].data.mes,
                  Lista.vet[j].data.ano,
                  Lista.vet[j].anoNascimento.ano,
                  Lista.vet[j].eyeColour,
                  Lista.vet[j].gender,
                  Lista.vet[j].hairColour,
                  Lista.vet[j].wizard
                );
                break;
                }
            }
 }




// retorna o tamanho do arquivo
// le arquivo para struct
void importarBd(FILE *arq, array *Lista,long int sizeFile) {
  char linha[1023];
  
  arq = fopen("characters.csv", "r");

  if (arq == NULL) {
    printf("Arquivo nao encontrado");
    return;
  }

  fgets(linha, sizeof(linha), arq);

    while (fgets(linha, sizeof(linha), arq) != NULL) {
        sscanf(linha, "%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%*[^;];%*[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^\n]",
               Lista->vet[Lista->id].id,
               Lista->vet[Lista->id].name,
               Lista->vet[Lista->id].alternate_names,
               Lista->vet[Lista->id].house,
               Lista->vet[Lista->id].ancestry,
               Lista->vet[Lista->id].species,
               Lista->vet[Lista->id].patronus,
               Lista->vet[Lista->id].hogwartsStaff,
               Lista->vet[Lista->id].hogwartsStudent,
               Lista->vet[Lista->id].actorName,
               Lista->vet[Lista->id].alive,
               Lista->vet[Lista->id].data.dia,
               Lista->vet[Lista->id].data.mes,
               Lista->vet[Lista->id].data.ano,
               Lista->vet[Lista->id].anoNascimento.ano,
               Lista->vet[Lista->id].eyeColour,
               Lista->vet[Lista->id].gender,
               Lista->vet[Lista->id].hairColour,
               Lista->vet[Lista->id].wizard);

        // Update the list size and id
        Lista->id++;
        Lista->size++;
    }

    fclose(arq);
}

/*
c3b1f9a5-b87b-48bf-b00d-95b093ea6390;Ron Weasley;['Dragomir Despard', 'Ronald',
 'Ickle Ronniekins', 'Ronnie', 'Wheezy', 'Won-Won', 'Roonil Wazlib'];Gryffindor;pure-blood
;human;Jack Russell terrier;FALSO;VERDADEIRO;Rupert Grint;VERDADEIRO;[];01-03-1980;1980;blue;male;red;VERDADEIRO
*/

#endif // FUNCOES_H_INCLUDED
