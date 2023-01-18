package com.meta3.meta3_challenge.service;

import com.meta3.meta3_challenge.model.Post;

import java.util.List;

public interface Meta3blogService {

    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);
    Post edit(Post post);
    void deleteById(long id);


}
