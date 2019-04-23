

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dat {

    private ArrayList<Person> personsFromFile;
    private ArrayList<Person> foundedPersons;


    public Dat() {
        personsFromFile=new ArrayList<>(100);
        foundedPersons=new ArrayList<>(100);
    }

    public void addPerson( String surn, String nam, String patron){
        personsFromFile.add(personsFromFile.size(),new Person(surn,nam,patron) );
    }

    public void dataFromFile() {
         int lineCount=0;
        Pattern pattern;
        Matcher match;

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("C:\\Users\\Maxim\\IdeaProjects\\rest_appl_glassfish\\src\\config.txt"), "cp1251"))
                // читаем файл из двоичного потока
                // в виде текста с нужной кодировкой
        ) {
            String s;
            while ((s=br.readLine()) !=null ) { // пока readLine() возвращает не null


                pattern=Pattern.compile("(\\w+),(\\w+),(\\w+)");
                match = pattern.matcher(s);
                if (match.find()){

                    addPerson( match.group(1), match.group(2) , match.group(3) );
                }
                lineCount++;
                System.out.print(s);
            }

        }
        catch (IOException ex) {
            System.out.println("Reading error in line "+lineCount);
            ex.printStackTrace();
        }


    }

    public  List<Person>  returnAllPersons(){
        return personsFromFile;

    }
    public   List<Person>  returnAllPersonsPagination(int page, int start, int limit){

        returnAllPersons();
        if ((page*limit)>personsFromFile.size()){
            return personsFromFile.subList(page*limit-limit,personsFromFile.size() );
        }else{
            return personsFromFile.subList(page*limit-limit,page*limit );
        }
    }

    public  List<Person> returnFindPerson(String text){
        returnAllPersons();
        for(Person p:personsFromFile){
            if (p.getSurname().toUpperCase().contains(text.toUpperCase())){
                foundedPersons.add(foundedPersons.size(),p );
            }
        }
        return foundedPersons;

    }
    public  List<Person> returnFindPersonPagination(String text, int page, int start, int limit){
       // returnFindPerson(text);
         if((page*limit)<foundedPersons.size()){
            return foundedPersons.subList(page*limit-limit,page*limit  );
        } else if(foundedPersons.size()<limit){
            return foundedPersons.subList(0,foundedPersons.size() );
        }else if ((page*limit)>foundedPersons.size()){
             return foundedPersons.subList(page*limit-limit,foundedPersons.size()  );
         }
            return null;
    }




}
