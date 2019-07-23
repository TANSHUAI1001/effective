package encryption;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shuaitan
 * 2019-07-20
 * 参考链接：https://blog.csdn.net/a344288106/article/details/80094878
 * 参考文档：https://wenku.baidu.com/view/8d67d80178563c1ec5da50e2524de518964bd3b6.html
 */
public class GmsslHash {

    private static boolean isLittleEndian(){
        return false;
    }

    public static int reverseWord(byte msg0,byte msg1, byte msg2,byte msg3){
        int reverse;
        int []bytes = new int[4];
        bytes[0] = (0x000000ff & msg3) << 24;
        bytes[1] = (0x0000ff00 & (msg2 << 8)) << 8;
        bytes[2] = (0x00ff0000 & (msg1 << 16)) >> 8;
        bytes[3] = (0xff000000 & (msg0 << 24)) >>> 24;
        reverse = bytes[0] | bytes[1] | bytes[2] | bytes[3];
        return reverse;
    }

    public static int reverseWord(int word){
        int reverse;
        int []bytes = new int[4];
        bytes[0] = (0x000000ff & word) << 24;
        bytes[1] = (0x0000ff00 & word) << 8;
        bytes[2] = (0x00ff0000 & word) >> 8;
        bytes[3] = (0xff000000 & word) >>> 24;
        reverse = bytes[0] | bytes[1] | bytes[2] | bytes[3];
        return reverse;
    }

    public static byte[] LongToBytes(long values) {
        byte[] buffer = new byte[8];
        for (int i = 0; i < 8; i++) {
            int offset = 64 - (i + 1) * 8;
            buffer[i] = (byte) ((values >> offset) & 0xff);
        }
        return buffer;
    }

    public static int BytesToInt(byte msg0,byte msg1, byte msg2,byte msg3){
        int []bytes = new int[4];
        bytes[0] = msg0 << 24;
        bytes[1] = 0x00ff0000 & (msg1 << 16);
        bytes[2] = 0x0000ff00 & (msg2 << 8);
        bytes[3] = (0x000000ff & msg3);
        return bytes[0] | bytes[1] | bytes[2] | bytes[3];
    }

    // 常量
    private static int T(int i){
        if(i >= 0 && i <= 15){
            return 0x79CC4519;
        }else if(i >= 16 && i <= 63){
            return 0x7A879D8A;
        }else{
            return 0;
        }
    }

    // 布尔函数
    private static int FF(int X, int Y, int Z, int j){
        if (j >= 0 && j <= 15)
            return X ^ Y ^ Z;
        else if (j >= 16 && j <= 63)
            return (X & Y) | (X & Z) | (Y & Z);
        else
            return 0;
    }
    private static int GG(int X, int Y, int Z, int j){
        if (j >= 0 && j <= 15)
            return X ^ Y ^ Z;
        else if (j >= 16 && j <= 63)
            return (X & Y) | (~X & Z);
        else
            return 0;
    }

    //循环左移
    private static int LoopLeftShift(int word,int bits){
        return (word) << (bits) | (word) >>> (32 - (bits));
    }

    //置换函数
    private static int P0(int X){
        return X ^ LoopLeftShift(X, 9) ^ LoopLeftShift(X, 17);
    }
    private static int P1(int X){
        return X ^ LoopLeftShift(X, 15) ^ LoopLeftShift(X, 23);
    }


    // 初始值
    private int[] IV = {
            0x7380166F,0x4914B2B9,0x172442D7,0xDA8A0600,
            0xA96F30BC,0x163138AA,0xE38DEE4D,0xB0FB0E4E
    };

    /**
     * 填充
     * 迭代压缩
     * 1. 迭代过程
     * 2. 消息扩展
     * 3. 压缩函数
      */

    private void SM3ProcessMessageBlock(int[] word){
        int[] W = new int[68];
        int[] W1 = new int [64];
        int i;
        int A, B, C, D, E, F, G, H, SS1, SS2, TT1, TT2;

        // 消息扩展
        for(i = 0; i < 16; i++){
            W[i] = word[i];
        }
        for(i = 16; i < 68; i++){
            W[i] = P1(W[i - 16] ^ W[i - 9] ^ LoopLeftShift(W[i - 3], 15))
                    ^ LoopLeftShift(W[i - 13], 7)
                    ^ W[i - 6];
        }
        for(i = 0; i < 64; i++){
            W1[i] = W[i] ^ W[i + 4];
        }

        // 消息压缩
        A = IV[0];
        B = IV[1];
        C = IV[2];
        D = IV[3];
        E = IV[4];
        F = IV[5];
        G = IV[6];
        H = IV[7];

        for (i = 0; i < 64; i++){
            SS1 = LoopLeftShift((LoopLeftShift(A, 12) + E + LoopLeftShift(T(i), i%32)), 7);
            SS2 = SS1 ^ LoopLeftShift(A, 12);
            TT1 = FF(A, B, C, i) + D + SS2 + W1[i];
            TT2 = GG(E, F, G, i) + H + SS1 + W[i];
            D = C;
            C = LoopLeftShift(B, 9);
            B = A;
            A = TT1; // error in i = 15
            H = G;
            G = LoopLeftShift(F, 19);
            F = E;
            E = P0(TT2);
        }

        IV[0] ^= A;
        IV[1] ^= B;
        IV[2] ^= C;
        IV[3] ^= D;
        IV[4] ^= E;
        IV[5] ^= F;
        IV[6] ^= G;
        IV[7] ^= H;

    }

    private void SM3Calculate(byte[] message){
        long messageLen = message.length;
        int i;
        int[] word = new int[16];
        // 512bit一组，即64byte / 4 byte = 16个int(word)
        int n = (int) (messageLen / 64);
        for (i = 0; i < n*64; i += 4) {
            if(isLittleEndian()){
                word[(i/4)%16] = reverseWord(message[i],message[i+1],message[i+2],message[i+3]);
            }else{
                word[(i/4)%16] = BytesToInt(message[i], message[i+1], message[i+2], message[i+3]);
            }
            if((i/4)%16 == 15) {
                SM3ProcessMessageBlock(word);
            }
        }

        // 填充
        long remainByteLen = messageLen % 64;
        byte[] lenBytes = LongToBytes(messageLen*8);
        int lenBytesIndex = 0;
        if(remainByteLen <= 55){
            byte[] x_msg = new byte[64];
            for (int j = 0; j < 64; j++) {
                if(j < remainByteLen){
                    x_msg[j] = message[i+j];
                }else if(j == remainByteLen){
                    x_msg[j] = (byte) 0x80;
                }else if(j > 55 ){ // 56 ~ 63
                    x_msg[j] = lenBytes[lenBytesIndex++];
                }else{
                    x_msg[j] = 0;
                }

                if((j+1)%4 == 0){
                    if(isLittleEndian()){
                        word[(j/4)%16] = reverseWord(x_msg[j-3],x_msg[j-2],x_msg[j-1],x_msg[j]);
                    }else{
                        word[(j/4)%16] = BytesToInt(x_msg[j-3],x_msg[j-2],x_msg[j-1],x_msg[j]);
                    }
                }
            }
            SM3ProcessMessageBlock(word);
        }else{
            byte[] x_msg = new byte[128];
            for (int j = 0; j < 128; j++) {
                if(j < remainByteLen){
                    x_msg[j] = message[i+j];
                }else if(j == remainByteLen){
                    x_msg[j] = (byte) 0x80;
                }else if(j >= 120){ // 120 ~ 127
                    x_msg[j] = lenBytes[lenBytesIndex++];
                }else{
                    x_msg[j] = 0;
                }

                if((j+1)%4 == 0){
                    if(isLittleEndian()){
                        word[(j/4)%16] = reverseWord(x_msg[j-3],x_msg[j-2],x_msg[j-1],x_msg[j]);
                    }else{
                        word[(j/4)%16] = BytesToInt(x_msg[j-3],x_msg[j-2],x_msg[j-1],x_msg[j]);
                    }
                }

                if((j+1)%64 == 0){
                    SM3ProcessMessageBlock(word);
                }
            }
        }
    }

    public String SM3Digest(byte[] message){
        StringBuilder result = new StringBuilder();
        SM3Calculate(message);
        for (int value : IV) {
            result.append(Integer.toHexString(value));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        GmsslHash gmHash = new GmsslHash();
//        byte[] array = "abc".getBytes(); //3*8=24bits pass
//        byte[] array = "123456".getBytes(); // 6*8=48bits pass
//        byte[] array = "abcdefg".getBytes(); //7*8=56bits pass
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 2*64+56; i++) { // 55bits,56bits,57bits,64+55=119bits,64+56=120bits,2*64+55=183bits,2*64+56=184bits pass
            s.append(i%9);
        }

        System.out.println(s.toString());
        byte[] array = s.toString().getBytes();
        System.out.println("array len:"+array.length);
        System.out.println(gmHash.SM3Digest(array));

    }

    @Test
    public void testSample1(){ // pass
        byte[] array = {0x61,0x62,0x63};
        Assert.assertEquals("66c7f0f4 62eeedd9 d1f2d46b dc10e4e2 4167c487 5cf2f7a2 297da02b 8f4ba8e0".replace(" ",""),SM3Digest(array));
    }

    @Test
    public void testSample2(){ // pass
        byte[] array = {
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,

                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64,
                0x61,0x62,0x63,0x64
                };
        Assert.assertEquals("debe9ff9 2275b8a1 38604889 c18e5a4d 6fdb70e5 387e5765 293dcba3 9c0c5732".replace(" ",""),SM3Digest(array));
    }
}
