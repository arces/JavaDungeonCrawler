/**
 * Created by Dan on 12/19/2015.
 */
public class tresureroom {

    private weapon w;

    public tresureroom(){
        RandomNum r = new RandomNum();
        int temp = r.random(1,90);
        if(temp<=10){
            w=(weapon) new weapon1();
        }else if (temp<=20){
            w=(weapon) new weapon2();
        }else if (temp<=30){
            w=(weapon) new weapon3();
        }else if (temp<=40){
            w=(weapon) new weapon4();
        }else if (temp<=50){
            w=(weapon) new weapon5();
        }else if (temp<=60){
            w=(weapon) new weapon6();
        }else if (temp<=70){
            w=(weapon) new weapon7();
        }else if (temp<=80){
            w=(weapon) new weapon8();
        }else if (temp<=85){
            w=(weapon) new weapon9();
        }else if (temp<=90){
            w=(weapon) new weapon10();
        }else{
            w=(weapon) new weapon1();
        }
    }
    public weapon getItem(){
        return w;
    }
}
