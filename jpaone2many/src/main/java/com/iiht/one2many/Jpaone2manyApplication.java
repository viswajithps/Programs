package com.iiht.one2many;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iiht.one2many.entity.Book;
import com.iiht.one2many.entity.Page;
import com.iiht.one2many.repository.BookRepository;
import com.iiht.one2many.repository.PageRepository;

@SpringBootApplication
public class Jpaone2manyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jpaone2manyApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner mappingDemo(BookRepository bookRepository,PageRepository pageRepository) {
//		return args->{
//			Book book =new Book("Spring Boot","Josh Lang","8735");
//			Page p1=new Page(1,"Introduction","Beautiful Spring");
//			Page p2=new Page(65,"Java8 Contents","Java 8 Lambda");
//			Page p3=new Page(95,"Concurrency","Virtual Threads");
//			
//			book.getPages().add(p1);
//			book.getPages().add(p2);
//			book.getPages().add(p3);
//			
//			bookRepository.save(book);
//			
//		};
//	}
	
	
	@Bean
    public CommandLineRunner mappingDemo(BookRepository bookRepository,
                                         PageRepository pageRepository) {
        return args -> {

            // create a new book
            Book book = new Book("Spring", "Jones Doe", "3435");

            // save the book
            bookRepository.save(book);

            // create and save new pages
            pageRepository.save(new Page(1, "Introduction ", "Introduction", book));
            pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
            pageRepository.save(new Page(95, "Concurrency", "Concurrency", book));
        };
    }

}
