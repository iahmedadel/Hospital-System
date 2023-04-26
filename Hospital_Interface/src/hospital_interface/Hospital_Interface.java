
//   username  : Ahmed 
//   password  : 1621


package hospital_interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Hospital_Interface extends Frame implements ActionListener
{
//    Connection
    public String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public String url="jdbc:sqlserver://localhost;databaseName=Hospital";
    public String username="Hospital";
    public String password="abohanafi";
    
    

    
    // Welcome Frame
    JLabel welcome=new JLabel("Welcome to Modern Hospital");
    URL Img=getClass().getResource("logo.png");
    ImageIcon logo =new ImageIcon(Img);
    JLabel icon =new JLabel(logo); 
    
    URL Img1=getClass().getResource("user.png");
    ImageIcon logo1 =new ImageIcon(Img1);
    JLabel user =new JLabel(logo1);
    
    URL Img2=getClass().getResource("pass.png");
    ImageIcon logo2 =new ImageIcon(Img2);
    JLabel pass =new JLabel(logo2);
    
    //create check pass screen
    JLabel telllabel = new JLabel("Please, Enter your Username & Password :");
    JLabel userlabel = new JLabel("Username :");
    JLabel passlabel = new JLabel("Password :");
    //create Text Fields for Welcome Frame
    JTextField usertext = new JTextField();
    JTextField passtext = new JTextField();
    //create Button Login for Welcome Frame
    JButton submitpass = new JButton("Log In");
    //create Fonts
    Font font = new Font("SansSerif", Font.BOLD, 15);
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font font2 = new Font("SansSerif", Font.BOLD, 25);
    
    
    
    
    //Choose Frame
    JFrame chooseframe = new JFrame();
    JLabel icon2=new JLabel(logo);
    JLabel choose=new JLabel("Please, Enter your Choice :");
    JButton doctor = new JButton("Doctor");
    JButton patient = new JButton("Patient");
    JButton test = new JButton("Test");
    URL Img3=getClass().getResource("doctor.png");
    ImageIcon logo3 =new ImageIcon(Img3);
    JLabel doctorc =new JLabel(logo3);
    URL Img4=getClass().getResource("patient.png");
    ImageIcon logo4 =new ImageIcon(Img4);
    JLabel patientc =new JLabel(logo4);
    URL Img5=getClass().getResource("test.png");
    ImageIcon logo5 =new ImageIcon(Img5);
    JLabel testc =new JLabel(logo5);
    JButton logout = new JButton("Log out");
    
    
    
    //Choose doctor operation
    JFrame Doperation = new JFrame();
    JLabel icon3=new JLabel(logo);
    JLabel chooseopd=new JLabel("Please, Choose your Operation :");
    JButton adddoctor = new JButton("Add Doctor");
    JButton editdoctor = new JButton("Edit Doctor");
    JButton deletedoctor = new JButton("Delete Doctor");
    JButton searchdoctor = new JButton("Search Doctor");
    JButton doctorprevious = new JButton("Home");
    
    //Add Doctor Frame
    JFrame Add_Doctors =new JFrame ();
    JLabel D1=new JLabel("Enter The Doctor's Data");
    JLabel labeldssn=new JLabel("DSSN :");
    JLabel labeldname=new JLabel("Name :");
    JLabel labelspecialization=new JLabel("Specialization :");
    JTextField dssn= new JTextField();
    JTextField dname= new JTextField();
    JTextField specialization= new JTextField();
    JButton dprevious= new JButton("Previous");
    JButton dinsert= new JButton("Insert");
    
       
    
    //Edit Doctor Frame
    JFrame Edit_Doctors =new JFrame ();
    JLabel ED1=new JLabel("Enter DSSN & New Doctor's Data");
    JLabel labeledssn=new JLabel("DSSN :");
    JLabel labeledname=new JLabel("Name :");
    JLabel labelespecialization=new JLabel("Specialization :");
    JTextField edssn= new JTextField();
    JTextField edname= new JTextField();
    JTextField especialization= new JTextField();
    JButton edprevious= new JButton("Previous");
    JButton edupdate= new JButton("Update");
       
    //Delete Doctor Frame
    JFrame Delete_Doctors =new JFrame ();
    JLabel DD1=new JLabel("Enter The Doctor's DSSN");
    JLabel labelddssn=new JLabel("DSSN :");
    JTextField ddssn= new JTextField();
    JButton ddprevious= new JButton("Previous");
    JButton ddelete= new JButton("Delete");
    
    //Search Doctor Frame
    JFrame Search_Doctors =new JFrame ();  
    JLabel SD1=new JLabel("Enter The Doctor's DSSN");
    JLabel labelsdssn=new JLabel("DSSN :");
    JLabel labelsdname=new JLabel("Name is :");
    JLabel labelsspecialization=new JLabel("Specialization is :");   
    JTextField sdssn= new JTextField();
    JTextField sdname= new JTextField();
    JTextField sspecialization= new JTextField();    
    JButton sdprevious= new JButton("Previous");
    JButton dsearch= new JButton("Show Data");
    
    
  

    //Choose patient operation
    JFrame Poperation = new JFrame();
    JLabel icon4=new JLabel(logo);
    JLabel chooseopp=new JLabel("Please, Choose your Operation :");
    JButton addpatient = new JButton("Add Patient");
    JButton editpatient = new JButton("Edit Patient");
    JButton deletepatient = new JButton("Delete Patient");
    JButton searchpatient = new JButton("Search Patient");
    JButton patientprevious = new JButton("Home");
        
    //Add Patient Frame
    JFrame Add_Patients =new JFrame (); 
    JLabel P1=new JLabel("Enter Patient's Data");
    JLabel labelssn=new JLabel("SSN :");
    JLabel labelname=new JLabel("Name :");
    JLabel labelmedical=new JLabel("Medical insurance :");
    JLabel labeldate_admitted=new JLabel("Date Admitted :");
    JLabel labeldate_checkedout=new JLabel("Date of Checked out :"); 
    JTextField ssn= new JTextField();
    JTextField name= new JTextField();
    JTextField medical_insurance = new JTextField();
    JTextField date_admitted= new JTextField();
    JTextField date_checked_out= new JTextField();  
    JButton pprevious= new JButton("Previous");
    JButton pinsert= new JButton("Insert");
    
    //Edit Patient Frame
    JFrame Edit_Patients =new JFrame ();
    JLabel EP1=new JLabel("Enter SSN & New Patient's Data");
    JLabel labelessn=new JLabel("SSN :");
    JLabel labelename=new JLabel("Name :");
    JLabel labelemedical=new JLabel("Medical insurance :");
    JLabel labeledate_admitted=new JLabel("Date Admitted :");
    JLabel labeledate_checkedout=new JLabel("Date of Checked out :"); 
    JTextField essn= new JTextField();
    JTextField ename= new JTextField();
    JTextField edate_checked_out= new JTextField();
    JTextField edate_admitted= new JTextField();
    JTextField emedical_insurance = new JTextField();
    JButton epprevious= new JButton("Previous");
    JButton epupdate= new JButton("Update"); 
    
    //Delete Patient Frame
    JFrame Delete_Patients =new JFrame ();
    JLabel PD1=new JLabel("Enter The Patient's SSN");
    JLabel labeldpssn=new JLabel("SSN :");
    JTextField dpssn= new JTextField();
    JButton dpprevious= new JButton("Previous");
    JButton pdelete= new JButton("Delete");
  
     //Search Patient Frame
    JFrame Search_Patients =new JFrame ();  
    JLabel SP1=new JLabel("Enter The Patient's SSN");
    JLabel labelsssn=new JLabel("SSN :");
    JLabel labelsname=new JLabel("Name is :");
    JLabel labelsmedical=new JLabel("Medical insurance is :");
    JLabel labelsdate_admitted=new JLabel("Date Admitted is :");
    JLabel labelsdate_checkedout=new JLabel("Date of Checked out is :"); 
    JTextField sssn= new JTextField();
    JTextField sname= new JTextField();
    JTextField sdate_checked_out= new JTextField();
    JTextField sdate_admitted= new JTextField();
    JTextField smedical_insurance = new JTextField(); 
    JButton spprevious= new JButton("Previous");
    JButton psearch= new JButton("Show Data");
    
    
    
    
    //Choose Test operation
    JFrame Toperation = new JFrame();
    JLabel icon5=new JLabel(logo);
    JLabel chooseopt=new JLabel("Please, Choose your Operation :");
    JButton addtest = new JButton("Add Test");
    JButton edittest = new JButton("Edit Test");
    JButton deletetest = new JButton("Delete Test");
    JButton searchtest = new JButton("Search Test");
    JButton testprevious = new JButton("Home");
    
    //Add Tests Frame
    JFrame Add_Tests =new JFrame ();
    JLabel T1=new JLabel("Enter Test Data");
    JLabel labelTid=new JLabel("ID :");
    JLabel labelTname=new JLabel("Name :");
    JLabel labelTdate=new JLabel("Date :");
    JLabel labelTtime=new JLabel("Time :");
    JLabel labelTresult=new JLabel("Result :");
    JTextField Tid= new JTextField();
    JTextField Tname= new JTextField();
    JTextField Tdate= new JTextField();
    JTextField Ttime= new JTextField();
    JTextField Tresult = new JTextField();
    JButton Tprevious= new JButton("Previous");
    JButton Tinsert= new JButton("Insert");
    
    //Edit Tests Frame
    JFrame Edit_Tests =new JFrame ();
    JLabel ET1=new JLabel("Enter ID & New Test Data");
    JLabel labeleTid=new JLabel("ID :");
    JLabel labeleTname=new JLabel("Name :");
    JLabel labeleTdate=new JLabel("Date :");
    JLabel labeleTtime=new JLabel("Time :");
    JLabel labeleTresult=new JLabel("Result :");
    JTextField eTid= new JTextField();
    JTextField eTname= new JTextField();
    JTextField eTdate= new JTextField();
    JTextField eTtime= new JTextField();
    JTextField eTresult = new JTextField();  
    JButton eTprevious= new JButton("Previous");
    JButton eTupdate= new JButton("Update"); 
    
    //Delete Test Frame
    JFrame Delete_Tests =new JFrame ();
    JLabel TD1=new JLabel("Enter The Test ID");
    JLabel labelid=new JLabel("ID :");
    JTextField dTid= new JTextField();
    JButton dtprevious= new JButton("Previous");
    JButton tdelete= new JButton("Delete");  
    
    //Search Tests Frame
    JFrame Search_Tests =new JFrame ();  
    JLabel ST1=new JLabel("Enter The Test ID");
    JLabel labelsTid=new JLabel("ID :");
    JLabel labelsTname=new JLabel("Name is :");
    JLabel labelsTdate=new JLabel("Date is :");
    JLabel labelsTtime=new JLabel("Time is :");
    JLabel labelsTresult=new JLabel("Result is :");
    JTextField sTid= new JTextField();
    JTextField sTname= new JTextField();
    JTextField sTdate= new JTextField();
    JTextField sTtime= new JTextField();
    JTextField sTresult = new JTextField();  
    JButton stprevious= new JButton("Previous");
    JButton tsearch= new JButton("Show Data");
    
    
    //Constractor
    Hospital_Interface()
    {
        //icon in top frame
   
        try {
        Image img=ImageIO.read(getClass().getResource("/image/Hospital.png"));
        this.setIconImage(img);
   
        }
        catch(Exception ex){}
        
            
        
        //close operation
        
        this.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        }
        );
          
        
        
       //Welcome Form
        setLayout(null);
        setBounds(500, 50, 600, 650);
        setBackground(Color.LIGHT_GRAY);
       //logo & heading Label
        icon.setBounds(50,100,500,300);
        welcome.setBounds(170,40,300,40);
        welcome.setFont(font1);
        //Add logo & heading Label
        add(icon);       
        add(welcome);
        //create username & password
        telllabel.setBounds(110,390,360,30);
        user.setBounds(110,440,40,70);
        userlabel.setBounds(160,450,100,30);
        pass.setBounds(110,480,40,70);
        passlabel.setBounds(160,505,100,30);
        //add fonts username & password
        telllabel.setFont(font);
        userlabel.setFont(font);
        passlabel.setFont(font);
        //Welcome Frame Text Fields
        usertext.setBounds(260,450,210,30);
        passtext.setBounds(260,505,210,30);
        //Welcome Frame Button Log in
        submitpass.setBounds(260,560,100,50);
        
        //add to password frame
        add(telllabel);
        add(user);
        add(pass);
        add(passlabel);
        add(userlabel);
        add(usertext);
        add(passtext);
        add(submitpass);
        //add actionlistener to password frame
        submitpass.addActionListener(this);
       
        setVisible(true);
        
        
        
        //create Choose Frame
        chooseframe.setLayout(null);
        chooseframe.setBounds(500, 50, 600, 650);
        icon2.setBounds(50,5,500,300);
        choose.setBounds(200,275,300,40);
        choose.setFont(font);
        doctor.setBounds(200, 330, 200, 50);
        doctorc.setBounds(140,330,40,70);
        patient.setBounds(200, 400, 200, 50);
        patientc.setBounds(130,395,60,70);
        test.setBounds(200, 470, 200, 50);
        testc.setBounds(130,460, 70,70);
        logout.setBounds(250, 540, 100, 50);
        //add button to choose frame
        chooseframe.add(icon2);
        chooseframe.add(choose);
        chooseframe.add(doctor);
        chooseframe.add(doctorc);
        chooseframe.add(patient);
        chooseframe.add(patientc);
        chooseframe.add(test);
        chooseframe.add(testc);
        chooseframe.add(logout);
        //add action listener to choose frame
        doctor.addActionListener(this);
        patient.addActionListener(this);
        test.addActionListener(this);
         logout.addActionListener(this);
        
        
        //choose Doctor operation frame
        Doperation.setLayout(null);
        Doperation.setBounds(500, 50, 600, 650);
        //add Labels to Doctor operation frame
        icon3.setBounds(50,20,500,300);
        chooseopd.setBounds(190,300,300,40);
        chooseopd.setFont(font);
        //Create Buttons to Doctor operation frame
        adddoctor.setBounds(60, 350, 200, 50);
        editdoctor.setBounds(310, 350, 200, 50);
        deletedoctor.setBounds(60, 420, 200, 50); 
        searchdoctor.setBounds(310, 420, 200, 50);
        doctorprevious.setBounds(60, 500, 450, 50);
        //add Buttons to Doctor operation frame
        Doperation.add(icon3);
        Doperation.add(chooseopd);
        Doperation.add(adddoctor);
        Doperation.add(editdoctor);
        Doperation.add(deletedoctor);
        Doperation.add(searchdoctor);
        Doperation.add(doctorprevious);
        //add action listener to Doctor operation frame
        adddoctor.addActionListener(this);
        editdoctor.addActionListener(this);
        deletedoctor.addActionListener(this);
        searchdoctor.addActionListener(this);
        doctorprevious.addActionListener(this);
        
  
        
        //Add Doctors Frame
        Add_Doctors.setLayout(null);
        Add_Doctors.setBounds(500, 50, 600, 650);
        //Add Doctors heading Label
        D1.setBounds(140,50,300,40);
        D1.setFont(font2);
        //Add Doctors Labels
        labeldssn.setFont(font);
        labeldname.setFont(font);
        labelspecialization.setFont(font);
        labeldssn.setBounds(100,150,100,30);
        labeldname.setBounds(100,250,100,30);
        labelspecialization.setBounds(100, 350, 120, 30);
        //Add Doctors Text Fields
        dssn.setBounds(240,150,210,30);
        dname.setBounds(240,250,210,30);
        specialization.setBounds(240, 350, 210, 30);  
        //create Doctors Buttuns
        dprevious.setBounds(150, 450, 100, 50);
     
        dinsert.setBounds(350, 450, 100, 50);
       
        //Add Doctors Buttuns
        Add_Doctors.add(D1);
        Add_Doctors.add(labeldssn);
        Add_Doctors.add(labeldname);
        Add_Doctors.add(labelspecialization);
        Add_Doctors.add(dssn);
        Add_Doctors.add(dname);
        Add_Doctors.add(specialization);
        Add_Doctors.add(dinsert);
        Add_Doctors.add(dprevious);
        //Add Doctors Buttuns Action Listener
        dinsert.addActionListener(this); 
        dprevious.addActionListener(this);
        
        
        
        //Edit Doctor Frame
        Edit_Doctors.setLayout(null);
        Edit_Doctors.setBounds(500, 50, 600, 650);
        //Edit Doctors heading Label
        ED1.setBounds(100,50,500,40);
        ED1.setFont(font2);
        //Edit Doctors Labels Fonts
        labeledssn.setFont(font);
        labeledname.setFont(font);
        labelespecialization.setFont(font);
        //Edit Doctors Label
        labeledssn.setBounds(100,150,100,30);
        labeledname.setBounds(100,250,100,30);
        labelespecialization.setBounds(100, 350, 120, 30);
        //Edit Doctors Text Fields
        edssn.setBounds(260,150,230,30);
        edname.setBounds(260,250,230,30);
        especialization.setBounds(260, 350, 230, 30);
        //Create Edit Doctors Buttons
        edprevious.setBounds(150, 450, 100, 50);
        
        edupdate.setBounds(350, 450, 100, 50);
          
        //Add Edit Doctors Buttons
        Edit_Doctors.add(ED1);
        Edit_Doctors.add(labeledssn);
        Edit_Doctors.add(labeledname);
        Edit_Doctors.add(labelespecialization);
        Edit_Doctors.add(edssn);
        Edit_Doctors.add(edname);
        Edit_Doctors.add(especialization);
        Edit_Doctors.add(edupdate);
        Edit_Doctors.add(edprevious);
        //Edit Doctors Buttuns Action Listener
        edupdate.addActionListener(this); 
        edprevious.addActionListener(this);
        
        
        //Delete Doctor Frame
        Delete_Doctors.setLayout(null);
        Delete_Doctors.setBounds(500, 50, 600, 650);
        //Delete Doctors heading Label
        DD1.setBounds(150,100,300,40);
        DD1.setFont(font2);
        //Delete Doctors Labels Fonts
        labelddssn.setFont(font);
        //Delete Doctors Label
        labelddssn.setBounds(150,250,100,30);
        //Delete Doctors Text Fields
        ddssn.setBounds(230,250,210,30);
        //Create Delete Doctors Buttons
        ddprevious.setBounds(150, 450, 100, 50);
      
        ddelete.setBounds(350, 450, 100, 50);
       
        //Add Delete Doctors Buttons
        Delete_Doctors.add(DD1);
        Delete_Doctors.add(labelddssn);
        Delete_Doctors.add(ddssn);
        Delete_Doctors.add(ddelete);
        Delete_Doctors.add(ddprevious);
        //Delete Doctors Buttuns Action Listener
        ddelete.addActionListener(this); 
        ddprevious.addActionListener(this);
        
        
        
        //Search Doctor Frame
        Search_Doctors.setLayout(null);
        Search_Doctors.setBounds(500, 50, 600, 650);
        //Search Doctors heading Label
        SD1.setBounds(140,50,300,40);
        SD1.setFont(font2);
        //Search Doctors Labels Fonts
        labelsdssn.setFont(font);
        labelsdname.setFont(font);
        labelsspecialization.setFont(font);
        labelsdssn.setBounds(100,150,150,30);
        labelsdname.setBounds(100,250,150,30);
        labelsspecialization.setBounds(100, 350, 200, 30);
        //Search Doctors Text Fields
        sdssn.setBounds(280,150,210,30);
        sdname.setBounds(280,250,210,30);
        sspecialization.setBounds(280, 350, 210, 30);
        //Create Search Doctors Buttons
        sdprevious.setBounds(150, 450, 100, 50);
      
        dsearch.setBounds(350, 450, 100, 50);
       
        //Add Search Doctors Buttons
        Search_Doctors.add(SD1);
        Search_Doctors.add(labelsdssn);
        Search_Doctors.add(labelsdname);
        Search_Doctors.add(labelsspecialization);
        Search_Doctors.add(sdssn);
        Search_Doctors.add(sdname);
        Search_Doctors.add(sspecialization);
        Search_Doctors.add(dsearch);
        Search_Doctors.add(sdprevious);
        //Search Doctors Buttuns Action Listener
        dsearch.addActionListener(this); 
        sdprevious.addActionListener(this);
        
        
        
        
        //choose Patient operation frame
        Poperation.setLayout(null);
        Poperation.setBounds(500, 50, 600, 650);
        //add Labels to Patient operation frame
        icon4.setBounds(50,20,500,300);
        chooseopp.setBounds(190,300,300,40);
        chooseopp.setFont(font);
        //Create Buttons to Patient operation frame
        addpatient.setBounds(60, 350, 200, 50);
        editpatient.setBounds(310, 350, 200, 50);
        deletepatient.setBounds(60, 420, 200, 50); 
        searchpatient.setBounds(310, 420, 200, 50);
        patientprevious.setBounds(60, 500, 450, 50);
        //add Buttons to Patient operation frame
        Poperation.add(icon4);
        Poperation.add(chooseopp);
        Poperation.add(addpatient);
        Poperation.add(editpatient);
        Poperation.add(deletepatient);
        Poperation.add(searchpatient);
        Poperation.add(patientprevious);
        //add action listener to Patient operation frame
        addpatient.addActionListener(this);
        editpatient.addActionListener(this);
        deletepatient.addActionListener(this);
        searchpatient.addActionListener(this);
        patientprevious.addActionListener(this);
        
        
           
        //Add_patients Frame
        Add_Patients.setLayout(null);
        Add_Patients.setBounds(500, 50, 600, 650);
        //Add Patients heading Label
        P1.setBounds(180,50,250,40);
        P1.setFont(font2);
        //Add Patients Labels Font
        labelssn.setFont(font);
        labelname.setFont(font);
        labelmedical.setFont(font);
        labeldate_admitted.setFont(font);
        labeldate_checkedout.setFont(font);
        //Add Patients Labels
        labelssn.setBounds(100,150,100,30);
        labelname.setBounds(100,210,100,30);
        labelmedical.setBounds(100, 270, 150, 30);
        labeldate_admitted.setBounds(100,330,150,30);
        labeldate_checkedout.setBounds(100,390,160,30);
        //Add Patients Texts Fields
        ssn.setBounds(280, 150, 210, 30);
        name.setBounds(280,210, 210, 30);
        medical_insurance.setBounds(280, 270, 210,30); 
        date_admitted.setBounds(280, 330, 210, 30);
        date_checked_out.setBounds(280, 390, 210, 30); 
        //Create Patients Buttuns
        pprevious.setBounds(150, 480, 100, 50);
       
        pinsert.setBounds(350, 480, 100, 50);
       
        //Add Patients Buttuns
        Add_Patients.add(P1);
        Add_Patients.add(labelssn);
        Add_Patients.add(labelname);
        Add_Patients.add(labelmedical);
        Add_Patients.add(labeldate_admitted);
        Add_Patients.add(labeldate_checkedout);  
        Add_Patients.add(ssn);
        Add_Patients.add(name);
        Add_Patients.add(medical_insurance);
        Add_Patients.add(date_admitted); 
        Add_Patients.add(date_checked_out); 
        Add_Patients.add(pinsert);
        Add_Patients.add(pprevious);
        //Add Patients Buttuns Action Listener
        pprevious.addActionListener(this);
        pinsert.addActionListener(this);
       
        
        
        
        //Edit_patients Frame
        Edit_Patients.setLayout(null);
        Edit_Patients.setBounds(500, 50, 600, 650);
        //Edit Patients heading Label
        EP1.setBounds(100,50,500,40);
        EP1.setFont(font2);
        //Edit Patients Labels Font
        labelessn.setFont(font);
        labelename.setFont(font);
        labelemedical.setFont(font);
        labeledate_admitted.setFont(font);
        labeledate_checkedout.setFont(font);
        //Edit Patients Labels
        labelessn.setBounds(100,150,100,30);
        labelename.setBounds(100,210,100,30);
        labelemedical.setBounds(100, 270, 150, 30);
        labeledate_admitted.setBounds(100,330,150,30);
        labeledate_checkedout.setBounds(100,390,160,30);
        //Edit Patients Texts Fields
        essn.setBounds(280, 150, 210, 30);
        ename.setBounds(280,210, 210, 30);
        emedical_insurance.setBounds(280, 270, 210,30); 
        edate_admitted.setBounds(280, 330, 210, 30);
        edate_checked_out.setBounds(280, 390, 210, 30);
        //Create Edit Patients Buttuns
        epprevious.setBounds(150, 480, 100, 50);
       
        epupdate.setBounds(350, 480, 100, 50);
       
        //Add Edit Patients Buttuns
        Edit_Patients.add(EP1);
        Edit_Patients.add(labelessn);
        Edit_Patients.add(labelename);
        Edit_Patients.add(labeledate_admitted);
        Edit_Patients.add(labeledate_checkedout);
        Edit_Patients.add(labelemedical);
        Edit_Patients.add(essn);
        Edit_Patients.add(ename);
        Edit_Patients.add(edate_checked_out);
        Edit_Patients.add(edate_admitted);
        Edit_Patients.add(emedical_insurance);
        Edit_Patients.add(epprevious);
        Edit_Patients.add(epupdate);
        //Edit Patients Buttuns Action Listener
        epupdate.addActionListener(this); 
        epprevious.addActionListener(this);
        
        
        
        //Delete Patients Frame
        Delete_Patients.setLayout(null);
        Delete_Patients.setBounds(500, 50, 600, 650);
        //Delete Doctors heading Label
        PD1.setBounds(150,100,300,40);
        PD1.setFont(font2);
        //Delete Patients Labels Fonts
        labeldpssn.setFont(font);
        //Delete Patients Label
        labeldpssn.setBounds(150,250,100,30);
        //Delete Patients Text Fields
        dpssn.setBounds(230,250,210,30);
        //Create Delete Patients Buttons
        dpprevious.setBounds(150, 450, 100, 50);
       
        pdelete.setBounds(350, 450, 100, 50);
       
        //Add Delete Patients Buttons
        Delete_Patients.add(PD1);
        Delete_Patients.add(labeldpssn);
        Delete_Patients.add(dpssn);
        Delete_Patients.add(pdelete);
        Delete_Patients.add(dpprevious);
        //Delete Patients Buttuns Action Listener
        pdelete.addActionListener(this); 
        dpprevious.addActionListener(this);
         
        
        //Search_patients Frame
        Search_Patients.setLayout(null);
        Search_Patients.setBounds(500, 50, 600, 650);
        //Search Patients heading Label
        SP1.setBounds(140,50,300,40);
        SP1.setFont(font2);
        //Search Patients Labels Font
        labelsssn.setFont(font);
        labelsname.setFont(font);
        labelsmedical.setFont(font);
        labelsdate_admitted.setFont(font);
        labelsdate_checkedout.setFont(font);
        //Search Patients Labels
        labelsssn.setBounds(80,150,150,30);
        labelsname.setBounds(80,210,150,30);
        labelsmedical.setBounds(80, 270, 200, 30);
        labelsdate_admitted.setBounds(80,330,200,30);
        labelsdate_checkedout.setBounds(80,390,200,30);
        //Search Patients Texts Fields
        sssn.setBounds(300, 150, 210, 30);
        sname.setBounds(300,210, 210, 30);  
        smedical_insurance.setBounds(300, 270, 210,30); 
        sdate_admitted.setBounds(300, 330, 210, 30);
         sdate_checked_out.setBounds(300, 390, 210, 30);
        //Create Search Patients Buttuns
        spprevious.setBounds(150, 480, 100, 50);
      
        psearch.setBounds(350, 480, 100, 50);
      
        //Add Search Patients Buttuns
        Search_Patients.add(SP1);
        Search_Patients.add(labelsssn);
        Search_Patients.add(labelsname);
        Search_Patients.add(labelsdate_admitted);
        Search_Patients.add(labelsdate_checkedout);
        Search_Patients.add(labelsmedical);
        Search_Patients.add(sssn);
        Search_Patients.add(sname);
        Search_Patients.add(sdate_checked_out);
        Search_Patients.add(sdate_admitted);
        Search_Patients.add(smedical_insurance);
        Search_Patients.add(spprevious);
        Search_Patients.add(psearch);
        //Edit Patients Buttuns Action Listener
        psearch.addActionListener(this); 
        spprevious.addActionListener(this);
        
        
        
        //choose Test operation frame
        Toperation.setLayout(null);
        Toperation.setBounds(500, 50, 600, 650);
        //add Labels to Patient operation frame
        icon5.setBounds(50,20,500,300);
        chooseopt.setBounds(190,300,300,40);
        chooseopt.setFont(font);
        //Create Buttons to Test operation frame
        addtest.setBounds(60, 350, 200, 50);
        edittest.setBounds(310, 350, 200, 50);
        deletetest.setBounds(60, 420, 200, 50); 
        searchtest.setBounds(310, 420, 200, 50);
        testprevious.setBounds(60, 500, 450, 50);
        //add Buttons to Test operation frame
        Toperation.add(icon5);
        Toperation.add(chooseopt);
        Toperation.add(addtest);
        Toperation.add(edittest);
        Toperation.add(deletetest);
        Toperation.add(searchtest);
        Toperation.add(testprevious);
        //add action listener to Test operation frame
        addtest.addActionListener(this);
        edittest.addActionListener(this);
        deletetest.addActionListener(this);
        searchtest.addActionListener(this);
        testprevious.addActionListener(this);
        
  
        //Add Tests Frame
        Add_Tests.setLayout(null);
        Add_Tests.setBounds(500, 50, 600, 650);
        //Add Tests heading Label
        T1.setBounds(200,50,250,40);
        T1.setFont(font2);
        //Add Tests Labels Font
        labelTid.setFont(font);
        labelTname.setFont(font);
        labelTdate.setFont(font);
        labelTtime.setFont(font);
        labelTresult.setFont(font);
        //Add Tests Labels
        labelTid.setBounds(100,150,100,30);
        labelTname.setBounds(100,210,100,30);
        labelTdate.setBounds(100, 270, 150, 30);
        labelTtime.setBounds(100,330,150,30);
        labelTresult.setBounds(100,390,160,30);
        //Add Tests Text Fields
        Tid.setBounds(280, 150, 210, 30);
        Tname.setBounds(280,210, 210, 30);
        Tdate.setBounds(280, 270, 210, 30);
        Ttime.setBounds(280, 330, 210, 30);
        Tresult.setBounds(280, 390, 210,30); 
        //Create Tests Buttuns
        Tprevious.setBounds(150, 480, 100, 50);
        
        Tinsert.setBounds(350, 480, 100, 50);
       
        //Add Tests Buttuns
        Add_Tests.add(T1);
        Add_Tests.add(labelTid);
        Add_Tests.add(labelTname);
        Add_Tests.add(labelTdate);
        Add_Tests.add(labelTtime);
        Add_Tests.add(labelTresult);
        Add_Tests.add(Tid);
        Add_Tests.add(Tname);
        Add_Tests.add(Tdate);
        Add_Tests.add(Ttime);
        Add_Tests.add(Tresult);
        Add_Tests.add(Tinsert);
        Add_Tests.add(Tprevious);
        //Add Tests Buttuns Action Listener
        Tprevious.addActionListener(this);
        Tinsert.addActionListener(this);
          
        
        
        //Edit Tests Frame
        Edit_Tests.setLayout(null);
        Edit_Tests.setBounds(500, 50, 600, 650);
        //Edit Tests heading Label
        ET1.setBounds(130,50,300,40);
        ET1.setFont(font2);
        //Edit Tests Labels Font
        labeleTid.setFont(font);
        labeleTname.setFont(font);
        labeleTdate.setFont(font);
        labeleTtime.setFont(font);
        labeleTresult.setFont(font);
        //Edit Tests Labels
        labeleTid.setBounds(130,150,100,30);
        labeleTname.setBounds(130,210,100,30);
        labeleTdate.setBounds(130, 270, 150, 30);
        labeleTtime.setBounds(130,330,150,30);
        labeleTresult.setBounds(130,390,160,30);
        //Edit Tests Text Fields
        eTid.setBounds(250, 150, 210, 30);
        eTname.setBounds(250,210, 210, 30);
        eTdate.setBounds(250, 270, 210, 30);
        eTtime.setBounds(250, 330, 210, 30);
        eTresult.setBounds(250, 390, 210,30); 
        //Create Edit Tests Buttuns
        eTprevious.setBounds(150, 480, 100, 50);
     
        eTupdate.setBounds(350, 480, 100, 50);
      
        //Add Edit Tests Buttuns
        Edit_Tests.add(ET1);
        Edit_Tests.add(labeleTid);
        Edit_Tests.add(labeleTname);
        Edit_Tests.add(labeleTdate);
        Edit_Tests.add(labeleTtime);
        Edit_Tests.add(labeleTresult);
        Edit_Tests.add(eTid);
        Edit_Tests.add(eTname);
        Edit_Tests.add(eTdate);
        Edit_Tests.add(eTtime);
        Edit_Tests.add(eTresult);
        Edit_Tests.add(eTupdate);
        Edit_Tests.add(eTprevious);
        //Edit Tests Buttuns Action Listener 
        eTupdate.addActionListener(this); 
        eTprevious.addActionListener(this);
        
        
        
        //Delete Tests Frame
        Delete_Tests.setLayout(null);
        Delete_Tests.setBounds(500, 50, 600, 650);
        //Delete Tests heading Label
        TD1.setBounds(190,100,300,40);
        TD1.setFont(font2);
        //Delete Tests Labels Fonts
        labelid.setFont(font);
        //Delete Patients Label
        labelid.setBounds(150,250,100,30);
        //Delete Patients Text Fields
        dTid.setBounds(230,250,210,30);
        //Create Delete Patients Buttons
        dtprevious.setBounds(150, 450, 100, 50);
       
        tdelete.setBounds(350, 450, 100, 50);
       
        //Add Delete Patients Buttons
        Delete_Tests.add(TD1);
        Delete_Tests.add(labelid);
        Delete_Tests.add(dTid);
        Delete_Tests.add(tdelete);
        Delete_Tests.add(dtprevious);
        //Delete Patients Buttuns Action Listener
        tdelete.addActionListener(this); 
        dtprevious.addActionListener(this);
        
        
        
        //Search_Tests Frame
        Search_Tests.setLayout(null);
        Search_Tests.setBounds(500, 50, 600, 650);
        //Search Tests heading Label
        ST1.setBounds(190,50,300,40);
        ST1.setFont(font2);
        //Search Tests Labels Font
        labelsTid.setFont(font);
        labelsTname.setFont(font);
        labelsTdate.setFont(font);
        labelsTtime.setFont(font);
        labelsTresult.setFont(font);
        //Search Tests Labels
        labelsTid.setBounds(130,150,100,30);
        labelsTname.setBounds(130,210,100,30);
        labelsTdate.setBounds(130, 270, 150, 30);
        labelsTtime.setBounds(130,330,150,30);
        labelsTresult.setBounds(130,390,160,30);
        //Search Tests Texts Fields
        sTid.setBounds(250, 150, 210, 30);
        sTname.setBounds(250,210, 210, 30);
        sTdate.setBounds(250, 270, 210, 30);
        sTtime.setBounds(250, 330, 210, 30);
        sTresult.setBounds(250, 390, 210,30); 
        //Create Search Tests Buttuns
        stprevious.setBounds(150, 480, 100, 50);
       
        tsearch.setBounds(350, 480, 100, 50);
      
        //Add Search Tests Buttuns
        Search_Tests.add(ST1);
        Search_Tests.add(labelsTid);
        Search_Tests.add(labelsTname);
        Search_Tests.add(labelsTdate);
        Search_Tests.add(labelsTtime);
        Search_Tests.add(labelsTresult);
        Search_Tests.add(sTid);
        Search_Tests.add(sTname);
        Search_Tests.add(sTdate);
        Search_Tests.add(sTtime);
        Search_Tests.add(sTresult);
        Search_Tests.add(tsearch);
        Search_Tests.add(stprevious);
        //Search Tests Buttuns Action Listener 
        tsearch.addActionListener(this); 
        stprevious.addActionListener(this);
       

    }


//    Method to search for Doctor
    public class Dmethod{
            Connection con=null;
            ResultSet rs=null;
            PreparedStatement ps=null;
           
             public ResultSet find(String s){
                 try{
              con=DriverManager.getConnection(url, username, password);
              ps=con.prepareStatement("select * from Medical_Doctor where DSSN=?");
              ps.setString(1, s);
              rs=ps.executeQuery();
                 }
                 catch(Exception e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
                 
                 }
             return rs;
             }
           
           }

    
    
    
    //    Method to search for patient
    public class Pmethod{
            Connection con=null;
            ResultSet rs=null;
            PreparedStatement ps=null;
           
             public ResultSet find(String s){
                 try{
              con=DriverManager.getConnection(url, username, password);
              ps=con.prepareStatement("select * from Patients where SSN=?");
              ps.setString(1, s);
              rs=ps.executeQuery();
                 }
                 catch(Exception e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
                 
                 }
             return rs;
             }
           
           }
    
    
    
    
    
    //    Method to search for Tests
    public class Tmethod{
            Connection con=null;
            ResultSet rs=null;
            PreparedStatement ps=null;
           
             public ResultSet find(String s){
                 try{
              con=DriverManager.getConnection(url, username, password);
              ps=con.prepareStatement("select * from Tests where test_id=?");
              ps.setString(1, s);
              rs=ps.executeQuery();
                 }
                 catch(Exception e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
                 
                 }
             return rs;
             }
    }
   
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {

        if (ae.getSource()==submitpass)
        {
         if(usertext.getText().equals("Ahmed")&&passtext.getText().equals("1621"))
         {
             chooseframe.setVisible(true);
             setVisible(false);
             usertext.setText("");
             passtext.setText("");
         }
         else 
             telllabel.setText("Wrong Username or Password try again :");
             usertext.setText("");
             passtext.setText("");
        }
        
        
        
        else if (ae.getSource()==doctor)
        {
            Doperation.setVisible(true);
            chooseframe.setVisible(false);
        }
          else if(ae.getSource()==doctorprevious)
        {
            Doperation.setVisible(false);
            chooseframe.setVisible(true);
        }
          
          
           else if (ae.getSource()==logout)
        {
            setVisible(true);
            chooseframe.setVisible(false);
        }
         
          
          
          
        else if (ae.getSource()==adddoctor)
        {
            Add_Doctors.setVisible(true);
            Doperation.setVisible(false); 
        }
          else if(ae.getSource()==dprevious)
        {
            Add_Doctors.setVisible(false);
            Doperation.setVisible(true);
        }
          
          
           else if (ae.getSource()==editdoctor)
        {
            Edit_Doctors.setVisible(true);
            Doperation.setVisible(false);
        }
         else if(ae.getSource()==edprevious)
        { 
            Edit_Doctors.setVisible(false);   
            Doperation.setVisible(true);
        }
         
         
         
         else if (ae.getSource()==deletedoctor)
        {
            Delete_Doctors.setVisible(true);
            Doperation.setVisible(false);
        }
         else if(ae.getSource()==ddprevious)
        { 
            Delete_Doctors.setVisible(false);   
            Doperation.setVisible(true);
        }
         
         
        else if (ae.getSource()==searchdoctor)
        {
            Search_Doctors.setVisible(true);
            Doperation.setVisible(false);
        }
         else if(ae.getSource()==sdprevious)
        { 
            Search_Doctors.setVisible(false);   
            Doperation.setVisible(true);
        }  
  
          
          
         
         else if(ae.getSource()==dinsert)
        {
            try
            {
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url, username, password);
                String sql="Insert into Medical_Doctor"
                        +"(dssn,name,specialization)"
                        +"values(?,?,?)";
                PreparedStatement stm=con.prepareCall(sql);//same name in String 
                stm.setString(1, dssn.getText());
                stm.setString(2, dname.getText());
                stm.setString(3, specialization.getText());
                
                stm.executeUpdate();
                JOptionPane.showMessageDialog(this, "Inserted");
                
                dssn.setText("");
                dname.setText("");
                specialization.setText("");
            }   
        catch(Exception e)
            {
                 JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }
          
         
           else if(ae.getSource()==edupdate)
        {
         try
            {
               Class.forName(driver);
               Connection con=DriverManager.getConnection(url, username, password);
               String sql="update Medical_Doctor set  name=?,specialization=?  where DSSN=?";
               PreparedStatement stm=con.prepareCall(sql);//same name in String 
               stm.setString(1, edname.getText());
               stm.setString(2, especialization.getText());
               stm.setString(3, edssn.getText());

               stm.executeUpdate();
               JOptionPane.showMessageDialog(this, "Updated");
                             
               edname.setText("");
               especialization.setText("");
               edssn.setText("");
           }   
        catch(Exception e)
            {
               JOptionPane.showMessageDialog(this,e.getMessage());
            } 
        }
           
           
           else if(ae.getSource()==ddelete)
           {
            try
             {
                 Class.forName(driver);
                 Connection con=DriverManager.getConnection(url, username, password);
                 String sql="Delete from Medical_Doctor where DSSN=?";
                 PreparedStatement stm=con.prepareCall(sql);
                 stm.setString(1, ddssn.getText());
                 
                 stm.executeUpdate();
                 JOptionPane.showMessageDialog(this,"Deleted");
                 
                 ddssn.setText("");
             }   
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
           }
           
         
          
           
         else if(ae.getSource()==dsearch)
           {
           
               Dmethod f=new Dmethod();
               ResultSet rs=null;
               String Name="Name";
               String Specialization="Specialization";
               
               rs=f.find( sdssn.getText());
              
           try{
            
                if(rs.next()){
                
                 sdname.setText(rs.getString("Name"));
                 sspecialization.setText(rs.getString("Specialization"));

                 }
                else
                {
                JOptionPane.showMessageDialog(null,"NO DATA FOR THIS ID");
                }
          
//           JOptionPane.showMessageDialog(this, "Showed");
              }   
            catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
               }

         
           
         
         else if (ae.getSource()==patient)
        {
            Poperation.setVisible(true);
            chooseframe.setVisible(false);
        }
          else if(ae.getSource()==patientprevious)
        {
            Poperation.setVisible(false);
            chooseframe.setVisible(true);
        }
         
        else if (ae.getSource()==addpatient)
        {
            Add_Patients.setVisible(true);
            Poperation.setVisible(false);
        }
         else if(ae.getSource()==pprevious)
        {
            Add_Patients.setVisible(false);
            Poperation.setVisible(true);
        }
        
         
         
         else if (ae.getSource()==editpatient)
        {
            Edit_Patients.setVisible(true);
            Poperation.setVisible(false);
        }
        
         else if(ae.getSource()==epprevious)
        { 
            Edit_Patients.setVisible(false);   
            Poperation.setVisible(true);
        }
         
         
         else if (ae.getSource()==deletepatient)
        {
            Delete_Patients.setVisible(true);
            Poperation.setVisible(false);
        }
         else if(ae.getSource()==dpprevious)
        { 
            Delete_Patients.setVisible(false);   
            Poperation.setVisible(true);
        }
         
         
         else if (ae.getSource()==searchpatient)
        {
            Search_Patients.setVisible(true);
            Poperation.setVisible(false);
        }
         else if(ae.getSource()==spprevious)
        { 
            Search_Patients.setVisible(false);   
            Poperation.setVisible(true);
        }  
         
         
         
         
         else if(ae.getSource()==pinsert)
        {
            try
            {
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url, username, password);
                String sql="Insert into Patients"
                        +"(ssn,name,medical_insurance,date_admitted,date_checkedout)"
                        +"values(?,?,?,?,?)";
                PreparedStatement stm=con.prepareCall(sql);//same name in String 
                stm.setString(1, ssn.getText());
                stm.setString(2, name.getText());
                stm.setString(3, medical_insurance.getText());
                stm.setString(4, date_admitted.getText());
                stm.setString(5, date_checked_out.getText());
                
                stm.executeUpdate();
                JOptionPane.showMessageDialog(this, "Inserted");
                
                ssn.setText("");
                name.setText("");
                date_checked_out.setText("");
                date_admitted.setText("");
                medical_insurance.setText("");
            }   
        catch(Exception e)
            {
                 JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }
          
         
           else if(ae.getSource()==epupdate)
        {
         try
            {
               Class.forName(driver);
               Connection con=DriverManager.getConnection(url, username, password);
               String sql="update Patients set  name=?,medical_insurance=?,date_admitted=?,date_checkedout=?  where SSN=?";
               PreparedStatement stm=con.prepareCall(sql);//same name in String 
               
               stm.setString(1, ename.getText());
               stm.setString(2, emedical_insurance.getText());
               stm.setString(3, edate_admitted.getText());
               stm.setString(4, edate_checked_out.getText());
               stm.setString(5, essn.getText());
               
               stm.executeUpdate();
               JOptionPane.showMessageDialog(this, "Updated");
               
               ename.setText("");
               edate_checked_out.setText("");
               edate_admitted.setText("");
               emedical_insurance.setText("");
               essn.setText("");
           }   
        catch(Exception e)
            {
               JOptionPane.showMessageDialog(this,e.getMessage());
            } 
        }
           
           
           else if(ae.getSource()==pdelete)
           {
            try
             {
                 Class.forName(driver);
                 Connection con=DriverManager.getConnection(url, username, password);
                 String sql="Delete from Patients where SSN=?";
                 PreparedStatement stm=con.prepareCall(sql);
                 stm.setString(1, dpssn.getText());
                 stm.executeUpdate();
                 JOptionPane.showMessageDialog(this,"Deleted");
                 
                 dpssn.setText("");
             }   
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
           }
         
           
           
           else if(ae.getSource()==psearch)
           {
           
               Pmethod f=new Pmethod();
               ResultSet rs=null;
               
               String name="name";
               String medical_insurance="medical_insurance";
               String date_admitted="date_admitted";
               String date_checkedout="date_checkedout";
               
               rs=f.find( sssn.getText());
              
           try{
            
                if(rs.next()){
                
                 sname.setText(rs.getString("name"));
                 smedical_insurance.setText(rs.getString("medical_insurance"));
                 sdate_admitted.setText(rs.getString("date_admitted"));
                 sdate_checked_out.setText(rs.getString("date_checkedout"));
                 
                 }
                else
                {
                JOptionPane.showMessageDialog(null,"NO DATA FOR THIS ID");
                }
          
//           JOptionPane.showMessageDialog(this, "Showed");
              }   
            catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
               }

           
           
  
           
         
         else if (ae.getSource()==test)
        {
            Toperation.setVisible(true);
            chooseframe.setVisible(false);
        }
          else if(ae.getSource()==testprevious)
        {
            Toperation.setVisible(false);
            chooseframe.setVisible(true);
        }
          
          
        else if (ae.getSource()==addtest)
        {
            Add_Tests.setVisible(true);
            Toperation.setVisible(false);
        }
         else if(ae.getSource()==Tprevious)
        { 
            Add_Tests.setVisible(false);   
            Toperation.setVisible(true);
        }
        
        
         
        else if (ae.getSource()==edittest)
        {
            Edit_Tests.setVisible(true);
            Toperation.setVisible(false);
        }
         else if(ae.getSource()==eTprevious)
        { 
            Edit_Tests.setVisible(false);   
            Toperation.setVisible(true);
        }
        
         else if (ae.getSource()==deletetest)
        {
            Delete_Tests.setVisible(true);
            Toperation.setVisible(false);
        }
         else if(ae.getSource()==dtprevious)
        { 
            Delete_Tests.setVisible(false);   
            Toperation.setVisible(true);
        }
        
        
        else if (ae.getSource()==searchtest)
        {
            Search_Tests.setVisible(true);
            Toperation.setVisible(false);
        }
         else if(ae.getSource()==stprevious)
        { 
            Search_Tests.setVisible(false);   
            Toperation.setVisible(true);
        }  
             
        
        
        
         else if(ae.getSource()==Tinsert)
        {
            try
            {
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url, username, password);
                String sql="Insert into Tests"
                        +"(test_id,test_name,test_date,test_time,result)"
                        +"values(?,?,?,?,?)";
                PreparedStatement stm=con.prepareCall(sql);//same name in String 
                stm.setString(1, Tid.getText());
                stm.setString(2, Tname.getText());
                stm.setString(3, Tdate.getText());
                stm.setString(4, Ttime.getText());
                stm.setString(5, Tresult.getText());
                
                stm.executeUpdate();
                JOptionPane.showMessageDialog(this, "Inserted");
                
                Tid.setText("");
                Tname.setText("");
                Tdate.setText("");
                Ttime.setText("");
                Tresult.setText("");
            }   
        catch(Exception e)
            {
                 JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }
          
         
           else if(ae.getSource()==eTupdate)
        {
         try
            {
               Class.forName(driver);
               Connection con=DriverManager.getConnection(url, username, password);
               String sql="update Tests set  test_name=?,test_date=?,test_time=?,result=?  where test_id=?";
               PreparedStatement stm=con.prepareCall(sql);//same name in String 
               
               stm.setString(1, eTname.getText());
               stm.setString(2, eTdate.getText());
               stm.setString(3, eTtime.getText());
               stm.setString(4, eTresult.getText());
               stm.setString(5, eTid.getText());
               
               stm.executeUpdate();
               JOptionPane.showMessageDialog(this, "Updated");
               eTname.setText("");
               eTdate.setText("");
               eTtime.setText("");
               eTresult.setText("");
               eTid.setText("");
               
           }   
        catch(Exception e)
            {
               JOptionPane.showMessageDialog(this,e.getMessage());
            } 
        }
           
           
           else if(ae.getSource()==tdelete)
           {
            try
             {
                 Class.forName(driver);
                 Connection con=DriverManager.getConnection(url, username, password);
                 String sql="Delete from Tests where test_id=?";
                 PreparedStatement stm=con.prepareCall(sql);
                 stm.setString(1, dTid.getText());
                 
                 stm.executeUpdate();
                 JOptionPane.showMessageDialog(this,"Deleted");
                 
                 dTid.setText("");
             }   
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
           }
        
        
        
        
        else if(ae.getSource()==tsearch)
           {
           
               Tmethod f=new Tmethod();
               ResultSet rs=null;
               
               String test_name="test_name";
               String test_date="test_date";
               String test_time="test_time";
               String result="result";
               
               rs=f.find( sTid.getText());
              
           try{
            
                if(rs.next()){
                
                 sTname.setText(rs.getString("test_name"));
                 sTdate.setText(rs.getString("test_date"));
                 sTtime.setText(rs.getString("test_time"));
                 sTresult.setText(rs.getString("result"));
                 
                 }
                else
                {
                JOptionPane.showMessageDialog(null,"NO DATA FOR THIS ID");
                }
          
//           JOptionPane.showMessageDialog(this, "Showed");
              }   
            catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
               }

        
        
        
    }  

      public static void main(String[] args) 
    {
        Hospital_Interface H1=new Hospital_Interface();
    }
      
}
 