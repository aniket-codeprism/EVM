import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.util.Date;
import javax.sound.sampled.*;
import java.nio.channels.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class ElectonicVotingSystem extends JPanel 
{
       public static JFrame f;
       int cl1=0,cl2=0,cl3=0,cl4=0,cl5=0,cl6=0;
       int count1=0,count2,count3,count4,count5,count6;
       JButton b1,b2,b3,b4,b5,b6,save,reset,display;
       JTextField field;       
       Timer t1,t2,t3,t4,t5,t6,PLAYERTIMER;
       boolean check=false;
       JMenuBar menubar;
       JMenu menu1,menu2,menu3,menu4,menu5;
       JMenu submenu1,submenu2,submenu3,submenu4,submenu5;
       JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20;
       JMenuItem item21,item22,item23,item24,item25,item26,item27;
       JRadioButtonMenuItem item28,item29;
       Clip p1,p2;      
       static String PASSWORD="";
       Color defaultColor;
       GridBagConstraints g;    
       int choice=0;
       String passinp="";
       String option[];
       JPanel plpa;
       JPasswordField passf;
       JLabel passl;
       JDialog dl,dialog;
       int timef=5;
       Date d=new Date();
       String dat;
       static JFrame fr=new JFrame();
       frame frm=new frame();
       String dir=System.getProperty("user.home")+"/Documents/Electonic Voting System";
       static int startup_count=0;
       static Timer startup_timer;
       static Window startup;
       JPanel info;
       static JLabel ini=new JLabel("Initalising....");
       String ext[]=new String[6];
       final static String labels[]={"Preparing Basics","Initalising GUI","Registering Event Listeners","Adding GUI"};
       
       int sizek=500,sizef=500;
       public static void main(String args[])
       {
               PASSWORD=security.getPassword();
            new Thread(new Runnable(){public void run(){new ElectonicVotingSystem().init();}}).start();
            startup=new Window(f);        
            ini.setForeground(Color.RED);
            ini.setFont(new Font("Courier",Font.ITALIC,22));
            startup.add(new win(ini));
            startup.setSize(1000,500);
            startup.setLocation(150,100);
            startup.setBackground(Color.yellow);
            startup.setLayout(new GridLayout());
            startup.setVisible(true);
            startup_timer=new Timer(10,new ActionListener(){public void actionPerformed(ActionEvent e){starty();}});
            startup_timer.start();
        }
        public static void starty(){
            if(startup_count==0)
            {
                ini.setText(labels[0]);
            }
            else if(startup_count==67)
            {
                ini.setText(labels[1]);
            }
            else if(startup_count==67*2)
            {
                ini.setText(labels[2]);
            }
            else if(startup_count==180)
            {
                ini.setText(labels[3]);
            }
            startup_count++;
            if(startup_count==201)
            {
                startup_timer.stop();
                startup.setVisible(false);
                f.setVisible(true);
            }
        }
        public void init()
        {
            writeext(true);
            makedirs();
            f = new JFrame("AC :Electronic Voating Machine");         
            f.setSize(1000,700);    
            f.setIconImage(new ImageIcon("icon.png").getImage());
            f.setLocationRelativeTo(null);
            f.setExtendedState(f.MAXIMIZED_BOTH);
            setLayout(new GridBagLayout());
            g=new GridBagConstraints();
            g.insets=new Insets(12,6,12,6);
            plpa= new JPanel();
            passl= new JLabel("Enter a password(CASE SENSITIVE):");
            passf= new JPasswordField(10);
            plpa.add(passl);
            plpa.add(passf);
            option= new String[]{"OK","Cancel"};
            dl=new JDialog(f,"Congrats");
            String s="     Congratulations ";
            String s2="             You have casted your vote";
            dl.setLayout(new FlowLayout());
            dl.add(new JLabel(s));
            dl.add(new JLabel(s2));
            dat=(d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900)+"/"+getdayname(d.getDay()));
            try{                                
                BufferedReader br=new BufferedReader(new FileReader(dir+"/button names.dat"));
                b1=new JButton(br.readLine());
                b2=new JButton(br.readLine());
                b3=new JButton(br.readLine());
                b4=new JButton(br.readLine());
                b5=new JButton(br.readLine());
                b6=new JButton(br.readLine());
                br.close();
            }
            catch(Exception e)
            {
                b1=new JButton("1");
                b2=new JButton("2");
                b3=new JButton("3");
                b4=new JButton("4");
                b5=new JButton("5");
                b6=new JButton("6");
            }
            field=new JTextField(10);
            reset=new JButton("Reset");
            display=new JButton("Display the Votes");
            menubar=new  JMenuBar();
            menu1=new JMenu("File");
            menu2=new JMenu("View");
            menu3=new JMenu("Edit");
            menu4=new JMenu("Help");
            submenu1=new JMenu("Edit Candidate Profile");
            submenu2=new JMenu("Show Candidates Image");
            submenu3=new JMenu("Edit Candidates Name");
            submenu4=new JMenu("Edit Profile Picture");
            submenu5=new JMenu("Change Mode");
            item1=new  JMenuItem(b1.getText());
            item2=new  JMenuItem(b2.getText());
            item3=new  JMenuItem(b3.getText());
            item4=new  JMenuItem(b4.getText());
            item5=new  JMenuItem(b5.getText()); 
            item6=new  JMenuItem(b6.getText());                             
            item7=new  JMenuItem(reset.getText());                   
            item8=new  JMenuItem("Display the Result"); 
            item9=new JMenuItem("Exit"); 
            item10=new JMenuItem("References");                            
            item11=new JMenuItem("Save The Result");
            item12=new JMenuItem("Review The Last Saved Result");                            
            item13=new JMenuItem("Change Password");
            item14=new  JMenuItem(b1.getText());
            item15=new  JMenuItem(b2.getText());
            item16=new  JMenuItem(b3.getText());
            item17=new  JMenuItem(b4.getText());
            item18=new  JMenuItem(b5.getText()); 
            item19=new  JMenuItem(b6.getText()); 
            item20=new  JMenuItem("Change Duration");                             
            item21=new  JMenuItem(b1.getText());
            item22=new  JMenuItem(b2.getText());
            item23=new  JMenuItem(b3.getText());
            item24=new  JMenuItem(b4.getText());
            item25=new  JMenuItem(b5.getText()); 
            item26=new  JMenuItem(b6.getText());
            item27=new  JMenuItem("Change Background");
            item28=new  JRadioButtonMenuItem("Text  Mode");
            item29=new  JRadioButtonMenuItem("Image Mode");
            item28.setSelected(true);
            
            b1.setFont(new Font("Courier",Font.BOLD,22));
            b2.setFont(new Font("Courier",Font.BOLD,22));
            b3.setFont(new Font("Courier",Font.BOLD,22));
            b4.setFont(new Font("Courier",Font.BOLD,22));
            b5.setFont(new Font("Courier",Font.BOLD,22));
            b6.setFont(new Font("Courier",Font.BOLD,22));   
            b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickCount1();}});
            b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickCount2();}});
            b3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickCount3();}});
            b4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickCount4();}});
            b5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickCount5();}});
            b6.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clickCount6();}});
            reset.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){reset();}});
            display.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){display();}});            
            
            t1=new Timer(1000,new ActionListener(){public void actionPerformed(ActionEvent e){counter1();}});
            t2=new Timer(1000,new ActionListener(){public void actionPerformed(ActionEvent e){counter2();}});
            t3=new Timer(1000,new ActionListener(){public void actionPerformed(ActionEvent e){counter3();}});
            t4=new Timer(1000,new ActionListener(){public void actionPerformed(ActionEvent e){counter4();}});
            t5=new Timer(1000,new ActionListener(){public void actionPerformed(ActionEvent e){counter5();}});
            t6=new Timer(1000,new ActionListener(){public void actionPerformed(ActionEvent e){counter6();}});
            PLAYERTIMER=new Timer(1000,new ActionListener(){public void actionPerformed(ActionEvent e){execute1();}});
            item1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editname(1);}});
            item2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editname(2);}});
            item3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editname(3);}});
            item4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editname(4);}});
            item5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editname(5);}});  
            item6.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editname(6);}});
            item7.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){reset();}});
            item8.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){display();}});
            item9.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){close();}});
            item10.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){references();}});
            item11.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){save();}});
            item12.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){view();}});
            item13.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){setpass();}});
            item14.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){showcandidate(1);}});
            item15.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){showcandidate(2);}});
            item16.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){showcandidate(3);}});
            item17.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){showcandidate(4);}});
            item18.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){showcandidate(5);}});  
            item19.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){showcandidate(6);}});
            item20.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){duration();}});
            item21.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editprofilepic(1);}});
            item22.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editprofilepic(2);}});
            item23.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editprofilepic(3);}});
            item24.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editprofilepic(4);}});
            item25.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editprofilepic(5);}});
            item26.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editprofilepic(6);}});
            item27.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){changebackground();}});
            item28.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){select1();}});
            item29.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){select2();}});
            f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){close();}});
            g.weighty=1;
            g.weightx=7;
            g.gridy=1;
            g.gridx=1;
            g.anchor=GridBagConstraints.WEST;
            add(b1,g);
            g.gridx=7;
            g.anchor=GridBagConstraints.EAST;
            add(b2,g);                              
            g.weighty=2;                 
            g.gridy=2;
            g.gridx=1;
            add(new JLabel(),g);
            g.weighty=3;
            g.gridy=4;
            g.anchor=GridBagConstraints.WEST;
            add(b3,g);
            g.gridx=7;
            g.anchor=GridBagConstraints.EAST;
            add(b4,g); 
            g.gridy=5;
            g.gridx=1;
            g.anchor=GridBagConstraints.WEST;
            add(b5,g); 
            g.gridx=7;
            g.anchor=GridBagConstraints.EAST;
            add(b6,g);
            g.weighty=3;
            g.insets=new Insets(12,15,12,15);
            g.gridy=5;
            g.gridx=1;
            g.ipadx=0;
            g.ipady=0;
            g.anchor=GridBagConstraints.SOUTHWEST;
            add(reset,g);                            
            g.gridx=7;                            
            g.anchor=GridBagConstraints.SOUTHEAST;
            add(display,g);
            
            menubar.add(menu1);        
            menubar.add(menu2);        
            menubar.add(menu3);   
            menubar.add(menu4);   
            
            submenu5.add(item28);
            submenu5.add(item29);
            menu1.add(submenu5);
            menu1.add(item7);
            menu1.add(item10);    
            menu1.add(item11);       
            menu1.addSeparator();
            menu1.add(item9); 
            
            menu2.add(item8);  
            menu2.add(item12);
            submenu2.add(item14);
            submenu2.add(item15);
            submenu2.add(item16);
            submenu2.add(item17);
            submenu2.add(item18);
            submenu2.add(item19);
            menu2.add(submenu2);
            
            submenu3.add(item1);
            submenu3.add(item2);
            submenu3.add(item3);
            submenu3.add(item4);
            submenu3.add(item5);
            submenu3.add(item6);
            submenu4.add(item21);
            submenu4.add(item22);
            submenu4.add(item23);
            submenu4.add(item24);
            submenu4.add(item25);
            submenu4.add(item26); 
            submenu1.add(submenu3);
            submenu1.add(submenu4);  
            menu3.add(submenu1);             
            menu3.add(item13);
            menu3.add(item20);
            menu3.add(item27);
            
            menu4.add(item10);
            f.add(this);
            f.setJMenuBar(menubar);
            createmediasupport();
            defaultColor=b1.getBackground();
            dl.setBackground(defaultColor);
            dl.pack();
            dl.setLocation(347,313);
            fr.add(frm);
            fr.setSize(500,500);
            f.setDefaultCloseOperation(f.DO_NOTHING_ON_CLOSE);
            fr.setDefaultCloseOperation(fr.HIDE_ON_CLOSE);
        }
        public void paintComponent(Graphics g) {
            dl.setLocationRelativeTo(f);
            super.paintComponent(g);
            File[] thu=new File(dir+"/IMAGES/background").listFiles();
            Image i=null;
            if(thu!=null)
            {
                try{
                    i=new ImageIcon(thu[0].getAbsolutePath()).getImage();
                }
                catch(Exception e)
                {
                    i=new ImageIcon("").getImage();
                }
            }
            else
            i=new ImageIcon("").getImage();
            setBackground(Color.BLACK);
            g.setColor(Color.BLUE);
            g.drawImage(i,1,1,f.getWidth(),f.getHeight(),this); 
        }
        public void createmediasupport()
        {
            try{
                AudioInputStream ain=AudioSystem.getAudioInputStream(new File("SOUNDS/horn.wav"));
                p1=(Clip)AudioSystem.getLine(new DataLine.Info(Clip.class,ain.getFormat()));
                p1.open(ain);
                AudioInputStream ain2=AudioSystem.getAudioInputStream(new File("SOUNDS/error.wav"));
                p2=(Clip)AudioSystem.getLine(new DataLine.Info(Clip.class,ain2.getFormat()));
                p2.open(ain2);
            }
            catch(Exception e){}
        }
        
        public void makedirs()
        {                        
            if(new File(dir).exists()==false)new File(dir).mkdirs();
            if(new File(dir+"/IMAGES").exists()==false)new File(dir+"/IMAGES").mkdirs();
            if(new File(dir+"/IMAGES/candidate").exists()==false)new File(dir+"/IMAGES/candidate").mkdirs();
            if(new File(dir+"/IMAGES/background").exists()==false)new File(dir+"/IMAGES/background").mkdirs();
        }
        
        public void clickCount1()
        {       
            dl.setLocationRelativeTo(f);
            dl.setVisible(true);
            passf.setRequestFocusEnabled(true);
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);
            b5.setBackground(Color.red);
            b6.setBackground(Color.red);
            if(t1.isRunning()==false&&t2.isRunning()==false&&t3.isRunning()==false&&t4.isRunning()==false&&t5.isRunning()==false&&t6.isRunning()==false)
            {
                t1.start();
                cl1++;
            }
            else
            {
                resetmedia();
                p1.start();
                PLAYERTIMER.start();
            }
        }
        public void counter1()
        {                    
            
            count1++;
            if(count1==timef){
                t1.stop();
                dl.setVisible(false);
                count1=0;
                b1.setBackground(defaultColor);
                b2.setBackground(defaultColor);
                b3.setBackground(defaultColor);
                b4.setBackground(defaultColor);
                b5.setBackground(defaultColor);
                b6.setBackground(defaultColor);
            }
        }
         public void clickCount2()
        {       
            dl.setLocationRelativeTo(f);
            dl.setVisible(true);
            passf.setRequestFocusEnabled(true);
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);
            b5.setBackground(Color.red);            
            b6.setBackground(Color.red);
            if(t1.isRunning()==false&&t2.isRunning()==false&&t3.isRunning()==false&&t4.isRunning()==false&&t5.isRunning()==false&&t6.isRunning()==false)
            {
                t2.start();
                cl2++;
            }
            else
            {
                resetmedia();
                p1.start();
                PLAYERTIMER.start();
            }
            
        }
        public void counter2()
        {       
            count2++;
            if(count2==timef){
                t2.stop();                
                dl.setVisible(false);
                count2=0;
                b1.setBackground(defaultColor);
                b2.setBackground(defaultColor);
                b3.setBackground(defaultColor);
                b4.setBackground(defaultColor);
                b5.setBackground(defaultColor);
                b6.setBackground(defaultColor);
            }
        }
         public void clickCount3()
        {         
            dl.setLocationRelativeTo(f);
            dl.setVisible(true);
            passf.setRequestFocusEnabled(true);
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);
            b5.setBackground(Color.red);
            b6.setBackground(Color.red);
            if(t1.isRunning()==false&&t2.isRunning()==false&&t3.isRunning()==false&&t4.isRunning()==false&&t5.isRunning()==false&&t6.isRunning()==false)
            {
                t3.start();
                cl3++;
            }
            else
            {
                resetmedia();
                p1.start();
                PLAYERTIMER.start();
            }
            
        }
        public void counter3()
        {
            count3++;
            if(count3==timef){
                t3.stop();
                dl.setVisible(false);
                count3=0;
                b1.setBackground(defaultColor);
                b2.setBackground(defaultColor);
                b3.setBackground(defaultColor);
                b4.setBackground(defaultColor);
                b5.setBackground(defaultColor);                
                b6.setBackground(defaultColor);
            }
        }
         public void clickCount4()
        {   
            dl.setLocationRelativeTo(f);
            dl.setVisible(true);
            passf.setRequestFocusEnabled(true);
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);
            b5.setBackground(Color.red);            
            b6.setBackground(Color.red);
            if(t1.isRunning()==false&&t2.isRunning()==false&&t3.isRunning()==false&&t4.isRunning()==false&&t5.isRunning()==false&&t6.isRunning()==false)
            {
                t4.start();
                cl4++;
            }
            else
            {
                resetmedia();
                p1.start();
                PLAYERTIMER.start();
            }
            
        }
        public void counter4()
        {  
            count4++;
            if(count4==timef){
                t4.stop();
                dl.setVisible(false);
                count4=0;
                b1.setBackground(defaultColor);
                b2.setBackground(defaultColor);
                b3.setBackground(defaultColor);
                b4.setBackground(defaultColor);
                b5.setBackground(defaultColor);
                b6.setBackground(defaultColor);
            }
        }
         public void clickCount5()
        {      
            dl.setLocationRelativeTo(f);
            dl.setVisible(true);
            passf.setRequestFocusEnabled(true);
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);
            b5.setBackground(Color.red);
            b6.setBackground(Color.red);            
            if(t1.isRunning()==false&&t2.isRunning()==false&&t3.isRunning()==false&&t4.isRunning()==false&&t5.isRunning()==false&&t6.isRunning()==false)
            {
                t5.start();
                cl5++;
            }
            else
            {
                resetmedia();
                p1.start();
                PLAYERTIMER.start();
            }
            
        }
        public void counter5()
        {                     
            count5++;
            if(count5==timef){
                t5.stop();
                dl.setVisible(false);
                count5=0;
                b1.setBackground(defaultColor);
                b2.setBackground(defaultColor);
                b3.setBackground(defaultColor);
                b4.setBackground(defaultColor);
                b5.setBackground(defaultColor);
                b6.setBackground(defaultColor);
            }
        }
         public void clickCount6()
        {      
            dl.setLocationRelativeTo(f);
            dl.setVisible(true);
            passf.setRequestFocusEnabled(true);
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);
            b5.setBackground(Color.red);            
            b6.setBackground(Color.red);            
            if(t1.isRunning()==false&&t2.isRunning()==false&&t3.isRunning()==false&&t4.isRunning()==false&&t5.isRunning()==false&&t6.isRunning()==false)
            {
                t6.start();
                cl6++;
            }
            else
            {
                resetmedia();
                p1.start();
                PLAYERTIMER.start();
            }
            
        }
        public void counter6()
        {                   
            count6++;
            dl.getLocation();
            if(count6==timef){
                t6.stop();
                dl.setVisible(false);
                count6=0;
                b1.setBackground(defaultColor);
                b2.setBackground(defaultColor);
                b3.setBackground(defaultColor);
                b4.setBackground(defaultColor);
                b5.setBackground(defaultColor);
                b6.setBackground(defaultColor);
            }
        }
        public void display()
        {
            String pass=getPassword(null);         
            if(pass!=null&&pass.equals(PASSWORD))
            {
            String msg="Votes for "+b1.getText()+"    "+cl1+" times"+'\n'+"Votes for "+b2.getText()+"    "+cl2+" times"+'\n'+"Votes for "+b3.getText()+"    "+cl3+" times"+'\n'+"Votes for "+b4.getText()+"    "+cl4+" times"+'\n'+"Votes for "+b5.getText()+"    "+cl5+" times"+'\n'+"Votes for "+b6.getText()+"    "+cl6+" times" ;
            JOptionPane.showMessageDialog(f,(msg),"Result",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(pass!=null&&pass.equals(""))
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"Please enter psssword","Error",JOptionPane.ERROR_MESSAGE);
                display();
            }            
            else if(pass!=null)
            {               
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"You have entered wrong password","Error",JOptionPane.ERROR_MESSAGE); 
                display();
            }
        }
        
        
        public void reset()
        {
            String pass=getPassword(null);            
            if(pass!=null&&pass.equals(PASSWORD))
            {
                t1.stop();
                t2.stop();
                t3.stop();
                t4.stop();
                t5.stop();
                t6.stop();
                cl1=0;
                cl2=0;
                cl3=0;
                cl4=0;
                cl5=0;
                cl6=0;
                count1=0;
                count2=0;
                count3=0;
                count4=0;
                count5=0;
                count6=0;                
                JOptionPane.showMessageDialog(f,"Reset Successful !!!!","Reset",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(pass!=null&&pass.equals(""))
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"Please enter password","Error",JOptionPane.ERROR_MESSAGE);
                reset();
            }
            
            else if(pass!=null)
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"You entered wrong pssword","Error",JOptionPane.ERROR_MESSAGE);      
                reset();
            }
                
        }
        
        public void editname(int x)
        {            
            String pass=getPassword(null);   
            if(pass!=null&&pass.equals(PASSWORD))
            {                
                switch(x)
                {
                    case 1:
                    {
                        String nam=(JOptionPane.showInputDialog(f,"Please enter the name for the First Candidate","Edit Candidate's Name",JOptionPane.INFORMATION_MESSAGE));
                        if(nam!=null&&(nam.equals("")==false))
                        b1.setText(nam);
                        update();
                        break;
                    }
                    case 2:
                    {
                        String nam=(JOptionPane.showInputDialog(f,"Please enter the name for the Second Candidate","Edit Candidate's Name",JOptionPane.INFORMATION_MESSAGE));
                        if(nam!=null&&(nam.equals("")==false))
                        b2.setText(nam);
                        update();
                        break;
                    }
                    case 3:
                    {
                        String nam=(JOptionPane.showInputDialog(f,"Please enter the name for the Third Candidate","Edit Candidate's Name",JOptionPane.INFORMATION_MESSAGE));
                        if(nam!=null&&(nam.equals("")==false))
                        b3.setText(nam);
                        update();
                        break;
                    }                    
                    case 4:
                    {
                        String nam=(JOptionPane.showInputDialog(f,"Please enter the name for the Fourth Candidate","Edit Candidate's Name",JOptionPane.INFORMATION_MESSAGE));
                        if(nam!=null&&(nam.equals("")==false))
                        b4.setText(nam);
                        update();
                        break;
                    }
                    case 5:
                    {
                        String nam=(JOptionPane.showInputDialog(f,"Please enter the name for the Fifth Candidate","Edit Candidate's Name",JOptionPane.INFORMATION_MESSAGE));
                        if(nam!=null&&(nam.equals("")==false))
                        b5.setText(nam);
                        update();
                        break;
                    }
                    case 6:
                    {
                        String nam=(JOptionPane.showInputDialog(f,"Please enter the name for the Sixth Candidate","Edit Candidate's Name",JOptionPane.INFORMATION_MESSAGE));
                        if(nam!=null&&(nam.equals("")==false))
                        b6.setText(nam);
                        update();
                        break;
                    }         
                }
            }
            else if(pass!=null&&pass.equals(""))
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"Please enter password","Error",JOptionPane.ERROR_MESSAGE);
                editname(x);
            }
            else if(pass!=null)
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"You eneterd wrond password","Error",JOptionPane.ERROR_MESSAGE);     
                editname(x);          
            }
        }
        public void editprofilepic(int x)
        {            
            String pass=getPassword(null);   
            if(pass!=null&&pass.equals(PASSWORD))
            { 
                switch(x)
                {
                    case 1:{String send="Please Select Profile Picture For First Candidate"; choseimg(send,x);mode2();break;}
                    case 2:{String send="Please Select Profile Picture For Second Candidate"; choseimg(send,x);mode2();break;}
                    case 3:{String send="Please Select Profile Picture For Third Candidate"; choseimg(send,x);mode2();break;}
                    case 4:{String send="Please Select Profile Picture For Fourth Candidate"; choseimg(send,x);mode2();break;}
                    case 5:{String send="Please Select Profile Picture For Fifth Candidate"; choseimg(send,x);mode2();break;}
                    case 6:{String send="Please Select Profile Picture For Sixth Candidate"; choseimg(send,x);mode2();break;}
                }
            }
            else if(pass!=null&&pass.equals(""))
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"Please enter password","Error",JOptionPane.ERROR_MESSAGE);
                editname(x);
            }
            else if(pass!=null)
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"You eneterd wrond password","Error",JOptionPane.ERROR_MESSAGE);     
                editname(x);          
            }
        }
        public void execute1()
        {
            if(p1.getMicrosecondPosition()==p1.getMicrosecondLength())
            {
                resetmedia();
            }
        }
        public void resetmedia()
        {
            p1.stop();
            p1.setMicrosecondPosition((0));
            p2.stop();
            p2.setMicrosecondPosition((0));
        }
        public void close()
        {
            String pass=getPassword(null);         
            if(pass!=null&&pass.equals(PASSWORD))
            {
                try
                {
                    writeext(false);
                    BufferedWriter bw=new BufferedWriter(new FileWriter(dir+"/button names.dat"));
                    bw.write(b1.getText());
                    bw.newLine();
                    bw.write(b2.getText());
                    bw.newLine();
                    bw.write(b3.getText());
                    bw.newLine();
                    bw.write(b4.getText());
                    bw.newLine();
                    bw.write(b5.getText());
                    bw.newLine();
                    bw.write(b6.getText());
                    bw.newLine();
                    bw.close();
                }catch(Exception e){}
                System.exit(0);
            }
            else if(pass!=null&&pass.equals(""))
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"Please enter password","Error",JOptionPane.ERROR_MESSAGE);
                close();
            }            
            else if(pass!=null)
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"You eneterd wrond password","Error",JOptionPane.ERROR_MESSAGE);                        
                close();
            }
        }
        public void update()
        {
            item1.setText(b1.getText());
            item2.setText(b2.getText());
            item3.setText(b3.getText());
            item4.setText(b4.getText());
            item5.setText(b5.getText()); 
            item6.setText(b6.getText());        
            item14.setText(b1.getText());
            item15.setText(b2.getText());
            item16.setText(b3.getText());
            item17.setText(b4.getText());
            item18.setText(b5.getText()); 
            item19.setText(b6.getText());
        }
        
        public void references()
        {
            String s="";
            try{
                String temp;
                BufferedReader br1=new BufferedReader(new FileReader("REFERENCES.DAT"));
                while((temp=br1.readLine())!=null)
                {
                    s=s+temp+"\n";
                }
            }catch(Exception e){s="Cannot find Refrences.dat File";}
            JOptionPane.showMessageDialog(f,s,"REFERENCES",JOptionPane.INFORMATION_MESSAGE);
        }
        public String getPassword(String in)
        {
            String set=in;
            if(in==null) set="Please enter password";
            JOptionPane pane=new JOptionPane(plpa, JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_CANCEL_OPTION,null);
            dialog=pane.createDialog(f,set);
            dialog.addComponentListener(new ComponentAdapter(){public void componentShown(ComponentEvent e){focus();}});
            dialog.setVisible(true);
            int opt=0;
            if(pane.getValue()==null)opt=pane.CANCEL_OPTION;
            else opt=(Integer)pane.getValue();
            dialog.dispose();
            if(opt==pane.OK_OPTION)
            {   
                String slk=new String(passf.getPassword());            
                passf.setText("");
                return slk;
            }
            else
            { 
                passf.setText("");
                return null;
            }
            
        }
        public String getdayname(int dayno)
        {
            String re=null;
            switch(dayno)
            {
                case 1:re= "MONDAY";    break;
                case 2:re= "TUESDAY";   break;
                case 3:re= "WEDNESDAY"; break;
                case 4:re= "THURSDAY";  break;
                case 5:re= "FRIDAY";    break;
                case 6:re= "SATURDAY";  break;
                case 7:re= "SUNDAY";    break;            
            }
            return re;
        }
        public void save()
        {
            String pass=getPassword(null);         
            if(pass!=null&&pass.equals(PASSWORD))
            {
                try{
                    BufferedWriter bw=new BufferedWriter(new FileWriter(dir+"/Result of Votes Casted.dat"));  
                    bw.write(dat);
                    bw.newLine();
                    bw.write(String.valueOf(cl1));
                    bw.newLine();
                    bw.write(String.valueOf(cl2));
                    bw.newLine();
                    bw.write(String.valueOf(cl3));
                    bw.newLine();
                    bw.write(String.valueOf(cl4));
                    bw.newLine();
                    bw.write(String.valueOf(cl5));
                    bw.newLine();
                    bw.write(String.valueOf(cl6));
                    bw.close();
                    JOptionPane.showMessageDialog(f,"Saving Successful !!!!","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception e){}
            }
            else if(pass!=null&&pass.equals(""))
            { 
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"Please enter password","Error",JOptionPane.ERROR_MESSAGE);
                save();
            }            
            else if(pass!=null)
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"You eneterd wrond password","Error",JOptionPane.ERROR_MESSAGE);           
                save();
            }
        }
        public void view()
        {
            String pass=getPassword(null);         
            if(pass!=null&&pass.equals(PASSWORD))
            {
                try{
                    BufferedReader br1=new BufferedReader(new FileReader(dir+"/Result of Votes Casted.dat"));
                    String s="";
                    String tmp="Date of Vote Casted:  ";
                    int index=0;
                    while((s=br1.readLine())!=null)
                    {
                        tmp+=s+'\n';
                        index++;
                        switch(index)
                        {
                            case 1:tmp+=b1.getText()+"        ";break;
                            case 2:tmp+=b2.getText()+"        ";break;
                            case 3:tmp+=b3.getText()+"        ";break;
                            case 4:tmp+=b4.getText()+"        ";break;
                            case 5:tmp+=b5.getText()+"        ";break;
                            case 6:tmp+=b6.getText()+"        ";break;
                        }     
                    }           
                    br1.close();
                    JOptionPane.showMessageDialog(f,tmp,"Last Result",JOptionPane.INFORMATION_MESSAGE);                     
                    index=0;
                }
                catch(IOException e)
                {   
                    resetmedia();
                    p2.start();
                    JOptionPane.showMessageDialog(f,"Cannot not found stored result file /n Please start new election","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(pass!=null&&pass.equals(""))
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"Please enter password","Error",JOptionPane.ERROR_MESSAGE);
                view();
            }            
            else if(pass!=null)
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"You eneterd wrond password","Error",JOptionPane.ERROR_MESSAGE);                
                view();
            }
        }
        
        public void showcandidate(int it)
        {
            switch(it)
            {
                case 1:frm.loadimage(new ImageIcon(dir+"/IMAGES/candidate/1"+ext[0]));break;
                case 2:frm.loadimage(new ImageIcon(dir+"/IMAGES/candidate/2"+ext[1]));break;
                case 3:frm.loadimage(new ImageIcon(dir+"/IMAGES/candidate/3"+ext[2]));break;
                case 4:frm.loadimage(new ImageIcon(dir+"/IMAGES/candidate/4"+ext[3]));break;
                case 5:frm.loadimage(new ImageIcon(dir+"/IMAGES/candidate/5"+ext[4]));break;
                case 6:frm.loadimage(new ImageIcon(dir+"/IMAGES/candidate/6"+ext[5]));break;
            }
            frm.repaint();
            fr.setVisible(true);
        }
        public void setpass()
        {
            String pass=getPassword(null);   
            if(pass!=null&&pass.equals(PASSWORD))
            {
                String newpas=getPassword("Please enter new Password");
                try
                {
                    security.changePassword(newpas); 
                    JOptionPane.showMessageDialog(f,"Password Changed","Change Password",JOptionPane.INFORMATION_MESSAGE);
                    PASSWORD=newpas;
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(f,"Error Changing Password","Error",JOptionPane.ERROR_MESSAGE);                
                }
            }
            else if(pass!=null&&pass.equals(""))
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"Please enter password","Error",JOptionPane.ERROR_MESSAGE);
                setpass();
            }            
            else if(pass!=null)
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"You eneterd wrond password","Error",JOptionPane.ERROR_MESSAGE);   
                setpass();
            }
        }
        public void duration()
        {
            String pass=getPassword(null);   
            if(pass!=null&&pass.equals(PASSWORD))
            {
                String pastmp=(JOptionPane.showInputDialog(f,"Please enter Duration for time out(In Seconds)","Duration",JOptionPane.INFORMATION_MESSAGE));
                if(pastmp!=null&&(pastmp.equals("")==false))
                {
                    try
                    {
                        int ji=Integer.parseInt(pastmp);
                        timef=ji;
                        JOptionPane.showMessageDialog(f,"Changing duration Succesful  !!!!","Duration",JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(Exception e)
                    {
                        resetmedia();
                        p2.start();
                        JOptionPane.showMessageDialog(f,"Please enter correct INTEGER value","Error",JOptionPane.ERROR_MESSAGE);
                        duration();                    
                    }
                }
            }
            else if(pass!=null&&pass.equals(""))
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"Please enter password","Error",JOptionPane.ERROR_MESSAGE);
                duration();
            }            
            else if(pass!=null)
            {
                resetmedia();
                p2.start();
                JOptionPane.showMessageDialog(f,"You eneterd wrond password","Error",JOptionPane.ERROR_MESSAGE);   
                duration();
            }
        }
        public void focus()
        {
            SwingUtilities.invokeLater(new Runnable(){@Override public void run(){giv();}});            
        }
        public void giv()
        {
            passf.requestFocusInWindow();
        }
        public void choseimg(String title,int index)
        {
            JFileChooser openfile=new JFileChooser(title);
            int ki=openfile.showOpenDialog(f); 
            if(ki==JFileChooser.APPROVE_OPTION)
            {
                File tmp=openfile.getSelectedFile();
                FileChannel input=null,output=null;
                try
                {
                    String hi=tmp.getName();
                    ext[index-1]=hi.substring(hi.lastIndexOf("."),hi.length());
                    input=new FileInputStream(tmp).getChannel();
                    output=new FileOutputStream(new File(dir+"/IMAGES/candidate/"+index+ext[index-1])).getChannel();
                    output.transferFrom(input,0,input.size());
                    JOptionPane.showMessageDialog(f,"Changing Profile Picture Succesful !!!","Succesful",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception e){}
                finally
                {
                    try
                    {
                        input.close();
                        output.close();
                    }
                    catch(Exception e){}
                }
            }
        }
        public void changebackground()
        {
            FileNameExtensionFilter filter= new FileNameExtensionFilter("Media File", new String[]{".jpg","jpeg",".png",".bmp"});
            JFileChooser openfile=new JFileChooser("Chose Background Image");
            openfile.setFileFilter(filter);  
            int ki=openfile.showOpenDialog(f); 
            if(ki==JFileChooser.APPROVE_OPTION)
            { 
                File[] thu=new File(dir+"/IMAGES/background").listFiles();
                if(thu!=null)
                {                
                    try
                    {
                        thu[0].delete();
                    }
                    catch(Exception e)
                    {
                    }
                    }
                    File tmp=openfile.getSelectedFile();
                    FileChannel input=null,output=null;
                    try
                    {
                        String hi=tmp.getName();
                        input=new FileInputStream(tmp).getChannel();
                        output=new FileOutputStream(new File(dir+"/IMAGES/background/"+hi)).getChannel();
                        output.transferFrom(input,0,input.size());
                        repaint();
                        JOptionPane.showMessageDialog(f,"Background Changing Succesful !!!!","Succesful",JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(Exception e)
                    {             
                        JOptionPane.showMessageDialog(f,"Error changing backgroung","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    finally
                    {
                        try
                        {
                            input.close();
                            output.close();
                        }
                        catch(Exception e){}
                    }
                }
            }
            public void writeext(boolean wht)
            {
                if(wht)
                {
                    try{  
                        BufferedReader br=new BufferedReader(new FileReader(dir+"/image ext.dat"));
                        String exti=null;
                        int uy=0;
                        while((exti=br.readLine())!=null)               
                        {
                            ext[uy]=exti;
                            uy++;
                        }
                        if(uy<ext.length)
                        {
                            for(int i=uy;i<ext.length;i++)
                            ext[i]="";
                        }
                        br.close();
                    }
                    catch(Exception e)
                    {
                        for(int uy=0;uy<ext.length;uy++)
                        {
                            ext[uy]="";
                        }
                    }
                }
                else
                {
                    try
                    {
                        BufferedWriter bw=new BufferedWriter(new FileWriter(dir+"/image ext.dat"));
                        for(int uy=0;uy<ext.length;uy++)
                        {
                            bw.write(ext[uy]);
                            bw.newLine();
                        }
                        bw.close();
                    }
                    catch(Exception e)
                    {
                    }
                }
            }
            public void select1()
            {                
                    item28.setSelected(true);        
                    mode1();
            }
            public void select2()
            {
                    item29.setSelected(true);
                    mode2();
            }
            public void mode1()
            {
                if(item28.isSelected())
                {                    
                    item29.setSelected(false);
                    b1.setText(item1.getText());
                    b2.setText(item2.getText());
                    b3.setText(item3.getText());
                    b4.setText(item4.getText());
                    b5.setText(item5.getText()); 
                    b6.setText(item6.getText());
                    b1.setIcon(null);
                    b2.setIcon(null);
                    b3.setIcon(null);
                    b4.setIcon(null);
                    b5.setIcon(null);
                    b6.setIcon(null);
                }
            }
            public void mode2()
            {
                if(item29.isSelected())
                {
                    item28.setSelected(false);
                     b1.setText("");
                    b2.setText("");
                    b3.setText("");
                    b4.setText("");
                    b5.setText(""); 
                    b6.setText("");
                    ImageIcon ic[]=new ImageIcon[6];
                    for(int i=0;i<ic.length;i++)
                    {
                        try
                        {
                            int yui=i+1;
                            Image imj=ImageIO.read(new File(dir+"/IMAGES/candidate/"+yui+ext[i]));
                            imj=imj.getScaledInstance(194,110,0);
                            ic[i]=new ImageIcon(imj);                            
                        }catch(Exception e){}
                    }
                    b1.setIcon(ic[0]);
                    b2.setIcon(ic[1]);
                    b3.setIcon(ic[2]);
                    b4.setIcon(ic[3]);
                    b5.setIcon(ic[4]);
                    b6.setIcon(ic[5]);
                }
            }
        }