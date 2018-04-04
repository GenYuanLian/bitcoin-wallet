package com.example.myapplication;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class testUpdate {
	

//	static protected int engineDigest(byte[] buf, int offset, int len)
//            throws DigestException {
//
//			byte[] digest = engineDigest();
//			if (len < digest.length)
//			throw new DigestException("partial digests not returned");
//			if (buf.length - offset < digest.length)
//			throw new DigestException("insufficient space in the output "
//			      + "buffer to store the digest");
//			System.arraycopy(digest, 0, buf, offset, digest.length);
//			return digest.length;
//	}
//
//    static void engineUpdate(ByteBuffer var1) {
//        if(var1.hasRemaining()) {
//            int var3;
//            int var4;
//            if(var1.hasArray()) {
//                byte[] var2 = var1.array();
//                var3 = var1.arrayOffset();
//                var4 = var1.position();
//                int var5 = var1.limit();
//                engineUpdate(var2, var3 + var4, var5 - var4);
//                var1.position(var5);
//            } else {
//                int var6 = var1.remaining();
//                var3 = JCAUtil.getTempArraySize(var6);
//                if(tempArray == null || var3 > this.tempArray.length) {
//                    this.tempArray = new byte[var3];
//                }
//
//                while(var6 > 0) {
//                    var4 = Math.min(var6, this.tempArray.length);
//                    var1.get(this.tempArray, 0, var4);
//                    this.engineUpdate(this.tempArray, 0, var4);
//                    var6 -= var4;
//                }
//            }
//
//        }
//    }

	
	public static void make() throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte []input1 = new byte[10];
		
		for(int i = 0;i < input1.length;i++) {
			input1[i] = (byte)i;
		}
		
		byte []input2 = new byte[10];
		for(int i = 0;i < input2.length;i++) {
			input2[i] = (byte)(i+20);
		}
		
//		System.out.println(digest.digest(input1));
//		System.out.println(digest.toString());
//		System.out.println(digest.digest(input2));
//		System.out.println(digest.toString());
		MessageDigest digest1 = MessageDigest.getInstance("SHA-256");
        digest1.update(input1, 0, input1.length);
        System.out.println(digest1.digest());
        digest1.update(input2, 0, input2.length);
        System.out.println(digest1.digest());
       
        System.out.println("--------------------------------------");
    	MessageDigest digest2 = MessageDigest.getInstance("SHA-256");
	    digest2.update(input2, 0, input2.length);
	    System.out.println(digest2.digest());
	    digest2.update(input1, 0, input1.length);
	    
		System.out.println(digest2.digest());
	}

}
