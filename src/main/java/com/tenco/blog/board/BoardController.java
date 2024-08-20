package com.tenco.blog.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.blog.repository.model.Posts;
import com.tenco.blog.service.PostsService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final PostsService postsService;

    /**
     * 게시글 목록 페이지 요청
     * @param 
     * @return 
     */
    @GetMapping({"/list", "/"})
    public String listPage(Model model) {
        List<Posts> postsList = postsService.findAll();
        model.addAttribute("postsList", postsList);
        return "board/list";  
    }

    /**
     * 게시글 저장
     */
    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       @RequestParam("title") String title,
                       @RequestParam("content") String content) {
        Posts post = Posts.builder()
                          .username(username)
                          .password(password)
                          .title(title)
                          .content(content)
                          .build();
        postsService.savePost(post);
        return "redirect:/board/list";
    }

    
    // 게시글 삭제 처리
    @PostMapping("/delete")
    public String deletePost(@RequestParam("id") int id,
                             @RequestParam(value = "password", required = false) String password,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        if ("delete".equals(action)) {
            model.addAttribute("id", id);
            return "board/list"; 
        } else if ("confirm".equals(action) && password != null) {
            boolean isPasswordValid = checkPassword(id, password);
            if (isPasswordValid) {
                postsService.deleteById(id);
                model.addAttribute("successMessage", "게시글이 삭제되었습니다.");
            } else {
                model.addAttribute("errorMessage", "비밀번호가 올바르지 않습니다.");
            }
            return "redirect:/board/list"; 
        }
        return "redirect:/board/list";
    }

    /**
     * 게시글 수정 화면 표시
     */
    @GetMapping("/{id}/updateForm")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Posts post = postsService.findById(id);
        model.addAttribute("post", post);
        return "board/updateForm"; 
    }

    /**
     * 게시글 비밀번호 검증
     */
    private boolean checkPassword(int id, String password) {
        Posts post = postsService.findById(id);
        return post != null && post.getPassword().equals(password);
    }
    /**
     * 글쓰기 화면 요청
     * @return
     */
    @GetMapping("/saveForm")
    public String showSaveForm() {
        return "board/saveForm"; 
    }
    
    /**
     * 게시물 수정
     * @return
     */
    @PostMapping("/update")
    public String updatePost(@RequestParam("id") int id,
                             @RequestParam("author") String author,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam("password") String password,
                             Model model) {
        Posts existingPost = postsService.findById(id);
        if (existingPost == null) {
            model.addAttribute("errorMessage", "게시글을 찾을 수 없습니다.");
            return "redirect:/board/list";
        }

        // 비밀번호 검증
        if (!existingPost.getPassword().equals(password)) {
            model.addAttribute("errorMessage", "비밀번호가 올바르지 않습니다.");
            return "board/updateForm?id=" + id;
        }

        // 게시글 정보를 업데이트
        Posts updatedPost = existingPost.builder()
                                        .username(author)
                                        .title(title)
                                        .content(content)
                                        .password(password)  
                                        .build();
        postsService.savePost(updatedPost);

        return "redirect:/board/list"; 
    }

    
    
}
