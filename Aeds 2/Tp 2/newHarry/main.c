#include "struct.h"
#include "funcoes.h"
#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(void) {

  // objeto da struct array e ponteiro do arquivo
  array Lista;
  FILE *arq;

  // inicializando tamanho da lista de passagens e a qtd de passagens
  Lista.size = 0;
  Lista.id = 0;

  int n = 1;

  long int size = sizeOf_File(arq);
  importarBd(arq, &Lista,size);
 printf("[%s ## %s ## {%s} ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %02d/%02d/%d ## %d ## %s ## %s ## %s ## %s]\n",
                  Lista.vet[n].id,
                  Lista.vet[n].name,
                  tratandoAlternateNames(Lista.vet[n].alternate_names),
                  Lista.vet[n].house,
                  Lista.vet[n].ancestry,
                  Lista.vet[n].species,
                  Lista.vet[n].patronus,
                  Lista.vet[n].hogwartsStaff,
                  Lista.vet[n].hogwartsStudent,
                  Lista.vet[n].actorName,
                  Lista.vet[n].alive,
                  Lista.vet[n].data.dia,
                  Lista.vet[n].data.mes,
                  Lista.vet[n].data.ano,
                  Lista.vet[n].anoNascimento.ano,
                  Lista.vet[n].eyeColour,
                  Lista.vet[n].gender,
                  Lista.vet[n].hairColour,
                  Lista.vet[n].wizard
                );

  /*
c3b1f9a5-b87b-48bf-b00d-95b093ea6390;Ron Weasley;['Dragomir Despard', 'Ronald',
 'Ickle Ronniekins', 'Ronnie', 'Wheezy', 'Won-Won', 'Roonil Wazlib'];Gryffindor;pure-blood
;human;Jack Russell terrier;FALSO;VERDADEIRO;Rupert Grint;VERDADEIRO;[];01-03-1980;1980;blue;male;red;VERDADEIRO
*/

  // listaPassagens(Lista);
  pesquisaPassagem(Lista);
  printf("jorge");

  return 0;
}
