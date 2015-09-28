
public class CRC32 {
	public static void main (String[] args) {
    	//CRC32 function
		String studentNumberMD5 = "F415CFD06E23A34A5346CF697959E1AE";
	
		int crcX = 0; int crcY = 0;
		crcX = crcHash(studentNumberMD5);
		System.out.println("CRC32 (via direct calculation) = " + Integer.toHexString(crcX));		
		
		for(int i = 0;i<Integer.MAX_VALUE;i++){
			crcY=crcHash(Integer.toString(i));
			if (crcY == crcX){
				System.out.println("yCRC32 (via direct calculation) = " + Integer.toHexString(crcY) + "\n");		
				System.out.print("y string: " +i+ "\n");
			}
		}
		for(int i = 0;i<Integer.MAX_VALUE;i++){
			crcY=crcHash(Integer.toString(-i));
			if (crcY == crcX){
				System.out.println("yCRC32 (via direct calculation) = " + Integer.toHexString(crcY) + "\n");		
				System.out.print("y string: " +-i+ "\n");
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
