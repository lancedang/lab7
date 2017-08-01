package com.ppdai.tutorial;

/**
 * Full game implementation.
 * <p>
 * This game uses three decks of cards: 1x - Emperor's com.ppdai.tutorial.Deck 1x - Plebeian's com.ppdai.tutorial.Deck
 * 1x - Fate com.ppdai.tutorial.Deck
 * <p>
 * RULES: 1) At the beginning of each game, the player draws a fate card. - if
 * the fate is of riches, the player uses the emperor deck - if the fate is of
 * revolution, the player uses the plebeian deck
 * 2) Each player reveals the top
 * card of their deck - Emperor beats Patrician - Patrician beats Plebeian -
 * Plebeian beat Emperor 3) Repeat Rule 2 if both players reveal a patrician
 * <p>
 * Scoring: If the player wins using the Emperor com.ppdai.tutorial.Deck, they get 1 point. If the
 * player wins with the Plebeian com.ppdai.tutorial.Deck, they get 4 points.
 *
 * @author Taner
 * @version 2016-10-05
 */
public class Game {
    /**
     * The Emperor com.ppdai.tutorial.Deck
     */
    private EmperorsDeck emperorsDeck;

    /**
     * The Plebeian com.ppdai.tutorial.Deck
     */
    private PlebeiansDeck plebeianDeck;

    /**
     * The Fate com.ppdai.tutorial.Deck. Decides which player gets the Emperor com.ppdai.tutorial.Deck and which
     * player gets the Plebeian com.ppdai.tutorial.Deck.
     */
    private FateDeck fateDeck;

    /**
     * Used to invert the point-value constants for when the player loses.
     */
    private final int constPlayerLost = -1;

    /**
     * Total points won from playing a plebeian against an emperor Multiply by
     * constPlayerLost if the player played the Emperor
     */
    private final int constPlebeianEmperor = 4;

    /**
     * Total points won from playing a patrician against a non-patrician
     * Multiply by constPlayerLost if the patrician beats the player's card
     */
    private final int constPatrcianNonPatrician = 1;

    /**
     * com.ppdai.tutorial.Game Constructor.
     * <p>
     * Create and populate all three decks.
     */
    public Game() {
        emperorsDeck = new EmperorsDeck();
        emperorsDeck.populateDeck();
        plebeianDeck = new PlebeiansDeck();
        plebeianDeck.populateDeck();
        fateDeck = new FateDeck();
        fateDeck.populateDeck();
    }

    /**
     * Ensures that all decks are ready to play, and passes the decks to the
     * play() method. This separation makes the stochastic nature of this game
     * easier to control during testing.
     *
     * @return The total number of points the player either won or lost
     */
    public int playOnce() {
        ensureNewGame();
        return play(emperorsDeck, plebeianDeck, fateDeck);
    }

    /**
     * Play one round of Fate.
     * <p>
     * Returns the point value of the player's perspective when a win condition
     * based on rule 2 is achieved.
     *
     * @param emperorsDeck The shuffled-and-readied Emperor's com.ppdai.tutorial.Deck
     * @param plebeianDeck The shuffled-and-readied Plebeian's com.ppdai.tutorial.Deck
     * @param fateDeck     The shuffled-and-readied Fate com.ppdai.tutorial.Deck
     * @return The number of points the player (not opponent) receives
     */
    public int play(EmperorsDeck emperorsDeck, PlebeiansDeck plebeianDeck,
                    FateDeck fateDeck) {
        // Draw a Fate card to decide who gets which deck
        // TODO: Implement
        Fate fateCard = fateDeck.drawCard();

        // Let the user know which deck they've been given with a print
        // statement
        // TODO: Implement
        String you = "";
        if (fateCard == Fate.RICHES) {
            System.out.println("///// You are the Emperor /////");
        } else {
            System.out.println("///// You are the Plebeian /////");
        }
        // The Top card that each player draws during each round.
        Character player;
        Character opponent;
        int score = 0;
        // The Fate card is the Riches card. The player gets the Emperor deck.
        if (fateCard == Fate.RICHES) {
            // TODO: Implement
            for (int i = 0; i < 5; i++) {
                player = emperorsDeck.drawCard();
                opponent = plebeianDeck.drawCard();

                String playerName = player.toString();
                String opponentName = opponent.toString();

                System.out.println("You: " + playerName + "\n" + "Opp: " + opponentName);

                if (playerName.equals(opponentName)) {
                    continue;
                }

                if (playerName.equals("Patrician") && opponentName.equals("Plebeian")) {
                    score += constPatrcianNonPatrician;
                } else if (playerName.equals("Emperor") && opponentName.equals("Patrician")) {
                    score += constPatrcianNonPatrician;
                } else if (playerName.equals("Emperor") && opponentName.equals("Plebeian")) {
                    score += constPlayerLost * constPlebeianEmperor;
                }
                break;

            }

        }
        // The Fate card is the Revolution card. Player gets the Plebeian deck.
        else {
            // TODO: Implement
            int size = plebeianDeck.drawingStack.size();
            for (int i = 0; i < size; i++) {
                player = plebeianDeck.drawCard();
                opponent = emperorsDeck.drawCard();

                String playerName = player.toString();
                String opponentName = opponent.toString();

                System.out.println("You: " + playerName + "\n" + "Opp: " + opponentName);

                if (playerName.equals(opponentName)) {
                    continue;
                }

                if (playerName.equals("Plebeian") && opponentName.equals("Patrician")) {
                    score += constPlayerLost;
                } else if (playerName.equals("Plebeian") && opponentName.equals("Emperor")) {
                    score += constPlebeianEmperor;
                }
                if (playerName.equals("Patrician") && opponentName.equals("Emperor")) {
                    score += constPlayerLost;
                }
                break;
            }

        }

        /*
         * Given that the Emperor com.ppdai.tutorial.Deck and the Plebeian com.ppdai.tutorial.Deck both have the same
         * number of cards and contain the pre-specified types and amount of
         * cards inside of them, this is unreachable. However, this makes
         * Eclipse happy that all paths return some int.
         */
        return score;

    }

    /**
     * Ensure that all decks are reset to their respective drawing decks
     */
    private void ensureNewGame() {
        emperorsDeck.resetDeck();
        plebeianDeck.resetDeck();
        fateDeck.resetDeck();
    }
}