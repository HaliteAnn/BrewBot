package personal.halite.brewbot;

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


    public BrewBot(){

        // Set screen resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_HEIGHT = screenSize.height;
        SCREEN_WIDTH = screenSize.width;

        // Set coordinates for Transmute button
        TRANSMUTE_X = getTransmuteX();
        TRANSMUTE_Y = getTransmuteY();

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

    /*
     *  ----------------------------
     *  Action methods
     *  ----------------------------
     */

    private void go() throws AWTException, InterruptedException {

        Robot robot = new Robot();
        Random random = new Random();

        while(true){

            brewFood(robot);
            TimeUnit.MINUTES.sleep(random.longs(32, 45).findFirst().getAsLong());
            brew(robot, MATERIALS_X, MATERIALS_Y);
            TimeUnit.MINUTES.sleep(random.longs(32, 45).findFirst().getAsLong());
            brew(robot, APPAREL_X, APPAREL_Y);
            TimeUnit.MINUTES.sleep(random.longs(32, 45).findFirst().getAsLong());
            brew(robot, FAMILIARS_X, FAMILIARS_Y);
            TimeUnit.MINUTES.sleep(random.longs(32, 45).findFirst().getAsLong());
            brew(robot, OTHER_X, OTHER_Y);
            TimeUnit.MINUTES.sleep(random.longs(32, 45).findFirst().getAsLong());

        }

    }

    private void brewFood(Robot robot){
        clickTransmute(robot);
        clickItem(robot);                                    // No need to select tab, already on food tab
        clickAdd(robot);
    }

    private void brew(Robot robot, int x, int y){
        clickTransmute(robot);
        robot.delay((int)(Math.random() * 10000) + 1);    // Wait for up to 10 seconds
        robot.mouseMove(x ,y);                               // Move mouse to desired tab
        robot.delay((int)(Math.random() * 10000) + 1);    // Wait for up to 10 seconds
        click(robot);                                        // Click tab
        clickItem(robot);
        clickAdd(robot);
    }

    private void clickTransmute(Robot robot){
        robot.delay((int)(Math.random() * 10000) + 1);    // Wait for up to 10 seconds
        robot.mouseMove(TRANSMUTE_X, TRANSMUTE_Y);           // Move mouse to Transmute button
        robot.delay((int)(Math.random() * 10000) + 1);    // Wait for up to 10 seconds
        click(robot);
    }

    private void clickAdd(Robot robot){
        robot.delay((int)(Math.random() * 10000) + 1);    // Wait for up to 10 seconds
        robot.mouseMove(ADD_X, ADD_Y);                       // Move mouse to Add button
        robot.delay((int)(Math.random() * 10000) + 1);    // Wait for up to 10 seconds
        click(robot);
    }

    private void clickItem(Robot robot){
        robot.delay((int)(Math.random() * 10000) + 1);    // Wait for up to 10 seconds
        robot.mouseMove(ITEM_X,ITEM_Y);                      // Food tab already selected, move straight to item
        robot.delay((int)(Math.random() * 10000) + 1);    // Wait for up to 10 seconds
        click(robot);
    }

    private void click(Robot robot){
        robot.delay((int)(Math.random() * 10000) + 1);    // Wait for up to 10 seconds
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);      // Press the main mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);    // Release the main mouse button
    }

    /*
     *  ----------------------------
     *  MAIN
     *  ----------------------------
     */

    public static void main(String[] args){

        System.out.println("BrewBot push test.");

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
