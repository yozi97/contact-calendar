package com.zijad.contactcalendar.repository;

import com.zijad.contactcalendar.model.Content;
import com.zijad.contactcalendar.model.Status;
import com.zijad.contactcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {

        Content content1 = new Content(1
                , "My first Blog Post"
                , "My first blog post"
                , Status.IDEA, Type.ARTICLE
                , LocalDateTime.now()
                , null
                , "");

        content.add(content1);
    }
}
