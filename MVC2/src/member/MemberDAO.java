package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private void closeAll(Object... obj) {
		try {
			for (int i = 0; i < obj.length; i++) {
				if (obj[i] instanceof ResultSet) {
					((ResultSet) obj[i]).close();
				}
				if (obj[i] instanceof PreparedStatement) {
					((PreparedStatement) obj[i]).close();
				}
				if (obj[i] instanceof Connection) {
					((Connection) obj[i]).close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int create(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into member");
		sql.append("(id,password,name,age,birth,email,img)");
		sql.append("values(?,?,?,?,?,?,?)");
		int i = 0;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getAge());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getImg());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt);
		}
		return i;
	}

	public MemberDTO read(String id) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) { 
				dto=new MemberDTO(
						           rs.getString("id"),
						           rs.getString("password"),
						           rs.getString("m_grade"),
						           rs.getString("name"),
						           rs.getInt("age"),
						           rs.getString("birth"),
						           rs.getString("email"),
						           rs.getString("img")
						         );
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}
	public boolean login(String id,String password) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=dataFactory.getConnection();
			pstmt = conn.prepareStatement("select * from member where id=? and password= ?");
			pstmt.setString(1, id);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			flag=rs.next();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs,pstmt,conn);
		}
		return flag;
	}
}
