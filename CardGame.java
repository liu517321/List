import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardGame {
    private static final String[] COLORS = {
            "♠", "♥", "♦", "♣"
    };

    private static List<Card> buyDeck() {
        List<Card> deck = new ArrayList<>(52);
        for (int i = 0; i < 4; i++) {
            String color = COLORS[i];
            for (int j = 1; j <= 13; j++) {
                int value = j;

                Card card = new Card(value, color);
                deck.add(card);
            }
        }

        return deck;
    }

    private static void shuffle(List<Card> deck) {
        Random random = new Random(20190910);
        for (int i = deck.size() - 1; i > 0; i--) {
            int r = random.nextInt(i);
            swap(deck, i, r);
        }
    }

    private static void swap(List<Card> deck, int i, int j) {
        Card t = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, t);
    }

    private static void swap(Card[] deck, int i, int j) {
        Card t = deck[i];
        deck[i] = deck[j];
        deck[j] = t;
    }

    public static void main(String[] args) {
        List<Card> deck = buyDeck();
        System.out.println(deck);
        shuffle(deck);
        System.out.println(deck);
        List<List<Card>> hands = new ArrayList<>();
        send(hands, deck, 3, 5);
        System.out.println(hands.get(0));
        System.out.println(hands.get(1));
        System.out.println(hands.get(2));
        System.out.println(deck);

        play(hands);
    }

    private static void play(List<List<Card>> hands) {
        Card card = new Card(1, "♠");
        for (int i = 0; i < hands.size(); i++) {
            if (hands.get(i).contains(card)) {
                System.out.println("%d 输了");
                return;
            }

            /*
            for (int j = 0; j < hands.get(i).size(); j++) {
                // 错误的
                Card handCard = hands.get(i).get(j);
                if (card.equals(handCard)) {
                    System.out.println("%d 输了");
                    return;
                }
            }
             */
        }
    }

    private static void send(List<List<Card>> hands, List<Card> deck, int numPerson, int numCard) {
        // 调用 get 之前一定要保证元素是存在的
        for (int k = 0; k < numPerson; k++) {
            hands.add(new ArrayList<>());
        }

        for (int i = 0; i < numCard; i++) {
            for (int j = 0; j < numPerson; j++) {
                // 抓牌
                Card card = deck.remove(0);
                hands.get(j).add(card);
            }
        }
    }
}
