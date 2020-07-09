import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        IntStream
                .range(0, 10)
                .skip(4)
                .forEach(x->System.out.print(x));

        System.out.println();
        System.out.println(
        IntStream
                .range(0, 10)
                .sum()
        );
        System.out.println();
        String[] names = {"Ola", "Michelle", "Ayo", "Micheal"};
        Stream.of("Ola", "Michelle", "Ayo")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();
        Arrays.stream(names)//Stream.of(name)
                .map(String::toLowerCase)
                .filter(x->x.startsWith("M")||x.startsWith("m"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();
        Arrays.stream(new int[]{3,5,8,6,3,9})
                .map(x->x*x)
                .average()
                .ifPresent(System.out::println);
        //Path pathToFile = Paths.get("pass.txt");
        //System.out.println(pathToFile.toAbsolutePath());
        Stream<String> words = Files.lines(Paths.get("pass.txt"));
        words
                .sorted()
                .filter(x->x.contains("jiz"))
                .forEach(System.out::println);

        System.out.println();

        List<String> words2 = Files.lines(Paths.get("pass.txt"))
                .sorted()
                .filter(x->x.length()>50)
                .collect(Collectors.toList());
        words2.forEach(x->System.out.println(x));
        System.out.println();

        Map<String, Integer> map = new HashMap<>();
        Stream<String> words3 = Files.lines(Paths.get("data.txt"));
        map = words3
                .map(x->x.split(","))
                .filter(x->x.length==3)
                .filter(x->Integer.parseInt(x[1].trim())>15)
                .collect(Collectors.toMap(
                        x->x[0],
                        x->Integer.parseInt(x[1].trim())
                ));
        words2.forEach(x->System.out.println(x));
        for(String key: map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
        words3.close();

        System.out.println();
        Double total = Stream.of(5.2,6.8,9.7)
                .reduce(0.0, (Double runningTotal, Double newValue)->runningTotal+newValue);
        System.out.println("Total = "+total);

        System.out.println();
        IntSummaryStatistics summary = IntStream.of(54,26,8,4,12)
                .summaryStatistics();
        System.out.println(summary);
    }


}
