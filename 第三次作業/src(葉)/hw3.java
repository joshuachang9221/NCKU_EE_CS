import java.util.Scanner;
public class hw3{
  public static void main(String Args[]){
  String[] plant = new String []{"empty ", "empty ", "empty ", "empty ","empty ", "empty ","empty ", "empty ", "empty "};//empty表尚未種植植物
  int[] fruitnumber = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};//紀錄果實數量
  int[] lifespan = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};//紀錄植物當前壽命 
  int[] StayingMonkey = new int[]{0, 0, 0};//判斷猴子停留天數
  int[] StayingBear = new int[]{0};//判斷熊停留天數
  int monkeynumber = 0;//紀錄動物目前數量
  int dognumber = 0;
  int bearnumber = 0; 
  int hivenumber = 0;
  int a = 0;//若現有香蕉數量小於全部猴子偷的香蕉數量則顯示猴子偷走了現有香蕉數量
  int b = 0;//計算採收的pomelo數量
  int e = 0;//計算採收的banana數量
  int f = 0;//計算已經採收的pomelo數量
  int g = 0;//計算已經採收的banana數量
  System.out.println("歡迎使用果園生態系模擬系統");
  for(int i = 1; i>0 ; i+=0){
    System.out.println("當前日期為: "+i+"日");
    System.out.println("請輸入指令: add [樹種] [位置], add [動物] [數量], next [天數], harvest, prune, show, exit ");
    Scanner scanner = new Scanner(System.in);
    String mustSplitString = scanner.nextLine();
    String[] AfterSplit = mustSplitString.split(" ");
    if(AfterSplit[0].equals("add")){//add 功能 分為添加植物和添加動物兩大部分
      if(!AfterSplit[1].equals("banana")&&!AfterSplit[1].equals("pomelo")&&!AfterSplit[1].equals("dog")&&!AfterSplit[1].equals("monkey")&&!AfterSplit[1].equals("bear")&&!AfterSplit[1].equals("hive")){
        System.out.println("物種輸入錯誤, 請重新輸入");
        continue;
      }
      if(AfterSplit[1].equals("banana")||AfterSplit[1].equals("pomelo")){
       if(!AfterSplit[2].equals("1")&&!AfterSplit[2].equals("2")&&!AfterSplit[2].equals("3")&&!AfterSplit[2].equals("4")&&!AfterSplit[2].equals("5")&&!AfterSplit[2].equals("6")&&!AfterSplit[2].equals("7")&&!AfterSplit[2].equals("8")&&!AfterSplit[2].equals("9")){
       System.out.println("位置輸入錯誤, 請重新輸入");
       continue;
       }
      }
      if(AfterSplit[1].equals("pomelo") && AfterSplit[2].equals("1")){
        Pomelo pomelo1 = new Pomelo();
        int pomeloPlace = Integer.parseInt(AfterSplit[2]);
        pomelo1.place = pomeloPlace;
        pomelo1.name = "pomelo";
        plant[0] =  pomelo1.name; 
        System.out.println("成功在編號: "+pomelo1.place+"新增一棵pomelo");
      }
      if(AfterSplit[1].equals("pomelo") && AfterSplit[2].equals("2")){
        Pomelo pomelo2 = new Pomelo();
        int pomeloPlace = Integer.parseInt(AfterSplit[2]);
        pomelo2.place = pomeloPlace;
        pomelo2.name = "pomelo";
        plant[1] =  pomelo2.name;
        System.out.println("成功在編號: "+pomelo2.place+"新增一棵pomelo");
      }
      if(AfterSplit[1].equals("pomelo") && AfterSplit[2].equals("3")){
        Pomelo pomelo3 = new Pomelo();
        int pomeloPlace = Integer.parseInt(AfterSplit[2]);
        pomelo3.place = pomeloPlace;
        pomelo3.name = "pomelo";
        plant[2] =  pomelo3.name; 
        System.out.println("成功在編號: "+pomelo3.place+"新增一棵pomelo");
      }
      if(AfterSplit[1].equals("pomelo") && AfterSplit[2].equals("4")){
        Pomelo pomelo4 = new Pomelo();
        int pomeloPlace = Integer.parseInt(AfterSplit[2]);
        pomelo4.place = pomeloPlace;
        pomelo4.name = "pomelo";
        plant[3] =  pomelo4.name;
        System.out.println("成功在編號: "+pomelo4.place+"新增一棵pomelo");
      }
      if(AfterSplit[1].equals("pomelo") && AfterSplit[2].equals("5")){
        Pomelo pomelo5 = new Pomelo();
        int pomeloPlace = Integer.parseInt(AfterSplit[2]);
        pomelo5.place = pomeloPlace;
        pomelo5.name = "pomelo";
        plant[4] =  pomelo5.name;
        System.out.println("成功在編號: "+pomelo5.place+"新增一棵pomelo");
      }
      if(AfterSplit[1].equals("pomelo") && AfterSplit[2].equals("6")){
        Pomelo pomelo6 = new Pomelo();
        int pomeloPlace = Integer.parseInt(AfterSplit[2]);
        pomelo6.place = pomeloPlace;
        pomelo6.name = "pomelo";
        plant[5] =  pomelo6.name;
        System.out.println("成功在編號: "+pomelo6.place+"新增一棵pomelo");
      }
      if(AfterSplit[1].equals("pomelo") && AfterSplit[2].equals("7")){
        Pomelo pomelo7 = new Pomelo();
        int pomeloPlace = Integer.parseInt(AfterSplit[2]);
        pomelo7.place = pomeloPlace;
        pomelo7.name = "pomelo";
        plant[6] =  pomelo7.name;
        System.out.println("成功在編號: "+pomelo7.place+"新增一棵pomelo");
      }
      if(AfterSplit[1].equals("pomelo") && AfterSplit[2].equals("8")){
        Pomelo pomelo8 = new Pomelo();
        int pomeloPlace = Integer.parseInt(AfterSplit[2]);
        pomelo8.place = pomeloPlace;
        pomelo8.name = "pomelo";
        plant[7] =  pomelo8.name;
        System.out.println("成功在編號: "+pomelo8.place+"新增一棵pomelo");
      }
      if(AfterSplit[1].equals("pomelo") && AfterSplit[2].equals("9")){
        Pomelo pomelo9 = new Pomelo();
        int pomeloPlace = Integer.parseInt(AfterSplit[2]);
        pomelo9.place = pomeloPlace;
        pomelo9.name = "pomelo";
        plant[8] =  pomelo9.name;
        System.out.println("成功在編號: "+pomelo9.place+"新增一棵pomelo");
      }
      if(AfterSplit[1].equals("banana") && AfterSplit[2].equals("1")){
        Banana banana1 = new Banana();
        int bananaPlace = Integer.parseInt(AfterSplit[2]);
        banana1.place = bananaPlace;
        banana1.name = "banana";
        plant[0] =   banana1.name;
        System.out.println("成功在編號: "+banana1.place+"新增一棵banana");
      }
      if(AfterSplit[1].equals("banana") && AfterSplit[2].equals("2")){
        Banana banana2 = new Banana();
        int bananaPlace = Integer.parseInt(AfterSplit[2]);
        banana2.place = bananaPlace;
        banana2.name = "banana";
        plant[1] =   banana2.name;
        System.out.println("成功在編號: "+banana2.place+"新增一棵banana");
      }
      if(AfterSplit[1].equals("banana") && AfterSplit[2].equals("3")){
        Banana banana3 = new Banana();
        int bananaPlace = Integer.parseInt(AfterSplit[2]);
        banana3.place = bananaPlace;
        banana3.name = "banana";
        plant[2] =   banana3.name;
        System.out.println("成功在編號: "+banana3.place+"新增一棵banana");
      }
      if(AfterSplit[1].equals("banana") && AfterSplit[2].equals("4")){
        Banana banana4 = new Banana();
        int bananaPlace = Integer.parseInt(AfterSplit[2]);
        banana4.place = bananaPlace;
        banana4.name = "banana";
        plant[3] =   banana4.name;
        System.out.println("成功在編號: "+banana4.place+"新增一棵banana");
      }
      if(AfterSplit[1].equals("banana") && AfterSplit[2].equals("5")){
        Banana banana5 = new Banana();
        int bananaPlace = Integer.parseInt(AfterSplit[2]);
        banana5.place = bananaPlace;
        banana5.name = "banana";
        plant[4] =   banana5.name;
        System.out.println("成功在編號: "+banana5.place+"新增一棵banana");
      }
      if(AfterSplit[1].equals("banana") && AfterSplit[2].equals("6")){
        Banana banana6 = new Banana();
        int bananaPlace = Integer.parseInt(AfterSplit[2]);
        banana6.place = bananaPlace;
        banana6.name = "banana";
        plant[5] =   banana6.name;
        System.out.println("成功在編號: "+banana6.place+"新增一棵banana");
      }
      if(AfterSplit[1].equals("banana") && AfterSplit[2].equals("7")){
        Banana banana7 = new Banana();
        int bananaPlace = Integer.parseInt(AfterSplit[2]);
        banana7.place = bananaPlace;
        banana7.name = "banana";
        plant[6] =   banana7.name;
        System.out.println("成功在編號: "+banana7.place+"新增一棵banana");
      }
      if(AfterSplit[1].equals("banana") && AfterSplit[2].equals("8")){
        Banana banana8 = new Banana();
        int bananaPlace = Integer.parseInt(AfterSplit[2]);
        banana8.place = bananaPlace;
        banana8.name = "banana";
        plant[7] =   banana8.name;
        System.out.println("成功在編號: "+banana8.place+"新增一棵banana");
      }
      if(AfterSplit[1].equals("banana") && AfterSplit[2].equals("9")){
        Banana banana9 = new Banana();
        int bananaPlace = Integer.parseInt(AfterSplit[2]);
        banana9.place = bananaPlace;
        banana9.name = "banana";
        plant[8] =   banana9.name;
        System.out.println("成功在編號: "+banana9.place+"新增一棵banana");
      }
      if(AfterSplit[1].equals("monkey")){
        int monkeyamount = Integer.parseInt(AfterSplit[2]);
        if(monkeyamount==0){
          System.out.println("指令中的數量不接受 0, 請重新輸入");
          continue;
        }
        StayingMonkey[0] += monkeyamount;
        monkeynumber +=  monkeyamount; 
        System.out.println("成功新增"+monkeyamount+"隻猴子");
      }
      if(AfterSplit[1].equals("bear")){
        int bearamount = Integer.parseInt(AfterSplit[2]);
        if(bearamount==0){
          System.out.println("指令中的數量不接受 0, 請重新輸入");
          continue;
        }
        StayingBear[0] += bearamount;
        bearnumber += bearamount;
        System.out.println("成功新增"+bearamount+"隻熊");
      }
      if(AfterSplit[1].equals("dog")){
        int dogamount = Integer.parseInt(AfterSplit[2]);
        if(dogamount==0){
          System.out.println("指令中的數量不接受 0, 請重新輸入");
          continue;
        }
        dognumber += dogamount;
        System.out.println("成功新增"+dogamount+"隻狗");
      }
      if(AfterSplit[1].equals("hive")){
        int hiveamount = Integer.parseInt(AfterSplit[2]);
        if(hiveamount==0){
          System.out.println("指令中的數量不接受 0, 請重新輸入");
          continue;
        }
        hivenumber += hiveamount;
        System.out.println("成功新增"+hiveamount+"個蜂巢");
      }
    }
    if(AfterSplit[0].equals("next")){
      int product = Integer.parseInt(AfterSplit[1]);
      if(product==0){
        System.out.println("指令中的天數不接受 0, 請重新輸入");
        continue;
      }
      i += product;//日期往後product天
      boolean bool4 = hivenumber >= 0;
      boolean bool5 = bearnumber > 0;
      if(bool5){//只要熊存在
       int HiveBeBroken = bearnumber;//將被破壞的蜂巢數量
       if(bool4){//熊存存在會執行的行為
        if(hivenumber>=HiveBeBroken){
         System.out.println("熊破壞了"+HiveBeBroken+"個蜂巢");
         hivenumber -=  HiveBeBroken;
        }
        else if(hivenumber<HiveBeBroken){
         int c = 0;
         for(int j = 0; j<9; j++){
          if(!plant[j].equals("empty ")){
            c++;
          }
         }
         if((c+hivenumber)>=HiveBeBroken){
         System.out.println("熊破壞了"+hivenumber+"個蜂巢");
         HiveBeBroken -= hivenumber;//破壞完蜂巢後因為蜂巢不夠而需要被破壞的果樹數量
         int TreeBeBroken =  HiveBeBroken;
         System.out.println("熊破壞了"+TreeBeBroken+"棵果樹");

         for(int j = 0; j<9; j++){//熊破壞果樹
          int d = 0;
          if(!plant[j].equals("empty ")){
            plant[j] = "empty ";
            fruitnumber[j] = 0;
            lifespan[j] = 0;
            d++;
          }
          if(d==TreeBeBroken){
            break;
          }
        }

        }
        if((c+hivenumber)<HiveBeBroken){
          System.out.println("熊破壞了"+hivenumber+"個蜂巢");
          System.out.println("熊破壞了"+c+"棵果樹");
 
          for(int j = 0; j<9; j++){//熊破壞果樹
          hivenumber = 0;
          plant[j] = "empty ";
          fruitnumber[j] = 0;
          lifespan[j] = 0;
         }
         }
       } 
      }
    }
    for(int j = 0; j<product; j++){//判斷停留的熊
      StayingBear[0] = 0;
      bearnumber =  StayingBear[0];
    }
      boolean bool6 = hivenumber > 0;
      if(bool6){//只要蜂巢存在
        Pomelo.DailyFruit = 2 + hivenumber*2;
        Banana.DailyFruit = 5 + hivenumber*2;
      }
      else{
        Pomelo.DailyFruit = 2;
        Banana.DailyFruit = 5;
      }
      

      for(int x = 0; x<9; x++){//計算植物年齡
        if(!plant[x].equals("empty ")){//有種植植物的地方的lifespan才會增加, 且植物只要達壽命上限就不會再生產果實
          lifespan[x] += product;
          if(plant[x].equals("pomelo") && lifespan[x]>= Pomelo.LifeEndurance ){
            fruitnumber[x]-=Pomelo.DailyFruit;
          }
          if(plant[x].equals("banana") && lifespan[x]>= Banana.LifeEndurance ){
            fruitnumber[x]-=Banana.DailyFruit;
         }
        }
      }
      for(int j = 0; j< product; j++){//計算果實 利用每日生產數量乘上product天
        for(int x = 0; x<9; x++){
        if(plant[x].equals("pomelo")){
          fruitnumber[x] += Pomelo.DailyFruit;
            if(fruitnumber[x]>Pomelo.FruitLimitation){
              fruitnumber[x] = Pomelo.FruitLimitation;
            }
          }
          if(plant[x].equals("banana")){
            fruitnumber[x] += Banana.DailyFruit;
              if(fruitnumber[x]>Banana.FruitLimitation){
                fruitnumber[x] = Banana.FruitLimitation;
              }             
            }
          }
        }
        boolean bool7 = dognumber > 0;//只要dog存在
        if(bool7){
         int GetOutMonkey =  dognumber*2;
         if(StayingMonkey[2]>=GetOutMonkey){
          StayingMonkey[2]-=GetOutMonkey;
         }
         else if(StayingMonkey[2]<GetOutMonkey && (StayingMonkey[2]+StayingMonkey[1])>=GetOutMonkey){
          GetOutMonkey -=StayingMonkey[2];
          StayingMonkey[2] = 0;
          StayingMonkey[1]-=GetOutMonkey;
         }
         else if(StayingMonkey[2]<GetOutMonkey && (StayingMonkey[2]+StayingMonkey[1])<GetOutMonkey && (StayingMonkey[2]+StayingMonkey[1]+StayingMonkey[0])>=GetOutMonkey){
          GetOutMonkey -=StayingMonkey[2];
          StayingMonkey[2] = 0;
          GetOutMonkey -=StayingMonkey[1];
          StayingMonkey[1] = 0;
          StayingMonkey[0]-=GetOutMonkey;
         }
         else{
          StayingMonkey[2] = 0;
          StayingMonkey[1] = 0;
          StayingMonkey[0] = 0;
         }
        }
        boolean bool1 = monkeynumber>0;//只要monkey存在
          if(bool1){//只要猴子存在
            int BananaBeStolen = 0;
            for(int j = 0; j<product; j++){
            monkeynumber = StayingMonkey[2] + StayingMonkey[1]+  StayingMonkey[0];
            BananaBeStolen += monkeynumber*3;//總共被偷的香蕉數量
            StayingMonkey[2] = StayingMonkey[1];
            StayingMonkey[1] = StayingMonkey[0];
            StayingMonkey[0] = 0;
            monkeynumber = StayingMonkey[2] + StayingMonkey[1]+  StayingMonkey[0]; 
            }
            for(int j = 0; j<9;j++){//若現有香蕉數量小於全部猴子偷的香蕉數量則顯示猴子偷走了現有香蕉數量
            if(plant[j].equals("banana")){
            a = 0;
            a += fruitnumber[j];
            }
          }
          boolean bool2 = a > BananaBeStolen;
          if(bool2){
            System.out.println("猴子偷走了"+BananaBeStolen+"根香蕉");
          }
          else{
            System.out.println("猴子偷走了"+a+"根香蕉");
          }
            for(int j = 0; j<9; j++){
              if(plant[j].equals("banana")){
                boolean bool3 = fruitnumber[j] > BananaBeStolen;
                if(bool3){
                  fruitnumber[j] -= BananaBeStolen;
                  break; 
                }
                else{
                  BananaBeStolen -= fruitnumber[j];
                  fruitnumber[j] = 0;
                }
              }
            }
          }
      }
    if(AfterSplit[0].equals("show")){
      for(int j = 1 ; j<10; j++){
        System.out.print("編號: "+j+"         ");
      }
      System.out.println();
      for(int j = 0 ; j<9; j++){
        System.out.print("樹種: "+plant[j]+"    ");
      }
      System.out.println();
      for(int j = 0 ; j<9; j++){
        System.out.print("果實數:"+fruitnumber[j]+"        ");
      }
      System.out.println();
      for(int j = 0 ; j<9; j++){
        System.out.print("樹齡:  "+lifespan[j]+"        ");
      }
      System.out.println();
      System.out.println("當前狗的數量為: "+dognumber+"隻");
      System.out.println("當前熊的數量為: "+bearnumber+"隻");
      System.out.println("當前猴子的數量為: "+monkeynumber+"隻");
      System.out.println("當前蜂巢的數量為: "+hivenumber+"個");
      System.out.println("當前已採收的柚子的數量為: "+f+"個");
      System.out.println("當前已採收的香蕉數量為: "+g+"個");
    }
    if(AfterSplit[0].equals("harvest")){
     for(int j =0; j<9; j++){
      if(fruitnumber[j]>0){
        if(plant[j].equals("pomelo")){
         b += fruitnumber[j];
         fruitnumber[j] = 0;
        }
        if(plant[j].equals("banana")){
         e += fruitnumber[j];
         fruitnumber[j] = 0;
         }
      }
     }
     System.out.println("總共採收了: "+b+"顆柚子");
     System.out.println("總共採收了: "+e+"根香蕉");
     f+=b;
     g+=e;
     b = 0;
     e = 0;
    }
    if(AfterSplit[0].equals("prune")){
     for(int j = 0; j<9; j++){
      if(!plant[j].equals("empty ")){
       if(plant[j].equals("pomelo")){
        
       }
      }
     }
    }
    if(AfterSplit[0].equals("exit")){
     System.out.println("系統結束");
     break;
    }





  }
}
}

