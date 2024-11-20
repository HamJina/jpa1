package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item.Book;
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

    @Transactional
    public void updateItem(Long id, String name, int price, int stockQuantity) {
        //itemRepository에서 찾아온 findItem은 영속 상태이다.
        Item item = itemRepository.findOne(id);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);

        //값이 변경되면 변경감지에 의해 값이 변경된다.
    }


    //상품 목록 조회
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
