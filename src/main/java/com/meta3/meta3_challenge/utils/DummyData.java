package com.meta3.meta3_challenge.utils;


import com.meta3.meta3_challenge.model.Post;
import com.meta3.meta3_challenge.repository.BlogRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    BlogRepository blogRepository;

    //@PostConstruct
    public void savePost() {

        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        post1.setAutor("Lucas Mendes");
        post1.setData(LocalDate.now());
        post1.setTitulo("Blog teste");
        post1.setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed auctor, magna id malesuada bibendum, risus magna bibendum nibh, a semper elit turpis et nulla. Integer eget augue euismod, interdum ipsum a, malesuada turpis. Aliquam erat volutpat. Curabitur non metus a metus interdum auctor. Sed tincidunt congue libero, id accumsan ipsum posuere at. Sed velit velit, malesuada vel malesuada a, fringilla at est. Sed id justo eget risus gravida convallis. Sed auctor, magna id malesuada bibendum, risus magna bibendum nibh, a semper elit turpis et nulla.\n" +
                "\n");

        Post post2 = new Post();
        post2.setAutor("User Teste");
        post2.setData(LocalDate.now());
        post2.setTitulo("Testando dados populados");
        post2.setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed auctor, magna id malesuada bibendum, risus magna bibendum nibh, a semper elit turpis et nulla. Integer eget augue euismod, interdum ipsum a, malesuada turpis. Aliquam erat volutpat. Curabitur non metus a metus interdum auctor. Sed tincidunt congue libero, id accumsan ipsum posuere at. Sed velit velit, malesuada vel malesuada a, fringilla at est. Sed id justo eget risus gravida convallis. Sed auctor, magna id malesuada bibendum, risus magna bibendum nibh, a semper elit turpis et nulla.\n" +
                "\n");

        postList.add(post1);
        postList.add(post2);

        for(Post post: postList) {
            Post postSaved = blogRepository.save(post);
            System.out.println(postSaved.getId());
        }

    }


}
