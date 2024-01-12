package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void save(){
        Member result = new Member(3,9,"First name 10","Last name 10","Academic title 1","Education title 1","Scientific field 1");
        result = memberRepository.save(result);
        System.out.println(result.toString());
    }
}