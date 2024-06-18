#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
// -------------------------- Struct ------------------------------------------
typedef struct Personagem {
  char id[100];
  char name[100];
  char alternate_names[500];
  char house[100];
  char ancestry[100];
  char species[100];
  char patronus[100];
  char hogwartsStaff[100];
  char hogwartsStudent[100];
  char actorName[100];
  char alive[100];
  char DataNascimento[100];
  char anoNascimento[100];
  char eyeColour[100];
  char gender[100];
  char hairColour[100];
  char wizard[100];
} Personagem;

typedef struct array {
  Personagem vet[700];
  Personagem clone;
  int id;
  int size;

} array;

// ----------------------------------------------- Leitura de Arquvo
// ------------------------------------
void importarBd(FILE *arq, array *Lista) {
  char linha[1024];
  char tmp[100];

  // arq = fopen("characters.csv", "r");
  arq = fopen("/tmp/characters.csv", "r");

  if (arq == NULL) {
    printf("Arquivo nao encontrado");
    return;
  }

  fgets(linha, sizeof(linha),
        arq); // Descartar a primeira linha (cabeçalho)
              // Remover o \n do final da linha, se existir

  while (!feof(arq)) {
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].id);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].name);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].alternate_names);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].house);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].ancestry);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].species);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].patronus);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].hogwartsStaff);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].hogwartsStudent);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].actorName);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].alive);
    fgetc(arq);
    fscanf(arq, " %[^;]", tmp);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].DataNascimento);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].anoNascimento);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].eyeColour);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].gender);
    fgetc(arq);
    fscanf(arq, " %[^;]", Lista->vet[Lista->id].hairColour);
    fgetc(arq);
    fscanf(arq, " %[^\n]", Lista->vet[Lista->id].wizard);
    fgetc(arq);
    // Update the list size and id
    Lista->id++;
    Lista->size++;
  }
  fclose(arq);
}
// -------------------------------------------- Funções de tratamento
// ---------------------------
char *tratandoAlternateNames(char string[]) {
  int count = 0;
  char *newChar = (char *)malloc((strlen(string) + 1) * sizeof(char));
  for (int i = 0; string[i] != '\0'; i++) {

    if (string[i] == '\'' || string[i] == '[' || string[i] == ']')
      continue;
    newChar[count++] = string[i];
  }
  newChar[count] = '\0';

  return newChar;
}
bool charToBoolean(char c[]) {

  if (strcmp(c, "VERDADEIRO") == 0)
    return true;

  else
    return false;
}

// --------------------------printa Array------
void printaArray(array *Lista) {
  for (int j = 0; j < Lista->size; j++) {
    printf("[%d ## %s ## ",j, Lista->vet[j].id);
    printf("%s ## ", Lista->vet[j].name);
    printf("{%s} ## ", tratandoAlternateNames(Lista->vet[j].alternate_names));
    printf("%s ## ", Lista->vet[j].house);
    printf("%s ## ", Lista->vet[j].ancestry);
    printf("%s ## ", Lista->vet[j].species);
    printf("%s ## ", Lista->vet[j].patronus);
    if (charToBoolean(Lista->vet[j].hogwartsStaff)) {
      printf("true ## ");
    } else
      printf("false ## ");

    if (charToBoolean(Lista->vet[j].hogwartsStudent)) {
      printf("true ## ");
    } else
      printf("false ## ");

    printf("%s ## ", Lista->vet[j].actorName);

    if (charToBoolean(Lista->vet[j].alive))
      printf("true ## ");
    else
      printf("false ## ");

    printf("%s ## ", Lista->vet[j].DataNascimento);
    printf("%s ## ", Lista->vet[j].anoNascimento);
    printf("%s ## ", Lista->vet[j].eyeColour);
    printf("%s ## ", Lista->vet[j].gender);
    printf("%s ## ", Lista->vet[j].hairColour);
    if (charToBoolean(Lista->vet[j].wizard))
      printf("true]\n");
    else
      printf("false]\n");
  }
}
// ------------------------------------------- SubListas
// ---------------------------------------------

// SubLista por Id
array *subListId(array *Lista) {

  array *subLista = (array *)malloc(200 * sizeof(array));
  char *id = (char *)malloc(200 * sizeof(char));
  subLista->size = 0;
  scanf(" %[^\n\r]", id);
  while (strcmp(id, "FIM")) {
    for (int i = 0; i < Lista->size; i++) {
      if (strcmp(id, Lista->vet[i].id) == 0) {
        strcpy(subLista->vet[subLista->size].id, Lista->vet[i].id);
        strcpy(subLista->vet[subLista->size].name, Lista->vet[i].name);
        strcpy(subLista->vet[subLista->size].alternate_names,
               Lista->vet[i].alternate_names);
        strcpy(subLista->vet[subLista->size].house, Lista->vet[i].house);
        strcpy(subLista->vet[subLista->size].ancestry, Lista->vet[i].ancestry);
        strcpy(subLista->vet[subLista->size].species, Lista->vet[i].species);
        strcpy(subLista->vet[subLista->size].patronus, Lista->vet[i].patronus);
        strcpy(subLista->vet[subLista->size].hogwartsStaff,
               Lista->vet[i].hogwartsStaff);
        strcpy(subLista->vet[subLista->size].hogwartsStudent,
               Lista->vet[i].hogwartsStudent);
        strcpy(subLista->vet[subLista->size].actorName,
               Lista->vet[i].actorName);
        strcpy(subLista->vet[subLista->size].alive, Lista->vet[i].alive);
        strcpy(subLista->vet[subLista->size].DataNascimento,
               Lista->vet[i].DataNascimento);
        strcpy(subLista->vet[subLista->size].anoNascimento,
               Lista->vet[i].anoNascimento);
        strcpy(subLista->vet[subLista->size].eyeColour,
               Lista->vet[i].eyeColour);
        strcpy(subLista->vet[subLista->size].gender, Lista->vet[i].gender);
        strcpy(subLista->vet[subLista->size].hairColour,
               Lista->vet[i].hairColour);
        strcpy(subLista->vet[subLista->size].wizard, Lista->vet[i].wizard);
        subLista->size++;
        break;
      }
    }
    scanf(" %[^\n\r]", id);
  }
  return subLista;
}
Personagem buscaPorId(array *Lista,char id[]) {
    Personagem temp;
    for (int i = 0; i < Lista->size; i++) {
      if (strcmp(id, Lista->vet[i].id) == 0) {

        strcpy(temp.id, Lista->vet[i].id);
        strcpy(temp.name, Lista->vet[i].name);
        strcpy(temp.alternate_names,
               Lista->vet[i].alternate_names);
        strcpy(temp.house, Lista->vet[i].house);
        strcpy(temp.ancestry, Lista->vet[i].ancestry);
        strcpy(temp.species, Lista->vet[i].species);
        strcpy(temp.patronus, Lista->vet[i].patronus);
        strcpy(temp.hogwartsStaff,
               Lista->vet[i].hogwartsStaff);
        strcpy(temp.hogwartsStudent,
               Lista->vet[i].hogwartsStudent);
        strcpy(temp.actorName,
               Lista->vet[i].actorName);
        strcpy(temp.alive, Lista->vet[i].alive);
        strcpy(temp.DataNascimento,
               Lista->vet[i].DataNascimento);
        strcpy(temp.anoNascimento,
               Lista->vet[i].anoNascimento);
        strcpy(temp.eyeColour,
               Lista->vet[i].eyeColour);
        strcpy(temp.gender, Lista->vet[i].gender);
        strcpy(temp.hairColour,
               Lista->vet[i].hairColour);
        strcpy(temp.wizard, Lista->vet[i].wizard);
        break;
      }
    }
  return temp;
}


// ------------------------------------------- Pesquisas
// ---------------------------------
void pesquisaSequencial(array Lista) {

  bool ehIgual;
  bool ehTrue;
  char id[200];
  int tamString;

  ehTrue = false;

  // lê id do teclado

  scanf(" %[^\n\r]", id);
  while (strcmp(id, "FIM\0")) {
    tamString = strlen(id);
    for (int j = 0; j < Lista.size; j++) {
      ehIgual = true;
      for (int i = 0; i < tamString; i++) {
        if (id[i] != Lista.vet[j].id[i]) {
          ehIgual = false;
        }
      }
      if (ehIgual) {
        printf("[%s ## ", Lista.vet[j].id);
        printf("%s ## ", Lista.vet[j].name);
        printf("{%s} ## ",
               tratandoAlternateNames(Lista.vet[j].alternate_names));
        printf("%s ## ", Lista.vet[j].house);
        printf("%s ## ", Lista.vet[j].ancestry);
        printf("%s ## ", Lista.vet[j].species);
        printf("%s ## ", Lista.vet[j].patronus);

        if (charToBoolean(Lista.vet[j].hogwartsStaff)) {
          printf("false ## ");
        } else
          printf("true ## ");

        if (charToBoolean(Lista.vet[j].hogwartsStudent)) {
          printf("false ## ");
        } else
          printf("true ## ");

        printf("%s ## ", Lista.vet[j].actorName);

        if (charToBoolean(Lista.vet[j].alive))
          printf("true ## ");
        else
          printf("false ## ");

        printf("%s ## ", Lista.vet[j].DataNascimento);
        printf("%s ## ", Lista.vet[j].anoNascimento);
        printf("%s ## ", Lista.vet[j].eyeColour);
        printf("%s ## ", Lista.vet[j].gender);
        printf("%s ## ", Lista.vet[j].hairColour);
        if (charToBoolean(Lista.vet[j].wizard))
          printf("true]\n");
        else
          printf("false]\n");
      }
    }
    scanf(" %[^\n\r]", id);
  }
}

void inserirInicio(array *lista,Personagem personagem) {
  for(int i = lista->size; i > 0;i--){
    lista->vet[i] = lista->vet[i-1];
  }
  lista->vet[0] = personagem;
  lista->size++;
}
void inserirFim(array *lista,Personagem personagem) {
  lista->vet[lista->size] = personagem;
  lista->size++;
}
void inserir(array *lista,int pos,Personagem personagem) {
  for(int i = lista->size; i > pos;i--){
    lista->vet[i] = lista->vet[i-1];
  }
  lista->vet[pos] = personagem;
  lista->size++;
}

Personagem removerInicio(array *lista) {
  Personagem temp = lista->vet[0];
  for(int i = 0; i < lista->size - 1;i++){
    lista->vet[i] = lista->vet[i+1];
  }
    lista->size--;

  return temp;
}
Personagem removerFim(array *lista) {
  lista->size--;
  Personagem temp = lista->vet[lista->size];
  return temp;
}
Personagem remover(int pos,array *lista) {
  Personagem temp = lista->vet[pos];
  for(int i = pos; i < lista->size - 1;i++){
    lista->vet[i] = lista->vet[i+1];
  }
    lista->size--;
  return temp;

}

void processaComandos(array* lista,array* subLista,array* removidos) {
    int qtd;
    scanf("%d", &qtd);
    getchar(); // Consumir o newline após o número

    for (int i = 0; i < qtd; i++) {
        Personagem temp;
        char comando[100];
        scanf(" %[^\n\r]",comando);
        char *token = strtok(comando, " ");
        char *tokens[60];
        int j = 0;

        while (token != NULL) {
            // Alocar memória para o token e copiá-lo para o array
            tokens[j] = (char *)malloc(100 * sizeof(char));
            strcpy(tokens[j], token);
            j++;
            token = strtok(NULL, " ");
        }

        if (j > 0) {
            if (strcmp(tokens[0], "II") == 0) {
                temp = buscaPorId(lista, tokens[1]);
                inserirInicio(subLista, temp);
            } else if (strcmp(tokens[0], "I*") == 0) {
                temp = buscaPorId(lista, tokens[2]);
                inserir(subLista, atoi(tokens[1]), temp);
            } else if (strcmp(tokens[0], "IF") == 0) {
                temp = buscaPorId(lista, tokens[1]);
                inserirFim(subLista, temp);
            } else if (strcmp(tokens[0], "RI") == 0) {
                removidos->vet[removidos->size++] = removerInicio(subLista);
            } else if (strcmp(tokens[0], "R*") == 0) {
               removidos->vet[removidos->size++] = remover(atoi(tokens[1]), subLista);
            } else if (strcmp(tokens[0], "RF") == 0) {
                removidos->vet[removidos->size++] = removerFim(subLista);
            } else {
                // Caso default
                printf("Comando não reconhecido\n");
            }

            // Liberar memória alocada para os tokens
            for (int k = 0; k < j; k++) {
                free(tokens[k]);
            }
        } else {
            printf("Nenhum token encontrado\n");
        }
    }

}

void removidos(array listaRemovidos) {
  for (int i = 0; i < listaRemovidos.size; i++) {
    printf("(R) %s\n", listaRemovidos.vet[i].name);
  }
}

// ------------------------------------------ Funcao Principal
// ------------------------------
int main() {
  // objeto da struct array e ponteiro do arquivo
  array Lista;
  FILE *arq;

  // inicializando tamanho da lista de personagens e a qtd de personagens
  Lista.size = 0;
  Lista.id = 0;
  array listaRemovidos;
  listaRemovidos.size = 0;
  importarBd(arq, &Lista);
  // printaArray(&Lista);
  array *subListaId = subListId(&Lista);
  // printaArray(subListaId);
  processaComandos(&Lista,subListaId,&listaRemovidos);
  removidos(listaRemovidos);
  printaArray(subListaId);

  return 0;
}
