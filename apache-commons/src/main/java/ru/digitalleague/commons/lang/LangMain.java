package ru.digitalleague.commons.lang;

import static org.apache.commons.lang3.ArrayUtils.isSorted;
import static org.apache.commons.lang3.ArrayUtils.shuffle;
import static org.apache.commons.lang3.ArrayUtils.toArray;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAscii;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import java.util.Arrays;

public class LangMain {

  /**
   * {@link org.apache.commons.lang3.StringUtils}
   * {@link org.apache.commons.lang3.LocaleUtils}
   * {@link org.apache.commons.lang3.ArrayUtils}
   * {@link org.apache.commons.lang3.RandomStringUtils}
   * etc
   */
  public static void main(String[] args) {
    // StringUtils
    System.out.println("'" + trimToEmpty(null) + "'");
    System.out.println("'" + trimToEmpty("     ") + "'");
    System.out.println("'" + trimToEmpty("    abc    ") + "'");
    System.out.println();
    // ArrayUtils
    System.out.println(isSorted(toArray(1, 2, 3)));
    System.out.println(isSorted(toArray(1, 2, 4, 3)));
    Integer[] shuffle = toArray(1, 2, 3, 4, 5);
    shuffle(shuffle);
    System.out.println(Arrays.toString(shuffle));
    System.out.println();
    // RandomStringUtils
    System.out.println(randomNumeric(3, 9));
    System.out.println(randomAscii(3, 9));
    var letters = "abcd1234";
    System.out.println(random(10, 0, letters.length(), true, true, letters.toCharArray()));
    System.out.println(random(6, 0, letters.length(), true, false, letters.toCharArray()));
  }

}
