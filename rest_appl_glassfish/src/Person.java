import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Person {

    private String surname;
    private String name;
    private String patronymic;
    int total=10;

    public Person (){}

    public Person (String surname, String name, String patronymic){
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;

    }



    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
