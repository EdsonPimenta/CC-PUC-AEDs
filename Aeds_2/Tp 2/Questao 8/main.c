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




// ----------------------------------------------- Leitura de Arquvo ------------------------------------
void importarBd(FILE *arq, array *Lista) {
    char linha[1024];
    char tmp[100];
  
    arq = fopen("/tmp/characters.csv", "r");
    // arq = fopen("characters.csv", "r");

    if (arq == NULL) {
        printf("Arquivo nao encontrado");
        return;
    }

    fgets(linha, sizeof(linha), arq); // Descartar a primeira linha (cabeçalho)
        // Remover o \n do final da linha, se existir

    while (!feof(arq)) {
              fscanf(arq," %[^;]",Lista->vet[Lista->id].id);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].name);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].alternate_names);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].house);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].ancestry);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].species);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].patronus);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].hogwartsStaff);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].hogwartsStudent);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].actorName);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].alive);fgetc(arq);
              fscanf(arq," %[^;]",tmp);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].DataNascimento);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].anoNascimento);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].eyeColour);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].gender);fgetc(arq);
              fscanf(arq," %[^;]",Lista->vet[Lista->id].hairColour);fgetc(arq);
              fscanf(arq," %[^\n]",Lista->vet[Lista->id].wizard);fgetc(arq);
        // Update the list size and id
        Lista->id++;
        Lista->size++;
    }
    fclose(arq);
}





// ------------------------------------------- SubListas ---------------------------------------------

// SubLista por Id
array* subListId(array* Lista){

  array *subLista = (array*) malloc(200 * sizeof(array));
  char* id = (char*) malloc(200 * sizeof(char));
  subLista->size = 0;
  scanf(" %[^\n\r]",id);
  while(strcmp(id,"FIM")){
    for(int i = 0; i < Lista->size;i++){
      if(strcmp(id,Lista->vet[i].id) == 0){
        strcpy(subLista->vet[subLista->size].id, Lista->vet[i].id);
        strcpy(subLista->vet[subLista->size].name, Lista->vet[i].name);
        strcpy(subLista->vet[subLista->size].alternate_names, Lista->vet[i].alternate_names);
        strcpy(subLista->vet[subLista->size].house, Lista->vet[i].house);
        strcpy(subLista->vet[subLista->size].ancestry, Lista->vet[i].ancestry);
        strcpy(subLista->vet[subLista->size].species, Lista->vet[i].species);
        strcpy(subLista->vet[subLista->size].patronus, Lista->vet[i].patronus);
        strcpy(subLista->vet[subLista->size].hogwartsStaff, Lista->vet[i].hogwartsStaff);
        strcpy(subLista->vet[subLista->size].hogwartsStudent, Lista->vet[i].hogwartsStudent);
        strcpy(subLista->vet[subLista->size].actorName, Lista->vet[i].actorName);
        strcpy(subLista->vet[subLista->size].alive, Lista->vet[i].alive);
        strcpy(subLista->vet[subLista->size].DataNascimento, Lista->vet[i].DataNascimento);
        strcpy(subLista->vet[subLista->size].anoNascimento, Lista->vet[i].anoNascimento);
        strcpy(subLista->vet[subLista->size].eyeColour, Lista->vet[i].eyeColour);
        strcpy(subLista->vet[subLista->size].gender, Lista->vet[i].gender);
        strcpy(subLista->vet[subLista->size].hairColour, Lista->vet[i].hairColour);
        strcpy(subLista->vet[subLista->size].wizard, Lista->vet[i].wizard);
        subLista->size++;
        break;
      }
    }
    scanf(" %[^\n\r]",id);
  }
  return subLista;
}
 

  // SubLista por nome
 array* subListNome(array* Lista){

  array *subLista = (array*) malloc(200 * sizeof(array));
  char* nome = (char*) malloc(200 * sizeof(char));
  subLista -> size = 0;
  scanf(" %[^\n\r]",nome);
  while(strcmp(nome,"FIM")){
    for(int i = 0; i < Lista->size;i++){
      if(strcmp(nome,Lista->vet[i].name) == 0){
        strcpy(subLista->vet[subLista->size].id, Lista->vet[i].id);
        strcpy(subLista->vet[subLista->size].name, Lista->vet[i].name);
        strcpy(subLista->vet[subLista->size].alternate_names, Lista->vet[i].alternate_names);
        strcpy(subLista->vet[subLista->size].house, Lista->vet[i].house);
        strcpy(subLista->vet[subLista->size].ancestry, Lista->vet[i].ancestry);
        strcpy(subLista->vet[subLista->size].species, Lista->vet[i].species);
        strcpy(subLista->vet[subLista->size].patronus, Lista->vet[i].patronus);
        strcpy(subLista->vet[subLista->size].hogwartsStaff, Lista->vet[i].hogwartsStaff);
        strcpy(subLista->vet[subLista->size].hogwartsStudent, Lista->vet[i].hogwartsStudent);
        strcpy(subLista->vet[subLista->size].actorName, Lista->vet[i].actorName);
        strcpy(subLista->vet[subLista->size].alive, Lista->vet[i].alive);
        strcpy(subLista->vet[subLista->size].DataNascimento, Lista->vet[i].DataNascimento);
        strcpy(subLista->vet[subLista->size].anoNascimento, Lista->vet[i].anoNascimento);
        strcpy(subLista->vet[subLista->size].eyeColour, Lista->vet[i].eyeColour);
        strcpy(subLista->vet[subLista->size].gender, Lista->vet[i].gender);
        strcpy(subLista->vet[subLista->size].hairColour, Lista->vet[i].hairColour);
        strcpy(subLista->vet[subLista->size].wizard, Lista->vet[i].wizard);
        subLista->size++;
        break;
      }
    }
    scanf(" %[^\n\r]",nome);
  }
  return subLista;
}
 

  // ----------------------------------------- Ordencação ---------------------------------------------
  void swap(array* subListaId,int i, int menorIndice){
        Personagem tmp = subListaId->vet[i];
        subListaId->vet[i] = subListaId->vet[menorIndice];
        subListaId->vet[menorIndice] = tmp;
  }
// insertion por nome
void insertionSort(array* lista){


  for(int i = 1; i  < lista->size;i++){
        Personagem aux;
        strcpy(aux.id,lista->vet[i].id);
        strcpy(aux.name, lista->vet[i].name);
        strcpy(aux.alternate_names, lista->vet[i].alternate_names);
        strcpy(aux.house, lista->vet[i].house);
        strcpy(aux.ancestry, lista->vet[i].ancestry);
        strcpy(aux.species, lista->vet[i].species);
        strcpy(aux.patronus, lista->vet[i].patronus);
        strcpy(aux.hogwartsStaff, lista->vet[i].hogwartsStaff);
        strcpy(aux.hogwartsStudent, lista->vet[i].hogwartsStudent);
        strcpy(aux.actorName, lista->vet[i].actorName);
        strcpy(aux.alive, lista->vet[i].alive);
        strcpy(aux.DataNascimento, lista->vet[i].DataNascimento);
        strcpy(aux.anoNascimento, lista->vet[i].anoNascimento);
        strcpy(aux.eyeColour, lista->vet[i].eyeColour);
        strcpy(aux.gender, lista->vet[i].gender);
        strcpy(aux.hairColour, lista->vet[i].hairColour);
        strcpy(aux.wizard, lista->vet[i].wizard);
      
      int j = i - 1;  
      while(j>=0 && strcmp(lista->vet[j].name, aux.name ) > 0){
        strcpy(lista->vet[j+1].id,lista->vet[j].id);
        strcpy(lista->vet[j+1].name, lista->vet[j].name);
        strcpy(lista->vet[j+1].alternate_names, lista->vet[j].alternate_names);
        strcpy(lista->vet[j+1].house, lista->vet[j].house);
        strcpy(lista->vet[j+1].ancestry, lista->vet[j].ancestry);
        strcpy(lista->vet[j+1].species, lista->vet[j].species);
        strcpy(lista->vet[j+1].patronus, lista->vet[j].patronus);
        strcpy(lista->vet[j+1].hogwartsStaff, lista->vet[j].hogwartsStaff);
        strcpy(lista->vet[j+1].hogwartsStudent, lista->vet[j].hogwartsStudent);
        strcpy(lista->vet[j+1].actorName, lista->vet[j].actorName);
        strcpy(lista->vet[j+1].alive, lista->vet[j].alive);
        strcpy(lista->vet[j+1].DataNascimento, lista->vet[j].DataNascimento);
        strcpy(lista->vet[j+1].anoNascimento, lista->vet[j].anoNascimento);
        strcpy(lista->vet[j+1].eyeColour, lista->vet[j].eyeColour);
        strcpy(lista->vet[j+1].gender, lista->vet[j].gender);
        strcpy(lista->vet[j+1].hairColour, lista->vet[j].hairColour);
        strcpy(lista->vet[j+1].wizard, lista->vet[i].wizard);
        j--; 
      }    
        strcpy(lista->vet[j+1].id, aux.id);
        strcpy(lista->vet[j+1].name, aux.name);
        strcpy(lista->vet[j+1].alternate_names, aux.alternate_names);
        strcpy(lista->vet[j+1].house, aux.house);
        strcpy(lista->vet[j+1].ancestry, aux.ancestry);
        strcpy(lista->vet[j+1].species, aux.species);
        strcpy(lista->vet[j+1].patronus, aux.patronus);
        strcpy(lista->vet[j+1].hogwartsStaff, aux.hogwartsStaff);
        strcpy(lista->vet[j+1].hogwartsStudent, aux.hogwartsStudent);
        strcpy(lista->vet[j+1].actorName, aux.actorName);
        strcpy(lista->vet[j+1].alive, aux.alive);
        strcpy(lista->vet[j+1].DataNascimento, aux.DataNascimento);
        strcpy(lista->vet[j+1].anoNascimento, aux.anoNascimento);
        strcpy(lista->vet[j+1].eyeColour, aux.eyeColour);
        strcpy(lista->vet[j+1].gender, aux.gender);
        strcpy(lista->vet[j+1].hairColour, aux.hairColour);
        strcpy(lista->vet[j+1].wizard, aux.wizard);

    }
  }
  // selection sort recursivo
  void selectionSort(array* subListaId, int i) {
    if (i >= subListaId->size - 1) {
        return;
    } 
    int menorIndice = i;
    for (int j = i + 1; j < subListaId->size; j++) {
        if (strcmp(subListaId->vet[j].name, subListaId->vet[menorIndice].name) < 0) {
            menorIndice = j;
        }
    }
        
    swap(subListaId, i, menorIndice);
    selectionSort(subListaId, ++i);
}
  int comparaDesempate(Personagem p1, Personagem p2){
    int resp = strcmp(p1.eyeColour,p2.eyeColour);
    if(resp == 0){
      resp =  strcmp(p1.name,p2.name);
    }
    return resp;
  }

    void insercaoPorCor(int cor, int h,array* subListaId){
      for (int i = (h + cor); i < subListaId->size; i+=h) {
         Personagem tmp = subListaId->vet[i];
         int j = i - h;
        //  strcmp(subListaId->vet[j].eyeColour, tmp.eyeColour) > 0
         while ((j >= 0) && (comparaDesempate(subListaId->vet[j],tmp))>0) {
            subListaId->vet[j + h] = subListaId->vet[j];
            j-=h;
         }
         subListaId->vet[j + h] = tmp;
      }
   }
// shell sort por eye colour
 void shellSort(array* subListaId) {
      int h = 1;

      do { h = (h * 3) + 1; } while (h < subListaId->size);

      do {
         h /= 3;
         for(int cor = 0; cor < h; cor++){
            insercaoPorCor(cor,h,subListaId);
         }
      } while (h != 1);
   }



  // ----- Fim shellSort -------
  // ----- Inicio quickSort ----
  void quicksortRec(array* subListaId, int esq, int dir) {
    int i = esq, j = dir;
    Personagem pivo = subListaId->vet[(dir+esq)/2];
    while (i <= j) {
        while (strcmp(subListaId->vet[i].house, pivo.house)<0) i++;
        while (strcmp(subListaId->vet[j].house, pivo.house)>0) j--;
        if (i <= j) {
            swap(array + i, array + j);
            i++;
            j--;
        }
    }
    if (esq < j)  quicksortRec(array, esq, j);
    if (i < dir)  quicksortRec(array, i, dir);
}
//=============================================================================
void quicksort(array* subListaId, int n) {
    quicksortRec(array, 0, n-1);
}

// -------------------------------------------- Funções de tratamento ---------------------------
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
bool charToBoolean(char c[]) {

    if(strcmp(c,"VERDADEIRO") == 0)
      return true;
    
    else
      return false;
}
// ------------------------------------------- Pesquisas ---------------------------------
void pesquisaSequencial(array Lista) {

  bool ehIgual;
  bool ehTrue;
  char id[200];
  int tamString;

        ehTrue = false;

        // lê id do teclado
         
        scanf(" %[^\n\r]",id);
        while(strcmp(id,"FIM\0")){
        tamString = strlen(id);
        for (int j = 0; j < Lista.size; j++) {
            ehIgual = true;
            for (int i = 0; i < tamString; i++) {
                if (id[i] != Lista.vet[j].id[i]) {
                  ehIgual = false;
                }
                }
                if (ehIgual) {
                  printf("[%s ## ",Lista.vet[j].id);
                  printf("%s ## ",Lista.vet[j].name);
                  printf("{%s} ## ",tratandoAlternateNames(Lista.vet[j].alternate_names));
                  printf("%s ## ",Lista.vet[j].house);
                  printf("%s ## ",Lista.vet[j].ancestry);
                  printf("%s ## ",Lista.vet[j].species);
                  printf("%s ## ",Lista.vet[j].patronus);
                  
                  if(charToBoolean( Lista.vet[j].hogwartsStaff)){
                    printf("false ## ");
                  }
                  else
                    printf("true ## ");

                  if(charToBoolean( Lista.vet[j].hogwartsStudent)){
                    printf("false ## ");
                  }
                  else
                    printf("true ## ");                 
                  
                   printf("%s ## ",Lista.vet[j].actorName);

                  if(charToBoolean(Lista.vet[j].alive))
                    printf("true ## ");
                  else
                    printf("false ## ");

                  
                  printf("%s ## ",Lista.vet[j].DataNascimento);
                  printf("%s ## ",Lista.vet[j].anoNascimento);
                  printf("%s ## ",Lista.vet[j].eyeColour);
                  printf("%s ## ",Lista.vet[j].gender);
                  printf("%s ## ",Lista.vet[j].hairColour);
                  if(charToBoolean(Lista.vet[j].wizard))
                    printf("true]\n");
                  else
                    printf("false]\n");
                }
            }
          scanf(" %[^\n\r]",id);
        }
 }
void pesquisaBinaria(array* subListaNome, array* subListaId) {
    // Ordena a subListaNome por nome antes de realizar a pesquisa binária
    insertionSort(subListaId);

    // Realiza a pesquisa binária
    for (int i = 0; i < subListaNome->size; i++) {
        bool foiEncontrado = false;
        int esquerda = 0;
        int direita = subListaId->size - 1;
  
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            int comparacao = strcmp(subListaId->vet[meio].name,subListaNome->vet[i].name);

            if (comparacao == 0) {
                foiEncontrado = true;
                break; // Encerra o loop enquanto se o ID for encontrado
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        // Imprime "SIM" se foi encontrado ou "NAO" caso contrário
        if (foiEncontrado == true) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }
}
void pesquisaSequencialSublists(array* subListaNome, array* subListaId) {

    for (int i = 0; i < subListaNome->size; i++) {
      bool foiEncontrado = false;
      for(int j = 0; j < subListaId->size;j++){
        if(strcmp(subListaNome->vet[i].id,subListaId->vet[j].id) == 0){
          foiEncontrado = true;
          break;
        }
      }
        // Imprime "SIM" se foi encontrado ou "NAO" caso contrário
        if (foiEncontrado == true) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }
}

    
   
void printaArray(array* Lista){
            for (int j = 0; j < Lista->size; j++) {
                  printf("[%s ## ",Lista->vet[j].id);
                  printf("%s ## ",Lista->vet[j].name);
                  printf("{%s} ## ",tratandoAlternateNames(Lista->vet[j].alternate_names));
                  printf("%s ## ",Lista->vet[j].house);
                  printf("%s ## ",Lista->vet[j].ancestry);
                  printf("%s ## ",Lista->vet[j].species);
                  printf("%s ## ",Lista->vet[j].patronus);
                  if(charToBoolean( Lista->vet[j].hogwartsStaff)){
                    printf("true ## ");
                  }
                  else
                    printf("false ## ");

                  if(charToBoolean( Lista->vet[j].hogwartsStudent)){
                    printf("true ## ");
                  }
                  else
                    printf("false ## ");                 
                  
                   printf("%s ## ",Lista->vet[j].actorName);

                  if(charToBoolean(Lista->vet[j].alive))
                    printf("true ## ");
                  else
                    printf("false ## ");

                  
                  printf("%s ## ",Lista->vet[j].DataNascimento);
                  printf("%s ## ",Lista->vet[j].anoNascimento);
                  printf("%s ## ",Lista->vet[j].eyeColour);
                  printf("%s ## ",Lista->vet[j].gender);
                  printf("%s ## ",Lista->vet[j].hairColour);
                  if(charToBoolean(Lista->vet[j].wizard))
                    printf("true]\n");
                  else
                    printf("false]\n");
                }
}


// ------------------------------------------ Funcao Principal ------------------------------
int main() {
  // objeto da struct array e ponteiro do arquivo
  array Lista;
  FILE *arq;
  
  // inicializando tamanho da lista de personagens e a qtd de personagens
  Lista.size = 0;
  Lista.id = 0;

  importarBd(arq, &Lista);

  array* subListaId = subListId(&Lista);
  // array* subListaNome = subListNome(&Lista);
  // insertionSort(subListaId);
  // pesquisaSequencialSublists(subListaNome,subListaId);
  // pesquisaBinaria(subListaNome,subListaId);
  // selectionSort(subListaId,0);
  // shellSort(subListaId);
  insertionSort(subListaId);
  quickSort(subListaId,subListaId->size);
  printaArray(subListaId);
  
  
  // printf("\n\n----------Printa array por nome----------\n\n");
  // printaArray(subListaNome);
  // printf("\n\n----------Printa array por id--------\n\n");

  return 0;
}

