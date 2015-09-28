import java.util.Random;
public class Q3 {
	public static void main (String[] args) {
    	//CRC32 function
		int crcX = 0; int crcY = 0; int x = 0; int y = 0;
		System.out.print("Question 3 \n");
		Boolean finish = false;
		Random randomGenerator = new Random();
		while(finish != true){
			x = randomGenerator.nextInt((Integer.MAX_VALUE));
			y = randomGenerator.nextInt((Integer.MAX_VALUE));
			
			crcX=crcHash(Integer.toString(x));
			crcY=crcHash(Integer.toString(y));
			if (crcY == crcX && x != y){
				System.out.println("xCRC32 (via direct calculation) = " + Integer.toHexString(crcX) + "\n");		
				System.out.print("x string: " +x+ "\n");
				
				System.out.println("yCRC32 (via direct calculation) = " + Integer.toHexString(crcY) + "\n");		
				System.out.print("y string: " +y+ "\n");
				finish = true;
			}
		}
		
		System.out.print("Done");
		
    }
	public static Integer crcHash(String desiredString){
		byte[] bytes = desiredString.getBytes();
		int crc  = 0xFFFFFFFF;  
        int poly = 0xEDB88320;

        for (byte b : bytes) {
            int temp = (crc ^ b) & 0xff;

            // read 8 bits one at a time
            for (int i = 0; i < 8; i++) {
                if ((temp & 1) == 1) temp = (temp >>> 1) ^ poly;
                else                 temp = (temp >>> 1);
            }
            crc = (crc >>> 8) ^ temp;
        }

        // flip bits
        crc = crc ^ 0xffffffff;
        return crc;
	}
}


