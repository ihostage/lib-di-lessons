package ru.digitalleague.jackson;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.time.LocalDateTime;
import java.util.List;

public class JacksonMain {

  private static final ObjectMapper MAPPER = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .registerModule(new Jdk8Module())
      .registerModule(new ParameterNamesModule())
      .disable(WRITE_DATES_AS_TIMESTAMPS)
      .disable(FAIL_ON_UNKNOWN_PROPERTIES)
      .enable(READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)
      .setSerializationInclusion(NON_NULL)
      ;

  public static void main(String[] args) throws JsonProcessingException {
    serialize();
    System.out.println();
    deserialize();
    System.out.println();
  }

  private static void serialize() throws JsonProcessingException {
    User user = new User();
    user.setFirstName("Ivan");
    user.setBirthDay(LocalDateTime.of(2000, 1, 1, 13, 45));
    user.setGender(Gender.MAN);
    user.setTransientField("transient");
    user.setAddress(new Address("Moscow, Mira st."));
    user.setPets(List.of(new Cat("Matroskin", "striped"), new Dog("Sharik", 7)));
    user.setJob(new Job("developer", "Digital League", null));

    System.out.println(MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(user));
  }

  private static void deserialize() throws JsonProcessingException {
    String json = "{\n"
        + "  \"first_name\" : \"Ivan\",\n"
        + "  \"birthday\" : \"2000-01-01T13:45:00\",\n"
        + "  \"gender\" : \"BEAR\",\n"
        + "  \"transient_field\": null,\n"
        + "  \"address\" : \"Moscow, Tverskaya st.\",\n"
        + "  \"pets\" : [ {\n"
        + "    \"type\" : \"cat\",\n"
        + "    \"name\" : \"Matroskin\",\n"
        + "    \"cat_color\" : \"striped\"\n"
        + "  }, {\n"
        + "    \"type\" : \"dog\",\n"
        + "    \"name\" : \"Sharik\",\n"
        + "    \"weight\" : 7\n"
        + "  } ],\n"
        + "  \"job\" : {\n"
        + "    \"t\" : \"developer\",\n"
        + "    \"d\" : null,\n"
        + "    \"c\" : \"Digital League\"\n"
        + "  },\n"
        + "  \"smart\" : true\n"
        + "}";

    User user = MAPPER.readValue(json, User.class);
    System.out.println(user);
  }

}
