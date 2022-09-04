package dnick.zad5.helpyourself.config;

import dnick.zad5.helpyourself.service.NewsService;
import dnick.zad5.helpyourself.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DataInitializer {

    private final UserService userService;

    private final NewsService service;

    public DataInitializer(UserService userService, NewsService service) {
        this.userService = userService;
        this.service = service;
    }

    @PostConstruct
    public void initData() {
        this.userService.create("user" + 0, "pass" + 0, "ADMIN");
        for (int i = 1; i < 4; i++) {
            this.userService.create("user" + i, "pass" + i, "USER");
        }


        this.service.create(
                "https://www.verywellmind.com/i-dont-trust-people-what-it-means-and-how-to-get-help-5219769#:~:text=Not%20being%20able%20to%20trust%20people%20can%20be%20linked%20to,undermining%20trust%20in%20other%20people.",
                "What It Means if You Don't Trust People",
                "https://www.verywellmind.com/thmb/6RU9LenXPcRWQHfHKgKIu2j9Vfk=/800x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/GettyImages-1135927624-23ae6dc621f6409a8d699bc3c2192ddd.jpg",
                LocalDate.of(2022, 7, 2)
        );
        this.service.create(
                "https://time.com/5548386/feeling-lonely-in-relationship/",
                "Feeling Lonely in Your Relationship? Here's What to Do About It",
                "https://api.time.com/wp-content/uploads/2019/03/alone-relationship.jpg?quality=85&w=800",
                LocalDate.of(2022, 7, 12)
        );
        this.service.create(
                "https://www.fingerprintforsuccess.com/blog/how-to-stop-being-jealous#",
                "How to stop being jealous: The surprising truth behind this emotion",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlGckLB16-1rNVQuNAs9XOvwq7g09p4wqLiQ&usqp=CAU",
                LocalDate.of(2022, 7, 14)
        );
        this.service.create(
                "https://thompsontee.com/blog/nervous-sweating-triggers/",
                "Why Do I Sweat When I Get Nervous?",
                "https://thompsontee.com/product_images/uploaded_images/6-nervous-sweating-triggers.jpg",
                LocalDate.of(2022, 7, 15)
        );
        this.service.create(
                "http://www.strongbonds.jss.org.au/feelings/blame.html",
                "Feeling Blamed - Strong Bonds - Building Family Connections",
                "https://cms.sehatq.com/public/img/article_img/inilah-ciri-ciri-toxic-parents-jangan-sampai-anda-melakukannya-1590511524.jpg",
                LocalDate.of(2022, 7, 25)
        );
        this.service.create(
                "https://www.aconsciousrethink.com/7567/dont-belong/",
                "Reasons You Feel Like You Don’t Belong Anywhere",
                "https://www.aconsciousrethink.com/wp-content/uploads/2018/03/dont-belong-702x336.jpg",
                LocalDate.of(2022, 7, 20)
        );
        this.service.create(
                "https://www.ditchthelabel.org/feeling-lonely-weve-got-7-things-you-can-do-to-help-deal-with-it/?gclid=Cj0KCQjwjbyYBhCdARIsAArC6LJEQmlszeSIK2KoMAJRoe7bm3Zi7k2S2dUbFoNYYOwxt1TMQ7w3kpgaAtQcEALw_wcB",
                "FEELING LONELY?",
                "https://www.aconsciousrethink.com/wp-content/uploads/2020/08/nothing-makes-you-happy-702x336.jpg",
                LocalDate.of(2022, 7, 15)
        );
        this.service.create(
                "https://www.unicef.org/parenting/mental-health/what-is-depression?gclid=Cj0KCQjwjbyYBhCdARIsAArC6LL8F_HDbJzGDa6lJGKrf2ftoDkKgFNtLYmB5_aLugmevwri16phHXoaAi-4EALw_wcB",
                "What is depression?",
                "https://images.everydayhealth.com/images/how-to-cope-with-anxiety-and-depression-722x406.jpg",
                LocalDate.of(2022, 7, 15)
        );
        this.service.create(
                "https://therapychat.com/en-gb/i-get-jealous-when-my-partner-goes-out-with-friends/",
                "I get jealous when my partner goes out with friends",
                "https://therapychat.com/wp-content/uploads/2019/09/enfados-en-la-pareja.jpg",
                LocalDate.of(2022, 7, 30)
        );
        this.service.create(
                "https://www.elitedaily.com/p/is-it-normal-to-be-jealous-of-your-partners-ex-the-answer-makes-sense-15954773#:~:text=Another%20reason%20for%20your%20jealousy,you%2C%20like%20a%20friend's%20ex.",
                "Here's What To Remember When You Get Jealous Of Your Partner's Ex, & It's So Helpful",
                "https://imgix.bustle.com/uploads/image/2019/2/14/6020b7d3-480d-4c11-9d92-2303582fc79f-stocksy_txpb3409186pjf200_small_748601.jpg?w=560&h=373&fit=crop&crop=faces&auto=format%2Ccompress",
                LocalDate.of(2022, 8, 2)
        );
        this.service.create(
                "https://www.verywellmind.com/how-important-is-alone-time-for-mental-health-5184607",
                "How Important Is Alone Time for Mental Health?",
                "https://www.aconsciousrethink.com/wp-content/uploads/2016/06/woman-alone-wide.jpg",
                LocalDate.of(2022, 8, 5)
        );


    }

}
