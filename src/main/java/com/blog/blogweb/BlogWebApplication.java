package com.blog.blogweb;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.blog.blogweb.data.PostRepository;
import com.blog.blogweb.model.Author;
import com.blog.blogweb.model.Comment;
import com.blog.blogweb.model.Post;

@SpringBootApplication
public class BlogWebApplication {

    private static final Logger log = LoggerFactory.getLogger(BlogWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BlogWebApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, PostRepository postRepository) {
        return args -> {
            log.info("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                log.info(beanName);
            }

            Post post1 = new Post("post1", "post body", new Author("Sherlock"));
            post1.addComment(new Comment("comment1", post1));
            postRepository.save(post1);
            postRepository.save(new Post("post2", "post body2", new Author("Merlin")));


            log.info("Posts found with findAll():");
            log.info("-------------------------------");
            for (Post post : postRepository.findAll()) {
                log.info(post.toString());
            }
            log.info("");

            Optional<Post> postOptional = postRepository.findById(1L);
            Post post = postOptional.orElseThrow(() -> new IllegalArgumentException("No such id exists"));
            log.info("Post with findById");
            log.info(post.toString());

        };
    }

}
