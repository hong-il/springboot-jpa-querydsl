package boot.jpa.querydsl.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

import static boot.jpa.querydsl.domain.QHero.hero;

@Repository
public class HeroRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param jpaQueryFactory
     */
    public HeroRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Hero.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Hero> findByName(String name) {
        return jpaQueryFactory
                .selectFrom(hero)
                .where(hero.name.eq(name))
                .fetch();
    }

    @Transactional
    public void deleteByName(String name) {
        jpaQueryFactory
        .delete(hero)
        .where(hero.name.eq(name))
        .execute();
    }

    @Transactional
    public void updateByName(String note) {
        jpaQueryFactory
        .update(hero)
        .set(hero.name, note)
        .execute();
    }

    public List<Hero> findAllOrderBy() {
        return jpaQueryFactory
                .selectFrom(hero)
                .orderBy(hero.id.desc())
                .fetch();
    }

}
