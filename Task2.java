import java.util.*;

public class Task2 {
    public static void main(String[] args) {

    }

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] dir = path.split(" ");
            String pathdirec = dir[0];
            for (int i = 1; i < dir.length; i++) {
                String[] file = dir[i].replace('(', ':').split(":", 0);
                List<String> lis = map.getOrDefault(file[1], new ArrayList<String>());
                lis.add(pathdirec + "/" + file[0]);
                map.put(file[1], lis);
            }
        }
        List<List<String>> list = new ArrayList<List<String>>();
        for (Map.Entry<String, List<String>> mapElement : map.entrySet()) {
            List<String> value = mapElement.getValue();
            if (value.size() > 1) {
                list.add(value);
            }
        }
        return list;
    }
}
