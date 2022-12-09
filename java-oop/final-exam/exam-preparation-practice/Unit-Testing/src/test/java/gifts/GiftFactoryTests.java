package gifts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiftFactoryTests {

    private static final String GIFT_TYPE = "test_gift";
    private static final double GIFT_MAGIC = 20.00;

    private GiftFactory giftFactory;
    private Gift gift;

    @Before
    public void setUp() {
        giftFactory = new GiftFactory();
        gift = new Gift(GIFT_TYPE, GIFT_MAGIC);
    }

    @Test
    public void testConstructorCreatesNewInstance() {
        giftFactory = new GiftFactory();
        assertEquals(0, giftFactory.getCount());
    }

    @Test
    public void testCreateGiftAddsToTheCollection() {
        assertEquals(0, giftFactory.getCount());
        giftFactory.createGift(gift);
        assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftThrowsWhenGiftIsAlreadyPresent() {
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);
    }

    @Test
    public void testRemoveGiftRemovesFromTheCollection() {
        assertEquals(0, giftFactory.getCount());

        giftFactory.createGift(gift);
        giftFactory.createGift(new Gift("another_gift", GIFT_MAGIC));
        assertEquals(2, giftFactory.getCount());

        giftFactory.removeGift(gift.getType());
        assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftThrowsWhenNull() {
        giftFactory.createGift(gift);
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftThrowsWhenEmpty() {
        giftFactory.createGift(gift);
        giftFactory.removeGift("        ");
    }

    @Test
    public void testGetPresentWithLeastMagicReturnsTheCorrectGift() {
        assertEquals(0, giftFactory.getCount());

        Gift anotherGift = new Gift("another_gift", Double.MIN_VALUE);

        giftFactory.createGift(gift);
        giftFactory.createGift(anotherGift);
        giftFactory.createGift(new Gift("third_gift", 50.00));

        assertEquals(anotherGift, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresentReturnsTheCorrectObject() {
        String giftName = "another_gift";
        Gift anotherGift = new Gift(giftName, GIFT_MAGIC);

        giftFactory.createGift(gift);
        giftFactory.createGift(anotherGift);

        assertEquals(anotherGift, giftFactory.getPresent(giftName));
    }

}
