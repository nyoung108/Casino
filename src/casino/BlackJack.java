package casino;

import java.util.*;

public class BlackJack {

    public int play(int coins) {
        Scanner input = new Scanner(System.in);
        boolean play = true;
        while (play) {
            try {
                System.out.println();
                System.out.println("You have " + coins + " coins");
                System.out.println();
                int[] deck = createDeck();

                System.out.println("How much do you want to bet?");
                int pool = input.nextInt();
                while (coins - pool < 0) {
                    System.out.println("You don't have enough coins");
                    System.out.println("How many coins would you like to enter?");
                    pool = input.nextInt();
                }
                deck = shuffleArray(deck);
                int dealerCard1 = deck[6];
                int dealerCard2 = deck[7];
                System.out.println("The dealer's first card is " + dealerCard1);
                int playerTotal = game(deck);
                if (playerTotal == 0) {
                    coins = coins - pool;

                }
                System.out.println("Your total is: " + playerTotal);
                int dealerTotal = dealerTurn(deck, dealerCard1, dealerCard2);

                if (playerTotal == 100 && dealerTotal != 100) {
                    System.out.println("You got Black Jack");
                    coins = coins + (pool * 2);

                } else if (dealerTotal != 100) {
                    if (playerTotal > dealerTotal) {
                        System.out.println("You win");
                        System.out.print("Your total was " + playerTotal);
                        System.out.println(" and the dealer's total was " + dealerTotal);
                        coins = coins + pool;

                    } else if (playerTotal < dealerTotal) {
                        System.out.println("You lost");
                        System.out.print("Your total was " + playerTotal);
                        System.out.println(" and the dealer's total was " + dealerTotal);
                        coins = coins - pool;

                    }
                } else {
                    System.out.println("Dealer got Black Jack");
                    coins = coins - pool;

                }
                if (playerTotal == dealerTotal) {
                    System.out.println("You drew");
                    System.out.print("Your total was " + playerTotal);
                    System.out.println(" and the dealer's total was " + dealerTotal);
                }

                System.out.println("If you would like to play again enter 1");
                System.out.println("If you would like exit enter 0");
                int selected = input.nextInt();
                if (selected == 0) {
                    play = false;
                }
            } catch (Exception e) {
                System.out.println(e);
                input.next();
            }
        }

        return coins;
    }

    public int[] createDeck() {
        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = ((i) % 13) + 1;
            if (deck[i] > 10) {
                deck[i] = 10;
            }
        }

        return deck;
    }

    public int[] shuffleArray(int[] deck) {
        Random rand = new Random();
        int[] num = new int[52];
        for (int i = 0; i < 52; i++) {
            num[i] = i;
        }
        int[] temp = new int[52];
        for (int j = 0; j < 52; j++) {
            int value = rand.nextInt(num.length);
            int index = num[value];
            num = remove(num, value);
            temp[j] = deck[index];
        }
        return temp;
    }

    public int[] remove(int[] num, int value) {
        int[] temp = new int[num.length - 1];
        for (int i = value; i < num.length - 1; i++) {
            num[i] = num[i + 1];
        }
        for (int j = 0; j < num.length - 1; j++) {
            temp[j] = num[j];
        }
        return temp;
    }

    public int game(int[] deck) {
        Scanner input = new Scanner(System.in);

        int card1 = deck[0];
        int card2 = deck[1];
        System.out.println("Your first card is " + card1);
        System.out.println("Your second card is " + card2);
        int total = card1 + card2;
        int count = 2;

        boolean draw = true;
        if ((card1 == 1) || (card2 == 1)) {

            if (total == 11) {
                total = 100;
                return total;
            } else {
                total = ace(deck, count, total);

                draw = false;
            }
        }

        while (draw) {
            if (count < 5 && total <= 21) {
                try {
                    System.out.println("Your total is " + total);
                    System.out.println("If you would like to draw a card enter 1");
                    System.out.println("If you would like to stick enter 0");
                    int selected = input.nextInt();
                    if (selected == 0) {
                        System.out.println("Your total is " + total);
                        draw = false;
                        break;
                    } else {
                        int drawnCard = deck[count + 1];
                        count++;
                        total = total + drawnCard;
                        System.out.println("You drew a " + deck[count]);

                        if (drawnCard == 1) {
                            total = ace(deck, count, total);

                            draw = false;
                        }
                        if (total > 21) {
                            System.out.println("You went bust");
                            System.out.println("Your total was " + total);
                            total = 0;
                            return total;
                        } else {
                            System.out.println("Your total is " + total);
                        }

                    }
                } catch (Exception e) {
                    System.out.println(e);
                    input.next();
                }
            } else {
                draw = false;
            }

        }
        if (count == 4) {
            total = 21;
        }
        return total;
    }

    public int ace(int deck[], int count, int total) {
        Scanner input = new Scanner(System.in);
        boolean draw = true;
        total = total + 10;
        while (draw) {
            if (count < 5 && total <= 31) {
                try {
                    System.out.println("Your total is " + (total - 10) + " or " + total);
                    System.out.println("If you would like to draw a card enter 1");
                    System.out.println("If you would like to stick enter 0");
                    int selected = input.nextInt();
                    if (selected == 0) {
                        System.out.println("Your total is " + (total - 10) + " or " + total);
                        draw = false;
                        break;
                    } else {
                        int drawnCard = deck[count];
                        count++;
                        total = total + drawnCard;
                        System.out.println("You drew a " + deck[count]);
                        System.out.println("Your total is " + (total - 10) + " or " + total);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    input.next();
                }
            } else {
                draw = false;
            }

        }
        if ((total <= 31) && (total > 21)) {
            total = total - 10;
        }
        if (total > 21) {
            System.out.println("You went bust");
            total = 0;
        }
        return total;
    }

    public int dealerTurn(int deck[], int dealerCard1, int dealerCard2) {
        int dealerTotal = dealerCard1 + dealerCard2;
        int dealerCount = 8;
        System.out.println("Dealer's second card is " + dealerCard2);

        if ((dealerCard1 == 1) || (dealerCard2 == 1)) {

            if (dealerTotal == 11) {
                dealerTotal = 100;
                return dealerTotal;
            } else {
                dealerTotal = dealerAce(deck, dealerCard1, dealerCard2, dealerTotal, dealerCount);
                return dealerTotal;

            }
        }
        while (dealerTotal < 17 && dealerCount < 11 && dealerTotal <= 21) {
            System.out.println("Dealer's total is now " + dealerTotal);
            System.out.println("Dealer drew a " + deck[dealerCount]);

            dealerTotal = dealerTotal + deck[dealerCount];
            dealerCount++;
            if (deck[dealerCount] == 1) {
                dealerTotal = dealerAce(deck, dealerCard1, dealerCard2, dealerTotal, dealerCount);
                return dealerTotal;
            }
        }
        if (dealerTotal > 21) {
            System.out.println("Dealer went bust");
            dealerTotal = 0;
        } else {
            System.out.println("Dealer's total is " + dealerTotal);
        }
        return dealerTotal;
    }

    public int dealerAce(int deck[], int dealerCard1, int dealerCard2, int dealerTotal, int dealerCount) {
        dealerTotal = dealerTotal + 10;
        while (dealerTotal < 17 && dealerCount < 11) {
            System.out.println("Dealer drew a " + deck[dealerCount]);
            dealerTotal = dealerTotal + deck[dealerCount];
            System.out.println("Dealer's total is now " + (dealerTotal - 10) + " or " + dealerTotal);

        }
        if (dealerTotal > 21) {
            dealerTotal = dealerTotal - 10;
        }
        if (dealerTotal > 21) {
            System.out.println("Dealer went bust");
            dealerTotal = 0;
        } else {
            System.out.println("Dealer's total is " + dealerTotal);
        }
        return dealerTotal;
    }
}
