import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class CustomPerson {
    List<Person> persons;
    int total;
//
    public CustomPerson( int t,List<Person> lpContr){
        this.persons = lpContr;
        this.total=t;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public int getTotal() {
        return total;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
