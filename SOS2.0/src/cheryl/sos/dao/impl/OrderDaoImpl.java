package cheryl.sos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cheryl.sos.dao.OrderDao;
import cheryl.sos.domain.Order;
import cheryl.sos.utils.ConnectDB;

public class OrderDaoImpl implements OrderDao{

	@Override
	public boolean addOrder(int user_id, int merchandise_id, int num) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try{
			conn = ConnectDB.getConnection();
			try{
				String sql = "insert into ordering.orders (user_id, merchandise_id, num) values (?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, user_id);
				ps.setInt(2, merchandise_id);
				ps.setInt(3, num);
				if(ps.executeUpdate()<1){
					return false;
				}
				else{
					return true;
				}
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}finally{
			ConnectDB.release(conn, ps, rs);
		}
		
	}

	@Override
	public List<Order> listOrder(String username) {
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<Order> orders = new ArrayList();
	//当查找用户信息属性时，需要修改这里的代码；不再将DBinsert函数单独提取
				
		try{
			conn = ConnectDB.getConnection();
			try {
				String sql = "select orders.order_id, merchandise.merchandise_name,merchandise.price,orders.num, round(merchandise.price * orders.num,2) as total_price " +
						"from ordering.orders inner join ordering.usersinfo inner join ordering.merchandise " +
						"on orders.user_id = usersinfo.user_id and orders.merchandise_id = merchandise.merchandise_id where user_name=?";
				ps = conn.prepareStatement(sql);	
				ps.setString(1, username);
				rs = ps.executeQuery();
				while(rs.next()){
					Order order = new Order();
					order.setMerchandiseName(rs.getString("merchandise.merchandise_name"));
					order.setNum(rs.getInt("orders.num"));
					order.setMerchandisePrice(rs.getFloat("merchandise.price"));
					order.setTotal_price(rs.getFloat("total_price"));
					order.setOrder_id(rs.getInt("orders.order_id"));
					orders.add(order);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			return orders;
		}finally{//确保释放，否则系统很可能崩溃
			ConnectDB.release(conn, ps, rs);
		}
	}

	@Override
	public boolean removeOrder(String order_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			conn = ConnectDB.getConnection();
			try{
				String sql = "delete from ordering.orders where order_id=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, order_id);
				if(ps.executeUpdate()<1){
					return false;
				}
				else{
					return true;
				}
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}finally{
			ConnectDB.release(conn, ps, rs);
		}
		
	}

	@Override
	public List<Integer> singleOrder(String order_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList();
		try{
			conn = ConnectDB.getConnection();
			try{
				String sql = "select merchandise.merchandise_id,merchandise.remaining, orders.num from ordering.orders inner join ordering.merchandise " +
						"on orders.merchandise_id = merchandise.merchandise_id where order_id=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, order_id);
				rs = ps.executeQuery();
				while(rs.next()){
					list.add(rs.getInt("merchandise.merchandise_id"));
					list.add(rs.getInt("merchandise.remaining"));
					list.add(rs.getInt("orders.num"));
				}
				return list;
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}finally{
			ConnectDB.release(conn, ps, rs);
		}
	}

}
