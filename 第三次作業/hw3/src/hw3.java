import java.util.Date;
public class hw3 {
	static String function,template,log="\n";
	static String[] splitfunction= {" "," "," "," "," "," "," "};
	static boolean service=true;
	static boolean error=false;
	static int date=1,amoutOfBananaMonkeyHaveStolen,dogCanScaredMonkey=0,log_num=1;
	public static void exit(){//結束功能
		service=false;
		System.out.println("*************************");
		System.out.println("程式結束");
		System.out.println("*************************\n");
	}
	/*
	 * function儲存輸入資訊
	 * template暫存資料
	 * log系統紀錄檔
	 * splitfunction儲存分割後輸入資訊
	 * service程式是否繼續執行
	 * date//儲存目前日期
	 * monkeyAfterScaredByDog被狗嚇走後的猴子數目
	 * amoutOfBananaMonkeyHaveStolen被猴子偷走後的香蕉數目
	 * dogCanScaredMonkey狗還可再嚇得猴子數
	 * log_num:log系統紀錄編碼
	 */
	public static void main(String[] args) {//主程式
		plant pomelo=new plant(2,20,30);//新增物件pomelo(plant)
		plant banana=new plant(5,100,60);//新增物件banana(plant)
		animal monkey=new animal(3);//新增物件monkey(animal)
		animal bear=new animal(1);//新增物件bear(animal)
		animal hive=new animal(0);//新增物件hive(animal)
		animal dog=new animal(0);//新增物件dog(animal)
		System.out.println("\n********************************");
		System.out.println("  歡迎使用果園生態系模擬系統\n");
		System.out.println("********************************");		
		System.out.println("您可以選擇輸入指令: add [樹種] [位置], add [動物] [數量], \n next [天數], harvest, prune, show, exit ");
		System.out.println("-------------------------------------------------");
		while(service){
			System.out.println(" 請輸入指令");
			System.out.println(" 目前日期: "+date+" 日");
			System.out.println("-------------------------------------------------");
			function = ConsoleIn.readLine();
			splitfunction = function.split(" ");
			error();//判斷輸入字串是否有誤
			if(error==false){//字串輸入無錯誤
				if(splitfunction[0].equals("add")){//新增功能
					if(splitfunction[1].equals("pomelo")){//新增pomelo
						if(banana.location[Integer.parseInt(splitfunction[2])-1]==false&&pomelo.location[Integer.parseInt(splitfunction[2])-1]==false){
							//位置空白
							pomelo.add(Integer.parseInt(splitfunction[2]));
							System.out.println("已將pomelo新增至位置"+splitfunction[2]);
							System.out.println("-------------------------------------------------");
							logAdd("已將pomelo新增至位置"+splitfunction[2]);
						}else{
							System.out.println("位置"+splitfunction[2]+"已被占用");
							logAdd("位置"+splitfunction[2]+"已被占用");
						}
	
					}else if(splitfunction[1].equals("banana")){//新增banana
						if(banana.location[Integer.parseInt(splitfunction[2])-1]==false&&pomelo.location[Integer.parseInt(splitfunction[2])-1]==false){
							//位置空白
							banana.add(Integer.parseInt(splitfunction[2]));
							System.out.println("已將banana新增至位置"+splitfunction[2]);
							System.out.println("-------------------------------------------------");
							logAdd("已將banana新增至位置"+splitfunction[2]);
						}else{
							System.out.println("位置"+splitfunction[2]+"已被占用");
						}
	
					}else if(splitfunction[1].equals("monkey")){//新增monkey
						
						monkey.monkeyAdd(Integer.parseInt(splitfunction[2]));
						System.out.println("-------------------------------------------------");
						System.out.println("已新增monkey"+splitfunction[2]+"隻");
						System.out.println("目前monkey總數為"+monkey.totalAmount+"隻");
						System.out.println("-------------------------------------------------");
						logAdd("已新增monkey"+splitfunction[2]+"隻");
											
					}else if(splitfunction[1].equals("bear")){//新增bear
						bear.add(Integer.parseInt(splitfunction[2]));
						System.out.println("-------------------------------------------------");
						System.out.println("已新增monkey"+splitfunction[2]+"隻");
						System.out.println("目前monkey總數為"+bear.totalAmount+"隻");
						System.out.println("-------------------------------------------------");
						logAdd("已新增bear"+splitfunction[2]+"隻");
					}else if(splitfunction[1].equals("hive")){//新增hive
						hive.add(Integer.parseInt(splitfunction[2]));
						System.out.println("-------------------------------------------------");
						System.out.println("已新增hive"+splitfunction[2]+"個");
						System.out.println("目前hive總數為"+hive.totalAmount+"個");
						System.out.println("-------------------------------------------------");
						logAdd("已新增hive"+splitfunction[2]+"個");
					}else if(splitfunction[1].equals("dog")){//新增dog
						dog.add(Integer.parseInt(splitfunction[2]));
						System.out.println("-------------------------------------------------");
						System.out.println("已新增dog"+splitfunction[2]+"隻");
						System.out.println("目前dog總數為"+dog.totalAmount+"隻");
						logAdd("已新增dog"+splitfunction[2]+"隻");
					}
					
				}else if(splitfunction[0].equals("next")){//日期跳轉
					int bearStillNeedDistroy=bear.totalAmount;
					boolean stillDestroy=true;
					for(int n=1;n<=Integer.parseInt(splitfunction[1]);n++){
						date++;
						if(!(bear.totalAmount==0)){//步驟01起點
							//根據熊以及蜂巢的數量，決定蜂巢減少數量
							if(!(hive.totalAmount==0)){//有蜂巢
								while(bearStillNeedDistroy>0){
									if(stillDestroy==false){
										break;
									}
									if(hive.totalAmount>0){
										hive.totalAmount--;
										bearStillNeedDistroy--;
									}else{
										if(stillDestroy==true){
											for(int k=0;k<=8;k++){
												if(banana.location[k]==true){
													banana.location[k]=false;
													banana.amount--;
													banana.fruitAmount[k]=0;
													banana.remain_age[k]=0;
													banana.lifeSpan[k]=0;
													bear.received++;
													bearStillNeedDistroy--;
													break;
												}else if(pomelo.location[k]==true){
													pomelo.location[k]=false;
													pomelo.amount--;
													pomelo.fruitAmount[k]=0;
													pomelo.remain_age[k]=0;
													pomelo.lifeSpan[k]=0;
													bear.received++;
													bearStillNeedDistroy--;
													break;
												}else if(k==8){
													stillDestroy=false;
													break;
												}
											}
										
										}
										
									}
								}
							}else{//無蜂巢
								for(int i=1;i<=bear.totalAmount;i++){
									for(int k=0;k<=8;k++){
										if(banana.location[k]==true){
											banana.location[k]=false;
											banana.amount--;
											banana.fruitAmount[k]=0;
											banana.remain_age[k]=0;
											banana.lifeSpan[k]=0;
											bear.received++;
											break;
										}else if(pomelo.location[k]==true){
											pomelo.location[k]=false;
											pomelo.amount--;
											pomelo.fruitAmount[k]=0;
											pomelo.remain_age[k]=0;
											pomelo.lifeSpan[k]=0;
											bear.received++;
											break;
										}
									}
								}
								
							}
						}
						bear.totalAmount=0;
						//步驟01/
						//步驟2
						pomelo.allGrowNewFruit(hive.totalAmount*2);
						banana.allGrowNewFruit(hive.totalAmount*2);//根據蜂巢剩餘數量，決定果樹的結果數量
						pomelo.aDayPass();
						banana.aDayPass();
						dogCanScaredMonkey=(dog.totalAmount*2);	
						while(dogCanScaredMonkey>0 ){//狗嚇跑猴子
							if(monkey.totalAmount==0){
								break;
							}						
							if(monkey.monkeyLifeRemain1Day>0){//
								monkey.monkeyLifeRemain1Day--;
								monkey.totalAmount--;
								dog.received++;
								dogCanScaredMonkey--;
							}else if(monkey.monkeyLifeRemain2Day>0){
								monkey.monkeyLifeRemain2Day--;
								monkey.totalAmount--;
								dog.received++;
								dogCanScaredMonkey--;
							}else if(monkey.monkeyLifeRemain3Day>0){
								monkey.monkeyLifeRemain3Day--;
								monkey.totalAmount--;
								dog.received++;
								dogCanScaredMonkey--;
							}
						}
						boolean StealSameBananaTreeAgain=true;
						int bananaMonkeyShouldSteal=monkey.totalAmount*3;//猴子需偷走的香蕉
						for(int i=0;i<=8;i++){
							StealSameBananaTreeAgain=true;
							while(StealSameBananaTreeAgain&&bananaMonkeyShouldSteal>0){
								if(banana.fruitAmount[i]>0){
									banana.fruitAmount[i]--;
									banana.fruitTotal--;
									bananaMonkeyShouldSteal--;
									monkey.received++;
								}else {
									StealSameBananaTreeAgain=false;
								}
							}
							
						}
						monkey.aDayPass();
						//步驟3
		
					}
					System.out.println("-------------------------------------------------");
					System.out.println("已將時間平移"+splitfunction[1]+"天");
					System.out.println("目前日期: "+date+" 日");
					System.out.println("-------------------------------------------------");
					logAdd("已將時間平移"+splitfunction[1]+"天");
				}else if(splitfunction[0].equals("harvest")){//採收
					System.out.println("採收成功");
					pomelo.harvest("pomelo");
					banana.harvest("banana");
					System.out.println("-------------------------------------------------");
					logAdd("採收成功");
				}else if(splitfunction[0].equals("prune")){//修剪
					pomelo.prune();
					banana.prune();
					System.out.println("修剪完成");
					logAdd("修剪完成");
				}else if(splitfunction[0].equals("show")){//輸出資訊
					System.out.println("\n-------------------------------------------------");
					System.out.println("\n編號  "+"  樹種  "+"果實數量  "+"樹齡  "+"位置  ");
					for(int i=0;i<=8;i++){
						if(pomelo.location[i]==true){
							System.out.println(i+1+"     pomelo       "+pomelo.fruitAmount[i]+"      "+pomelo.age(i)+"    "+(i+1));
						}else if(banana.location[i]==true){
							System.out.println(i+1+"     banana       "+banana.fruitAmount[i]+"      "+banana.age(i)+"    "+(i+1));					
						}else{
							System.out.println(i+1+"-------------無果樹--------------");			
						}
					}
					System.out.println("\n-------------------------------------------------");
					System.out.println("\n編號  "+"  動物  "+"     數量  "+"         收穫  ");	
					
					System.out.println   ("1    "+"  monkey       "+monkey.totalAmount+"       共獲得"+monkey.received+"根香蕉 ");
					System.out.println   ("2    "+"  bear         "+bear.totalAmount+"         共破壞"+bear.received+"棵樹");
					System.out.println   ("3    "+"  hive         "+hive.totalAmount+"                  ---       ");
					System.out.println   ("4    "+"  dog          "+dog.totalAmount+"         共嚇跑"+dog.received+"隻猴子");
					System.out.println("\n-------------------------------------------------");
					logAdd("顯示果園中所有動植物詳細情況");
				}else if(splitfunction[0].equals("exit")){
					exit();
					
				}else if(splitfunction[0].equals("log")){
					System.out.println(log);
					System.out.println("\n-------------------------------------------------");
					logAdd("顯示系統紀錄檔");
				}
			}
			
		}

	}

	public static void logAdd(String a){
		Date datea = new Date();
		log=(log+"\n"+log_num+"  "+datea.toString()+"  >>  "+a);
		log=(log+"\n   "+"變數相關資訊"+"  >>    輸入資訊: "+function+"  /系統錯誤: "+error+"  /目前日期: "+date);
		log_num++;
		}
	public static void error(){//輸入資料判斷錯誤
		error=false;
		if(splitfunction[0].equals("add")){
			if(splitfunction[1].equals("pomelo")){//新增pomelo
				error=true;
				for(int i=1;i<=9;i++){//位置輸入判斷
					if(errorInt(2)==true){
						break;
					}
					if(Integer.parseInt(splitfunction[2])==i){
						error=false;
						break;
					}
				}
				if(error==true){
					System.out.println("請輸入1~9之間的整數");
					logAdd("系統錯誤，請輸入1~9之間的整數");
				}

			}else if(splitfunction[1].equals("banana")){//新增banana
				error=true;
				for(int i=1;i<=9;i++){//位置輸入判斷
					if(errorInt(2)==true){
						break;
					}
					if(Integer.parseInt(splitfunction[2])==i){
						error=false;
						break;
					}
				}
				if(error==true){
					System.out.println("請輸入1~9之間的整數");
					logAdd("系統錯誤，請輸入1~9之間的整數");
				}					
			}else if(splitfunction[1].equals("monkey")){//新增monkey
				if(errorInt(2)==true||Integer.parseInt(splitfunction[2])<=0){//數量輸入判斷
					System.out.println("錯誤，請輸入正整數");
					error=true;
					logAdd("系統錯誤，請輸入正整數");
					
				}
									
			}else if(splitfunction[1].equals("bear")){//新增bear
				if(errorInt(2)==true||Integer.parseInt(splitfunction[2])<=0){
					System.out.println("錯誤，請輸入正整數");
					error=true;
					logAdd("系統錯誤，請輸入正整數");
				}
				
			}else if(splitfunction[1].equals("hive")){//新增hive
				if(errorInt(2)==true||Integer.parseInt(splitfunction[2])<=0){
					System.out.println("錯誤，請輸入正整數");					
					error=true;
					logAdd("系統錯誤，請輸入正整數");
				}
			}else if(splitfunction[1].equals("dog")){//新增dog
				if(errorInt(2)==true||Integer.parseInt(splitfunction[2])<=0){
					System.out.println("錯誤，請輸入正整數");
					error=true;
					logAdd("系統錯誤，請輸入正整數");
				}
			}else{
				error=true;
				System.out.println("您輸入的字串"+function+"錯誤，請重新輸入");
				logAdd("輸入的字串"+function+"錯誤");
			}
		}else if(splitfunction[0].equals("next")){
			if(errorInt(1)==true||Integer.parseInt(splitfunction[1])<=0){
				System.out.println("錯誤，請輸入整數");
				error=true;
				logAdd("錯誤，請輸入整數");
				
			}

		}else if(splitfunction[0].equals("harvest")){
			
		}else if(splitfunction[0].equals("prune")){
			
		}else if(splitfunction[0].equals("log")){
			
		}else if(splitfunction[0].equals("show")){
			
		}else {
			error=true;
			System.out.println("您輸入的字串"+function+"錯誤，請重新輸入");
			logAdd("輸入的字串"+function+"錯誤，請重新輸入");
		}
		
			
	}		

	public static boolean errorInt(int a){//當輸入字串非正整數時，回報並取得錯誤訊息
		boolean errorInt=false;
		try{//try_catch
			String str = splitfunction[a];
			int m = Integer.parseInt(str);
		}catch (Exception e){
		  System.out.println("\n錯誤代碼:" + e);
		  log=(log+"\n錯誤原因:請輸入整數(int)" + e);
		  errorInt=true;

		}
		return errorInt;
		
	}
}//error回傳錯誤boolean至上方