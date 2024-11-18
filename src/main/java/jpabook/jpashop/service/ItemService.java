package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //조회시 사용
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    //상품 등록
    @Transactional //등록하는 경우
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    //상품 목록 조회
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
