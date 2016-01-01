package room517.asm.interpreter.cmd;

import java.io.IOException;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class int_21 extends cmd {
    void func_ah1()
    {
        char ch = 0;
        try {
            System.out.println("请输入一个字符，然后按回车键...");
            ch = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reg.set("al", (int)ch);
    }
    void func_ah2()
    {
        System.out.print((char)reg.get("dl"));
    }
    void func_ah3()
    {
        System.out.print(reg.get("dl"));
    }
    @Override
    public void func() {
        if (reg.get("ah") == 1) {
            func_ah1();
        }
        else if (reg.get("ah") == 2) {
            func_ah2();
        }
        else if (reg.get("ah") == 3) {
            func_ah3();
        }
    }
}
