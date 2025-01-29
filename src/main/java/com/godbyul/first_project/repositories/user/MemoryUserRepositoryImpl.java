package com.godbyul.first_project.repositories.user;

import com.godbyul.first_project.domains.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryUserRepositoryImpl implements UserRepository {
    static private final Map<String, User> store = new HashMap<>();

    @Override
    public User save(User user) {
        if (store.containsKey(user.getUuid())) {
            throw new IllegalStateException("이미 존재하는 유저입니다.");
        }
        store.put(user.getUuid(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String id) {
        if (!store.containsKey(id)) {
            throw new IllegalStateException("존재하지 않는 유저입니다.");
        }
        store.remove(id);
    }

    public void clear() {
        store.clear();
    }
}
