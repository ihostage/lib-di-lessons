package ru.digitalleague.commons.collections;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;

public class CollectionsMain {

  public static void main(String[] args) {
    listIntersectionUnion();
    System.out.println();
    nullSafeMethods(null);
    System.out.println();
    nullSafeMethods(List.of("one", "two"));
    System.out.println();
    bidi();
    System.out.println();
    multiKey();
    System.out.println();
    cycle();
  }

  private static void listIntersectionUnion() {
    var list1 = List.of(1, 2, 3, 4);
    var list2 = List.of(3, 4, 5, 6);
    var intersection = CollectionUtils.intersection(list1, list2);
    System.out.println(intersection);
    var union = CollectionUtils.union(list1, list2);
    System.out.println(union);
  }

  private static void nullSafeMethods(Collection<String> collection) {
    if (isEmpty(collection)) {
      System.out.println("collection is empty");
    } else {
      System.out.println(collection);
    }
  }

  private static void bidi() {
    BidiMap<String, String> bidi = new TreeBidiMap<>();
    bidi.put("SIX", "6");
    bidi.put("FIVE", "5");
    bidi.put("FOUR", "4");
    bidi.get("SIX");
    bidi.getKey("6");
    bidi.removeValue("6");
    BidiMap<String, String> inverse = bidi.inverseBidiMap();
    System.out.println(inverse);
  }

  private static void multiKey() {
    Map<MultiKey<Object>, String> map = new HashMap<>();
    map.put(new MultiKey<>("msg", Locale.US), "some text");
    var multiKey = new MultiKey<>("msg", Locale.US);
    String localizedText = map.get(multiKey);
    System.out.println(localizedText);
  }

  private static void cycle() {
    List<String> names = List.of("Ivan", "Petr", "Oleg");
    Iterator<String> iterator = new LoopingIterator<>(names);
    for (int i = 0; i < 10; ++i) {
      System.out.println(iterator.next());
    }
  }

}
