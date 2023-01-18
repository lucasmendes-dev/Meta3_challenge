package com.meta3.meta3_challenge.controller;

import com.meta3.meta3_challenge.model.Post;
import com.meta3.meta3_challenge.service.Meta3blogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
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

    @RequestMapping(value = "/posts/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editPost(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("editPost");
        Post post = meta3blogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/posts/{id}/edit", method = RequestMethod.POST)
    public String saveEditedPost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos");
            return "redirect:/newpost";
        }
        meta3blogService.save(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "newpost", method = RequestMethod.GET)
    public String getPostForm() {
        return "postForm";
    }

    @RequestMapping(value = "newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        meta3blogService.save(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/posts/{id}/delete", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") long id, RedirectAttributes attributes) {
        meta3blogService.deleteById(id);
        attributes.addFlashAttribute("mensagem", "Post excluído com sucesso");
        return "redirect:/posts";
    }
}
