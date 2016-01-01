package room517.asm.interpreter.register;



/**
 * Created by Henry on 2015/12/31.
 *
 */
public class Register {
    public final static String regName[] = {"ax", "bx", "cx", "dx",
                                          "ah", "al", "bh", "bl",
                                          "ch", "cl", "dh", "dl"};
    static long[] regValue = {0, 0, 0, 0};

    public enum OpeType{
        add, sub, and, or, xor, not, neg, mul16, mul32, imul16, imul32, div16, div32, idiv16, idiv32
    }

    static long[] flagsFrom = {-1, -1};
    static OpeType type = null;

    public static void setFlags(long left, long right, OpeType _type)
    {
        flagsFrom[0] = left;
        flagsFrom[1] = right;
        type = _type;
    }

    public static long[] getFlagsFrom()
    {
        return flagsFrom;
    }

    public static void set(String reg_name, long setValue)
    {
        if(reg_name.charAt(1) == 'l')
        {
            for(int i = 0; i < regValue.length; i ++)
            {
                if(reg_name.charAt(0) == regName[i].charAt(0))
                {
                    setValue = 0x00000FFFFL & setValue;
                    regValue[i] = 0x0FFFF0000L & regValue[i];
                    regValue[i] = setValue | regValue[i];
                    break;
                }
            }
        }else if(reg_name.charAt(1) == 'h'){
            for(int i = 0; i < regValue.length; i ++)
            {
                if(reg_name.charAt(0) == regName[i].charAt(0))
                {
                    setValue = 0x00000FFFFL & setValue;
                    setValue = setValue << 16;
                    regValue[i] = 0x00000FFFFL & regValue[i];
                    regValue[i] = setValue | regValue[i];
                    break;
                }
            }
        }else{
            for(int i = 0; i < regValue.length; i ++)
            {
                if(reg_name.charAt(0) == regName[i].charAt(0))
                {
                    regValue[i] = setValue;
                    break;
                }
            }
        }
    }

    public static long get(String reg_name)
    {
        if(reg_name.charAt(1) == 'l')
        {
            for(int i = 0; i < regValue.length; i ++)
            {
                if(reg_name.charAt(0) == regName[i].charAt(0))
                {
                    return regValue[i] & 0x000000000000FFFFL;
                }
            }
        }else if(reg_name.charAt(1) == 'h'){
            for(int i = 0; i < regValue.length; i ++)
            {
                if(reg_name.charAt(0) == regName[i].charAt(0))
                {
                    long tmp = regValue[i] & 0x0000000FFFF0000L;
                    tmp = tmp >> 16;
                    return tmp;
                }
            }
        }else{
            for(int i = 0; i < regValue.length; i ++)
            {
                if(reg_name.charAt(0) == regName[i].charAt(0))
                {
                    return regValue[i] & 0x0000000FFFFFFFFL;
                }
            }
        }
        System.err.println(reg_name+"寄存器不存在!");
        System.exit(-1);
        return -1;
    }

}
