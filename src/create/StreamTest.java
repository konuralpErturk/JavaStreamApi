package create;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest
{
    public static void main(String[] args)
    {
        //Stream.of stream created with number of integers
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(System.out::println);

        //Stream.of stream created with array
        Stream<Integer> arrayStream = Stream.of(new Integer[]{1,2,3,4,5,6,7,8,9});
        arrayStream.forEach(System.out::println);

        //Stream created with List
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> listStream = list.stream();
        listStream.forEach(System.out::println);

        //Stream created with Stream's generate method and we write console only 25 element
        Stream<Integer> randomNumberStream = Stream.generate(()->(new Random()).nextInt());
        randomNumberStream.limit(25).forEach(System.out::println);

        //first we create integer list and list convert to stream then we use collect and filter method then we collect with elements mod and put to new list
        List<Integer> unCollectList      = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer>  unCollectStream = unCollectList.stream();
        List<Integer> collectList        = unCollectStream.filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(collectList);
    }
}
