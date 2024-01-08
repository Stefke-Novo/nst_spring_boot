package fon.stefan.januarski_rok.converter.impl;

import fon.stefan.januarski_rok.converter.DtoEntityConverter;
import fon.stefan.januarski_rok.domain.Member;
import fon.stefan.januarski_rok.dto.MemberDto;

public class MemberConverter implements DtoEntityConverter<MemberDto, Member> {
    @Override
    public MemberDto toDto(Member member) {
        return new MemberDto(member.getFirstName(),member.getLastName(),member.getAcademicTitles().getLast().getAcademicTitle().getTitle(),member.getEducationTitle().getTitle(),member.getAcademicTitles().getLast().getScientificField().getName());
    }

    @Override
    public Member toEntity(MemberDto memberDto) {
        return new Member(0,memberDto.getFirstName(),memberDto.getLastName());
    }
}
