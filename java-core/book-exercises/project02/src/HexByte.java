public class HexByte {
    public static void main(String[] args) {
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a','b','c','d','e','f'};

        byte b = (byte) 0xf1;
        System.out.println(b & 0x0f);
        byte c = (byte) (b>>4);
        System.out.println(Integer.toHexString(c));
        byte d = (byte)(b>>>4);
        byte e = (byte) ((b & 0xff) >>4);

        System.out.println("b = 0x" + hex[(b >>4) & 0x0f] + hex[b & 0x0f]);
        System.out.println(" b >> 4 = 0x" + hex[(c >>4) & 0x0f] + hex[c & 0x0f]);
        System.out.println(" b >>> 4 = 0x" + hex[(d >>4) & 0x0f] + hex[d & 0x0f]);
        int v = 1;
        System.out.println(v | 4);
        int s , y , bb;
        s=y=bb=100;
        System.out.println(s + y + bb);
    }
}
