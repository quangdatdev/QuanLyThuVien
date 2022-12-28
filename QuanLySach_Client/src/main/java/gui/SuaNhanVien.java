package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.type.WrapperBinaryType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

import entity.DocGia;
import entity.NhanVien;
import iRemote.NhanVienDao;
import javassist.Loader.Simple;

public class SuaNhanVien extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField texTen;
	private JTextField textDiaChi;
	private JTextField textSDT;
	private JTextField textMa;
	private JButton btnHuy;
	private AbstractButton btnLamMoi;
	private AbstractButton btnLuu;
	private NhanVienDao nhanVienDao;
	
	private JComboBox cbGioiTinh;
	private JDateChooser ngaySinh;
	private NhanVien nv;
	private JComboBox cbChucVu;
	

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

	/**
	 * Create the dialog.
	 */
	public SuaNhanVien(String ma) {
		setIconImage(new ImageIcon("src/main/resources/img/logo.jpg").getImage());
		try {
			nhanVienDao = (NhanVienDao) Naming.lookup("rmi://192.168.1.3:2910/nhanVienDao");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		setBounds(100, 100, 849, 463);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblThmcGi = new JLabel("Sửa thông tin Nhân Viên");
			lblThmcGi.setOpaque(true);
			lblThmcGi.setHorizontalAlignment(SwingConstants.CENTER);
			lblThmcGi.setForeground(new Color(204, 102, 51));
			lblThmcGi.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblThmcGi.setBackground(new Color(245, 245, 220));
			lblThmcGi.setBounds(0, 0, 835, 50);
			contentPanel.add(lblThmcGi);
		}
		{
			btnHuy = new JButton("Hủy");
			btnHuy.setIconTextGap(20);
			btnHuy.setForeground(new Color(0, 0, 0));
			btnHuy.setFont(new Font("Arial", Font.BOLD, 16));
			btnHuy.setBackground(new Color(255, 69, 0));
			btnHuy.setBounds(25, 365, 131, 40);
			contentPanel.add(btnHuy);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Địa chỉ:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(25, 283, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Họ tên:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(25, 157, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			texTen = new JTextField();
			texTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
			texTen.setColumns(10);
			texTen.setBounds(149, 159, 248, 35);
			contentPanel.add(texTen);
		}
		{
			textDiaChi = new JTextField();
			textDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textDiaChi.setColumns(10);
			textDiaChi.setBounds(149, 285, 650, 35);
			contentPanel.add(textDiaChi);
		}
		{
			btnLamMoi = new JButton("Làm mới");
			btnLamMoi.setMargin(new Insets(2, 0, 2, 0));
			btnLamMoi.setIconTextGap(2);
			btnLamMoi.setForeground(new Color(0, 0, 0));
			btnLamMoi.setFont(new Font("Arial", Font.BOLD, 16));
			btnLamMoi.setBackground(new Color(102, 153, 51));
			btnLamMoi.setBounds(535, 366, 131, 40);
			contentPanel.add(btnLamMoi);
		
			
		}
		{
			btnLuu = new JButton("Sửa");
			btnLuu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean cn=capNhatNhanVien();
					if (cn) {
						JOptionPane.showMessageDialog(null, "cap nhat thanh cong ");

					}
				}
			});
			btnLuu.setIconTextGap(15);
			btnLuu.setForeground(new Color(0, 0, 0));
			btnLuu.setFont(new Font("Arial", Font.BOLD, 16));
			btnLuu.setBackground(new Color(0, 102, 255));
			btnLuu.setBounds(678, 366, 131, 40);
			contentPanel.add(btnLuu);
		}
		{
			textSDT = new JTextField();
			textSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textSDT.setColumns(10);
			textSDT.setBounds(149, 220, 248, 35);
			contentPanel.add(textSDT);
		}
		{
			 cbGioiTinh = new JComboBox();
			cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Giới tính", "Nam", "Nữ" }));
			cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
			cbGioiTinh.setBounds(516, 220, 283, 35);
			contentPanel.add(cbGioiTinh);
		}
		{
			JLabel lblGioiTinh = new JLabel("Giới tính:");
			lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
			lblGioiTinh.setBounds(413, 220, 81, 35);
			contentPanel.add(lblGioiTinh);
		}
		{
			JLabel lblSDT = new JLabel("SDT:");
			lblSDT.setFont(new Font("Arial", Font.BOLD, 16));
			lblSDT.setBounds(22, 223, 76, 35);
			contentPanel.add(lblSDT);
		}
		{
			JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
			lblMNhnVin.setFont(new Font("Arial", Font.BOLD, 16));
			lblMNhnVin.setBounds(25, 96, 143, 35);
			contentPanel.add(lblMNhnVin);
		}
		{
			textMa = new JTextField();
			textMa.setEditable(false);
			textMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textMa.setColumns(10);
			textMa.setBounds(149, 93, 248, 35);
			contentPanel.add(textMa);
		}

		ngaySinh = new JDateChooser();
		ngaySinh.setBounds(516, 96, 283, 35);
		contentPanel.add(ngaySinh);

		JLabel lblNgySinh = new JLabel("Ngày sinh:");
		lblNgySinh.setFont(new Font("Arial", Font.BOLD, 16));
		lblNgySinh.setBounds(413, 96, 106, 35);
		contentPanel.add(lblNgySinh);

		JLabel lblNewLabel_2 = new JLabel("Chức vụ:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(413, 157, 82, 35);
		contentPanel.add(lblNewLabel_2);
		{
			cbChucVu = new JComboBox();
			cbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Chức vụ", "Quản lý", "Nhân viên"}));
			cbChucVu.setFont(new Font("Arial", Font.PLAIN, 16));
			cbChucVu.setBounds(516, 157, 283, 35);
			contentPanel.add(cbChucVu);
		}
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		// loadDuLieu(null);
		btnHuy.addActionListener(this);
		btnLamMoi.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object.equals(btnHuy)) {
			dispose();
		}
		

	}

	public boolean capNhatNhanVien() {
		String tennv = texTen.getText().toString().trim();
		Date ngay = ngaySinh.getDate();
		String diaChi = textDiaChi.getText().toString().trim();
		String sdt = textSDT.getText().toString().trim();
		// boolean ccv=textFChucvu.getText().trim();
		if (tennv.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên không được trống");
			texTen.selectAll();
			texTen.requestFocus();
			return false;
		}
		if (!tennv.matches("" + "[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ"
				+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu"
				+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+")) {
			JOptionPane.showMessageDialog(this, "Tên không có kí tự đặc biệt");
			texTen.selectAll();
			texTen.requestFocus();
			return false;
		}
		if (sdt.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại");
			textSDT.selectAll();
			textSDT.requestFocus();
			return false;
		}
		if (!sdt.matches("^0[1-9][0-9]{8}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại là dãy s!");
			textSDT.selectAll();
			textSDT.requestFocus();

			return false;
		}
		if (cbGioiTinh.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn  giới tính");
			return false;
		}
		if (cbChucVu.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn  chức vụ!");
			return false;
		}
		if (diaChi.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được trống");
			textDiaChi.selectAll();
			textDiaChi.requestFocus();
			return false;
		}
		if (ngaySinh.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh");
			return false;
		}
		try {
			nv = nhanVienDao.layNhanVienTheoMa(textMa.getText().toString());
			System.out.println(nv);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNhanVien(nv.getMaNhanVien());
		nhanVien.setTenNhanVien(tennv);
		nhanVien.setNgaySinh(ngay);
		nhanVien.setSoDienThoai(sdt);
		nhanVien.setDiaChi(diaChi);
		nhanVien.setChucVu(isChucVu());
		nhanVien.setGioiTinh(isgioiTinh());
		System.out.println("NhanVienda capnhat");
System.out.println(nhanVien);
		try {
			nhanVienDao.capNhatNhanVien(nhanVien);
		} catch (RemoteException e) {
			
			e.printStackTrace();
			
		} 
		return true;
		
	}

	public boolean isgioiTinh() {

		if (cbGioiTinh.getSelectedIndex() == 1) {
			return true;
		}
		if (cbGioiTinh.getSelectedIndex() == 2) {
			return false;
		}
		return true;
	}

	public boolean isChucVu() {

		if (cbChucVu.getSelectedIndex() == 1) {
			return true;
		}
		if (cbChucVu.getSelectedIndex() == 2) {

			return false;
		}
		return false;
	}
	
	public void loadDuLieu(NhanVien docGia) {
		textMa.setText(docGia.getMaNhanVien().toString());
		texTen.setText(docGia.getTenNhanVien().toString());
		SimpleDateFormat sdt= new SimpleDateFormat("yyyy-MM-dd");
		ngaySinh.setDate(docGia.getNgaySinh());
		cbChucVu.setSelectedItem(docGia.isChucVu() ? "Quản lý" : "Nhân Viên");
		textDiaChi.setText(docGia.getDiaChi().toString());
		textSDT.setText(docGia.getSoDienThoai().toString());
		cbGioiTinh.setSelectedItem(docGia.isGioiTinh() ? "Nam" : "Nữ");
	}
}