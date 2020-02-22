package boot.jpa.querydsl.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPower is a Querydsl query type for Power
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPower extends EntityPathBase<Power> {

    private static final long serialVersionUID = 1852464837L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPower power1 = new QPower("power1");

    public final QHero hero;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath power = createString("power");

    public QPower(String variable) {
        this(Power.class, forVariable(variable), INITS);
    }

    public QPower(Path<? extends Power> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPower(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPower(PathMetadata metadata, PathInits inits) {
        this(Power.class, metadata, inits);
    }

    public QPower(Class<? extends Power> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hero = inits.isInitialized("hero") ? new QHero(forProperty("hero")) : null;
    }

}

