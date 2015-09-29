import java.io.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class A2 {

    // method main()
    public static void main (String[] args) {
    	//question1();
    	//question2V1();
    	question2V2();
    }
    
    public static void question1(){
    	//Question 1 cipher
    	String cipher1 = "MCTDTWEBEBITRGEPPUPEDYTIEVGPGJZRJLLEBJKGYMCEMMCTMDTTMCEMYDTWGZMCTHGTPSWEBDGYCMGZBGSTGMRJLLEEZSBMJJSIDJQSPUZTEDJZTTZSRJLLEEMMCTCTESJHMCTRCGTHMEKPTSJMPEZMTDZBWTDTCQZYJZEPPGMBKDEZRCTBSJMLJDTIDJLGBGZYBMGPPSJMMJMCTCJKKGMBLGZSSJMEZTZJDLJQBJITZEGDFGMRCTZWEBTDTRMTSGZMCTZJDMCRJDZTDJHMCTHGTPSSJMESDEQYCMJHRJJFBRJLLEHDJLTVTDUGZZEZSTEMGZYCJQBTHJDLGPTBEDJQZSRJLLEEDDGVTSMJBQIIPTLTZMMCTSWEDVTBEZSJMCTDJSSHJPFMCEMWTDTXQEDMTDTSEMKEYTZSSJMTNRGMTLTZMDJBTMJGMBCTGYCM";
    	
    	//Print out cipher text
    	System.out.print(cipher1 + "\n\n");
    	
    	//Frequency Map
    	TreeMap<Character, Integer> fMap = new TreeMap<Character, Integer>();
    
    	for(int i=0;i<cipher1.length();i++){
    		//System.out.print(cipher1.charAt(i));
    		if(fMap.get(cipher1.charAt(i))==null){
    			fMap.put(cipher1.charAt(i),1);
    		}
    		else{
    			int count = (int) fMap.get(cipher1.charAt(i));
    			count++;
    			fMap.put(cipher1.charAt(i),count);
    		}
    		
    	}
       	//System.out.print(fMap + "\n\n");
    	
    	//Trigraph map
    	TreeMap<String, Integer> TriMap = new TreeMap<String, Integer>();
        
    	
    	for(int i=0;i<(cipher1.length()-3);i++){
    		
    		if(TriMap.get(cipher1.substring(i,i+3)) == null){
    			TriMap.put(cipher1.substring(i,i+3),1);
    		}
    		else{
    			int count = TriMap.get(cipher1.substring(i,i+3));
    			count++;
    			TriMap.put(cipher1.substring(i,i+3),count);
    		}
    		
    	}
    	//Digraph map
    	TreeMap<String, Integer> DiMap = new TreeMap<String, Integer>();
        
    	
    	for(int i=0;i<(cipher1.length()-2);i++){
    		
    		if(DiMap.get(cipher1.substring(i,i+2)) == null){
    			DiMap.put(cipher1.substring(i,i+2),1);
    		}
    		else{
    			int count = DiMap.get(cipher1.substring(i,i+2));
    			count++;
    			DiMap.put(cipher1.substring(i,i+2),count);
    		}
    		
    	}
    	
    	//Print out Trigraph
    	/*
    	for (Map.Entry<String, Integer> entry : TriMap.entrySet()) {
    	     System.out.println(entry.getKey() );
    	}
    	for (Map.Entry<String, Integer> entry : TriMap.entrySet()) {
   	     System.out.println(entry.getValue());
    	}
    	
    	System.out.print(TriMap + "\n\n");
    	*/
    	
    	//Print out digraph
    	/*
    	for (Map.Entry<String, Integer> entry : DiMap.entrySet()) {
    	     System.out.println(entry.getKey() );
    	}
    	for (Map.Entry<String, Integer> entry : DiMap.entrySet()) {
   	     System.out.println(entry.getValue());
    	}
    	
    	System.out.print(DiMap + "\n\n");
    	*/
    	
    	//Letter map for question 1.
    	TreeMap<String, String> letterMap = new TreeMap<String, String>();
        
    	letterMap.put("A", "Q"); //empty
    	letterMap.put("B", "S");
    	letterMap.put("C", "H");
    	letterMap.put("D", "R");
    	letterMap.put("E", "A");
    	letterMap.put("F", "K");
    	letterMap.put("G", "I");
    	letterMap.put("H", "F");
    	letterMap.put("I", "P");
    	letterMap.put("J", "O");
    	letterMap.put("K", "B");
    	letterMap.put("L", "M");
    	letterMap.put("M", "T");
    	letterMap.put("N", "X");
    	letterMap.put("O", "Z");//empty
    	letterMap.put("P", "L");
    	letterMap.put("Q", "U");
    	letterMap.put("R", "C");
    	letterMap.put("S", "D");
    	letterMap.put("T", "E");
    	letterMap.put("U", "Y");
    	letterMap.put("V", "V");
    	letterMap.put("W", "W");
    	letterMap.put("X", "Q");
    	letterMap.put("Y", "G");
    	letterMap.put("Z", "N");
    	//System.out.print(letterMap + "\n\n");
    	
    	//creating new cipher and counting number of characters in cypher
    	String newCipher="";
    	int count = 0;
    	for(int i=0;i<cipher1.length();i++){
    			newCipher = newCipher + letterMap.get(String.valueOf(cipher1.charAt(i)));
    			count ++;
    	}
    	System.out.print(newCipher + "\n\n");
    	System.out.print(count);
    }
   
    
    static String[][] letterArray = new String[5][5];
	static String[][] bestArray = new String[5][5];
    static double temp = 20;
    static double step = 0.2;
    
    //Algorithm method
    public static void question2V1(){
    	//Question 2 cipher
    	String cipher2 = "HLVFDIAYLCWQGERBOZVLLUWNRBPIALCTOEEZDFWADIAYPAGCEXSBOFBILAAFDMGSACHTYSHGRTWCVYDISRTAATMEVHSLAFDMGSTKLUBVTPSTEYSKAQZLRLLUWNEIGRQVTZSTFDMYIRBGOFRBXTTROLEXSBRSHPQIOFOISWAPALAFDMGSACHTYSHGRTWCOFBITPWLOADUDFYACSEIBCLSMYLORBVTSBFGSBFDDIAYLACODPFDGFBLOFOLZPGRYAVFEIDIAKLRGFTQFLCGBSLDPAHKRBXTFDQLCGDLSKLWTABSGDIOLOBLGXLUWNULADWSRDNEDGGSECWQTPGFAFDMGSACHTPAFQDGGSEYBFYARSHPQIAFVIOSMCBYHOFDADOFLAULACIRBGDFBSLDPAIRAPAQXPLAQVDILOTFBPKYAEDGGSACHTYSHGRTWCAFDMGSGFVBPIVQWNDICBPRVRSLGRWAACLHBCPSVHVQWNPADULUWNCWOILRSAAFDMGSEYECXLLYBVRPMCOSYPVYPCHOHXBGLDPAWNDIYKRSWLDFGSWYDISKCWSQCGDVCWDLFGDISWOFDBPAGSSUILRSLUWLYASOAFDMGSMYLORSHPQITHODAPHTTSLATHRPKBCAFGABBDYSBCGYLCSUEIBFTAGPDPFBGEHEFBBSLDPAIHWNSRAPAQXPOFBVRSFLDGGSLDEOTYWNULVYDIEOCAUIHLZBCGOREXSBRSHPQIOFDFYMLSSEDGGSIVEZKBLWAWFDLXSQCSRPWALXZPUARBBTCAUIHLZBCGMAAFDMGSDICWAFDMGSACHTPAMFFDYVCAGBMFAYQVNVRSBVYBAYAWTRWNDFOFVYDIDISWOFLUDOBACMDILGLBFTLCOELHIUEXOCWNAFDMGSACHTYSHGRTWCGRLUCWLIHBFDULRSLDFTLADGLBRHWNADBSLDIPLFUTLBRSDUDISYAPAQXPECVFYAGRHQULALCTOFDTCAUIHLUWCWDGFGEIRSADWCCGLUOFBLAFDMGSCGTHDLQVAQSBYTEIPRYAXRBAVQUDLCHAAFDMGSACHTRSHPQIAFDMGSGFSMTHWNOFBLPSLFEIAFDMGSACHTYSHGRTWCOFDFPIGPFTSLVHLDRSDUDIAYLCYAWLQIBCMEKTLDCGELACHSLAOIZLLUWLCAOELHIUEXWLGFNSDGGSCGODYSIQLCSUSTCGWAPAXLDFECHPQIRPTPMFVYDIRBXTFDDILOACGPFTSLGVAYAWTRWNDFRSWLDFADITLEDGGSDITPMRAFDMGSEYECXLAYRUURWNAFDMGSHDCARHWNAFDMGSAPAQXLRHWNSRAPAQXPGBVFOFDILBQHEZOFBITPWLOADUDFZXLUDTYKFGSDROQLCSYAGRHQOFDTVLLWCWQTBYGYLEUBYSDIQVVRLIUTLAQVAFDMGSACHTPAFQDGGSMYQECGDUDIYEULFBADVIQVULUVLDOACGTSUTLYMCDGLBRHWNLSALEYECXLLCRDQAIPUHLDYSAFGXSLBLAGGALHBLFBSRXVCGEYQVMOFDALLYWNDILORSHPQICGOHFGATBPSBDIAPTPMREIAFFCXLSBAFDMGSYSHGRTWCIXHPQHSBFGOFLIDPBPAFDMGSQTRUQLWYTXGREMAPOHRVIDGFNEDGGSPAFQDGGSCGOHCGRBVLRQTPMRVYDIULAFDMGSYVTPSTVFOSGSWARBPIADVILOCSSTFDMYQLYMTPSTEYRPLCSEDGBFIODFWSAFDMGSHVLXYAAFDMGSACHTPAMFFDRSHPQISCPVYSSMOFLUDLRDVIOTLEDGGSCELVCSEITKDVRKTRVFHLDILOMYLOLWAYRSZPKAMCDFRBPITFBHAFDMGSRBPIADVIVYSUSAPITUWLAFDMGSZVDFZLYSFSDGGSACHTYSHGRTWCOFDTVLULLDYSFDYSYGERPAZVBMULRSRDQAIPMSFDDICBPRNGCWDFDCTPIUMCHTLYDOAKCWSHFGULAEFGOLQVAYAFDMGSULALFQRSVFSBTFBHAFDMGSBFHAPITUGLSTFDULECVFSKHLBVULRDVLULOFDUDILOTHRPHEAPDFBOYLBMYSVQLDEOEYTHFLDGGSACHTRSHPQIAFDMGSYAWSWDAYQVVRWZGAPIQVVAYUYEATFOOQDGDIAKZVLFPISBGRWAAEDGGSCGODYSAEYASGADBDYSURLEABTNTABSGDIOHMADVICAULGLVQHXSBOFOLMFFGELDISBRLQIGEAXPAKAIAHBLAOIBRSBAFDMGSDIYEULFBADVIOIRGKATHVQFLTPSTGFATWNAYSKHLDOFDVRMZWQOIYLODAOLBQHOFBDYSTHRPKECBAPYKTPTHFSDGGSTCXLRHWNULEGERAFDMGSTKDFTWRTXLEIULECWSOEEZOAFOCAWCMBFDRSWNFGAFDMGSACHTPAFQDGGSOQBGVQWNOFDUDIYEULFBADVIQVDILOTHRPKBCAGAHMALHMLHWNVRMZWQAFDMGSGECMLUDIBGOFLADILOGBYPAFDMGSDICWMYUILBYSGSVRECSEFGOLQVAYHLLDUIIUVFCEFLDGGSDIYEULFBADVIQVLHBSULECFCIULUGCMFTPDFDCDGABWCQTDIYKWADUDFFAATALDFDIABTYLEDU";
    	
    	//Print out cipher text
    	System.out.print(cipher2 + "\n\n");
    	
    	/*
    	//Frequency Map
    	TreeMap<Character, Integer> fMap = new TreeMap<Character, Integer>();
    	
    	for(int i=0;i<cipher2.length();i++){
    		//System.out.print(cipher1.charAt(i));
    		if(fMap.get(cipher2.charAt(i))==null){
    			fMap.put(cipher2.charAt(i),1);
    		}
    		else{
    			int count = (int) fMap.get(cipher2.charAt(i));
    			count++;
    			fMap.put(cipher2.charAt(i),count);
    		}
    		
    	}
    	//Print out Frequency map
    	for (Map.Entry<Character, Integer> entry : fMap.entrySet()) {
   	     System.out.println(entry.getKey() );
    	}
    	for (Map.Entry<Character, Integer> entry : fMap.entrySet()) {
  	     System.out.println(entry.getValue());
    	}
    	
       	System.out.print(fMap + "\n\n");
       	*/
       	
    	//Letter Mapping array
    	letterArray[0][0] = "P";
    	letterArray[0][1] = "L";
    	letterArray[0][2] = "A";
    	letterArray[0][3] = "Y";
    	letterArray[0][4] = "F";
    	
    	letterArray[1][0] = "I";
    	letterArray[1][1] = "R";
    	letterArray[1][2] = "E";
    	letterArray[1][3] = "X";
    	letterArray[1][4] = "M";
    	
    	letterArray[2][0] = "B";
    	letterArray[2][1] = "C";
    	letterArray[2][2] = "D";
    	letterArray[2][3] = "G";
    	letterArray[2][4] = "H";
  
    	letterArray[3][0] = "K";
    	letterArray[3][1] = "N";
    	letterArray[3][2] = "O";
    	letterArray[3][3] = "Q";
    	letterArray[3][4] = "S";
  
    	letterArray[4][0] = "T";
    	letterArray[4][1] = "U";
    	letterArray[4][2] = "V";
    	letterArray[4][3] = "W";
    	letterArray[4][4] = "Z";
    	
    	//Testing for printing out key array
    	for (int i=0;i<5;i++){
    		for (int j=0;j<5;j++){
        		System.out.print(letterArray[i][j] + " ");
        	}
    		System.out.print("\n");
    	}
    	
    	//Search for pair
    	//results = searchArray("J");
    	//System.out.print(results[0] + " " + results[1]);
    	
    	
    	//String test = "BMODZBXDNABEKUDMUIXMMOUVIF";
    	//System.out.print(decrypter(test)+"\n");
    	//System.out.print(quadgramScore("TIONTIONTION") + "\n");
    	//System.out.print(quadgramScore("HOWAREYOUTOO") + "\n");
    	
    	
    	cipher2 = "HLVFDIAYLCWQGERBOZVLLUWNRBPIALCTOEEZDFWADIAYPAGCEXSBOFBILAAFDMGSACHTYSHGRTWCVYDISRTAATMEVHSLAFDMGSTKLUBVTPSTEYSKAQZLRLLUWNEIGRQVTZSTFDMYIRBGOFRBXTTROLEXSBRSHPQIOFOISWAPALAFDMGSACHTYSHGRTWCOFBITPWLOADUDFYACSEIBCLSMYLORBVTSBFGSBFDDIAYLACODPFDGFBLOFOLZPGRYAVFEIDIAKLRGFTQFLCGBSLDPAHKRBXTFDQLCGDLSKLWTABSGDIOLOBLGXLUWNULADWSRDNEDGGSECWQTPGFAFDMGSACHTPAFQDGGSEYBFYARSHPQIAFVIOSMCBYHOFDADOFLAULACIRBGDFBSLDPAIRAPAQXPLAQVDILOTFBPKYAEDGGSACHTYSHGRTWCAFDMGSGFVBPIVQWNDICBPRVRSLGRWAACLHBCPSVHVQWNPADULUWNCWOILRSAAFDMGSEYECXLLYBVRPMCOSYPVYPCHOHXBGLDPAWNDIYKRSWLDFGSWYDISKCWSQCGDVCWDLFGDISWOFDBPAGSSUILRSLUWLYASOAFDMGSMYLORSHPQITHODAPHTTSLATHRPKBCAFGABBDYSBCGYLCSUEIBFTAGPDPFBGEHEFBBSLDPAIHWNSRAPAQXPOFBVRSFLDGGSLDEOTYWNULVYDIEOCAUIHLZBCGOREXSBRSHPQIOFDFYMLSSEDGGSIVEZKBLWAWFDLXSQCSRPWALXZPUARBBTCAUIHLZBCGMAAFDMGSDICWAFDMGSACHTPAMFFDYVCAGBMFAYQVNVRSBVYBAYAWTRWNDFOFVYDIDISWOFLUDOBACMDILGLBFTLCOELHIUEXOCWNAFDMGSACHTYSHGRTWCGRLUCWLIHBFDULRSLDFTLADGLBRHWNADBSLDIPLFUTLBRSDUDISYAPAQXPECVFYAGRHQULALCTOFDTCAUIHLUWCWDGFGEIRSADWCCGLUOFBLAFDMGSCGTHDLQVAQSBYTEIPRYAXRBAVQUDLCHAAFDMGSACHTRSHPQIAFDMGSGFSMTHWNOFBLPSLFEIAFDMGSACHTYSHGRTWCOFDFPIGPFTSLVHLDRSDUDIAYLCYAWLQIBCMEKTLDCGELACHSLAOIZLLUWLCAOELHIUEXWLGFNSDGGSCGODYSIQLCSUSTCGWAPAXLDFECHPQIRPTPMFVYDIRBXTFDDILOACGPFTSLGVAYAWTRWNDFRSWLDFADITLEDGGSDITPMRAFDMGSEYECXLAYRUURWNAFDMGSHDCARHWNAFDMGSAPAQXLRHWNSRAPAQXPGBVFOFDILBQHEZOFBITPWLOADUDFZXLUDTYKFGSDROQLCSYAGRHQOFDTVLLWCWQTBYGYLEUBYSDIQVVRLIUTLAQVAFDMGSACHTPAFQDGGSMYQECGDUDIYEULFBADVIQVULUVLDOACGTSUTLYMCDGLBRHWNLSALEYECXLLCRDQAIPUHLDYSAFGXSLBLAGGALHBLFBSRXVCGEYQVMOFDALLYWNDILORSHPQICGOHFGATBPSBDIAPTPMREIAFFCXLSBAFDMGSYSHGRTWCIXHPQHSBFGOFLIDPBPAFDMGSQTRUQLWYTXGREMAPOHRVIDGFNEDGGSPAFQDGGSCGOHCGRBVLRQTPMRVYDIULAFDMGSYVTPSTVFOSGSWARBPIADVILOCSSTFDMYQLYMTPSTEYRPLCSEDGBFIODFWSAFDMGSHVLXYAAFDMGSACHTPAMFFDRSHPQISCPVYSSMOFLUDLRDVIOTLEDGGSCELVCSEITKDVRKTRVFHLDILOMYLOLWAYRSZPKAMCDFRBPITFBHAFDMGSRBPIADVIVYSUSAPITUWLAFDMGSZVDFZLYSFSDGGSACHTYSHGRTWCOFDTVLULLDYSFDYSYGERPAZVBMULRSRDQAIPMSFDDICBPRNGCWDFDCTPIUMCHTLYDOAKCWSHFGULAEFGOLQVAYAFDMGSULALFQRSVFSBTFBHAFDMGSBFHAPITUGLSTFDULECVFSKHLBVULRDVLULOFDUDILOTHRPHEAPDFBOYLBMYSVQLDEOEYTHFLDGGSACHTRSHPQIAFDMGSYAWSWDAYQVVRWZGAPIQVVAYUYEATFOOQDGDIAKZVLFPISBGRWAAEDGGSCGODYSAEYASGADBDYSURLEABTNTABSGDIOHMADVICAULGLVQHXSBOFOLMFFGELDISBRLQIGEAXPAKAIAHBLAOIBRSBAFDMGSDIYEULFBADVIOIRGKATHVQFLTPSTGFATWNAYSKHLDOFDVRMZWQOIYLODAOLBQHOFBDYSTHRPKECBAPYKTPTHFSDGGSTCXLRHWNULEGERAFDMGSTKDFTWRTXLEIULECWSOEEZOAFOCAWCMBFDRSWNFGAFDMGSACHTPAFQDGGSOQBGVQWNOFDUDIYEULFBADVIQVDILOTHRPKBCAGAHMALHMLHWNVRMZWQAFDMGSGECMLUDIBGOFLADILOGBYPAFDMGSDICWMYUILBYSGSVRECSEFGOLQVAYHLLDUIIUVFCEFLDGGSDIYEULFBADVIQVLHBSULECFCIULUGCMFTPDFDCDGABWCQTDIYKWADUDFFAATALDFDIABTYLEDU";
    	int i=0;
    	double score,maxScore=-99e99;
    	System.out.print(cipher2);
    	
    	while(true){
    			i++;
    			
    	        score = playfairDecrypter(cipher2);
    	        
    	        if(score > maxScore){
    	            maxScore = score;
    	            System.out.print("best score so far: "+maxScore+", on iteration"+i+"\n");
    	            for (int x=0;x<5;x++){
    	        		for (int y=0;y<5;y++){
    	            		System.out.print(bestArray[x][y] + " ");
    	            	}
    	        		System.out.print("\n");
    	        	}
    	            System.out.print("    plaintext: " +decrypter(cipher2)+ " \n");
    	        }
    	}
    	
    	
    	
    }
   
    //Analytical approach
    public static void question2V2(){
    	//Question 2 cipher
    	String cipher2 = "HLVFDIAYLCWQGERBOZVLLUWNRBPIALCTOEEZDFWADIAYPAGCEXSBOFBILAAFDMGSACHTYSHGRTWCVYDISRTAATMEVHSLAFDMGSTKLUBVTPSTEYSKAQZLRLLUWNEIGRQVTZSTFDMYIRBGOFRBXTTROLEXSBRSHPQIOFOISWAPALAFDMGSACHTYSHGRTWCOFBITPWLOADUDFYACSEIBCLSMYLORBVTSBFGSBFDDIAYLACODPFDGFBLOFOLZPGRYAVFEIDIAKLRGFTQFLCGBSLDPAHKRBXTFDQLCGDLSKLWTABSGDIOLOBLGXLUWNULADWSRDNEDGGSECWQTPGFAFDMGSACHTPAFQDGGSEYBFYARSHPQIAFVIOSMCBYHOFDADOFLAULACIRBGDFBSLDPAIRAPAQXPLAQVDILOTFBPKYAEDGGSACHTYSHGRTWCAFDMGSGFVBPIVQWNDICBPRVRSLGRWAACLHBCPSVHVQWNPADULUWNCWOILRSAAFDMGSEYECXLLYBVRPMCOSYPVYPCHOHXBGLDPAWNDIYKRSWLDFGSWYDISKCWSQCGDVCWDLFGDISWOFDBPAGSSUILRSLUWLYASOAFDMGSMYLORSHPQITHODAPHTTSLATHRPKBCAFGABBDYSBCGYLCSUEIBFTAGPDPFBGEHEFBBSLDPAIHWNSRAPAQXPOFBVRSFLDGGSLDEOTYWNULVYDIEOCAUIHLZBCGOREXSBRSHPQIOFDFYMLSSEDGGSIVEZKBLWAWFDLXSQCSRPWALXZPUARBBTCAUIHLZBCGMAAFDMGSDICWAFDMGSACHTPAMFFDYVCAGBMFAYQVNVRSBVYBAYAWTRWNDFOFVYDIDISWOFLUDOBACMDILGLBFTLCOELHIUEXOCWNAFDMGSACHTYSHGRTWCGRLUCWLIHBFDULRSLDFTLADGLBRHWNADBSLDIPLFUTLBRSDUDISYAPAQXPECVFYAGRHQULALCTOFDTCAUIHLUWCWDGFGEIRSADWCCGLUOFBLAFDMGSCGTHDLQVAQSBYTEIPRYAXRBAVQUDLCHAAFDMGSACHTRSHPQIAFDMGSGFSMTHWNOFBLPSLFEIAFDMGSACHTYSHGRTWCOFDFPIGPFTSLVHLDRSDUDIAYLCYAWLQIBCMEKTLDCGELACHSLAOIZLLUWLCAOELHIUEXWLGFNSDGGSCGODYSIQLCSUSTCGWAPAXLDFECHPQIRPTPMFVYDIRBXTFDDILOACGPFTSLGVAYAWTRWNDFRSWLDFADITLEDGGSDITPMRAFDMGSEYECXLAYRUURWNAFDMGSHDCARHWNAFDMGSAPAQXLRHWNSRAPAQXPGBVFOFDILBQHEZOFBITPWLOADUDFZXLUDTYKFGSDROQLCSYAGRHQOFDTVLLWCWQTBYGYLEUBYSDIQVVRLIUTLAQVAFDMGSACHTPAFQDGGSMYQECGDUDIYEULFBADVIQVULUVLDOACGTSUTLYMCDGLBRHWNLSALEYECXLLCRDQAIPUHLDYSAFGXSLBLAGGALHBLFBSRXVCGEYQVMOFDALLYWNDILORSHPQICGOHFGATBPSBDIAPTPMREIAFFCXLSBAFDMGSYSHGRTWCIXHPQHSBFGOFLIDPBPAFDMGSQTRUQLWYTXGREMAPOHRVIDGFNEDGGSPAFQDGGSCGOHCGRBVLRQTPMRVYDIULAFDMGSYVTPSTVFOSGSWARBPIADVILOCSSTFDMYQLYMTPSTEYRPLCSEDGBFIODFWSAFDMGSHVLXYAAFDMGSACHTPAMFFDRSHPQISCPVYSSMOFLUDLRDVIOTLEDGGSCELVCSEITKDVRKTRVFHLDILOMYLOLWAYRSZPKAMCDFRBPITFBHAFDMGSRBPIADVIVYSUSAPITUWLAFDMGSZVDFZLYSFSDGGSACHTYSHGRTWCOFDTVLULLDYSFDYSYGERPAZVBMULRSRDQAIPMSFDDICBPRNGCWDFDCTPIUMCHTLYDOAKCWSHFGULAEFGOLQVAYAFDMGSULALFQRSVFSBTFBHAFDMGSBFHAPITUGLSTFDULECVFSKHLBVULRDVLULOFDUDILOTHRPHEAPDFBOYLBMYSVQLDEOEYTHFLDGGSACHTRSHPQIAFDMGSYAWSWDAYQVVRWZGAPIQVVAYUYEATFOOQDGDIAKZVLFPISBGRWAAEDGGSCGODYSAEYASGADBDYSURLEABTNTABSGDIOHMADVICAULGLVQHXSBOFOLMFFGELDISBRLQIGEAXPAKAIAHBLAOIBRSBAFDMGSDIYEULFBADVIOIRGKATHVQFLTPSTGFATWNAYSKHLDOFDVRMZWQOIYLODAOLBQHOFBDYSTHRPKECBAPYKTPTHFSDGGSTCXLRHWNULEGERAFDMGSTKDFTWRTXLEIULECWSOEEZOAFOCAWCMBFDRSWNFGAFDMGSACHTPAFQDGGSOQBGVQWNOFDUDIYEULFBADVIQVDILOTHRPKBCAGAHMALHMLHWNVRMZWQAFDMGSGECMLUDIBGOFLADILOGBYPAFDMGSDICWMYUILBYSGSVRECSEFGOLQVAYHLLDUIIUVFCEFLDGGSDIYEULFBADVIQVLHBSULECFCIULUGCMFTPDFDCDGABWCQTDIYKWADUDFFAATALDFDIABTYLEDU";
    	
    	//Print out cipher text
    	System.out.print(cipher2 + "\n\n");
    	
    	/*
    	//Frequency Map
    	TreeMap<Character, Integer> fMap = new TreeMap<Character, Integer>();
    	for(int i=0;i<cipher2.length();i++){
    		//System.out.print(cipher1.charAt(i));
    		if(fMap.get(cipher2.charAt(i))==null){
    			fMap.put(cipher2.charAt(i),1);
    		}
    		else{
    			int count = (int) fMap.get(cipher2.charAt(i));
    			count++;
    			fMap.put(cipher2.charAt(i),count);
    		}
    		
    	}
    	//Print out Frequency map
    	for (Map.Entry<Character, Integer> entry : fMap.entrySet()) {
   	     System.out.println(entry.getKey() );
    	}
    	for (Map.Entry<Character, Integer> entry : fMap.entrySet()) {
  	     System.out.println(entry.getValue());
    	}
    	
       	System.out.print(fMap + "\n\n");
       	System.out.print(cipher2.length() + "\n\n");
       	
       	*/
    	//Sixgraph map
    	TreeMap<String, Integer> SixMap = new TreeMap<String, Integer>();
        
    	
    	for(int i=0;i<(cipher2.length()-6);i++){
    		
    		if(SixMap.get(cipher2.substring(i,i+6)) == null){
    			SixMap.put(cipher2.substring(i,i+6),1);
    		}
    		else{
    			int count = SixMap.get(cipher2.substring(i,i+6));
    			count++;
    			SixMap.put(cipher2.substring(i,i+6),count);
    		}
    		
    	}
    	//Pentagraph map
    	TreeMap<String, Integer> PentaMap = new TreeMap<String, Integer>();
        
    	
    	for(int i=0;i<(cipher2.length()-5);i++){
    		
    		if(PentaMap.get(cipher2.substring(i,i+5)) == null){
    			PentaMap.put(cipher2.substring(i,i+5),1);
    		}
    		else{
    			int count = PentaMap.get(cipher2.substring(i,i+5));
    			count++;
    			PentaMap.put(cipher2.substring(i,i+5),count);
    		}
    		
    	}
    	//Quadgraph map
    	TreeMap<String, Integer> QuadMap = new TreeMap<String, Integer>();
        
    	
    	for(int i=0;i<(cipher2.length()-4);i++){
    		
    		if(QuadMap.get(cipher2.substring(i,i+4)) == null){
    			QuadMap.put(cipher2.substring(i,i+4),1);
    		}
    		else{
    			int count = QuadMap.get(cipher2.substring(i,i+4));
    			count++;
    			QuadMap.put(cipher2.substring(i,i+4),count);
    		}
    		
    	}
    	//Trigraph map
    	TreeMap<String, Integer> TriMap = new TreeMap<String, Integer>();
        
    	
    	for(int i=0;i<(cipher2.length()-3);i++){
    		
    		if(TriMap.get(cipher2.substring(i,i+3)) == null){
    			TriMap.put(cipher2.substring(i,i+3),1);
    		}
    		else{
    			int count = TriMap.get(cipher2.substring(i,i+3));
    			count++;
    			TriMap.put(cipher2.substring(i,i+3),count);
    		}
    		
    	}
    	/*
    	//Digraph map
    	TreeMap<String, Integer> DiMap = new TreeMap<String, Integer>();
        
    	
    	for(int i=0;i<(cipher2.length()-2);i++){
    		
    		if(DiMap.get(cipher2.substring(i,i+2)) == null){
    			DiMap.put(cipher2.substring(i,i+2),1);
    		}
    		else{
    			int count = DiMap.get(cipher2.substring(i,i+2));
    			count++;
    			DiMap.put(cipher2.substring(i,i+2),count);
    		}
    		
    	}
    	*/
    	
    	//Print out Sixgraph
    	for (Map.Entry<String, Integer> entry : SixMap.entrySet()) {
    	     System.out.println(entry.getKey() );
    	}
    	for (Map.Entry<String, Integer> entry : SixMap.entrySet()) {
   	     System.out.println(entry.getValue());
    	}
    	
    	System.out.print(SixMap + "\n\n");
    	
    	/*
    	//Print out Pentagraph
    	for (Map.Entry<String, Integer> entry : PentaMap.entrySet()) {
    	     System.out.println(entry.getKey() );
    	}
    	for (Map.Entry<String, Integer> entry : PentaMap.entrySet()) {
   	     System.out.println(entry.getValue());
    	}
    	
    	System.out.print(PentaMap + "\n\n");
    	*/
    	/*
    	//Print out Quadgraph
    	for (Map.Entry<String, Integer> entry : QuadMap.entrySet()) {
    	     System.out.println(entry.getKey() );
    	}
    	for (Map.Entry<String, Integer> entry : QuadMap.entrySet()) {
   	     System.out.println(entry.getValue());
    	}
    	
    	System.out.print(PentaMap + "\n\n");
    	*/
    	/*
    	//Print out Trigraph
    	for (Map.Entry<String, Integer> entry : TriMap.entrySet()) {
    	     System.out.println(entry.getKey() );
    	}
    	for (Map.Entry<String, Integer> entry : TriMap.entrySet()) {
   	     System.out.println(entry.getValue());
    	}
    	
    	System.out.print(TriMap + "\n\n");
    	*/
    	/*
    	//Print out digraph
    	for (Map.Entry<String, Integer> entry : DiMap.entrySet()) {
    	     System.out.println(entry.getKey() );
    	}
    	for (Map.Entry<String, Integer> entry : DiMap.entrySet()) {
   	     System.out.println(entry.getValue());
    	}
    	
    	System.out.print(DiMap + "\n\n");
    	*/
       	
    	//Letter Mapping array
    	letterArray[0][0] = "P";
    	letterArray[0][1] = "L";
    	letterArray[0][2] = "A";
    	letterArray[0][3] = "Y";
    	letterArray[0][4] = "F";
    	
    	letterArray[1][0] = "I";
    	letterArray[1][1] = "R";
    	letterArray[1][2] = "E";
    	letterArray[1][3] = "X";
    	letterArray[1][4] = "M";
    	
    	letterArray[2][0] = "B";
    	letterArray[2][1] = "C";
    	letterArray[2][2] = "D";
    	letterArray[2][3] = "G";
    	letterArray[2][4] = "H";
  
    	letterArray[3][0] = "K";
    	letterArray[3][1] = "N";
    	letterArray[3][2] = "O";
    	letterArray[3][3] = "Q";
    	letterArray[3][4] = "S";
  
    	letterArray[4][0] = "T";
    	letterArray[4][1] = "U";
    	letterArray[4][2] = "V";
    	letterArray[4][3] = "W";
    	letterArray[4][4] = "Z";
    	
    	//Testing for printing out key array
    	for (int i=0;i<5;i++){
    		for (int j=0;j<5;j++){
        		System.out.print(letterArray[i][j] + " ");
        	}
    		System.out.print("\n");
    	}	
    }
    
    public static int[] searchArray(String desiredString){
    	int[] results = new int[2];
    	for (int i=0;i<5;i++){
    		for (int j=0;j<5;j++){
    			if(letterArray[i][j].equals(desiredString)){
    				results[0]=i;
    				results[1]=j;
    			}
    		}
    	}
    	//System.out.print(results[0]+""+results[1]+"\n");
    	return results;
    }

	public static double quadgramScore(String text){
		String fileName = "english_quadgrams.txt";
		String line = null;
		String textSplitBy = " ";
		
		//Create map for quadgrams
		TreeMap<String, Double> quadgramMap = new TreeMap<String, Double>();
    	String key[];
    	double totalKey = 0;
    	double quadgramFloor=0;
    	
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	key =  line.split(textSplitBy);
            	
            	if(quadgramMap.get(key[0])==null){
            		quadgramMap.put(key[0],Double.parseDouble(key[1]));
            		totalKey += Double.parseDouble(key[1]);  
        		}
            }
            //Calculate Log possibilities.
            double keyVal = 0;
            for (Map.Entry<String, Double> entry : quadgramMap.entrySet()) {
          	   //System.out.println(entry.getKey()); 
          	   keyVal = Math.log10(entry.getValue()/totalKey);
          	  
          	   quadgramMap.put(entry.getKey(), keyVal);
           	}
            
            quadgramFloor = Math.log10(0.01/totalKey);
            
                       // Always close files.
            bufferedReader.close();         
		}
		 catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
		//do scoring 
        double score=0;
      
        for (int i=0;i<text.length()-3;i++){
        	for (Map.Entry<String, Double> entry : quadgramMap.entrySet()) {
        		if(text.substring(i,i+4).equals(entry.getKey())){
        			score += entry.getValue();
        			
        		}
        		else{
        			score += quadgramFloor;
        		}
        	}
        		
        }       
        return score;
               
	}
	
	
	
	public static String decrypter(String text) {
		//Decrypter
		int[] a_results = new int[2];
    	int[] b_results = new int[2];
    	String plainText = "";
    	for(int i=0;i<text.length();i=i+2){
    		a_results = searchArray(text.substring(i, i+1));
    		//System.out.print(a_results[0]+""+a_results[1]+"\n");
    		b_results = searchArray(text.substring(i+1, i+2));
    		//System.out.print(b_results[0]+""+b_results[1]+"\n");
    		//Check if row or column
    		//Checking if row is same
    		
    		if(a_results[0] == b_results[0]){
    			//If row is same, shift left
    			a_results[1] = (a_results[1]+4)%5;
    			b_results[1] = (b_results[1]+4)%5;
    		}
    		else if(a_results[1] == b_results[1]){
    			//If column is same, shift up
    			a_results[0] = (a_results[0]+4)%5;
    			b_results[0] = (b_results[0]+4)%5;
    		}
    		else{
    			//In rectangle shape
    			int temp;
    			temp = a_results[1];
    			a_results[1]=b_results[1];
    			b_results[1]=temp;
    		}
    		
    		plainText = plainText + letterArray[a_results[0]][a_results[1]];
    		plainText = plainText + letterArray[b_results[0]][b_results[1]];
    	}
    	
    	//System.out.print(plainText + "\n");
    	return plainText;
	}

	public static void swapRandom(){
		int row1 = (int) ((Math.random()*100)%5);
		int row2 = (int) ((Math.random()*100)%5);
		while(row1==row2){
			row2 = (int) ((Math.random()*100)%5);
		}
		int col1 = (int) ((Math.random()*100)%5);
		int col2 = (int) ((Math.random()*100)%5);
		while(col1==col2){
			col2 = (int) ((Math.random()*100)%5);
		}
		String temp1 = letterArray[row1][col1];
		String temp2 = letterArray[row2][col2];
		letterArray[row1][col1]=temp2;
		letterArray[row2][col2]=temp1;
	}		

	public static double playfairDecrypter(String text){
		double parentScore;double childScore;double maxScore = -99e99; double dF;double bestScore;
    	double prob;
    	String[][] parentArray = new String[5][5];
    	parentArray = letterArray;
    	bestArray=parentArray;
    
    	String plainText = decrypter(text);
    	
    	parentScore = quadgramScore(plainText);
    	
    	bestScore = parentScore;
    	
    	for (temp=20;temp>=0;temp=temp-step){
    		for (int count = 10000 ; count>0 ; count--){
    			swapRandom();
    			plainText = decrypter(text);
    			childScore = quadgramScore(plainText);
    			dF = childScore-parentScore;
    			if (dF >= 0){
    				parentScore = childScore;
    				parentArray = letterArray;
    			}
    			else if (temp>0) {
    				prob = Math.exp(dF/temp);
    				if(prob > Math.random()){
                        parentScore = childScore;
        				parentArray = letterArray; 
                    }
    			}
    			if (parentScore > bestScore){
    				bestScore = parentScore;
    				bestArray=parentArray;
    			}
    		}
    	}
    	return bestScore;
	}
}
