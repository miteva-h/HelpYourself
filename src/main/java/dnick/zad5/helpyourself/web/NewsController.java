package dnick.zad5.helpyourself.web;

import dnick.zad5.helpyourself.model.News;
import dnick.zad5.helpyourself.service.NewsService;
import dnick.zad5.helpyourself.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class NewsController {

    private final NewsService newsService;
    private final UserService userService;

    public NewsController(NewsService newsService, UserService userService) {
        this.newsService = newsService;
        this.userService = userService;
    }

    @GetMapping( "/home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/explore/page/{pageNumber}")
    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
        Page<News> page = newsService.findPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<News> news = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("news", news);

        return "explore";
    }

    @GetMapping("/explore")
    public String getAllPages(Model model) {
        return getOnePage(model, 1);
    }

    @GetMapping("/dateAfter")
    public String getAllExploredAfterDate(Model model,
                                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateAfter) {
        if (dateAfter != null) {
            List<News> news = newsService.listAllByDateAfter(dateAfter);
            model.addAttribute("news", news);
            return "newsWithDates";
        } else {
            return getOnePage(model, 1);
        }
    }

    @GetMapping("/wordContaining")
    public String getAllExploredContainingWord(Model model,
                                               @RequestParam(required = false) String wordContaining) {
        if (!wordContaining.isEmpty()) {
            List<News> news = newsService.listAllByTitleContaining(wordContaining);
            model.addAttribute("news", news);
            return "newsWithTitles";
        } else {
            return getOnePage(model, 1);
        }
    }

    @GetMapping("/advice")
    public String showAdvice(Model model,
                             @RequestParam(required = false) String first,
                             @RequestParam(required = false) String second,
                             @RequestParam(required = false) String third) {
        if (first != null) {
            model.addAttribute("flag", "second");
            if (first.equals("stress"))
                model.addAttribute("second", "stress");
            else
                model.addAttribute("second", "sadness");
        } else if (second != null) {
            model.addAttribute("flag", "third");
            if (second.equals("family"))
                model.addAttribute("third", "family");
            else if (second.equals("colleagues"))
                model.addAttribute("third", "colleagues");
            else if (second.equals("friends"))
                model.addAttribute("third", "friends");
            else
                model.addAttribute("third", "partner");
        } else if (third != null) {
            model.addAttribute("flag", "fourth");
            if (third.equals("family1")) {
                model.addAttribute("fourth", "family1");
            } else if (third.equals("family2")) {
                model.addAttribute("fourth", "family2");
            } else if (third.equals("family3")) {
                model.addAttribute("fourth", "family3");
            } else if (third.equals("colleagues1")) {
                model.addAttribute("fourth", "colleagues1");
            } else if (third.equals("colleagues2")) {
                model.addAttribute("fourth", "colleagues2");
            } else if (third.equals("colleagues3")) {
                model.addAttribute("fourth", "colleagues3");
            } else if (third.equals("friends1")) {
                model.addAttribute("fourth", "friends1");
            } else if (third.equals("friends2")) {
                model.addAttribute("fourth", "friends2");
            } else if (third.equals("friends3")) {
                model.addAttribute("fourth", "friends3");
            } else if (third.equals("partner1")) {
                model.addAttribute("fourth", "partner1");
            } else if (third.equals("partner2")) {
                model.addAttribute("fourth", "partner2");
            } else if (third.equals("partner3")) {
                model.addAttribute("fourth", "partner3");
            }
        } else {
            model.addAttribute("flag", "first");
        }
        return "advice";
    }

    @GetMapping("/diary")
    public String getDiary(Model model, @RequestParam(required = false) String diary) {
        if (diary == null) {
            model.addAttribute("flag", false);
        } else {
            model.addAttribute("flag", true);
            model.addAttribute("date",LocalDate.now());
            model.addAttribute("diary", diary);
        }
        return "diary";
    }

    @GetMapping(path={"/start","/"})
    public String getStart() {
        return "start";
    }

}
