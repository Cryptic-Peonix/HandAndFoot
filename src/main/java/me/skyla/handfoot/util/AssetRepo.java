package me.skyla.handfoot.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * Class to contain all of our image assets.
 */
public class AssetRepo {

    // All Card images
    private static BufferedImage twoOfClubs;
    private static BufferedImage twoOfDiamonds;
    private static BufferedImage twoOfHearts;
    private static BufferedImage twoOfSpades;
    private static BufferedImage threeOfClubs;
    private static BufferedImage threeOfDiamonds;
    private static BufferedImage threeOfHearts;
    private static BufferedImage threeOfSpades;
    private static BufferedImage fourOfClubs;
    private static BufferedImage fourOfDiamonds;
    private static BufferedImage fourOfHearts;
    private static BufferedImage fourOfSpades;
    private static BufferedImage fiveOfClubs;
    private static BufferedImage fiveOfDiamonds;
    private static BufferedImage fiveOfHearts;
    private static BufferedImage fiveOfSpades;
    private static BufferedImage sixOfClubs;
    private static BufferedImage sixOfDiamonds;
    private static BufferedImage sixOfHearts;
    private static BufferedImage sixOfSpades;
    private static BufferedImage sevenOfClubs;
    private static BufferedImage sevenOfDiamonds;
    private static BufferedImage sevenOfHearts;
    private static BufferedImage sevenOfSpades;
    private static BufferedImage eightOfClubs;
    private static BufferedImage eightOfDiamonds;
    private static BufferedImage eightOfHearts;
    private static BufferedImage eightOfSpades;
    private static BufferedImage nineOfClubs;
    private static BufferedImage nineOfDiamonds;
    private static BufferedImage nineOfHearts;
    private static BufferedImage nineOfSpades;
    private static BufferedImage tenOfClubs;
    private static BufferedImage tenOfDiamonds;
    private static BufferedImage tenOfHearts;
    private static BufferedImage tenOfSpades;
    private static BufferedImage jackOfClubs;
    private static BufferedImage jackOfDiamonds;
    private static BufferedImage jackOfHearts;
    private static BufferedImage jackOfSpades;
    private static BufferedImage queenOfClubs;
    private static BufferedImage queenOfDiamonds;
    private static BufferedImage queenOfHearts;
    private static BufferedImage queenOfSpades;
    private static BufferedImage kingOfClubs;
    private static BufferedImage kingOfDiamonds;
    private static BufferedImage kingOfHearts;
    private static BufferedImage kingOfSpades;
    private static BufferedImage aceOfClubs;
    private static BufferedImage aceOfDiamonds;
    private static BufferedImage aceOfHearts;
    private static BufferedImage aceOfSpades;
    private static BufferedImage redJoker;
    private static BufferedImage blackJoker;

    // Set the images for each of our cards.
    static {
        try {
            twoOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/2_of_clubs.png")));
            twoOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/2_of_diamonds.png")));
            twoOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/2_of_hearts.png")));
            twoOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/2_of_spades.png")));
            threeOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/3_of_clubs.png")));
            threeOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/3_of_diamonds.png")));
            threeOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/3_of_hearts.png")));
            threeOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/3_of_spades.png")));
            fourOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/4_of_clubs.png")));
            fourOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/4_of_diamonds.png")));
            fourOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/4_of_hearts.png")));
            fourOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/4_of_spades.png")));
            fiveOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/5_of_clubs.png")));
            fiveOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/5_of_diamonds.png")));
            fiveOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/5_of_hearts.png")));
            fiveOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/5_of_spades.png")));
            sixOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/6_of_clubs.png")));
            sixOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/6_of_diamonds.png")));
            sixOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/6_of_hearts.png")));
            sixOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/6_of_spades.png")));
            sevenOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/7_of_clubs.png")));
            sevenOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/7_of_diamonds.png")));
            sevenOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/7_of_hearts.png")));
            sevenOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/7_of_spades.png")));
            eightOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/8_of_clubs.png")));
            eightOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/8_of_diamonds.png")));
            eightOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/8_of_hearts.png")));
            eightOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/8_of_spades.png")));
            nineOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/9_of_clubs.png")));
            nineOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/9_of_diamonds.png")));
            nineOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/9_of_hearts.png")));
            nineOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/9_of_spades.png")));
            tenOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/10_of_clubs.png")));
            tenOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/10_of_diamonds.png")));
            tenOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/10_of_hearts.png")));
            tenOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/10_of_spades.png")));
            jackOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/jack_of_clubs.png")));
            jackOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/jack_of_diamonds.png")));
            jackOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/jack_of_hearts.png")));
            jackOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/jack_of_spades.png")));
            queenOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/queen_of_clubs.png")));
            queenOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/queen_of_diamonds.png")));
            queenOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/queen_of_hearts.png")));
            queenOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/queen_of_spades.png")));
            kingOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/king_of_clubs.png")));
            kingOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/king_of_diamonds.png")));
            kingOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/king_of_hearts.png")));
            kingOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/king_of_spades.png")));
            aceOfClubs = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/ace_of_clubs.png")));
            aceOfDiamonds = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/ace_of_diamonds.png")));
            aceOfHearts = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/ace_of_hearts.png")));
            aceOfSpades = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/ace_of_spades.png")));
            redJoker = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/red_joker.png")));
            blackJoker = ImageIO.read(Objects.requireNonNull(AssetRepo.class
                    .getResource("/images/cards/black_joker.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private AssetRepo() {
        throw new UnsupportedOperationException("This is a utility"
                + " class and cannot be instantiated!");
    }

    // Getters for each card.

    public static BufferedImage getTwoOfClubs() {
        return twoOfClubs;
    }

    public static BufferedImage getEightOfClubs() {
        return eightOfClubs;
    }

    public static BufferedImage getTwoOfDiamonds() {
        return twoOfDiamonds;
    }

    public static BufferedImage getTwoOfHearts() {
        return twoOfHearts;
    }

    public static BufferedImage getTwoOfSpades() {
        return twoOfSpades;
    }

    public static BufferedImage getThreeOfClubs() {
        return threeOfClubs;
    }

    public static BufferedImage getThreeOfDiamonds() {
        return threeOfDiamonds;
    }

    public static BufferedImage getThreeOfHearts() {
        return threeOfHearts;
    }

    public static BufferedImage getThreeOfSpades() {
        return threeOfSpades;
    }

    public static BufferedImage getFourOfClubs() {
        return fourOfClubs;
    }

    public static BufferedImage getFourOfDiamonds() {
        return fourOfDiamonds;
    }

    public static BufferedImage getFourOfHearts() {
        return fourOfHearts;
    }

    public static BufferedImage getFourOfSpades() {
        return fourOfSpades;
    }

    public static BufferedImage getFiveOfClubs() {
        return fiveOfClubs;
    }

    public static BufferedImage getFiveOfDiamonds() {
        return fiveOfDiamonds;
    }

    public static BufferedImage getFiveOfHearts() {
        return fiveOfHearts;
    }

    public static BufferedImage getFiveOfSpades() {
        return fiveOfSpades;
    }

    public static BufferedImage getSixOfClubs() {
        return sixOfClubs;
    }

    public static BufferedImage getSixOfDiamonds() {
        return sixOfDiamonds;
    }

    public static BufferedImage getSixOfHearts() {
        return sixOfHearts;
    }

    public static BufferedImage getSixOfSpades() {
        return sixOfSpades;
    }

    public static BufferedImage getSevenOfClubs() {
        return sevenOfClubs;
    }

    public static BufferedImage getSevenOfDiamonds() {
        return sevenOfDiamonds;
    }

    public static BufferedImage getSevenOfHearts() {
        return sevenOfHearts;
    }

    public static BufferedImage getSevenOfSpades() {
        return sevenOfSpades;
    }

    public static BufferedImage getEightOfDiamonds() {
        return eightOfDiamonds;
    }

    public static BufferedImage getEightOfHearts() {
        return eightOfHearts;
    }

    public static BufferedImage getEightOfSpades() {
        return eightOfSpades;
    }

    public static BufferedImage getNineOfClubs() {
        return nineOfClubs;
    }

    public static BufferedImage getNineOfDiamonds() {
        return nineOfDiamonds;
    }

    public static BufferedImage getNineOfHearts() {
        return nineOfHearts;
    }

    public static BufferedImage getNineOfSpades() {
        return nineOfSpades;
    }

    public static BufferedImage getTenOfClubs() {
        return tenOfClubs;
    }

    public static BufferedImage getTenOfDiamonds() {
        return tenOfDiamonds;
    }

    public static BufferedImage getTenOfHearts() {
        return tenOfHearts;
    }

    public static BufferedImage getTenOfSpades() {
        return tenOfSpades;
    }

    public static BufferedImage getJackOfClubs() {
        return jackOfClubs;
    }

    public static BufferedImage getJackOfDiamonds() {
        return jackOfDiamonds;
    }

    public static BufferedImage getJackOfHearts() {
        return jackOfHearts;
    }

    public static BufferedImage getJackOfSpades() {
        return jackOfSpades;
    }

    public static BufferedImage getQueenOfClubs() {
        return queenOfClubs;
    }

    public static BufferedImage getQueenOfDiamonds() {
        return queenOfDiamonds;
    }

    public static BufferedImage getQueenOfHearts() {
        return queenOfHearts;
    }

    public static BufferedImage getQueenOfSpades() {
        return queenOfSpades;
    }

    public static BufferedImage getKingOfClubs() {
        return kingOfClubs;
    }

    public static BufferedImage getKingOfDiamonds() {
        return kingOfDiamonds;
    }

    public static BufferedImage getKingOfHearts() {
        return kingOfHearts;
    }

    public static BufferedImage getKingOfSpades() {
        return kingOfSpades;
    }

    public static BufferedImage getAceOfClubs() {
        return aceOfClubs;
    }

    public static BufferedImage getAceOfDiamonds() {
        return aceOfDiamonds;
    }

    public static BufferedImage getAceOfHearts() {
        return aceOfHearts;
    }

    public static BufferedImage getAceOfSpades() {
        return aceOfSpades;
    }

    public static BufferedImage getRedJoker() {
        return redJoker;
    }

    public static BufferedImage getBlackJoker() {
        return blackJoker;
    }
}
