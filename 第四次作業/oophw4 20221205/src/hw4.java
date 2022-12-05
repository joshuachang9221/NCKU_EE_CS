import java.util.*;
import java.io.*;

public class hw4 {
	public static int nowAttackPlayer=-1;//目前攻擊玩家
	public static boolean exchangePlayer;//是否更換攻擊方
	public static void main(String[] args) {
		ArrayList<Player> player = new ArrayList<>();//儲存玩家基本資料
		ArrayList<Pokemon> player1 = new ArrayList<>();//儲存玩家一寶可夢基本資料
		ArrayList<Pokemon> player2 = new ArrayList<>();//儲存玩家二寶可夢基本資料
		String[] record = new String[50];//儲存record.txt全部資料
		System.out.println("讓輸入編號來選擇 (1)新遊戲 或 (2)讀取存檔");
		String input = ConsoleIn.readLine();
		int player1num = 0;
		int player2num = 0;
		if (input.equals("1")) {//（1）新遊戲
			System.out.println("您已選擇 （1）新遊戲");
			System.out.println("請輸入第一位 玩家名字 寶可夢名稱");
			String function = ConsoleIn.readLine();
			String splitfunction01[] = function.split(" ");
			player.add(new Player(splitfunction01[0]));
			if (splitfunction01[1].equals("Leafeon")) {
				player1.add(new Leafeon(1));
			} else if (splitfunction01[1].equals("Flareon")) {
				player1.add(new Flareon(1));
			} else if (splitfunction01[1].equals("Vaporeon")) {
				player1.add(new Vaporeon(1));
			} // 第一位玩家

			System.out.println("請輸入第二位 玩家名字 寶可夢名稱");
			function = ConsoleIn.readLine();
			String splitfunction02[] = function.split(" ");
			player.add(new Player(splitfunction02[0]));
			if (splitfunction02[1].equals("Leafeon")) {
				player2.add(new Leafeon(1));
			} else if (splitfunction02[1].equals("Flareon")) {
				player2.add(new Flareon(1));
			} else if (splitfunction02[1].equals("Vaporeon")) {
				player2.add(new Vaporeon(1));
			} else {
				System.out.println("錯誤，請輸入正確寶可夢名稱");
			} // 第二位玩家

		} else if (input.equals("2")) {//（2）讀取存檔
			System.out.println("您已選擇 （2）讀取存檔");
			int k = 0;
			try {
				Scanner reader = new Scanner(new File("record.txt"));//從record.txt讀取資料
				while (reader.hasNext()) {
					record[k] = reader.next();
					k++;
				}
				record[k] = "";
				player.add(new Player(record[0]));//新增玩家一
				boolean exe = true;
				int i = 1;
				while (exe) {// 第一位玩家
					if (!(record[i].equals("Leafeon") || record[i].equals("Flareon") || record[i].equals("Vaporeon"))) {
						exe = false;
						break;
					}//玩家一新增程序結束
					if (record[i].equals("Leafeon")) {
						player1.add(new Leafeon(Integer.parseInt(record[i + 1])));
						player1.get(player1num).remainHealth = Integer.parseInt(record[i + 2]);
						player1.get(player1num).skill1 = Integer.parseInt(record[i + 3]);
						player1.get(player1num).skill2 = Integer.parseInt(record[i + 4]);
					} else if (record[i].equals("Flareon")) {
						player1.add(new Flareon(Integer.parseInt(record[i + 1])));
						player1.get(player1num).remainHealth = Integer.parseInt(record[i + 2]);
						player1.get(player1num).skill1 = Integer.parseInt(record[i + 3]);
						player1.get(player1num).skill2 = Integer.parseInt(record[i + 4]);
					} else if (record[i].equals("Vaporeon")) {
						player1.add(new Vaporeon(Integer.parseInt(record[i + 1])));
						player1.get(player1num).remainHealth = Integer.parseInt(record[i + 2]);
						player1.get(player1num).skill1 = Integer.parseInt(record[i + 3]);
						player1.get(player1num).skill2 = Integer.parseInt(record[i + 4]);
					}
					i += 5;
					player1num++;
				}
				exe = true;
				player.add(new Player(record[i]));//新增玩家二
				i++;
				while (exe) {// 第二位玩家
					if (!(record[i].equals("Leafeon") || record[i].equals("Flareon") || record[i].equals("Vaporeon"))) {
						exe = false;
						break;
					}//玩家二新增程序結束
					if (record[i].equals("Leafeon")) {
						player2.add(new Leafeon(Integer.parseInt(record[i + 1])));
						player2.get(player2num).remainHealth = Integer.parseInt(record[i + 2]);
						player2.get(player2num).skill1 = Integer.parseInt(record[i + 3]);
						player2.get(player2num).skill2 = Integer.parseInt(record[i + 4]);
					} else if (record[i].equals("Flareon")) {
						player2.add(new Flareon(Integer.parseInt(record[i + 1])));
						player2.get(player2num).remainHealth = Integer.parseInt(record[i + 2]);
						player2.get(player2num).skill1 = Integer.parseInt(record[i + 3]);
						player2.get(player2num).skill2 = Integer.parseInt(record[i + 4]);
					} else if (record[i].equals("Vaporeon")) {
						player2.add(new Vaporeon(Integer.parseInt(record[i + 1])));
						player2.get(player2num).remainHealth = Integer.parseInt(record[i + 2]);
						player2.get(player2num).skill1 = Integer.parseInt(record[i + 3]);
						player2.get(player2num).skill2 = Integer.parseInt(record[i + 4]);
					}
					i += 5;
					player2num++;

				}
				System.out.println("資料載入成功!");
			} catch (Exception e) {
				System.out.println("error\nrecord.txt不存在或文件格式錯誤\n程式結束");
			}
		} else {
			System.out.println("錯誤，請輸入整數(1 或 2)");
			System.out.println("程式結束");
		}		
		printInfo(player1, player2,player);
		System.out.println("資料建立完畢");
		boolean service = true;
		while (service) {
			System.out.println("請輸入編號選擇行動");
			System.out.println("(1)一般對戰  （2）捕捉  （3）前往回復站  （4）結束遊戲");
			String function = ConsoleIn.readLine();
			int nowRound=1;
			nowAttackPlayer=-1;
			player.get(0).nowPokemon=0;
			player.get(1).nowPokemon=0;
			Attack attack=new Attack(player1,player2,player);
			if (function.equals("1")) {// 一般對戰
				player.get(0).superPotion=2;
				player.get(1).superPotion=2;
				boolean attackExe=true;//是否繼續攻擊
				boolean nextRound=false;//是否增加下一回合
				attack.FirstAttack();//首次攻擊建置資料
				while(attackExe){
					if(attack.StopAttack()==true){
						break;
					}//停止攻擊
					
					System.out.println("回合數:"+nowRound);	
					System.out.println("----------------------------------------------------------");
					System.out.println("正在進行一般對戰");
					System.out.println("請輸入[attack]、[attack] [技能名稱]、[super] [potion]、[run] [away]、[switch] [寶可夢編號]");
					function = ConsoleIn.readLine();
					String splitfunction[] = function.split(" ");
					if (function.equals("attack")){//一般攻擊
						if(nowAttackPlayer==0){
							attack.normalattack(0,1,player1,player2);
							attack.pokemonSelect(0,1,player1,player2);
							
						}else if(nowAttackPlayer==1){
							attack.normalattack(1,0,player2,player1);
							attack.pokemonSelect(1,0,player2,player1);
							
						}

						attack.AttackPrintInfo();//顯示玩家戰鬥資料

						if(nowAttackPlayer==0){//切換攻擊玩家
							nowAttackPlayer=1;
							System.out.println("玩家二 "+ player.get(1).playername+" 為攻擊者 ");

						}else if(nowAttackPlayer==1){
							nowAttackPlayer=0;
							System.out.println("玩家一 "+ player.get(0).playername+" 為攻擊者 ");
						}

						if(nextRound==false){//是否增加回合數
							nextRound=true;
						}else if(nextRound==true){
							nextRound=false;
							nowRound++;
						}
						

					} else if (splitfunction[0].equals("attack")) {//技能攻擊
						int skillAttackvalue=0;

						
						if(nowAttackPlayer==0){//目前玩家為1
							if (splitfunction[1].equals(player1.get(player.get(0).nowPokemon).attack1Name)) {//玩家1技能攻擊1
								if(player1.get(player.get(0).nowPokemon).skill1>0){
									player1.get(player.get(0).nowPokemon).skill1--;
									skillAttackvalue=player1.get(player.get(0).nowPokemon).skill1;
									attack.skillattack(0,1,player1,player2,skillAttackvalue);
									attack.pokemonSelect(0,1,player1,player2);
								
								}else{
									System.out.println("技能 "+player1.get(player.get(0).nowPokemon).attack1Name+"已用盡\n請重新輸入");
									System.out.println("----------------------------------------------------------");
									break;
								}
								
							}else if(splitfunction[1].equals(player1.get(player.get(0).nowPokemon).attack2Name)){//玩家1技能攻擊2
								if(player1.get(player.get(0).nowPokemon).skill2>0){
									player1.get(player.get(0).nowPokemon).skill2--;
									skillAttackvalue=player1.get(player.get(0).nowPokemon).skill2;
									attack.skillattack(0,1,player1,player2,skillAttackvalue);
									attack.pokemonSelect(0,1,player1,player2);

									
								}else{
									System.out.println("技能 "+player1.get(player.get(0).nowPokemon).attack2Name+"已用盡\n請重新輸入");
									System.out.println("----------------------------------------------------------");
									break;
								}
							}else{
								System.out.println("技能輸入錯誤");
								System.out.println("----------------------------------------------------------");
							}															
						}else if(nowAttackPlayer==1){//目前玩家為2
							if (splitfunction[1].equals(player2.get(player.get(1).nowPokemon).attack1Name)) {//玩家2技能攻擊1
								if(player2.get(player.get(1).nowPokemon).skill1>0){
									player2.get(player.get(1).nowPokemon).skill1--;
									skillAttackvalue=player2.get(player.get(1).nowPokemon).skill1;
									attack.skillattack(1,0,player2,player1,skillAttackvalue);
									attack.pokemonSelect(1,0,player2,player1);

								}else{
									System.out.println("技能 "+player2.get(player.get(1).nowPokemon).attack1Name+"已用盡\n請重新輸入");
									System.out.println("----------------------------------------------------------");
								}
							}else if(splitfunction[1].equals(player2.get(player.get(1).nowPokemon).attack2Name)){//玩家2技能攻擊2
								if(player2.get(player.get(1).nowPokemon).skill2>0){
									player2.get(player.get(1).nowPokemon).skill2--;
									skillAttackvalue=player2.get(player.get(1).nowPokemon).skill2;
									attack.skillattack(1,0,player2,player1,skillAttackvalue);
									attack.pokemonSelect(1,0,player2,player1);

								}else{
									System.out.println("技能 "+player2.get(player.get(1).nowPokemon).attack1Name+"已用盡\n請重新輸入");
									System.out.println("----------------------------------------------------------");
								}
							}else{
									System.out.println("技能輸入錯誤");
									System.out.println("----------------------------------------------------------");
							}
						}
						
						if(!(skillAttackvalue==0)){//切換玩家
							if(nowAttackPlayer==0){
								nowAttackPlayer=1;
								System.out.println("玩家二 "+ player.get(1).playername+" 為攻擊者 ");

							}else if(nowAttackPlayer==1){
								nowAttackPlayer=0;
								System.out.println("玩家一 "+ player.get(0).playername+" 為攻擊者 ");
							}
							if(nextRound==false){//是否增加回合數
								nextRound=true;
							}else if(nextRound==true){
								nextRound=false;
								nowRound++;
							}
							attack.AttackPrintInfo();//顯示戰鬥結果
						}
						
							
					} else if (function.equals("super potion")) {//使用好傷藥
						//superPotion(ArrayList<Pokemon> playernum,String pokemonnum,ArrayList<Player> player, int nowAttackPlayer,ArrayList<Pokemon> player1,ArrayList<Pokemon> player2)
						if(nowAttackPlayer==0){//玩家一使用好傷藥
							attack.superPotion(player1,nowAttackPlayer);
						}else if(nowAttackPlayer==1){//玩家二使用好傷藥
							attack.superPotion(player2,nowAttackPlayer);
						}
					} else if (function.equals("run away")) {
						if(nowAttackPlayer==0){//玩家一逃跑
							attack.runaway( player1,0);
							attack.AfterAttackPrintInfo(player.get(1).playername,player.get(0).playername,player1);
							attack.dataRefresh();
							

						}else if(nowAttackPlayer==1){//玩家二逃跑
							attack.runaway( player2,1);
							attack.AfterAttackPrintInfo(player.get(0).playername,player.get(1).playername,player2);
							attack.dataRefresh();
						}
						break;
					} else if (splitfunction[0].equals("switch")) {
						if(nowAttackPlayer==0){//玩家一切換寶可夢
							attack.toswitch(player1,splitfunction[1],0);
						}else if(nowAttackPlayer==1){//玩家二切換寶可夢
							attack.toswitch(player2,splitfunction[1],1);
						}
						
					} else{
						System.out.println("輸入錯誤，請重新輸入");
					}

				}				
			
									
		
								
			}else if (function.equals("2")) {// 捕捉
				if(player1.size() == 3 && player2.size() == 3){
					System.out.println("所有玩家背包已滿，請重新輸入");
				}else{
					System.out.println("----------------------------------------------------------");
					System.out.println("指令為 [玩家名字] [寶可夢名稱] [等級]");
					function = ConsoleIn.readLine();
					String splitfunction[] = function.split(" ");
					if (splitfunction[0].equals(player.get(0).playername)) {//玩家一捕捉寶可夢
						if (player1.size() == 3) {
							System.out.println("背包已滿，請重新輸入");
							System.out.println("----------------------------------------------------------");
						} else {
							CatchNewPokemon catcchnewpokemon = new CatchNewPokemon(player1,player2,player);
							catcchnewpokemon.catchPokemon(player1,splitfunction[1],Integer.parseInt(splitfunction[2]),0);
							
						}
					} else if (splitfunction[0].equals(player.get(1).playername)) {//玩家二捕捉寶可夢
						if (player2.size() == 3) {
							System.out.println("背包已滿，請重新輸入");
							System.out.println("----------------------------------------------------------");
						} else{
							CatchNewPokemon catcchnewpokemon = new CatchNewPokemon(player1,player2,player);
							catcchnewpokemon.catchPokemon(player2,splitfunction[1],Integer.parseInt(splitfunction[2]),1);
						}
					} else {
						System.out.println("玩家名字輸入錯誤，請重新輸入");
						System.out.println("----------------------------------------------------------");
					}
				}
				
				
				


			} else if (function.equals("3")) {// 前往回復站
				boolean p1resume = false;//玩家一寶可夢是否狀態全滿
				boolean p2resume = false;//玩家二寶可夢是否狀態全滿
				for (int n = 0; n < player1.size(); n++) {
					if (player1.get(n).resumeOrNot() == true) {
						p1resume = true;
						break;
					}
				}
				for (int n = 0; n < player2.size(); n++) {
					if (player2.get(n).resumeOrNot() == true) {
						p2resume = true;
						break;
					}
				}

				if (p1resume == false && p2resume == false) {
					System.out.println("寶可夢狀態全滿，請重新輸入");
					System.out.println("----------------------------------------------------------");
				} else {
					for (int n = 0; n < player1.size(); n++) {
						player1.get(n).resume();
					}
					for (int n = 0; n < player2.size(); n++) {
						player2.get(n).resume();
					}
					printInfo(player1, player2,player);
					System.out.println("前往回復站成功");

				}
			} else if (function.equals("4")) {// 結束遊戲
				try {
					PrintWriter writer = new PrintWriter(new File("record.txt"));//回傳資料至record.txt
					writer.println(player.get(0).playername);
					for (int n = 0; n < player1.size(); n++) {
						writer.println(
								player1.get(n).property + " " + player1.get(n).level + " " + player1.get(n).remainHealth
										+ " " + player1.get(n).skill1 + " " + player1.get(n).skill2);
					}
					writer.println(player.get(1).playername);
					for (int n = 0; n < player2.size(); n++) {
						writer.println(
								player1.get(n).property + " " + player2.get(n).level + " " + player2.get(n).remainHealth+ " " + player2.get(n).skill1 + " " + player2.get(n).skill2);
					}
					writer.flush();
					System.out.println("遊戲結束\n資料已回傳至 record.txt");
				} catch (Exception e) {

				}
				service = false;
			} else {
				System.out.println("資料輸入錯誤，請重新輸入");
				System.out.println("----------------------------------------------------------");
			}
		}

	}
	protected static void printInfo(ArrayList<Pokemon> player1,ArrayList<Pokemon> player2,ArrayList<Player> player){
		System.out.println("----------------------------------------------------------");
		System.out.println("第一位玩家姓名:  "+player.get(0).playername);
		System.out.println("  寶可夢名稱  等級  剩餘生命  技能一  技能二  經驗值");
		for (int n = 0; n < player1.size(); n++) {
			System.out.println((n+1)+"  "+player1.get(n).property + "    " + player1.get(n).level + "      " + player1.get(n).remainHealth
					+ "    (" + player1.get(n).skill1 + "/5)    (" + player1.get(n).skill2+"/5)   " +player1.get(n).totalexperience);
		}
		
		System.out.println("\n第二位玩家姓名:  "+player.get(1).playername);
		System.out.println("  寶可夢名稱  等級  剩餘生命  技能一  技能二  經驗值");
		for (int n = 0; n < player2.size(); n++) {
			System.out.println((n+1)+"  "+player2.get(n).property + "    " + player2.get(n).level + "      " + player2.get(n).remainHealth
					+ "    (" + player2.get(n).skill1 + "/5)    (" + player2.get(n).skill2+"/5)   "+player2.get(n).totalexperience);
		}
		System.out.println("----------------------------------------------------------");
	}


	
}



