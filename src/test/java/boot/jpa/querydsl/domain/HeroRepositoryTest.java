package boot.jpa.querydsl.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class HeroRepositoryTest {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private HeroRepositorySupport heroRepositorySupport;

    @AfterEach
    public void tearDown() throws Exception {
        heroRepository.deleteAllInBatch();
    }

    @Test
    public void HeroFindByNameResponseTest() {
        //given
        Hero input = Hero.builder()
                .name("hong-il")
                .age(27)
                .note("github.com/hong-il")
                .build();

        heroRepository.save(input);

        //when
        List<Hero> output = heroRepositorySupport.findByName("hong-il");

        //then
        assertThat(output.size(), is(1));
        assertThat(output.get(0).getName(), is("hong-il"));
    }

    @Test
    public void HeroDeleteByNameRequestTest() {
        //given
        Hero input = Hero.builder()
                .name("hong-il")
                .age(27)
                .note("github.com/hong-il")
                .build();

        heroRepository.save(input);

        //when
        heroRepositorySupport.deleteByName("hong-il");

        //then
        assertThat(heroRepository.findAll().size(), is(0));
    }

    @Test
    public void HeroUpdateByNameRequestTest() {
        //given
        Hero input = Hero.builder()
                .name("hong-il")
                .age(27)
                .note("github.com/hong-il")
                .build();

        heroRepository.save(input);

        //when
        heroRepositorySupport.updateByName("github.com/hong-il");

        //then
        assertThat(heroRepository.findAll().get(0).getName(), is("github.com/hong-il"));
    }
}
