/*NameOfPlayer1
Leafeon 2 22 5 6
Flareon 1 22 5 6
Vaporeon 1 22 5 6
NameOfPlayer2
Leafeon 1 22 5 6
Flareon 3 22 5 6
Vaporeon 4 22 5 6 */

public class Pokemon {
    int level, remainHealth, attack, speed, normalAttack, Attack1, Attack2, skill1=5,skill2=5, remainHealthlimit,roundexperience=0, totalexperience=0;
    public String property,attack1Name,attack2Name;
    public void resume(){//恢復寶可夢生命值及技能
        remainHealth=remainHealthlimit;
        skill1=5;
        skill2=5;

        
    }

    /*變數用途說明
    int level:等級
    int remainHealth:剩餘生命值
    int attack:攻擊力
    int speed:速度
    int normalAttack:普通攻擊力
    int Attack1:技能攻擊1攻擊力
    int Attack2:技能攻擊2攻擊力
    int skill1:技能攻擊1剩餘次數
    int skill2:技能攻擊2剩餘次數
    int remainHealthlimit:生命值上限
    int roundexperience:該輪經驗值
    int totalexperience:總經驗值
    String property:寶可夢名稱
    String attack1Name:技能攻擊1名稱
    String attack2Name技能攻擊2名稱
     * 
     */

    public void dataRefresh(){       
    }
    public boolean resumeOrNot(){//狀態是否全滿
        if( remainHealthlimit<=remainHealth && skill1==5 && skill2==5){
            return false;
        }else{
            return true;
        }
        
    }
    
    
}
