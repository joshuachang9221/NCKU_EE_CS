import java.util.*;
public class CatchNewPokemon {
    ArrayList<Pokemon> playercatch;
    ArrayList<Pokemon> pokemontocatch= new ArrayList<>();
    ArrayList<Player> player;
    int playernum=0,level;
    String PokemonName;
    public static int nowAttackPlayer=-1;//1玩家、2寶可夢
    public static boolean nextRound=false;
    public CatchNewPokemon(ArrayList <Pokemon> playercatch,ArrayList<Player> player,int playernum){//資料匯入
        this.playercatch=playercatch;
        this.player=player;
        this.playernum=playernum;
        
    }
    
    public void initiallizecatchPokemon(String PokemonName,int level){
        this.PokemonName=PokemonName;
        this.level=level;
        if(PokemonName.equals("Leafeon")) {
            pokemontocatch.add(new Leafeon(level));
            System.out.println("玩家 "+player.get(playernum).playername+"已選擇捕捉寶可夢等級"+level+" Leafeon");
        }else if (PokemonName.equals("Flareon")) {
            pokemontocatch.add(new Flareon(level));
            System.out.println("玩家 "+player.get(playernum).playername+"已選擇捕捉寶可夢等級"+level+" Flareon");
        }else if (PokemonName.equals("Vaporeon")) {
            pokemontocatch.add(new Vaporeon(level));
            System.out.println("玩家 "+player.get(playernum).playername+"已選擇捕捉寶可夢等級"+level+" Vaporeon");
        }else if (PokemonName.equals("Espeon")) {
            pokemontocatch.add(new Espeon(level));
            System.out.println("玩家 "+player.get(playernum).playername+"已選擇捕捉寶可夢等級"+level+" Espeon");
        }else if (PokemonName.equals("Umbreon")) {
            pokemontocatch.add(new Umbreon(level));
            System.out.println("玩家 "+player.get(playernum).playername+"已選擇捕捉寶可夢等級"+level+" Umbreon");
        }
        else{
            System.out.println("寶可夢名稱錯誤");
        }
    }


    public void catchexe(){
        AttackforCatchnewPokemon attack=new AttackforCatchnewPokemon(playercatch,pokemontocatch,player,playernum);
        player.get(playernum).superPotion=2;
        player.get(playernum).maxelixir=2;
        int nowRound=1;
		nextRound=false;
        boolean attackExe=true;//是否繼續攻擊
        attack.FirstAttack();//首次攻擊建置資料
        while(attackExe){
            if(attack.StopAttack()==true|| nowRound==5){
                break;
            }//停止攻擊
            if(nowAttackPlayer==1){
                System.out.println("----------------------------------------------------------");
                System.out.println("寶可夢 "+ pokemontocatch.get(0).property+" 為攻擊者 ");
                attack.normalattackbypokemon();
                attack.pokemonSelect();
                nowAttackPlayer=0;
                if(nextRound==false){//是否增加回合數
                    nextRound=true;
                }else if(nextRound==true){
                    nextRound=false;
                    nowRound++;
                }
                continue; 
                
            }
            System.out.println("回合數:"+nowRound);	
            System.out.println("----------------------------------------------------------");
            System.out.println("正在進行捕捉");
            System.out.println("請輸入[attack]、[attack] [技能名稱]、[max][elixir]、[super] [potion]、[run] [away]、[switch] [寶可夢編號]");
            if(nowAttackPlayer==0){
                System.out.println("玩家 "+ player.get(playernum).playername+" 為攻擊者 ");
            }
            String function = ConsoleIn.readLine();
            String splitfunction[] = function.split(" ");
            if (function.equals("attack")){//一般攻擊
                attack.normalattackbyplayer();
                nowAttackPlayer=1;
                attack.AttackPrintInfo();//顯示玩家戰鬥資料
            } else if (splitfunction[0].equals("attack")) {//技能攻擊
                int skillAttackvalue=0;
                if (splitfunction[1].equals(playercatch.get(player.get(playernum).nowPokemon).attack1Name)) {
                    if(playercatch.get(player.get(playernum).nowPokemon).skill1>0){
                        playercatch.get(player.get(playernum).nowPokemon).skill1--;
                        skillAttackvalue=playercatch.get(player.get(playernum).nowPokemon).skill1;
                        attack.skillattackbyplayer(skillAttackvalue);
                        attack.AttackPrintInfo();//顯示玩家戰鬥資料
                        nowAttackPlayer=1;
                    }else{
                        System.out.println("技能 "+playercatch.get(player.get(playernum).nowPokemon).attack1Name+"已用盡\n請重新輸入");
                        System.out.println("----------------------------------------------------------");
                        continue; 
                    }
                    
                }else if(splitfunction[1].equals(playercatch.get(player.get(playernum).nowPokemon).attack2Name)){
                    if(playercatch.get(player.get(playernum).nowPokemon).skill2>0){
                        playercatch.get(player.get(playernum).nowPokemon).skill2--;
                        skillAttackvalue=playercatch.get(player.get(playernum).nowPokemon).skill2;
                        attack.skillattackbyplayer(skillAttackvalue);
                        attack.AttackPrintInfo();//顯示玩家戰鬥資料
                        nowAttackPlayer=1;
                        
                    }else{
                        System.out.println("技能 "+player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).attack2Name+"已用盡\n請重新輸入");
                        System.out.println("----------------------------------------------------------");
                        continue; 
                    }
                }else{
                    System.out.println("技能輸入錯誤");
                    System.out.println("----------------------------------------------------------");
                    continue; 
                }															
            
            } else if (function.equals("max elixir")) {//使用技能回復劑
                attack.maxelixir();
                nowAttackPlayer=1;

            } else if (function.equals("super potion")) {//使用好傷藥
                attack.superPotion();
                nowAttackPlayer=1;
            } else if (function.equals("run away")) {
                attack.runaway();
                nowAttackPlayer=1;
                break;
                
            } else if (splitfunction[0].equals("switch")) {
                attack.toswitch(Integer.parseInt(splitfunction[1]));
                attack.AttackPrintInfo();
                nowAttackPlayer=1;
            } else{
                System.out.println("輸入錯誤，請重新輸入");
                continue; 
            }

            if(nowAttackPlayer==1){
                if(nextRound==false){//是否增加回合數
                    nextRound=true;
                }else if(nextRound==true){
                    nextRound=false;
                    nowRound++;
                }
            }

        }System.out.println("----------------------------------------------------------");
        if(!(pokemontocatch.get(0).remainHealth==0)){
            System.out.println("失敗捕捉"+level+"級寶可夢"+PokemonName);
        }else{
            System.out.println("成功捕捉"+level+"級寶可夢"+PokemonName);
            player.get(playernum).addnewPokemon(PokemonName,level);
            player.get(playernum).addnewPitembycatch(PokemonName);
            
        }
        attack.dataRefresh();
        attack.PitemafterAttack();
        attack.resetroundexperience();
        hw5.printInfo(player.get(0).pokemon, player.get(1).pokemon, player);
    }
}
