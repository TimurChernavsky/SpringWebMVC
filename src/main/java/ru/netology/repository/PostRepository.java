package ru.netology.repository;
import ru.netology.model.Post;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository implements PostRepositoryInterface {
    private final ConcurrentHashMap<Long, Post> list = new ConcurrentHashMap<>();
    private final AtomicLong postID = new AtomicLong(1);

    public List<Post> all() {
        return new ArrayList<>(list.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(list.get(id));
    }


    public Post save(Post post) {
        postID.incrementAndGet();
        list.put(postID.get(), post);
        return post;
    }

    public void removeById(long id) {
        list.remove(id);
    }
}
