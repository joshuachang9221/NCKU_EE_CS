
import java.util.ArrayList;
public class CatchNewPokemon {
    ArrayList<Pokemon> player1;
    ArrayList<Pokemon> player2;
    ArrayList<Player> player;
    private boolean stopattack=false;//是否停止攻擊
    public boolean successattack=false;//是否成功捕捉
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
                    exe=true;
                    break;
                }
          
            }
            if(exe==false){
                System.out.println("玩家 "+ player.get(playercatch).playername+" 的所有寶可夢均已無生命值 ");
                stopattack=true;
                successattack=false;
            }
        }

        if(pokemon.remainHealth==0){
            
            stopattack=true;
            successattack=true;
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
    }

    public void attacktoplayer(ArrayList<Pokemon> playerattack,Pokemon playerbeAttack,String Pokemonname,int nowplayer){
        int causelife=((playerbeAttack.attack  +  playerbeAttack.normalAttack));//造成傷害
        causelife=(int)Math.round((causelife*count(playerbeAttack.property, playerattack.get(player.get(nowplayer).nowPokemon).property) * 1.0) / 1.0);
        if(playerattack.get(player.get(nowplayer).nowPokemon).remainHealth>=causelife){
            playerattack.get(player.get(nowplayer).nowPokemon).remainHealth-=causelife;
            playerattack.get(player.get(nowplayer).nowPokemon).totalexperience+=causelife;
            playerattack.get(player.get(nowplayer).nowPokemon).roundexperience+=causelife;

        }else{
            playerattack.get(player.get(nowplayer).nowPokemon).totalexperience+=playerattack.get(player.get(nowplayer).nowPokemon).remainHealth;
            playerattack.get(player.get(nowplayer).nowPokemon).roundexperience+=playerattack.get(player.get(nowplayer).nowPokemon).remainHealth;
            playerattack.get(player.get(nowplayer).nowPokemon).remainHealth=0;
        }
    }

    
    public void catchPokemon(ArrayList<Pokemon> playerattack,String Pokemonname,int level,int nowplayer){//主程式
        playerattack.get(player.get(nowplayer).nowPokemon).roundexperience=0;
        if(level<=3){
            if(Pokemonname.equals("Leafeon")){
                Pokemon pokemon=new Leafeon(level);
                FirstAttack(playerattack,pokemon,Pokemonname,nowplayer);
                for(int i=1;i<=8;i++){
                    pokemonSelect(nowplayer,playerattack,pokemon);
                    if(stopattack==true){
                        break;//停止攻擊
                        }  //生命值=0
        
                    
                    if(nowattackisplayer==true){
                        attacktoplayer(playerattack, pokemon, Pokemonname, nowplayer);
                        nowattackisplayer=false;
                        
                    }else if(nowattackisplayer==false){
                        attacktoPokemon(playerattack, pokemon, Pokemonname, nowplayer);
                        nowattackisplayer=true;
                    
                    }
                         
                }
                System.out.println("----------------------------------------------------------");
                if(!(pokemon.remainHealth==0)){
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 失敗抓取寶可夢 "+Pokemonname);
                }else{
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 成功抓取寶可夢 "+Pokemonname);
                    playerattack.add(new Leafeon(level));
                }
                AfterAttackPrintInfo(playerattack,nowplayer);
            }else if(Pokemonname.equals("Flareon")){
                Pokemon pokemon=new Flareon(level);
                FirstAttack(playerattack,pokemon,Pokemonname,nowplayer);
                for(int i=1;i<=8;i++){
                    pokemonSelect(nowplayer,playerattack,pokemon);
                    if(stopattack==true){
                        break;//停止攻擊
                        }  //生命值=0 
        
                    
                    if(nowattackisplayer==true){
                        attacktoplayer(playerattack, pokemon, Pokemonname, nowplayer);
                        nowattackisplayer=false;
                        
                    }else if(nowattackisplayer==false){
                        attacktoPokemon(playerattack, pokemon, Pokemonname, nowplayer);
                        nowattackisplayer=true;
                    
                    }
                         
                }
                System.out.println("----------------------------------------------------------");
                if(!(pokemon.remainHealth==0)){
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 失敗抓取寶可夢 "+Pokemonname);
                }else{
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 成功抓取寶可夢 "+Pokemonname);
                    playerattack.add(new Flareon(level));
                }
                AfterAttackPrintInfo(playerattack,nowplayer);
            }else if(Pokemonname.equals("Vaporeon")){
                Pokemon pokemon=new Vaporeon(level);
                FirstAttack(playerattack,pokemon,Pokemonname,nowplayer);
                for(int i=1;i<=8;i++){
                    pokemonSelect(nowplayer,playerattack,pokemon);
                    if(stopattack==true){
                        break;//停止攻擊
                    }  //生命值=0
        
                    
                    if(nowattackisplayer==true){
                        attacktoplayer(playerattack, pokemon, Pokemonname, nowplayer);
                        nowattackisplayer=false;
                        
                    }else if(nowattackisplayer==false){
                        attacktoPokemon(playerattack, pokemon, Pokemonname, nowplayer);
                        nowattackisplayer=true;
                    
                    }
                    
    
                       
                }
                System.out.println("----------------------------------------------------------");
                if(!(pokemon.remainHealth==0)){
                    System.out.println("玩家 "+ player.get(nowplayer).playername+" 失敗抓取寶可夢 "+Pokemonname);
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

    public void FirstAttack(ArrayList<Pokemon> playerattack,Pokemon pokemon,String Pokemonname,int nowplayer){//首次攻擊，寶可夢初始化
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
        }else if (playerattack.get(player.get(nowplayer).nowPokemon).speed < pokemon.speed) {
            nowattackisplayer=false;
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
					+ "    (" + playerattack.get(n).skill1 + "/5)    (" + playerattack.get(n).skill2+"/5)       ("+ playerattack.get(n).roundexperience+"/"+player1.get(n).totalexperience+")");
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


}
