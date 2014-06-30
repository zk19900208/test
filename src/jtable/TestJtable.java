package jtable;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class TestJtable {
    private JFrame frame;
    private JPanel panel;
    private JButton addButton,totalSelectedButton;
    private JTable table;
    private TableModel model;
 
 
    public TestJtable(){
        frame = new JFrame("������");
        panel = new JPanel();
        addButton = new JButton("���");
        totalSelectedButton = new JButton("ѡ�е���Ŀ");
        
        //����ť��Ӽ�����
        addButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		Object[] data = {"����","zhangsan","column2",false};
        		model.addRow(data);
        		//ǿ��ˢ�½���
        		table.updateUI();
        	}
        });
        
        //����ťtotalSelectedButton��Ӽ�����
        totalSelectedButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		int c=model.getRowCount();
        		System.out.println("��ѡ�е���Ϊ��");
        		for(int i=0;i<c;i++) {
        			if((boolean)model.getValueAt(i, 3)==true) {
        				System.out.println(i+1);
        			}
        		}
        	}
        });
        
        model = new TableModel();
        table = new JTable(model);
        
        /*
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;

        table.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer(){	 
            //(non-Javadoc)
            //�˷��������򷽷������߷���ĳһ��Ԫ�����Ⱦ��������ʾ���ݵ��齨--��ؼ���
            //����ΪJCheckBox JComboBox JTextArea ��
            //@see javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
            
            @Override
            public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
                // �������ڷ��ص���Ⱦ���
                JCheckBox ck = new JCheckBox();
                // ʹ���н�����ж�Ӧ�ĸ�ѡ��ѡ��
                ck.setSelected(isSelected);
                // ���õ�ѡbox.setSelected(hasFocus);
                // ʹ��ѡ���ڵ�Ԫ���ھ�����ʾ
                ck.setHorizontalAlignment((int) 0.5f);
                return ck;
            }
        });
        */

        /*
        String[]d = {"����","����","����"};
        JComboBox com = new JComboBox(d);
        TableColumnModel tcm = table.getColumnModel();//�õ�TableModel()
        
        tcm.getColumn(0).setCellEditor(new DefaultCellEditor(com));
        tcm.getColumn(0).setPreferredWidth(50);
        tcm.getColumn(1).setPreferredWidth(100);
        tcm.getColumn(2).setPreferredWidth(50);
        */
        
        JScrollPane pane = new JScrollPane(table);
        panel.add(addButton);
        panel.add(totalSelectedButton);
        panel.add(pane);
        frame.add(panel);
        frame.setVisible(true);
        frame.setBounds(400,200,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //model.addRow("1","zhangsan", true, "19");
        //table.updateUI();
    }
    /*
    AbstractTableModel:�еĳ��󷽷���
    getColumnCount(),getRowCount(),getValueAt()��
    JTable���÷���updateUI()ʱ���ͻ�ִ����Щ������
    updateUI()��Ѹ����еķ���ȫ��ִ��һ�� 
    @author Administrator
    */
    public class TableModel extends AbstractTableModel{
    	private Vector vector = new Vector();
    	private String[] columnNames = {"�û���","����","�Ƿ����"};
    	private String newColumn="newColumn";
    	
    	@Override
    	public int getColumnCount() {
    		// TODO Auto-generated method stub
    		System.out.println("getColumnCount()");
    		return columnNames.length+1;
    	}
    	
    	@Override
    	public int getRowCount() {
    		// TODO Auto-generated method stub
    		System.out.println("getRowCount()");
    		return vector.size();
    	}
    	
    	@Override
    	public Object getValueAt(int rowIndex, int columnIndex) {
    		// TODO Auto-generated method stub
    		//vector.get(rowIndex);�õ�����Object�Ķ���
    		System.out.println("getValueAt()");
    		//System.out.println(((Vector)vector.get(rowIndex)).get(columnIndex));
    		if (columnIndex==3) {
    			return ((Vector)vector.get(rowIndex)).get(columnIndex);
    		}
    		else {
    			return ((Vector)vector.get(rowIndex)).get(columnIndex);
    		}
    	}
    	
    	@Override
    	public String getColumnName(int columnIndex) {
    		System.out.println("getColumnName");
    		if (columnIndex==3) {
    			return newColumn;
    		} else {
    		    return columnNames[columnIndex];
    		}
    	}
 
    	
    	@Override
    	public Class getColumnClass(int columnIndex){
    		return getValueAt(0,columnIndex).getClass();
    	}
    	
    	
    	@Override
    	public boolean isCellEditable(int rowIndex, int columnIndex) {
    		return true;
    	}
 
    	@Override
    	public void setValueAt(Object value, int rowIndex, int columnIndex) {
    		//��ɾ���������
    		System.out.println("setValueAt()");
    		((Vector) vector.get(rowIndex)).remove(columnIndex);
    		((Vector) vector.get(rowIndex)).add(columnIndex,value);
    		this.fireTableCellUpdated(rowIndex, columnIndex);
    	}
    	
    	public TableModel(){
    	
    	}
    	
    	//�������������----����������������⣬���û��������е��ã�����table.updateUI()�ǲ����Զ����õ�
    	public void addRow(Object[] data){
    		int size = data.length;
    		Vector v = new Vector();
    		for(int i=0; i<size; i++){
    			v.add(data[i]);
    		}
    		vector.add(v);
    	}
    }
    
    //��������
    public static void main(String[] args){
    	new TestJtable();
    }
}
