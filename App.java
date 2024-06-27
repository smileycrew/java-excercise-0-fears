import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        PeopleReader reader = new PeopleReader("people.txt");

        List<Person> people = reader.getAllPeople();
        List<String> uniqueFears = getFears(people);

        for (String fear : uniqueFears) {

            printDivider();

            System.out.println(String.format("\n%s\n", fear));

            printPeopleWithFear(fear, people);

            printDivider();
        }
    }

    public static List<String> getFears(List<Person> people) {
        List<String> fears = new ArrayList<>();

        for (Person p : people) {
            String fear = p.getFear();

            if (!fears.contains(fear)) {
                fears.add(fear);
            }
        }

        return fears;
    }

    public static void printDivider() {
        String divider = "---------------------------";

        System.out.println(divider);
    }

    public static void printPeopleWithFear(String fear, List<Person> people) {
        for (Person p : people) {
            String personsFear = p.getFear();

            if (personsFear.equals(fear)) {
                System.out.println(p);
            }
        }
    }
}