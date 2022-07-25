package com.blog.blogweb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * "id": number, "name": String, "username": String, "email": String, “address": String
 */
@Entity
public class Author implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("username")
  private String username;

  @JsonProperty("email")
  private String email;

  @JsonProperty("address")
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
