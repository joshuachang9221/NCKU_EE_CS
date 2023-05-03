import java.util.*;
import java.io.*;
public class hw5 {
	public static int nowAttackPlayer=-1;//目前攻擊玩家
	public static boolean exchangePlayer;//是否更換攻擊方
	public static void main(String[] args) {
		ArrayList<Player> player = new ArrayList<>();//儲存玩家基本資料
		System.out.println("讓輸入編號來選擇 (1)新遊戲 或 (2)讀取存檔");
		String input = ConsoleIn.readLine();
		if (input.equals("1")) {//（1）新遊戲
			System.out.println("您已選擇 （1）新遊戲");
			System.out.println("請輸入第一位 玩家名字 寶可夢名稱");
			String function = ConsoleIn.readLine();
			String splitfunction[] = function.split(" ");
			player.add(new Player(splitfunction[0]));
			player.get(0).addnewPokemon(splitfunction[1],1);
			// 第一位玩家
			System.out.println("請輸入第二位 玩家名字 寶可夢名稱");
			function = ConsoleIn.readLine();
			String splitfunction02[] = function.split(" ");
			player.add(new Player(splitfunction02[0]));
			player.get(1).addnewPokemon(splitfunction[1],1); 
			// 第二位玩家
			
		} else if (input.equals("2")) {//（2）讀取存檔
			String[] record = new String[20];//儲存record.txt全部資料
			System.out.println("您已選擇 （2）讀取存檔");
			int k = 0;
			for(int i=0;i<=19;i++){
				record[i]="";
			}
			try {			
				Scanner reader = new Scanner(new File("record.txt"));//從record.txt讀取資料
				while (reader.hasNextLine()) {
					record[k] = reader.nextLine();
					k++;
				}							
			} catch (Exception e) {
				System.out.println("error\nrecord.txt不存在或文件格式錯誤\n程式結束");
			}
			player.add(new Player(record[0]));//新增玩家一
			boolean exe = true;
			int line=1;
			int playerpitemline=0;
			System.out.println("----------------------------------------------------------");
			System.out.println("寶可夢道具裝備中");
			System.out.println("----------------------------------------------------------");
			while (exe) {// 第一位玩家
				String[] temp = record[line].split(" ");
				line++;
				if(playerpitemline==3){
					break;
				}else if(temp.length==6){
					player.get(0).addnewPokemon(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),Integer.parseInt(temp[5]));
				}else if(temp.length==7){
					player.get(0).addnewPokemon(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),Integer.parseInt(temp[5]),temp[6]);
				}else if(temp[0].equals("")){
					player.get(0).PlayerPitem.add(null);
					playerpitemline++;
				}else if(temp.length==1){
					if(Management.pitemOrNot(temp[0])==true){
						player.get(0).addPitem(temp[0]);
						playerpitemline++;
					}else{
						break;
					}
				}else{
					System.out.println("error");
				}
			}
			player.add(new Player(record[line-1]));//新增玩家二
			exe = true;
			playerpitemline=0;
			while (exe) {// 第一位玩家
				String[] temp = record[line].split(" ");
				line++;
				if(playerpitemline==3){
					break;
				}else if(temp.length==6){
					player.get(1).addnewPokemon(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),Integer.parseInt(temp[5]));
				}else if(temp.length==7){
					player.get(1).addnewPokemon(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),Integer.parseInt(temp[5]),temp[6]);
				}else if(temp[0].equals("")){
					player.get(1).PlayerPitem.add(null);
					playerpitemline++;
				}else if(temp.length==1){
					if(Management.pitemOrNot(temp[0])==true){
						player.get(1).addPitem(temp[0]);
						playerpitemline++;
					}else{
						break;
					}
				}else{
					System.out.println("error");
				}
			}
			System.out.println("玩家資料載入成功!");
		}else {
			System.out.println("錯誤，請輸入整數(1 或 2)");
			System.out.println("程式結束");
		}		
		player.get(0).checkError();
		player.get(1).checkError();
		printInfo(player.get(0).pokemonArraylist() , player.get(1).pokemonArraylist(),player);
		System.out.println("資料建立完畢");
		boolean service = true;
		while (service) {
			System.out.println("請輸入編號選擇行動");
			System.out.println("(1)一般對戰  （2）捕捉  （3）前往回復站  （4）顯示遊戲狀態  （5）裝備/卸除道具  （6）更改順序  （7）結束遊戲");
			String function = ConsoleIn.readLine();
			int nowRound=1;
			nowAttackPlayer=-1;
			player.get(0).nowPokemon=0;
			player.get(1).nowPokemon=0;
			
			Attack attack=new Attack(player.get(0).pokemonArraylist(),player.get(1).pokemonArraylist(),player);
			if (function.equals("1")) {// 一般對戰
				player.get(0).superPotion=2;
				player.get(1).superPotion=2;
				player.get(0).maxelixir=2;
				player.get(1).maxelixir=2;
				boolean attackExe=true;//是否繼續攻擊
				boolean nextRound=false;//是否增加下一回合
				attack.FirstAttack();//首次攻擊建置資料
				while(attackExe){
					if(attack.StopAttack()==true){
						attack.dataRefresh();
						break;
					}//停止攻擊
					
					System.out.println("回合數:"+nowRound);	
					System.out.println("----------------------------------------------------------");
					System.out.println("正在進行一般對戰");
					System.out.println("請輸入[attack]、[attack] [技能名稱]、[super] [potion]、[max][elixir]、[run] [away]、[switch] [寶可夢編號]");
					function = ConsoleIn.readLine();
					String splitfunction[] = function.split(" ");
					if (function.equals("attack")){//一般攻擊
						if(nowAttackPlayer==0){
							attack.normalattack(0,1,player.get(0).pokemonArraylist(),player.get(1).pokemonArraylist());
							attack.pokemonSelect(0,1,player.get(0).pokemonArraylist(),player.get(1).pokemonArraylist());
							
						}else if(nowAttackPlayer==1){
							attack.normalattack(1,0,player.get(1).pokemonArraylist(),player.get(0).pokemonArraylist());
							attack.pokemonSelect(1,0,player.get(1).pokemonArraylist(),player.get(0).pokemonArraylist());
							
						}

						attack.AttackPrintInfo();//顯示玩家戰鬥資料

						
						

					} else if (splitfunction[0].equals("attack")) {//技能攻擊
						int skillAttackvalue=0;
						if(nowAttackPlayer==0){//目前玩家為1
							if (splitfunction[1].equals(player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).attack1Name)) {//玩家1技能攻擊1
								if(player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).skill1>0){
									player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).skill1--;
									skillAttackvalue=player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).skill1;
									attack.skillattack(0,1,player.get(0).pokemonArraylist(),player.get(1).pokemonArraylist(),skillAttackvalue);
									attack.pokemonSelect(0,1,player.get(0).pokemonArraylist(),player.get(1).pokemonArraylist());
									attack.AttackPrintInfo();
								}else{
									System.out.println("技能 "+player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).attack1Name+"已用盡\n請重新輸入");
									System.out.println("----------------------------------------------------------");
									continue; 
								}
								
							}else if(splitfunction[1].equals(player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).attack2Name)){//玩家1技能攻擊2
								if(player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).skill2>0){
									player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).skill2--;
									skillAttackvalue=player.get(0).pokemonArraylist().get(player.get(0).nowPokemon).skill2;
									attack.skillattack(0,1,player.get(0).pokemonArraylist(),player.get(1).pokemonArraylist(),skillAttackvalue);
									attack.pokemonSelect(0,1,player.get(0).pokemonArraylist(),player.get(1).pokemonArraylist());
									attack.AttackPrintInfo();
									
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
						}else if(nowAttackPlayer==1){//目前玩家為2
							if (splitfunction[1].equals(player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).attack1Name)) {//玩家2技能攻擊1
								if(player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).skill1>0){
									player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).skill1--;
									skillAttackvalue=player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).skill1;
									attack.skillattack(1,0,player.get(1).pokemonArraylist(),player.get(0).pokemonArraylist(),skillAttackvalue);
									attack.pokemonSelect(1,0,player.get(1).pokemonArraylist(),player.get(0).pokemonArraylist());
									attack.AttackPrintInfo();
								}else{
									System.out.println("技能 "+player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).attack1Name+"已用盡\n請重新輸入");
									System.out.println("----------------------------------------------------------");
									continue; 
								}
							}else if(splitfunction[1].equals(player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).attack2Name)){//玩家2技能攻擊2
								if(player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).skill2>0){
									player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).skill2--;
									skillAttackvalue=player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).skill2;
									attack.skillattack(1,0,player.get(1).pokemonArraylist(),player.get(0).pokemonArraylist(),skillAttackvalue);
									attack.pokemonSelect(1,0,player.get(1).pokemonArraylist(),player.get(0).pokemonArraylist());
									attack.AttackPrintInfo();
								}else{
									System.out.println("技能 "+player.get(1).pokemonArraylist().get(player.get(1).nowPokemon).attack1Name+"已用盡\n請重新輸入");
									System.out.println("----------------------------------------------------------");
									continue; 
								}

							}else{
									System.out.println("技能輸入錯誤");
									
									System.out.println("----------------------------------------------------------");
									continue; 
							}
						}
						
						if(!(skillAttackvalue==0)){//切換玩家
							attack.AttackPrintInfo();//顯示戰鬥結果
						}else{
							continue;
						}
						
					} else if (function.equals("max elixir")) {
						//superPotion(ArrayList<Pokemon> playernum,String pokemonnum,ArrayList<Player> player, int nowAttackPlayer,ArrayList<Pokemon> player.get(0).pokemonArraylist(),ArrayList<Pokemon> player.get(1).pokemonArraylist())
						if(nowAttackPlayer==0){//玩家一使用好傷藥
							attack.maxelixir(player.get(0).pokemonArraylist(),nowAttackPlayer);
							attack.AttackPrintInfo();
						}else if(nowAttackPlayer==1){//玩家二使用好傷藥
							attack.maxelixir(player.get(1).pokemonArraylist(),nowAttackPlayer);
							attack.AttackPrintInfo();
						}
					} else if (function.equals("super potion")) {//使用好傷藥
						//superPotion(ArrayList<Pokemon> playernum,String pokemonnum,ArrayList<Player> player, int nowAttackPlayer,ArrayList<Pokemon> player.get(0).pokemonArraylist(),ArrayList<Pokemon> player.get(1).pokemonArraylist())
						if(nowAttackPlayer==0){//玩家一使用好傷藥
							attack.superPotion(player.get(0).pokemonArraylist(),nowAttackPlayer);
							attack.AttackPrintInfo();
						}else if(nowAttackPlayer==1){//玩家二使用好傷藥
							attack.superPotion(player.get(1).pokemonArraylist(),nowAttackPlayer);
							attack.AttackPrintInfo();
						}
					} else if (function.equals("run away")) {
						if(nowAttackPlayer==0){//玩家一逃跑
							attack.runaway( player.get(0).pokemonArraylist(),0);
							attack.AfterAttackPrintInfo(player.get(1).playername,player.get(0).playername,player.get(0).pokemonArraylist());
							attack.dataRefresh();
							break;

						}else if(nowAttackPlayer==1){//玩家二逃跑
							attack.runaway( player.get(1).pokemonArraylist(),1);
							attack.AfterAttackPrintInfo(player.get(0).playername,player.get(1).playername,player.get(1).pokemonArraylist());
							attack.dataRefresh();
							break;
						}
					} else if (splitfunction[0].equals("switch")) {
						if(nowAttackPlayer==0){//玩家一切換寶可夢
							attack.toswitch(player.get(0).pokemonArraylist(),splitfunction[1],0);
						}else if(nowAttackPlayer==1){//玩家二切換寶可夢
							attack.toswitch(player.get(1).pokemonArraylist(),splitfunction[1],1);
						}
						
					} else{
						System.out.println("輸入錯誤，請重新輸入");
						continue; 
					}

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

				}				
			
									
		
								
			}else if (function.equals("2")) {// 捕捉
				if(player.get(0).pokemonArraylist().size() == 4 && player.get(1).pokemonArraylist().size() == 4){
					System.out.println("所有玩家背包已滿，請重新輸入");
				}else{
					System.out.println("----------------------------------------------------------");
					System.out.println("指令為 [玩家名字] [寶可夢名稱] [等級]");
					function = ConsoleIn.readLine();
					String splitfunction[] = function.split(" ");
					if (splitfunction[0].equals(player.get(0).playername)) {//玩家一捕捉寶可夢
						if (player.get(0).pokemonArraylist().size() == 4) {
							System.out.println("背包已滿，請重新輸入");
							System.out.println("----------------------------------------------------------");
						} else {
							
							CatchNewPokemon catchNewPokemon= new CatchNewPokemon(player.get(0).pokemonArraylist(),player,0);  
							catchNewPokemon.initiallizecatchPokemon(splitfunction[1],Integer.parseInt(splitfunction[2]));
							catchNewPokemon.catchexe();
						}
					} else if (splitfunction[0].equals(player.get(1).playername)) {//玩家二捕捉寶可夢
						if (player.get(1).pokemonArraylist().size() == 4) {
							System.out.println("背包已滿，請重新輸入");
							System.out.println("----------------------------------------------------------");
						}else{ 
							CatchNewPokemon catchNewPokemon= new CatchNewPokemon(player.get(1).pokemonArraylist(),player,1);  
							catchNewPokemon.initiallizecatchPokemon(splitfunction[1],Integer.parseInt(splitfunction[2]));
							catchNewPokemon.catchexe();
						}
					} else {
						System.out.println("玩家名字輸入錯誤，請重新輸入");
						System.out.println("----------------------------------------------------------");
					}
				}
				
				
				


			} else if (function.equals("3")) {// 前往回復站
				boolean p1resume = false;//玩家一寶可夢是否狀態全滿
				boolean p2resume = false;//玩家二寶可夢是否狀態全滿
				for (int n = 0; n < player.get(0).pokemonArraylist().size(); n++) {
					if (player.get(0).pokemonArraylist().get(n).resumeOrNot() == true) {
						p1resume = true;
						break;
					}
				}
				for (int n = 0; n < player.get(1).pokemonArraylist().size(); n++) {
					if (player.get(1).pokemonArraylist().get(n).resumeOrNot() == true) {
						p2resume = true;
						break;
					}
				}

				if (p1resume == false && p2resume == false) {
					System.out.println("寶可夢狀態全滿，請重新輸入");
					System.out.println("----------------------------------------------------------");
				} else {
					for (int n = 0; n < player.get(0).pokemonArraylist().size(); n++) {
						player.get(0).pokemonArraylist().get(n).resume();
					}
					for (int n = 0; n < player.get(1).pokemonArraylist().size(); n++) {
						player.get(1).pokemonArraylist().get(n).resume();
					}
					printInfo(player.get(0).pokemonArraylist(), player.get(1).pokemonArraylist(),player);
					System.out.println("前往回復站成功");

				}
			} else if (function.equals("4")) {
				printInfo(player.get(0).pokemonArraylist() , player.get(1).pokemonArraylist(),player);
			} else if (function.equals("5")) {
				System.out.println("請輸入[load] [玩家名字] [寶可夢編號] [道具編號]  或  [unload] [玩家名字] [寶可夢編號]");
				function = ConsoleIn.readLine();
				String splitfunction[] = function.split(" ");
				if(splitfunction[0].equals("load")){
					if(splitfunction[1].equals(player.get(0).playername)){
						player.get(0).loadPitem(Integer.parseInt(splitfunction[2])-1,Integer.parseInt(splitfunction[3])-1);
					}else if(splitfunction[1].equals(player.get(1).playername)){
						player.get(1).loadPitem(Integer.parseInt(splitfunction[2])-1,Integer.parseInt(splitfunction[3])-1);
					}else{
						System.out.println("玩家姓名輸入錯誤");
					}
				}else if(splitfunction[0].equals("unload")){
					if(splitfunction[1].equals(player.get(0).playername)){
						player.get(0).unloadPitem(Integer.parseInt(splitfunction[2])-1);
					}else if(splitfunction[1].equals(player.get(1).playername)){
						player.get(1).unloadPitem(Integer.parseInt(splitfunction[2])-1);
					}else{
						System.out.println("玩家姓名輸入錯誤");
					}
				}else{
					System.out.println("錯誤");
				}
				printInfo(player.get(0).pokemonArraylist() , player.get(1).pokemonArraylist(),player);
			} else if (function.equals("6")) {
				System.out.println("“請輸入[switch] [玩家名字] [編號] [編號]");
				function = ConsoleIn.readLine();
				String splitfunction[] = function.split(" ");
				
				if(splitfunction[0].equals("switch")){
					if(splitfunction[1].equals(player.get(0).playername)){
						player.get(0).switchPokemonArraylist(Integer.parseInt(splitfunction[2])-1,Integer.parseInt(splitfunction[3])-1);
					}else if(splitfunction[1].equals(player.get(1).playername)){
						player.get(1).switchPokemonArraylist(Integer.parseInt(splitfunction[2])-1,Integer.parseInt(splitfunction[3])-1);
					}else{
						System.out.println("玩家姓名輸入錯誤");
					}
				}else{
					System.out.println("錯誤");
				}
			} else if (function.equals("7")) {// 結束遊戲
				try {
					PrintWriter writer = new PrintWriter(new File("record.txt"));//回傳資料至record.txt
					writer.println(player.get(0).playername);
					for (int n = 0; n < player.get(0).pokemonArraylist().size(); n++) {
						writer.println(
								player.get(0).pokemonArraylist().get(n).property + " " + player.get(0).pokemonArraylist().get(n).level + " " + player.get(0).pokemonArraylist().get(n).remainHealth
										+ " " + player.get(0).pokemonArraylist().get(n).skill1 + " " + player.get(0).pokemonArraylist().get(n).skill2 +" " + player.get(0).pokemonArraylist().get(n).totalexperience+" "+player.get(0).pokemonArraylist().get(n).returnPitemNameforsave());
					}
					
					writer.println(player.get(0).PlayerPitemforsave());
					writer.println(player.get(1).playername);
					for (int n = 0; n < player.get(1).pokemonArraylist().size(); n++) {
						writer.println(
								player.get(1).pokemonArraylist().get(n).property + " " + player.get(1).pokemonArraylist().get(n).level + " " + player.get(1).pokemonArraylist().get(n).remainHealth+ " " + player.get(1).pokemonArraylist().get(n).skill1 + " " + player.get(1).pokemonArraylist().get(n).skill2+" "+ player.get(1).pokemonArraylist().get(n).totalexperience+" "+player.get(1).pokemonArraylist().get(n).returnPitemNameforsave());
					}

					writer.println(player.get(1).PlayerPitemforsave());
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
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
		System.out.println("第一位玩家姓名:  "+player.get(0).playername);
		System.out.println("  寶可夢名稱  等級  生命值/生命值上限  技能一名稱  (可使用次數/總次數)   技能二名稱  (可使用次數/總次數)  經驗值     道具       普通攻擊力   技能攻擊力(技能1/技能2)  速度");
		for (int n = 0; n < player1.size(); n++) {
			System.out.println((n+1)+"  "+player1.get(n).property + "    " + player1.get(n).level + "        (" + player1.get(n).remainHealth
			+"/"+player1.get(n).remainHealthlimit		+ ")         " + player1.get(n).attack1Name+"       ("+player1.get(n).skill1 + "/5)              "     + player1.get(n).attack2Name+"             (" + player1.get(n).skill2+"/"+player1.get(n).Attack2limit+")           " +
			player1.get(n).totalexperience+"       "+player1.get(n).returnPitemName()+"       "+player1.get(n).normalAttack+"            ("+player1.get(n).Attack1+"/"+player1.get(n).Attack2+")           "+player1.get(n).speed);
		}
		System.out.println("\n道具");
		player.get(0).showAllPlayerPitem();
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n第二位玩家姓名:  "+player.get(1).playername);
		System.out.println("  寶可夢名稱  等級  生命值/生命值上限  技能一名稱  (可使用次數/總次數)   技能二名稱  (可使用次數/總次數)  經驗值     道具       普通攻擊力   技能攻擊力(技能1/技能2)  速度");
		for (int n = 0; n < player2.size(); n++) {
			System.out.println((n+1)+"  "+player2.get(n).property + "    " + player2.get(n).level + "        (" + player2.get(n).remainHealth
			+"/"+player2.get(n).remainHealthlimit		+ ")         " + player2.get(n).attack1Name+"       ("+player2.get(n).skill1 + "/5)              "     + player2.get(n).attack2Name+"             (" + player2.get(n).skill2+"/"+player2.get(n).Attack2limit+")           " +
			player2.get(n).totalexperience+"       "+player2.get(n).returnPitemName()+"       "+player2.get(n).normalAttack+"            ("+player2.get(n).Attack1+"/"+player2.get(n).Attack2+")           "+player2.get(n).speed);
		}
		System.out.println("\n道具");
		player.get(1).showAllPlayerPitem();
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
	}


		
		
		    
	
	
}



