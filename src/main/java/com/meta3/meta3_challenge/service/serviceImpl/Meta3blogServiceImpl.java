package com.meta3.meta3_challenge.service.serviceImpl;

import com.meta3.meta3_challenge.model.Post;
import com.meta3.meta3_challenge.repository.BlogRepository;
import com.meta3.meta3_challenge.service.Meta3blogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Meta3blogServiceImpl implements Meta3blogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Post> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return blogRepository.save(post);
    }

    @Override
    public Post edit(Post post){
        return blogRepository.save(post);
    }

    @Override
    public void deleteById(long id) {
         blogRepository.deleteById(id);
    }

}
