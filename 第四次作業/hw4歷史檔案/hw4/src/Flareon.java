public class Flareon extends Pokemon{
    public Flareon(int level,String property){
        
        this.property=property;
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

    }
   
}
