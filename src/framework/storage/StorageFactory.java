package framework.storage;

public class StorageFactory<O,K> {

    public static <O extends Storable<K>,K> Storage<O,K> getMemoryStorage(){
        return new MemoryStorage<O,K>();
    }

}
