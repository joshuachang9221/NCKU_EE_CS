
import java.util.ArrayList;

public class Attack {
    ArrayList<Pokemon> player1;
    ArrayList<Pokemon> player2;
    ArrayList<Player> player;
    public boolean stopattack=false;//是否停止攻擊
    public Attack(ArrayList<Pokemon> player1,ArrayList<Pokemon> player2,ArrayList<Player> player){//資料匯入
        this.player1=player1;
        this.player2=player2;
        this.player=player;
    }
    public double count(String p1Property , String p2Property){//(attacker,beingAttack)回傳剋屬倍率
        if(p1Property.equals(p2Property)){           
            return 1.0;
        }else if(p1Property.equals("Flareon")){
            if(p2Property.equals("Leafeon")){
                return 1.2;
            }else if(p2Property.equals("Vaporeon")){
                return 0.8;
            }else{
                System.out.println("error");
                return 0.0;
            }
        }else if(p1Property.equals("Leafeon")){
            if(p2Property.equals("Flareon")){
                return 0.8;

            }else if(p2Property.equals("Vaporeon")){
                return 1.2;
            }else{
                System.out.println("error");
                return 0.0;

            }
        }else if(p1Property.equals("Vaporeon")){
            if(p2Property.equals("Flareon")){
                return 1.2;

            }else if(p2Property.equals("Leafeon")){
                return 0.8;
            }else{
                System.out.println("error");
                return 0.0;
            }
        }else{
            System.out.println("error");
            return 0.0;
        }
    }

    public void pokemonSelect(int nowAttackPlayer,int playerbeAttack,ArrayList<Pokemon> playerattack,ArrayList<Pokemon> playerbeingattack){
        //用於判斷如果玩家目前寶可夢生命值=0時，自動切換寶可夢
        boolean exe=true;
        stopattack=false;
        exe=false;
        if(playerbeingattack.get(player.get(playerbeAttack).nowPokemon).remainHealth==0){
            for(int i=0;i<playerbeingattack.size();i++){//選擇被攻擊者寶可夢(生命值>=0)
                if(playerbeingattack.get(i).remainHealth>0){
                    player.get(playerbeAttack).nowPokemon=i;
                    System.out.println("系統已切換玩家(被攻擊者) "+ player.get(playerbeAttack).playername+" 的出戰寶可夢為編號 "+ (player.get(playerbeAttack).nowPokemon+1));
                    exe=true;
                    break;
                    
                }
            }
            if(exe==false){
                System.out.println("玩家(被攻擊者) "+ player.get(playerbeAttack).playername+" 的所有寶可夢均已無生命值 ");
                stopattack=true;
            }
        }
        
    }





    public void FirstAttack(){//於第一次攻擊時，依指示自動選擇玩家寶可夢並判斷誰是攻擊方
        boolean exe=false;
        stopattack=false;

        exe=false;
        for(int i=0;i<player1.size();i++){//選擇寶可夢(生命值>0)
            if(player1.get(i).remainHealth>0){//尚有生命值>0的寶可夢
                player.get(0).nowPokemon=i;
                exe=true;
                System.out.println("玩家一 "+ player.get(0).playername+" 的出戰寶可夢為編號 "+ (player.get(0).nowPokemon+1));
                break;
            }
        }
      
        
        if(exe==false){
            //
            stopattack=true;
        }

        exe=false;
        for(int i=0;i<player2.size();i++){//選擇寶可夢(生命值>0)
            if(player2.get(i).remainHealth>0){
                player.get(1).nowPokemon=i;
                exe=true;
                System.out.println("玩家二 "+ player.get(1).playername+" 的出戰寶可夢為編號 "+ (player.get(1).nowPokemon+1));
                break;
            }
        }
        
        if(exe==false){
            //System.out.println("玩家二 "+ player.get(1).playername+" 的所有寶可夢均已無生命值 ");
            stopattack=true;
        }

        if (player1.get(player.get(0).nowPokemon).speed >= player2.get(player.get(1).nowPokemon).speed) {
            hw4.nowAttackPlayer=0;//p1
            System.out.println("玩家一 "+ player.get(0).playername+" 為攻擊者 ");
        }else if (player1.get(player.get(0).nowPokemon).speed < player2.get(player.get(1).nowPokemon).speed) {
            hw4.nowAttackPlayer=1;
            System.out.println("玩家二 "+ player.get(1).playername+" 為攻擊者 ");
        }//由速度較快的寶可夢先出來
    }



    public boolean StopAttack(){
        //是否有任何一位玩家所有寶可夢生命值均為零
        stopattack=false;
        boolean exe=false;
        for(int i=0;i<player1.size();i++){//選擇被攻擊者寶可夢(生命值>=0)
            if(player1.get(i).remainHealth>0){
                
                exe=true;
                break;
                
            }
      
        }

        if(exe==false){
            System.out.println("玩家一 "+ player.get(0).playername+" 的所有寶可夢均已無生命值 ");
            stopattack=true;
            if(stopattack==true){
                AfterAttackPrintInfo(player.get(1).playername,player.get(0).playername,player1);
                dataRefresh();
                //stop.....
                return true;
            }else{
                return false;
            }
        }

        exe=false;
        for(int i=0;i<player2.size();i++){//選擇被攻擊者寶可夢(生命值>=0)
            if(player2.get(i).remainHealth>0){
            
            exe=true;
            break;
                
            }
      
        }

        if(exe==false){
            System.out.println("玩家二 "+ player.get(1).playername+" 的所有寶可夢均已無生命值 ");
            stopattack=true;
            if(stopattack==true){
                AfterAttackPrintInfo(player.get(0).playername,player.get(1).playername,player2);
                dataRefresh();
                //stop.....
                return true;
            }else{
                return false;
            }
        }
        return false;
        
    }



    public void normalattack(int nowAttackPlayer,int playerbeAttack,ArrayList<Pokemon> playerattack,ArrayList<Pokemon> playerbeingattack){//記得四捨五入
        //進行普通攻擊
        int causelife=(int)((playerattack.get(player.get( nowAttackPlayer ).nowPokemon).attack+playerattack.get(player.get(nowAttackPlayer).nowPokemon).normalAttack));//造成傷害
        causelife=(int)Math.round((causelife*count(playerattack.get(player.get(nowAttackPlayer).nowPokemon).property, playerbeingattack.get(player.get(playerbeAttack).nowPokemon).property) * 1.0) / 1.0);
        if(playerbeingattack.get(player.get(playerbeAttack).nowPokemon).remainHealth>=causelife){
            playerbeingattack.get(player.get(playerbeAttack).nowPokemon).remainHealth-=causelife;
        }else{
            playerbeingattack.get(player.get(playerbeAttack).nowPokemon).remainHealth=0;
        }
        playerbeingattack.get(player.get(playerbeAttack).nowPokemon).roundexperience+=causelife;
        playerbeingattack.get(player.get(playerbeAttack).nowPokemon).totalexperience+=causelife;
        System.out.println("攻擊完成");
    }


    public void skillattack(int nowAttackPlayer,int playerbeAttack,ArrayList<Pokemon> playerattack,ArrayList<Pokemon> playerbeingattack,int skillAttackvalue){//記得四捨五入
        //進行技能攻擊
        int causelife=(int)((playerattack.get(player.get(nowAttackPlayer).nowPokemon).attack+skillAttackvalue));//造成傷害
        causelife=(int)Math.round((causelife*count(playerattack.get(player.get(nowAttackPlayer).nowPokemon).property, playerbeingattack.get(player.get(playerbeAttack).nowPokemon).property) * 1.0) / 1.0);
        if(playerbeingattack.get(player.get(playerbeAttack).nowPokemon).remainHealth>=causelife){
            playerbeingattack.get(player.get(playerbeAttack).nowPokemon).remainHealth-=causelife;
           
        }
        else{
            playerbeingattack.get(player.get(playerbeAttack).nowPokemon).remainHealth=0;
            
        }
        playerbeingattack.get(player.get(playerbeAttack).nowPokemon).roundexperience+=causelife;
        playerbeingattack.get(player.get(playerbeAttack).nowPokemon).totalexperience+=causelife;
        System.out.println("攻擊完成");
    }





    

    public void AttackPrintInfo(){
        //於一般對戰中顯示資訊
        System.out.println("----------------------------------------------------------");
		System.out.println("第一位玩家姓名:  "+player.get(0).playername);
		System.out.println("  出戰寶可夢  等級  剩餘生命  技能一  技能二");

        System.out.println((player.get(0).nowPokemon+1)+"  "+player1.get(player.get(0).nowPokemon).property + "    " + player1.get(player.get(0).nowPokemon).level + "      " + player1.get(player.get(0).nowPokemon).remainHealth
                + "    (" + player1.get(player.get(0).nowPokemon).skill1 + "/5)    (" + player1.get(player.get(0).nowPokemon).skill2+"/5)");
    
		
		System.out.println("\n第二位玩家姓名:  "+player.get(1).playername);
		System.out.println("  出戰寶可夢  等級  剩餘生命  技能一  技能二");
		System.out.println((player.get(1).nowPokemon+1)+"  "+player2.get(player.get(1).nowPokemon).property + "    " + player2.get(player.get(1).nowPokemon).level + "      " + player2.get(player.get(1).nowPokemon).remainHealth
                + "    (" + player2.get(player.get(1).nowPokemon).skill1 + "/5)    (" + player2.get(player.get(1).nowPokemon).skill2+"/5)");
    
		System.out.println("----------------------------------------------------------");
    }

    public void AfterAttackPrintInfo(String winner,String looser,ArrayList<Pokemon> lose){
        //於逃跑與一般對戰結束時須顯示獲勝與落敗的玩家名字、該玩家擁有的全部寶可夢、每隻寶可夢各自獲得的經驗值與結算後的等級等資訊
        System.out.println("戰鬥結束，系統結算");
        cutFiftyExperience(lose);
        System.out.println("----------------------------------------------------------");
        System.out.println("獲勝者:"+winner);
        System.out.println("落敗者:"+looser);
        System.out.println("----------------------------------------------------------");
		System.out.println("第一位玩家姓名:  "+player.get(0).playername);
		System.out.println("  寶可夢名稱  等級  剩餘生命  技能一  技能二  (本次獲得經驗值/總經驗值)  ");
		for (int n = 0; n < player1.size(); n++) {
            if(player1.get(n).totalexperience>=800 && player1.get(n).level<3){
                player1.get(n).level=3;
                System.out.println("   ↓  已將等級升級至"+ player1.get(n).level);
            }else if(player1.get(n).totalexperience>=200 && player1.get(n).level<2){
                player1.get(n).level=2;
                System.out.println("   ↓  已將等級升級至"+ player1.get(n).level);
            }
			System.out.println((n+1)+"  "+player1.get(n).property + "    " + player1.get(n).level + "      " + player1.get(n).remainHealth
					+ "    (" + player1.get(n).skill1 + "/5)    (" + player1.get(n).skill2+"/5)       ("+player1.get(n).roundexperience+"/"+player1.get(n).totalexperience+")");
		}
		
		System.out.println("\n第二位玩家姓名:  "+player.get(1).playername);
		System.out.println("  寶可夢名稱  等級  剩餘生命  技能一  技能二  (本次獲得經驗值/總經驗值)  ");
		for (int n = 0; n < player2.size(); n++) {
			if(player2.get(n).totalexperience>=800 && player2.get(n).level<3){
                player2.get(n).level=3;
                System.out.println("   ↓  已將等級升級至"+ player2.get(n).level);
            }else if(player2.get(n).totalexperience>=200 && player2.get(n).level<2){
                player2.get(n).level=2;
                System.out.println("   ↓  已將等級升級至"+ player2.get(n).level);
            }
            System.out.println((n+1)+"  "+player2.get(n).property + "    " + player2.get(n).level + "      " + player2.get(n).remainHealth
					+ "    (" + player2.get(n).skill1 + "/5)    (" + player2.get(n).skill2+"/5)       ("+player2.get(n).roundexperience+"/"+player2.get(n).totalexperience+")");
		}
		System.out.println("----------------------------------------------------------");
	}
    

    public void dataRefresh(){
        //用於處理經驗值達升級標準後相關資料數據的處理及檢查
		for (int n = 0; n < player1.size(); n++) {
            player1.get(n).dataRefresh();//等級處理
		}
        for (int n = 0; n < player2.size(); n++) {
            player2.get(n).dataRefresh();
		
		}
		
		    
	}
    





    public void runaway(ArrayList<Pokemon> playernum,int n){//逃跑
        cutFiftyExperience(playernum);
        System.out.println("玩家"+player.get(n).playername+"已逃跑");
    }
    
    public void cutFiftyExperience(ArrayList<Pokemon> playernum){
        for(int i=0;i<playernum.size();i++){
            for(int k=1;k<=50;k++){
                if(playernum.get(i).roundexperience>0){
                    playernum.get(i).roundexperience--;
                   playernum.get(i).totalexperience--;
                }else{
                    break;
                }
           
            }
            
        }
    }



    public void toswitch(ArrayList<Pokemon> playernum,String pokemonnum, int nowAttackPlayer){//切換寶可夢
        if(player.get(nowAttackPlayer).nowPokemon==(Integer.parseInt(pokemonnum)-1)){
            System.out.println("錯誤，請勿選取相同寶可夢");
        }else if(playernum.size()==1){
            System.out.println("背包中只有一個寶可夢，無法選擇其他寶可夢");
        }else if((Integer.parseInt(pokemonnum))>playernum.size()){
            System.out.println("您輸入的數值超過您的寶可夢數量");
        }else if((Integer.parseInt(pokemonnum))<=0){
            System.out.println("您輸入的數字<=0");

        }else{
            if(playernum.get(Integer.parseInt(pokemonnum)-1).remainHealth==0){
                System.out.println("錯誤，該寶可夢生命值=0");
            }else{
                player.get(nowAttackPlayer).nowPokemon=Integer.parseInt(pokemonnum)-1;
                System.out.println("已將目前玩家"+player.get(nowAttackPlayer).playername+"的寶可夢更換為"+playernum.get(Integer.parseInt(pokemonnum)-1).property);
                hw4.printInfo(player1, player2,player);
            }                    
            
        }
    }

    public void superPotion(ArrayList<Pokemon> playernum, int nowAttackPlayer){//使用好傷藥
        if(player.get(nowAttackPlayer).superPotion==0){
            System.out.println("好傷藥(Super Potion)已使用完畢");
        }else{
            player.get(nowAttackPlayer).superPotion--;
            if((playernum.get(player.get(nowAttackPlayer).nowPokemon).remainHealth+50)<(playernum.get(player.get(nowAttackPlayer).nowPokemon).remainHealthlimit)){
                playernum.get(player.get(nowAttackPlayer).nowPokemon).remainHealth+=50;

            }else{
                playernum.get(player.get(nowAttackPlayer).nowPokemon).remainHealth=playernum.get(player.get(nowAttackPlayer).nowPokemon).remainHealthlimit;
            }
            System.out.println("----------------------------------------------------------");
            System.out.println("玩家"+player.get(nowAttackPlayer).playername+"已使用好傷藥(Super Potion)");
            System.out.println("剩餘次數:"+player.get(nowAttackPlayer).superPotion+"/2)");
            hw4.printInfo(player1, player2,player);
        }
    }
}