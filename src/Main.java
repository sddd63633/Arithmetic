import java.util.Scanner;

import static java.lang.Integer.*;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        int N=5;
        int i=0;
        int T=0,F=0;

        Main it=new Main();

        Scanner input=new Scanner(System.in);
        System.out.println("Please enter the number of questions you want to do");
        N=input.nextInt();


        while(i<N){

            int num = (int)(Math.random()*7);
            //int num = 2;
            i++;
            switch (num){
                case 0:
                    if(it.add()){T++;}
                    else{F++;}
                    break;
                case 1:
                    if(it.sub()){T++;}
                    else{F++;}
                    break;
                case 2:
                    if(it.mul()){T++;}
                    else{F++;}
                    break;
                case 3:
                    if (!it.div()) {F++;} else {T++;}
                    break;
                case 4:
                    if(it.tadd()){T++;}
                    else F++;
                    break;
                case 5:
                    if(it.tsub()){T++;}
                    else{F++;}
                    break;
                case 6:
                    if(it.tmul()){T++;}
                    else{F++;}
                    break;
                case 7:
                    if(it.tdiv()){T++;}
                    else{F++;}
                    break;
            }
        }
        System.out.println("You're right question "+T+" items.");
        System.out.println("You answer wrong "+F+" items.");
        float an = (float) T/N;
        System.out.println("Your accuracy is "+an*100+"%.");
    }


    @SuppressWarnings("resource")
    private boolean div() {
        int a = (int)(Math.random()*10)+1;
        int b = (int)(Math.random()*10)+1;
        String d1 = a+"/"+b;

        d1=Economize(d1);
        Double d2= (double)a/b;
        Integer d3=a/b;
        System.out.print(a+" / "+b+"=");
        Scanner input=new Scanner(System.in);
        String c1 =  input.next();

        if(c1.indexOf('/')!=-1){
            c1=Economize(c1);
            if(c1.equals(d1)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else if(c1.indexOf('q')!=-1){
            System.exit(0);
            return false;
        } else if(c1.indexOf('.')!=-1){
            if(c1.equals(d2.toString())){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else{
            if(c1.equals(d3.toString())){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }

    }







    @SuppressWarnings("resource")
    private boolean add() {
        int a = (int)(Math.random()*10)+1;
        int b = (int)(Math.random()*10)+1;
        int d = a+b;

        System.out.print(a+"+"+b+"=");
        Scanner input=new Scanner(System.in);
        String ch=input.next();
        if(ch.indexOf('q')!=-1){
            System.exit(0);
            return false;
        }else{
            int c = Integer.parseInt(ch);
            if(c==d){
                System.out.println("ture");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }

    }

    @SuppressWarnings("resource")
    private boolean sub() {
        int a = (int)(Math.random()*10)+1;
        int b = (int)(Math.random()*10)+1;
        int d = a-b;

        System.out.print(a+"-"+b+"=");
        Scanner input=new Scanner(System.in);
        String ch=input.next();
        if(ch.indexOf('q')!=-1){
            System.exit(0);
            return false;
        }else{
            int c = Integer.parseInt(ch);
            if(c==d){
                System.out.println("ture");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }
    }


    @SuppressWarnings("resource")
    private boolean mul() {
        int a = (int)(Math.random()*10)+1;
        int b = (int)(Math.random()*10)+1;
        int d = a*b;

        System.out.print(a+"*"+b+"=");
        Scanner input=new Scanner(System.in);
        String ch=input.next();
        if(ch.indexOf('q')!=-1){
            System.exit(0);
            return false;
        }else{
            int c = Integer.parseInt(ch);
            if(c==d){
                System.out.println("ture");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }
    }

    private boolean tadd(){
        int fz1,fm1,fz2,fm2;
        while(true){
            fz1=(int)(Math.random()*10)+1;
            fm1=(int)(Math.random()*10)+1;
            fz2=(int)(Math.random()*10)+1;
            fm2=(int)(Math.random()*10)+1;
            if(fz1<fm1&&fz2<fm2){
                break;
            }
        }
        String fzm1=fz1+"/"+fm1;
        String fzm2=fz2+"/"+fm2;
        fzm1=Economize(fzm1);
        fzm2=Economize(fzm2);

        System.out.print("("+fzm1+")"+"+"+"("+fzm2+")"+"=");
        int tempfm = fm1*fm2;
        int tempfz = fz1*fm2+fz2*fm1;
        int max = tempfm;
        String answer="";
        String answer1="";
        Double answer2=0.0;

        if(tempfm<tempfz){
            max=getmax(tempfz,tempfm);
        }else if(tempfm>tempfz){
            max=getmax(tempfm,tempfz);
        }else{
            answer="1";
        }
        tempfz=tempfz/max;
        tempfm=tempfm/max;
        if(0==tempfz%tempfm){
            Integer s=tempfz/tempfm;
            answer=s.toString();
        }else{
            answer1=tempfz+"/"+tempfm;
            answer2=(double) tempfz/tempfm;
        }

        Scanner input=new Scanner(System.in);
        String reanswer = input.next();

        if(reanswer.indexOf('/')!=-1){
            reanswer = Economize(reanswer);
            if(reanswer.equals(answer1)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else if(reanswer.indexOf('q')!=-1){
            System.exit(0);
            return false;
        }else if(reanswer.indexOf('.')!=-1){
            if(reanswer.equals(answer2.toString())){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else{
            if(reanswer.equals(answer)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }
    }


    private boolean tsub() {
        int fz1,fm1,fz2,fm2;
        while(true){
            fz1=(int)(Math.random()*10)+1;
            fm1=(int)(Math.random()*10)+1;
            fz2=(int)(Math.random()*10)+1;
            fm2=(int)(Math.random()*10)+1;
            if(fz1<fm1&&fz2<fm2){
                break;
            }
        }
        String fzm1=fz1+"/"+fm1;
        String fzm2=fz2+"/"+fm2;
        fzm1=Economize(fzm1);
        fzm2=Economize(fzm2);

        System.out.print("("+fzm1+")"+"-"+"("+fzm2+")"+"=");
        int tempfm = fm1*fm2;
        int tempfz = fz1*fm2-fz2*fm1;
        int max = tempfm;
        String answer="";
        String answer1="";
        Double answer2=0.0;

        if(tempfm<tempfz){
            max=getmax(tempfz,tempfm);
        }else if(tempfm>tempfz){
            max=getmax(tempfm,tempfz);
        }else{
            answer="1";
        }
        tempfz=tempfz/max;
        tempfm=tempfm/max;
        if(0==tempfz%tempfm){
            Integer s=tempfz/tempfm;
            answer=s.toString();
        }else{
            answer1=tempfz+"/"+tempfm;
            answer2=(double) tempfz/tempfm;
        }

        Scanner input=new Scanner(System.in);
        String reanswer = input.next();

        if(reanswer.indexOf('/')!=-1){
            reanswer=Economize(reanswer);
            if(reanswer.equals(answer1)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else if(reanswer.indexOf('q')!=-1){
            System.exit(0);
            return false;
        }else if(reanswer.indexOf('.')!=-1){
            if(reanswer.equals(answer2.toString())){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else{
            if(reanswer.equals(answer)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }
    }

    private boolean tmul() {
        int fz1,fm1,fz2,fm2;
        while(true){
            fz1=(int)(Math.random()*10)+1;
            fm1=(int)(Math.random()*10)+1;
            fz2=(int)(Math.random()*10)+1;
            fm2=(int)(Math.random()*10)+1;
            if(fz1<fm1&&fz2<fm2){
                break;
            }
        }
        String fzm1=fz1+"/"+fm1;
        String fzm2=fz2+"/"+fm2;
        fzm1=Economize(fzm1);
        fzm2=Economize(fzm2);

        System.out.print("("+fzm1+")"+"*"+"("+fzm2+")"+"=");
        int tempfm = fm1*fm2;
        int tempfz = fz1*fz2;
        int max = tempfm;
        String answer="";
        String answer1="";
        Double answer2=0.0;

        if(tempfm<tempfz){
            max=getmax(tempfz,tempfm);
        }else if(tempfm>tempfz){
            max=getmax(tempfm,tempfz);
        }else{
            answer="1";
        }
        tempfz=tempfz/max;
        tempfm=tempfm/max;
        if(0==tempfz%tempfm){
            Integer s=tempfz/tempfm;
            answer=s.toString();
        }else{
            answer1=tempfz+"/"+tempfm;
            answer2=(double) tempfz/tempfm;
        }

        Scanner input=new Scanner(System.in);
        String reanswer = input.next();

        if(reanswer.indexOf('/')!=-1){
            reanswer=Economize(reanswer);
            if(reanswer.equals(answer1)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else if(reanswer.indexOf('q')!=-1){
            System.exit(0);
            return false;
        }else if(reanswer.indexOf('.')!=-1){
            if(reanswer.equals(answer2.toString())){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else{
            if(reanswer.equals(answer)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }
    }

    private boolean tdiv() {
        int fz1,fm1,fz2,fm2;
        while(true){
            fz1=(int)(Math.random()*10)+1;
            fm1=(int)(Math.random()*10)+1;
            fz2=(int)(Math.random()*10)+1;
            fm2=(int)(Math.random()*10)+1;
            if(fz1<fm1&&fz2<fm2){
                break;
            }
        }
        String fzm1=fz1+"/"+fm1;
        String fzm2=fz2+"/"+fm2;
        fzm1=Economize(fzm1);
        fzm2=Economize(fzm2);

        System.out.print("("+fzm1+")"+"/"+"("+fzm2+")"+"=");
        int tempfm = fm1*fz2;
        int tempfz = fz1*fm2;
        int max = tempfm;
        String answer="";
        String answer1="";
        Double answer2=0.0;

        if(tempfm<tempfz){
            max=getmax(tempfz,tempfm);
        }else if(tempfm>tempfz){
            max=getmax(tempfm,tempfz);
        }else{
            answer="1";
        }
        tempfz=tempfz/max;
        tempfm=tempfm/max;
        if(0==tempfz%tempfm){
            Integer s=tempfz/tempfm;
            answer=s.toString();
        }else{
            answer1=tempfz+"/"+tempfm;
            answer2=(double) tempfz/tempfm;
        }

        Scanner input=new Scanner(System.in);
        String reanswer = input.next();

        if(reanswer.indexOf('/')!=-1){
            reanswer=Economize(reanswer);
            if(reanswer.equals(answer1)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else if(reanswer.indexOf('q')!=-1){
            System.exit(0);
            return false;
        }else if(reanswer.indexOf('.')!=-1){
            if(reanswer.equals(answer2.toString())){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }else{
            if(reanswer.equals(answer)){
                System.out.println("true");
                return true;
            }else{
                System.out.println("false");
                return false;
            }
        }
    }



    private static int getmax(int divisor, int dividend) {
        try{
            int remainder=divisor%dividend;
            boolean i=true;
            if(remainder==0){
                i=false;
            }
            while(i){
                divisor=dividend;
                dividend=remainder;
                remainder=divisor%dividend;
                if(remainder==0){
                    i=false;
                }
            }

        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        return dividend;
    }

    private static String Economize(String ch){
        int sign=ch.indexOf('/');

        Integer fz=1;Integer fm=1;
        String fzz = ch.substring(0,sign);
        String fmm = ch.substring(sign+1);
        try {
            fz = Integer.parseInt(fzz);
            fm = Integer.parseInt(fmm);
            if(fm==0){
                System.out.println("syntax error");
                return "***";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int max=getmax(fz,fm);

        String Newch;
        Newch = (fz/max)+"/"+(fm/max);

        return Newch;

    }

}


