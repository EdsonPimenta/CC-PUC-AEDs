#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef struct Alunos{ 
    char nome[50];
    char regiao;
    int distancia; 
}Alunos;
bool desempateN(Alunos a1, Alunos a2){
        if(a1.distancia > a2.distancia){
            return true;
        }
        else if(a1.distancia == a2.distancia){
                if(a1.regiao > a2.regiao){
                    return true;
                } else if (a1.regiao == a2.regiao){
                    if(strcmp(a1.nome,a2.nome) > 0){
                        return true;
                    }
                }
        }

        return false;
}

void lerAlunos(Alunos* aluno,int Q){
    for(int i = 0;i < Q;i++){
        scanf(" %s",aluno[i].nome);
        scanf(" %c",&aluno[i].regiao);
        scanf("%d",&aluno[i].distancia);
    }
}
void comparaNome(Alunos* a1, Alunos* a2){
    if(strcmp(a1->nome,a2->nome)>0){
        Alunos *aux = a1;
        *a1 = *a2;
        *a2 = *aux;
    }
}
void comparaRegiao(Alunos* alunoI, Alunos* alunoJ){
    if(alunoI->regiao > alunoJ->regiao){
        Alunos* aux = alunoI;
        *alunoI = *alunoJ;
        *alunoJ = *aux;
    }
    else if(alunoI->regiao == alunoJ->regiao){
        comparaNome(alunoI,alunoJ);
    }

}

void ordenaAlunos(Alunos* aluno,int Q){
    for(int i = 0; i < Q - 1;i++){
        int menorIndice = i;
        for(int j = i + 1;j < Q;j++){
            if(desempateN(aluno[menorIndice],  aluno[j])){
                 menorIndice = j;
             }
        }
        Alunos aux = aluno[i];
        aluno[i] = aluno[menorIndice];
        aluno[menorIndice] = aux;
        
    }
    
}
void printaAlunos(Alunos* aluno,int Q){
    for(int i = 0; i < Q;i++){
        printf("%s\n",aluno[i].nome);
    }
}

int main(){
    int Q;
    scanf("%d",&Q);
    Alunos* aluno =  (Alunos*) malloc(Q * sizeof(Alunos));
    lerAlunos(aluno, Q);
    ordenaAlunos(aluno, Q);
    printaAlunos(aluno, Q);
    free(aluno);
    


    return 0;
}
