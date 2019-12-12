import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Program {

    private List<Integer> codes;
    private int checkSum;

    public static void main(String[] args) throws IOException {
        List<Integer> codes = Arrays.stream(Files.readString(Paths.get("input/day2.txt")).split(",")).mapToInt(s -> Integer.parseInt(s.trim())).boxed().collect(Collectors.toCollection(ArrayList::new));

        Program firstPart = new Program(new ArrayList<>(codes), 12, 2);
        System.out.println("Part1: " + firstPart.getFirst());

        List<Program> part2 = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++) part2.add(new Program(new ArrayList<>(codes), i, j));
        for (Program p : part2) if (p.getFirst() == 19690720) System.out.println("Part2: " + p.getCheckSum());
    }

    public Program(List<Integer> codes, int noun, int verb) {
        this.codes = codes;
        this.codes.set(1, noun);
        this.codes.set(2, verb);
        this.checkSum = noun * 100 + verb;
        run();
    }

    private void run() {
        for (int address = 0; address < codes.size(); address += 4) {
            int value = codes.get(address);

            switch (value) {
                case 1:
                    codes.set(codes.get(address + 3), codes.get(codes.get(address + 2)) + codes.get(codes.get(address + 1)));
                    break;

                case 2:
                    codes.set(codes.get(address + 3), codes.get(codes.get(address + 2)) * codes.get(codes.get(address + 1)));
                    break;

                case 99:
                    return;
            }
        }
    }

    public int getFirst() {
        return codes.get(0);
    }

    public int getCheckSum() {
        return checkSum;
    }

}