package boot.jpa.querydsl.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String power;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_POWER_HERO"))
    private Hero hero;

    @Builder
    public Power(String power, Hero hero) {
        this.power = power;
        this.hero = hero;
    }
}
