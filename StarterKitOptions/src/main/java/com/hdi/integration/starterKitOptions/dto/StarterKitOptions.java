package com.hdi.integration.starterKitOptions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hdi.integration.starterKitOptions.util.ObjectConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Start Kit Options for insurance policy
 */
@ApiModel(description = "Start Kit Options for insurance policy")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-11T14:23:30.536Z")

public class StarterKitOptions {

  public StarterKitOptions(){}

  public StarterKitOptions(Object id, Object description, Object flagReason) {
    this.id = ObjectConverter.convert(id, Long.class);
    this.description = ObjectConverter.convert(description, String.class);
    this.flagReason = ObjectConverter.convert(flagReason, Boolean.class);
  }

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("flagReason")
  private Boolean flagReason = null;

  public StarterKitOptions id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Type of option ID
   * @return id
  **/
  @ApiModelProperty(value = "Type of option ID")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public StarterKitOptions description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description od option
   * @return description
  **/
  @ApiModelProperty(value = "Description od option")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public StarterKitOptions flagReason(Boolean flagReason) {
    this.flagReason = flagReason;
    return this;
  }

  /**
   * Flag to enable fill reason
   * @return flagReason
  **/
  @ApiModelProperty(value = "Flag to enable fill reason")


  public Boolean isFlagReason() {
    return flagReason;
  }

  public void setFlagReason(Boolean flagReason) {
    this.flagReason = flagReason;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StarterKitOptions starterKitOptions = (StarterKitOptions) o;
    return Objects.equals(this.id, starterKitOptions.id) &&
        Objects.equals(this.description, starterKitOptions.description) &&
        Objects.equals(this.flagReason, starterKitOptions.flagReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, flagReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StarterKitOptions {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    flagReason: ").append(toIndentedString(flagReason)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

