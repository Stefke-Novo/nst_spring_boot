package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AcademicTitleDto {
    @JsonProperty(value = "academic_title_id", required = true)
    private long id;
    @JsonProperty(value = "title")
    private String title;

    public AcademicTitleDto() {
    }

    public AcademicTitleDto(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
