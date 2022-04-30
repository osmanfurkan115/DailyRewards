package io.github.osmanfurkan115.dailyrewards.storage;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface CrudRepository<T, ID> {

    void initialize();

    CompletableFuture<List<T>> findAll();

    CompletableFuture<Optional<T>> findById(ID id);

    void save(T data);

    void saveAll(List<T> data);

    void delete(ID id);
}
