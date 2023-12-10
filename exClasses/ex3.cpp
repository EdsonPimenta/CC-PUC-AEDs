#include <iostream>
using namespace std;

class Carro{

private:
int distancia;
int litros;
public:

void setDistancia(int distancia)
{
    this->distancia = distancia;
}
void setLitros(int litros)
{
    this->litros = litros;
}
int getDistancia(){
    return distancia;
}
int getLitros(){
    return litros;
}
};




int main()
{
    int deslocamento;
    int litros;
    int distanciaPercorrida[2];
    int combustivelRestante;

    Carro carro[2];

    for(int i = 0;i<2;i++)
    {
        cout<<"Digite o deslocamento do carro: "<<endl;
        cin>>deslocamento;
        cout<<"Digite o combustivel do carro: "<<endl;
        cin>>litros;
        carro[i].setDistancia(deslocamento);
        carro[i].setLitros(litros);
    }

    
    for(int i = 0;i<2;i++){
    distanciaPercorrida[i] = 15*carro[i].getLitros();
    
    if(distanciaPercorrida[i]<carro[i].getDistancia())
    {
        cout<<"Faltou combusivel"<<endl;
        cout<<"Distancia percorrida eh: "<<distanciaPercorrida[i]<<endl;
    }
    else if(distanciaPercorrida[i]>=carro[i].getDistancia()){
        combustivelRestante = (distanciaPercorrida[i] - carro[i].getDistancia())/15;
        cout<<"Ainda resta "<<combustivelRestante<<" listros"<<endl;
        cout<<"Distancia percorrida eh: "<<carro[i].getDistancia()<<endl;
  

    }
    
    }
    


    
    

    



    return 0;
}