import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Snakeladder extends JFrame{
//Image i1;
JButton b1;
JTextField t1;
JButton b2;
JButton player1;
JButton player2;
JPanel p;
int Xpixel1=0,Ypixel1=350;
int Xpixel2=0,Ypixel2=365;
int randno=3,buttonpress1=0,buttonpress2=0,firsttime1=1,firsttime2=1;
public Snakeladder(){
setTitle("Snake Ladder");
//setSize(1800,1800);
setResizable(true);
setLayout(null);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
p=new JPanel();
add(p);
t1=new JTextField("hello");
b1=new JButton("p1");
b2=new JButton("p2");
add(t1);
add(b2);
add(b1);
t1.setBounds(480,30,80,25);
b1.setBounds(650,30,25,25);
b2.setBounds(650,80,25,25);
b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
int randnoold=randno;
buttonpress2=0;
randno=1;/*1+(int)(Math.random()*6);*/
t1.setText(Integer.toString(randno));
if(firsttime1!=1 || randno==1){
buttonpress1++;
firsttime1++;
if(buttonpress1==1 || randnoold==1){
new Thread(){
public void run(){
int Xfinal,Yfinal,dx=1,i=0;
Xfinal=((Integer.parseInt(t1.getText())*38)+Xpixel1);
Yfinal=Ypixel1;
while(Xpixel1!=Xfinal){
Xpixel1+=dx;
i++;
player1.setBounds(Xpixel1,Ypixel1,10,10);
try{
Thread.sleep(17);}
catch(InterruptedException e){
System.out.println("Thread Exception");
}
if(Xpixel1>384){
Xpixel1=0;
Ypixel1-=38;
Xfinal=((Integer.parseInt(t1.getText())*39)-i);}
}
if(Xpixel1>=76 && Xpixel1<114){
if(Ypixel1==350){
new Thread(){
public void run(){
int Xfinal,Yfinal,dx=1;
Xfinal=0;
Yfinal=160;
while(Xpixel1!=Xfinal){
Xpixel1-=dx;
Ypixel1=(int)(1.67*(Xpixel1-114)+350);
player1.setBounds(Xpixel1,Ypixel1,10,10);
try{
Thread.sleep(17);}
catch(InterruptedException e){
System.out.println("Thread Exception");
}}
}
}.start();
}}
}
}.start();
}
}
}
});

b2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
int randnoold=randno;
buttonpress1=0;
randno=1+(int)(Math.random()*6);
t1.setText(Integer.toString(randno));
if(firsttime2!=1 || randno==1){
buttonpress2++;
firsttime2++;
if(buttonpress2==1 || randnoold==1){
new Thread(){
public void run(){
int Xfinal,Yfinal,dx=1,i=0;
Xfinal=((Integer.parseInt(t1.getText())*38)+Xpixel2);
Yfinal=Ypixel2;
while(Xpixel2!=Xfinal){
Xpixel2+=dx;
i++;
player2.setBounds(Xpixel2,Ypixel2,10,10);
try{
Thread.sleep(17);}
catch(InterruptedException e){
System.out.println("Thread Exception");
}
if(Xpixel2>384){
Xpixel2=0;
Ypixel2-=38;
Xfinal=((Integer.parseInt(t1.getText())*38)-i);}
}
}
}.start();
if(Xpixel2>=114){
if(Ypixel2==350){
new Thread(){
public void run(){
int Xfinal,Yfinal,dx=1;
Xfinal=0;
Yfinal=160;
while(Xpixel2!=Xfinal){
Xpixel2-=dx;
Ypixel2=(int)(1.67*(Xpixel2-114)+350);
player2.setBounds(Xpixel2,Ypixel2,10,10);
try{
Thread.sleep(17);}
catch(InterruptedException e){
System.out.println("Thread Exception");
}}
}
}.start();
}}
}
}
}
});
p.setLayout(new BorderLayout());
JLabel Background=new JLabel(new ImageIcon("Snakeladder.jpg"));
p.add(Background);
p.setBounds(20,20,384,384);
Background.setLayout(null);

/*try{
i1=Toolkit.getDefaultToolkit.getImage("cake.jpg");
}*/
player1=new JButton();
Background.add(player1);
player1.setBounds(0,350,10,10);
player1.setBackground(Color.red);

player2=new JButton();
Background.add(player2);
player2.setBounds(0,365,10,10);
player2.setBackground(Color.green);


setSize(399,399);
setSize(400,400);
}


public static void main(String arg[])
{

Snakeladder sl=new Snakeladder();
}
}
