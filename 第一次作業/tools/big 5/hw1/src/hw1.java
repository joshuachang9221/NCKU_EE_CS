public class hw1 {
	static boolean service=true;
	static String gender,designer,haircut,fhaircut,dye,dyem,conditioner,perm,permm,wash,next;
	static int total=0,user=0;
	
	public static void welcome_interface(){
		System.out.println("***************************");
		System.out.println("歡迎使用理髮店金額計算系統");
		System.out.println("***************************");
	}

	public static void setgender(){
			gender = ConsoleIn.readLine();
			if(gender.equals("m")){
				System.out.println("-您的性別->男性");
			}
			else if(gender.equals("f")){
				System.out.println("-您的性別->女性");
			}
			else{
				System.out.println("-錯誤");
			}
			System.out.println("--------------------------------");
	}

	public static void setdesigner(){
		System.out.println("是否指定設計師( y or n )");
			designer = ConsoleIn.readLine();
			if(designer.equals("y")){
				System.out.println("-您已選擇->指定設計師");
				total+=500;
			}
			else if(designer.equals("n")){
				System.out.println("-您已選擇->不指定設計師");
			}
			else{
				System.out.println("-錯誤");
			}
			System.out.println("-目前累計金額:"+total+"元");
			System.out.println("--------------------------------");
	}
    
	public static void main(String[] args) {
		welcome_interface();
		while(service){
			service=false;
			setgender();
			setdesigner();
			System.out.println("是否需要剪髮服務( y or n )");
			haircut = ConsoleIn.readLine();
			if(haircut.equals("y")){
				System.out.println("-您已選擇->剪髮服務");
				if(gender.equals("f")){
					System.out.println("-是否選擇只剪瀏海");
					fhaircut= ConsoleIn.readLine();
					if(fhaircut.equals("y")){
						total+=50;
						System.out.println("-您已選擇->只剪瀏海");
					}
					else if(fhaircut.equals("n")){
						total+=150;
						System.out.println("-您已選擇->精緻剪髮");

					}
					else{
						System.out.println("-錯誤");
						}
					}
				else if(gender.equals("m")){
						total+=100;
						System.out.println("-您已選擇->剪髮");
				}	
					
			}			
			else if(designer.equals("n")){
				System.out.println("-您未選擇剪髮服務");
				}
			else{
				System.out.println("-錯誤");
			}
			System.out.println("-目前累計金額:"+total+"元");
			System.out.println("--------------------------------");
			System.out.println("是否需要染髮服務( y or n )");
			dye = ConsoleIn.readLine();
			if(dye.equals("y")){
				System.out.println("請選擇染劑 ( 1為一般染劑、2為天然護髮染)");
				dyem = ConsoleIn.readLine();
				if(dyem.equals("1")){
					System.out.println("-您已選擇->一般染劑");
					total+=499;
				}
				else if(dyem.equals("2")){
					System.out.println("-您已選擇->天然護髮染");
					total+=999;
				}
				else{
					System.out.println("-錯誤");
				}
			}
			else if(gender.equals("n")){
				System.out.println("-您未選擇染髮服務");
			}
			else{
				System.out.println("-錯誤");
			}
			System.out.println("-目前累計金額:"+total+"元");
			System.out.println("--------------------------------");
			System.out.println("是否需要護髮服務 ( y or n )");
			conditioner = ConsoleIn.readLine();
			if(conditioner.equals("y")){
				System.out.println("-您已選擇->護髮服務");
				if(gender.equals("f")){
					total+=720;
				}
				else{
					total+=360;
				}	
			}
			else if(designer.equals("n")){
				System.out.println("-您未選擇護髮服務");
			}
			else{
				System.out.println("錯誤");
			}
			System.out.println("-目前累計金額:"+total+"元");
			System.out.println("--------------------------------");
			System.out.println("是否需要燙髮服務( y or n )");
			perm = ConsoleIn.readLine();
			if(perm.equals("y")){
				System.out.println("請選擇項目( 1為髮根澎澎燙、2為局部燙、3為哥德式閃亮)");
				permm = ConsoleIn.readLine();
				if(permm.equals("1")){
					System.out.println("-您已選擇->髮根澎澎燙");
					total+=1000;
				}
				else if(permm.equals("2")){
					System.out.println("-您已選擇->局部燙");
					total+=500;
				}
				else if(permm.equals("3")){
					System.out.println("-您已選擇->哥德式閃亮");
					total+=350;
				}
				else{
					System.out.println("-錯誤");
				}
			}
			else if(perm.equals("n")){
				System.out.println("-您未選擇染髮服務");
			}
			else{
				System.out.println("-錯誤");
			}
			System.out.println("-目前累計金額:"+total+"元");
			System.out.println("--------------------------------");
			System.out.println("是否是否需要洗髮服務 ( y or n )");
			wash = ConsoleIn.readLine();
			if(wash.equals("y")){
				System.out.println("-您已選擇->洗髮服務");
				total+=50;
			}
			else if(wash.equals("n")){
				System.out.println("-您未選擇洗髮服務");
			}
			else{
				System.out.println("-錯誤");
			}
			System.out.println("-目前累計金額:"+total+"元");
			System.out.println("--------------------------------");
			if(wash.equals("n")&&haircut.equals("n")&&dye.equals("n")&&conditioner.equals("n")&&perm.equals("n")){
				service=true;
				System.out.println("-未預約任何項目，請重新輸入");
				System.out.println("-目前預約人數"+user+"人");
			}
			else{
				user++;
				System.out.println("-目前已輸入"+user+"位顧客");
				System.out.println("是否繼續預約下一位顧客( y or n )");
				next= ConsoleIn.readLine();
				if(next.equals("y")){
					System.out.println("-開始預約下一個人");
					service=true;
				}
				else if(next.equals("n")){
					System.out.println("-系統結束");
					service=false;
				}
				else{
					System.out.println("-錯誤");
				}
			}
		}
		System.out.println("--------------------------------");
		System.out.println("本次消費總人數:"+user+"人");
		if(user==2)
		{
			System.out.println("適用折扣優惠:9折");
			total=(int) (total*(0.9));

		}
		else if(user>2){
			System.out.println("適用折扣優惠:8折");
			total=(int) (total*(0.8));
		}
		System.out.println("本次消費總金額:"+total+"元");
		System.out.println("--------------------------------");
	}	
						
}			
