/*NameOfPlayer1
Leafeon 2 22 5 6
Flareon 1 22 5 6
Vaporeon 1 22 5 6
NameOfPlayer2
Leafeon 1 22 5 6
Flareon 3 22 5 6
Vaporeon 4 22 5 6 */

public class Pokemon {
    int level, remainHealth, attack, speed, normalAttack, Attack1, Attack2, skill1=5,skill2=5, remainHealthlimit,experience=0, totalcauselife=0;
    public String property,attack1Name,attack2Name;
    public void resume(){
        remainHealth=remainHealthlimit;
        skill1=5;
        skill2=5;

        
    }
    public boolean resumeOrNot(){
        if( remainHealthlimit==remainHealth && skill1==5 && skill2==5){
            return false;
        }else{
            return true;
        }
        
    }
    
}
