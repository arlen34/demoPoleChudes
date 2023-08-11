package kg.polechudes.demo.repository;

import kg.polechudes.demo.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}