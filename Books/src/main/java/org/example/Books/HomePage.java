package org.example.Books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class HomePage {



        private final databook bookRepository;

        public HomePage(databook bookRepository) {
            this.bookRepository = bookRepository;
        }

        @GetMapping("/")
        public String home(Model model) {
            List<book> latestBooks = bookRepository.findTop10ByOrderByCreatedAtDesc();
            model.addAttribute("books", latestBooks);
            return "home";
        }

}

