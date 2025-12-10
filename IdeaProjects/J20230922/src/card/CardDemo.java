package card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDemo {

    private  final String[] suits = {"♥","♠","♦","♣"};

    /**
     * 52张 1-K
     *      J   Q  K
     *      11 12 13
     * @return
     */
    public List<Card> buyCard() {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(suits[i],j);
                cardList.add(card);
            }
        }
        return cardList;
    }

    public void shuffle(List<Card> cardList) {
        Random random = new Random();
        for (int i = cardList.size()-1; i > 0; i--) {
            int index = random.nextInt(i);
            //index  i 交换
            swap(cardList,i,index);
        }
    }
    private void swap(List<Card> cardList,int a,int b) {
        Card tmp = cardList.get(a);
        cardList.set(a,cardList.get(b));
        cardList.set(b,tmp);
        /**
         * tmp = a
         * a = b
         * b = tmp
         */
    }

    /**
     * 揭牌
     * 3个人 每个人轮流揭牌5张
     * @param cardList
     */
    public void getCard(List<Card> cardList) {
        //把牌放到每个人手中
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();

        List<List<Card>> hands = new ArrayList<>();
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);


        //3个人 轮流抓牌5张 每次揭牌1张，i代表次数
        for (int i = 0; i < 5; i++) {
            //j代表人
            for (int j = 0; j < 3; j++) {
                Card card = cardList.remove(0);
                hands.get(j).add(card);
            }
        }

        System.out.println("第1个揭牌如下：");
        System.out.println(hand1);
        System.out.println("第2个揭牌如下：");
        System.out.println(hand2);
        System.out.println("第3个揭牌如下：");
        System.out.println(hand3);

        System.out.println("剩下的牌：");
        System.out.println(cardList);

    }

}
