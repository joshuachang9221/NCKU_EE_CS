public class Vaporeon extends Pokemon{
    public Vaporeon(int level,String property){
        
        this.property=property;
        this.level=level;
        remainHealth=70+level*35;
        remainHealthlimit=remainHealth;
        attack=28+level*4;
        speed=2+level*3;
        normalAttack=12;
        Attack1=40;
        Attack2=110;
        attack1Name="watergun";
        attack2Name="hydropumpe";
    }
    
}
