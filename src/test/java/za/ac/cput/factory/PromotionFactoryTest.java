package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Promotion;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PromotionFactoryTest {

    private Promotion promotionA;
    private Promotion promotionB;
    private Promotion promotionC;


    @Test
    void buildPromotions() {
        promotionA = PromotionFactory.buildPromotions(123456789, "420 special",
                "Discount on cannabis products", new Date(),  new Date(),
                "End of month sale", 100);
        assertNotNull(promotionA);
        System.out.println(promotionA);
    }

    @Test
    void copyBuildPromotions() {
        promotionC = PromotionFactory.buildPromotions(987654321, "Mothers Day",
                "Special Mothers Day Combos", new Date(), new Date(), "Weekly sale",
                200);

        promotionB = new Promotion.Builder().copy(promotionC).setDiscountAmount(300).build();
        assertNotNull(promotionB);
        System.out.println(promotionB);
    }
}