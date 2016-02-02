package brainfucker;

import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;

public class Frame extends javax.swing.JFrame {

    public int level = 1;
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int result = 0;
    public int entered = 0;
    public int limit = 100;

    /** Creates new form Frame */
    public Frame() {
        initComponents();
    }

    public void switchLevel(){
        level = jSlider1.getValue();
        switch ( level ){
            case 0:
                this.limit = 10;
                jLabel2.setText("тьфу");
                break;
            case 1:
                this.limit = 100;
                jLabel2.setText("легко");
                break;
            case 2:
                this.limit = 1000;
                jLabel2.setText("неплохо");
                break;
            case 3:
                this.limit = 100;
                jLabel2.setText("нормально");
                break;
            case 4:
                this.limit = 1000;
                jLabel2.setText("хорошо");
                break;
            case 5:
                this.limit = 1000;
                jLabel2.setText("круто");
                break;
        }
        generateProblem();

    }

    public void generateProblem(){
        Random generator = new Random();
        switch ( level ){
            case 0:
            case 1:
            case 2:
                a = generateInteger( limit );
                b = generateInteger( limit );
                result = a + b;
                jLabel1.setText(a + " + " + b);
                break;
            case 3:
                a = generateInteger( limit );
                b = generateInteger( limit );
                c = generateInteger( 10 );
                switch ( generator.nextInt( 4 ) ){
                    case 0:
                        result = a + b - c;
                        jLabel1.setText(a + " + " + b + " - " + c);
                        break;
                    case 1:
                        result = a - b + c;
                        jLabel1.setText(a + " - " + b + " + " + c);
                        break;
                    case 2:
                        d = generateInteger( 100 );
                        result = b + a - c*d;
                        jLabel1.setText(b + " + " + a + " - " + c + " x " + d);
                        break;
                    case 3:
                        d = generateInteger( 100 );
                        result = d*c - a + b;
                        jLabel1.setText(d + " x " + c + " - " + a + " + " + b);
                        break;
                }
                break;
            case 4:
                a = generateInteger( limit );
                b = generateInteger( limit );
                c = generateInteger( 20 );
                d = generateInteger( 10 );
                switch ( generator.nextInt( 4 ) ){
                    case 0:
                        result = a + b - c;
                        jLabel1.setText(a + " + " + b + " - " + c);
                        break;
                    case 1:
                        result = a - b + c;
                        jLabel1.setText(a + " - " + b + " + " + c);
                        break;
                    case 2:
                        result = b + a - c*d;
                        jLabel1.setText(b + " + " + a + " - " + c + " x " + d);
                        break;
                    case 3:
                        result = d*c - a + b;
                        jLabel1.setText(d + " x " + c + " - " + a + " + " + b);
                        break;
                }
                break;
            case 5:
                a = generateInteger( limit );
                b = generateInteger( 26 );
                c = generateInteger( 16 );
                switch ( generator.nextInt( 5 ) ){
                    case 0:
                        d = generateInteger( limit );
                        result = a + b*c - d;
                        jLabel1.setText(a + " + " + b + " x " + c + " - " + d);
                        break;
                    case 1:
                        d = generateInteger( limit );
                        result = d + a - c*b;
                        jLabel1.setText(d + " + " + a + " - " + c + " x " + b);
                        break;
                    case 2:
                        d = generateInteger( 100 );
                        result = b + a - c*d;
                        jLabel1.setText(b + " + " + a + " - " + c + " x " + d);
                        break;
                    case 3:
                        d = generateInteger( 100 );
                        result = a - b + d*c;
                        jLabel1.setText(a + " - " + b + " + " + d + " x " + c);
                        break;
                    case 4:
                        d = generateInteger( 100 );
                        result = c*d + a - b;
                        jLabel1.setText(c + " x " + d + " + " + a + " - " + b);
                        break;
                
                
                }
                break;
        }
        

    }

    public int generateInteger( int max ){
        Random generator = new Random();
        int value = generator.nextInt( max );
        while( value == 0 )
            value = generator.nextInt( max );
    return value;
    }

    public boolean checkResult(){
        try{
            entered = Integer.parseInt( jTextField1.getText() );
        }
        catch( Exception e ){
            System.out.println(e);
        }
        return ( entered == result )? true : false ;
    }

    public void handleAnswer(){
        if( checkResult() ){
            generateProblem();
            jTextField1.setText(null);
        }
        else{
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
        jTextField1.requestFocusInWindow();
    }

    public void assignListeners(){

        jTextField1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();
                switch(keyCode){
                    case KeyEvent.VK_ENTER: 
                        handleAnswer();
                        break;
                }
            }

        });


    }

    public void takeYourTime(){
        this.setVisible(false);
        Timer timer = new Timer(1000*60, new ActionListener()
          {
              public void actionPerformed(ActionEvent e)
              {
                wakeUp();
              }
          } );
         timer.setRepeats(false); 
         timer.start();


    }

    public void wakeUp(){
       this.setVisible(true);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("a + b");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jButton1.setText("Ответить");
        jButton1.setToolTipText("Клавиша Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(5);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("Уровень сложности");
        jSlider1.setValue(1);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSlider1.setFocusable(false);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("легко");

        jMenu1.setText("Опции");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Хочу отдохнуть");
        jMenuItem1.setToolTipText("минутный перерыв");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleDescription("");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Да пошел ты!");
        jMenuItem2.setToolTipText("Вежливо покинуть программу");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSlider1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        handleAnswer();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        takeYourTime();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        switchLevel();
    }//GEN-LAST:event_jSlider1StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JSlider jSlider1;
    private static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
