public class Banana{
 public static int LifeEndurance = 60;
 public static int FruitLimitation = 100;
 public static int DailyFruit = 5;
 public String name;
 public int CurrentFruitNumber = 0;
 public int Age = 0;
 public int place = 0;

 
 /*果實達上限就不會繼續增加 */
 public void check(){
  if( CurrentFruitNumber > FruitLimitation){
    CurrentFruitNumber = 100;
  }
 }
 /*達壽命上限 */
 public void death(){
  if(Age == LifeEndurance){
    DailyFruit = 0;
  }
 }
 
}


