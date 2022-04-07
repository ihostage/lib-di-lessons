package ru.digitalleague.guava;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PreconditionsMain {

  /**
   * See {@link com.google.common.base.Preconditions}
   */
  public static void main(String[] args) {
    try {
      var m = method(5, "");
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      method(15, null);
    } catch (Exception e) {
      e.printStackTrace();
    }
    method(25, "string");
  }

  @Nullable
  private static String method(int arg, @Nonnull String str) {
    checkArgument(arg > 10, "Argument is %s, but should be more 10", arg);
    checkNotNull(str, "Str should not be null");
    System.out.printf("\n%s - %d%n", str, arg);
    // do something
    return null;
  }

}
