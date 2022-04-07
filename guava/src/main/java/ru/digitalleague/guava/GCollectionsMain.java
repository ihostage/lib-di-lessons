package ru.digitalleague.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Iterables;
import java.util.Iterator;
import java.util.List;

public class GCollectionsMain {

  public static void main(String[] args) {
    bidi();
    System.out.println();
    cycle();
  }

  private static void bidi() {
    HashBiMap<String, Integer> bidi = HashBiMap.create();
    bidi.put("SIX", 6);
    bidi.put("FIVE", 5);
    bidi.put("FOUR", 4);
    System.out.println(bidi.containsValue(6));
    BiMap<Integer, String> inverse = bidi.inverse();
    System.out.println(inverse);
  }

  private static void cycle() {
    List<String> names = List.of("Ivan", "Petr", "Oleg");
    Iterator<String> iterator = Iterables.cycle(names).iterator();
    for (int i = 0; i < 10; ++i) {
      System.out.println(iterator.next());
    }
  }

}
