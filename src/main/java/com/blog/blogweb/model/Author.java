package com.blog.blogweb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * "id": number, "name": String, "username": String, "email": String, “address": String
 */
@Entity
public class Author
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private String username;

  private String email;

  private String address;

  @OneToMany()
  List<Post> posts;

  protected Author(){}

  public Author(String name){
    this.name = name;
  }

  @Override
  public String toString()
  {
    return String.format("Auth- id:%d, name: '%s'",id, name);
  }
}
