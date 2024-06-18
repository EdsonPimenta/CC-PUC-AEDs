import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.io.*;
import java.nio.charset.*;

class Personagem {
    private String id;
    private String name;
    private List<String> alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private Boolean hogwartsStaff;
    private Boolean hogwartsStudent;
    private String actorName;
    private Boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;
    Personagem prox;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Construtor default
    Personagem() {
        this.prox = null;
        this.id = null;
        this.name = null;
        this.alternate_names = null;
        this.house = null;
        this.ancestry = null;
        this.species = null;
        this.patronus = null;
        this.hogwartsStaff = null;
        this.hogwartsStudent = null;
        this.actorName = null;
        this.alive = null;
        this.dateOfBirth = null;
        this.yearOfBirth = 0;
        this.eyeColour = null;
        this.gender = null;
        this.hairColour = null;
        this.wizard = null;
        this.dateFormat = null;

    }

    // Construtor da classe
    public Personagem(String id, String name, List<String> alternate_names, String house, String ancestry,
            String species, String patronus, Boolean hogwartsStaff, Boolean hogwartsStudent,
            String actorName, boolean alive, Date dateOfBirth, int yearOfBirth, String eyeColour,
            String gender, String hairColour, Boolean wizard, DateFormat dateFormat) {
        this.id = id;
        this.name = name;
        this.alternate_names = alternate_names;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
        this.dateFormat = dateFormat;
        this.prox = null;
    }

    public Personagem(String[] aux) throws ParseException {
        int j = 0;
        this.id = aux[j++];
        this.name = aux[j++];
        String[] aux2 = aux[j++].split(",");
        this.alternate_names = new ArrayList<>();
        for (String s : aux2) {
            alternate_names.add(s);
        }
        this.house = aux[j++];
        this.ancestry = aux[j++];
        this.species = aux[j++];
        this.patronus = aux[j++];

        // hogwarts staff
        if (aux[j++].charAt(0) == 'V')
            this.hogwartsStaff = true;
        else
            this.hogwartsStaff = false;

        // hogwarts student
        if (aux[j++].charAt(0) == 'V')
            this.hogwartsStudent = true;
        else
            this.hogwartsStudent = false;

        this.actorName = aux[j++];

        // alive
        if (aux[j++].charAt(0) == 'V')
            this.alive = true;
        else
            this.alive = false;

        // pulando actor name
        j++;
        this.dateOfBirth = dateFormat.parse(aux[j++]);
        this.yearOfBirth = Integer.parseInt(aux[j++]);
        this.eyeColour = aux[j++];
        this.gender = aux[j++];
        this.hairColour = aux[j++];

        // wizard
        if (aux[j++].charAt(0) == 'V')
            this.wizard = true;
        else
            this.wizard = false;
        this.prox = null;

    }

    // printa array de personagem
    public void printPersonagem(int i) {
        int j = 0;
        System.out.print("[" + i + " ## " + id + " ## " +
                name + " ## " +
                "{");
        for (String s : alternate_names) {
            j++;
            System.out.print(s);
            if (j < alternate_names.size()) {
                System.out.print(",");
            }
        }
        System.out.println("}" + " ## " +
                house + " ## " +
                ancestry + " ## " +
                species + " ## " +
                patronus + " ## " +
                hogwartsStaff + " ## " +
                hogwartsStudent + " ## " +
                actorName + " ## " +
                alive + " ## " +
                dateFormat.format(dateOfBirth) + " ## " +
                yearOfBirth + " ## " +
                eyeColour + " ## " +
                gender + " ## " +
                hairColour + " ## " +
                wizard +
                "]");

    }

    // ------------------ Setters --------------------------------------------------
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlternateNames(List<String> alternate_names) {
        this.alternate_names = alternate_names;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public void setHogwartsStudent(Boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setWizard(Boolean wizard) {
        this.wizard = wizard;
    }
    public void setProx(Personagem prox){
        this.prox = prox;
    }

    // ---------------------------- Getters
    // ----------------------------------------------
    public Boolean getWizard() {
        return wizard;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean getIsAlive() {
        return alive;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getAlternateNames() {
        return alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public String getPatronus() {
        return patronus;
    }

    public Boolean isHogwartsStaff() {
        return hogwartsStaff;
    }

    public Boolean getHogwartsStudent() {
        return hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColour() {
        return hairColour;
    }
    public Personagem getProx(){
        return prox;
    }

    // printa array list de personagem
    public static void printaArray(Personagem primeiro) {
        int pos = 0;
        Personagem i = primeiro.prox;
        while (i != null) {
            i.printPersonagem(pos);;
            i = i.prox;
            pos++;
        }
    }

    // clone do personagem
    public Personagem getClone(Personagem personagems) {
        return new Personagem(personagems.id,
                personagems.name,
                personagems.alternate_names,
                personagems.house,
                personagems.ancestry,
                personagems.species,
                personagems.patronus,
                personagems.hogwartsStaff,
                personagems.hogwartsStudent,
                personagems.actorName,
                personagems.alive,
                personagems.dateOfBirth,
                personagems.yearOfBirth,
                personagems.eyeColour,
                personagems.gender,
                personagems.hairColour,
                personagems.wizard,
                personagems.dateFormat);
    }

}

// -------------------Ler
// arquivo---------------------------------------------------
class LerArquivo {

    public static ArrayList<Personagem> lerArquivo() throws ParseException {
        ArrayList<Personagem> array = new ArrayList<Personagem>();
        // tratamento de excessao
        try {
            RandomAccessFile arq = new RandomAccessFile("/tmp/characters.csv", "r");
            arq.seek(0);
            arq.readLine();
            for (long i = 0; i < arq.length(); i = arq.getFilePointer()) {
                String WordPersonagem = "";
                String aux2 = "";
                String aux[];
                WordPersonagem += arq.readLine();
                for (int j = 0; j < WordPersonagem.length(); j++) {
                    if (WordPersonagem.charAt(j) != '[' && WordPersonagem.charAt(j) != ']'
                            && WordPersonagem.charAt(j) != '\'') {
                        aux2 += WordPersonagem.charAt(j);
                    }
                }
                aux = aux2.split(";", 18);// split
                Personagem personagem = new Personagem(aux);
                array.add(personagem);

            }
            arq.close();// fechando arquivo

        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

}

// ---------------------- Crio SubList de personagem com base no id
// ------------------------------

class SubLists {
    // retorna personagem buscando por id
    public static Personagem buscaPorId(String myId, ArrayList<Personagem> personagem) {
        Personagem personagem1 = null;
        for (Personagem p : personagem) {
            if (p.getId().equals(myId)) {
                personagem1 = p.getClone(p);
                continue;
            }
        }
        return personagem1;
    }

    // add sublist por id
    public static ArrayList<Personagem> addSubList1(ArrayList<Personagem> personagem, Scanner scanner) {
        // Scanner scanner = (new Scanner(System.in)).useDelimiter("\r\n");
        String myId;
        ArrayList<Personagem> subList1 = new ArrayList<Personagem>();
        while (!(myId = scanner.nextLine()).equals("FIM")) {
            if (SubLists.buscaPorId(myId, personagem) == null)
                continue;
            subList1.add(SubLists.buscaPorId(myId, personagem));
        }
        return subList1;

    }

}

// --------------------------------------------Ordenacao
// ---------------------------------------------
class Ordenacao {

}

class Lista {
    private int tamanho;
    Personagem primeiro,ultimo,primeiroRemovidos,ultimoRemovidos;

    Lista() {
         primeiro = ultimo = new Personagem();
         primeiroRemovidos = ultimoRemovidos = new Personagem();
    }
    
        
    

     // ----- inserção -----
     public void inserirInicio(Personagem personagem){
        Personagem tmp = personagem.getClone(personagem);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if(primeiro == ultimo){
            ultimo = tmp;
        }
        tmp = null; // organização
        tamanho++;
     }
     public void inserirFim(Personagem personagem){
        ultimo.prox = personagem;
        ultimo = ultimo.prox;
        tamanho++;
     }
     public void inserir(int pos,Personagem personagem){
        if(pos < 0 || pos > tamanho){
            System.exit(0);
        }else if(pos == 0){
            inserirInicio(personagem);
        }else if(pos == tamanho){
            inserirFim(personagem);
        }else{
            Personagem tmp = personagem.getClone(personagem);
            Personagem j = primeiro;
            for(int i = 0;i<pos;i++,j = j.prox);
            tmp.prox = j.prox;
            j.prox = tmp;
            tmp = j = null;
            tamanho++;
        }
     
     }
     //------ remoção -------
     public Personagem removerInicio(){
        if(primeiro == ultimo){
            System.exit(0);
        }
        Personagem tmp = primeiro.prox;
        Personagem resp = tmp;
        primeiro.prox = primeiro.prox.prox;
        // remove fisicamente a Personagem
        tmp.prox = null;
        tmp = null;
        tamanho--;

         return resp;
     } 
     public Personagem removerFim (){
        if(primeiro == ultimo){
            System.exit(0);      
        }
         Personagem i;
         for(i = primeiro;i.prox!=ultimo;i = i.prox);
         Personagem resp = ultimo;
         ultimo = i;
         i = ultimo.prox = null;
         tamanho--;
         return resp;
     }
     public Personagem remover(int pos){
        Personagem resp = null;
        if(primeiro == ultimo || pos < 0 || pos >= tamanho){
            System.exit(0);
        }
        else if(pos == 0){
            removerInicio();
        }
        else if(pos == tamanho - 1){
            removerFim();
        }
        else{
        Personagem j = primeiro;
        for(int i = 0; i < pos;i++,j = j.prox);
        resp = j.prox;
        Personagem tmp = j.prox;
        j.prox = tmp.prox;
        tmp.prox = null;
        tmp = j = null;
       
         tamanho--;
        }
         return resp;
     }
     public void arrRemovidos(Personagem personagemRemovido) {
        ultimoRemovidos.prox = personagemRemovido;
        ultimoRemovidos = ultimoRemovidos.prox;
    }

    public void mostrarRemovidos() {
        Personagem i = primeiroRemovidos.prox;
        while (i!=null) {
            System.out.println("(R) "+ i.getName());
            i =  i.prox;
        }
    }

     // ---- mostrar ------
     public void mostrar(){
        Personagem.printaArray(primeiro);
     
     } 

    public int getTamanho() {
        return tamanho;
    }
}

// controlar tamanho do array de personagens

// ------------------- Classe
// Principal-------------------------------------------------------
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void processaComandos(Lista lista, ArrayList<Personagem> listaPersonagems)
            throws NumberFormatException {
                // II inserir no início,
                // I* inserir em qualquer posição,
                // IF inserir no fim,
                // RI remover no início
                // R* remover em qualquer posição
                // RF remover no fim
                String test = scanner.nextLine();
                int qtdComando = Integer.parseInt(test);
                
                for (int i = 0; i < qtdComando; i++) {
                    String comandos = scanner.nextLine();
                    String[] split = comandos.split(" ");
            Personagem personagemTemp;
            switch (split[0]) {
                case "II":
                    personagemTemp = SubLists.buscaPorId(split[1], listaPersonagems);
                    lista.inserirInicio(personagemTemp);
                    break;
                    case "I*":
                    personagemTemp = SubLists.buscaPorId(split[2], listaPersonagems);
                    lista.inserir(Integer.parseInt(split[1]), personagemTemp);
                    break;
                    case "IF":
                    personagemTemp = SubLists.buscaPorId(split[1], listaPersonagems);
                    lista.inserirFim(personagemTemp);
                    break;
                    case "RI":
                    personagemTemp = lista.removerInicio();
                    lista.arrRemovidos(personagemTemp);
                    break;
                    case "R*":
                    personagemTemp = lista.remover(Integer.parseInt(split[1]));
                    lista.arrRemovidos(personagemTemp);
                    break;
                    case "RF":
                    personagemTemp = lista.removerFim();
                    lista.arrRemovidos(personagemTemp);
                    break;
                default:
                System.err.println("Comando desconhecido: " + split[0]);
                break;
            }
        }

    }
    
    public static void main(String[] args) throws ParseException {

        ArrayList<Personagem> personagem = LerArquivo.lerArquivo();
        ArrayList<Personagem> subList1 = SubLists.addSubList1(personagem, scanner);
        // Personagem.printaArray(subList1);
        Lista lista = new Lista();
        for (int i = 0; i < subList1.size(); i++) {
            lista.inserirFim(subList1.get(i));
        }
        processaComandos(lista, personagem);
        lista.mostrarRemovidos();
        lista.mostrar();
        
    }
}
