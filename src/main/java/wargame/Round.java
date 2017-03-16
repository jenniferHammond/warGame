package wargame;

import java.util.*;

/**
 * Created by Jen on 3/15/2017.
 */
public class Round {

    private final IGameReporter reporter;

    public Round(IGameReporter reporter){
        this.reporter = reporter;
    }

    public RoundResults playOneRound(List<Player> players) {
        RoundResults roundResults = new RoundResults();
        return playOneRound(players, roundResults);
    }

    private RoundResults playOneRound(List<Player> players, RoundResults roundResults){
        LinkedList<Play> currentRound = new LinkedList<Play>();
        for (Player player : players) {
            // if player cannot play card, do not add them to the round.
            if(player.hasCards()) {
                if(player.hasCards()) {
                    Play play = new Play(player, player.playCard());
                    currentRound.add(play);
                    reporter.print(play.toString());
                }
            }
        }

        /*
         * It's unlikely, but possible, that all players in the round have run out of cards.
         * This is a draw.
         */
        if(currentRound.size() == 0){
            for (Player player : players) {
                roundResults.addWinner(player);
            }
            return roundResults;
        }

        if(isWar(currentRound)){
            // find players with equal cards
            List<Player> warringPlayers = warringPlayers(currentRound);
            roundResults.addCardsWon(getCardsForRound(currentRound));

            reporter.print("WAR breaks out between " + warringPlayers);

            // all players must play one card face-down.
            // if they have no cards, they'll be eliminated next go-round, so they
            // can stay in the pool for now.
            for(Player player: warringPlayers){
                if(player.hasCards()){
                    roundResults.addCardWon(player.playCard());
                }
            }

            // play another round with warring players
            return playOneRound(warringPlayers, roundResults);
        }
        else{
            Player winningPlayer = getWinningPlayer(currentRound);
            roundResults.addWinner(winningPlayer);

            // give cards to the winner and report back out
            List<Card> cardsWon = getCardsForRound(currentRound);
            roundResults.addCardsWon(cardsWon);
        }

        return roundResults;
    }

    private Player getWinningPlayer(LinkedList<Play> currentRound) {
        Collections.sort(currentRound);
        // since we know we aren't warring, and the list is sorted,
        // the last player is the winner.
        return currentRound.getLast().getPlayer();
    }

    private List<Card> getCardsForRound(Collection<Play> round) {
        List<Card> cardsWon = new ArrayList<Card>();
        for (Play play:round){
            cardsWon.add(play.getCard());
        }
        return cardsWon;
    }

    private boolean isWar(List<Play> currentRound){
        return new HashSet(currentRound).size() != currentRound.size();
    }

    /*
     * From a list of sorted plays, finds the plays with the same value.
     */
    private List<Player> warringPlayers(List<Play> plays){
        List<Player> warringPlayers = new ArrayList<Player>();

        for(Play play: plays){
            if(Collections.frequency(plays, play) > 1){
                warringPlayers.add(play.getPlayer());
            }
        }
        return warringPlayers;
    }
}


