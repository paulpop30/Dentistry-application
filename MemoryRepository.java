package repository;
import domain.Identifiable;
import java.util.HashMap;
import java.util.Map;


public class MemoryRepository <T extends Identifiable<Long>> {
    private Map<Long, T> entities=new HashMap<>();
    public void add(T entity) {
        entities.put(entity.getId(), entity);
    }
    public T find(Long id) {
        return entities.get(id);
    }
    public void update(T entity) {
        entities.put(entity.getId(), entity);
    }
    public void delete (Long id) {
        entities.remove(id);
    }
    public Map<Long,T> findAll() {
        return entities;
    }
}
