package room517.asm.interpreter.register;



/**
 * Created by Henry on 2015/12/31.
 *
 */
public class Register {
    public final static String name[] = {"ah", "al", "bh", "bl", "dh", "dl", "cx"};
    public final static String name2[] = {"ax", "bx", "cx", "dx",
                                          "ah", "al", "bh", "bl", "ch", "cl", "dh", "dl"};
    static int value[] = {0, 0, 0, 0, 0, 0, 0};
    static int value2[] = {0, 0, 0, 0};


//    public void set(String reg_name, int setValue)
//    {
//        System.out.println("setValue:"+setValue);
//        System.out.println(reg_name+":"+get(reg_name));
//        if(reg_name.charAt(1) == 'l')
//        {
//            for(int i = 0; i < value2.length; i ++)
//            {
//                if(reg_name.charAt(0) == name2[i].charAt(0))
//                {
//                    setValue = 0x00FF & setValue;
//                    value2[i] = 0xFF00 & value2[i];
//                    value2[i] = setValue & value2[i];
//                    break;
//                }
//            }
//        }else if(reg_name.charAt(1) == 'h'){
//            for(int i = 0; i < value2.length; i ++)
//            {
//                if(reg_name.charAt(0) == name2[i].charAt(0))
//                {
//                    setValue = 0xFF00 & setValue;
//                    value2[i] = 0x00FF & value2[i];
//                    value2[i] = setValue & value2[i];
//                    break;
//                }
//            }
//        }else{
//            for(int i = 0; i < value2.length; i ++)
//            {
//                if(reg_name.charAt(0) == name2[i].charAt(0))
//                {
//                    value2[i] = setValue;
//                    break;
//                }
//            }
//        }
//    }
//
//    public int get(String reg_name)
//    {
//        if(reg_name.charAt(1) == 'l')
//        {
//            for(int i = 0; i < value2.length; i ++)
//            {
//                if(reg_name.charAt(0) == name2[i].charAt(0))
//                {
//                    return value2[i] & 0x00FF;
//                }
//            }
//        }else if(reg_name.charAt(1) == 'h'){
//            for(int i = 0; i < value2.length; i ++)
//            {
//                if(reg_name.charAt(0) == name2[i].charAt(0))
//                {
//                    int tmp = value2[i] & 0xFF00;
//                    tmp = tmp >> 16;
//                    return tmp;
//                }
//            }
//        }else{
//            for(int i = 0; i < value2.length; i ++)
//            {
//                if(reg_name.charAt(0) == name2[i].charAt(0))
//                {
//                    return value2[i];
//                }
//            }
//        }
//        System.err.println(reg_name+"寄存器不存在!");
//        return -1;
//    }

    public void set(String reg_name, int setValue)
    {
        for(int i = 0; i < name.length; i ++)
        {
            if(reg_name.equals(name[i]))
            {
                value[i] = setValue;
                break;
            }
        }
    }
    public int get(String reg_name)
    {
        for(int i = 0; i < name.length; i ++)
        {
            if(reg_name.equals(name[i]))
            {
                return value[i];
            }
        }
        System.err.println(reg_name+"寄存器不存在!");
        return -1;
    }
}
