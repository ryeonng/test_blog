package com.tenco.blog.repository.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Posts {

	private int id;
	private String title;
	private String content;
	private String username;
	private String password;
	private Timestamp createdAt;
	
}
