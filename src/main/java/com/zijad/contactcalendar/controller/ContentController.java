package com.zijad.contactcalendar.controller;

import com.zijad.contactcalendar.model.Content;
import com.zijad.contactcalendar.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.repository =  contentCollectionRepository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }
}
