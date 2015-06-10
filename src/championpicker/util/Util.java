package championpicker.util;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.Comparator;

public class Util {

    //stackoverflow.com/questions/109383/how-to-sort-a-mapkey-value-on-the-values-in-java
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare( Map.Entry<K, V> a, Map.Entry<K, V> b ) {
                return b.getValue().compareTo(a.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list)
            result.put(entry.getKey(), entry.getValue());
        return result;
    }
}
