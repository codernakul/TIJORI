class Password
{
    static int number()
    {
        return (int)Math.round(Math.random()*9);
    }

    static char symbol()
    {
        int i=(int)Math.round(Math.random()*3);
        if(i==1)
            return '!';
        if(i==2)
            return '#';
        if(i==3)
            return '_';
        else
            return '&';
    }

    static char upper()
    {
        int c=1,s=0;
        while(c<=3)
        {
            ++c;
            s+=(int)Math.round(Math.random()*10);
        }
        if(s>25)
            s=s-5;
        return (char)(s+65);
    }

    static char lower()
    {
        int c=1,s=0;
        while(c<=3)
        {
            ++c;
            s+=(int)Math.round(Math.random()*10);
        }
        if(s>25)
            s=s-5;
        return (char)(s+97);
    }

    static int type(char ch)
    {
        if(Character.isLowerCase(ch))
            return 0;
        else if(Character.isUpperCase(ch))
            return 1;
        else if(Character.isDigit(ch))
            return 2;
        else
            return 3;
    }

    static String cPW()
    {
        String pw="";
        int ch=0;
        pw=pw+lower();
        while(pw.length()<Length.length())
        {
            while(type(pw.charAt(pw.length()-1))==ch)
                ch=(int)Math.round(Math.random()*3);
            if(ch==0)
                pw=pw+lower();
            if(ch==1)
                pw=pw+upper();
            if(ch==2)
                pw=pw+number();
            if(ch==3)
                pw=pw+symbol();
            //System.out.println(pw);
        }
        return pw;
    }
}