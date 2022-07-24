package com.blog.blogweb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * “id” : number
 * “title” : String
 * “body” : String
 * “authorId” : number
 * “createdOn” : TimeStamp,
 * “modifiedOn” : TimeStamp
 */
@Entity
public class Post
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;

  private String body;

  private Date createdOn;

  private Date modifiedOn;

  @ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
  private Author author;

  @OneToMany(cascade=CascadeType.PERSIST)
  private final List<Comment> comments = new ArrayList<>();

  protected Post(){}

  public Post(String title, String body, Author author)
  {
    this.title = title;
    this.body = body;
    this.author = author;
  }

  @Override
  public String toString()
  {
    return String.format("Post [id=%d, title='%s', author='%s']", id,title,author.toString());
  }

  public List<Comment> getComments()
  {
    return comments;
  }

  public Author getAuthor()
  {
    return author;
  }

  public Post addComment(Comment comment)
  {
    comments.add(comment);
    return this;
  }
}
