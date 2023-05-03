public class Attack {
    public double p1,p2;
    public Attack(String p1Property , String p2Property){
       
        if(p1Property.equals(p2Property)){
            p1=1;
            p2=1;
        }else if(p1Property.equals("Flareon")){
            if(p2Property.equals("Leafeon")){
                p1=1.2;
                p2=0.8;

            }else if(p2Property.equals("Vaporeon")){
                p1=0.8;
                p2=1.2;
            }
        }else if(p1Property.equals("Leafeon")){
            if(p2Property.equals("Flareon")){
                p1=0.8;
                p2=1.2;

            }else if(p2Property.equals("Vaporeon")){
                p1=1.2;
                p2=0.8;
            }
        }else if(p1Property.equals("Vaporeon")){
            if(p2Property.equals("Flareon")){
                p1=1.2;
                p2=0.8;

            }else if(p2Property.equals("Leafeon")){
                p1=0.8;
                p2=1.2;
            }
        }
    }
}
