/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college.planner;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class MainFrame extends javax.swing.JFrame {
    public MainFrame() {
        initComponents();
        load();
        changePanel("Login");
    }
    ArrayList<db_User> db = new ArrayList<>();
    /**
     *
     * @param panel
     * Ganti-ganti panel disini
     * "Login" / "Register" / "Home"
     */
    public void changePanel(String panel){
        Login.setVisible(false);
        Register.setVisible(false);
        if (panel.equals("Login")) {
            Login.setVisible(true);
        }
        else if(panel.equals("Register")){
            Register.setVisible(true);
        }
        else if(panel.equals("Home")){
            Home.setVisible(true);
        }
        else{
            System.exit(0);
        }
    }
    
    public void load(){
        try{
            FileInputStream fin = new FileInputStream("src/data/data.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            db = (ArrayList<db_User>) ois.readObject();
            ois.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void save(){
        try{
            FileOutputStream fout = new FileOutputStream("src/data/data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(db);
            oos.close();
            System.out.println("Saved");

       }catch(Exception e){
            System.out.println(e);
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Register_ButtonGroup = new javax.swing.ButtonGroup();
        Register = new javax.swing.JPanel();
        Register_Container = new javax.swing.JPanel();
        Register_LabelTitle = new javax.swing.JLabel();
        Register_LabelUsername = new javax.swing.JLabel();
        Register_Username = new javax.swing.JTextField();
        Register_LabelPassword = new javax.swing.JLabel();
        Register_FirstName = new javax.swing.JTextField();
        Register_Password1 = new javax.swing.JPasswordField();
        Register_Password2 = new javax.swing.JPasswordField();
        Register_LabelConfirmPassword = new javax.swing.JLabel();
        Register_LabelFirstName = new javax.swing.JLabel();
        Register_LastName = new javax.swing.JTextField();
        Register_LabelLastName = new javax.swing.JLabel();
        Register_LabelDate = new javax.swing.JLabel();
        Register_ButtonRegister = new javax.swing.JButton();
        Register_LabelGender = new javax.swing.JLabel();
        Register_RadioMale = new javax.swing.JRadioButton();
        Register_RadioFemale = new javax.swing.JRadioButton();
        Register_CheckTOS = new javax.swing.JCheckBox();
        Register_DatePicker = new com.github.lgooddatepicker.components.DatePicker();
        Register_LabelEmail = new javax.swing.JLabel();
        Register_Email = new javax.swing.JTextField();
        Register_LabelHaveAnAccount = new javax.swing.JLabel();
        Register_LabelLogin = new javax.swing.JLabel();
        Login = new javax.swing.JPanel();
        Login_Container = new javax.swing.JPanel();
        Login_LabelTitle = new javax.swing.JLabel();
        Login_Username = new javax.swing.JTextField();
        Login_LabelUsername = new javax.swing.JLabel();
        Login_LabelPassword = new javax.swing.JLabel();
        Login_ButtonLogin = new javax.swing.JButton();
        Login_Password = new javax.swing.JPasswordField();
        Login_Container_Reg = new javax.swing.JPanel();
        Login_LabelDontHaveAnAcc = new javax.swing.JLabel();
        Login_LabelSignUp = new javax.swing.JLabel();
        Home = new javax.swing.JPanel();
        Home_Title = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        Register_Container.setBackground(new java.awt.Color(65, 49, 24));

        Register_LabelTitle.setText("Create New Account");
        Register_LabelTitle.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        Register_LabelTitle.setForeground(new java.awt.Color(255, 255, 255));

        Register_LabelUsername.setText("Username");
        Register_LabelUsername.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_LabelUsername.setForeground(new java.awt.Color(255, 255, 255));

        Register_Username.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Register_LabelPassword.setText("Password");
        Register_LabelPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_LabelPassword.setForeground(new java.awt.Color(255, 255, 255));

        Register_FirstName.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Register_Password1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Register_Password2.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Register_LabelConfirmPassword.setText("Confirm Password");
        Register_LabelConfirmPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_LabelConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));

        Register_LabelFirstName.setText("First Name");
        Register_LabelFirstName.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_LabelFirstName.setForeground(new java.awt.Color(255, 255, 255));

        Register_LastName.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Register_LabelLastName.setText("Last Name");
        Register_LabelLastName.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_LabelLastName.setForeground(new java.awt.Color(255, 255, 255));

        Register_LabelDate.setText("Date of Birth");
        Register_LabelDate.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_LabelDate.setForeground(new java.awt.Color(255, 255, 255));

        Register_ButtonRegister.setText("Register");
        Register_ButtonRegister.setBackground(new java.awt.Color(51, 0, 204));
        Register_ButtonRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        Register_ButtonRegister.setForeground(new java.awt.Color(255, 255, 255));
        Register_ButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_ButtonRegisterActionPerformed(evt);
            }
        });

        Register_LabelGender.setText("Gender");
        Register_LabelGender.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_LabelGender.setForeground(new java.awt.Color(255, 255, 255));

        Register_RadioMale.setBackground(new java.awt.Color(65, 49, 24));
        Register_ButtonGroup.add(Register_RadioMale);
        Register_RadioMale.setForeground(new java.awt.Color(255, 255, 255));
        Register_RadioMale.setSelected(true);
        Register_RadioMale.setText("Male");

        Register_RadioFemale.setBackground(new java.awt.Color(65, 49, 24));
        Register_ButtonGroup.add(Register_RadioFemale);
        Register_RadioFemale.setForeground(new java.awt.Color(255, 255, 255));
        Register_RadioFemale.setText("Female");

        Register_CheckTOS.setText("I Agree to the Terms of Use");
        Register_CheckTOS.setBackground(new java.awt.Color(65, 49, 24));
        Register_CheckTOS.setForeground(new java.awt.Color(255, 255, 255));

        Register_LabelEmail.setText("Email");
        Register_LabelEmail.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_LabelEmail.setForeground(new java.awt.Color(255, 255, 255));

        Register_Email.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        javax.swing.GroupLayout Register_ContainerLayout = new javax.swing.GroupLayout(Register_Container);
        Register_Container.setLayout(Register_ContainerLayout);
        Register_ContainerLayout.setHorizontalGroup(
            Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Register_ContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Register_LabelTitle)
                .addGap(52, 52, 52))
            .addGroup(Register_ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Register_ContainerLayout.createSequentialGroup()
                        .addComponent(Register_RadioMale)
                        .addGap(18, 18, 18)
                        .addComponent(Register_RadioFemale))
                    .addComponent(Register_LabelPassword)
                    .addComponent(Register_LabelConfirmPassword)
                    .addComponent(Register_LabelDate)
                    .addComponent(Register_LabelUsername)
                    .addComponent(Register_LabelGender)
                    .addGroup(Register_ContainerLayout.createSequentialGroup()
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Register_LabelFirstName)
                            .addComponent(Register_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Register_LabelLastName)
                            .addComponent(Register_LastName, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                    .addComponent(Register_Password2)
                    .addComponent(Register_Password1)
                    .addComponent(Register_Username)
                    .addComponent(Register_DatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Register_LabelEmail)
                    .addComponent(Register_Email)
                    .addComponent(Register_CheckTOS)
                    .addComponent(Register_ButtonRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        Register_ContainerLayout.setVerticalGroup(
            Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Register_ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Register_ContainerLayout.createSequentialGroup()
                        .addComponent(Register_LabelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Register_LabelFirstName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Register_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Register_ContainerLayout.createSequentialGroup()
                        .addComponent(Register_LabelLastName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Register_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_LabelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_DatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Register_LabelGender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register_RadioMale)
                    .addComponent(Register_RadioFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_LabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_LabelUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_LabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_Password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_LabelConfirmPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_Password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Register_CheckTOS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Register_ButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Register_LabelHaveAnAccount.setText("Have an account?");
        Register_LabelHaveAnAccount.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 80)); // NOI18N
        Register_LabelHaveAnAccount.setForeground(new java.awt.Color(255, 255, 255));

        Register_LabelLogin.setText("Log in");
        Register_LabelLogin.setFont(new java.awt.Font("Tahoma", 0, 80)); // NOI18N
        Register_LabelLogin.setForeground(new java.awt.Color(51, 0, 153));
        Register_LabelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Register_LabelLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout RegisterLayout = new javax.swing.GroupLayout(Register);
        Register.setLayout(RegisterLayout);
        RegisterLayout.setHorizontalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Register_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(515, Short.MAX_VALUE))
            .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RegisterLayout.createSequentialGroup()
                    .addGap(0, 330, Short.MAX_VALUE)
                    .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Register_LabelHaveAnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(RegisterLayout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(Register_LabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        RegisterLayout.setVerticalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Register_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RegisterLayout.createSequentialGroup()
                    .addGap(40, 70, Short.MAX_VALUE)
                    .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Register_LabelHaveAnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(RegisterLayout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(Register_LabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 280, Short.MAX_VALUE)))
        );

        getContentPane().add(Register, "card3");

        Login.setBackground(new java.awt.Color(255, 255, 255));

        Login_Container.setBackground(new java.awt.Color(255, 255, 255));

        Login_LabelTitle.setText("College Planner");
        Login_LabelTitle.setFont(new java.awt.Font("Blackadder ITC", 1, 48)); // NOI18N

        Login_Username.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Login_LabelUsername.setText("Username");
        Login_LabelUsername.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Login_LabelPassword.setText("Password");
        Login_LabelPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Login_ButtonLogin.setText("Log In");
        Login_ButtonLogin.setBackground(new java.awt.Color(51, 0, 255));
        Login_ButtonLogin.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        Login_ButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        Login_ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_ButtonLoginActionPerformed(evt);
            }
        });

        Login_Password.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        javax.swing.GroupLayout Login_ContainerLayout = new javax.swing.GroupLayout(Login_Container);
        Login_Container.setLayout(Login_ContainerLayout);
        Login_ContainerLayout.setHorizontalGroup(
            Login_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Login_ContainerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(Login_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Login_Password)
                    .addComponent(Login_ButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(Login_LabelPassword)
                    .addComponent(Login_LabelUsername)
                    .addComponent(Login_Username)
                    .addComponent(Login_LabelTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Login_ContainerLayout.setVerticalGroup(
            Login_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Login_ContainerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Login_LabelTitle)
                .addGap(15, 15, 15)
                .addComponent(Login_LabelUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login_LabelPassword)
                .addGap(1, 1, 1)
                .addComponent(Login_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login_ButtonLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Login_Container_Reg.setBackground(new java.awt.Color(255, 255, 255));

        Login_LabelDontHaveAnAcc.setText("Dont't have an account?");
        Login_LabelDontHaveAnAcc.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Login_LabelSignUp.setText("Sign up");
        Login_LabelSignUp.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Login_LabelSignUp.setForeground(new java.awt.Color(51, 0, 255));
        Login_LabelSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login_LabelSignUpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Login_Container_RegLayout = new javax.swing.GroupLayout(Login_Container_Reg);
        Login_Container_Reg.setLayout(Login_Container_RegLayout);
        Login_Container_RegLayout.setHorizontalGroup(
            Login_Container_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Login_Container_RegLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(Login_LabelDontHaveAnAcc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login_LabelSignUp)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        Login_Container_RegLayout.setVerticalGroup(
            Login_Container_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Login_Container_RegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Login_Container_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login_LabelDontHaveAnAcc)
                    .addComponent(Login_LabelSignUp))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Login_Container_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Login_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(197, 197, 197))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(Login_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Login_Container_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        getContentPane().add(Login, "card2");

        Home_Title.setText("Home");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(Home_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(Home_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
        );

        getContentPane().add(Home, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_ButtonLoginActionPerformed
        if (Login_Username.getText().isEmpty() || Login_Password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Semua field harus di isi", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (Login_Password.getPassword().length < 8) {
            JOptionPane.showMessageDialog(rootPane, "Password minimal 8 karakter", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            load();
            int id = -1;
            for (int i = 0; i < db.size(); i++) {
                if (Login_Username.getText().equals(db.get(i).getUsername())) {
                    id = i;
                    break;
                }
            }
            if (id != -1) {
                if (Login_Password.getText().equals(db.get(id).getPassword())) {
                    changePanel("Home");
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Username / Password salah", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Username / Password salah", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Login_ButtonLoginActionPerformed

    private void Login_LabelSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_LabelSignUpMouseClicked
        changePanel("Register");
    }//GEN-LAST:event_Login_LabelSignUpMouseClicked

    private void Register_ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_ButtonRegisterActionPerformed
        if (Register_Username.getText().isEmpty() || Register_Email.getText().isEmpty()
                || Register_Password1.getText().isEmpty() || Register_Password2.getText().isEmpty()
                || Register_DatePicker.getDateStringOrEmptyString().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Semua field harus di isi", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (Register_Password1.getPassword().length < 8) {
            JOptionPane.showMessageDialog(rootPane, "Password minimal 8 karakter", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (!Arrays.equals(Register_Password1.getPassword(), Register_Password2.getPassword())) {
            JOptionPane.showMessageDialog(rootPane, "Password tidak sama", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (Register_DatePicker.getDateStringOrEmptyString().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Date invalid", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (!Register_CheckTOS.isSelected()){
            JOptionPane.showMessageDialog(rootPane, "Harus setuju TOS", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            load();
            boolean sama = false;
            for (int i = 0; i < db.size(); i++) {
                if (Register_Username.getText().equalsIgnoreCase(db.get(i).getUsername())) {
                    sama = true;
                    break;
                }
            }
            if (!sama){
                String gender = "Female";
                if (Register_RadioMale.isSelected()){gender = "Male";}
                db.add(new db_User(Register_Username.getText(), Register_Password1.getText(), Register_FirstName.getText(), Register_LastName.getText(), Register_DatePicker.getDateStringOrEmptyString(), gender, Register_Email.getText()));
                save();
                Register_RadioMale.setSelected(true);
                Register_FirstName.setText("");
                Register_LastName.setText("");
                Register_Email.setText("");
                Register_Username.setText("");
                Register_Password1.setText("");
                Register_Password2.setText("");
                Register_DatePicker.setDateToToday();
                Register_CheckTOS.setSelected(false);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Username sudah ada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Register_ButtonRegisterActionPerformed

    private void Register_LabelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Register_LabelLoginMouseClicked
        changePanel("Login");
    }//GEN-LAST:event_Register_LabelLoginMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Home;
    private java.awt.Label Home_Title;
    private javax.swing.JPanel Login;
    private javax.swing.JButton Login_ButtonLogin;
    private javax.swing.JPanel Login_Container;
    private javax.swing.JPanel Login_Container_Reg;
    private javax.swing.JLabel Login_LabelDontHaveAnAcc;
    private javax.swing.JLabel Login_LabelPassword;
    private javax.swing.JLabel Login_LabelSignUp;
    private javax.swing.JLabel Login_LabelTitle;
    private javax.swing.JLabel Login_LabelUsername;
    private javax.swing.JPasswordField Login_Password;
    private javax.swing.JTextField Login_Username;
    private javax.swing.JPanel Register;
    private javax.swing.ButtonGroup Register_ButtonGroup;
    private javax.swing.JButton Register_ButtonRegister;
    private javax.swing.JCheckBox Register_CheckTOS;
    private javax.swing.JPanel Register_Container;
    private com.github.lgooddatepicker.components.DatePicker Register_DatePicker;
    private javax.swing.JTextField Register_Email;
    private javax.swing.JTextField Register_FirstName;
    private javax.swing.JLabel Register_LabelConfirmPassword;
    private javax.swing.JLabel Register_LabelDate;
    private javax.swing.JLabel Register_LabelEmail;
    private javax.swing.JLabel Register_LabelFirstName;
    private javax.swing.JLabel Register_LabelGender;
    private javax.swing.JLabel Register_LabelHaveAnAccount;
    private javax.swing.JLabel Register_LabelLastName;
    private javax.swing.JLabel Register_LabelLogin;
    private javax.swing.JLabel Register_LabelPassword;
    private javax.swing.JLabel Register_LabelTitle;
    private javax.swing.JLabel Register_LabelUsername;
    private javax.swing.JTextField Register_LastName;
    private javax.swing.JPasswordField Register_Password1;
    private javax.swing.JPasswordField Register_Password2;
    private javax.swing.JRadioButton Register_RadioFemale;
    private javax.swing.JRadioButton Register_RadioMale;
    private javax.swing.JTextField Register_Username;
    // End of variables declaration//GEN-END:variables
}
