package ru.digitalleague.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.IOException;

@JsonSerialize(using = Job.Serializer.class)
@JsonDeserialize(using = Job.Deserializer.class)
public class Job {

  private final String title;

  private final String company;

  private final String department;

  public Job(String title, String company, String department) {
    this.title = title;
    this.company = company;
    this.department = department;
  }

  static class Serializer extends JsonSerializer<Job> {
    @Override
    public void serialize(Job value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException {
      gen.writeStartObject();
      if (value.title != null) {
        gen.writeStringField("t", value.title);
      } else {
        gen.writeNullField("t");
      }
      gen.writeStringField("d", value.department);
      serializers.defaultSerializeField("c", value.company, gen);
      gen.writeEndObject();
    }
  }

  static class Deserializer extends JsonDeserializer<Job> {
    @Override
    public Job deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException, JacksonException {
      JsonNode node = p.getCodec().readTree(p);
      var company = node.hasNonNull("c") ? node.get("c").asText() : null;
      var title = node.hasNonNull("t") ? node.get("t").asText() : null;
      var dep = node.hasNonNull("d") ? node.get("d").asText() : null;
      return new Job(title, company, dep);
    }
  }

  @Override
  public String toString() {
    return "Job{" +
        "title='" + title + '\'' +
        ", company='" + company + '\'' +
        ", department='" + department + '\'' +
        '}';
  }
}
