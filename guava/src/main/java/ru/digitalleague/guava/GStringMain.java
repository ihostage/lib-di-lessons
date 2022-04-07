package ru.digitalleague.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class GStringMain {

  public static void main(String[] args) {
    Joiner joiner = Joiner.on("; ").skipNulls();
    System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));

    System.out.println(
        Splitter.on(',')
            .trimResults()
            .omitEmptyStrings()
            .split("foo,bar,,   qux")
    );
  }

}
