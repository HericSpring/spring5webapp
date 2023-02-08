package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("John", "Thompson");
        Book book = new Book("Java", "123123");

//        Tarefa do curso
        Publisher saraiva = new Publisher("Saraiva", "Rua Amazonas", 4321, "Santo André",
                "São Paulo");

        author.getBook().add(book);
        authorRepository.save(author);

        book.getAuthors().add(author);
        bookRepository.save(book);

        saraiva.getBooks().add(book);
        publisherRepository.save(saraiva);

        book.setPublisher(saraiva);
        bookRepository.save(book);

        System.out.println("Publisher: " + saraiva);
        System.out.println("Quantidade de livros: " + saraiva.getBooks().size());
    }
}
