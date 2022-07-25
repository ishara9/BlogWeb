package com.blog.blogweb.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogweb.dto.AuthorDTO;
import com.blog.blogweb.mapper.AuthorMapper;
import com.blog.blogweb.service.api.AuthorService;

@RestController
public class AuthorController
{

  @Resource
  AuthorService authorService;

  @Resource
  AuthorMapper authorMapper;

  @PostMapping("/author/register")
  public ResponseEntity<Boolean> createPost(@RequestBody AuthorDTO author)
  {
    try
    {
      authorService.createAuthor(authorMapper.map(author));
      return new ResponseEntity<>(true, HttpStatus.OK);
    }
    catch (Exception ex)
    {
      return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
  }
}
