package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
