#ifndef STRUCT_H_INCLUDED
#define STRUCT_H_INCLUDED

#include <stdio.h>


// typedef struct {
//   char dia[100];
//   char mes[100];
//   char ano[100];

// } DataNascimento;
// private String id;
//         private String name;
//         private List<String> alternate_names;
//         private String house;
//         private String ancestry;
//         private String species;
//         private String patronus;
//         private Boolean hogwartsStaff;
//         private String hogwartsStudent;
//         private String actorName;
//         private boolean alive;
//         private Date dateOfBirth;
//         private int yearOfBirth;
//         private String eyeColour;
//         private String gender;
//         private String hairColour;
//         private Boolean wizard;
// typedef struct {
  
//   char ano[100];

// } AnoNascimento;


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
  int id;
  int size;

} array;


#endif // STRUCT_H_INCLUDED
