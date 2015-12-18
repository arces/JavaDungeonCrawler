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
    private int currentRow =0;
    private int currentCol =0;
    private String textField="";
    private boolean tutorial1,tutorial2,tutorialDone;

    public Main() {
        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(btnAttack);
    }

    public void clearMap() {
        AreaMap.setText("");
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
        printMap();
        tutorial("");

    }

    public static void main(String[] args) {
        Main dialog = new Main();
        dialog.pack();
        dialog.mainThread();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void getTextField(){
        textField=TextF.getText();
        System.out.println(textField);
        TextF.setText("");

    }
    private void tutorial(String str){
        AreaCon.append("Welcome to textRPG written by Dan Janes\nThis is the tutorial, to skip type /skipT\nTo go to the next slide type /next");
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
                        row == 6 && col == 21 || row == 6 && col == 22 || row == 7 && col == 22 || row == 8 && col == 22 || row == 8 && col == 23||row == 8 && col == 11||row == 8 && col == 10||row == 8 && col == 9||row == 8 && col == 8||
                        row == 7 && col == 9||row == 6 && col == 9||row == 5 && col == 9||row == 4 && col == 9||row == 3 && col == 9||row == 4 && col == 8||row == 4 && col == 7||row == 4 && col == 6||row == 5 && col == 6||row == 6 && col == 6||row == 7 && col == 6||row == 7 && col == 5||
                row == 7 && col == 4||row == 2 && col == 9||row == 1 && col == 9||row == 1 && col == 8||row == 1 && col == 7||row == 1 && col == 10||row == 1 && col == 11||row == 1 && col == 12||row == 1 && col == 13||row == 1 && col == 14||row == 1 && col == 15||row == 1 && col == 16
                        ||row == 1 && col == 17||row == 1 && col == 18||row == 1 && col == 19||row == 2 && col == 19||row == 3 && col == 19||row == 4 && col == 19||row == 4 && col == 18||row == 4 && col == 17||row == 4 && col == 16||row == 4 && col == 15||row == 4 && col == 14||row == 4 && col == 13) {
                    Room r = new Room("");
                    layout[row][col] = r;
                } else if (row == 8 && col == 24||row == 7 && col == 3) {
                    Room r = new Room("");
                    r.setTreasureRoom(true);
                    layout[row][col] = r;}
                else if (row == 3 && col == 13){
                    Room r = new Room("");
                    r.setBossRoom(true);
                    layout[row][col]=r;
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
            System.out.println("row" + row);
            for (int col = 0; col < 27; col++) {
                System.out.println(col);
                if (layout[row][col].isCurrent()) {
                    appendToMap("░");
                    currentCol=col;
                    currentRow=row;
                }else if (layout[row][col].isBossRoom()){
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
                    appendToMap("K");
                }
            }
        }
    }










    private class EnterListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent arg0) {
            if(arg0.getKeyCode()==10){
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
