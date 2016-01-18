package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public abstract class Command {
    static CmdBuffer label_buf = null;
    String operStr1;
    String operStr2;
    public static void set_buffer(CmdBuffer b)
    {
        if (label_buf == null)
            label_buf = b;
    }
    public abstract void func();
    public static boolean is_reg(String word)
    {
        for(String i:Register.regName)
        {
            if(i.equals(word))
            {
                return true;
            }
        }
        return false;
    }

    public static long str_to_long(String num_str)
    {
        if(num_str.startsWith("'") && num_str.endsWith("'") && num_str.length() > 2)
        {
            return num_str.charAt(1);
        }else if(num_str.isEmpty() || num_str.equals(""))
        {
            return -1;
        }else{
            try{
                return Long.decode(num_str);
            }catch (NumberFormatException e)
            {
                System.err.println("\n无法解析的符号:"+num_str);
                System.exit(-1);
            }
        }
        return -1;
    }
}
