public class animal {
	public String name;//動物種類
	public int remainStayDay,totalAmount=0;//剩餘停留時間
	public int monkeyLifeRemain1Day;//猴子剩餘停留時間只剩1天
	public int monkeyLifeRemain2Day;//猴子剩餘停留時間只剩2天
	public int monkeyLifeRemain3Day;//猴子剩餘停留時間只剩3天
	public int received=0;//取得收穫
	
	animal (int remainStayDay){//建構子
		this.remainStayDay=remainStayDay;//儲存停留時間
	}
	
	public void add(int amount){//增加動物
		totalAmount+=amount;
	}
	public void monkeyAdd(int amount){//增加猴子
		
		monkeyLifeRemain3Day+=amount;
		totalAmount=monkeyLifeRemain1Day+monkeyLifeRemain2Day+monkeyLifeRemain3Day;
	}


	public void aDayPass(){//一天過去、記錄猴子剩餘停留時間
		monkeyLifeRemain1Day=monkeyLifeRemain2Day;	//剩2天儲存至剩1天	
		monkeyLifeRemain2Day=monkeyLifeRemain3Day;	//剩3天儲存至剩2天	
		monkeyLifeRemain3Day=0;						////剩1天歸零
		totalAmount=monkeyLifeRemain1Day+monkeyLifeRemain2Day+monkeyLifeRemain3Day;//回傳猴子總數
	}
}


		
