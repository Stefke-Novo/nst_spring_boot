package fon.stefan.januarski_rok.service;

import fon.stefan.januarski_rok.dto.MemberDto;

public interface MemberService {
    MemberDto createMember(MemberDto member) throws Exception;
}
