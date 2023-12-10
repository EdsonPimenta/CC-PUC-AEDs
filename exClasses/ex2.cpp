#include <iostream>
using namespace std;
#include <string>
#include <string.h>
#include <ctype.h>

class Relogio{

private:
int segundo;
int minuto;
int hora;

public:
void setHora(int hora,int minuto, int segundo)
{

this->hora = hora;
this->minuto = minuto;
this->segundo = segundo;

}

void aumentaSegundo()
{
    
    segundo++;
    if(segundo>59){
        segundo = 60 - segundo;
        minuto++;
        if(minuto>59){
            minuto = 60 - minuto;
            hora++;
        }
    }
    
}

string getHora()
{
    return (to_string(hora) + ":" + to_string(minuto) + ":" + to_string(segundo));
}

};
int main()
{   
    Relogio relogio1;
    string opcao;

    int hora,minuto,segundo;
    cout<<"Digite a hora: "<<endl;
    cin>>hora;
    
    cout<<"Digite o minuto: "<<endl;
    cin>>minuto;
    
    cout<<"Digite o segu9ndo: "<<endl;
    cin>>segundo;
    relogio1.setHora(hora,minuto,segundo);
    cout<<"A hora eh:"<<relogio1.getHora()<<endl;

    cout<<"Deseja  passar para o proximo segundo[S/N]: "<<endl;
    cin>>opcao;
    //strcmp(opcao,'S'); SIM   if ( opcao == "SIM")
    if ( opcao.length() == 1 && toupper(opcao[0]) == 'S')
    {

        relogio1.aumentaSegundo();
        cout<<"A hora eh:"<<relogio1.getHora()<<endl;
    }

    



    return 0;
}