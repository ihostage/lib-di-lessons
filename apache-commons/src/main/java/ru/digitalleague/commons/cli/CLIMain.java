package ru.digitalleague.commons.cli;

import java.util.Arrays;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CLIMain {

  private static final Options OPTIONS = new Options();

  static {
    OPTIONS.addOption("d", "debug", false, "Turn on debug.");
    OPTIONS.addOption("h", "help", false, "Print help message.");
    Option featuresOpt = Option.builder("f")
        .longOpt("feature")
        .hasArgs()
        .valueSeparator(',')
        .desc("Turn on some features.")
        .build();
    OPTIONS.addOption(featuresOpt);
    Option propertyOpt = Option.builder("P")
        .hasArgs()
        .desc("Use value for given property")
        .build();
    OPTIONS.addOption(propertyOpt);
  }

  public static void main(String[] args) throws ParseException {
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(OPTIONS, args);

    if (cmd.hasOption('h')) {
      printHelpMessage();
      return;
    }

    if (cmd.hasOption('d')) {
      System.out.println("DEBUG ENABLED");
    }

    if (cmd.hasOption('f')) {
      System.out.println("FEATURES: " + Arrays.toString(cmd.getOptionValues("f")));
    }

    if (cmd.hasOption("P")) {
      System.out.println("PROPS: " + cmd.getOptionProperties("P"));
    }

  }

  public static void printHelpMessage() {
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("java", OPTIONS);
  }
}
