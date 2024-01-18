package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.converter.impl.AcademicTitleConverter;
import fon.stefan.januarski_rok.converter.impl.MemberConverter;
import fon.stefan.januarski_rok.converter.impl.ScientificFieldConverter;
import fon.stefan.januarski_rok.domain.AcademicTitleHistory;
import lombok.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicTitleHistoryDto {

    @JsonProperty(value = "member", required = true)
    private MemberDto memberDto;

    @JsonProperty(value = "ascademic_title",required = true)
    private AcademicTitleDto academicTitleDto;

    @JsonProperty(value = "scientific_field")
    private ScientificFieldDto scientificFieldDto;

    @JsonProperty(value = "start_date")
    private String startDate;

    @JsonProperty(value = "end_date")
    private String endDate;

    public AcademicTitleHistoryDto(AcademicTitleHistory academicTitleHistory) {
        this.memberDto = new MemberConverter().toDto(academicTitleHistory.getMember());
        this.academicTitleDto= new AcademicTitleConverter().toDto(academicTitleHistory.getAcademicTitle());
        this.startDate = AcademicTitleHistoryDto.toString(academicTitleHistory.getStartDate());
        this.endDate = AcademicTitleHistoryDto.toString(academicTitleHistory.getEndDate());
        this.scientificFieldDto = new ScientificFieldConverter().toDto(academicTitleHistory.getScientificField());
    }


    public static Date toDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(date);
    }
    public static String toString(Date date){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
