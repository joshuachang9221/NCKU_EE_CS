
import java.util.ArrayList;
public class CatchNewPokemon {
    ArrayList<Pokemon> player1;
    ArrayList<Pokemon> player2;
    ArrayList<Player> player;
    private boolean stopattack=false;//是否停止攻擊
    public boolean nowattackisplayer=true;//目前攻擊方
    public CatchNewPokemon(ArrayList<Pokemon> player1,ArrayList<Pokemon> player2,ArrayList<Player> player){
        this.player1=player1;
        this.player2=player2;
        this.player=player;
    }




    public double count(String p1Property , String p2Property){//(attacker,beingAttack)
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

    public void pokemonSelect(int playercatch,ArrayList<Pokemon> nowplayer,Pokemon pokemon){//記得四捨五入
        boolean exe=true;
        stopattack=false;
        exe=false;
        if(nowplayer.get(player.get(playercatch).nowPokemon).remainHealth==0){
            for(int i=0;i<nowplayer.size();i++){//選擇被攻擊者寶可夢(生命值>=0)
                if(nowplayer.get(i).remainHealth>0){
                    player.get(playercatch).nowPokemon=i;
                    System.out.println("系統已切換玩家(被攻擊者) "+ player.get(playercatch).playername+" 的出戰寶可夢為編號 "+ (player.get(playercatch).nowPokemon+1));
                    exe=true;
                    break;
                }
          
            }
            if(exe==false){
                System.out.println("玩家 "+ player.get(playercatch).playername+" 的所有寶可夢均已無生命值 ");
                stopattack=true;
            }
        }

        if(pokemon.remainHealth==0){
            stopattack=true;
        }
    }
        
    

    

    public void attacktoPokemon(ArrayList<Pokemon> playerattack,Pokemon playerbeAttack,String Pokemonname,int nowplayer){//玩家進攻
        int causelife=((playerattack.get(player.get(nowplayer).nowPokemon).attack  +  playerattack.get(player.get(nowplayer).nowPokemon).normalAttack));//造成傷害
        causelife=(int)Math.round((causelife*count(playerattack.get(player.get(nowplayer).nowPokemon).property, playerbeAttack.property) * 1.0) / 1.0);
        if(playerbeAttack.remainHealth>=causelife){
            playerbeAttack.remainHealth-=causelife;
            
        }else{
            playerbeAttack.remainHealth=0;
            
        }
        System.out.println("玩家 "+player.get(nowplayer).playername+"普通攻擊完成");
    }

    public void attacktoplayer(ArrayList<Pokemon> playerattack,Pokemon playerbeAttack,String Pokemonname,int nowplayer){
        int causelife=((playerbeAttack.attack  +  playerbeAttack.normalAttack));//造成傷害
        causelife=(int)Math.round((causelife*count(playerbeAttack.property, playerattack.get(player.get(nowplayer).nowPokemon).property) * 1.0) / 1.0);
        if(playerattack.get(player.get(nowplayer).nowPokemon).remainHealth>=causelife){
            playerattack.get(player.get(nowplayer).nowPokemon).remainHealth-=causelife;

        }else{
            playerattack.get(player.get(nowplayer).nowPokemon).remainHealth=0;
        }
        System.out.println("正在捕捉的寶可夢 "+Pokemonname+"普通攻擊完成");
        playerattack.get(player.get(nowplayer).nowPokemon).totalexperience+=causelife;
        playerattack.get(player.get(nowplayer).nowPokemon).roundexperience+=causelife;
    }
    
    public void catchPokemon(ArrayList<Pokemon> playerattack,String Pokemonname,int level,int nowplayer){//主程式
        playerattack.get(player.get(nowplayer).nowPokemon).roundexperience=0;
        if(level<=3){
            if(Pokemonname.equals("Leafeon")){
                Pokemon pokemon=new Leafeon(level);
                catchPokemonexe(playerattack,pokemon, Pokemonname, level,nowplayer);
                
                System.out.println("----------------------------------------------------------");
                if(!(pokemon.remainHealth==0)){
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 失敗抓取寶可夢 "+Pokemonname);
                    cutFiftyExperience(playerattack);
                }else{
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 成功抓取寶可夢 "+Pokemonname);
                    playerattack.add(new Leafeon(level));
                }
                AfterAttackPrintInfo(playerattack,nowplayer);
            }else if(Pokemonname.equals("Flareon")){
                Pokemon pokemon=new Flareon(level);
                catchPokemonexe(playerattack,pokemon, Pokemonname, level,nowplayer);
                
                System.out.println("----------------------------------------------------------");
                if(!(pokemon.remainHealth==0)){
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 失敗抓取寶可夢 "+Pokemonname);
                    cutFiftyExperience(playerattack);
                }else{
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 成功抓取寶可夢 "+Pokemonname);
                    playerattack.add(new Flareon(level));
                }
                AfterAttackPrintInfo(playerattack,nowplayer);
            }else if(Pokemonname.equals("Vaporeon")){
                Pokemon pokemon=new Vaporeon(level);
                catchPokemonexe(playerattack,pokemon, Pokemonname, level,nowplayer);      
                System.out.println("----------------------------------------------------------");
                if(!(pokemon.remainHealth==0)){
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 失敗抓取寶可夢 "+Pokemonname);
                    cutFiftyExperience(playerattack);
                }else{
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 成功抓取寶可夢 "+Pokemonname);
                    playerattack.add(new Vaporeon(level));
                }
                AfterAttackPrintInfo(playerattack,nowplayer);
                
            }else{
                System.out.println("寶可夢名稱輸入錯誤，請重新輸入");
                System.out.println("----------------------------------------------------------");
            }
            
        }else{
            System.out.println("您輸入的寶可夢等級過大");
        }
        
		
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

    public void catchPokemonexe(ArrayList<Pokemon> playerattack,Pokemon Pokemon,String Pokemonname,int level,int nowplayer){
        player.get(0).superPotion=2;
        player.get(1).superPotion=2;
        
        boolean attackExe=true;//是否繼續攻擊
        FirstAttack(playerattack,Pokemon,nowplayer);//首次攻擊建置資料
        int nowRound=1;
        while(attackExe){
            if(stopattack==true){//停止攻擊
                break;
            }else if(nowRound==5){
                System.out.println("已攻擊四回合\n戰鬥結束");
                break;
            }           
            System.out.println("回合數:"+nowRound);	
            System.out.println("----------------------------------------------------------");
            System.out.println("正在進行捕捉一般對戰");
            System.out.println("請輸入[attack]、[attack] [技能名稱]、[super] [potion]、[run] [away]、[switch] [寶可夢編號]");
            String function = ConsoleIn.readLine();
            String splitfunction[] = function.split(" ");
            if (function.equals("attack")){//一般攻擊
                if(nowattackisplayer==true){
                    attacktoPokemon(playerattack, Pokemon, Pokemonname, nowplayer);
                    attacktoplayer(playerattack, Pokemon, Pokemonname, nowplayer);
                    
                }else{
                    attacktoplayer(playerattack, Pokemon, Pokemonname, nowplayer);
                    attacktoPokemon(playerattack, Pokemon, Pokemonname, nowplayer);
                    
                }
                pokemonSelect(nowplayer, playerattack, Pokemon);
                AttackPrintInfo(playerattack, Pokemon,Pokemonname, level, nowplayer);//顯示戰鬥結果
                nowRound++;
            }else if (splitfunction[0].equals("attack")) {//技能攻擊
                int skillAttackvalue=0; 
                if (splitfunction[1].equals(playerattack.get(player.get(nowplayer).nowPokemon).attack1Name)) {
                    if(playerattack.get(player.get(0).nowPokemon).skill1>0){
                        playerattack.get(player.get(0).nowPokemon).skill1--;
                        skillAttackvalue=playerattack.get(player.get(nowplayer).nowPokemon).skill1; 
                        if(nowattackisplayer==true){
                            skillattacktoPokemon(nowplayer, playerattack, Pokemon, skillAttackvalue);
                            attacktoplayer(playerattack, Pokemon, Pokemonname, nowplayer);
                            
                        }else{
                            attacktoplayer(playerattack, Pokemon, Pokemonname, nowplayer);
                            skillattacktoPokemon(nowplayer, playerattack, Pokemon, skillAttackvalue);

                        }
                        nowRound++;
                    }else{
                        System.out.println("技能 "+player1.get(player.get(0).nowPokemon).attack1Name+"已用盡\n請重新輸入");
                        System.out.println("----------------------------------------------------------");
                        break;
                    }
                }else if(splitfunction[1].equals(playerattack.get(player.get(nowplayer).nowPokemon).attack2Name)){
                        if(playerattack.get(player.get(0).nowPokemon).skill2>0){
                            playerattack.get(player.get(0).nowPokemon).skill2--;
                            skillAttackvalue=playerattack.get(player.get(nowplayer).nowPokemon).skill2;
                            if(nowattackisplayer==true){
                                skillattacktoPokemon(nowplayer, playerattack, Pokemon, skillAttackvalue);
                                attacktoplayer(playerattack, Pokemon, Pokemonname, nowplayer);
                                
                            }else{
                                attacktoplayer(playerattack, Pokemon, Pokemonname, nowplayer);
                                skillattacktoPokemon(nowplayer, playerattack, Pokemon, skillAttackvalue);
    
                            }   
                            nowRound++;
                        }else{
                            System.out.println("技能 "+playerattack.get(player.get(nowplayer).nowPokemon).attack2Name+"已用盡\n請重新輸入");
                            System.out.println("----------------------------------------------------------");
                            break;
                        }
                }else{
                        System.out.println("技能輸入錯誤");
                        System.out.println("----------------------------------------------------------");
                }
                pokemonSelect(nowplayer, playerattack, Pokemon);
                System.out.println("技能攻擊完成");
                AttackPrintInfo(playerattack, Pokemon,Pokemonname, level, nowplayer);//顯示戰鬥結果
            }else if (function.equals("super potion")) {//使用好傷藥
                //superPotion(ArrayList<Pokemon> playernum,String pokemonnum,ArrayList<Player> player, int nowAttackPlayer,ArrayList<Pokemon> player1,ArrayList<Pokemon> player2)
                superPotion(playerattack,1);
                
            } else if (function.equals("run away")) {
                runaway( playerattack);       
                break;

            } else if (splitfunction[0].equals("switch")) {
            toswitch(playerattack,splitfunction[1],nowplayer);
                
                
            } else{
                System.out.println("輸入錯誤，請重新輸入");
            }
            
        }

    

    }

    public void AttackPrintInfo(ArrayList<Pokemon> playerattack,Pokemon Pokemon,String Pokemonname,int level,int nowplayer){
        //於一般對戰中顯示資訊
        System.out.println("----------------------------------------------------------");
		System.out.println("第一位玩家姓名:  "+player.get(nowplayer).playername);
		System.out.println("  出戰寶可夢  等級  剩餘生命  技能一  技能二");

        System.out.println((player.get(nowplayer).nowPokemon+1)+"  "+playerattack.get(player.get(nowplayer).nowPokemon).property + "    " + playerattack.get(player.get(nowplayer).nowPokemon).level + "      " + playerattack.get(player.get(nowplayer).nowPokemon).remainHealth
                + "    (" + playerattack.get(player.get(nowplayer).nowPokemon).skill1 + "/5)    (" + playerattack.get(player.get(nowplayer).nowPokemon).skill2+"/5)");
    
		System.out.println("----------------------------------------------------------");
    }



    public void skillattacktoPokemon(int nowplayer,ArrayList<Pokemon> playerattack,Pokemon pokemon,int skillAttackvalue){//記得四捨五入
        //進行技能攻擊
        int causelife=(int)((playerattack.get(player.get(nowplayer).nowPokemon).attack+skillAttackvalue));//造成傷害
        causelife=(int)Math.round((causelife*count(playerattack.get(player.get(nowplayer).nowPokemon).property, pokemon.property) * 1.0) / 1.0);
        if(playerattack.get(player.get(nowplayer).nowPokemon).remainHealth>=causelife){
            playerattack.get(player.get(nowplayer).nowPokemon).remainHealth-=causelife;

        }
        else{
            playerattack.get(player.get(nowplayer).nowPokemon).remainHealth=0; 
        }
        System.out.println("玩家 "+player.get(nowplayer).playername+"技能攻擊完成");
        playerattack.get(player.get(nowplayer).nowPokemon).roundexperience+=causelife;
        playerattack.get(player.get(nowplayer).nowPokemon).totalexperience+=causelife;
    }


    public void FirstAttack(ArrayList<Pokemon> playerattack,Pokemon pokemon,int nowplayer){//首次攻擊，寶可夢初始化
        boolean exe=false;
        stopattack=false;
        exe=false;
        for(int i=0;i<playerattack.size();i++){//選擇寶可夢(生命值>0)
            if(playerattack.get(i).remainHealth>0){
                player.get(nowplayer).nowPokemon=i;
                exe=true;
                break;
            }
        }
      
        
        if(exe==false){
            //
            stopattack=true;
        }

        if (playerattack.get(player.get(nowplayer).nowPokemon).speed >= pokemon.speed) {
            nowattackisplayer=true;
            System.out.println("目前攻擊方為玩家");
        }else if (playerattack.get(player.get(nowplayer).nowPokemon).speed < pokemon.speed) {
            nowattackisplayer=false;
            System.out.println("目前攻擊方為待捕捉的寶可夢");
        }//由速度較快的寶可夢先出來
        
    }

    public void AfterAttackPrintInfo(ArrayList<Pokemon> playerattack,int nowplayer){//列印詳細資訊，資料更新_等級
        System.out.println("----------------------------------------------------------");
		System.out.println("玩家姓名:  "+player.get(nowplayer).playername);
		System.out.println("  寶可夢名稱  等級  剩餘生命  技能一  技能二  (本次獲得經驗值/總經驗值)  ");
		for (int n = 0; n < playerattack.size(); n++) {
            if(playerattack.get(n).totalexperience>=800 && playerattack.get(n).level<3){
                playerattack.get(n).level=3;
                System.out.println("   ↓  已將等級升級至"+ playerattack.get(n).level);
            }else if(playerattack.get(n).totalexperience>=200 && playerattack.get(n).level<2){
                playerattack.get(n).level=2;
                System.out.println("   ↓  已將等級升級至"+ playerattack.get(n).level);
            }
			System.out.println((n+1)+"  "+playerattack.get(n).property + "    " + playerattack.get(n).level + "      " + playerattack.get(n).remainHealth
					+ "    (" + playerattack.get(n).skill1 + "/5)    (" + playerattack.get(n).skill2+"/5)       ("+ playerattack.get(n).roundexperience+"/"+playerattack.get(n).totalexperience+")");
		}
		System.out.println("----------------------------------------------------------");
        dataRefresh();
	}
    

    public void dataRefresh(){//等級更新
		for (int n = 0; n < player1.size(); n++) {
            player1.get(n).dataRefresh();//等級處理
		}
        for (int n = 0; n < player2.size(); n++) {
            player2.get(n).dataRefresh();
		
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



    public void runaway(ArrayList<Pokemon> playernum){//逃跑
        cutFiftyExperience(playernum);
        System.out.println("玩家已逃跑");
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
            }                    
            
        }
    }
}
