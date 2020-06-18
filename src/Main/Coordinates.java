package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import Object3D.Object_1_3D;
import java.awt.Font;
public class Coordinates extends JPanel {
	int x1 = 375;// tam O tuong ung voi he toa do cua chuong trinh
	int y1 = 375;
	int index;
        float[] dash1 = {2f, 0f, 2f};
        BasicStroke bs1 = new BasicStroke(3, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		this.setBounds(300, 0, 580, 580);
		//this.setBorder(BorderFactory.createEtchedBorder(1));
		Graphics2D g2d = (Graphics2D) g;
		//Axis2D(g2d);
		// g.setColor(Color.red);
		// g.fillOval(370, 370, 10, 10);
		//doDrawing(g2d);
                // vẽ hệ tọa độ 3D
                Axis3D(g2d);
                // biến dổi x , z người dùng nhập vào thành tọa độ máy tính ( đây là nhập tâm trong mặt phằng 0xz nên ràng buộc là y=0)
                int y = converY3Dto2D(-10);
                int x = converX3Dto2D(10, 10);
                int z= converZ3Dto2D(10);
                // vẽ hình nón 3D tại đây
                drawCone3D(x, z, y,100,200,g2d);
                
	}

	// ham ve thi ta ve vao day
	public Coordinates() {
		this.index = -1;
	}

	public void doDrawing(Graphics2D g2d) {
		// ham chuc nang
		Axis2D(g2d);
		if (index == 0) {
			// DrawElip(g2d, x1, y1, R1, R2);
		}
	}

	// ham ve toa do
	public void Axis2D(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(1));
		for (int i = 0; i <= 150; i++) {
			g2d.drawLine(5 * i, 0, 5 * i, 750);// moi don vi la 5 pixel
			g2d.drawLine(0, 5 * i, 750, 5 * i);
		}
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.BLACK);
		g2d.drawLine(0, 290, 750, 290);// truc ngang
		g2d.drawLine(300, 0, 300, 750);// truc doc
	}
        public void Axis3D(Graphics2D g2d)
        {
            
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.BLACK);
            //ox
            g2d.drawLine(300, 290, 600, 290);
            g2d.drawString("Ox", 550, 280);
            //dau mui ten
            g2d.drawLine(580, 290, 570, 285);
            g2d.drawLine(580, 290, 570, 295);
            //oy
            g2d.drawLine(300, 290, 300, 0);
            g2d.drawString("Oy",275,15);
            g2d.drawLine(300, 2, 295, 10);
            g2d.drawLine(300,2, 305, 10);
            //oz
            
            g2d.drawLine(0,580,300,290);
            g2d.drawString("Oz",5,550);
            g2d.drawLine(2, 580, 2, 570);
            g2d.drawLine(4, 578, 12, 578);
            // to mau
            g2d.setColor(Color.GRAY);
            g2d.setStroke(new BasicStroke(1));
//            for(int i=1; i<=140;i++)
//            {
//                g2d.drawLine(300+i*5, 290, 0+i*5, 580);
//                
//            }
//            for(float i=1; i<=58;i++)
//            {
//                g2d.drawLine((int)(300-(i*5.0*(float)30/29)), (int)(290+(i*5)), 600, (int)(290+(i*5))); //doi=ke*tan 300/290
//                //System.out.println(300-(i*5.0*(float)30/29));
//            }
            
        }
        public void drawCone3D(int ox, int oy,int y, int r,int h,Graphics2D g2d)
        {
            oy=oy-y;
            g2d.setColor(Color.BLUE);
            // scale tỉ lệ vì hình tròn khi vẽ 3d thành hình eclip
            int a=r,  b = a/2;
            //System.out.println(b);
            //ve hình eclip
            Object_1_3D eclip = new Object_1_3D();
            eclip.eclipMidpoint(ox, oy, a, b, g2d);
            // two line can visible
            g2d.drawLine(ox, oy - h, ox - a -2, oy);
            g2d.drawLine(ox, oy - h , ox + a , oy);
            // line index unvisible
            g2d.setStroke(bs1);
            g2d.drawLine(ox, oy -h , ox, oy);
            //g2d.dispose();
            g2d.drawLine(ox, oy, ox + a, oy );
            // ve cai ten
            // tam O
            g2d.setFont(new Font("Arial", Font.BOLD, 15));
            g2d.drawString("O", ox-25, oy);
            g2d.drawString("A", ox, oy-h-10);
            g2d.drawString("r", (ox+a/2), oy-10);
            g2d.drawString("h", ox+10, oy-(h/2));
            
        }
        public int converX3Dto2D(int x, int z)
    {
        
        
        return (int)(x*5-z*5*0.7189+300); //0.7189 = sin(30/29)
    }
        public int converZ3Dto2D(int z)
        {
            return (int)(z*5*0.6950+290); // 0.6950 = cos(30/29)
        }
        public int converY3Dto2D(int y)
        {
            return (y*5);
        }
}