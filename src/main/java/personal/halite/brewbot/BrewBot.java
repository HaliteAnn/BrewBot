package personal.halite.brewbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Halite on 2/18/2017.
 * Automatically selects first item in each category for brewing.
 * It is recommended to move items that you don't want to be brewed
 * into your vault.
 *
 * Supported screen resolutions:
 *     - 1920 x 1080
 */
public class BrewBot {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int SCREEN_HEIGHT;
    private final int SCREEN_WIDTH;
    private final int TRANSMUTE_X;
    private final int TRANSMUTE_Y;
    private final int MATERIALS_X;
    private final int MATERIALS_Y;
    private final int APPAREL_X;
    private final int APPAREL_Y;
    private final int FAMILIARS_X;
    private final int FAMILIARS_Y;
    private final int OTHER_X;
    private final int OTHER_Y;
    private final int ITEM_X;
    private final int ITEM_Y;
    private final int ADD_X;
    private final int ADD_Y;
    private final int CONFIRM_X;
    private final int CONFIRM_Y;
    private final int COLLECT_X;
    private final int COLLECT_Y;


    public BrewBot(){

        // Set screen resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_HEIGHT = screenSize.height;
        SCREEN_WIDTH = screenSize.width;
        logger.info("Screen resolution detected as {} x {}.", SCREEN_HEIGHT, SCREEN_WIDTH);

        // Set coordinates for Transmute button
        TRANSMUTE_X = getTransmuteX();
        TRANSMUTE_Y = getTransmuteY();

        if(TRANSMUTE_X == 0 || TRANSMUTE_Y == 0){
            logger.error("Screen resolution {} x {} not supported.  Please check the README for supported resolutions.", SCREEN_HEIGHT, SCREEN_WIDTH);
            System.exit(0);
        }

        int y = getTabsY(); // All labels are on the same y coordinate

        // Set coordinates for materials tab
        MATERIALS_X = getMaterialsX();
        MATERIALS_Y = y;

        // Set coordinates for apparel tab
        APPAREL_X = getApparelX();
        APPAREL_Y = y;

        // Set coordinates for familiars tab
        FAMILIARS_X = getFamiliarsX();
        FAMILIARS_Y = y;

        // Set coordinates for trinkets tab
        OTHER_X = getOtherX();
        OTHER_Y = y;

        // Set coordinates for first item in hoard
        ITEM_X = getItemX();
        ITEM_Y = getItemY();

        // Set coordinates for Add button
        ADD_X = getAddX();
        ADD_Y = getAddY();

        // Set coordinates for confirmation button
        CONFIRM_X = getConfirmX();
        CONFIRM_Y = getConfirmY();

        // Set coordinates for Collect button
        COLLECT_X = getCollectX();
        COLLECT_Y = getCollectY();

    }

    /*
     *  ----------------------------
     *  Constructor helpers
     *  ----------------------------
     */

    private int getTransmuteX(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 870;
        }
        return 0;
    }

    private int getTransmuteY(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 720;
        }
        return 0;
    }

    private int getTabsY(){ // All tabs are on the same Y coordinate
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 450;
        }
        return 0;
    }

    private int getMaterialsX(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 890;
        }
        return 0;
    }

    private int getApparelX(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 955;
        }
        return 0;
    }

    private int getFamiliarsX(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 1015;
        }
        return 0;
    }

    private int getOtherX(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 1065;
        }
        return 0;
    }

    private int getItemX(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 790;
        }
        return 0;
    }

    private int getItemY(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 490;
        }
        return 0;
    }

    private int getAddX(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 840;
        }
        return 0;
    }

    private int getAddY(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 650;
        }
        return 0;
    }

    private int getConfirmX(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 880;
        }
        return 0;
    }

    private int getConfirmY(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 445;
        }
        return 0;
    }

    private int getCollectX(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 885;
        }
        return 0;
    }

    private int getCollectY(){
        if(SCREEN_WIDTH == 1920 && SCREEN_HEIGHT == 1080){
            return 715;
        }
        return 0;
    }

    /*
     *  ----------------------------
     *  Action methods
     *  ----------------------------
     */

    private void go() throws AWTException, InterruptedException {

        logger.info("Starting BrewBot.");

        Robot robot = new Robot();

        while(true){

            brewFood(robot);
            logger.info("Added FOOD to Baldwin's Brew.");
            watchPaintDry();
            brew(robot, MATERIALS_X, MATERIALS_Y);
            logger.info("Added MATERIAL to Baldwin's Brew.");
            watchPaintDry();
            brew(robot, APPAREL_X, APPAREL_Y);
            logger.info("Added APPAREL to Baldwin's Brew.");
            watchPaintDry();
            brew(robot, FAMILIARS_X, FAMILIARS_Y);
            logger.info("Added FAMILIAR to Baldwin's Brew.");
            watchPaintDry();
            brew(robot, OTHER_X, OTHER_Y);
            logger.info("Added TRINKET to Baldwin's Brew.");
            watchPaintDry();

        }

    }

    private void watchPaintDry() throws InterruptedException {
        Random random = new Random();
        long randomNumber = random.longs(32, 45).findFirst().getAsLong();
        logger.info("Waiting {} minutes before brewing again.", randomNumber);
        TimeUnit.MINUTES.sleep(randomNumber);
    }

    private void brewFood(Robot robot){
        clickButton(robot, TRANSMUTE_X, TRANSMUTE_Y);
        clickButton(robot, ITEM_X, ITEM_Y);
        clickButton(robot, ADD_X, ADD_Y);
        clickButton(robot, CONFIRM_X, CONFIRM_Y);
        clickButton(robot, COLLECT_X, COLLECT_Y);
    }

    private void brew(Robot robot, int x, int y){
        clickButton(robot, TRANSMUTE_X, TRANSMUTE_Y);
        robot.delay((int)(Math.random() * 10000) + 1);       // Wait for up to 10 seconds
        robot.mouseMove(x ,y);                               // Move mouse to desired tab
        click(robot);                                        // Click tab
        clickButton(robot, ITEM_X, ITEM_Y);
        clickButton(robot, ADD_X, ADD_Y);
        clickButton(robot, CONFIRM_X, CONFIRM_Y);
        clickButton(robot, COLLECT_X, COLLECT_Y);
    }

    private void clickButton(Robot robot, int x, int y){
        robot.delay((int)(Math.random() * 6000) + 1);        // Wait for up to 6 seconds
        robot.mouseMove(x, y);                               // Move mouse to button
        click(robot);                                        // Click
    }

    private void click(Robot robot){
        robot.delay((int)(Math.random() * 4000) + 1);        // Wait for up to 4 seconds
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);      // Press the main mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);    // Release the main mouse button
    }

    /*
     *  ----------------------------
     *  MAIN
     *  ----------------------------
     */

    public static void main(String[] args){

        BrewBot bot = new BrewBot();

        try {
            bot.go();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
