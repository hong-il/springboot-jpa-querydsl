package boot.jpa.querydsl.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHero is a Querydsl query type for Hero
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHero extends EntityPathBase<Hero> {

    private static final long serialVersionUID = -1603059142L;

    public static final QHero hero = new QHero("hero");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath note = createString("note");

    public final ListPath<Power, QPower> powers = this.<Power, QPower>createList("powers", Power.class, QPower.class, PathInits.DIRECT2);

    public QHero(String variable) {
        super(Hero.class, forVariable(variable));
    }

    public QHero(Path<? extends Hero> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHero(PathMetadata metadata) {
        super(Hero.class, metadata);
    }

}

