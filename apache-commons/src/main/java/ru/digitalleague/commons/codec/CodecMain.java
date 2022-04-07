package ru.digitalleague.commons.codec;

import java.util.Arrays;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MurmurHash3;

public class CodecMain {

  public static void main(String[] args) throws DecoderException {
    base64();
    hex();
    md5();
    murmur();
  }

  /**
   * Also see {@link java.util.Base64}
   */
  private static void base64() {
    System.out.println("BASE64:");
    String originalInput = "test input";
    String encodedString = new String(Base64.encodeBase64(originalInput.getBytes()));
    System.out.println("\t" + encodedString);
    String decodedString = new String(Base64.decodeBase64(encodedString.getBytes()));
    System.out.println("\t" + decodedString);
  }

  /**
   * Also see {@link java.lang.String#format(String, Object...)} and {@link java.math.BigDecimal}
   */
  private static void hex() throws DecoderException {
    System.out.println("HEX:");
    String originalInput = "test input";
    String encodedString = Hex.encodeHexString(originalInput.getBytes());
    System.out.println("\t" + encodedString);
    byte[] bytes = Hex.decodeHex(encodedString);
    System.out.println("\t" + Arrays.toString(bytes));
    String decodedString = new String(bytes);
    System.out.println("\t" + decodedString);
  }

  /**
   * Also see {@link java.security.MessageDigest#getInstance}
   * and {@link org.apache.commons.codec.digest.MessageDigestAlgorithms}
   */
  private static void md5() {
    System.out.println("MD5:");
    String password = "ILoveJava";
    String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
    System.out.println("\t" + md5Hex);
  }

  private static void murmur() {
    System.out.println("MurmurHash3:");
    String password = "ILoveJava";
    long[] hash = MurmurHash3.hash128x64(password.getBytes());
    System.out.println("\t" + Arrays.toString(hash));
  }

}
