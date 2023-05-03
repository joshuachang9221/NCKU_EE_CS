import java.util.*;
import java.io.*;

public class hw4 {

	public static void main(String[] args) {
		ArrayList<Player> player = new ArrayList<>();
		ArrayList<Pokemon> player1 = new ArrayList<>();
		ArrayList<Pokemon> player2 = new ArrayList<>();
		String[] record = new String[50];
		int player1num = 0;
		int player2num = 0;
		System.out.println("讓輸入編號來選擇 (1)新遊戲 或 (2)讀取存檔");
		String input = ConsoleIn.readLine();
		if (input.equals("1")) {
			System.out.println("您已選擇 （1）新遊戲");
			System.out.println("請輸入第一位 玩家名字 寶可夢名稱");
			String function = ConsoleIn.readLine();
			String splitfunction01[] = function.split(" ");
			player.add(new Player(splitfunction01[0]));
			if (splitfunction01[1].equals("Leafeon")) {
				player1.add(new Leafeon(1, "Leafeon"));
			} else if (splitfunction01[1].equals("Flareon")) {
				player1.add(new Flareon(1, "Flareon"));
			} else if (splitfunction01[1].equals("Vaporeon")) {
				player1.add(new Vaporeon(1, "Vaporeon"));
			} // 第一位玩家

			System.out.println("請輸入第二位 玩家名字 寶可夢名稱");
			function = ConsoleIn.readLine();
			String splitfunction02[] = function.split(" ");
			player.add(new Player(splitfunction02[0]));
			if (splitfunction02[1].equals("Leafeon")) {
				player2.add(new Leafeon(1, "Leafeon"));
			} else if (splitfunction02[1].equals("Flareon")) {
				player2.add(new Flareon(1, "Flareon"));
			} else if (splitfunction02[1].equals("Vaporeon")) {
				player2.add(new Vaporeon(1, "Vaporeon"));
			} else {
				System.out.println("錯誤，請輸入正確寶可夢名稱");
			} // 第二位玩家

		} else if (input.equals("2")) {
			System.out.println("您已選擇 （2）讀取存檔");
			int k = 0;
			try {
				Scanner reader = new Scanner(new File("record.txt"));
				while (reader.hasNext()) {
					record[k] = reader.next();
					k++;
				}
				record[k] = "";
				player.add(new Player(record[0]));
				boolean exe = true;
				int i = 1;
				while (exe) {// 第一位玩家
					if (!(record[i].equals("Leafeon") || record[i].equals("Flareon") || record[i].equals("Vaporeon"))) {
						exe = false;
						break;
					}
					if (record[i].equals("Leafeon")) {
						player1.add(new Leafeon(1, "Leafeon"));
						player1.get(player1num).level = Integer.parseInt(record[i + 1]);
						player1.get(player1num).remainHealth = Integer.parseInt(record[i + 2]);
						player1.get(player1num).skill1 = Integer.parseInt(record[i + 3]);
						player1.get(player1num).skill2 = Integer.parseInt(record[i + 4]);
					} else if (record[i].equals("Flareon")) {
						player1.add(new Leafeon(1, "Flareon"));
						player1.get(player1num).level = Integer.parseInt(record[i + 1]);
						player1.get(player1num).remainHealth = Integer.parseInt(record[i + 2]);
						player1.get(player1num).skill1 = Integer.parseInt(record[i + 3]);
						player1.get(player1num).skill2 = Integer.parseInt(record[i + 4]);
					} else if (record[i].equals("Vaporeon")) {
						player1.add(new Vaporeon(1, "Vaporeon"));
						player1.get(player1num).level = Integer.parseInt(record[i + 1]);
						player1.get(player1num).remainHealth = Integer.parseInt(record[i + 2]);
						player1.get(player1num).skill1 = Integer.parseInt(record[i + 3]);
						player1.get(player1num).skill2 = Integer.parseInt(record[i + 4]);
					}
					i += 5;
					player1num++;
				}
				exe = true;
				player.add(new Player(record[i]));
				i++;
				while (exe) {// 第二位玩家
					if (!(record[i].equals("Leafeon") || record[i].equals("Flareon") || record[i].equals("Vaporeon"))) {
						exe = false;
						break;
					}
					if (record[i].equals("Leafeon")) {
						player2.add(new Leafeon(1, "Leafeon"));
						player2.get(player2num).level = Integer.parseInt(record[i + 1]);
						player2.get(player2num).remainHealth = Integer.parseInt(record[i + 2]);
						player2.get(player2num).skill1 = Integer.parseInt(record[i + 3]);
						player2.get(player2num).skill2 = Integer.parseInt(record[i + 4]);
					} else if (record[i].equals("Flareon")) {
						player2.add(new Flareon(1, "Flareon"));
						player2.get(player2num).level = Integer.parseInt(record[i + 1]);
						player2.get(player2num).remainHealth = Integer.parseInt(record[i + 2]);
						player2.get(player2num).skill1 = Integer.parseInt(record[i + 3]);
						player2.get(player2num).skill2 = Integer.parseInt(record[i + 4]);
					} else if (record[i].equals("Vaporeon")) {
						player2.add(new Vaporeon(1, "Vaporeon"));
						player2.get(player2num).level = Integer.parseInt(record[i + 1]);
						player2.get(player2num).remainHealth = Integer.parseInt(record[i + 2]);
						player2.get(player2num).skill1 = Integer.parseInt(record[i + 3]);
						player2.get(player2num).skill2 = Integer.parseInt(record[i + 4]);
					}
					i += 5;
					player2num++;

				}
				System.out.println("資料載入成功!");
				System.out.println("----------------------------------------------------------");
			} catch (Exception e) {
				System.out.println("error\nrecord.txt不存在或文件格式錯誤\n程式結束");
			}
		} else {
			System.out.println("錯誤，請輸入整數(1 或 2)");
		}
		
		System.out.println(player.get(0).playername);
		for (int n = 0; n < player1.size(); n++) {
			System.out.println(player1.get(n).property + " " + player1.get(n).level + " " + player1.get(n).remainHealth
					+ " " + player1.get(n).skill1 + " " + player1.get(n).skill2);
		}
		System.out.println(player.get(1).playername);
		for (int n = 0; n < player2.size(); n++) {
			System.out.println(player1.get(n).property + " " + player2.get(n).level + " " + player2.get(n).remainHealth
					+ " " + player2.get(n).skill1 + " " + player2.get(n).skill2);
		}
		System.out.println("----------------------------------------------------------");
		System.out.println("資料建立完畢");
		boolean service = true;
		while (service) {
			System.out.println("請輸入編號選擇行動");
			System.out.println("(1)一般對戰  （2）捕捉  （3）前往回復站  （4）結束遊戲");
			String function = ConsoleIn.readLine();
			if (function.equals("1")) {// 一般對戰
				System.out.println("attack、super potion、run away、switch");
				function = ConsoleIn.readLine();
				String splitfunction[] = function.split(" ");
				int nowRound=1;
				int nowAttackPlayer=-1;
				player.get(0).nowPokemon=0;
				player.get(1).nowPokemon=0;
				if (player1.get(player.get(0).nowPokemon).speed >= player2.get(player.get(1).nowPokemon).speed) {
					nowAttackPlayer=1;//p1
				}else if (player1.get(player.get(0).nowPokemon).speed < player2.get(player.get(1).nowPokemon).speed) {
					nowAttackPlayer=2;//p2
				}//由速度較快的寶可夢先出來

				boolean attackExe=true;
				while(attackExe){
					if(nowAttackPlayer==1){//由玩家一號先進攻
						System.out.println("目前出戰玩家:"+player.get(0).playername+"\n"+"回合數:"+nowRound);
						if (function.equals("attack")) {
							//player.get(nowAttackPlayer-1).nowAttackPower=player1.get(player.get(nowAttackPlayer-1).nowPokemon).attack;
							Attack attack= new Attack(player1.get(player.get(0).nowPokemon).property,player2.get(player.get(0).nowPokemon).property);
							int causelife=(int)((player1.get(player.get(0).nowPokemon).attack+player1.get(player.get(0).nowPokemon).normalAttack)*attack.p2);//造成傷害
							for(int i=0;i<=player1.size();i++){
								while(causelife>0){					
									while(player1.get(i).remainHealth>0){
										player1.get(i).remainHealth--;
										causelife--;
										player1.get(i).totalcauselife++;
									}
								}
							}
							for(int i=0;i<=player1.size();i++){
								if(player2.get(i).remainHealth==0){
									
								}else{
									break;									
								}
							}
						}else if (splitfunction[0].equals("attack")) {
								if (splitfunction[1].equals(player1.get(player.get(0).nowPokemon).attack1Name)) {
									//player.get(0).nowAttackPower=player1.get(player.get(nowAttackPlayer-1).nowPokemon).Attack1;
									Attack attack= new Attack(player1.get(player.get(0).nowPokemon).property,player2.get(player.get(0).nowPokemon).property);
									int causelife=(int)((player1.get(player.get(0).nowPokemon).attack+player1.get(player.get(0).nowPokemon).Attack1)*attack.p2);//造成傷害
			
								}else if(splitfunction[1].equals(player1.get(player.get(0).nowPokemon).attack2Name)){
									//player.get(0).nowAttackPower=player1.get(player.get(nowAttackPlayer-1).nowPokemon).Attack2;
									Attack attack= new Attack(player1.get(player.get(0).nowPokemon).property,player2.get(player.get(0).nowPokemon).property);
									int causelife=(int)((player1.get(player.get(0).nowPokemon).attack+player1.get(player.get(0).nowPokemon).Attack1)*attack.p2);//造成傷害
									}else{
										System.out.println("技能輸入錯誤");
									}
																		
						} else if (function.equals("super potion")) {
					
						} else if (function.equals("run away")) {
										
						} else if (splitfunction[0].equals("switch")) {
					
						}
					}				
				}
									
		
								
			}else if (function.equals("2")) {// 捕捉
				System.out.println("指令為 [玩家名字] [寶可夢名稱] [等級]");
				function = ConsoleIn.readLine();
				String splitfunction[] = function.split(" ");
				if (splitfunction[0].equals(player.get(0).playername)) {
					if (player1.size() == 3) {
						System.out.println("背包已滿，請重新輸入");
						System.out.println("----------------------------------------------------------");
					} else {

					}
				} else if (splitfunction[0].equals(player.get(1).playername)) {
					if (player2.size() == 3) {
						System.out.println("背包已滿，請重新輸入");
						System.out.println("----------------------------------------------------------");
					}
				} else {
					System.out.println("資料輸入錯誤，請重新輸入");
					System.out.println("----------------------------------------------------------");
				}

			} else if (function.equals("3")) {// 前往回復站
				boolean p1resume = false;
				boolean p2resume = false;
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
					System.out.println("----------------------------------------------------------");
					System.out.println(player.get(0).playername);
					for (int n = 0; n < player1.size(); n++) {
						System.out.println(
								player1.get(n).property + " " + player1.get(n).level + " " + player1.get(n).remainHealth
										+ " " + player1.get(n).skill1 + " " + player1.get(n).skill2);
					}
					System.out.println(player.get(1).playername);
					for (int n = 0; n < player2.size(); n++) {
						System.out.println(
								player1.get(n).property + " " + player2.get(n).level + " " + player2.get(n).remainHealth
										+ " " + player2.get(n).skill1 + " " + player2.get(n).skill2);
					}
					System.out.println("----------------------------------------------------------");
					System.out.println("前往回復站成功");

				}
			} else if (function.equals("4")) {// 結束遊戲
				try {
					PrintWriter writer = new PrintWriter(new File("record.txt"));
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
				} catch (Exception e) {

				}
				System.out.println("遊戲結束\n資料已回傳至 record.txt");
				service = false;
			} else {
				System.out.println("資料輸入錯誤，請重新輸入");
				System.out.println("----------------------------------------------------------");
			}
		}

	}
}