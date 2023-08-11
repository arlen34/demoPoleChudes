package kg.polechudes.demo.service;

import kg.polechudes.demo.entity.Word;
import kg.polechudes.demo.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class WordService {
    private final WordRepository wordRepository;

    public Word getRandomWordWithQuestion(){
        List<Word> words = wordRepository.findAll();
        if (!words.isEmpty()){
            int randomIndex = new Random().nextInt(words.size());
            return words.get(randomIndex);
        }
        return null;
    }
}
