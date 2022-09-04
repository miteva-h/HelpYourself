package dnick.zad5.helpyourself.service.impl;

import dnick.zad5.helpyourself.model.News;
import dnick.zad5.helpyourself.model.exceptions.InvalidNewsIdException;
import dnick.zad5.helpyourself.repository.NewsRepository;
import dnick.zad5.helpyourself.repository.UserRepository;
import dnick.zad5.helpyourself.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    public NewsServiceImpl(NewsRepository newsRepository, UserRepository userRepository) {
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;

    }

    @Override
    public Page<News> findPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 5);
        return newsRepository.findAll(pageable);
    }

    @Override
    public List<News> listAll() {
        return newsRepository.findAll();
    }

    @Override
    public News findById(Long id) {
        return newsRepository.findById(id).orElseThrow(() -> new InvalidNewsIdException());
    }

    @Override
    public News create(String url, String title, String photoUrl, LocalDate date) {
        return newsRepository.save(new News(url, title, photoUrl, date));
    }

    @Override
    public News update(Long id, String url, String title, String photoUrl, LocalDate date) {
        News n = newsRepository.findById(id).orElseThrow(() -> new InvalidNewsIdException());
        n.setUrl(url);
        n.setTitle(title);
        n.setPhotoUrl(photoUrl);
        n.setDate(date);
        newsRepository.save(n);
        return n;
    }

    @Override
    public News delete(Long id) {
        News n = newsRepository.findById(id).orElseThrow(() -> new InvalidNewsIdException());
        newsRepository.delete(n);
        return n;
    }

    @Override
    public List<News> listAllByDateAfter(LocalDate dateAfter) {
        return newsRepository.findAllByDateAfter(dateAfter);
    }

    @Override
    public List<News> listAllByTitleContaining(String word) {
        return newsRepository.findAllByTitleContainingIgnoreCase(word);
    }
}
