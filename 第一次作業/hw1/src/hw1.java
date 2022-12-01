import java.util.Random;
import java.util.Date;

public class hw1 {
	
	static boolean service=true,exe=false;
	static String gender,designer,haircut,fhaircut,dye,dyem,conditioner,perm,permm,wash,next,receipt=("---------------------------");
	static int total=0,user=0;
	/*
	 * 變數相關資訊:
	 * (1)boolean
	 * service:程式是否繼續執行(true:使用者未預約任何服務或需預約下一位顧客/false:所有顧客已完成預約，準備結束程式)
	 * exe:用於判斷使用者是否輸入錯誤(true:執行while迴圈/false:使用者已輸入系統要求字串，進入下一個迴圈)
	 * (2)String
	 * gender:儲存顧客性別
	 * designer:儲存顧客是否需設計師
	 * haircut:儲存顧客是否需剪髮
	 * fhaircut:儲存女性顧客是否只剪瀏海
	 * dye:儲存顧客是否染頭髮
	 * dyem:儲存顧客的染劑選項
	 * conditioner:儲存顧客是否護髮
	 * perm:儲存顧客是否燙髮
	 * permm:儲存顧客的燙髮選項
	 * wash:儲存顧客是否需洗頭
	 * next:儲存是否繼續預約
	 * receipt:儲存收據內容
	 * (3)int
	 * total:儲存總消費金額
	 * user:儲存使用者人數
	 */
	public static void welecomeinterface(){//歡迎介面
		System.out.println("***************************");
		System.out.println("歡迎使用理髮店金額計算系統");
		System.out.println("***************************");
	}

	public static void setgender(){//性別設定
		exe=true;
		while(exe){
			System.out.println("請輸入顧客性別 ( m or f)");
		gender = ConsoleIn.readLine();
		receipt=(receipt+"\n");
		if(gender.equals("m")){//男性
			System.out.println(" - 您的性別->男性");
			receipt=(receipt+"\n - 您的性別->男性");
			exe=false;
		}
		else if(gender.equals("f")){//女性
			System.out.println(" - 您的性別->女性");
			receipt=(receipt+"\n - 您的性別->女性");
			exe=false;
		}
		else{
			System.out.println(" - 錯誤.請重新輸入");
			exe=true;
		}
		System.out.println("---------------------------");
		}
		
	}

	public static void setdesigner(){//設計師設定
		exe=true;
		while(exe){
			System.out.println("是否指定設計師( y or n )");
		designer = ConsoleIn.readLine();
		if(designer.equals("y")){//指定設計師
				System.out.println(" - 您已選擇->指定設計師");
				receipt=(receipt+"\n - 您已選擇->指定設計師");
				total+=500;
				exe=false;
		}
		else if(designer.equals("n")){//不指定設計師
				System.out.println(" - 您已選擇->不指定設計師");
				receipt=(receipt+"\n - 您已選擇->指定設計師");
				exe=false;
		}
		else{
				System.out.println(" - 錯誤.請重新輸入");
				exe=true;
		}
		}
		
		System.out.println(" - 目前累計金額:"+total+"元");
		System.out.println("---------------------------");
	}

	public static void sethaircut(){//剪髮設定
		exe=true;
		while(exe){
			System.out.println("是否需要剪髮服務( y or n )");
		haircut = ConsoleIn.readLine();
		if(haircut.equals("y")){//需剪髮
			exe=false;
			System.out.println(" - 您已選擇->剪髮服務");
			receipt=(receipt+"\n - 您已選擇->剪髮服務");
			if(gender.equals("f")){//是否為女性
				System.out.println("-是否選擇只剪瀏海( y or n )");
				fhaircut= ConsoleIn.readLine();
				if(fhaircut.equals("y")){//女性只剪瀏海
					exe=false;
					total+=50;
					System.out.println(" - 您已選擇->只剪瀏海");
					receipt=(receipt+"\n - 您已選擇->只剪瀏海");
				}
				else if(fhaircut.equals("n")){//女性精緻剪髮
					exe=false;
					total+=150;
					System.out.println(" - 您已選擇->精緻剪髮");
					receipt=(receipt+"\n - 您已選擇->精緻剪髮");

				}
				else{
					exe=true;
					System.out.println(" - 錯誤.請重新輸入");
					}
				}
			else if(gender.equals("m")){//性別為男性
					exe=false;
					total+=100;
					System.out.println(" - 您已選擇->男性剪髮");
					receipt=(receipt+"\n - 您已選擇->男性剪髮");
			}	
				
		}			
		else if(haircut.equals("n")){//未選擇剪髮
			exe=false;
			System.out.println(" - 您未選擇剪髮服務");
			receipt=(receipt+"\n - 您未選擇剪髮服務");
			}
		else{
			exe=true;
			System.out.println(" - 錯誤.請重新輸入");
		}
		}
		System.out.println(" - 目前累計金額:"+total+"元");
		System.out.println("---------------------------");
	}

	public static void setdye(){//染髮設定
		exe=true;
		while(exe){
			System.out.println("是否需要染髮服務( y or n )");
			dye = ConsoleIn.readLine();
			if(dye.equals("y")){//需要染髮服務
				exe=false;
				System.out.println("請選擇染劑 ( 1為一般染劑、2為天然護髮染)");
				dyem = ConsoleIn.readLine();
				if(dyem.equals("1")){//選擇染劑:1
					exe=false;
					System.out.println(" - 您已選擇染髮->一般染劑");
					receipt=(receipt+"\n - 您已選擇染髮->一般染劑");
					total+=499;
				}
				else if(dyem.equals("2")){//選擇染劑:2
					exe=false;
					System.out.println(" - 您已選擇染髮->天然護髮染");
					receipt=(receipt+"\n - 您已選擇染髮->天然護髮染");
					total+=999;
				}
				else{
					exe=true;
					System.out.println(" - 錯誤.請重新輸入");
				}
			}
			else if(dye.equals("n")){//不選擇染髮服務
				exe=false;
				System.out.println(" - 您未選擇染髮服務");
				receipt=(receipt+"\n - 您未選擇染髮服務");
			}
			else{
				exe=true;
				System.out.println(" - 錯誤.請重新輸入");
			}
		}	
		
			System.out.println(" - 目前累計金額:"+total+"元");
			System.out.println("---------------------------");
	}

	public static void setconditioner(){//護髮設定
		exe=true;
		while(exe){
			System.out.println("是否需要護髮服務 ( y or n )");
			conditioner = ConsoleIn.readLine();
			if(conditioner.equals("y")){//選擇護髮服務
				System.out.println(" - 您已選擇->護髮服務");
				receipt=(receipt+"\n - 您已選擇->護髮服務");
				exe=false;
				if(gender.equals("f")){//判斷性別
					total+=720;//女性價格
				}
				else{
					total+=360;//男性價格
				}	
			}
			else if(conditioner.equals("n")){//不選擇護髮服務
				exe=false;
				System.out.println(" - 您未選擇護髮服務");
				receipt=(receipt+"\n - 您未選擇護髮服務");
			}
			else{
				exe=true;
				System.out.println(" - 錯誤.請重新輸入");
			}
		}
		
		System.out.println(" - 目前累計金額:"+total+"元");
		System.out.println("---------------------------");
	}

	public static void setperm(){//趟髮設定
		exe=true;
		while(exe){
		System.out.println("是否需要燙髮服務( y or n )");
		perm = ConsoleIn.readLine();
		if(perm.equals("y")){//選擇燙髮服務
			System.out.println("請選擇項目( 1為髮根澎澎燙、2為局部燙、3為哥德式閃亮)");
			permm = ConsoleIn.readLine();
			if(permm.equals("1")){//選擇1
				exe=false;
				System.out.println(" - 您已選擇->髮根澎澎燙");
				receipt=(receipt+"\n - 您已選擇->髮根澎澎燙");
				total+=1000;
			}
			else if(permm.equals("2")){//選擇2
				exe=false;
				System.out.println(" - 您已選擇->局部燙");
				receipt=(receipt+"\n - 您已選擇->局部燙");
				total+=500;
			}
			else if(permm.equals("3")){//選擇3
				exe=false;
				System.out.println(" - 您已選擇->哥德式閃亮");
				receipt=(receipt+"\n - 您已選擇->哥德式閃亮");
				total+=350;
			}
			else{
				exe=true;
				System.out.println(" - 錯誤.請重新輸入");
			}
		}
		else if(perm.equals("n")){//未選擇燙髮服務
			exe=false;
			System.out.println(" - 您未選擇燙髮服務");
			receipt=(receipt+"\n - 您未選擇燙髮服務");
		}
		else{
			exe=true;
			System.out.println(" - 錯誤.請重新輸入");
		}
		}
		
		System.out.println(" - 目前累計金額:"+total+"元");
		System.out.println("---------------------------");
	} 

	public static void setwash(){//洗髮設定
		exe=true;
		while(exe){
			System.out.println("是否需要洗髮服務 ( y or n )");
			wash = ConsoleIn.readLine();
			if(wash.equals("y")){//選擇洗髮服務
				exe=false;
				System.out.println(" - 您已選擇->洗髮服務");
				receipt=(receipt+"\n - 您已選擇->洗髮服務");
				total+=50;
			}
			else if(wash.equals("n")){//未選擇洗髮服務
				exe=false;
				System.out.println(" - 您未選擇洗髮服務");
				receipt=(receipt+"\n - 您未選擇洗髮服務");
			}
			else{
				exe=true;
				System.out.println(" - 錯誤.請重新輸入");
			}
		}
		
		System.out.println(" - 目前累計金額:"+total+"元");
		System.out.println("---------------------------");
	}

	public static void setreceipt(){//交易明細
		System.out.println("***************************");
		System.out.println("以下是您的交易明細");
		System.out.println("本次消費總人數:"+user+"人");
		Date date = new Date();
		System.out.println("預約日期:"+date.toString());
		System.out.println(receipt);
		System.out.println("原消費金額:"+total+"元");
		if(user==2){//折扣優惠
			System.out.println("2人預約.適用折扣優惠:9折");
			total=(int) (total*(0.9));

		}
		else if(user>2&&user<5){
			System.out.println("3至4人預約.適用折扣優惠:8折");
			total=(int) (total*(0.8));
		}
		else if(user>=5){//抽獎
			System.out.println("預約人數共大於等於5人.獲得抽獎機會(95折、7折、50元折扣)");
			Random random = new Random();
			int r = random.nextInt(3);//取得亂數
			if(r==0){
			System.out.println("恭喜您獲得95折優惠"); 
			total=(int) (total*(0.95));
			}
			else if(r==1){
			System.out.println("恭喜您獲得7折優惠");
			total=(int) (total*(0.7));
			}
			else if(r==2){
			System.out.println("恭喜您獲得50元折扣");
			total-=50;
			}
		}
		System.out.println("本次消費總金額:"+total+"元");
		System.out.println("***************************\n");
	}
/*優惠規則如下
 * 預約人數=1
 * 無優惠
 * 
 * 預約人數=2
 * 9折優惠
 * 
 * 預約人數=3~4
 * 8折優惠
 * 
 * 預約人數=5~
 * 獲得抽獎機會
 * 95折
 * 7折
 * 50元折扣
 * (各獎項機率相同)
 */
    public static void main(String[] args) {//主程式
		welecomeinterface();
		while(service){
			service=false;
			setgender();
			setdesigner();
			sethaircut();
			setdye();
			setconditioner();
			setperm();
			setwash();
			if(wash.equals("n")&&haircut.equals("n")&&dye.equals("n")&&conditioner.equals("n")&&perm.equals("n")){
				//判斷使用者是否未預約任何項目
				service=true;
				System.out.println("-未預約任何項目，請重新輸入");
			}
			else{
				user++;
				System.out.println(" - 目前預約人數:"+user+"人");
				service=true;
				exe=true;
				while(exe){//是否繼續預約下一位顧客
					System.out.println("是否繼續預約下一位顧客( y or n )");
					next= ConsoleIn.readLine();
					receipt=(receipt+"\n以上為第"+user+"位顧客\n"+"---------------------------");
					if(next.equals("y")){
						System.out.println(" - 開始預約下一位顧客");
						service=true;
						exe=false;
					}
					else if(next.equals("n")){//不繼續預約下一位顧客
						System.out.println(" - 系統結束");
						service=false;
						exe=false;
						setreceipt();//輸出收據
					}
					else{
						System.out.println(" - 錯誤.請重新輸入");
						exe=true;
					}
				}
				
			}
		}
	}						
}			
