package java;

/*Crie uma classe Personagem seguindo todas as regras apresentadas no slide unidade01g_conceitosBasicos_introducaoOO.pdf.
    Sua classe terá os atributos privados id (String), name (String), alternate_names (Lista), house (String), ancestry (String), species (String), patronus (String), hogwartsStaff (Boolean), hogwartsStudent (String), actorName (String), alive (Boolean), dateOfBirth (DateTime), yearOfBirth (int), eyeColour (String), gender (String), hairColour (String), wizard (Boolean). 
    Sua classe também terá pelo menos dois construtores, e os métodos gets, sets, clone, imprimir e ler.
    O método imprimir mostra os atributos do registro (ver cada linha da saída padrão) e o ler lê os atributos de um registro. 
    Atenção para o arquivo de entrada, pois em alguns registros faltam valores e esse foi substituído pelo valor 0 (zero) ou vazio.
    A entrada padrão é composta por várias linhas e cada uma contém uma string indicando o id do Personagem a ser lido. 
    A última linha da entrada contém a palavra FIM. A saída padrão também contém várias linhas, uma para cada registro contido em uma linha da entrada padrão. */

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;

    public class Personagem {
        private String id;
        private String name;
        private List<String> alternate_names;
        private String house;
        private String ancestry;
        private String species;
        private String patronus;
        private Boolean hogwartsStaff;
        private String hogwartsStudent;
        private String actorName;
        private boolean alive;
        private Date dateOfBirth;
        private int yearOfBirth;
        private String eyeColour;
        private String gender;
        private String hairColour;
        private Boolean wizard;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        Personagem(){}
        
        public Personagem(String id, String name, List<String> alternate_names, String house, String ancestry,
                String species, String patronus, Boolean hogwartsStaff, String hogwartsStudent,
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
        Personagem(String[] aux) throws ParseException{
            int j=0; 
            this.id = aux[j++];
            this.name = aux[j++];
            String[] aux2 = aux[j++].split(",");
            this.alternate_names = new ArrayList<>();    
            for(String s : aux2){
                alternate_names.add(s); 
            }
            this.house = aux[j++];
            this.ancestry = aux[j++];
            this.species = aux[j++];
            this.patronus = aux[j++];
            this.hogwartsStaff = Boolean.parseBoolean(aux[j++]);
            this.hogwartsStudent = aux[j++];
            this.actorName = aux[j++];
            this.alive = Boolean.parseBoolean(aux[j++]);
            j++;
            this.dateOfBirth = dateFormat.parse(aux[j++]);
            this.yearOfBirth = Integer.parseInt(aux[j++]);
            this.eyeColour = aux[j++];
            this.gender = aux[j++];
            this.hairColour = aux[j++];
            this.wizard = Boolean.parseBoolean(aux[j++]);
        }
        
        
        public void printPersonagem(){
            int i = 0;
            
            System.out.print("["+ id + " ## " +
                    name +  " ## " +
                    "{");
                    for(String s : alternate_names){
                        i++;
                        System.out.print(s);
                        if(i<alternate_names.size()){
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

        // Setters
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
        
        public void setHogwartsStudent(String hogwartsStudent) {
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
        // Getters

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
        
        public String getHogwartsStudent() {
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
        
        
                public static Scanner scanner = new Scanner(System.in);

        public static ArrayList<Personagem> lerArquivo() throws ParseException{
            ArrayList<Personagem> array = new ArrayList<Personagem>();
            //tratamento de excessao
            try{ 
                RandomAccessFile arq = new RandomAccessFile("/tmp/characters.csv", "r");
                arq.seek(0);
                arq.readLine(); 
                for(long i = 0; i < arq.length(); i = arq.getFilePointer()){
                    String WordPersonagem = "";
                    String aux2 = "";
                    String aux[];
                    WordPersonagem += arq.readLine(); 
                    for(int j = 0; j < WordPersonagem.length();j++){
                        if(WordPersonagem.charAt(j)!='[' && WordPersonagem.charAt(j)!= ']' && WordPersonagem.charAt(j) != '\'' ){
                            aux2 += WordPersonagem.charAt(j);    
                        }
                    }
                    aux = aux2.split(";", 18);//split
                    Personagem personagem = new Personagem(aux);
                    array.add(personagem);
                    
                }
                arq.close();//fechando arquivo
                
            }catch(IOException e){
                e.printStackTrace();
            }
            return array;
        }
        /*
         * for(Personagem p : personagem  ){
         *      if(p.id.equals(myId)){
         *          p .printPersonagem
         *          break;
         *      }
         *}
         *  for(int i = 0; i < personagem.size(); i++){
         *      if(personagem.get(i).getId().equals(myId)){
         *              personagem.get(i).printPersonagem();
         *              
         */
        
        
        public static void printaArray(ArrayList<Personagem> personagem){

            for(int i = 0;i < personagem.size();i++){
                
                personagem.get(i).printPersonagem();
                
            }

        }
        public static void buscaPorId(String myId,ArrayList<Personagem> personagem){
            for(Personagem p : personagem  ){
                if(p.getId().equals(myId)){
                    p .printPersonagem();
                    break;
                }
            }
        }
        public  static  Personagem clone(Personagem personagems){
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
        
        public static void main(String[] args) throws ParseException {

            ArrayList<Personagem> personagem = new ArrayList<Personagem>();
            personagem = lerArquivo();

            // printaArray(personagem);
            String myId;
            while(!(myId = scanner.nextLine()).equals("FIM")){
                buscaPorId(myId, personagem);
            }



         }

    }
