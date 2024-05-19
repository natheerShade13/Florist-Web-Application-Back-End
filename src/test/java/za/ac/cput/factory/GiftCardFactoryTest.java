package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.GiftCard;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GiftCardFactoryTest {

    private GiftCard giftCardA;
    private GiftCard giftCardB;
    private GiftCard giftCardC;

    @Test
    @Order(1)
    void buildGiftCards() {
        giftCardA = GiftCardFactory.buildGiftCards(123456789, 100, 4561, 1000
                , false);
        assertNotNull(giftCardA);
        System.out.println(giftCardA);
    }

    @Test
    @Order(2)
    void copyBuildGiftCards() {
        giftCardC = GiftCardFactory.buildGiftCards(123456789, 100, 4561, 1000
                , false);
        giftCardB = new GiftCard.Builder().copy(giftCardC).setAmount(5000).build();
        assertNotNull(giftCardB);
        System.out.println(giftCardB);
    }
}