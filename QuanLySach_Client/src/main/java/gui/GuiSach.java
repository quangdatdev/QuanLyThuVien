package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import chucNangChung.ChucNangChoTable;
import entity.NhanVien;
import entity.Sach;
import entity.TheLoai;
import iRemote.ISach;
import iRemote.ITheLoai;
import view.util.HeaderRenderer;

public class GuiSach extends JPanel {
	private JList listLoaiSach;
	private JTable tblSach;
	private JTextField txtTrang;
	private JPopupMenu popupTable;
	private JMenuItem mnSua;
	private JMenuItem mnXoa;
	private JButton btnBack;
	private JButton btnNext;
	private JLabel lblTongTrang;
	private DefaultTableModel modelSach;
	private JMenuItem mnNhapSach;
	private JPanel panel;
	private JTextField txtTim;
	private JRadioButton rdoTenSach;
	private JRadioButton rdoTenTacGia;
	private JButton btnNhapSach;
	private ISach sachDao;
	private ITheLoai theLoaiDao;
	private DefaultListModel<Object> modelLoai;
	private List<TheLoai> listLoai;
	private List<Sach> dsSach;

	private List<Sach> listGioHang;
	private JButton btnMuon;
	private JButton btnTim;
private NhanVien nhanVien;

	/**
	 * Create the panel.
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	@SuppressWarnings({ "unchecked", "serial" })
	public GuiSach() {
		try {
			sachDao = (ISach) Naming.lookup("rmi://192.168.1.3:2910/iSach");
			theLoaiDao = (ITheLoai) Naming.lookup("rmi://192.168.1.3:2910/iTheLoai");
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (RemoteException e2) {
			e2.printStackTrace();
		} catch (NotBoundException e2) {
			e2.printStackTrace();
		}

		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane.setBounds(0, 108, 240, 666);
		add(scrollPane);

		JLabel lblNewLabel = new JLabel("Lo\u1EA1i s\u00E1ch");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(102, 51, 0));
		lblNewLabel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		scrollPane.setColumnHeaderView(lblNewLabel);

		listLoaiSach = new JList();
		listLoaiSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		modelLoai = new DefaultListModel<Object>();
		listLoaiSach.setModel(modelLoai);
		scrollPane.setViewportView(listLoaiSach);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(244, 143, 1296, 631);
		add(scrollPane_1);

		tblSach = new JTable();
		modelSach = new DefaultTableModel(new String[] { "STT", "M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch",
				"T\u00E1c gi\u1EA3", "Nh\u00E0 xu\u1EA5t b\u1EA3n ", "N\u0103m xu\u1EA5t b\u1EA3n", "Trang thai" },
				50) {

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 5 || column == 2)
					return true;
				return false;
			}
		};

		JTableHeader h = tblSach.getTableHeader();
		h.setPreferredSize(new Dimension(35, 35));
		((DefaultTableCellRenderer) h.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		HeaderRenderer renderer = new HeaderRenderer();
		// center
		JLabel headerLabel = (JLabel) renderer;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		// set color Header Table
		TableColumnModel columnmodel;
		for (int i = 0; i < tblSach.getColumnCount(); i++) {
			tblSach.getColumnModel().getColumn(i).setHeaderRenderer(renderer);
			renderer.setBackgroundColor(Color.black);
			renderer.setForegroundColor(Color.white);
			renderer.setBorder(new LineBorder(Color.gray));
		}

		tblSach.setModel(modelSach);
		tblSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblSach.setRowHeight(30);
		tblSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		h.setBackground(Color.black);
		h.setForeground(Color.white);
		h.setFont(new Font("Tahoma", Font.PLAIN, 18));

		scrollPane_1.setViewportView(tblSach);
//do rộng các cột
		tblSach.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblSach.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblSach.getColumnModel().getColumn(1).setPreferredWidth(30);
		tblSach.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblSach.getColumnModel().getColumn(3).setPreferredWidth(200);
		tblSach.getColumnModel().getColumn(4).setPreferredWidth(200);
		tblSach.getColumnModel().getColumn(5).setPreferredWidth(50);
		tblSach.getColumnModel().getColumn(6).setPreferredWidth(30);
		tblSach.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		popupTable = new JPopupMenu();

		addPopup(tblSach, popupTable);

		JMenuItem mnMuon = new JMenuItem("M\u01B0\u1EE3n");
		popupTable.add(mnMuon);

		mnSua = new JMenuItem("S\u1EEDa");
		mnSua.setToolTipText("S\u1EEDa d\u00F2ng \u0111ang ch\u1ECDn");
		popupTable.add(mnSua);

		mnXoa = new JMenuItem("X\u00F3a");
		mnXoa.setToolTipText("X\u00F3a d\u00F2ng \u0111ang ch\u1ECDn");
		popupTable.add(mnXoa);

		mnNhapSach = new JMenuItem("Nh\u1EADp s\u00E1ch c\u0169");
		popupTable.add(mnNhapSach);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(160, 227, 242));
		panel_1.setBounds(244, 774, 1296, 61);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnBack = new JButton("<<");
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setToolTipText("Trang tr\u01B0\u1EDBc");
		panel_1.add(btnBack);

		JLabel lblNewLabel_2 = new JLabel("Trang");
		panel_1.add(lblNewLabel_2);

		txtTrang = new JTextField();
		txtTrang.setToolTipText("Trang hi\u1EC7n t\u1EA1i");
		txtTrang.setText("01");
		panel_1.add(txtTrang);
		txtTrang.setColumns(10);

		lblTongTrang = new JLabel("Tr\u00EAn 100");
		lblTongTrang.setToolTipText("T\u1ED5ng s\u1ED1 trang");
		panel_1.add(lblTongTrang);

		btnNext = new JButton(">>");
		btnNext.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNext.setToolTipText("Trang ti\u1EBFp theo");
		panel_1.add(btnNext);

		JLabel lblNewLabel_1 = new JLabel("S\u00E1ch gi\u00E1o khoa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblNewLabel_1.setBounds(240, 108, 1300, 31);
		add(lblNewLabel_1);

		panel = new JPanel();
		panel.setBounds(0, 0, 1540, 116);
		add(panel);
		panel.setLayout(null);

		txtTim = new JTextField();
		txtTim.setBounds(1119, 10, 301, 30);
		panel.add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("T\u00ECm ki\u1EBFm");
		btnTim.setBounds(1417, 10, 101, 30);
		panel.add(btnTim);

		JRadioButton rdoMaSach = new JRadioButton("M\u00E3 S\u00E1ch");
		rdoMaSach.setBounds(1119, 60, 79, 23);
		panel.add(rdoMaSach);

		rdoTenSach = new JRadioButton("T\u00EAn s\u00E1ch");
		rdoTenSach.setBounds(1207, 60, 79, 23);
		panel.add(rdoTenSach);

		rdoTenTacGia = new JRadioButton("T\u00EAn t\u00E1c gi\u1EA3");
		rdoTenTacGia.setBounds(1292, 60, 109, 23);
		panel.add(rdoTenTacGia);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoMaSach);
		buttonGroup.add(rdoTenSach);
		buttonGroup.add(rdoTenTacGia);

		btnNhapSach = new JButton("Nh\u1EADp s\u00E1ch");
		btnNhapSach.setBounds(238, 72, 153, 30);
		panel.add(btnNhapSach);

		btnMuon = new JButton("Mượn (0)");
		btnMuon.setBounds(395, 72, 153, 30);
		panel.add(btnMuon);

		btnNhapSach.addActionListener(e -> {
			new NhapSach().setVisible(true);
		});
		txtTrang.setEditable(false);
		loadSach("", 0, 50, 0);
		loadListLoaiSach();
		setLableTongSoTrang();
		rdoMaSach.setSelected(true);
		listGioHang = new ArrayList<Sach>();
		tblSach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (tblSach.getValueAt(tblSach.getSelectedRow(), 0) == null) {
					return;
				}
				int y = e.getY() / 24;
				tblSach.getMousePosition();
				popupTable.show(tblSach, e.getX(), y * 24 + 24);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		listLoaiSach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				int index = listLoaiSach.getSelectedIndex();
				TheLoai theLoai = listLoai.get(index);
				loadSach(theLoai.getMaTheLoai(), 0, 1000000, 0);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		mnSua.addActionListener(e -> {
			int row = tblSach.getSelectedRow();
			int col = tblSach.getSelectedColumn();
			tblSach.editCellAt(row, col);
		});
		mnNhapSach.addActionListener(e -> {
			int index = tblSach.getSelectedRow();
			if (dsSach.get(index).isTrangThai()) {
				JOptionPane.showMessageDialog(this, "Sách này đang còn");
			} else {
				dsSach.get(index).setTrangThai(true);
				tblSach.setValueAt("Còn", index, 6);
				try {
					sachDao.updateSach(dsSach.get(index));
					JOptionPane.showMessageDialog(this, "Nhập thành công");
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnXoa.addActionListener(e -> {
			int index = tblSach.getSelectedRow();
			if (!dsSach.get(index).isTrangThai()) {
				JOptionPane.showMessageDialog(this, "Sách đã hết");
			} else {
				dsSach.get(index).setTrangThai(false);
				tblSach.setValueAt("Hết", index, 6);
				try {
					sachDao.updateSach(dsSach.get(index));
					JOptionPane.showMessageDialog(this, "Cập nhật hết hàng thành công");
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		mnMuon.addActionListener(e -> {
			int index = tblSach.getSelectedRow();

			String maSach = (String) tblSach.getValueAt(index, 1);

//			tblSach.getSelectedRows();
//			
			if (maSach != null) {
				try {
					Sach sach = sachDao.getSach(maSach);
					if (listGioHang.contains(sach)) {
						JOptionPane.showMessageDialog(this, "Sách đã tồn tại trong giỏ");
						return;
					}
					if (sach.isTrangThai()) {
						listGioHang.add(sach);
						setBtnMuon(listGioHang.size());
					} else {
						JOptionPane.showMessageDialog(null, "Sách này đã hết");
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMuon.addActionListener(e -> {
			if (listGioHang.size() <= 0) {
				JOptionPane.showMessageDialog(this, "Chưa thêm quyển sách nào vào giỏ");
				return;
			}
//			NhanVien nhanVien = new NhanVien();
//			nhanVien.setMaNhanVien("NV00004");/
			GuiMuonSach guiMuonSach = new GuiMuonSach();
			guiMuonSach.setSach(listGioHang, nhanVien);
			guiMuonSach.setVisible(true);
			setBtnMuon(0);
			listGioHang= new ArrayList<Sach>();
		});
		
		modelSach.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				int col = e.getColumn();
				int row = e.getFirstRow();
				if (col == 2) {
					try {
						String maSach = (String) tblSach.getValueAt(row, 1);
						if (maSach == null) {
							return;
						}
						Sach sach = sachDao.getSach(maSach);

						sach.setTenSach((String) tblSach.getValueAt(row, 2));
						sachDao.updateSach(sach);

					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if (col == 5) {
					try {
						String maSach = (String) tblSach.getValueAt(row, 1);
						if (maSach == null) {
							return;
						}
						Sach sach = sachDao.getSach(maSach);
						sach.setTenSach((String) tblSach.getValueAt(row, 5));
						sachDao.updateSach(sach);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			}
		});
		btnNext.addActionListener(e -> {
			int page = Integer.parseInt(txtTrang.getText().trim());
			int tong = 1;
			try {
				tong = sachDao.tongSoDong() / 50;
				System.out.println(tong);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			if (page > tong) {
			} else {
				page++;
				goToPage(page);
			}

			txtTrang.setText("0" + page);

		});
		btnBack.addActionListener(e -> {
			int page = Integer.parseInt(txtTrang.getText().trim());
			if (page < 2) {
			} else {
				page--;
				goToPage(page);
			}

			txtTrang.setText("0" + page);
		});
		btnTim.addActionListener(e -> {
			String text = txtTim.getText().trim();
			if (rdoMaSach.isSelected()) {
				if (timTheoMaSach(text) != null)
					loadSachFromList(Arrays.asList(timTheoMaSach(text)));
			} else if (rdoTenSach.isSelected()) {
				if (timTheoTenSach(text) != null)
					loadSachFromList(timTheoTenSach(text));
			} else {
				if (rdoTenTacGia.isSelected()) {
					if (timSachTheoTenTacGia(text) != null)
						loadSachFromList(timSachTheoTenTacGia(text));
				}
			}
		});
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien=nhanVien;
	}

	public void goToPage(int page) {
		loadSach("", page * 50 - 50, page * 50, page * 50 - 50);
	}

	public void loadSachFromList(List<Sach> ds) {
		ChucNangChoTable.XoaDongTable(modelSach);
		int stt = 1;
		for (Sach sach : ds) {
			Object[] rowData = { stt++, sach.getMaSach(), sach.getTenSach(), sach.getTacGia().getTenTacGia(),
					sach.getNhaXuatBan().getTenNhaXuatBan(), sach.getNamXuatBan(), sach.isTrangThai() ? "Còn" : "Hết" };
			modelSach.addRow(rowData);
		}
		ChucNangChoTable.addNullDataTable(modelSach);
	}

	public void loadSach(String maLoai, int from, int to, int stt) {
		dsSach = new ArrayList<Sach>();
		try {
			dsSach = sachDao.getSach(maLoai, from, to);
			System.out.println(dsSach);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		stt++;
		ChucNangChoTable.XoaDongTable(modelSach);
		for (Sach sach : dsSach) {
			Object[] rowData = { stt++, sach.getMaSach(), sach.getTenSach(), sach.getTacGia().getTenTacGia(),
					sach.getNhaXuatBan().getTenNhaXuatBan(), sach.getNamXuatBan(), sach.isTrangThai() ? "Còn" : "Hết" };
			modelSach.addRow(rowData);
		}
		ChucNangChoTable.addNullDataTable(modelSach);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1920, 918);
		f.getContentPane().add(new GuiSach());
		f.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void setLableTongSoTrang() {
		int soDong = 0;
		int soTrang = 0;
		try {
			soDong = sachDao.tongSoDong();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if (soDong == 0) {
			soTrang = 1;
		} else {
			soTrang = soDong / 50 + ((soDong % 50 == 0) ? 0 : 1);
			lblTongTrang.setText("Trên " + soTrang);
		}
	}

	public void loadListLoaiSach() {
		try {
			listLoai = theLoaiDao.getAllTheLoai();
			for (int i = 0; i < listLoai.size(); i++) {
				modelLoai.addElement(listLoai.get(i).getTenTheLoai());
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void setBtnMuon(int soLuong) {
		btnMuon.setText("Mượn (" + soLuong + ")");
	}

	public Sach timTheoMaSach(String maSach) {
		try {
			return sachDao.getSach(maSach);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Sach> timTheoTenSach(String tenSach) {
		try {
			return sachDao.getSachTheoTen(tenSach, 0, 2000000000);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Sach> timSachTheoTenTacGia(String tenTacGia) {
		try {
			return sachDao.timSachTheoTenTacGia(tenTacGia);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
