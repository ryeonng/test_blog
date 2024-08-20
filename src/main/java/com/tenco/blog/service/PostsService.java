package com.tenco.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenco.blog.repository.interfaces.PostsRepository;
import com.tenco.blog.repository.model.Posts;

@Service
public class PostsService {

	private final PostsRepository postsRepository;
	
	@Autowired
	public PostsService(PostsRepository postsRepository) {
		this.postsRepository = postsRepository;
	}
	
	/**
	 * 게시글 목록
	 * @return
	 */
	 public List<Posts> findAll() {
	        return postsRepository.findAll();
	    }
	
	 /**
	     * 게시글 삭제
	     * @param id
	     * @return 
	     */
	    public int deleteById(int id) {
	        return postsRepository.deleteById(id);
	    }

	    /**
	     * 게시글 저장
	     * @param posts
	     * @return 
	     */
	    public int savePost(Posts posts) {
	        return postsRepository.insert(posts);
	    }
	    

	    /**
	     * 게시글 조회
	     * @param id
	     * @return
	     */
	    public Posts findById(int id) {
	        return postsRepository.findById(id);
	    }
	    
	    /**
	     * 게시글 저장
	     * @param posts
	     * @return 
	     */
	    public int updatePost(Posts posts) {
	        if (posts.getId() > 0) {
	            return postsRepository.updateById(posts);
	        } else {
	            return postsRepository.insert(posts);
	        }
	    }
	    
}
