
public class plant {
	public int fruitPerDay,fruitLimit,amount,fruitTotal,lifeDefault;
	//fruitPerDay儲存每日新增果實
	//fruitLimit果實上限
	//amount果樹數量
	//fruitTotal總果實數
	//lifeDefault預設壽命
	public int fruitAmount[]={0,0,0,0,0,0,0,0,0};//目前果實
	public int remain_age[]={0,0,0,0,0,0,0,0,0};//剩餘壽命
	public int lifeSpan[]={0,0,0,0,0,0,0,0,0};//總壽命
	public boolean location[]={false,false,false,false,false,false,false,false,false};
	public boolean growNewFruit;
	//fruitAmount目前果實
	//remain_age剩餘壽命
	//lifeSpan總壽命
	//location該位置是否有果樹
	//growNewFruit是否還可繼續生長果實
	plant(int fruitPerDay,int fruitLimit,int lifeSpan){//建構子
		this.fruitPerDay=fruitPerDay;
		this.fruitLimit=fruitLimit;
		lifeDefault=lifeSpan;
		for(int i=0;i<9;i++){
			this.lifeSpan[i]=lifeDefault;
		}
		
	}
	public void add(int location){//新增果樹
		this.location[location-1]=true;
		fruitAmount[location-1]=0;
		lifeSpan[location-1]=lifeDefault;
		remain_age[location-1]=lifeDefault;
		amount++;

	}

	public int age(int i){//回傳樹齡值
		return lifeSpan[i]-remain_age[i];
	}

	public void harvest( String fruitName){//果樹採收
		fruitTotal=0;
		for(int i=0;i<9;i++){
			fruitTotal+=fruitAmount[i];
			fruitAmount[i]=0;
		}
		System.out.println("已收成"+fruitName+"共"+fruitTotal+"顆");
	}

	public void prune(){//果樹修剪
		for(int i=0;i<9;i++){
			if(location[i]==true){
				lifeSpan[i]+=5;
				remain_age[i]+=5;
			}
			
		}	
	}

	public void aDayPass(){//一天過去執行增加果實與減少剩餘壽命
		allGrowNewFruit(fruitPerDay);//全部生長果實
		for(int i=0;i<9;i++){
			if(location[i]==true){//分辨各位置是否有種樹
				remain_age[i]-=1;
			}
			
		}
		
	}

	public void allGrowNewFruit(int growHowManyFruit){//全部生長果實
		for(int k=0;k<=8;k++){
			if(location[k]==true){	//分辨各位置是否有種樹
				for(int i=1;i<=growHowManyFruit;i++){
					if(remain_age[k]>0&&(fruitLimit-fruitAmount[k])>0){//壽命大於零且未達果實上限
					fruitAmount[k]+=1;
					}
					
				}
			}
		} 
	}	 
}
