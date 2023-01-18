package com.meta3.meta3_challenge.controller;

import com.meta3.meta3_challenge.model.Post;
import com.meta3.meta3_challenge.service.Meta3blogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Meta3blogController {

    @Autowired
    Meta3blogService meta3blogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = meta3blogService.findAll();
        mv.addObject("posts", posts);

        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = meta3blogService.findById(id);
        mv.addObject("post", post);

        return mv;
    }

}
