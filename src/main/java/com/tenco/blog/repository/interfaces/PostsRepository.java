package com.tenco.blog.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.blog.repository.model.Posts;
@Mapper
public interface PostsRepository {

	public int insert(Posts posts); // 게시글 작성
	public int deleteById(int id); // 게시글 삭제
	public int updateById(Posts posts); // 게시글 수정
	
	public List<Posts> findAll(); // 게시글 조회
	Posts findById(int id);
}
