public class Leafeon extends Pokemon{
    public Leafeon(int level,String property){
        
        this.property=property;
        this.level=level;
        remainHealth=80+level*40;
        remainHealthlimit=remainHealth;
        attack=27+level*3;
        speed=5+level*2;
        normalAttack=12;
        Attack1=40;
        Attack2=90;
        attack1Name="razorleaf";
        attack2Name="leafblade";
    }
    
}
