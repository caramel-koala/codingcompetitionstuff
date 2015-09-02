import java.io.*;
class inversefib{

	static String fibToString(int F0,int F1,int n){
		String F0_str = Integer.toString(F0);
		String F1_str = Integer.toString(F1);
		String n_str = Integer.toString(n);
		return (F0_str + " " + F1_str + " " + n_str);
	}

	static String findfib(int Fn){
		int F0 = 0; 
		int F1 = 0;
		int n = 0;	

		int Fstart = (Fn*61)/100;
		int Fstop = (Fn*63)/100;
		while(true){
			if(Fstart > Fstop) break;
			int nc = 0;
			int F0c = Fstart;
			int F1c = Fn;			

			while(true){
				nc++;
				int tmp2 = F1c - F0c;
				if(tmp2 <= 0) break;
				int tmp = F0c;
				F0c = tmp2;
				F1c = tmp;
				//System.out.println(F1c);		
			}
			if(nc > n){
				n = nc; F0 = F0c; F1 = F1c;				 
			}
			if(nc == n && F0c < F0 && F0c > 0){
				F0 = F0c; F1 = F1c;
			}
			Fstart++;
		}		
		
		return fibToString(F0,F1,n);
	}		

	public static void main(String[] args){
		try{
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(console.readLine().trim());
			for(int i = 1; i <= T; i++){
				int Fn = Integer.parseInt(console.readLine().trim());
				String result = findfib(Fn);
				System.out.println("Case #" + i + ": " + result);
			}

			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
