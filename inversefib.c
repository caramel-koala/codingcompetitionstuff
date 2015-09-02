/*
SBITC 2015 Regional Question Reverse Fibonacci
=============================================================================
Authors: A. Peters
=============================================================================
Given a number the program will find the longest fibonacci sequence of which the number is an element.
This code is a rewrite of the java code.
*/#include <iostream>

using namespace std;


string findfib(int Fn){

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
		}
		if(nc > n){
			n = nc; F0 = F0c; F1 = F1c;				 
		}
		if(nc == n && F0c < F0 && F0c > 0){
			F0 = F0c; F1 = F1c;
		}
		Fstart++;
	}		
	
	return return std::to_string(F0) + " " + std::to_string(F1) + " " + std::to_string(n);

}

int main()
{

	int T;
	cin >> T;
		for(int i = 1; i <= T; i++){
			int Fn;
			cin >> Fn;
			string result = findfib(Fn);
			cout << "Case #" << i << ": " << result << "\n";
		}

}