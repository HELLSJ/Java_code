package card;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<Card> cardList = cardDemo.buyCard();
        System.out.println("买的牌如下：");
        System.out.println(cardList);

        System.out.println("洗牌：");
        cardDemo.shuffle(cardList);
        System.out.println(cardList);

        System.out.println("揭牌");
        cardDemo.getCard(cardList);
    }
}
