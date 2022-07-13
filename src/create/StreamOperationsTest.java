package create;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperationsTest
{
    static String[] nameList = {"Ahmet","Burak","Cemil","Davut","Erhan","Ferhat","Galip","Hayri"};
    static List<String> memberNames = new ArrayList<>(Arrays
            .asList(nameList));

    public static void main(String[] args) {

        filter();

        map();

        sort();

        foreach();

        collect();

        matched();

        count();

        reduce();

        findFirst();

        distinct();

        peek();

        skip();

        flatMap();
    }

    private static void flatMap()
    {
        String[][] dataArray = new String[][]{{"a", "b"},
                {"c", "d"}, {"e", "f"}, {"g", "h"}};

        List<String> listOfAllChars = Arrays.stream(dataArray)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());

        System.out.println(listOfAllChars);
    }

    private static void skip() {
        memberNames = memberNames.stream().skip(5).limit(2).collect(Collectors.toList());
        System.out.println(memberNames);
    }

    private static void peek()
    {
        memberNames = memberNames.stream().peek(item->item.equals("Ahmet")).collect(Collectors.toList());
        System.out.println(memberNames);
    }

    private static void distinct()
    {
        memberNames.add("Ahmet");
        System.out.println(memberNames);
        memberNames = memberNames.stream().distinct().collect(Collectors.toList());
        System.out.println(memberNames);
    }

    private static void findFirst()
    {
        String firstData = memberNames.stream().filter(i->i.startsWith("A")).findFirst().get();
        System.out.println(firstData);
    }

    private static void reduce()
    {
        Optional<String> reduced =  memberNames.stream().reduce((s1 , s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
    }

    private static void count()
    {
        long count = memberNames.stream().filter(i->i.startsWith("B")).count();
        System.out.println(count);
    }

    private static void matched()
    {
        boolean isMatched = memberNames.stream().anyMatch(i->i.startsWith("A"));
        System.out.println(isMatched);

        isMatched = memberNames.stream().allMatch(i->i.startsWith("A"));
        System.out.println(isMatched);

        isMatched = memberNames.stream().noneMatch(i->i.startsWith("A"));
        System.out.println(isMatched);
    }

    private static void collect()
    {
        List<String> collectedList = memberNames.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(collectedList);
    }

    private static void foreach()
    {
        memberNames.stream().forEach(System.out::println);
    }

    private static void sort()
    {
        List<String> sortedList = memberNames.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList);
    }

    private static void map()
    {
        List<String> mappedList = memberNames.stream().map(item->item.substring(0,1)).collect(Collectors.toList());
        System.out.println(mappedList);
    }

    private static void filter()
    {
        List<String> filteredList = memberNames.stream().filter(item->item.equals("Ahmet")).collect(Collectors.toList());
        System.out.println(filteredList);
    }
}
