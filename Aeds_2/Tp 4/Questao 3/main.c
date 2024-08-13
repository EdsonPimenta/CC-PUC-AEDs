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
  struct Personagem* prox;
} Personagem;

typedef struct array {
  Personagem vet[700];
  int id;
  int size;
  Personagem* topo;
} array;

typedef struct No {
    Personagem personagem;
    struct No *esq, *dir;
} No;

typedef struct ArvoreBinaria {
    No *raiz;
} ArvoreBinaria;



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
// ----------------------------------------------- Leitura de Arquivo
void importarBd(FILE *arq, array *Lista) {
  char linha[1024];
  char tmp[100];

  // arq = fopen("characters.csv", "r");
  arq = fopen("characters.csv", "r");

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

// --------------------------printa Array------
void printaArray(array *pilha) {
  int pos = 0;
  printf(" [ Top ]\n");
  for (Personagem* i = pilha->topo; i != NULL; i = i->prox) {
        printf("[%d ## %s ## ", pos, i->id);
        printf("%s ## ", i->name);
        printf("{%s} ## ", tratandoAlternateNames(i->alternate_names));
        printf("%s ## ", i->house);
        printf("%s ## ", i->ancestry);
        printf("%s ## ", i->species);
        printf("%s ## ", i->patronus);
        printf("%s ## ", charToBoolean(i->hogwartsStaff) ? "true" : "false");
        printf("%s ## ", charToBoolean(i->hogwartsStudent) ? "true" : "false");
        printf("%s ## ", i->actorName);
        printf("%s ## ", charToBoolean(i->alive) ? "true" : "false");
        printf("%s ## ", i->DataNascimento);
        printf("%s ## ", i->anoNascimento);
        printf("%s ## ", i->eyeColour);
        printf("%s ## ", i->gender);
        printf("%s ## ", i->hairColour);
        printf("%s]\n", charToBoolean(i->wizard) ? "true" : "false");
        pos++;
  }
  printf(" [ Bottom ]\n");
}

// ------------------------------------------- SubListas
// ---------------------------------------------

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

  
  Personagem* buscaPorId(array *Lista,char id[]) {
      Personagem* temp = (Personagem*)malloc(sizeof(Personagem));
    for (int i = 0; i < Lista->size; i++) {
      if (strcmp(id, Lista->vet[i].id) == 0) {

        strcpy(temp->id, Lista->vet[i].id);
        strcpy(temp->name, Lista->vet[i].name);
        strcpy(temp->alternate_names,
               Lista->vet[i].alternate_names);
        strcpy(temp->house, Lista->vet[i].house);
        strcpy(temp->ancestry, Lista->vet[i].ancestry);
        strcpy(temp->species, Lista->vet[i].species);
        strcpy(temp->patronus, Lista->vet[i].patronus);
        strcpy(temp->hogwartsStaff,
               Lista->vet[i].hogwartsStaff);
        strcpy(temp->hogwartsStudent,
               Lista->vet[i].hogwartsStudent);
        strcpy(temp->actorName,
               Lista->vet[i].actorName);
        strcpy(temp->alive, Lista->vet[i].alive);
        strcpy(temp->DataNascimento,
               Lista->vet[i].DataNascimento);
        strcpy(temp->anoNascimento,
               Lista->vet[i].anoNascimento);
        strcpy(temp->eyeColour,
               Lista->vet[i].eyeColour);
        strcpy(temp->gender, Lista->vet[i].gender);
        strcpy(temp->hairColour,
               Lista->vet[i].hairColour);
        strcpy(temp->wizard, Lista->vet[i].wizard);
        temp->prox = NULL;
        break;
      }
    }
  return temp;
}


// ------------------------------------------- Pesquisas
void pesquisaSequencial(array Lista) {
  bool ehIgual;
  char id[200];
  int tamString;

  scanf(" %[^\n\r]", id);
  while (strcmp(id, "FIM\0") != 0) {
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


// Personagem* removerInicio(array *fila) {
//   if (fila->topo == NULL) {
//     exit(1);
//   }

//   Personagem* temp = fila->topo;
//   fila->primeiro = fila->topo->prox;
//   temp->prox = NULL;
//   if (fila->primeiro == NULL) {
//     fila->ultimo = NULL;
//   }
//   fila->size--;
//   return temp;
// }
Personagem* removerFim(array *pilha) {
  if (pilha->topo == NULL) {
    exit(1);
  }
  
  Personagem* temp = pilha->topo;
  pilha->topo = pilha->topo->prox;
  temp->prox = NULL;
  pilha->size--;
  return temp;
}


void inserirFim(array *pilha, Personagem* personagem) {
  
  if (pilha->topo == NULL) {
    pilha->topo = personagem;
  } else {
    Personagem* temp = personagem;
    temp->prox = pilha->topo;
    pilha->topo = temp;
  }
  pilha->size++;
}
void inserirRemovidos(array* pilha,Personagem* personagem){
    if (pilha->topo == NULL) {
    pilha->topo = personagem;
    }else{
      Personagem* temp = personagem;
      temp->prox = pilha->topo;
      pilha->topo = temp;
    }
}

void processaComandos(array *lista, array *pilha,array* pilhaRemovidos) {
  int qtd;
  scanf("%d", &qtd);
  getchar(); // Consumir o newline após o número

  for (int i = 0; i < qtd; i++) {
    Personagem* temp;
    char comando[100];
    scanf(" %[^\n\r]", comando);
    char *token = strtok(comando, " ");
    char *tokens[60];
    int j = 0;

    while (token != NULL) {
      tokens[j] = (char *)malloc(100 * sizeof(char));
      strcpy(tokens[j], token);
      j++;
      token = strtok(NULL, " ");
    }

    if (j > 0) {
      if (strcmp(tokens[0], "I") == 0) {
        temp = buscaPorId(lista, tokens[1]);
        inserirFim(pilha, temp);
      } else if (strcmp(tokens[0], "R") == 0) {
        temp = removerFim(pilha);
        printf("(R) %s\n",temp->name);
        inserirFim(pilhaRemovidos,temp);
      } else {
        printf("Comando não reconhecido\n");
      }

      for (int k = 0; k < j; k++) {
        free(tokens[k]);
      }
    } else {
      printf("Nenhum token encontrado\n");
    }
  
  }
}
void printaRemovidos(array* pilha){
  for(Personagem*i = pilha->topo; i !=NULL;i= i ->prox){
    printf("(R) %s\n",i->name);
  }
}

void inicializandoPilha(array* pilha, array* subLista) {
  for (int i = 0; i < subLista->size; i++) {
    Personagem* temp = (Personagem*)malloc(sizeof(Personagem));
    *temp = subLista->vet[i];
    temp->prox = NULL;
    inserirFim(pilha, temp);
  }
}
No* inserir(No *no, Personagem personagem) {
    if (no == NULL) {
        no = (No*) malloc(sizeof(No));
        no->personagem = personagem;
        no->esq = no->dir = NULL;
    } else if (strcmp(personagem.name, no->personagem.name) < 0) {
        no->esq = inserir(no->esq, personagem);
    } else if (strcmp(personagem.name, no->personagem.name) > 0) {
        no->dir = inserir(no->dir, personagem);
    }
    return no;
}

// Função para pesquisar um personagem na árvore
int pesquisar(No *no, char *nome, char *caminho) {
    if (no == NULL) {
        return 0;
    } else if (strcmp(nome, no->personagem.name) < 0) {
        strcat(caminho, " esq");
        return pesquisar(no->esq, nome, caminho);
    } else if (strcmp(nome, no->personagem.name) > 0) {
        strcat(caminho, " dir");
        return pesquisar(no->dir, nome, caminho);
    } else {
        return 1;
    }
}

// Função para ler IDs dos personagens e inserir na árvore
void lerId(ArvoreBinaria *arvore, array *personagens) {

    for (int i = 0; i < personagens->size; i++) {
        inserir(arvore->raiz, personagens->vet[i]);
    }
}

// Função para ler nomes dos personagens e pesquisar na árvore
void lerNomes(ArvoreBinaria *arvore) {
    char entradaPesquisa[50];
    char caminho[100] = "";
    int encontrado;
    while (scanf(" %[^\n\r]", entradaPesquisa) && strcmp(entradaPesquisa, "FIM") != 0) {
        encontrado = pesquisar(arvore->raiz, entradaPesquisa, caminho);
        if (encontrado) {
            strcat(caminho, " SIM");
        } else {
            strcat(caminho, " NAO");
        }
        printf("%s => raiz%s\n", entradaPesquisa, caminho);
        caminho[0] = '\0'; // Limpa o caminho para a próxima pesquisa
    }
}

// ------------------------------------------ Funcao Principal
int main() {
  array Lista;
  FILE *arq;
  Lista.size = 0;
  Lista.id = 0;

  importarBd(arq, &Lista);

  array *subListaId = subListId(&Lista);
      ArvoreBinaria arvore;
    arvore.raiz = NULL;
    
    // Inserção dos personagens na árvore
    lerId(&arvore, subListaId);
    
    // Pesquisa de personagens na árvore
    lerNomes(&arvore);


  return 0;
}
