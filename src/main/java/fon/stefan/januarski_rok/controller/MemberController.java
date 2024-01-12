package fon.stefan.januarski_rok.controller;

import fon.stefan.januarski_rok.dto.MemberDto;
import fon.stefan.januarski_rok.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping
    public ResponseEntity<MemberDto> getMember(@RequestBody MemberDto member) throws Exception {

        return new ResponseEntity<>(memberService.getMember(member),HttpStatus.OK);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<MemberDto>> getAllMembers(){
        return new ResponseEntity<>(memberService.getAllMembers(),HttpStatus.OK);
    }
    @PostMapping(path = "/update")
    public ResponseEntity<MemberDto> updateMember(@RequestBody MemberDto member) throws Exception {
        return new ResponseEntity<>(memberService.updateMember(member), HttpStatus.OK);
    }
    @PostMapping(path = "/delete")
    public ResponseEntity<MemberDto> deleteMember(@RequestBody MemberDto member) throws Exception{
        return new ResponseEntity<>(memberService.deleteMember(member),HttpStatus.OK);
    }
}
