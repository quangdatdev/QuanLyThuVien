package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import entity.DocGia;
import iRemote.DocGiaDao;

public class ThemDocGiaDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField texTen;
	private JTextField textDiaChi;
	private JTextField textSDT;
	private AbstractButton btnLamMoi;
	private JButton btnHuy;
	private JButton btnLuu;
	private DocGiaDao docGiaDao;
	private JComboBox cbGioiTinh;

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
//
	/**
	 * Create the dialog.
	 */
	public ThemDocGiaDialog() {
		setIconImage(new ImageIcon("src/main/resources/img/logo.jpg").getImage());
		setModal(true);
		try {
			docGiaDao = (DocGiaDao) Naming.lookup("rmi://192.168.1.3:2910/docGiaDao");
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
			JLabel lblThmcGi = new JLabel("Thêm Độc Giả ");
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
			lblNewLabel_2.setBounds(25, 272, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Họ tên:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 128, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			texTen = new JTextField();
			texTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
			texTen.setColumns(10);
			texTen.setBounds(125, 130, 680, 35);
			contentPanel.add(texTen);
		}
		{
			textDiaChi = new JTextField();
			textDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textDiaChi.setColumns(10);
			textDiaChi.setBounds(122, 274, 680, 35);
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
			 btnLuu = new JButton("Thêm");
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
			textSDT.setBounds(125, 200, 275, 35);
			contentPanel.add(textSDT);
		}
		{
			 cbGioiTinh = new JComboBox();
			cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Giới tính", "Nam", "Nữ"}));
			cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
			cbGioiTinh.setBounds(522, 200, 283, 35);
			contentPanel.add(cbGioiTinh);
		}
		{
			JLabel lblGioiTinh = new JLabel("Giới tính:");
			lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
			lblGioiTinh.setBounds(433, 200, 81, 35);
			contentPanel.add(lblGioiTinh);
		}
		{
			JLabel lblSDT = new JLabel("SDT:");
			lblSDT.setFont(new Font("Arial", Font.BOLD, 16));
			lblSDT.setBounds(25, 203, 76, 35);
			contentPanel.add(lblSDT);
		}
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		btnHuy.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLamMoi.addActionListener(this);
	}
	
	public boolean themDocGia() {
		String tenDG= texTen.getText().toString().trim();
		String diaChi= textDiaChi.getText().toString().trim();
		String sdt= textSDT.getText().toString().trim();
		if (tenDG.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên không được trống");
			texTen.selectAll();
			texTen.requestFocus();
			return false;
		}
		if (!tenDG.matches("" + "[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ"
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
			JOptionPane.showMessageDialog(this, "Số điện thoại là dãy số!");
			textSDT.selectAll();
			textSDT.requestFocus();

			return false;
		}
		if (cbGioiTinh.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn tỉnh giới tính");
			return false;
		}
		if (diaChi.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được trống");
			textDiaChi.selectAll();
			textDiaChi.requestFocus();
			return false;
		}
		DocGia dG= new DocGia();
		dG.setTenDocGia(tenDG);
		dG.setDiaChi(diaChi);
		dG.setGioiTinh(isgioiTinh());
		dG.setSoDienThoai(sdt);
//		DocGia dG = new DocGia(docGiaDao.phatSinhMaTuDong(), tenDG,diaChi
//			, sdt, isgioiTinh());
		boolean k;
		try {
			k = docGiaDao.themDocGia(dG);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object= e.getSource();
		if(object.equals(btnHuy)) {
			dispose();
		}
		else if(object.equals(btnLuu)) {
			Boolean dG= themDocGia();
		
//			System.out.println(kh);
			if (dG) {
				
				JOptionPane.showMessageDialog(this, "Thêm  khách hàng thành công!");
				dispose();
			}
		}if(object.equals(btnLamMoi)) {
			texTen.setText("");
			textSDT.setText("");
			textDiaChi.setText("");
			cbGioiTinh.setSelectedIndex(0);
		}
	}

}
