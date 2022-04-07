package ru.digitalleague.jackson;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Gender {
  MAN,
  WOMEN,
  @JsonEnumDefaultValue
  UNKNOWN
}
