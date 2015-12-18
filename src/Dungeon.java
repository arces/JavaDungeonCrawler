public class Dungeon {

    public int layout[][] = new int[10][27];
    /**Index
     ▓ is Cleared
     ▒ is not cleared
     ░ is current
     ┬ is tresure room
     █ is nothing/walls/blank



     */

/**
    public void fillLayout(){
        for(int row = 0; row <10; row++){

            for(int col=0; col<27; col++){
                if(row==0||row==9||col==0||col==26){
                    layout[row][col]=0;
                }
                else {
                    layout[row][col] = 1;
                }
            }
        }
    }


    public void printMap(){
        Main m = new Main();
        m.clearMap();
        for(int row = 0; row <10; row++){
            System.out.println("row"+row);
            for(int col=0; col<27; col++){
                System.out.println(col);
                if(layout[row][col]==0){
                    m.appendToMap("█");
                }else if(layout[row][col]==1){
                    m.appendToMap("▒");
                }else{
                    m.appendToMap("K");
                }
            }
        }
    }
*/
}
