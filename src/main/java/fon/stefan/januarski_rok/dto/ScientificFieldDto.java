package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScientificFieldDto {
    @JsonProperty(value = "scientific_field_id",required = true)
    private long id;
    @JsonProperty(value = "name")
    private String name;

    public ScientificFieldDto() {
    }

    public ScientificFieldDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
