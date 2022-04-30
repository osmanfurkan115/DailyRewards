package io.github.osmanfurkan115.dailyrewards.storage.user;

import io.github.osmanfurkan115.dailyrewards.storage.CrudRepository;
import io.github.osmanfurkan115.dailyrewards.user.User;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface UserRepository extends CrudRepository<User, UUID> {

    CompletableFuture<List<User>> findUserByDay(int day);
}
