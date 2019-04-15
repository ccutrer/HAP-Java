package io.github.hapjava.characteristics;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

/**
 * Characteristic that exposes an Enum value. Enums are represented as an Integer value in the
 * Homekit protocol, and classes extending this one must handle the static mapping to an Integer
 * value.
 *
 * @author Andy Lintner
 */
public abstract class EnumCharacteristic extends BaseCharacteristic<Integer> {

  private final int maxValue;
  private final Optional<List<Integer>> validValues;

  /**
   * Default constructor
   *
   * @param type a string containing a UUID that indicates the type of characteristic. Apple defines
   *     a set of these, however implementors can create their own as well.
   * @param isWritable indicates whether the value can be changed.
   * @param isReadable indicates whether the value can be retrieved.
   * @param description a description of the characteristic to be passed to the consuming device.
   * @param maxValue the number of enum items.
   */
  public EnumCharacteristic(
      String type, boolean isWritable, boolean isReadable, String description, int maxValue) {
    super(type, "int", isWritable, isReadable, description);
    this.maxValue = maxValue;
    this.validValues = Optional.empty();
  }

  /**
   * Default constructor
   *
   * @param type a string containing a UUID that indicates the type of characteristic. Apple defines
   *     a set of these, however implementors can create their own as well.
   * @param isWritable indicates whether the value can be changed.
   * @param isReadable indicates whether the value can be retrieved.
   * @param description a description of the characteristic to be passed to the consuming device.
   * @param maxValue the number of enum items.
   * @param validValues a list of values allowed for this instance of the characteristic.
   */
  public EnumCharacteristic(
      String type,
      boolean isWritable,
      boolean isReadable,
      String description,
      int maxValue,
      List<Integer> validValues) {
    super(type, "int", isWritable, isReadable, description);
    this.maxValue = maxValue;
    this.validValues = Optional.of(validValues);
  }

  /** {@inheritDoc} */
  @Override
  protected CompletableFuture<JsonObjectBuilder> makeBuilder(int iid) {
    return super.makeBuilder(iid)
        .thenApply(
            builder -> {
              builder.add("minValue", 0).add("maxValue", maxValue).add("minStep", 1);
              validValues.ifPresent(
                  values -> {
                    JsonArrayBuilder valuesJson = Json.createArrayBuilder();
                    values.forEach(
                        v -> {
                          valuesJson.add(v);
                        });
                    builder.add("valid-values", valuesJson);
                  });
              return builder;
            });
  }

  /** {@inheritDoc} */
  @Override
  protected Integer convert(JsonValue jsonValue) {
    if (jsonValue instanceof JsonNumber) {
      return ((JsonNumber) jsonValue).intValue();
    } else if (jsonValue == JsonObject.TRUE) {
      return 1; // For at least one enum type (locks), homekit will send a true instead of 1
    } else if (jsonValue == JsonObject.FALSE) {
      return 0;
    } else {
      throw new IndexOutOfBoundsException("Cannot convert " + jsonValue.getClass() + " to int");
    }
  }

  /** {@inheritDoc} */
  @Override
  protected Integer getDefault() {
    return 0;
  }
}
