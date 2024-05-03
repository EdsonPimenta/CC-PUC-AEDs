import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;

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
    private boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Construtor default
    Personagem() {
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
    }

    public  Personagem(String[] aux) throws ParseException {
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
        this.hogwartsStaff = Boolean.parseBoolean(aux[j++]);
        this.hogwartsStudent = Boolean.parseBoolean(aux[j++]);
        this.actorName = aux[j++];
        this.alive = Boolean.parseBoolean(aux[j++]);
        j++;
        this.dateOfBirth = dateFormat.parse(aux[j++]);
        this.yearOfBirth = Integer.parseInt(aux[j++]);
        this.eyeColour = aux[j++];
        this.gender = aux[j++];
        this.hairColour = aux[j++];
        if(aux[j] == "VERDADEIRO")
        this.wizard = true;
        else
        this.wizard = false;
   
    }

    // printa array de personagem
    public void printPersonagem() {
        int i = 0;

        System.out.print("[" + id + " ## " +
                name + " ## " +
                "{");
        for (String s : alternate_names) {
            i++;
            System.out.print(s);
            if (i < alternate_names.size()) {
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

    // ---------------------------- Getters ----------------------------------------------
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

    //  printa array list de personagem
    public static void printaArray(ArrayList<Personagem> personagem) {

        for (int i = 0; i < personagem.size(); i++) {
            personagem.get(i).printPersonagem();
        }

    }

    // clone do personagem
    public  static Personagem clone(Personagem personagems) {
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


// -------------------Ler arquivo---------------------------------------------------
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


// ---------------------- Compara SubLists ------------------------------

class SubLists {
    public static Scanner scanner = new Scanner(System.in);

    // retorna personagem buscando por id
    public static Personagem buscaPorId(String myId, ArrayList<Personagem> personagem) {
        Personagem personagem1 = null;
        for (Personagem p : personagem) {
            if (p.getId().equals(myId)) {
                personagem1 = Personagem.clone(p);
                continue;
            }
        }
        return personagem1;
    }
    // retorna personagem bucando por nome
    public static Personagem buscaPorNome(String name, ArrayList<Personagem> personagem) {
        Personagem personagem2 = null;
        for (Personagem p : personagem) {
            if (p.getName().equals(name)) {
                personagem2 = Personagem.clone(p);
                continue;
            }
        }
        return personagem2;
    }

    //add sublist por id
    public static ArrayList<Personagem> addSubList1(ArrayList<Personagem> personagem ){
        String myId;
        ArrayList<Personagem> subList1 = new ArrayList<Personagem>();
        while (!(myId = scanner.nextLine()).equals("FIM")) {
            if (SubLists.buscaPorId(myId, personagem) == null)
                continue;
            subList1.add(SubLists.buscaPorId(myId, personagem));
        }
        return subList1;

    }
    //add sublist por nome
    public static ArrayList<Personagem> addSubList2(ArrayList<Personagem> personagem ){
        String name;
        ArrayList<Personagem> subList2 = new ArrayList<Personagem>();
        while (!(name = scanner.nextLine()).equals("FIM")) {
            if (SubLists.buscaPorNome(name, personagem) == null)
                continue;
            subList2.add(SubLists.buscaPorNome(name, personagem));
        }

        return subList2;
    }
    // comparo os novos sublists nome - > id
    public  static void comparaSubLists(ArrayList<Personagem> personagem, ArrayList<Personagem> personagem2) {
        boolean ehIgual = false;
        for (Personagem p : personagem) {
            ehIgual = false;
            for (Personagem p2 : personagem2) {
                if (p.getName().equals(p2.getName())) {
                    ehIgual = true;
                    break;
                }
            }
            if (ehIgual)
                System.out.println("SIM");
            else
                System.out.println("NAO");
        }
    }
    

}   
//  --------------------------------------------Ordenacao ---------------------------------------------
    class Ordenacao{

        //  Swap
        public static void swap(ArrayList<Personagem> subList1,int i,int menorIndice){
            Personagem aux = subList1.get(i);
            subList1.set(i,subList1.get(menorIndice));
            subList1.set(menorIndice,aux);

        }
        //  Selection Sort por nome
        public static void selectionSort(ArrayList<Personagem> subList1){  
            for(int i = 0;i < subList1.size()-1;i++){
                String stringI = null;
                String stringJ = null;

                int menorIndice = i;
                stringI = subList1.get(menorIndice).getName();
                for(int j = i + 1; j < subList1.size();j++){
                    stringJ = subList1.get(j).getName();
                    int resultado = stringI.compareTo(stringJ);
                    if(resultado>0){
                        menorIndice = j;
                        stringI = subList1.get(menorIndice).getName();
                    }
                }
                swap(subList1,i,menorIndice);
            }
        
        }
        //  Ordenar por nome em caso de empate
        public static int desempateNome(Personagem personagem,Personagem personagem2){
            int result = personagem.getDateOfBirth().compareTo(personagem2.getDateOfBirth());
            if(result==0){
                result = personagem.getName().compareTo(personagem2.getName());
            }
            return result;
        }

        // Insertion Sort por data de nascimento
        public static void insertionSort(ArrayList<Personagem> subList1){
            for (int i = 1; i < subList1.size(); i++) {
                Personagem aux = subList1.get(i);
                int j = i - 1;
                while ((j >= 0) && (desempateNome(subList1.get(j),aux) > 0)) {
                    subList1.set(j+1,subList1.get(j));
                    j--;

                }
                subList1.set(j+1,aux);
            }
        }
            // Método heapify ajustado para usar o nome como critério de desempate
    
    // ---------------------------------- HeapSort ----------------------------------------------
    public static void heapSort(List<Personagem> list) {
        int n = list.size();

        // Construir um heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        // Extrair elementos um por um do heap
        for (int i = n - 1; i > 0; i--) {
            swap2(list, 0, i);
            heapify(list, i, 0);
        }
    }

    public static void heapify(List<Personagem> list, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Se o filho esquerdo é maior que a raiz
        if (left < n && compare(list.get(left), list.get(largest)) > 0) {
            largest = left;
        }

        // Se o filho direito é maior que a maior atual
        if (right < n && compare(list.get(right), list.get(largest)) > 0) {
            largest = right;
        }

        // Se a maior não é a raiz
        if (largest != i) {
            swap2(list, i, largest);
            heapify(list, n, largest);
        }
    }

    public static int compare(Personagem p1, Personagem p2) {
        int result = p1.getHairColour().compareTo(p2.getHairColour());
        if (result == 0) {
            result = p1.getName().compareTo(p2.getName());
        }
        return result;
    }

    public static void swap2(List<Personagem> list, int i, int j) {
        Personagem temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    }
    // ------------------- Fim HeapSort ---------------------------------

    //------------------- Classe  Principal -------------------------------------------------------
    public class Main{
        public static Scanner scanner = new Scanner(System.in);
        
        public static void main(String[] args) throws ParseException {
            
            ArrayList<Personagem> personagem = new ArrayList<Personagem>();
            ArrayList<Personagem> subList1 = new ArrayList<Personagem>();

            personagem = LerArquivo.lerArquivo();
            subList1 = SubLists.addSubList1(personagem);
            Ordenacao.insertionSort(subList1);
            Personagem.printaArray(subList1);
            
        }

}
