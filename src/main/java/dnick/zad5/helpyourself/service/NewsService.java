package dnick.zad5.helpyourself.service;

import dnick.zad5.helpyourself.model.News;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface NewsService {

    Page<News> findPage(int pageNumber);
    List<News> listAll();
    News findById(Long id);
    News create(String url, String title, String photoUrl, LocalDate date);
    News update(Long id, String url, String title, String photoUrl, LocalDate date);
    News delete(Long id);
    List<News> listAllByDateAfter(LocalDate dateAfter);
    List<News> listAllByTitleContaining(String word);
}
