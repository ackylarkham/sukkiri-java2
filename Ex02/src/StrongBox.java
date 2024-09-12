import java.util.*;

public class StrongBox<E> {
    private E item;
    private KeyType keyType;
    private long retryCount;
    Map<KeyType, Long> keys = new HashMap<KeyType, Long>();

    public StrongBox(KeyType k) {
        this.keyType = k;
        switch (k) {
            case PADLOCK:
                keys.put(k,1024L);
                break;
            case BUTTON:
                keys.put(k,10000L);
                break;
            case DIAL:
                keys.put(k,30000L);
                break;
            case FINGER:
                keys.put(k,1000000L);
                break;        
        }
    }

    public E get() {
        this.retryCount ++;
        if (this.retryCount < keys.get(this.keyType)) {
            return null;
        }
        return (this.item);
    }

    public void put(E i) {
        this.item = i;
    }

    public KeyType getKeyType() {
        return this.keyType;
    }
}
