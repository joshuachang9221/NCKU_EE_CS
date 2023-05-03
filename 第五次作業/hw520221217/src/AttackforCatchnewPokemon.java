
import java.util.ArrayList;

public class AttackforCatchnewPokemon {
    ArrayList<Pokemon> playercatch;
    ArrayList<Pokemon> pokemontocatch;
    ArrayList<Player> player;
    public boolean stopattack=false;//是否停止攻擊
    public int playernum=0;
    public AttackforCatchnewPokemon(ArrayList<Pokemon>playercatch,ArrayList<Pokemon>pokemontocatch,ArrayList<Player> player,int playernum){//資料匯入
        this.playercatch=playercatch;
        this.pokemontocatch=pokemontocatch;
        this.player=player;
        this.playernum=playernum;
    }
    public static double count(String p1Property , String p2Property){//(attacker,beingAttack)回傳剋屬倍率
        if(p1Property.equals(p2Property)){           
            return 1.0;
        }else if(p1Property.equals("Flareon")){
            if(p2Property.equals("Leafeon")){
                System.out.println("剋屬倍率: 1.2");
                return 1.2;
            }else if(p2Property.equals("Vaporeon")){
                System.out.println("剋屬倍率: 0.8");
                return 0.8;
            }else{
                System.out.println("剋屬倍率: 1.0");
                return 1.0;
            }
        }else if(p1Property.equals("Leafeon")){
            if(p2Property.equals("Flareon")){
                System.out.println("剋屬倍率: 0.8");
                return 0.8;

            }else if(p2Property.equals("Vaporeon")){
                System.out.println("剋屬倍率: 1.2");
                return 1.2;
            }else{
                System.out.println("剋屬倍率: 1.0");
                return 1.0;
            }
        }else if(p1Property.equals("Vaporeon")){
            if(p2Property.equals("Flareon")){
                System.out.println("剋屬倍率: 1.2");
                return 1.2;

            }else if(p2Property.equals("Leafeon")){
                System.out.println("剋屬倍率: 0.8");
                return 0.8;
            }else{
                System.out.println("剋屬倍率: 1.0");
                return 1.0;
            }
        }else if(p1Property.equals("Espeon")){
            if(p2Property.equals("Umbreon")){
                System.out.println("剋屬倍率: 0.8");
                return 0.8;
            }else{
                System.out.println("剋屬倍率: 1.0");
                return 1.0;
            }
            
        }else if(p1Property.equals("Umbreon")){
            if(p2Property.equals("Espeon")){
                System.out.println("剋屬倍率: 1.2");
                return 1.2;
            }else{
                System.out.println("剋屬倍率: 1.0");
                return 1.0;
            }
        }else{
            System.out.println("error");
            return 0.0;

        }
    }

    public void pokemonSelect(){
        //用於判斷如果玩家目前寶可夢生命值=0時，自動切換寶可夢
        boolean exe=true;
        stopattack=false;
        exe=false;
        if(playercatch.get(player.get(playernum).nowPokemon).remainHealth==0){
            player.get(playernum).InAttackforPitemleftovers();
            for(int i=0;i<playercatch.size();i++){//選擇被攻擊者寶可夢(生命值>=0)
                if(playercatch.get(i).remainHealth>0){
                    player.get(playernum).nowPokemon=i;
                    System.out.println("系統已切換玩家 "+ player.get(playernum).playername+" 的出戰寶可夢為編號 "+ (player.get(playernum).nowPokemon+1));
                    exe=true;
                    break;
                    
                }
            }
            if(exe==false){
                System.out.println("玩家 "+ player.get(playernum).playername+" 的所有寶可夢均已無生命值 ");
                stopattack=true;
            }
        }else{
            playercatch.get(player.get(playernum).nowPokemon).leftoversInAttack();
        }
        
    }


    
    public void FirstAttack(){//於第一次攻擊時，依指示自動選擇玩家寶可夢並判斷誰是攻擊方
        boolean exe=false;
        stopattack=false;

        exe=false;
        for(int i=0;i<playercatch.size();i++){//選擇寶可夢(生命值>0)
            if(playercatch.get(i).remainHealth>0){//尚有生命值>0的寶可夢
                player.get(playernum).nowPokemon=i;
                exe=true;
                System.out.println("玩家 "+ player.get(playernum).playername+" 的出戰寶可夢為編號 "+ (player.get(playernum).nowPokemon+1));
                break;
            }
        }

        if(exe==false){
            
            stopattack=true;
        }

        if (playercatch.get(player.get(playernum).nowPokemon).speed >= pokemontocatch.get(0).speed) {
            CatchNewPokemon.nowAttackPlayer=0;

            System.out.println("玩家 "+ player.get(playernum).playername+" 為攻擊者 ");
        }else if (playercatch.get(player.get(playernum).nowPokemon).speed < pokemontocatch.get(0).speed) {
            CatchNewPokemon.nowAttackPlayer=1;
            System.out.println("寶可夢 "+ pokemontocatch.get(0).property+" 為攻擊者 ");
        }//由速度較快的寶可夢先出來
    }



    public boolean StopAttack(){
        //是否有任何一位玩家所有寶可夢生命值均為零
        stopattack=false;
        boolean exe=false;
        for(int i=0;i<playercatch.size();i++){//選擇被攻擊者寶可夢(生命值>=0)
            if(playercatch.get(i).remainHealth>0){

            exe=true;
            break;
                
            }
      
        }

        if(exe==false){
            System.out.println("玩家 "+ player.get(playernum).playername+" 的所有寶可夢均已無生命值 ");
            stopattack=true;
            if(stopattack==true){
                //stop.....
                return true;
            }else{
                return false;
            }
        }if(pokemontocatch.get(0).remainHealth==0){
            return true;
        }
        return false;
        
    }




    public void PitemafterAttack(){
        player.get(0).PitemafterAttack();
        player.get(1).PitemafterAttack();
    }


    public void resetroundexperience(){
        player.get(0).resetroundexperience();
        player.get(1).resetroundexperience();
    }
    public void normalattackbyplayer(){//記得四捨五入
        //進行普通攻擊
        int causelife=(int)((playercatch.get(player.get(playernum).nowPokemon).attack+playercatch.get(player.get(playernum).nowPokemon).normalAttack));//造成傷害
        causelife=(int)Math.round((causelife*count(playercatch.get(player.get(playernum).nowPokemon).property,pokemontocatch.get(0).property) * 1.0) / 1.0);
        if(pokemontocatch.get(0).remainHealth>=causelife){
            pokemontocatch.get(0).remainHealth-=causelife;
        }else{
            pokemontocatch.get(0).remainHealth=0;
        }
        
        System.out.println(player.get(playernum).playername+" 一般攻擊完成");
    }


    public void normalattackbypokemon(){//記得四捨五入
        //進行普通攻擊
        int causelife=(int)((pokemontocatch.get(0).attack+pokemontocatch.get(0).normalAttack));//造成傷害
        causelife=(int)Math.round((causelife*count(pokemontocatch.get(0).property,playercatch.get(player.get(playernum).nowPokemon).property) * 1.0) / 1.0);
        if(playercatch.get(player.get(playernum).nowPokemon).remainHealth>=causelife){
            playercatch.get(player.get(playernum).nowPokemon).remainHealth-=causelife;
        }else{
            playercatch.get(player.get(playernum).nowPokemon).remainHealth=0;
        }
        playercatch.get(player.get(playernum).nowPokemon).roundexperience+=causelife;
        playercatch.get(player.get(playernum).nowPokemon).totalexperience+=causelife;
        System.out.println("寶可夢一般攻擊完成");
    }

    public void skillattackbyplayer(int skillAttackvalue){//記得四捨五入
        //進行技能攻擊
        int causelife=(int)((playercatch.get(player.get(playernum).nowPokemon).attack+skillAttackvalue));//造成傷害
        causelife=(int)Math.round((causelife*count(pokemontocatch.get(player.get(playernum).nowPokemon).property,playercatch.get(player.get(playernum).nowPokemon).property) * 1.0) / 1.0);
        if(pokemontocatch.get(0).remainHealth>=causelife){
            pokemontocatch.get(0).remainHealth-=causelife;
        }else{
            pokemontocatch.get(0).remainHealth=0;
        }
        System.out.println(player.get(playernum).playername+" 技能攻擊完成");
    }





    

    public void AttackPrintInfo(){
        //於一般對戰中顯示資訊
        System.out.println("----------------------------------------------------------");
		System.out.println("玩家姓名:  "+player.get(playernum).playername);
		System.out.println("  出戰寶可夢  等級  剩餘生命  技能一  技能二  (該輪目前經驗值/總經驗值)");

        System.out.println((player.get(playernum).nowPokemon+1)+"  "+playercatch.get(player.get(playernum).nowPokemon).property + "    " + playercatch.get(player.get(playernum).nowPokemon).level + "      " + playercatch.get(player.get(playernum).nowPokemon).remainHealth
                + "    (" + playercatch.get(player.get(playernum).nowPokemon).skill1 + "/5)    (" +playercatch.get(player.get(playernum).nowPokemon).skill2+"/5)         ("+playercatch.get(player.get(playernum).nowPokemon).roundexperience+"/"+playercatch.get(player.get(playernum).nowPokemon).totalexperience+")");
    
		
	
    }

		
		
    

    public void dataRefresh(){
        //用於處理經驗值達升級標準後相關資料數據的處理及檢查
		for (int n = 0; n < playercatch.size(); n++) {
            playercatch.get(n).dataRefresh();//等級處理
            
		}	    
	}
    





    public void runaway(){//逃跑
        cutFiftyExperience();
        System.out.println("玩家"+player.get(playernum).playername+"已逃跑");
    }
    
    public void cutFiftyExperience(){
        for(int i=0;i<player.get(playernum).pokemonArraylist().size();i++){
            for(int k=1;k<=50;k++){
                if(playercatch.get(i).roundexperience>0){
                    playercatch.get(i).roundexperience--;
                    playercatch.get(i).totalexperience--;
                }else{
                    break;
                }
           
            }
            
        }
    }



    public void toswitch(int tochangepokemonum){//切換寶可夢
        if(player.get(playernum).nowPokemon==tochangepokemonum-1){
            System.out.println("錯誤，請勿選取相同寶可夢");
        }else if(playercatch.size()==1){
            System.out.println("背包中只有一個寶可夢，無法選擇其他寶可夢");
        }else if(tochangepokemonum>playercatch.size()){
            System.out.println("您輸入的數值超過您的寶可夢數量");
        }else if(tochangepokemonum<=0){
            System.out.println("您輸入的數字<=0");

        }else{
            if(player.get(playernum).pokemonArraylist().get(tochangepokemonum-1).remainHealth==0){
                System.out.println("錯誤，該寶可夢生命值=0");
            }else{
                player.get(playernum).nowPokemon=tochangepokemonum-1;
                System.out.println("已將目前玩家"+player.get(playernum).playername+"的寶可夢更換為"+player.get(playernum).pokemonArraylist().get(player.get(playernum).nowPokemon).property);
            }                    
            
        }
    }

    public void superPotion(){//使用好傷藥
        if(player.get(playernum).superPotion==0){
            System.out.println("好傷藥(Super Potion)已使用完畢");
        }else{
            player.get(playernum).superPotion--;
            if((playercatch.get(player.get(playernum).nowPokemon).remainHealth+50)<(playercatch.get(player.get(playernum).nowPokemon).remainHealthlimit)){
                playercatch.get(player.get(playernum).nowPokemon).remainHealth+=50;

            }else{
                playercatch.get(player.get(playernum).nowPokemon).remainHealth=playercatch.get(player.get(playernum).nowPokemon).remainHealthlimit;
            }
            System.out.println("----------------------------------------------------------");
            System.out.println("玩家"+player.get(playernum).playername+"已使用好傷藥(Super Potion)");
            System.out.println("剩餘次數:"+player.get(playernum).superPotion+"/2)");
        }
    }

    public void maxelixir(){
        
        System.out.println("技能攻擊次數已恢復");
        if(player.get(playernum).maxelixir==0){
            System.out.println("技能回復劑(max elixir)已使用完畢");
        }else{
            player.get(playernum).maxelixir--;
            playercatch.get(player.get(playernum).nowPokemon).skill1=5;
            playercatch.get(player.get(playernum).nowPokemon).skill2=playercatch.get(player.get(playernum).nowPokemon).Attack2limit;
            System.out.println("技能攻擊次數已恢復");
            System.out.println("----------------------------------------------------------");
            System.out.println("玩家"+player.get(playernum).playername+"已使用技能回復劑(max elixir)");
            System.out.println("剩餘次數:"+player.get(playernum).maxelixir+"/2)");
        }
        
        
    }
        
}