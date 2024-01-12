package fon.stefan.januarski_rok.controller;

import fon.stefan.januarski_rok.dto.MemberDto;
import fon.stefan.januarski_rok.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto member) throws Exception {
        return new ResponseEntity<>(memberService.createMember(member), HttpStatus.OK);
    }
}
