package com.example.restserverapi;

import com.example.restserverapi.service.AuthorServiceImpl;
import com.example.restserverapi.service.BookServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {
    private final AuthorServiceImpl authorService;
    private  final BookServiceImpl bookService;

    public AppInit(AuthorServiceImpl authorService, BookServiceImpl bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(authorService.countOfRepository()==0){
            inintJovkov();
            inintHaytov();
            inintDimitarTalev();
            inintIvanVazov();
            inintElinPelin();
        }


    }

    private void inintElinPelin() {
        authorService.initAuthor("Елин Пелин",
                "Пижо и Пендо",
                "Ян Бибиян на луната",
                "Под манастирската лоза");
    }

    private void inintIvanVazov() {
        authorService.initAuthor("Иван Вазов",
                "Пряпорец и Гусла",
                "Под Игото",
                "Тъгите на България");
    }

    private void inintDimitarTalev() {
        authorService.initAuthor("Димитър Димов",
                "Тютюн");

    }

    private void inintHaytov() {
    authorService.initAuthor(  "Николай Хайтов",
            "Диви Разкази"
    );
    }

    private void inintJovkov() {
        authorService.initAuthor("Йордан Йовков",
                "Старопланински легенди",
                "Чифликът край границата");
    }
}
