import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Calc {

    private ArrayList<Integer> list = new ArrayList<>();


    public Calc(String numbers) {
        String listTemp[] = numbers.replaceAll("\\[|\\]|\\s*", "").split(",");
        for (String item : listTemp) {
            try {
                list.add(Integer.parseInt(item));
            } catch (NumberFormatException e) {
                System.out.println('"' + item + "\" to nie liczba, nie została dodana.");
            }
        }
        if (list.isEmpty())
            throw new NoSuchElementException();
    }

    public int getMostRepeatedNumber(ArrayList<Integer> list) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int mostRepeatedNumber = 0;

        for (Integer number : list) {
            if (!map.containsKey(number))
                map.put(number, 1);
            else {
                map.put(number, map.get(number) + 1);
            }
        }

        boolean firstIteration = true;
        for (Integer key : map.keySet()) {
            if (firstIteration)
                mostRepeatedNumber = key;
            else {
                if (map.get(key) >= map.get(mostRepeatedNumber))
                    mostRepeatedNumber = key;
            }
            firstIteration = false;
        }
        return mostRepeatedNumber;
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}