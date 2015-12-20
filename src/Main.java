import javax.swing.*;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.soap.Text;
import java.awt.event.*;

public class Main extends JDialog {
    private JPanel contentPane;
    private JButton btnAttack;
    private JButton btnHeal;
    public JTextArea AreaMap;
    private JTextArea AreaCon;
    private JTextArea Areainfo;
    private JTextField TextF;
    private JButton btnLoot;
    private int currentRow = 0;
    private int currentCol = 0;
    private String textField = "";
    private boolean tutorial1, tutorial2, tutorialDone, characterCreate, name, inbattle;
    public String charName;
    public Player player;

    public Main() {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(btnAttack);
    }

    public void clearMap() {
        AreaMap.setText("");
    }

    public void clearCon() {
        AreaCon.setText("");
    }

    public void clearInfo() {
        Areainfo.setText("");
    }

    public void appendToMap(String str) {
        AreaMap.append(str);
    }

    private void scoreScreen() {
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓▓▓TEXT▓▓▓▓▓▓▓▓▓▓▓▓ ");
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓ADVENTURES▓▓▓▓▓▓▓▓▓▓▓");
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        AreaMap.append("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
    }


    private void mainThread() {
        AreaMap.setLineWrap(true);
        TextF.addKeyListener(new EnterListener());

        //AreaCon.append("█ ▄ ▌ ▐ ▀ α ■");
        AreaMap.setEditable(false);
        Areainfo.setEditable(false);
        AreaCon.setEditable(false);

        //AreaMap.append("hi");
        fillLayout();
        //printMap();
        scoreScreen();
        MainStart();

    }

    public static void main(String[] args) {
        Main dialog = new Main();
        dialog.pack();
        dialog.mainThread();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void getTextField() {
        textField = TextF.getText();
        System.out.println(textField);
        TextF.setText("");
        MainStart();

    }

    private void MainStart() {
        if (textField.equals("/skiptut")) {
            tutorialDone = true;
            tutorial2 = true;
            tutorial1 = true;
            clearCon();
        }
        if (textField.equals("/next")) {
            tutorial1 = true;
        }
        if (textField.equals("up") && tutorialDone && !inbattle) {
            moveChar(-1, 0);
        } else if (textField.equals("down") && tutorialDone && !inbattle) {
            moveChar(1, 0);
        } else if (textField.equals("left") && tutorialDone && !inbattle) {
            moveChar(0, -1);
        } else if (textField.equals("right") && tutorialDone && !inbattle) {
            moveChar(0, 1);
        }
        if (!tutorial1) {
            clearCon();
            AreaCon.append("Welcome to textRPG written by Dan Janes\nThis is the tutorial, to skip type /skiptut\nTo go to the next slide type /next\n");
            AreaCon.append("The Dungeon titles:\n░ is your Current Room\n▓ is a Cleared Room\n▒ is an Uncleared Room\n█ is a Wall\n┬ is a Treasure room\nßß is a Boss room");
        }
        if (tutorial1 && !tutorial2) {
            clearCon();
            AreaCon.append("In order to move around the map type left, right, up, or down\nIn order to attack press the Attack button\nTo Heal press the heal button\nPress the loot button to take loot");
            AreaCon.append("\nWhen you are ready to start type /skiptut");

        }
        if (tutorialDone) {
            if (!characterCreate) {
                AreaCon.append("Welcome traveler, what is your name?");
                characterCreate = true;

            } else if (!name) {
                clearCon();
                printMap();
                charName = textField;
                AreaCon.append("Welcome " + textField);
                player = new Player(charName, "The mighty and strong player", 100, 10, 20, 5, 1);
                name = true;
                printInfo();
            }

        }
    }


    private void moveChar(int row, int col) {
        System.out.println(row + " " + col);

        //Checks to see if the potential move is out of bounds
        if (currentCol + col <= 26 && currentCol + col >= 0) {
            if (currentRow + row <= 9 && currentRow + row >= 0) {


                if (layout[currentRow + row][currentCol + col].isaWall()) {
                    AreaCon.setText("Sorry that is a wall.\nYou may not go there.");
                } else if (layout[currentRow + row][currentCol + col].isTreasureRoom()) {

                } else if (layout[currentRow + row][currentCol + col].isaRoom() || layout[currentRow + row][currentCol + col].isBossRoom() ) {
                    clearCon();
                    layout[currentRow + row][currentCol + col].setIsCurrent(true);
                    layout[currentRow][currentCol].setIsCurrent(false);
                    layout[currentRow][currentCol].setCleared(true);
                    printMap();
                    printInfo();
                }
            }
        } else {
            AreaCon.setText("Sorry you can not move there. Out of the map");
        }
    }

    private void printInfo() {
        clearInfo();
        Areainfo.append("Name: " + player.getName() + "\nHealth: " + player.getHP() + "/100\nPotions: " + player.getPotions() + "\nCurrent Weapon Equipped: ");
    }

    /**
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Starts the DUNGEON CLASS
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */

    private Room layout[][] = new Room[10][27];

    /**
     * Index
     * ▓ is Cleared 1
     * ▒ is not cleared 2
     * ░ is current 3
     * ┬ is tresure room 4
     * █ is nothing/walls/blank 0
     * ßß is boss room
     */


    public void fillLayout() {
        for (int row = 0; row < 10; row++) {

            for (int col = 0; col < 27; col++) {
                if (row == 0 || row == 9 || col == 0 || col == 26) {
                    Room r = new Room("A wall");
                    r.setIsWall(true);
                    layout[row][col] = r;
                } else if (row == 8 && col == 13) {
                    Room r = new Room("");
                    r.setIsCurrent(true);
                    layout[row][col] = r;
                } else if (row == 8 && col == 12 || row == 8 && col == 14 || row == 8 && col == 15 || row == 8 && col == 16 || row == 8 && col == 17 || row == 7 && col == 15 || row == 6 && col == 15 || row == 6 && col == 16 || row == 6 && col == 17 || row == 6 && col == 18 || row == 6 && col == 19 || row == 6 && col == 20 ||
                        row == 6 && col == 21 || row == 6 && col == 22 || row == 7 && col == 22 || row == 8 && col == 22 || row == 8 && col == 23 || row == 8 && col == 11 || row == 8 && col == 10 || row == 8 && col == 9 || row == 8 && col == 8 ||
                        row == 7 && col == 9 || row == 6 && col == 9 || row == 5 && col == 9 || row == 4 && col == 9 || row == 3 && col == 9 || row == 4 && col == 8 || row == 4 && col == 7 || row == 4 && col == 6 || row == 5 && col == 6 || row == 6 && col == 6 || row == 7 && col == 6 || row == 7 && col == 5 ||
                        row == 7 && col == 4 || row == 2 && col == 9 || row == 1 && col == 9 || row == 1 && col == 8 || row == 1 && col == 7 || row == 1 && col == 10 || row == 1 && col == 11 || row == 1 && col == 12 || row == 1 && col == 13 || row == 1 && col == 14 || row == 1 && col == 15 || row == 1 && col == 16
                        || row == 1 && col == 17 || row == 1 && col == 18 || row == 1 && col == 19 || row == 2 && col == 19 || row == 3 && col == 19 || row == 4 && col == 19 || row == 4 && col == 18 || row == 4 && col == 17 || row == 4 && col == 16 || row == 4 && col == 15 || row == 4 && col == 14 || row == 4 && col == 13) {
                    Room r = new Room("");
                    layout[row][col] = r;
                } else if (row == 8 && col == 24 || row == 7 && col == 3) {
                    Room r = new Room("");
                    r.setTreasureRoom(true);
                    layout[row][col] = r;
                } else if (row == 3 && col == 13) {
                    Room r = new Room("");
                    r.setBossRoom(true);
                    layout[row][col] = r;
                } else {
                    RandomNum rn = new RandomNum();
                    // if(rn.random(0,25))
                    Room r = new Room("a damp dark Room");
                    r.setIsWall(true);
                    layout[row][col] = r;
                }
            }
        }
    }


    public void printMap() {

        clearMap();
        for (int row = 0; row < 10; row++) {
            //   System.out.println("row" + row);
            for (int col = 0; col < 27; col++) {
                //   System.out.println(col);
                if (layout[row][col].isCurrent()) {
                    appendToMap("░");
                    currentCol = col;
                    currentRow = row;
                } else if (layout[row][col].isBossRoom()) {
                    appendToMap("ßß");
                } else if (layout[row][col].isTreasureRoom()) {
                    appendToMap("┬");
                } else if (layout[row][col].isCleared()) {
                    appendToMap("▓");
                } else if (layout[row][col].isaRoom()) {
                    appendToMap("▒");
                } else if (layout[row][col].isaWall()) {
                    appendToMap("█");
                } else {
                    appendToMap("ERROR");
                }
            }
        }
    }


    private class EnterListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent arg0) {
            if (arg0.getKeyCode() == 10) {
                getTextField();
            }

        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

    }
}
