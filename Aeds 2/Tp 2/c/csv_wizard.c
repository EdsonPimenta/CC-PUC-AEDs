#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_LINE_LENGTH 1000
#define MAX_FIELD_LENGTH 100


char *processString(char string[]) {
    int count = 0;
    char* newChar = (char*) malloc((strlen(string) + 1) * 3 * sizeof(char));
    int count_ = 0;

    if (newChar == NULL) {
        printf("Memory allocation failed\n");
        exit(1);
    }

    for(int i = 0; string[i] != '\0'; i++) {

        if(string[i] == '\'') continue;

        if(string[i] == ';') { 
            newChar[count++] = ' ';
            newChar[count++] = '#';
            newChar[count++] = '#';
            newChar[count++] = ' ';
        } 
        else if(count_ == 2){   
            if (string[i] == '[') 
                newChar[count++] = '{';
            else if (string[i] == ']')
                newChar[count++] = '}';
        }
        else {
            newChar[count++] = string[i];
        }

        if(string[i] == ';') {
            count_ ++;
        }
    }

    newChar[count] = '\0';
    
    return newChar;
}


int main() {
    FILE *file;
    char filename[] = "characters.csv";
    char searchId[MAX_FIELD_LENGTH];
    char line[MAX_LINE_LENGTH];
    char line2[MAX_LINE_LENGTH];
    char foundLine[MAX_LINE_LENGTH];

    file = fopen(filename, "r");
    if (file == NULL) {
        printf("Could not open file %s\n", filename);
        return 1;
    }

    while(scanf("%s", searchId) != EOF) {

        while (fgets(line, MAX_LINE_LENGTH, file)) {
            char *token;
            char *newline;
            strcpy(line2, line);
            token = strtok(line, ";");
            if (token != NULL && strcmp(token, searchId) == 0) {
                strcpy(foundLine, line);
                newline = processString(line2);
                printf("[%s\n]", newline);
                break;
            }
        }

    }

    fclose(file);
    return 0;
}
