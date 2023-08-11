package kg.polechudes.demo.api;

import kg.polechudes.demo.entity.Word;
import kg.polechudes.demo.repository.WordRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final WordRepository wordRepository;

    public AdminController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }
    @GetMapping("/addWord")
    public String showAddWordForm(Model model){
     model.addAttribute("word", new Word());
     return "addWordForm";
    }

    @PostMapping("/addWord")
    public String addWord(@ModelAttribute Word word){
        wordRepository.save(word);
        return "redirect:/admin/addWord?success";
    }
}
