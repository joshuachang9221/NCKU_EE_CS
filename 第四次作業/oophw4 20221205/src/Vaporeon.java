public class Vaporeon extends Pokemon{
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

    public Vaporeon(int level){
        

        property="Vaporeon";
        this.level=level;
        remainHealth=70+level*35;
        remainHealthlimit=remainHealth;
        attack=28+level*4;
        speed=2+level*3;
        normalAttack=13;
        Attack1=40;
        Attack2=110;
        attack1Name="watergun";
        attack2Name="hydropump";
        if(level==1){
            totalexperience=0;
        }else if(level==2){
            totalexperience=200;
        }else if(level==3){
            totalexperience=800;
        }
    }
    public void dataRefresh(){//等級更新
        remainHealthlimit=70+level*35;
        attack=28+level*4;
        speed=2+level*3;
        roundexperience=0;
    }
}
