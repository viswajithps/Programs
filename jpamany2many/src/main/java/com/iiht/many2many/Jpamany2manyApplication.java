package com.iiht.many2many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iiht.many2many.model.Post;
import com.iiht.many2many.model.Tag;
import com.iiht.many2many.repository.PostRepository;
import com.iiht.many2many.repository.TagRepository;

@SpringBootApplication
public class Jpamany2manyApplication {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	TagRepository tagRepository;

	public static void main(String[] args) {
		SpringApplication.run(Jpamany2manyApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		
	//postsRepository.deleteAllInBatch();
	// tagsRepository.deleteAllInBatch();
		 
		 Post post = new Post("JPA Hibernate Many to Many example using Spring Boot",
                 "Leran how to map a many to many relationship using JPA" ," Code example with Java Maven");

		     
		 	 Tag tag1  = new Tag("Spring Boot");
           Tag tag2 = new Tag("JPA - Hibernate");
           
            post.getTags().add(tag1);
            post.getTags().add(tag2);
           
           tag1.getPosts().add(post);
           tag2.getPosts().add(post);
           
           postRepository.save(post);
//           tagsRepository.save(tag1);
//           tagsRepository.save(tag2);

}
