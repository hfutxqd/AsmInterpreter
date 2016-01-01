package room517.asm.interpreter.register;



/**
 * Created by Henry on 2015/12/31.
 *
 */
public class Register {
    public final static String name[] = {"ax", "bx", "cx", "dx",
                                          "ah", "al", "bh", "bl",
                                          "ch", "cl", "dh", "dl"};
    static long[]  value= {0, 0, 0, 0};

    static long[] cmp_buffer = {-1, -1};

    public static void setCmp(long a, long b)
    {
        cmp_buffer[0] = a;
        cmp_buffer[1] = b;
    }

    public static long[] getCmp()
    {
        return cmp_buffer;
    }

    public static void set(String reg_name, long setValue)
    {
        if(reg_name.charAt(1) == 'l')
        {
            for(int i = 0; i < value.length; i ++)
            {
                if(reg_name.charAt(0) == name[i].charAt(0))
                {
                    setValue = 0x00000FFFF & setValue;
                    value[i] = 0x0FFFF0000 & value[i];
                    value[i] = setValue | value[i];
                    break;
                }
            }
        }else if(reg_name.charAt(1) == 'h'){
            for(int i = 0; i < value.length; i ++)
            {
                if(reg_name.charAt(0) == name[i].charAt(0))
                {
                    setValue = 0x00000FFFF & setValue;
                    setValue = setValue << 16;
                    value[i] = 0x00000FFFF & value[i];
                    value[i] = setValue | value[i];
                    break;
                }
            }
        }else{
            for(int i = 0; i < value.length; i ++)
            {
                if(reg_name.charAt(0) == name[i].charAt(0))
                {
                    value[i] = setValue;
                    break;
                }
            }
        }
    }

    public static long get(String reg_name)
    {
        if(reg_name.charAt(1) == 'l')
        {
            for(int i = 0; i < value.length; i ++)
            {
                if(reg_name.charAt(0) == name[i].charAt(0))
                {
                    return value[i] & 0x00000FFFF;
                }
            }
        }else if(reg_name.charAt(1) == 'h'){
            for(int i = 0; i < value.length; i ++)
            {
                if(reg_name.charAt(0) == name[i].charAt(0))
                {
                    long tmp = value[i] & 0x0FFFF0000;
                    tmp = tmp >> 16;
                    return tmp;
                }
            }
        }else{
            for(int i = 0; i < value.length; i ++)
            {
                if(reg_name.charAt(0) == name[i].charAt(0))
                {
                    return value[i];
                }
            }
        }
        System.err.println(reg_name+"寄存器不存在!");
        return -1;
    }

}
