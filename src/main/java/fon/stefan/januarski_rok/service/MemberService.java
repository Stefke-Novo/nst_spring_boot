package fon.stefan.januarski_rok.service;

import fon.stefan.januarski_rok.dto.MemberDto;

import java.util.List;

public interface MemberService {
    MemberDto createMember(MemberDto member) throws Exception;
    MemberDto getMember(MemberDto member) throws Exception;
    List<MemberDto> getAllMembers();
    MemberDto updateMember(MemberDto member) throws Exception;
    MemberDto deleteMember(MemberDto member) throws Exception;
}
