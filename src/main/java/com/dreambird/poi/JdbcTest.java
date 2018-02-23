package com.dreambird.poi;
import java.sql.Connection;    
import java.sql.DriverManager;    
import java.sql.PreparedStatement;    
import java.sql.ResultSet;    
import java.sql.Statement;    
import java.sql.* ; 

/**
 * ���ݿ����Ӳ�����
 * @author chen.jun
 *
 */
public class JdbcTest {    
    //orclΪoracle���ݿ��е����ݿ�����localhost��ʾ���ӱ�����oracle���ݿ�     
    //1521Ϊ���ӵĶ˿ں�     
    private static String url="jdbc:oracle:thin:@localhost:1521:orcl";    
    //systemΪ��½oracle���ݿ���û���     
    private static String user="system";    
    //managerΪ�û���system������     
    private static String password="system";    
    public static Connection conn;    
    public static PreparedStatement ps;    
    public static ResultSet rs;    
    public static Statement st ;    
    //�������ݿ�ķ���     
    public void getConnection(){    
        try {    
            //��ʼ��������     
            Class.forName("oracle.jdbc.driver.OracleDriver");    
            //�������ݿ������ַ������ƣ������conn��ֵ     
            conn=DriverManager.getConnection(url, user, password);    
                
        } catch (Exception e) {    
            // TODO: handle exception     
            e.printStackTrace();    
        }    
    }    
    
    /**
     * һ���ǳ���׼������Oracle���ݿ��ʾ������
     */
    public void testOracle()
    {
        Connection con = null;// ����һ�����ݿ�����
        PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
        ResultSet result = null;// ����һ�����������
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
            System.out.println("��ʼ�����������ݿ⣡");
            String url = "jdbc:oracle:" + "thin:@localhost:1521:orcl";
            String user = "scott";// �û���,ϵͳĬ�ϵ��˻���
            String password = "tiger";// �㰲װʱѡ���õ�����
            con = DriverManager.getConnection(url, user, password);// ��ȡ����
            System.out.println("���ӳɹ���");
            String sql = "select * from emp where sal>?";// Ԥ������䣬�������������
//            Statement st = con.createStatement();
//            result = st.executeQuery(sql);
            pre = con.prepareStatement(sql);// ʵ����Ԥ�������
            pre.setInt(1, 2000);// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
            result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
            while (result.next())
                // ���������Ϊ��ʱ
                System.out.println("����:" + result.getInt("EMPNO") + "����:"
                        + result.getString("ENAME"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                // ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
                // ע��رյ�˳�����ʹ�õ����ȹر�
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("���ݿ������ѹرգ�");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
     //�����ܷ���oracle���ݿ����ӳɹ�     
     public static void main(String[] args) {    
        JdbcTest basedao=new JdbcTest();    
//        basedao.getConnection();    
//        if(conn==null){    
//            System.out.println("��oracle���ݿ�����ʧ�ܣ�");    
//        }else{    
//            System.out.println("��oracle���ݿ����ӳɹ���");    
//        }   
        
        basedao.testOracle();
     }    
}    
