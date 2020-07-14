/*
 * Java Lambdas manipulating binary data elevators.bin (3 int and 1 double)
 */

/**
 *
 * @author e2517  
 */
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static int i;
    static IntStream number;
    static List<Data> list;
    static Map<Integer, Long> movements;
    static IntSummaryStatistics statistics;

    public static void main(String[] args) throws Exception {

        int id;
        int start;
        int end;
        double weight;

        RandomAccessFile readData = new RandomAccessFile("elevators.bin", "r"); 

        list = new ArrayList();

        while (readData.getFilePointer() < readData.length()) {

            id = readData.readInt();
            start = readData.readInt();
            end = readData.readInt();
            weight = readData.readDouble();

            list.add(new Data(id, start, end, weight));
        }

        movements = list.stream()
                .collect(Collectors.groupingBy(a -> a.getNumberElevator(),
                        Collectors.counting()));

        statistics = list.stream()
                .mapToInt(Data::getNumberElevator)
                .summaryStatistics();

        for (i = 0; i <= statistics.getMax(); i++) {

            numberElevator(i);

            movementsElevator(i);

            totalWeight(i);

            startFloor();

            endFloor();

            System.out.println("================================");

        }
    }

    public static void numberElevator(int i) {

        number = list.stream()
                .filter(c -> c.getNumberElevator() == i)
                .mapToInt(c -> c.getNumberElevator())
                .sorted();

        int[] numberArray = number.toArray();

        System.out.println("Elevator: " + numberArray[i]);

    }

    public static void movementsElevator(int i) {

        Long changes = movements.get(i) - 1;

        System.out.println("Changes: " + changes);
    }

    public static void totalWeight(int i) {

        System.out.println("Total weight: "
                + list.stream()
                        .filter(c -> c.getNumberElevator() == i)
                        .mapToDouble(c -> c.getWeightElevator())
                        .sorted()
                        .sum()
                + " Kg");
    }

    public static void startFloor() {

        OptionalInt numero = list.stream()
                .filter(c -> c.getNumberElevator() == i)
                .mapToInt(c -> c.getStartFloor())
                .reduce((first, second) -> first);

        System.out.println("Start floor: " + numero.getAsInt());

    }

    public static void endFloor() {

        OptionalInt numero = list.stream()
                .filter(c -> c.getNumberElevator() == i)
                .mapToInt(c -> c.getEndFloor())
                .reduce((first, second) -> second);

        System.out.println("Final floor: " + numero.getAsInt());
    }

}
