package hello.itemservice.domain.item;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item){
        if(Objects.isNull(item.getId())){
            item.setId(++sequence);
        }
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }
    public void update(Long itemId, Item updateItem){
        Item findItem = findById(itemId);
        findItem.setItemName(updateItem.getItemName());
        findItem.setPrice(updateItem.getPrice());
        findItem.setQuantity(updateItem.getQuantity());
        findItem.setOpen(updateItem.getOpen());
        findItem.setRegions(updateItem.getRegions());
        findItem.setItemType(updateItem.getItemType());
        findItem.setDeliveryCode(updateItem.getDeliveryCode());
    }

    public void clearStore(){
        store.clear();
    }
}
