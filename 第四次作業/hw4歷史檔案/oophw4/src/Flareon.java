public class Flareon extends Pokemon{
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
    public Flareon(int level){
        

        property="Flareon";
        this.level=level;
        remainHealth=75+level*25;
        remainHealthlimit=remainHealth;
        attack=30+level*5;
        speed=7+level*1;
        normalAttack=10;
        Attack1=40;
        Attack2=120;
        attack1Name="ember";
        attack2Name="flareblitz";
        if(level==1){
            totalexperience=0;
        }else if(level==2){
            totalexperience=200;
        }else if(level==3){
            totalexperience=800;
        }
    }
    public void dataRefresh(){//等級更新
        remainHealthlimit=75+level*25;
        attack=30+level*5;
        speed=7+level*1;
        roundexperience=0;
    }
    
}
