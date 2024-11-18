package jpabook.jpashop;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

//데이터베이스 관련 코드
@Repository
public class MemberRepository {

    @PersistenceContext //엔티티 매니저
    private EntityManager em;

    /*//저장 코드
    public Long save(Member member) {
        em.persist(member);
        return member.getId(); //저장된 멤버 id값 반환
    }

    //조회 코드
    public Member find(Long id) {
        return em.find(Member.class, id); //id를 통해 찾은 멤버 반환
    }*/
}
