import java.util.Arrays;
import java.util.Date;

public class hw2 {
	static boolean service=true,error01,error02;
	static String function,log="\n";
	static String[] splitfunction= new String [4];
	static int[] date= new int [100];
	static String[] catagory= new String [100];
	static int[] amount= new int [100];
	static int count=0,num,update_number,delete_number,length01,length02,log_num=1,account_all=0;

	/*		各變數(陣列)功能說明如下:
	 * 		1.boolean 
	 * 		(1) service: 用於紀錄程式是否繼續執行，如使用exit功能時service=false，程式結束
	 * 		(2) error01: 用於紀錄使用者輸入時是否有錯誤，包含格式、拼字、數字型態及其他可能會造成程式執行時發生錯誤的狀況
	 * 		(3) error02: 同error01
	 * 
	 * 		2. String
	 * 		(1) function: 用於儲存使用者一開使輸入的功能名稱
	 * 		(2) log: 用於儲存系統紀錄檔，在發生錯誤時可輸入log查看詳細資訊
	 * 
	 * 		3.String[]
	 * 		(1)	splitfunction: 以陣列型態儲存使用者輸入的資訊
	 * 		(2) catagory: 以陣列型態儲存帳目類別
	 * 
	 * 		4.int[]
	 * 		(1) date: 以陣列型態儲存帳目日期
	 * 		(2) amount: 以陣列型態儲存帳目金額
	 * 
	 * 		5.int
	 * 		(1) count: 紀錄目前帳目已儲存筆數
	 * 		(2) num: 紀錄列表編碼
	 * 		(3) update_number: 紀錄使用update功能時，要更新的編碼
	 * 		(4) delete_number: 紀錄使用delete功能時，要刪除的編碼
	 * 		(5) length01: 用於判斷資料輸入格式是否有誤
	 * 		(6) length02: 同length01
	 * 		(7) log_num: 儲存系統紀錄檔編碼
	 * 		(8) account_all: 目前花費總金額
	 * 
	 */
	
	public static void log() {//儲存系統紀錄檔
		Date date = new Date();
		log=(log+"\n"+log_num+"  "+date.toString()+"  >>  "+service+"."+error01+"."+error02+"."+account_all+"."+function+"."+Arrays.toString(splitfunction)+".");
		log=(log+count+"."+num+"."+update_number+"."+delete_number+"."+length01+"."+length02+"."+log_num);
		log_num++;

	}
	public static void error(int a){//當輸入字串非正整數時，回報並取得錯誤訊息
		try{//try_catch
			String str = splitfunction[a];
			int m = Integer.parseInt(str);
		}catch (Exception e){
			error02=true;
		  System.out.println("\n錯誤代碼:" + e);
		  log=(log+"\n錯誤原因:請輸入整數(int)" + e);

		}
	}
	public static void add_error() { //判斷add功能輸入時格式及資料範圍是否有錯誤

		length01 = function.length();//判斷空格數
        String s = function.replace(" ", "");
        length02 = s.length();
		if((length01-length02)==3){//空格數==3
			for(int i=1;i<=31;i++){//判斷輸入日期是否介於1~31
				error01=true;
				
				
				if(splitfunction[1].equals(Integer.toString(i))){
					error01=false;
					break;	
				}			
			}			
			error02=false;
			error(3);
        }else{
			error01=true;
			log=(log+"\n錯誤原因:格式不符(!(length01-length02)=3)" );
        }
		
	}

	public static void add(){//add新增功能
		if(error01==false&&error02==false){//判斷格式是否有誤之錯誤變數
			if(splitfunction[2].equals("a")){//類別a
					date[count]=Integer.parseInt(splitfunction[1]);
					catagory[count]="娛樂";
					amount[count]=Integer.parseInt(splitfunction[3]);
					System.out.println("___________________________");	
					System.out.println(" 已將下列資料存入帳本");
					System.out.println("  日 期    類 別  金 額  ");
					System.out.println("  "+date[count]+"日     "+catagory[count]+"   "+amount[count]+"元");
					System.out.println("___________________________");	
			}else if(splitfunction[2].equals("b")){//類別b
					date[count]=Integer.parseInt(splitfunction[1]);
					catagory[count]="飲食";
					amount[count]=Integer.parseInt(splitfunction[3]);
					System.out.println("___________________________");	
					System.out.println(" 已將下列資料存入帳本");
					System.out.println("  日 期    類 別  金 額  ");
					System.out.println("  "+date[count]+"日     "+catagory[count]+"   "+amount[count]+"元");
					System.out.println("___________________________");
			}else if(splitfunction[2].equals("c")){//類別c
					date[count]=Integer.parseInt(splitfunction[1]);
					catagory[count]="交通";
					amount[count]=Integer.parseInt(splitfunction[3]);
					System.out.println("___________________________");	
					System.out.println(" 已將下列資料存入帳本");
					System.out.println("  日 期    類 別  金 額  ");
					System.out.println("  "+date[count]+"日     "+catagory[count]+"   "+amount[count]+"元");
					System.out.println("___________________________");
			}else{//類別資料輸入錯誤
					System.out.println("  錯誤.請重新輸入");
					System.out.println("  查看系統紀錄請輸入log");
					System.out.println("___________________________");
					log=(log+"\n錯誤原因:輸入數據異常(add)(類別資料)" );
			}
			count++;
		}else{
			log=(log+"\n錯誤原因:請輸入正確日期(add)(1~31)");
			System.out.println("  錯誤.請重新輸入" );
			System.out.println("  查看系統紀錄請輸入log");
			System.out.println("___________________________");
		}
	}
		
	public static void arrange(){//氣泡排序法
		//用於列表排序(先依日期、後依輸入順序)
		int j, tempd,tempa;
		String tempc;
		for(int t=0; t<count; t++){
			for(j=0; j<count-1; j++){
				if(date[j] > date[j+1]){
					tempd = date[j];
					date[j] = date[j+1];
					date[j+1] = tempd;
					tempc = catagory[j];
					catagory[j] = catagory[j+1];
					catagory[j+1] = tempc;
					tempa = amount[j];
					amount[j] = amount[j+1];
					amount[j+1] = tempa;
				}
			}
		}	
	}

	public static void show_all(){//show all功能 顯示全部資料
		arrange();
		num=1;
		System.out.println("___________________________");	
		System.out.println("   日 期    類 別  金 額  ");
		for(int i=0;i<count;i++){//列印列表
			System.out.println(num+"   "+date[i]+"日     "+catagory[i]+"   "+amount[i]+"元");
			num++;
		}
		for(int i=0;i<count;i++){//總金額計算
			account_all=amount[i]+account_all;
		}
		if(!(num==1)){//列表不空白
			System.out.println("\n 目前總金額為"+account_all+"元");
		}
	}	
	public static void show_a(){//show a功能 顯示類別a帳目
		arrange();
		System.out.println("以下為娛樂的帳目");
		System.out.println("___________________________");	
		System.out.println("   日 期    類 別  金 額  ");
		for(int i=0;i<count;i++){//列印列表
			if(catagory[i].equals("娛樂")){
				System.out.println(num+"   "+date[i]+"日     "+catagory[i]+"   "+amount[i]+"元");
				num++;
			}
		}
	}	
	public static void show_b(){//show a功能 顯示類別b帳目
		arrange();
		System.out.println("以下為娛樂的帳目");
		System.out.println("___________________________");	
		System.out.println("   日 期    類 別  金 額  ");	
		for(int i=0;i<count;i++){//列印列表
			if(catagory[i].equals("飲食")){
			System.out.println(num+"   "+date[i]+"日     "+catagory[i]+"   "+amount[i]+"元");
				num++;
			}
		}
	}
	public static void show_c(){//show a功能 顯示類別c帳目
		arrange();
		System.out.println("以下為娛樂的帳目");
		System.out.println("___________________________");	
		System.out.println("   日 期    類 別  金 額  ");	
		for(int i=0;i<count;i++){//列印列表
			if(catagory[i].equals("交通")){

				System.out.println(num+"   "+date[i]+"日     "+catagory[i]+"   "+amount[i]+"元");
				num++;
			}
		}
	}
	public static void update(){//帳目更新功能
		arrange();
		num=1;
		System.out.println("___________________________");	
		System.out.println("   日 期    類 別  金 額  ");	
		for(int i=0;i<count;i++){//列印列表
			System.out.println(num+"  "+date[i]+"日     "+catagory[i]+"   "+amount[i]+"元");
			num++;
		}
		if(num==1){//列表空白
			System.out.println("\n  系統錯誤:資料空白!");
			System.out.println("  查看系統紀錄請輸入log");
			log=(log+"\n錯誤原因:資料空白(num==0)" );
		}else{
			System.out.println("請輸入修改該編號的帳目:");
			function = ConsoleIn.readLine();
			splitfunction = function.split(" ");
			update_error();
			update_number=Integer.parseInt(splitfunction[0])-1;
			if(error01==false&&error02==false){//update_error格式判斷
				if(splitfunction[2].equals("a")){//更新之類別為a
					date[update_number]=Integer.parseInt(splitfunction[1]);
					catagory[update_number]="娛樂";
					amount[update_number]=Integer.parseInt(splitfunction[3]);
					System.out.println("編號"+splitfunction[0]+"已更新");	
					System.out.println("___________________________");	
					System.out.println("  日 期    類 別  金 額  ");	
					System.out.println(" "+date[update_number]+" "+catagory[update_number]+" "+amount[update_number]);
					System.out.println("___________________________");
				}else if(splitfunction[2].equals("b")){//更新之類別為b
					date[update_number]=Integer.parseInt(splitfunction[1]);
					catagory[update_number]="飲食";
					amount[update_number]=Integer.parseInt(splitfunction[3]);
					System.out.println("編號"+splitfunction[0]+"已更新");	
					System.out.println("___________________________");	
					System.out.println("  日 期    類 別  金 額  ");
					System.out.println(" "+date[update_number]+" "+catagory[update_number]+" "+amount[update_number]);
					System.out.println("___________________________");	
				}else if(splitfunction[2].equals("c")){//更新之類別為c
					date[update_number]=Integer.parseInt(splitfunction[1]);
					catagory[update_number]="交通";
					amount[update_number]=Integer.parseInt(splitfunction[3]);
					System.out.println("編號"+splitfunction[0]+"已更新");	
					System.out.println("___________________________");	
					System.out.println("  日 期    類 別  金 額  ");
					System.out.println(" "+date[update_number]+" "+catagory[update_number]+" "+amount[update_number]);
					System.out.println("___________________________");	
				}else{//類別資料輸入錯誤
					System.out.println(function+"  輸入字串有誤.請重新輸入");
					System.out.println("  查看系統紀錄請輸入log");
					System.out.println("___________________________");
				}
			}else {
			System.out.println(function+"  資料輸入錯誤.請重新輸入");
			log=(log+"\n錯誤原因:請輸入正確日期(1~31)或資料異常");
			System.out.println("  查看系統紀錄請輸入log");
			System.out.println("___________________________");
		}
		}
		
	}
	
	public static void update_error(){
		error02=false;
		length01 = function.length();
        String s = function.replace(" ", "");
        length02 = s.length();
		if(Integer.parseInt(splitfunction[0])<1){
			error02=true;
		}
		if((length01-length02)==3){//輸入格式判斷 空格是否==3
			for(int i=1;i<=31;i++){//日期輸入範圍判斷(1~31)
				error01=true;
				if(splitfunction[1].equals(Integer.toString(i))){
					error01=false;
					break;	
				}
			}			
			error(3);
			if(error01==true){
				log=(log+"\n錯誤原因:請輸入正確日期" );
				System.out.println("  日期資料輸入錯誤.請重新輸入");
			}	
        }else{
			error01=true;
			error02=true;
			log=(log+"\n錯誤原因:格式不符(!(length01-length02)=3)" );
        }

		if(Integer.parseInt(splitfunction[0])>(count)||Integer.parseInt(splitfunction[0])==0){//輸入是否超出列表範圍
			error01=true;	
			log=(log+"\n錯誤原因:找不到編碼(Integer.parseInt(splitfunction[0])>count||Integer.parseInt(splitfunction[0])==0)" );
		}	
	}
	public static void show_number(){//顯示特定日期帳目
		arrange();	
		System.out.println("以下為"+splitfunction[1]+"日的帳目");
		System.out.println("___________________________");	
		System.out.println("   日 期    類 別  金 額  ");
			for(int i=0;i<count;i++){//列印列表
				if(date[i]==Integer.parseInt(splitfunction[1])){
					System.out.println(num+"   "+date[i]+"日     "+catagory[i]+"   "+amount[i]+"元");
					num++;
				}
		}
	}
	
	public static void help(){//幫助功能
		System.out.println("_____________________________________________________________________________________________________________________________________________________");
		System.out.println("\n(1)請進行功能選擇並輸入，功能包括「add [日期] [類別] [金額]」、「show all」、「show [日期]」、「show [類別]」、「update」、「delete」、「delete all」、「help」、「exit」及「log」\n");
		System.out.println("(2)如選擇輸入「add [日期] [類別] [金額]」，系統將新增一筆帳目並儲存，並返回步驟(1)\n");
		System.out.println("(3)如選擇輸入「show all」，系統將用列表排序顯示所有帳目，同時顯示總金額，並返回步驟(1)\n");
		System.out.println("(4)如選擇輸入「show [日期]」，系統將用列表排序顯示於特定日期的所有帳目，並返回步驟(1)\n");
		System.out.println("(5)如選擇輸入「show [類別]」，系統將用列表排序顯示於特定類別的所有帳目，並返回步驟(1)\n");
		System.out.println("(6)如選擇輸入「update」，系統將進入修改模式，選擇輸入[編號] [日期] [類別] [金額]來修改該編號的帳目，系統將更新指定編號之帳目並儲存，並返回步驟(1)\n");
		System.out.println("(7)如選擇輸入「delete」，系統將進入刪除模式，選擇輸入[編號]來刪除該編號的帳目，系統將刪除指定編號之帳目，並返回步驟(1)\n");
		System.out.println("(8)如選擇輸入「delete all」，系統將刪除所有帳目，並返回步驟(1)\n");
		System.out.println("(9)如選擇輸入「help」，系統將列出基本指令集，說明各指令功能，並返回步驟(1)\n");
		System.out.println("(10)如選擇輸入「exit」，程式將結束運作並離開\n");
		System.out.println("(11)如選擇輸入「log」，系統將顯示程式執行時系統紀錄使用者所操作之相關資料，包含錯誤代碼、原因及各變數之數值或字串，並返回步驟(1)\n");
		System.out.println("_____________________________________________________________________________________________________________________________________________________");
	}
	public static void exit(){//結束功能
		service=false;
		System.out.println("程式結束");

	}

	public static void delete(){//刪除功能:刪除特定資料
		error01=false;
		error02=false;
		arrange();
		num=1;
		System.out.println("___________________________");	
		System.out.println("   日 期    類 別  金 額  ");	
		for(int i=0;i<count;i++){//列印列表
			System.out.println(num+"   "+date[i]+"日     "+catagory[i]+"   "+amount[i]+"元");
			num++;
		}
		System.out.println("請輸入刪除的帳目:");
		function = ConsoleIn.readLine();
		splitfunction = function.split(" ");
		error(0);
		if(error01==false&&error02==false){//輸入編號資料範圍判斷(是否超出)
			if(Integer.parseInt(splitfunction[0])>count||Integer.parseInt(splitfunction[0])==0){
				log=(log+"錯誤原因:編號不存在(Integer.parseInt(splitfunction[0])>count||Integer.parseInt(splitfunction[0])==0)" );
				error01=true;
			}else{
				error01=false;
			}
			if(error01==false){//刪除功能
				//刪除時皆最後一項資料替補已刪除之編碼並重新排序
				if(!(Integer.parseInt(splitfunction[0])<1)){
					splitfunction[0]= function;
					delete_number=Integer.parseInt(splitfunction[0])-1;
					date[delete_number]=date[count-1];
					catagory[delete_number]=catagory[count-1];
					amount[delete_number]=amount[count-1];
					date[count-1]=00;
					catagory[count-1]=("00");
					amount[count-1]=00;
					count--;
					System.out.println("編號"+splitfunction[0]+"已被刪除");
				}else{
					System.out.println(function+" 編號錯誤.無法刪除.請重新輸入");
					System.out.println("  查看系統紀錄請輸入log");
					log=(log+"\n錯誤原因:編號錯誤.無法刪除.請重新輸入" );
					System.out.println("___________________________");
				}
			
			}else{//資料範圍錯誤
				System.out.println(function+" 編號錯誤.無法刪除.請重新輸入");
				System.out.println("  查看系統紀錄請輸入log");
				log=(log+"\n錯誤原因:編號錯誤.無法刪除.請重新輸入" );
				System.out.println("___________________________");
			}		
		}else{
			System.out.println(function+" 編號錯誤.無法刪除.請重新輸入");
			log=(log+"\n錯誤原因:編號錯誤.無法刪除.請重新輸入" );
			System.out.println("  查看系統紀錄請輸入log");
			System.out.println("___________________________");
		}
		
	}

	public static void delete_all(){//全部刪除功能
		splitfunction= new String [4];//重設變數
		date= new int [100];
		String[] catagory= new String [100];
		int[] amount= new int [100];
		count=0;
		account_all=0;
		System.out.println("  已清空所有帳目 ");
		log=(log+"\n錯誤原因:資料已全部清除" );
	}
	public static void main(String[] args) {//主程式
		System.out.println("\n*************************");
		System.out.println("  歡迎使用記帳系統\n");
		System.out.println("  如需說明請輸入 help ");
		System.out.println("*************************\n");
		while(service){
			System.out.println(" 請輸入指令");
			function = ConsoleIn.readLine();
			splitfunction = function.split(" ");
			if(splitfunction[0].equals("add")){
				add_error();
				add();				
			}else if(splitfunction[0].equals("exit")){
				exit();
			}else if(splitfunction[0].equals("show")){
				num=1;
				int i;
				function= function.replace(" ", "");//移除空格
				if(!function.equals("show")){
					if(splitfunction[1].equals("all")){
						show_all();
					}else if(splitfunction[1].equals("a")){
						show_a();
					}else if(splitfunction[1].equals("b")){
						show_b();
					}else if(splitfunction[1].equals("c")){
						show_c();
					}
					for(i=1;i <=31;i++){
						if(splitfunction[1].equals(Integer.toString(i))){
							show_number();
						}
					}	
					if(num==1){//資料是否空白或輸入資料錯誤
						System.out.println("\n  系統錯誤:找不到資料.請重新輸入!");
						System.out.println("  查看系統紀錄請輸入log");
						log=(log+"\n錯誤原因:資料空白或輸入資料異常(num==1)" );
					}
				}else{
					System.out.println(function+"  輸入資料異常.請重新輸入");
					System.out.println("  查看系統紀錄請輸入log");
					log=(log+"\n錯誤原因:功能字串輸入錯誤" );
				}
				System.out.println("___________________________");
			}else if(function.equals("delete all")){
				delete_all();
			}else if(splitfunction[0].equals("update")){
				update();
			}else if(splitfunction[0].equals("delete")){
				delete();
			}else if(splitfunction[0].equals("help")){
				help();
			}else if(splitfunction[0].equals("log")){
				System.out.println(log);
			}else{
				System.out.println(" 輸入空白或找不到功能.請重新輸入");
				log=(log+"\n錯誤原因:功能字串輸入錯誤或空白" );
				System.out.println("  查看系統紀錄請輸入log");
				System.out.println("___________________________");
			}
			log();
		}
	}
		
	
}