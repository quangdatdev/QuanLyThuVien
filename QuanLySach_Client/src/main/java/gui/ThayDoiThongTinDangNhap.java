package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import entity.TaiKhoan;
import iRemote.ITaiKhoan;

public class ThayDoiThongTinDangNhap extends JDialog {
	private JPasswordField txtPassCu;
	private JTextField txtTenTaiKhoan;
	private JTextField txtThngTinng;
	private JPasswordField txtPassMoi;
	private JButton btnHuy;
	private JButton btnCapNhat;
	private JComponent lblXacNhanMK;
	private JPasswordField txtXN;
	private TaiKhoan taiKhoan;
	private ITaiKhoan taiKhoanDao;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ThemDocGiaDialog dialog = new ThemDocGiaDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
////
	/**
	 * Create the dialog.
	 */
	public ThayDoiThongTinDangNhap() {
		setIconImage(new ImageIcon("src/main/resources/img/logo.jpg").getImage());
		setModal(true);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			taiKhoanDao=(ITaiKhoan) Naming.lookup("rmi://192.168.1.3:2910/iTaiKhoan");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			e1.printStackTrace();
		}
		setBounds(100, 100, 691, 421);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 680, 378);
		getContentPane().add(contentPanel);
		
		JLabel lblMNhnVin = new JLabel("T??n t??i kho???n:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMNhnVin.setBounds(94, 90, 134, 35);
		contentPanel.add(lblMNhnVin);
		
		JLabel lblMatKhau = new JLabel("M???u kh???u c??");
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatKhau.setBounds(94, 136, 131, 35);
		contentPanel.add(lblMatKhau);
		
		txtPassCu = new JPasswordField();
		txtPassCu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassCu.setColumns(10);
		txtPassCu.setBounds(254, 136, 315, 35);
		contentPanel.add(txtPassCu);
		
		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setEditable(false);
		txtTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenTaiKhoan.setColumns(10);
		txtTenTaiKhoan.setBounds(254, 90, 315, 35);
		contentPanel.add(txtTenTaiKhoan);
		
		txtThngTinng = new JTextField();
		txtThngTinng.setText("Th??ng tin ????ng nh???p");
		txtThngTinng.setHorizontalAlignment(SwingConstants.CENTER);
		txtThngTinng.setForeground(new Color(0, 0, 0));
		txtThngTinng.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtThngTinng.setEditable(false);
		txtThngTinng.setColumns(10);
		txtThngTinng.setBackground(new Color(255, 250, 250));
		txtThngTinng.setBounds(-7, 0, 685, 65);
		contentPanel.add(txtThngTinng);
		
		 lblXacNhanMK = new JLabel("M???t kh???u m???i");
		lblXacNhanMK.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblXacNhanMK.setBounds(94, 182, 172, 35);
		contentPanel.add(lblXacNhanMK);
		
		txtPassMoi = new JPasswordField();
		txtPassMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassMoi.setColumns(10);
		txtPassMoi.setBounds(254, 182, 315, 35);
		contentPanel.add(txtPassMoi);
		
		btnHuy = new JButton("H???y");
		btnHuy.setIconTextGap(6);
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHuy.setBackground(new Color(255, 69, 0));
		btnHuy.setAlignmentY(0.0f);
		btnHuy.setBounds(55, 306, 131, 40);
		contentPanel.add(btnHuy);
		
		 btnCapNhat = new JButton("C???p nh???t");
		btnCapNhat.setMargin(new Insets(2, -2, 2, 0));
		btnCapNhat.setIconTextGap(6);
		btnCapNhat.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCapNhat.setDoubleBuffered(true);
		btnCapNhat.setBackground(new Color(0, 102, 255));
		btnCapNhat.setBounds(458, 307, 144, 40);
		contentPanel.add(btnCapNhat);
		
		txtXN = new JPasswordField();
		txtXN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtXN.setColumns(10);
		txtXN.setBounds(254, 228, 315, 35);
		contentPanel.add(txtXN);
		
		JLabel lblXcNhn = new JLabel("X??c nh???n");
		lblXcNhn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblXcNhn.setBounds(94, 228, 172, 35);
		contentPanel.add(lblXcNhn);
		btnCapNhat.addActionListener(e->{
			if(kiemTraMatKhauCu()) {
				if(kiemTraMatKhauMoi()) {
					taiKhoan.setMatKhau(txtPassMoi.getText().trim());
					try {
						taiKhoanDao.suaTaiKhoan(taiKhoan);
						JOptionPane.showMessageDialog(this,"?????i m???t kh???u th??nh c??ng");
						this.dispose();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan=taiKhoan;
		txtTenTaiKhoan.setText(taiKhoan.getTenTaiKhoan());
	}
	public boolean kiemTraMatKhauMoi() {
		String pass=txtPassMoi.getText().trim();
		String xn= txtXN.getText().trim();
		if(pass.matches("\\w{4,8}")) {
			if(pass.equals(xn)) {
				return true;
			}
			JOptionPane.showMessageDialog(this,"X??c nh???n m???t kh???u m???i th???t b???i");
			return false;
		}
		else {
			JOptionPane.showMessageDialog(this, "M???t kh???u t??? 4-8 k?? t???, kh??ng ch???a k?? t??? ?????c bi???t");
			return false;
		}
	}
	public boolean kiemTraMatKhauCu() {
		if(txtPassCu.getText().trim().equals(taiKhoan.getMatKhau()))
			return true;
		JOptionPane.showMessageDialog(this,"M???t kh???u c?? kh??ng ch??nh x??c");
		return false;
	}
	
	
}
