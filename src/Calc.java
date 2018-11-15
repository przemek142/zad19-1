import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Calc {

    private ArrayList<Integer> list = new ArrayList<>();
    private String errors = "";

    public String getErrors() {
        return errors;
    }

    public Calc(String numbers) {
        String listTemp[] = numbers.replaceAll("\\[|\\]|\\s*", "").split(",");
        for (String item : listTemp) {
            try {
                list.add(Integer.parseInt(item));
            } catch (NumberFormatException e) {
                errors += String.format('"' + item + "\" to nie liczba. Nie została dodana.\n");
            }
        }
        if (list.isEmpty())
            throw new NoSuchElementException();
    }

    public int getMostRepeatedNumber(ArrayList<Integer> list) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int mostRepeatedNumber = 0;

        for (Integer number : list) {
            map.put(number, map.getOrDefault(number, 0) + 1);
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