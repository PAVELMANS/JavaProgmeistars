import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.toList;

public class Streams {

    class Person{
        String name;
        int age;
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    class Track {
        String name;

        Track (String name) {
            this.name = name;
        }
    }

    class Album {
        private String title;
        private List<Artist> musicians;
        private List<Track> tracks;

        public List<Track> getTracks() {
            return tracks;
        }

        public void setTracks(List<Track> tracks) {
            this.tracks = tracks;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Artist> getMusicians() {
            return musicians;
        }

        public void setMusicians(List<Artist> musicians) {
            this.musicians = musicians;
        }
    }

    class Artist {
        private String name;
        private List<String> members;
        private String origin;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getMembers() {
            return members;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }
    }

    public void task0() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        collection = collection.stream()
                .map(a -> a.toUpperCase())
                .collect(toList());

    }

    public static void task1() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        collection = collection.stream()
                .filter(word -> word.length() < 4)
                .collect(toList());
    }

    public void task2() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List <String> flattenedCollection  = collection.stream()
                .flatMap(element -> element.stream())
                .collect(toList());
    }

    public void task3() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Person oldest = collection.stream()
                .max(Comparator.comparing(human -> human.age))
                .get();
    }

    public void task4() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
    }

    public void task5() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        List<String> underagedKids = collection.stream()
                .filter(human -> human.age < 18)
                .map(human -> human.name)
                .collect(toList());
    }

    public void task6() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        double averaageAge = collection.stream()
                .mapToInt(human -> human.age)
                .average()
                .getAsDouble();
                //.reduce(0, (a1, a2) -> (a1 + a2) / 2);
        //System.out.println(averaageAge);
        long amountOfPeople = collection.stream().count();
        long minAge = collection.stream()
                .map(human -> human.age)
                .min(Comparator.comparing(age -> age))
                .get();
        long maxAge = collection.stream()
                .map(human -> human.age)
                .max(Comparator.comparing(age -> age))
                .get();
        long sumOfAges = collection.stream()
                .map(human -> human.age)
                .reduce(0, (n1, n2) -> n1 + n2);
    }

    public void task7() {
        Artist ONUKA = new Artist();
        ONUKA.setName("ONUKA");
        ONUKA.setMembers(Arrays.asList("Nata Zhyzhchenko", "Daryna Sert", "Mariya Sorokina", "Yevhen Yovenko"));
        ONUKA.setOrigin("Kyiv, Ukraine");

        Artist PrātaVētra = new Artist();
        PrātaVētra.setName("Prāta Vētra");
        PrātaVētra.setMembers(Arrays.asList("Renārs Kaupers", "Jānis Jubalts", "Kaspars Roga", "Māris Mihelsons"));
        PrātaVētra.setOrigin("Jelgava, Latvia");

        Album sevenStepsOfFreshAir = new Album();
        sevenStepsOfFreshAir.setTitle("7 SOĻI SVAIGA GAISA");
        //sevenStepsOfFreshAir.setTracks(Arrays.asList(new Track("7 soļi svaiga gaisa"), new Track("Ēdenes dārzs"),
                //new Track("Pilsētas ugunis"), new Track("Sapnī"),
               // new Track("Kad zvaigznes pār alejām krīt"), new Track("Ziemu apēst",
                //new Track("Pastkastīte"), new Track("Laimes satelīts"), new Track("Jūras", "Meklēt vienam otru"));
    }
}
