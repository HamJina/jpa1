package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    //상품 저장
    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item); //item을 처음 저장할때는 id값 없을 것임(완전히 새로 생성한 객체)
        } else {
            em.merge(item); //나중에 다시 설명
        }
    }

    //상품 한개 찾기
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    //상품 모두 찾기
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
