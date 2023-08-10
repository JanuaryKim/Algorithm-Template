import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
  
        Map<String, Car> map = new HashMap<>();
        int[] result;
        
        for(String r : records)
        {
            String[] splR = r.split(" ");
            
            if(splR[2].equals("IN")) {
                Car car = map.getOrDefault(splR[1], new Car());
                car.in = splR[0];
                car.out = "";
                map.put(splR[1], car);
            }
            else {
                
                Car car = map.get(splR[1]);
                car.out = splR[0];
                car.calTime();
            }     
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        result = new int[map.size()];
        for(int i = 0; i < list.size(); i++)
        {
            String time = list.get(i);
            Car car = map.get(time);
            if(car.out.equals(""))
            {
                car.out = "23:59";
                car.calTime();
            }
            int fee = fees[1];
            int addTime = car.parkingTime - fees[0];
            int addFee = addTime > 0 ? (int)Math.ceil((double)addTime / fees[2]) * fees[3] : 0; 
            
            result[i] = fee + addFee;
        }      
        return result;
    }
    
    class Car{
        
        int parkingTime;
        String in;
        String out;
        
        public void calTime()
        {
            String[] splIn = in.split(":");
            String[] splOut = out.split(":");
            
            int inH = Integer.parseInt(splIn[0]);
            int inM = Integer.parseInt(splIn[1]);
            
            int outH = Integer.parseInt(splOut[0]);
            int outM = Integer.parseInt(splOut[1]);
            
            int h = outH - inH;
            int m = 0;
            
            if(inH == outH)
            {
                m = outM - inM;
            }
            else
            {
                if(inM > 0)
                {
                    h -= 1;
                    m += 60 - inM;
                }
                m += outM;
            }         
            parkingTime += (h * 60) + m;
        }
    }
}